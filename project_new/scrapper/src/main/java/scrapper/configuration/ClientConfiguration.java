package scrapper.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import scrapper.client.GitHubClient;
import scrapper.client.GitHubClientImpl;
import scrapper.client.StackOverflowClient;
import scrapper.client.StackOverflowClientImpl;


@Configuration
public class ClientConfiguration {

    @Bean
    public GitHubClient getGitHubClient() {
        return new GitHubClientImpl();
    }

    @Bean
    public StackOverflowClient getStackOverflowClient() {
        return new StackOverflowClientImpl();
    }

    @Bean
    public long schedulerIntervalMs(ApplicationConfig config) {
        return config.scheduler().interval().toMillis();
    }
}