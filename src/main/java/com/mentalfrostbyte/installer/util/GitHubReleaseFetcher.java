package com.mentalfrostbyte.installer.util;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GitHubReleaseFetcher {

    private static final String RELEASE_API_URL = "https://api.github.com/repos/Sigma-Skidder-Team/SigmaRebase/releases/latest";
    private static final String NIGHTLY_API_URL = "https://api.github.com/repos/Sigma-Skidder-Team/SigmaRebase/releases/tags/nightly";

    public static JSONObject fetchReleaseInfo(boolean isNightly) throws Exception {
        String url = isNightly ? NIGHTLY_API_URL : RELEASE_API_URL;

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        String responseString = EntityUtils.toString(response.getEntity());

        return new JSONObject(responseString);
    }
}
