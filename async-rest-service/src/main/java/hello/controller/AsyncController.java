package hello.controller;

import hello.dto.RepoListDto;
import hello.service.RepoListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
class AsyncController {
    private static final Logger log = LoggerFactory.getLogger(AsyncController.class);

    @Autowired
    private RepoListService repoListService;

    @RequestMapping("/async")
    DeferredResult<ResponseEntity<?>> async(@RequestParam("q") String query) {
        DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
        ListenableFuture<RepoListDto> repositoryListDto = repoListService.search(query);
        repositoryListDto.addCallback(
                new ListenableFutureCallback<RepoListDto>() {
                    @Override
                    public void onSuccess(RepoListDto result) {
                        ResponseEntity<RepoListDto> responseEntity =
                            new ResponseEntity<>(result, HttpStatus.OK);
                        deferredResult.setResult(responseEntity);
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        log.error("Failed to fetch result from remote service", t);
                        ResponseEntity<Void> responseEntity =
                            new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
                        deferredResult.setResult(responseEntity);
                    }
                }
        );
        return deferredResult;
    }
}
