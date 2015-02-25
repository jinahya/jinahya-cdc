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
 *
 * @see java.util.Optional
 */
public final class Optional<T> {


    /**
     *
     * @param <T>
     *
     * @return
     *
     * @see java.util.Optional#empty()
     */
    public static <T> Optional<T> empty() {

        return new Optional<T>(null);
    }


    /**
     *
     * @param <T>
     * @param value
     *
     * @return
     *
     * @see java.util.Optional#of(java.lang.Object)
     */
    public static <T> Optional<T> of(final T value) {

        if (value == null) {
            throw new NullPointerException("null value");
        }

        return new Optional<T>(value);
    }


    /**
     *
     * @param <T>
     * @param value
     *
     * @return
     *
     * @see java.util.Optional#ofNullable(java.lang.Object)
     */
    public static <T> Optional<T> ofNullable(final T value) {

        return new Optional<T>(value);
    }


    private Optional(final T value) {

        super();

        this.value = value;
    }


    /**
     *
     * @param obj
     *
     * @return
     *
     * @see java.util.Optional#equals(java.lang.Object)
     */
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


    /**
     *
     * @return
     *
     * @see java.util.Optional#hashCode()
     */
    @Override
    public int hashCode() {

        return isPresent() ? value.hashCode() : 0;
    }


    /**
     *
     * @param predicate
     *
     * @return
     *
     * @see java.util.Optional#filter(java.util.function.Predicate)
     */
    public Optional<T> filter(final Predicate<? super T> predicate) {

        if (isPresent() && predicate.test(value)) {
            return of(value);
        }

        return empty();
    }


    /**
     *
     * @param <U>
     * @param mapper
     *
     * @return
     *
     * @see java.util.Optional#flatMap(java.util.function.Function)
     */
    public <U> Optional<U> flatMap(
        final Function<? super T, Optional<U>> mapper) {

        if (isPresent()) {
            return mapper.apply(value);
        }

        return empty();
    }


    /**
     *
     * @return
     *
     * @see java.util.Optional#get()
     */
    public T get() {

        if (value == null) {
            throw new NoSuchElementException("empty");
        }

        return value;
    }


    /**
     *
     * @param consumer
     *
     * @see java.util.Optional#ifPresent(java.util.function.Consumer)
     */
    public void ifPresent(final Consumer<? super T> consumer) {

        if (isPresent()) {
            consumer.accept(value);
        }
    }


    /**
     *
     * @return
     *
     * @see java.util.Optional#isPresent()
     */
    public boolean isPresent() {

        return value != null;
    }


    /**
     *
     * @param <U>
     * @param mapper
     *
     * @return
     *
     * @see java.util.Optional#map(java.util.function.Function)
     */
    public <U> Optional<U> map(final Function<? super T, ? extends U> mapper) {

        if (isPresent()) {
            return ofNullable(mapper.apply(value));
        }

        return empty();
    }


    /**
     *
     * @param other
     *
     * @return
     *
     * @see java.util.Optional#orElse(java.lang.Object)
     */
    public T orElse(final T other) {

        return isPresent() ? value : other;
    }


    /**
     *
     * @param other
     *
     * @return
     *
     * @see java.util.Optional#orElseGet(java.util.function.Supplier)
     */
    public T orElseGet(final Supplier<? extends T> other) {

        return isPresent() ? value : other.get();
    }


    /**
     *
     * @param <X>
     * @param exceptionSupplier
     *
     * @return
     *
     * @throws X
     *
     * @see java.util.Optional#orElseThrow(java.util.function.Supplier)
     */
    public <X extends Throwable> T orElseThrow(
        final Supplier<? extends X> exceptionSupplier) throws X {

        if (isPresent()) {
            return value;
        }

        throw exceptionSupplier.get();
    }


    /**
     *
     * @param <X>
     * @param throwable
     *
     * @return
     *
     * @throws X
     * @deprecated
     */
    @Deprecated
    public <X extends Throwable> T orElseThrow(final X throwable) throws X {

        return orElseThrow(new Supplier<X>() {

            @Override
            public X get() {

                return throwable;
            }

        });
    }


//    /**
//     *
//     * @param <X>
//     * @param exception
//     *
//     * @return
//     *
//     * @throws X
//     *
//     * @see #orElseThrow(com.github.jinahya.util.function.Supplier)
//     */
//    public <X extends Throwable> T orElseThrow(final X exception) throws X {
//
//        return orElseThrow(new Supplier<X>() {
//
//            @Override
//            public X get() {
//
//                return exception;
//            }
//
//        });
//    }
    /**
     *
     * @return
     *
     * @see java.util.Optional#toString()
     */
    @Override
    public String toString() {

        return value != null ? "Optional[" + value + "]" : "Optional.empty";
    }


    private final T value;


}

