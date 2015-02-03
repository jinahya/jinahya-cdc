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


import org.testng.annotations.Test;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public class UnaryOperatorsTest {


    @Test
    public static void andThen() {

        final UnaryOperator<Object> operator = o -> null;
        final Function<Object, Object> after = o -> null;

        final Function<Object, Object> chained
            = UnaryOperators.andThen(operator, after);

        final Object applied = chained.apply(null);
    }


    @Test
    public static void andThenUnaryOperator() {

        final UnaryOperator<Object> operator = o -> null;
        final UnaryOperator<Object> after = o -> null;

        final UnaryOperator<Object> chained
            = UnaryOperators.andThen(operator, after);

        chained.apply(null);
    }


    @Test
    public static void compose() {

        final UnaryOperator<Object> operator = o -> null;
        final UnaryOperator<Object> after = o -> null;

        final Function<Object, Object> composed
            = UnaryOperators.compose(operator, after);

        final Object applied = composed.apply(null);
    }


    @Test
    public static void composeUnaryOperator() {

        final UnaryOperator<Object> operator = o -> null;
        final UnaryOperator<Object> after = o -> null;

        final UnaryOperator<Object> composed
            = UnaryOperators.compose(operator, after);

        final Object applied = composed.apply(null);
    }


}

