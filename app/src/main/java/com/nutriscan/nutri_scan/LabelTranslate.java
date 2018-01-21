package com.nutriscan.nutri_scan;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.net.*;
import java.io.*;
import android.view.SurfaceView;
import android.content.Intent;
import android.provider.MediaStore;
import android.content.pm.PackageManager;


/**
 * Created by justi on 1/21/2018.
 */

public class LabelTranslate {

    // Sends POST request to Google Cloud Vision and returns text results.
    // filePath is path to .jpg
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

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


}
