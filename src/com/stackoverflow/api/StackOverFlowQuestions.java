package com.stackoverflow.api;

import java.util.ArrayList;
import java.util.List;

import net.sf.stackwrap4j.entities.Question;
import net.sf.stackwrap4j.query.SearchQuery;
//import com.google.code.stackexchange.client.query.StackExchangeApiQueryFactory;

//http://stackoverflow.com/users/4033416/programmer
//clientId = 6836
//clientSecret = 7cL6PT3mXBDUb0DqDLpB0g((
//key = XPfk3ExLE7WL*n0L56e5DQ(( 
//

/**
 * @author Ashley
 * Import StackWrap4j wrapper for StackOverFlow APIs
 * Create a new app in StackApps to get all the necessary keys
 * This program will search for all the questions with the "quickbooks-api" tag.
 */

public class StackOverFlowQuestions {
	
	public static String appKey = "XPfk3ExLE7WL*n0L56e5DQ";
	
	public void getTopQuestions() throws Exception {
//		StackWrapper stackoverflow = new StackOverflow();
//		StackExchangeApiQueryFactory queryFactory = StackExchangeApiQueryFactory
//		        .newInstance(appKey, 
//		        StackExchangeSite.STACK_OVERFLOW);
//		
//		List<Question> questions = new ArrayList<Question>();
//		
//        SearchQuery query = new SearchQuery();
//        query.addTag("quickbooks");
//        query.addTag("api");
//        query.addTag("quickbooks-online");
//        query.addTag("intuit-partner-platform");
//        try {
//        	questions = stackoverflow.search(query);
//        	System.out.println("User = " + questions.get(0).getOwner().getDisplayName() +"\n" +
//	    			 " Text = " + questions.get(0).getBody() +"\n" +
//	    			 " userId = "  + questions.get(0).getOwner().getId() +"\n"
//	    			 " Id = " + tweets.get(0).getId() +"\n" +
//	    			 " InReplyScreenName = " + tweets.get(0).getInReplyToScreenName() +"\n" +
//	    			 " InReplyToStatusId = " + tweets.get(0).getInReplyToStatusId() +"\n" +
//	    			 " InReplyToUserId = " + tweets.get(0).getInReplyToUserId() +"\n" +
//	    			 " Lang = " + tweets.get(0).getLang() +"\n" +
//	    			 " QuotedStatus = " + tweets.get(0).getQuotedStatusId() +"\n" +
//	    			 " RetweetCount = " + tweets.get(0).getRetweetCount()
//	    			 );
//        } catch(Exception e) {
//        	 throw new Exception("Couldn't connect: " + e);
//        }
	}
}
