package scrapper.client;

import reactor.core.publisher.Mono;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.stereotype.Service;
import scrapper.dto.GitHubRepositoryResponse;

import java.beans.ConstructorProperties;

public class GitHubClientImpl implements GitHubClient {

    private final String BASE_URL = "https://api.github.com";
    private final WebClient webClient;

    public GitHubClientImpl() {
        webClient = WebClient.create(BASE_URL);
    }

    public GitHubClientImpl(String url) {
        webClient = WebClient.create(url);
    }

    @Override
    public Mono<GitHubRepositoryResponse> fetchInfoRepository(String userName, String repo) {
        return webClient.get().uri(uriBuilder -> uriBuilder.path("/{user_name}/{repos}").build(userName, repo))
                .retrieve().bodyToMono(GitHubRepositoryResponse.class);
    }
}