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
public class DoubleUnaryOperators {


    /**
     *
     * @param operator
     * @param after
     *
     * @return
     *
     * @see
     * java.util.function.DoubleUnaryOperator#andThen(java.util.function.DoubleUnaryOperator)
     */
    public static DoubleUnaryOperator andThen(
        final DoubleUnaryOperator operator,
        final DoubleUnaryOperator after) {

        Objects.requireNonNull(operator);
        Objects.requireNonNull(after);

        return new DoubleUnaryOperator() {

            @Override
            public double applyAsDouble(final double operand) {

                return after.applyAsDouble(operator.applyAsDouble(operand));
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
     * java.util.function.DoubleUnaryOperator#compose(java.util.function.DoubleUnaryOperator)
     */
    public static DoubleUnaryOperator compose(
        final DoubleUnaryOperator operator, final DoubleUnaryOperator before) {

        Objects.requireNonNull(before);
        Objects.requireNonNull(operator);

        return new DoubleUnaryOperator() {

            @Override
            public double applyAsDouble(final double operand) {

                return operator.applyAsDouble(before.applyAsDouble(operand));
            }

        };

    }


    /**
     *
     * @return
     *
     * @see java.util.function.DoubleUnaryOperator#identity()
     */
    public static DoubleUnaryOperator identity() {

        return new DoubleUnaryOperator() {

            @Override
            public double applyAsDouble(final double operand) {

                return operand;
            }

        };

    }


    private DoubleUnaryOperators() {

        super();
    }


}

