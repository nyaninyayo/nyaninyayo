package controllers;

import org.springframework.web.bind.annotation.*;
import dto.AddLinkRequest;
import dto.ListLinkResponse;
import dto.RemoteLinkResponse;


@RestControllerAdvice
public class LinksController {

    @GetMapping("/links")
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