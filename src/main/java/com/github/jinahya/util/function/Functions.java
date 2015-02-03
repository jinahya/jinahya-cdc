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


import com.github.jinahya.util.Objects;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public final class Functions {


    /**
     *
     * @param <T>
     * @param <R>
     * @param <V>
     * @param function
     * @param after
     *
     * @return
     *
     * @see java.util.function.Function#andThen(java.util.function.Function)
     */
    public static <T, R, V> Function<T, V> andThen(
        final Function<T, R> function,
        final Function<? super R, ? extends V> after) {

        Objects.requireNonNull(function);
        Objects.requireNonNull(after);

        return new Function<T, V>() {

            @Override
            public V apply(final T t) {
                return after.apply(function.apply(t));
            }

        };
    }


    /**
     *
     * @param <V>
     * @param <T>
     * @param <R>
     * @param function
     * @param before
     *
     * @return
     *
     * @see java.util.function.Function#compose(java.util.function.Function)
     */
    public static <V, T, R> Function<V, R> compose(
        final Function<T, R> function,
        final Function<? super V, ? extends T> before) {

        Objects.requireNonNull(function);
        Objects.requireNonNull(before);

        return new Function<V, R>() {

            @Override
            public R apply(final V v) {

                return function.apply(before.apply(v));
            }

        };
    }


    /**
     *
     * @param <T>
     *
     * @return
     *
     * @see java.util.function.Function#identity()
     */
    public static <T> Function<T, T> identity() {

        return new Function<T, T>() {

            @Override
            public T apply(final T t) {

                return t;
            }

        };
    }


    public static <T, U> Function<T, U> casting(final Class<U> type) {

        if (type == null) {
            throw new NullPointerException("null type");
        }

        return new Function<T, U>() {

            @Override
            public U apply(final T t) {

                return type.cast(t);
            }

        };
    }


    private Functions() {

        super();
    }


}

