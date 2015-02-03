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
public final class Predicates {


    /**
     * A constant always matches.
     */
    public static final Predicate<?> MATCHES = new Predicate<Object>() {

        @Override
        public boolean test(final Object t) {

            return true;
        }

    };


    /**
     * Creates a predicate which always matches regardless of input.
     *
     * @param <T> the type of the input to the predicate
     *
     * @return a new instance
     */
    public static <T> Predicate<T> matches() {

        return new Predicate<T>() {

            @Override
            public boolean test(final T t) {

                return true;
            }

        };
    }


    /**
     *
     * @param <T>
     * @param predicate
     * @param other
     *
     * @return
     *
     * @see java.util.function.Predicate#and(java.util.function.Predicate)
     */
    public static <T> Predicate<T> and(final Predicate<T> predicate,
                                       final Predicate<? super T> other) {

        if (predicate == null) {
            throw new NullPointerException("null predicate");
        }

        if (other == null) {
            throw new NullPointerException("null other");
        }

        return new Predicate<T>() {

            public boolean test(final T t) {

                return predicate.test(t) && other.test(t);
            }

        };
    }


    /**
     *
     * @param <T>
     * @param targetRef
     *
     * @return
     *
     * @see java.util.function.Predicate#isEqual(java.lang.Object)
     */
    public static <T> Predicate<T> isEqual(final Object targetRef) {

        return new Predicate<T>() {

            public boolean test(T t) {

                return targetRef == null ? t == null : targetRef.equals(t);
            }

        };
    }


    /**
     *
     * @param <T>
     * @param predicate
     *
     * @return
     *
     * @see java.util.function.Predicate#negate()
     */
    public static <T> Predicate<T> negate(final Predicate<T> predicate) {

        if (predicate == null) {
            throw new NullPointerException("null predicate");
        }

        return new Predicate<T>() {

            public boolean test(final T t) {

                return !predicate.test(t);
            }

        };
    }


    /**
     *
     * @param <T>
     * @param predicate
     * @param other
     *
     * @return
     *
     * @see java.util.function.Predicate#or(java.util.function.Predicate)
     */
    public static <T> Predicate<T> or(final Predicate<T> predicate,
                                      final Predicate<? super T> other) {

        if (predicate == null) {
            throw new NullPointerException("null predicate");
        }

        if (other == null) {
            throw new NullPointerException("null other");
        }

        return new Predicate<T>() {

            public boolean test(final T t) {

                return predicate.test(t) || other.test(t);
            }

        };
    }


    public static <T> Predicate<T> checkingInstanceOf(final Class<?> type) {

        return new Predicate<T>() {

            @Override
            public boolean test(final T t) {

                return type.isInstance(t);
            }

        };
    }


    private Predicates() {

        super();
    }


}

