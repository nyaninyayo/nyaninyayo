package bot.service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import bot.enums.InformationCommand;
import bot.client.ScrapperClient;
import bot.dto.ListLinkRequest;
import bot.dto.ListLinkResponse;

import java.net.URI;
import java.util.List;

@Component
public class CommandList extends AbstractCommand {

    private ScrapperClient client;
    public CommandList(ScrapperClient client) {
        this.client = client;
        informationCommand = InformationCommand.LIST;
    }

    @Override
    public SendMessage handle(Update update) {
        StringBuilder stringBuilder = new StringBuilder();
        Mono<ListLinkResponse> response = client.listTrackedLink(new ListLinkRequest(update.message().chat().id()));
        ListLinkResponse listLinkResponse = response.block();
        if (listLinkResponse != null) {
            List<URI> urls = listLinkResponse.urls();
            if (urls.size() > 0) {
                for (URI url : urls) {
                    stringBuilder.append(url.toString()).append("\n");
                }
            } else {
                stringBuilder.append("No tracked links");
            }
        } else {
            stringBuilder.append("Server is not responding");
        }
        return new SendMessage(update.message().chat().id(), stringBuilder.toString());
    }
}
