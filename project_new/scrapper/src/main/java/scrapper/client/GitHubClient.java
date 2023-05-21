package scrapper.client;

import reactor.core.publisher.Mono;
import scrapper.dto.GitHubRepositoryResponse;

public interface GitHubClient {
    Mono<GitHubRepositoryResponse> fetchInfoRepository(String userName, String repo);
}