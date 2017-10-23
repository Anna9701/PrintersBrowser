package com.annawyrwal.paintersbrowser;

public class Global {
    private static String path;

    public static void setPath(String p) {
        path = p;
        if (!path.endsWith("/"))
            path += "/";
    }

    public static String getPath() {
        return path;
    }
}
