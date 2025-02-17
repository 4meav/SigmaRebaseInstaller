package com.mentalfrostbyte.installer.util;

import java.io.*;
import java.net.*;
import javax.swing.*;

public class FileDownloader {

    public static void downloadFile(String fileUrl, String destinationPath, JProgressBar progressBar) {
        try (InputStream in = new URL(fileUrl).openStream();
             FileOutputStream out = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytesRead = 0;
            URL url = new URL(fileUrl);
            long fileSize = url.openConnection().getContentLengthLong();

            while ((bytesRead = in.read(buffer)) != -1) {
                totalBytesRead += bytesRead;
                out.write(buffer, 0, bytesRead);
                int progress = (int) (totalBytesRead * 100 / fileSize);
                progressBar.setValue(progress);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
