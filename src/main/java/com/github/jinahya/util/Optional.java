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


import com.github.jinahya.util.function.Consumer;
import com.github.jinahya.util.function.Function;
import com.github.jinahya.util.function.Predicate;
import com.github.jinahya.util.function.Supplier;
import java.util.NoSuchElementException;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 * @param <T> value type parameter
 */
public final class Optional<T> {


    /**
     * Returns an empty Optional instance. No value is present for this
     * Optional.
     *
     * @param <T> Type of the non-existent value
     *
     * @return an empty Optional
     */
    public static <T> Optional<T> empty() {

        return new Optional<T>(null);
    }


    /**
     * Returns an Optional with the specified present non-null value.
     *
     * @param <T> the class of the value
     * @param value the value to be present, which must be non-null
     *
     * @return an Optional with the value present
     *
     * @throws NullPointerException if value is null
     */
    public static <T> Optional<T> of(final T value) {

        if (value == null) {
            throw new NullPointerException("null value");
        }

        return new Optional<T>(value);
    }


    /**
     * Returns an Optional describing the specified value, if non-null,
     * otherwise returns an empty Optional.
     *
     * @param <T> the class of the value
     * @param value the possibly-null value to describe
     *
     * @return an Optional with a present value if the specified value is
     * non-null, otherwise an empty Optional
     */
    public static <T> Optional<T> ofNullable(final T value) {

        return new Optional<T>(value);
    }


    private Optional(final T value) {

        super();

        this.value = value;
    }


    @Override
    public boolean equals(final Object obj) {

        if (!Optional.class.isInstance(obj)) {
            return false;
        }

        final Optional<?> casted = (Optional<?>) obj;

        if (isPresent() && casted.isPresent()) {
            return value.equals(casted.value);
        }

        return false;
    }


    @Override
    public int hashCode() {

        return isPresent() ? value.hashCode() : 0;
    }


    public Optional<T> filter(final Predicate<? super T> predicate) {

        if (isPresent() && predicate.test(value)) {
            return of(value);
        }

        return empty();
    }


    public <U> Optional<U> flatMap(
        final Function<? super T, Optional<U>> mapper) {

        if (isPresent()) {
            return mapper.apply(value);
        }

        return empty();
    }


    public T get() {

        if (value == null) {
            throw new NoSuchElementException("empty");
        }

        return value;
    }


    public void ifPresent(final Consumer<? super T> consumer) {

        if (isPresent()) {
            consumer.accept(value);
        }
    }


    public boolean isPresent() {

        return value != null;
    }


    public <U> Optional<U> map(final Function<? super T, ? extends U> mapper) {

        if (isPresent()) {
            return ofNullable(mapper.apply(value));
        }

        return empty();
    }


    public T orElse(final T other) {

        return isPresent() ? value : other;
    }


    public T orElseGet(final Supplier<? extends T> other) {

        return isPresent() ? value : other.get();
    }


    public <X extends Throwable> T orElseThrow(
        final Supplier<? extends X> exceptionSupplier) throws X {

        if (isPresent()) {
            return value;
        }

        throw exceptionSupplier.get();
    }


    @Override
    public String toString() {

        return super.toString() + "(" + String.valueOf(value) + ")";
    }


    private final T value;


}

