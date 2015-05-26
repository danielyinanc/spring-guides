package hello.dto;

import hello.entity.GitHubItem;
import hello.entity.GitHubItems;
import hello.entity.GitHubOwner;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureAdapter;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepositoryListDtoAdapter extends ListenableFutureAdapter<RepoListDto, ResponseEntity<GitHubItems>> {

    private final String query;

    public RepositoryListDtoAdapter(String query, ListenableFuture<ResponseEntity<GitHubItems>> gitHubItems) {
        super(gitHubItems);
        this.query = query;
    }

    @Override
    protected RepoListDto adapt(ResponseEntity<GitHubItems> responseEntity) throws ExecutionException {
        GitHubItems gitHubItems = responseEntity.getBody();
        List<RepoDto> repoDtos =
            gitHubItems.getItems().stream().map(toRepositoryDto).collect(Collectors.toList());
        return new RepoListDto(query, gitHubItems.getTotalCount(), repoDtos);
    }

    private static Function<GitHubItem, RepoDto> toRepositoryDto = item -> {
        GitHubOwner owner = item.getOwner();
        return new RepoDto(item.getFullName(), item.getUrl(), item.getDescription(),
                           owner.getUserName(), owner.getUrl(), owner.getAvatarUrl());
    };
}
