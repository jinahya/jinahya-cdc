/*
 * Copyright 2015 Jin Kwon &lt;jinahya_at_gmail.com&gt;.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.github.jinahya.util.function;


import java.util.Collection;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public final class Consumers {


    public static <T> Consumer<T> andThen(final Consumer<T> before,
                                          final Consumer<? super T> after) {

        return new Consumer<T>() {


            @Override
            public void accept(final T t) {
                before.accept(t);
                after.accept(t);
            }


        };
    }


    public static <T> Consumer<T> collecting(
        final Collection<? super T> collection) {

        return new Consumer<T>() {


            @Override
            public void accept(final T t) {

                collection.add(t);
            }


        };

    }


    public static <T, U> Consumer<T> of(final Predicate<? super T> predicate,
                                        final Function<T, U> function,
                                        final Consumer<? super U> consumer) {

        return new Consumer<T>() {


            @Override
            public void accept(final T t) {

                if (predicate.test(t)) {
                    consumer.accept(function.apply(t));
                }
            }


        };
    }


    public static <T, U> Consumer<T> of(final Function<T, U> function,
                                        final Consumer<? super U> consumer) {

        return of(Predicates.pass(), function, consumer);
    }


    public static <T> Consumer<T> of(final Predicate<? super T> predicate,
                                     final Consumer<? super T> consumer) {

        return of(predicate, Functions.<T>identity(), consumer);
    }


    private Consumers() {

        super();
    }


}

