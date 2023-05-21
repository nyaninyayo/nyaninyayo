package parser;

import parser.ParserGitHubURL;
import parser.ParserStackOverflowURL;
import parser.ParserURL;
import parser.UrlData;

import java.util.List;

public class ConvertationUrlToData {
    public static UrlData getInfoAboutURL(String urlInput) {
        List<ParserURL> parsers = List.of(new ParserGitHubURL(), new ParserStackOverflowURL());
        for (ParserURL parser : parsers) {
            UrlData result = parser.parseUrl(urlInput);
            if (result != null) {
                return result;
            }
        }
        return null;
    }
}