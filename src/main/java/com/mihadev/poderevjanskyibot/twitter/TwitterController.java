package com.mihadev.poderevjanskyibot.twitter;

import com.mihadev.poderevjanskyibot.LesBotService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.Timer;
import java.util.TimerTask;

public class TwitterController {
    private Logger logger = LoggerFactory.getLogger(TwitterController.class);
    private final Twitter twitter;

    public TwitterController(Twitter twitter) {
        this.twitter = twitter;
    }

    void sendRandomLesTwits() {
        String twit = LesBotService.getRandomStringQuote();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                try {
                    twitter.updateStatus(twit);
                    logger.warn(twit);

                } catch (TwitterException e) {
                    e.printStackTrace();
                }
            }
        };

        Timer timer = new Timer("TwitterTimer");
        timer.schedule(timerTask, 1000L,10700000L);
    }
}
