package bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Map;

@Configuration
public class BotConfiguration {

    @Bean
    public String getBotToken(ApplicationConfig config) {

        return config.botToken();

    }
}