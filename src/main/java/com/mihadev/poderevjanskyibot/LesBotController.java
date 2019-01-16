package com.mihadev.poderevjanskyibot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.mihadev.poderevjanskyibot.Quotes.QUOTES;
import static java.util.Collections.*;

public class LesBotController extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());
        String text = message.getText();
        if (text.equalsIgnoreCase("/Лесь")) {
            sendRandomQuote(sendMessage);
        }else {
            List<Quote> quotes = findQuote(text);
            String answer = convertToAnswer(quotes);
            if (answer.isEmpty()) {
                answer = "Нема таких слів у класіка! Спробуй ще!";
            }
            sendMessage(sendMessage, answer);
        }
    }

    private void sendRandomQuote(SendMessage sendMessage) {
        Random random = new Random();
        int i = random.nextInt(QUOTES.size());
        Quote quote = QUOTES.get(i);
        String answer = convertToAnswer(singletonList(quote));
        sendMessage(sendMessage, answer);
    }

    private void sendMessage(SendMessage sendMessage, String answer) {
        setButton(sendMessage);
        sendMessage.setText(answer);
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private String convertToAnswer(List<Quote> quotes) {
        return quotes.stream()
                    .map(quote -> quote.getBook().bookName + " : " + quote.getText())
                    .collect(Collectors.joining("\n\n"));
    }

    private List<Quote> findQuote(String text) {
        List<Quote> result = new ArrayList<>();
        for (Quote q : QUOTES) {
            if (q.getText().toLowerCase().contains(text.toLowerCase())) {
                result.add(q);
            }
        }
        return result;
    }

    private void setButton(SendMessage sendMessage) {
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setResizeKeyboard(true);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        KeyboardRow keyboardRow = new KeyboardRow();
        keyboardRow.add(new KeyboardButton("/Лесь"));
        replyKeyboardMarkup.setKeyboard(singletonList(keyboardRow));
    }

    @Override
    public String getBotUsername() {
        return "LesPoderevjanskyiBot";
    }

    @Override
    public String getBotToken() {
        return "691587376:AAGKUFVCmXFFqggkj4HXx-FbAG6YCUy0atg";
    }
}
