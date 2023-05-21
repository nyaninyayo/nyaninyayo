package bot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import bot.client.ScrapperClient;
import bot.client.ScrapperClientImpl;

@Configuration
public class ClientConfiguration {

    @Bean
    public ScrapperClient getScrapperClient() {
        return new ScrapperClientImpl();
    }
}
