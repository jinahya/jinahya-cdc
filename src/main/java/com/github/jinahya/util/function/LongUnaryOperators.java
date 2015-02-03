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
public final class LongUnaryOperators {


    /**
     *
     * @param operator
     * @param after
     *
     * @return
     *
     * @see
     * java.util.function.LongUnaryOperator#andThen(java.util.function.LongUnaryOperator)
     */
    public static LongUnaryOperator andThen(final LongUnaryOperator operator,
                                            final LongUnaryOperator after) {

        Objects.requireNonNull(operator);
        Objects.requireNonNull(after);

        return new LongUnaryOperator() {

            @Override
            public long applyAsLong(long operand) {

                return after.applyAsLong(operator.applyAsLong(operand));
            }

        };
    }


    /**
     *
     * @param operator
     * @param before
     *
     * @return
     *
     * @see
     * java.util.function.LongUnaryOperator#compose(java.util.function.LongUnaryOperator)
     */
    public static LongUnaryOperator compose(final LongUnaryOperator operator,
                                            final LongUnaryOperator before) {

        Objects.requireNonNull(operator);
        Objects.requireNonNull(before);

        return new LongUnaryOperator() {

            @Override
            public long applyAsLong(long operand) {

                return operator.applyAsLong(before.applyAsLong(operand));
            }

        };
    }


    public static LongUnaryOperator identity(final LongUnaryOperator operator) {

        Objects.requireNonNull(operator);

        return new LongUnaryOperator() {

            @Override
            public long applyAsLong(long operand) {

                return operand;
            }

        };
    }


    private LongUnaryOperators() {

        super();
    }


}

