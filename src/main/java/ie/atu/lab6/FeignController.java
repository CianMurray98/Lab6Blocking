package ie.atu.lab6;

import org.bouncycastle.asn1.dvcs.DVCSObjectIdentifiers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class FeignController {
    private final FeignService feignService;

    public FeignController(FeignService feignService){
        this.feignService = feignService;
    }

    @GetMapping("/feign")
    public String getFeignData() throws Exception, InterruptedException {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<ToDoResponse>> futures = new ArrayList<>();

        for(int i = 0; i < 10; i++){
            CompletableFuture<ToDoResponse> future = CompletableFuture.supplyAsync(() -> feignService.fetchData());
            futures.add(future);
        }
        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.get();
        long endTime = System.currentTimeMillis();

        return "Total execution Time: " + (endTime - startTime) + " ms";
    }
}
