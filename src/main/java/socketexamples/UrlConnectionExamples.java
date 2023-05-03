package socketexamples;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlConnectionExamples {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https", "gb.ru", "/");

        InputStream in = url.openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            //System.out.println(line);
        }

        bufferedReader.close();

        URL url1 = new URL("https://restful-booker.herokuapp.com/auth");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url1.openConnection();

        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);
        String requetsBody = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(httpURLConnection.getOutputStream()))) {
            bufferedWriter.write(requetsBody);
        }

        try (BufferedReader bufferedReader1 = new BufferedReader(
                new InputStreamReader(httpURLConnection.getInputStream()))) {
            String temp;
            while ((temp = bufferedReader1.readLine()) != null) {
                System.out.println(temp);
            }
        }
    }
}