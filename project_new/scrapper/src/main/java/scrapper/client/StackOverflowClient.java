package scrapper.client;

import reactor.core.publisher.Mono;
import scrapper.dto.StackOverflowQuestionResponse;

public interface StackOverflowClient {
    Mono<StackOverflowQuestionResponse> fetchInfoQuestion(int numberQuestion);
}
