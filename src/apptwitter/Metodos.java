/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apptwitter;

import java.util.List;
import java.util.Scanner;
import twitter4j.DirectMessage;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author dsoutofernandez
 */
public class Metodos {
    
     Twitter twitter;
    private Object sender;
    
    public Metodos(){
    ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
        .setOAuthConsumerKey("5yqwH2WcqZ3YlkE0W8BLYkeoW")
        .setOAuthConsumerSecret("s5s5QGigqzULDGbbQs4Rm0pKdqLEefbO4gCh53XgcnA0RoMA9n")
        .setOAuthAccessToken("3055143533-jeaPEtFscvDMVKwPVLubxkmHs9DzCjZ2eIoWdcQ")
        .setOAuthAccessTokenSecret("NzIM687NlVRe3VxKh0a0xRRYpsGytrSEKISaqpuQGtTZL");

   twitter = new TwitterFactory(cb.build()).getInstance();
    }
    
    public void verTL() throws TwitterException{
    
        List<Status> statuses = twitter.getHomeTimeline();
    System.out.println("Showing home timeline.");
    for (Status status : statuses) {
        System.out.println(status.getUser().getName() + ":" +
                           status.getText());
    }
    
    }
    
    
    public void buscarTrending(String busqueda) throws TwitterException{
        
         Query query = new Query(busqueda);
    QueryResult result = twitter.search(query);
    for (Status status : result.getTweets()) {
        System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
    }

    }
    
    public void tweetear(String tweet) throws TwitterException{
        
    Status status = twitter.updateStatus(tweet);
    System.out.println("Successfully updated the status to [" + status.getText() + "].");
    
    }

    public void directMessage(String user, String mensaje){
    
        DirectMessage message = sender.sendDirectMessage("makarofcod", "Eres homosec");
    System.out.println("Sent: " message.getText() + " to @" + message.getRecipientScreenName());
        
    }
    
    
    
}
