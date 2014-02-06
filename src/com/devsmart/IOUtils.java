package com.devsmart;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtils {

    public interface IOProgress {
        void onProgress(int bytesWritten);
    }

    public static final int DEFAULT_BUFFER_SIZE = 4096;

    public static void pump(InputStream in, OutputStream out) throws IOException {
        pump(in, out, DEFAULT_BUFFER_SIZE, null, true, true);
    }

    public static void pump(InputStream in, OutputStream out,
                            boolean autoCloseInput, boolean autoCloseOutput) throws IOException {
        pump(in, out, DEFAULT_BUFFER_SIZE, null, autoCloseInput, autoCloseOutput);
    }

    public static void pump(InputStream in, OutputStream out, int bufSize, IOProgress progress,
                            boolean autoCloseInput, boolean autoCloseOutput) throws IOException {

        byte[] buffer = new byte[bufSize];
        int bytesRead;

        try {
            while((bytesRead = in.read(buffer, 0, bufSize)) > 0){
                out.write(buffer, 0, bytesRead);
                if(progress != null){
                    progress.onProgress(bytesRead);
                }
            }
        } finally {
            if(autoCloseInput){
                in.close();
            }
            if(autoCloseOutput){
                out.close();
            }
        }
    }

}
