package com.mentalfrostbyte.installer;

import com.mentalfrostbyte.installer.util.GitHubReleaseFetcher;
import com.mentalfrostbyte.installer.util.MinecraftVersionUpdater;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.event.*;

public class MinecraftLauncherGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sigma Rebase Installer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 220);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel label = new JLabel("Select SigmaRebase Version:");
        label.setBounds(10, 20, 200, 25);
        panel.add(label);

        JRadioButton nightlyButton = new JRadioButton("Nightly Build (probably more stable)");
        nightlyButton.setBounds(10, 50, 150, 25);
        panel.add(nightlyButton);

        JRadioButton releaseButton = new JRadioButton("Release Candidate (stale)");
        releaseButton.setBounds(10, 80, 150, 25);
        panel.add(releaseButton);

        ButtonGroup group = new ButtonGroup();
        group.add(nightlyButton);
        group.add(releaseButton);

        JButton startButton = new JButton("Start Download");
        startButton.setBounds(10, 120, 150, 25);
        panel.add(startButton);

        JProgressBar progressBar = new JProgressBar();
        progressBar.setBounds(10, 150, 350, 25);
        progressBar.setStringPainted(true);
        panel.add(progressBar);

        startButton.addActionListener(e -> {
            boolean isNightly = nightlyButton.isSelected();
            startButton.setEnabled(false);
            downloadAndSetup(isNightly, progressBar);
        });
    }

    private static void downloadAndSetup(boolean isNightly, JProgressBar progressBar) {
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                JSONObject releaseInfo = GitHubReleaseFetcher.fetchReleaseInfo(isNightly);
                String jarUrl = releaseInfo.getJSONArray("assets").getJSONObject(0).getString("browser_download_url");
                String jsonUrl = releaseInfo.getJSONArray("assets").getJSONObject(1).getString("browser_download_url");

                String versionName = isNightly ? "SigmaRebase-Nightly" : "SigmaRebase-Release";
                MinecraftVersionUpdater.setupVersion(jarUrl, jsonUrl, versionName, progressBar);
                return null;
            }

            @Override
            protected void done() {
                JOptionPane.showMessageDialog(null, "Installation complete!");
                System.exit(0);
            }
        };
        worker.execute();
    }
}
