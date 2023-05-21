package bot.service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import bot.enums.InformationCommand;
import bot.client.ScrapperClient;
import bot.dto.AddLinkRequest;
import bot.dto.AddLinkResponse;

@Component
public class CommandTrack extends AbstractCommand {

    private ScrapperClient client;
    public CommandTrack(ScrapperClient client) {
        this.client = client;
        informationCommand = InformationCommand.TRACK;
    }

    @Override
    public SendMessage handle(Update update) {
        // User user = getDB
        // user.state = Track
        return new SendMessage(update.message().chat().id(), "Enter url for track");
    }

    @Override
    public SendMessage handleWithArgument(Update update) {
        // Add url
        String url = update.message().text();
        Mono<AddLinkResponse> response = client.addTrackedLink(new AddLinkRequest(update.message().chat().id(), url));
        return new SendMessage(update.message().chat().id(), "Add url for track");
    }
}
