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


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public final class UnaryOperators {


    /**
     *
     * @param <T>
     * @param <V>
     * @param operator
     * @param after
     *
     * @return
     *
     * @see
     * java.util.function.UnaryOperator#andThen(java.util.function.Function)
     */
    public static <T, V> Function<T, V> andThen(
        final UnaryOperator<T> operator,
        final Function<? super T, ? extends V> after) {

        return Functions.andThen(operator, after);
    }


    public static <V> UnaryOperator<V> andThen(final UnaryOperator<V> operator,
                                               final UnaryOperator<V> after) {

        final Function<V, V> chained = Functions.andThen(operator, after);

        return new UnaryOperator<V>() {

            @Override
            public V apply(final V v) {

                return chained.apply(v);
            }

        };
    }


    /**
     *
     * @param <V>
     * @param <R>
     * @param operator
     * @param before
     *
     * @return
     *
     * @see
     * java.util.function.UnaryOperator#compose(java.util.function.Function)
     */
    public static <V, R> Function<V, R> compose(
        final UnaryOperator<R> operator,
        final Function<? super V, ? extends R> before) {

        return Functions.compose(operator, before);
    }


    public static <R> UnaryOperator<R> compose(final UnaryOperator<R> operator,
                                               final UnaryOperator<R> before) {

        final Function<R, R> composed = Functions.compose(operator, before);

        return new UnaryOperator<R>() {

            @Override
            public R apply(final R r) {

                return composed.apply(r);
            }

        };
    }


    /**
     *
     * @param <T>
     *
     * @return
     *
     * @see java.util.function.UnaryOperator#identity()
     */
    public static <T> UnaryOperator<T> identity() {

        return new UnaryOperator<T>() {

            @Override
            public T apply(final T t) {

                return t;
            }

        };
    }


    private UnaryOperators() {

        super();
    }


}

