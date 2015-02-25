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


package com.github.jinahya.util;


import static com.github.jinahya.util.Optional.ofNullable;
import com.github.jinahya.util.function.Supplier;


/**
 * An extended {@link SynchronizedHolder} which can hold only one non-null value
 * at any given time.
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 * @param <T> value type parameter
 */
public class AtomicHolder<T> extends SynchronizedHolder<T> {


    /**
     * Creates a new instance with specified {@code value}.
     *
     * @param value the value to hold.
     */
    public AtomicHolder(final T value) {

        super(value);
    }


    /**
     * {@inheritDoc} This method will throw an instance of
     * {@code IllegalStateException} if no non-null value has been set.
     *
     * @return the value this holder is holding.
     */
    @Override
    public synchronized T get() {

        return ofNullable(super.get())
            .orElseThrow(new Supplier<IllegalStateException>() {

                @Override
                public IllegalStateException get() {
                    return new IllegalStateException("no value set");
                }

            });
//        return ofNullable(super.get())
//            .orElseThrow(new IllegalStateException("no value set"));
    }


    /**
     * {@inheritDoc} This method will throw an instance of
     * {@code IllegalArgumentException} if specified {@code value} is not
     * {@code null} and a non-null value is already set.
     *
     * @param value the value
     */
    @Override
    public synchronized void set(final T value) {

        if (value != null && super.get() != null) {
            throw new IllegalStateException("already set");
        }

        super.set(value);
    }


}

