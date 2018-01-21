package com.nutriscan.nutri_scan;
import java.net.*;
import java.util.*;
import java.io.*;


/**
 * Created by justi on 1/20/2018.
 */

public class GoogleVision {
    public String imgToText (String filePath) {
        String output = null;
        String API_KEY = "AIzaSyC_u_NimzT1faJlGviqduEV51j2B3LO6Bw";
        String TARGET_URL = "https://vision.googleapis.com/v1/images:annotate?key=";
        try {
            URL serverUrl = new URL(TARGET_URL + API_KEY);
            URLConnection urlConnection = serverUrl.openConnection();
            HttpURLConnection httpConnection = (HttpURLConnection) urlConnection;
            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setDoOutput(true);

            //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(httpConnection.getOutputStream()));
            StringWriter bw = new StringWriter();
            bw.write
                    ("{\"requests\":  [{ \"features\":  [ {\"type\": \"TEXT_DETECTION\""
                            + "}], \"image\": {\"content\": " + filePath + "  }}}]}");
            output = bw.toString();
        } catch(MalformedURLException ex) {
            ex.printStackTrace();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
        return output;
    }
}
