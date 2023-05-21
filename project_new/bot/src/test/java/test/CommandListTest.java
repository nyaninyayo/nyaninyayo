package test;

import bot.service.CommandList;
import com.google.gson.Gson;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import bot.client.ScrapperClient;
import bot.dto.ListLinkRequest;
import bot.dto.ListLinkResponse;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest (classes = {CommandListTest.class})
public class CommandListTest {

    private final  String data = """ 
            {'update_id': 1684686775, 'message': {'message_id': 347, 'chat': {'id': 711597620,
            'type': 'private', 'first_name': 'няниняё', 'last_name': ''}, 'text': '/start', 'entities': [ {"offset": 0,"length": 6,"type": "bot_command"}]}}""";
    private final Gson gson = new Gson();
    @Mock
    private ScrapperClient scrapperClient;

    @InjectMocks
    private CommandList commandList;

    @Test
    void handle__scrapperClientReturnEmptyList_ReturnSpecialMessage() {
        // given
        ListLinkRequest request = new ListLinkRequest(711597620L);
        ListLinkResponse emptyList = new ListLinkResponse(List.of());
        Update update = gson.fromJson(data, Update.class);
        when(scrapperClient.listTrackedLink(request))
                .thenReturn(Mono.just(emptyList));

        // when
        SendMessage sendMessage = commandList.handle(update);
        Map<String, Object> result = sendMessage.getParameters();

        // then
        assertAll(
                () -> assertNotNull(result.get("chat_id")),
                () -> assertNotNull(result.get("text")),
                () -> assertEquals(result.get("chat_id"), 711597620L),
                () -> assertEquals(result.get("text"), "No tracked links")
        );
    }

    @Test
    void handle__scrapperClientReturnListUrl_FormatMatches() {
        // given
        ListLinkRequest request = new ListLinkRequest(711597620L);
        ListLinkResponse emptyList = new ListLinkResponse(List.of());
        Update update = gson.fromJson(data, Update.class);
        when(scrapperClient.listTrackedLink(request))
                .thenReturn(Mono.just(emptyList));

        // when
        SendMessage sendMessage = commandList.handle(update);
        Map<String, Object> result = sendMessage.getParameters();

        // then
        assertAll(
                () -> assertNull(result.get("parse_mode"))
        );
    }
}
