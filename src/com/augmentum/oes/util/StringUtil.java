package com.augmentum.oes.util;

public class StringUtil {

    public static boolean isEmpty(String string) {

        if ("".equals(string) || string == null) {
            return true;
        } else {
            return false;
        }
    }

    public static String toString(String string) {
        if (string == null) {
            string = "";
        }
        return string;
    }
}
