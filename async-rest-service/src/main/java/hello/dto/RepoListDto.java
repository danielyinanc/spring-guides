package hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RepoListDto {

    @JsonProperty("query")
    private final String query;

    @JsonProperty("nbr_of_repositories")
    private final int nbrOfRepositories;

    @JsonProperty("repositories")
    private final List<RepoDto> repositories;

    public RepoListDto(String query, int nbrOfRepositories, List<RepoDto> repositories) {
        this.query = query;
        this.nbrOfRepositories = nbrOfRepositories;
        this.repositories = repositories;
    }
}
