/*
package lecture.ec2.utils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Ec2Util {

    private static final String METADATA_URL = "http://169.254.169.254/latest/meta-data/";
    private static final String TOKEN_URL = "http://169.254.169.254/latest/api/token";

    private static String getToken() throws IOException {
        URL url = new URL(TOKEN_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("X-aws-ec2-metadata-token-ttl-seconds", "21600");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            return reader.readLine();
        }
    }

    public static String getMetadata(String path) throws IOException {
        String token = getToken();
        URL url = new URL(METADATA_URL + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-aws-ec2-metadata-token", token);
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            return response.toString();
        }
    }

    public static String getInstanceId() throws IOException {
        return getMetadata("instance-id");
    }

    public static String getRegion() throws IOException {
        String availabilityZone = getMetadata("placement/availability-zone");
        return availabilityZone.substring(0, availabilityZone.length() - 1);
    }
}
*/
