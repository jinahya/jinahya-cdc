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
public final class BiPredicates {


    /**
     *
     * @param <T>
     * @param <U>
     * @param predicate
     * @param other
     *
     * @return
     *
     * @see java.util.function.BiPredicate#and(java.util.function.BiPredicate)
     */
    public static <T, U> BiPredicate<T, U> and(
        final BiPredicate<T, U> predicate,
        final BiPredicate<? super T, ? super U> other) {

        if (predicate == null) {
            throw new NullPointerException("null predicate");
        }

        if (other == null) {
            throw new NullPointerException("null other");
        }

        return new BiPredicate<T, U>() {

            @Override
            public boolean test(final T t, final U u) {

                return predicate.test(t, u) && other.test(t, u);
            }

        };
    }


    /**
     *
     * @param <T>
     * @param <U>
     * @param predicate
     *
     * @return
     *
     * @see java.util.function.BiPredicate#negate()
     */
    public static <T, U> BiPredicate<T, U> negate(
        final BiPredicate<T, U> predicate) {

        if (predicate == null) {
            throw new NullPointerException("null predicate");
        }

        return new BiPredicate<T, U>() {

            @Override
            public boolean test(T t, U u) {

                return !predicate.test(t, u);

            }

        };
    }


    /**
     *
     * @param <T>
     * @param <U>
     * @param predicate
     * @param other
     *
     * @return
     *
     * @see java.util.function.BiPredicate#or(java.util.function.BiPredicate)
     */
    public static <T, U> BiPredicate<T, U> or(
        final BiPredicate<T, U> predicate,
        final BiPredicate<? super T, ? super U> other) {

        if (predicate == null) {
            throw new NullPointerException("null predicate");
        }

        if (other == null) {
            throw new NullPointerException("null other");
        }

        return new BiPredicate<T, U>() {

            @Override
            public boolean test(final T t, final U u) {

                return predicate.test(t, u) || other.test(t, u);
            }

        };
    }


    private BiPredicates() {

        super();
    }


}

