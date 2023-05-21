package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

public record StackOverflowQuestionResponse(@JsonProperty("last_edit_date") OffsetDateTime lastEditDate) {

}
