package com.wpi.common;

/**
 * Created by Wiesław Piasecki on 2015-01-10.
 */
public class StreamUtils {
    public static String convertStreamToString(java.io.InputStream is) {
        java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }
}
