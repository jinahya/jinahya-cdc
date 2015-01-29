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


import com.github.jinahya.util.function.Supplier;
import java.util.Comparator;


/**
 * An alternative implementation of {@link java.util.Objects}.
 * <p/>
 * Following methods are not implemented.
 * <ul>
 * <li>{@link java.util.Objects#deepEquals(java.lang.Object, java.lang.Object)}</li>
 * </ul>
 *
 * @author Jin Kwon &lt;jinahya_at_gmail.com&gt;
 */
public final class Objects {


    public static <T> int compare(final T a, final T b,
                                  final Comparator<? super T> c) {

        return a == b ? 0 : c.compare(a, b);
    }


//    public static boolean deepEquals(final Object a, final Object b) {
//
//        if (a == b) {
//            return true;
//        } else if (a == null || b == null) {
//            return false;
//        } else {
//            boolean equals;
//            if (a instanceof Object[] && b instanceof Object[]) {
//                equals = deepEquals((Object[]) a, (Object[]) b);
//            } else if (a instanceof byte[] && b instanceof byte[]) {
//                equals = equals((byte[]) a, (byte[]) b);
//            } else if (a instanceof short[] && b instanceof short[]) {
//                equals = equals((short[]) a, (short[]) b);
//            } else if (a instanceof int[] && b instanceof int[]) {
//                equals = equals((int[]) a, (int[]) b);
//            } else if (a instanceof long[] && b instanceof long[]) {
//                equals = equals((long[]) a, (long[]) b);
//            } else if (a instanceof char[] && b instanceof char[]) {
//                equals = equals((char[]) a, (char[]) b);
//            } else if (a instanceof float[] && b instanceof float[]) {
//                equals = equals((float[]) a, (float[]) b);
//            } else if (a instanceof double[] && b instanceof double[]) {
//                equals = equals((double[]) a, (double[]) b);
//            } else if (a instanceof boolean[] && b instanceof boolean[]) {
//                equals = equals((boolean[]) a, (boolean[]) b);
//            } else {
//                equals = a.equals(b);
//            }
//            return equals;
//        }
//    }


    public static boolean equals(final Object a, final Object b) {

        return a == null ? b == null : a.equals(b);
    }


    public static int hash(final Object... values) {

        if (values == null) {
            return 0;
        }

        int result = 1;

        for (final Object value : values) {
            result = 31 * result + (value == null ? 0 : value.hashCode());
        }

        return result;
    }


    public static int hashCode(final Object o) {

        return o != null ? o.hashCode() : 0;
    }


    public static boolean isNull(final Object obj) {

        return obj == null;
    }


    public static boolean nonNull(final Object obj) {

        return !isNull(obj);
    }


    public static <T> T requireNonNull(final T obj) {

        return requireNonNull(obj, "null");
    }


    public static <T> T requireNonNull(final T obj, final String message) {

        if (obj == null) {
            throw new NullPointerException(message);
        }

        return obj;
    }


    public static <T> T requireNonNull(final T obj,
                                       final Supplier<String> messageSupplier) {

        if (obj == null) {
            throw new NullPointerException(messageSupplier.get());
        }

        return obj;
    }


    public static String toString(final Object o) {

        return toString(o, "null");
    }


    public static String toString(final Object o, final String nullDefault) {

        return o == null ? nullDefault : o.toString();
    }


    private Objects() {

        super();
    }


}

