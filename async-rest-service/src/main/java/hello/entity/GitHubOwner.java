package hello.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GitHubOwner {

    @JsonProperty("login")
    private String userName;

    @JsonProperty("html_url")
    private URL url;

    @JsonProperty("avatar_url")
    private URL avatarUrl;

    String userName() {
        return userName;
    }

    URL url() {
        return url;
    }

    URL avatarUrl() {
        return avatarUrl;
    }
}