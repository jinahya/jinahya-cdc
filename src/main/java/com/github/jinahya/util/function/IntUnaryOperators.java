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
public final class IntUnaryOperators {


    /**
     *
     * @param operator
     * @param after
     *
     * @return
     *
     * @see
     * java.util.function.IntUnaryOperator#andThen(java.util.function.IntUnaryOperator)
     */
    public static IntUnaryOperator andThen(final IntUnaryOperator operator,
                                           final IntUnaryOperator after) {

        Objects.requireNonNull(operator);
        Objects.requireNonNull(after);

        return new IntUnaryOperator() {

            @Override
            public int applyAsInt(final int operand) {

                return after.applyAsInt(operator.applyAsInt(operand));
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
     * java.util.function.IntUnaryOperator#compose(java.util.function.IntUnaryOperator)
     */
    public static IntUnaryOperator compose(final IntUnaryOperator operator,
                                           final IntUnaryOperator before) {

        Objects.requireNonNull(operator);
        Objects.requireNonNull(before);

        return new IntUnaryOperator() {

            @Override
            public int applyAsInt(final int operand) {

                return operator.applyAsInt(before.applyAsInt(operand));
            }

        };
    }


    /**
     *
     * @return
     *
     * @see java.util.function.IntUnaryOperator#identity()
     */
    public static IntUnaryOperator identity() {

        return new IntUnaryOperator() {

            @Override
            public int applyAsInt(final int operand) {

                return operand;
            }

        };
    }


    private IntUnaryOperators() {

        super();
    }


}

