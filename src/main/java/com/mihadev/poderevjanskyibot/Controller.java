package com.mihadev.poderevjanskyibot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/les")
    public Quote getRandomQuote() {
        return LesBotService.getRandomQuote();
    }
}
