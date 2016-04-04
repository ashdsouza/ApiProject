package com.twitter.api;

/**
* 
* @author Ashley
* Import Twitter4j wrapper for Twitter APIs
* Create a new app in Twitter to get all the necessary CustomerKey, CustomerSecret
* This program will search for all the tweets with the handle provided.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.tweet.object.Issue;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterTweets 
{
	public static String consumerKeyStr = "cIVTBZ05p4JYyZkTCagF4NGfy";
	public static String consumerSecretStr = "PHWjlot3W5T0FN9jO1HAOUagcxQzasPgObobevcjrJRZD7wJKf";
	public static String accessTokenStr = "114999156-Uo7X6ClJjywcBQfDP6Jn3wWqnY8EmrvvtetkgVpt";
	public static String accessTokenSecretStr = "38nR7yhumIzrAjkbvByFOMN83AZONM5JudF4dRRAJsa3p";
	public static String handle = "quickbooks API";
	public static Integer maxUniqueTweets = 20;
	
  public HashMap<Long, Issue> getTopTweets() throws TwitterException {
	ArrayList<Status> tweets = new ArrayList<Status>();  
	HashMap<Long, Issue> issues = new HashMap<Long, Issue>();
  	//set the tokens for authentication using Twitter4j ConfigurationBuilder class
  	ConfigurationBuilder configSettings = new ConfigurationBuilder();
  	configSettings.setDebugEnabled(true)
        .setOAuthConsumerKey(consumerKeyStr)
        .setOAuthConsumerSecret(consumerSecretStr)
        .setOAuthAccessToken(accessTokenStr)
        .setOAuthAccessTokenSecret(accessTokenSecretStr);
  	
      Twitter twitter = new TwitterFactory(configSettings.build()).getInstance();	//get Twitter class Instance
      Query query = new Query(handle);	//use hashTag to get all tweets related to that
      query.setCount(200);	//top 20
      query.setResultType(Query.ResultType.recent); //recent
      query.setLang("en"); //Language is English
	  
      //make a query to search for all tweets having the handle "quickbooks API"
      try {
    	     QueryResult result = twitter.search(query);
	    	 tweets.addAll(result.getTweets());
//	    	 System.out.println("Gathered " + tweets.size() + " tweets"+"\n");	  
//	    	 System.out.println("User = " + tweets.get(0).getUser() +"\n" +
//	    			 " Text = " + tweets.get(0).getText() +"\n" +
//	    			 " CurrentUserRetweetId = "  + tweets.get(0).getCurrentUserRetweetId() +"\n" +
//	    			 " AccessLevel = " + tweets.get(0).getAccessLevel() +"\n" +
//	    			 " FavouriteCount = " + tweets.get(0).getFavoriteCount() +"\n" +
//	    			 " Id = " + tweets.get(0).getId() +"\n" +
//	    			 " InReplyScreenName = " + tweets.get(0).getInReplyToScreenName() +"\n" +
//	    			 " InReplyToStatusId = " + tweets.get(0).getInReplyToStatusId() +"\n" +
//	    			 " InReplyToUserId = " + tweets.get(0).getInReplyToUserId() +"\n" +
//	    			 " Lang = " + tweets.get(0).getLang() +"\n" +
//	    			 " QuotedStatus = " + tweets.get(0).getQuotedStatusId() +"\n" +
//	    			 " RetweetCount = " + tweets.get(0).getRetweetCount()
//	    			 );
	    	 issues = parseTweets(tweets);
	     } catch (TwitterException e) {
	    	 throw new TwitterException("Couldn't connect: " + e);
	     }
      return issues;
  	}
  
  public static final String typesOfIssues[] = new String[] {
		  "problems",
		  "issues",
		  "issue",
		  "problem",
		  "errors",
		  "encountered"
  };
  
  //returns issues after parsing Tweets as UserId  --> Issue
  public HashMap<Long, Issue> parseTweets(ArrayList<Status> tweets) {
	  int counter = 0;
	  HashMap<Long, Issue> issues = new HashMap<Long, Issue>();
	  for(Status tweet: tweets) {
		  if(checkIfStringContainsWords(tweet.getText())) {
			  if(counter == maxUniqueTweets) break;
			  if(!issues.containsKey(tweet.getUser().getId())) {
				  Issue issue = new Issue();
				  issue.setName(tweet.getUser().getName());
				  issue.setText(tweet.getText());
				  issue.setUserId(tweet.getUser().getId());
				  issues.put(tweet.getUser().getId(), issue);
				  counter++;
			  }
		  }
	  }
	  return issues;
  }
  
  public boolean checkIfStringContainsWords(String str) {
	  boolean contains = false;
	  for(int i=0; i<typesOfIssues.length; i++) {
		  if(str.contains(typesOfIssues[i])) {
			  contains = true;
		  }
	  }
	  return contains;
  }
}
