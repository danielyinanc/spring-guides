package hello.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GitHubItem {

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("html_url")
    private URL url;

    @JsonProperty("description")
    private String description;

    @JsonProperty("owner")
    private GitHubOwner owner;

}
