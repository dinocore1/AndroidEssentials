package com.devsmart;


import android.content.res.Resources;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringUtils {

    public static boolean isEmptyString(String str) {
        return !(str != null && str.trim().length() > 0);
    }

    public static String loadRawResourceString(Resources res, int resourceId) throws IOException {
        InputStream is = res.openRawResource(resourceId);
        return loadString(is);
    }

    public static String loadAssetString(Resources res, String filename) throws IOException {
        InputStream is = res.getAssets().open(filename);
        return loadString(is);
    }

    public static String loadString(InputStream is) throws IOException {
        StringBuilder builder = new StringBuilder();
        InputStreamReader reader = new InputStreamReader(is);
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            builder.append(buf, 0, numRead);
        }
        return builder.toString();
    }
}
