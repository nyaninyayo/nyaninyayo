package bot.service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import bot.enums.InformationCommand;
import bot.client.ScrapperClient;
import bot.dto.DeleteLinkRequest;
import bot.dto.DeleteLinkResponse;

@Component
public class CommandUnTrack extends AbstractCommand {
    private ScrapperClient client;
    public CommandUnTrack(ScrapperClient client) {
        this.client = client;
        informationCommand = InformationCommand.UNTRACK;
    }

    @Override
    public SendMessage handle(Update update) {
        // User user = getDB
        // user.state = UnTrack
        return new SendMessage(update.message().chat().id(), "Enter url for untrack");
    }

    @Override
    public SendMessage handleWithArgument(Update update) {
        // Delete url
        String url = update.message().text();
        // Detective url
        Mono<DeleteLinkResponse> response = client.deleteTrackedLink(new DeleteLinkRequest(update.message().chat().id(), url));
        return new SendMessage(update.message().chat().id(), "Delete tracked url");
    }
}