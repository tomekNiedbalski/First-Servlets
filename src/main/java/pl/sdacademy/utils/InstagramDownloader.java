package pl.sdacademy.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InstagramDownloader {

    public List<String> getUrls(String instagramAccount, int numberOfPhotos) throws IOException {
        String pageSource = getPageSource(instagramAccount);
        String justJsonString = pageSource
                .split("window._sharedData = ")[1]
                .split(";</script>")[0];

        JSONObject object = new JSONObject(justJsonString);

        JSONArray jsonArray = object.getJSONObject("entry_data")
                .getJSONArray("ProfilePage")
                .getJSONObject(0)
                .getJSONObject("graphql")
                .getJSONObject("user")
                .getJSONObject("edge_owner_to_timeline_media")
                .getJSONArray("edges");

        List<String> urlList = new ArrayList<>();
        if (numberOfPhotos > jsonArray.length()){
            numberOfPhotos = jsonArray.length();
        }
        for (int i = 0; i < numberOfPhotos; i++) {
            String urlAddress = jsonArray
                    .getJSONObject(i)
                    .getJSONObject("node")
                    .getString("display_url");
            urlList.add(urlAddress);
        }
        return urlList;
    }

    private String getPageSource(String instagramAccount) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL("https://www.instagram.com/"+instagramAccount)
                .openConnection();
        connection.setRequestMethod("GET");
        InputStream inputStream = connection.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder stringBuilder = new StringBuilder();

        String line = reader.readLine();
        while (line != null){
            stringBuilder.append(line);
            line = reader.readLine();
        }
     return stringBuilder.toString();
    }
}
