package org.kpe;

public class StringUtilsWithState {

    static boolean lastResult;
    public static boolean isStringLong(String input) {
        boolean result = input.length() > 5;
        lastResult = result;
        return result;
    }
}
