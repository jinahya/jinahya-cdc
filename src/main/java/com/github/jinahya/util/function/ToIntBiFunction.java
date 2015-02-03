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
 * @param <T>
 * @param <U>
 *
 * @see java.util.function.ToIntBiFunction
 */
public interface ToIntBiFunction<T, U> {


    /**
     *
     * @param t
     * @param u
     *
     * @return
     *
     * @see java.util.function.ToIntBiFunction#applyAsInt(java.lang.Object,
     * java.lang.Object)
     */
    int applyAsInt(T t, U u);


}

