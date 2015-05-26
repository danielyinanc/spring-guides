package hello.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GitHubItems {

    @JsonProperty("total_count")
    private int totalCount;

    @JsonProperty("items")
    private List<GitHubItem> items;

    int totalCount() {
        return totalCount;
    }

    List<GitHubItem> items() {
        return items;
    }
}
