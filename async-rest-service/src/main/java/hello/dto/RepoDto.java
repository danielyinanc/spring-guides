package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

public class RepoDto {

    @JsonProperty("name")
    private final String name;
    @JsonProperty("url")
    private final URL url;
    @JsonProperty("description")
    private final String description;

    @JsonProperty("owner")
    private final String owner;
    @JsonProperty("owner_url")
    private final URL ownerUrl;
    @JsonProperty("owner_avatar")
    private final URL ownerAvatar;

    public RepoDto(String name, URL url, String description,
                   String owner, URL ownerUrl, URL ownerAvatar) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.owner = owner;
        this.ownerUrl = ownerUrl;
        this.ownerAvatar = ownerAvatar;
    }
}
