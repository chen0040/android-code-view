package com.github.chen0040.androidcodeview;

import com.alibaba.fastjson.JSON;
import com.github.chen0040.magento.services.HttpComponent;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen0 on 4/7/2017.
 */

public class AndroidHttpComponent implements HttpComponent {
    @Override
    public String post(String uri, String body, Map<String, String> headers) {
        String result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            for(Map.Entry<String, String> header : headers.entrySet()) {
                urlConnection.setRequestProperty(header.getKey(), header.getValue());
            }

            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);

            urlConnection.connect();

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(body);
            writer.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            result = sb.toString();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    @Override
    public String put(String uri, String body, Map<String, String> headers) {
        String result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            for(Map.Entry<String, String> header : headers.entrySet()) {
                urlConnection.setRequestProperty(header.getKey(), header.getValue());
            }

            urlConnection.setRequestMethod("PUT");
            urlConnection.setDoOutput(true);

            urlConnection.connect();

            OutputStream out = new BufferedOutputStream(urlConnection.getOutputStream());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(body);
            writer.close();

            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            result = sb.toString();

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    @Override
    public String delete(String uri, Map<String, String> headers) {
        String result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            for(Map.Entry<String, String> header : headers.entrySet()) {
                urlConnection.setRequestProperty(header.getKey(), header.getValue());
            }

            urlConnection.setRequestMethod("DELETE");

            urlConnection.connect();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            result = sb.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    @Override
    public String get(String uri, Map<String, String> headers) {

        String result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(uri);
            urlConnection = (HttpURLConnection) url.openConnection();
            for(Map.Entry<String, String> header : headers.entrySet()) {
                urlConnection.setRequestProperty(header.getKey(), header.getValue());
            }

            urlConnection.setRequestMethod("GET");

            urlConnection.connect();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = reader.readLine())!=null){
                sb.append(line);
            }
            result = sb.toString();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    @Override
    public String jsonPost(String uri, Map<String, String> data) {
        Map<String, String> headers = new HashMap<>();
        String body = JSON.toJSONString(data);
        headers.put("Content-Type", "application/json");
        return post(uri, body, headers);
    }
}
