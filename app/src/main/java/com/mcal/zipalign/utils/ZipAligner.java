package com.mcal.zipalign.utils;

public class ZipAligner {
    static {
        System.loadLibrary("zipalign");
    }

    public static native boolean ZipAlign(String zip, String destZip);
    public static native boolean isZipAligned(String zip);
}
