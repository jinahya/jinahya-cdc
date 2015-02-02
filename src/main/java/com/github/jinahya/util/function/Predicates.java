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


    public static final Predicate<?> PASS = new Predicate<Object>() {

        @Override
        public boolean test(final Object t) {

            return true;
        }

    };


    public static final Predicate<?> FAIL = new Predicate<Object>() {

        @Override
        public boolean test(final Object t) {

            return false;
        }

    };


    public static <T> Predicate<T> pass() {

        return new Predicate<T>() {

            @Override
            public boolean test(final T t) {

                return true;
            }

        };
    }


    public static <T> Predicate<T> fail() {

        return new Predicate<T>() {

            @Override
            public boolean test(final T t) {

                return false;
            }

        };
    }


    public static <T> Predicate<T> and(final Predicate<T> p,
                                       final Predicate<? super T> other) {

        return new Predicate<T>() {

            public boolean test(final T t) {

                return p.test(t) && other.test(t);
            }

        };
    }


    public static <T> Predicate<T> isEqual(final Object targetRef) {

        return new Predicate<T>() {

            public boolean test(T t) {

                return targetRef == null ? t == null : targetRef.equals(t);
            }

        };
    }


    public static <T> Predicate<T> negate(final Predicate<T> p) {

        return new Predicate<T>() {

            public boolean test(final T t) {

                return !p.test(t);
            }

        };
    }


    public static <T> Predicate<T> or(final Predicate<T> p,
                                      final Predicate<? super T> other) {

        return new Predicate<T>() {

            public boolean test(final T t) {

                return p.test(t) || other.test(t);
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

