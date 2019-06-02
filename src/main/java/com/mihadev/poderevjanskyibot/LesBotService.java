package com.mihadev.poderevjanskyibot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.mihadev.poderevjanskyibot.Quotes.QUOTES;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class LesBotService {

    static String getRandomStringQuote() {
        Quote quote = getRandomQuote();
        return convertToAnswer(quote);
    }

    static Quote getRandomQuote() {
        Random random = new Random();
        int i = random.nextInt(QUOTES.size());
        return QUOTES.get(i);
    }

    static List<String> findQuotes(String text) {
        List<Quote> result = new ArrayList<>();
        for (Quote q : QUOTES) {
            if (q.getText().toLowerCase().contains(text.toLowerCase())) {
                result.add(q);
            }
        }
        return convertToAnswers(result);
    }

    private static List<String> convertToAnswers(List<Quote> quotes) {
        if (quotes.isEmpty()) {
            return emptyList();
        }
        return quotes.stream()
                .map(quote -> quote.getBook().bookName + " :\n" + quote.getText())
                .collect(Collectors.toList());
    }

    private static String convertToAnswer(Quote quote) {
        List<String> answers = convertToAnswers(singletonList(quote));
        if (answers.size() == 1) {
            return answers.get(0);
        }
        throw new IllegalStateException();
    }
}
