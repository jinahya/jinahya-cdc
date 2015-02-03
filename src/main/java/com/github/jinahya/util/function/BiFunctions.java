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
public final class BiFunctions {


    /**
     *
     * @param <T>
     * @param <U>
     * @param <R>
     * @param <V>
     * @param function
     * @param after
     *
     * @return
     *
     * @see java.util.function.BiFunction#andThen(java.util.function.Function)
     */
    public static <T, U, R, V> BiFunction<T, U, V> andThen(
        final BiFunction<T, U, R> function,
        final Function<? super R, ? extends V> after) {

        if (function == null) {
            throw new NullPointerException("null function");
        }

        if (after == null) {
            throw new NullPointerException("null after");
        }

        return new BiFunction<T, U, V>() {

            @Override
            public V apply(final T t, final U u) {

                return after.apply(function.apply(t, u));
            }

        };
    }


    private BiFunctions() {

        super();
    }


}

