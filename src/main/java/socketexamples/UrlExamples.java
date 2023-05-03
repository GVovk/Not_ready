package socketexamples;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlExamples {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://smirnov:password@geekbrains.ru:80/courses?type=qa&level=super#1");

        System.out.println(url.getAuthority());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getQuery());

        URL url1 = new URL("https", "geekbrains.ru", 443, "/courses");
    }
}
