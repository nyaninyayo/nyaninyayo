package bot.service;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.stereotype.Component;
import bot.enums.InformationCommand;

@Component
public class CommandStart extends AbstractCommand {

    public CommandStart() {
        informationCommand = InformationCommand.START;
    }
    @Override
    public SendMessage handle(Update update) {
        // create chat id
        return new SendMessage(update.message().chat().id(), "Hello, " +
                update.message().from().firstName() + " " + update.message().from().lastName() +
                ". Enter /help to find out what I can");
    }
}