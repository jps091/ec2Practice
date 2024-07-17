package lecture.ec2.utils;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Ec2Util {

    private static final String METADATA_URL = "http://169.254.169.254/latest/meta-data/";


    public static String getMetadata(String path) throws IOException {
        URL url = new URL(METADATA_URL + path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setConnectTimeout(5000);
        conn.setReadTimeout(5000);

        try (Scanner scanner = new Scanner(conn.getInputStream())) {
            return scanner.useDelimiter("\\A").hasNext() ? scanner.next() : "";
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
