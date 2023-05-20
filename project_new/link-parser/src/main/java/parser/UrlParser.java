package parser;
import java.net.URI;
import java.net.URISyntaxException;
public class UrlParser {
    public static String parse(String url) {
        try {
            URI uri = new URI(url);
            String host = uri.getHost();
            if (host != null) {
                if (host.equals("github.com")) {
                    String[] pathParts = uri.getPath().split("/");
                    if (pathParts.length >= 3) {
                        return pathParts[1] + "/" + pathParts[2];
                    }
                } else if (host.equals("stackoverflow.com")) {
                    String[] pathParts = uri.getPath().split("/");
                    if (pathParts.length >= 3) {
                        return pathParts[2];
                    }
                }
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String[] urls = {
                "https://github.com/sanyarnd/tinkoff-java-course-2022/",
                "https://stackoverflow.com/questions/1642028/what-is-the-operator-in-c",
                "https://stackoverflow.com/search?q=unsupported%20link"
        };
        for (String url : urls) {
            System.out.println(parse(url));
        }
    }
}
