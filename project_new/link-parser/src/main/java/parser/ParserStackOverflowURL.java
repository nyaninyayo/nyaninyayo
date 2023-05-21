package parser;

import parser.UrlData;
import parser.UrlDataStackOverflow;

public final class ParserStackOverflowURL implements ParserURL {

    private final String QUESTIONS = "questions";
    private final String TYPE_URL = "stackoverflow.com";

    @Override
    public UrlData parseUrl(String url) {
        String[] args = url.split("/");
        if (args.length > 4 && args[2].equals(TYPE_URL) && args[3].equals(QUESTIONS)) {
            try {
                Long id = Long.parseLong(args[4]);
                return new UrlDataStackOverflow(TYPE_URL, id);
            } catch (NumberFormatException e) {
                // Bad url
                return null;
            }
        }
        return null;
    }
}