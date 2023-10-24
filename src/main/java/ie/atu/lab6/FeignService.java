package ie.atu.lab6;

import org.springframework.stereotype.Service;

@Service
public class FeignService {
    private final ToDoClient todoClient;

    public FeignService(ToDoClient todoClient){
        this.todoClient = todoClient;
    }
    public ToDoResponse fetchData(){
        ToDoResponse td = todoClient.fetchData();
        System.out.println(td);
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        return td;
    }
}
