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


import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;


/**
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public class AtomicHolderTest {


    @Test(expectedExceptions = {IllegalStateException.class})
    public void get_null_value() {

        new AtomicHolder<>(null).get();
    }


    @Test
    public void get() {

        final Object expected = new Object();
        final Object actual = new AtomicHolder<>(expected).get();

        assertEquals(actual, expected);
    }


    @Test(expectedExceptions = {IllegalStateException.class})
    public void set_non_null_twice() {

        final AtomicHolder<Object> holder = new AtomicHolder<>(null);

        holder.set(new Object());
        holder.set(new Object());
    }


    @Test
    public void set_null_twice() {

        final AtomicHolder<Object> holder = new AtomicHolder<>(null);

        holder.set(null);
        holder.set(null);
    }


    @Test
    public void set_start_with_null() {

        final AtomicHolder<Object> holder = new AtomicHolder<>(null);

        holder.set(new Object());
        holder.set(null);

        holder.set(new Object());
        holder.set(null);
    }


    @Test
    public void set_start_with_non_null() {

        final AtomicHolder<Object> holder = new AtomicHolder<>(new Object());

        holder.set(null);
        holder.set(new Object());

        holder.set(null);
        holder.set(new Object());
    }


}

