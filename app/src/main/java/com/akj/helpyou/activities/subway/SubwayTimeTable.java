package com.akj.helpyou.activities.subway;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class SubwayTimeTable {
    public static void main(String[] args) throws IOException {

        // ODsay Api Key 정보
        String apiKey = "0nehdLX3OVWuCwGb4VVeuWQ2zgfr3WCF4OaAYd64xeo";

        String urlInfo = "https://api.odsay.com/v1/api/subwayTimeTable?lang=0&statuonID=130&apiKey="
                + URLEncoder.encode(apiKey, "UTF-8");

        // http 연결
        URL url = new URL(urlInfo);
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(conn.getInputStream()));

        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();
        conn.disconnect();

        // 결과 출력


    }
}
