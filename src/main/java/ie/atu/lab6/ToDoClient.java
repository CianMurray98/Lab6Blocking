package ie.atu.lab6;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface ToDoClient {

    @GetMapping("/todos/1")
    ToDoResponse fetchData();
}
