package com.example.root.jsonparsingapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Load File
            BufferedReader jsonReader = new BufferedReader(new InputStreamReader(this.getResources().openRawResource(R.raw.scene_data)));
            StringBuilder builder = new StringBuilder();
            for (String line = null; (line = jsonReader.readLine()) != null;) {
                builder.append(line).append("\n");
            }




            JSONObject root = new JSONObject(builder.toString());
            Log.d("TTag",root.toString());
            //Toast.makeText(this,root.getString("name").toString(),Toast.LENGTH_SHORT).show();
            //root.getJSONArray("scenes").getJSONObject(0).getString("src");

            JSONArray stages = root.getJSONArray("scenes");
            JSONArray scenes=stages.getJSONArray(0);
            JSONObject scene = scenes.getJSONObject(0);

            Toast.makeText(this,scene.getString("src").toString(),Toast.LENGTH_SHORT).show();




        } catch (FileNotFoundException e) {
            Log.e("jsonFile", "file not found");
        } catch (IOException e) {
            Log.e("jsonFile", "ioerror");
        } catch (JSONException e) {
            Log.e("jsonFile", "error while parsing json");
        }
    }
}