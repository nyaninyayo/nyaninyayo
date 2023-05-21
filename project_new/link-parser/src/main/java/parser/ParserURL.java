package parser;

public sealed interface ParserURL permits ParserGitHubURL, ParserStackOverflowURL {
    UrlData parseUrl(String url);
}