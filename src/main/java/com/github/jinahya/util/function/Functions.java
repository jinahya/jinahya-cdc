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
public final class Functions {


    public static <T, R, V> Function<T, V> andThen(
        final Function<T, R> f, final Function<? super R, ? extends V> after) {

        return new Function<T, V>() {


            @Override
            public V apply(final T t) {
                return after.apply(f.apply(t));
            }


        };
    }


    public static <V, T, R> Function<V, R> compose(
        final Function<? super V, ? extends T> before, final Function<T, R> f) {

        return new Function<V, R>() {


            public R apply(V v) {

                return f.apply(before.apply(v));
            }


        };
    }


    public static <T> Function<T, T> identity() {

        return new Function<T, T>() {


            public T apply(final T t) {

                return t;
            }


        };
    }


    private Functions() {

        super();
    }


}

