package com.mihadev.poderevjanskyibot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/les")
    public String getRandomQuote() {
        Quote randomQuote = LesBotService.getRandomQuote();
        System.out.println(randomQuote);
        return randomQuote.toString();
    }
}
