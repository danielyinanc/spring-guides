package hello.service;


import hello.dto.RepoListDto;
import org.springframework.util.concurrent.ListenableFuture;

public interface RepoListService {
    public ListenableFuture<RepoListDto> search(String query);
}
