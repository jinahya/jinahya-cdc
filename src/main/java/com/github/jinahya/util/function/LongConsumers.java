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
public final class LongConsumers {


    /**
     *
     * @param consumer
     * @param after
     *
     * @return
     *
     * @see
     * java.util.function.LongConsumer#andThen(java.util.function.LongConsumer)
     */
    public static LongConsumer andThen(final LongConsumer consumer,
                                       final LongConsumer after) {

        Objects.requireNonNull(consumer);
        Objects.requireNonNull(after);

        return new LongConsumer() {

            @Override
            public void accept(final long value) {

                consumer.accept(value);
                after.accept(value);
            }

        };
    }


    private LongConsumers() {

        super();
    }


}

