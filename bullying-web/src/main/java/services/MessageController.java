package services;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @RequestMapping("/mensaje")
    public Message message() {
        return new Message("Hola mundo");
    }
}
