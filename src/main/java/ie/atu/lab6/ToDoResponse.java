package ie.atu.lab6;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ToDoResponse {
    @JsonProperty("userID")
    private int userID;

    @JsonProperty("id")
    private int id;

    @JsonProperty("title")
    private int title;

    @JsonProperty("completed")
    private int completed;
}
