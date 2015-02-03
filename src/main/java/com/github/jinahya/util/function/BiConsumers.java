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
public class BiConsumers {


    /**
     *
     * @param <T>
     * @param <U>
     * @param consumer
     * @param after
     *
     * @return
     *
     * @see java.util.function.BiConsumer#andThen(java.util.function.BiConsumer)
     */
    public static <T, U> BiConsumer<T, U> andThen(
        final BiConsumer<T, U> consumer,
        final BiConsumer<? super T, ? super U> after) {

        if (consumer == null) {
            throw new NullPointerException("null consumer");
        }

        if (after == null) {
            throw new NullPointerException("null after");
        }

        return new BiConsumer<T, U>() {

            @Override
            public void accept(final T t, final U u) {

                consumer.accept(t, u);
                after.accept(t, u);
            }

        };
    }


    private BiConsumers() {

        super();
    }


}

