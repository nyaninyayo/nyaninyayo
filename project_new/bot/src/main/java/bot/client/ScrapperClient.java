package bot.client;

import reactor.core.publisher.Mono;
import bot.dto.*;

public interface ScrapperClient {
    Mono<AddLinkResponse> addTrackedLink(AddLinkRequest request);

    Mono<DeleteLinkResponse> deleteTrackedLink(DeleteLinkRequest request);

    Mono<ListLinkResponse> listTrackedLink(ListLinkRequest request);

    void registerChat(Long id);

    void deleteChat(Long id);
}