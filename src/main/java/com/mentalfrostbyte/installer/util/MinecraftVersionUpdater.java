package com.mentalfrostbyte.installer.util;

import org.json.JSONObject;

import javax.swing.*;
import java.io.*;
import java.nio.file.*;

public class MinecraftVersionUpdater {

    private static final String MINECRAFT_DIR = System.getProperty("user.home") + "/.minecraft";

    public static void setupVersion(String jarUrl, String jsonUrl, String versionName, JProgressBar progressBar) {
        try {
            File sigmaRebaseDir = new File(MINECRAFT_DIR + "/versions/" + versionName);
            if (!sigmaRebaseDir.exists()) {
                sigmaRebaseDir.mkdirs();
            }


            FileDownloader.downloadFile(jarUrl, sigmaRebaseDir + "/" + versionName + ".jar", progressBar);
            FileDownloader.downloadFile(jsonUrl, sigmaRebaseDir + "/" + versionName + ".json", progressBar);

            createMinecraftProfile(versionName);

            progressBar.setValue(100);
            System.out.println("Version setup complete!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createMinecraftProfile(String versionName) {
        String profileJsonPath = MINECRAFT_DIR + "/launcher_profiles.json";
        File profileFile = new File(profileJsonPath);

        try {
            JSONObject profilesJson = new JSONObject();
            if (profileFile.exists()) {
                profilesJson = new JSONObject(new String(Files.readAllBytes(profileFile.toPath())));
            }

            JSONObject newProfile = new JSONObject();
            newProfile.put("name", versionName);
            newProfile.put("lastVersionId", versionName);

            JSONObject version = new JSONObject();
            version.put("id", versionName);
            version.put("inheritsFrom", "1.16.4");
            version.put("type", "custom");

            profilesJson.put("profiles", new JSONObject().put(versionName, newProfile));

            Files.write(profileFile.toPath(), profilesJson.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}