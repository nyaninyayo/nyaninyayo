package scrapper.controller;

import org.springframework.web.bind.annotation.*;
import scrapper.dto.AddLinkRequest;
import scrapper.dto.ListLinkResponse;
import scrapper.dto.RemoteLinkResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class LinksController {

    @GetMapping(path = "/links", produces = APPLICATION_JSON_VALUE)
    public ListLinkResponse getLinks(@RequestParam("Tg-Chat-Id") long idChat) {
        return null;
    }

    @PostMapping("links")
    public AddLinkRequest addLink(@RequestParam("Tg-Chat-Id") long idChat, @RequestBody String addUrl) {
        return null;
    }

    @DeleteMapping("links")
    public RemoteLinkResponse deleteLink(@RequestParam("Tg-Chat-Id") long idChat, @RequestBody String deleteUrl) {
        return null;
    }
}