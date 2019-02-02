package com.mihadev.poderevjanskyibot.twitter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterConfig {

    @Bean
    public Twitter twitter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("rFGlcUlrOOVA4oX8ZT47mEYdl")
                .setOAuthConsumerSecret("dthMmXnVXHL0sv1oER3wdNFNwkqr8BLzkYLbimpHWGB1LEJeVY")
                .setOAuthAccessToken("2369297341-2jb8Yv4zwSIwUPPEpQLpRM6CjIbTAaUGoLwtsje")
                .setOAuthAccessTokenSecret("Pn7n35qJI8vRJkPh2onBBIi6OTedJzpKwsvgnjhSUb1BR");
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }

    @Bean
    public TwitterController twitterController(Twitter twitter) {
        TwitterController twitterController = new TwitterController(twitter);
        twitterController.sendRandomLesTwits();
        return twitterController;
    }
}
