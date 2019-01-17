package com.mihadev.poderevjanskyibot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.mihadev.poderevjanskyibot.Quotes.QUOTES;
import static java.util.Collections.singletonList;

class LesBotService {

    private static String convertToAnswer(List<Quote> quotes) {
        return quotes.stream()
                .map(quote -> quote.getBook().bookName + " : " + quote.getText())
                .collect(Collectors.joining("\n\n"));
    }

    static String findQuotes(String text) {
        List<Quote> result = new ArrayList<>();
        for (Quote q : QUOTES) {
            if (q.getText().toLowerCase().contains(text.toLowerCase())) {
                result.add(q);
            }
        }
        return convertToAnswer(result);
    }

    static String getRandomQuote() {
        Random random = new Random();
        int i = random.nextInt(QUOTES.size());
        Quote quote = QUOTES.get(i);
        return convertToAnswer(singletonList(quote));
    }


}