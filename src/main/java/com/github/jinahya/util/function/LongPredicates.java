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
public final class LongPredicates {


    /**
     *
     * @param predicate
     * @param other
     *
     * @return
     *
     * @see
     * java.util.function.LongPredicate#and(java.util.function.LongPredicate)
     */
    public static LongPredicate and(final LongPredicate predicate,
                                    final LongPredicate other) {

        Objects.requireNonNull(predicate);
        Objects.requireNonNull(other);

        return new LongPredicate() {

            @Override
            public boolean test(final long value) {

                return predicate.test(value) && other.test(value);
            }

        };
    }


    /**
     *
     * @param predicate
     *
     * @return
     *
     * @see java.util.function.LongPredicate#negate()
     */
    public static LongPredicate negate(final LongPredicate predicate) {

        Objects.requireNonNull(predicate);

        return new LongPredicate() {

            @Override
            public boolean test(final long value) {

                return !predicate.test(value);
            }

        };
    }


    /**
     *
     * @param predicate
     * @param other
     *
     * @return
     *
     * @see
     * java.util.function.LongPredicate#or(java.util.function.LongPredicate)
     */
    public static LongPredicate or(final LongPredicate predicate,
                                   final LongPredicate other) {

        Objects.requireNonNull(predicate);
        Objects.requireNonNull(other);

        return new LongPredicate() {

            @Override
            public boolean test(final long value) {

                return predicate.test(value) || other.test(value);
            }

        };
    }


    private LongPredicates() {

        super();
    }


}

