package com.mihadev.poderevjanskyibot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Objects;

import static com.mihadev.poderevjanskyibot.LesBotService.findQuotes;
import static com.mihadev.poderevjanskyibot.LesBotService.getRandomQuote;
import static java.util.Collections.singletonList;

public class TelegramLesBotController extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId());
        sendMessage.setReplyToMessageId(message.getMessageId());
        String text = message.getText();

        if (isNotEmpty(text) && text.equalsIgnoreCase("/Лесь")) {
            sendMessage(sendMessage, getRandomQuote());
        } else {
            String answer = findQuotes(text);
            if (answer.isEmpty()) {
                answer = "Нема таких слів у класіка! Спробуй ще!";
            }
            sendMessage(sendMessage, answer);
        }
    }

    private boolean isNotEmpty(String text) {
        return Objects.nonNull(text) && !text.isEmpty();
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
