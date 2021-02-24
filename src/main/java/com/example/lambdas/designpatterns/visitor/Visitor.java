package com.example.lambdas.designpatterns.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Visitor<R> {

    R visit(Object o);

    // store lambdas in a registry
    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        consumer.accept((type, function) -> registry.put(type, function));
        System.out.println("Registry: " + registry.keySet());
        return  (Object o) -> registry.get(o.getClass()).apply(o);
    }

    static <R> X<R> forType(Class<?> type) {
        // implementation for supplier
        return () -> type;
    }

    // use partial application through these 3 interfaces
    interface X<R> {

        Class<?> type ();

        default Y<R> execute(Function<Object, R> function) {
            return visitorBuilder -> visitorBuilder.register(type(), function);
        }
    }

    interface Y<R> extends Consumer<VisitorBuilder<R>> {
        default Z<R> forType(Class<?> type) {
            return index -> index == 0 ? this : type;
        }

        default Y<R> andThen(Y<R> after) { // allow chaining
            return t -> {
                this.accept(t);
                after.accept(t);
            };
        }
    }

    interface Z<R> {

        Object get(int index);

        default Class<?> type(){
            return (Class<?>) get(1);
        }

        default Y<R> previousConsumer(){
            return (Y<R>) get(0);
        }

        default Y<R> execute(Function<Object, R> function) {
            return previousConsumer().andThen(visitorBuilder -> visitorBuilder.register(type(), function));
        }
    }
}
