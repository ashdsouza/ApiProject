package com.twitter.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tweet.object.Issue;

import twitter4j.Status;
import twitter4j.TwitterException;

/**
 * Servlet implementation class TwitterFeed
 */
@WebServlet("/TwitterFeed")
public class TwitterFeed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private HashMap<Long, Issue> tweetsList = new HashMap<Long, Issue>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterFeed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().print("Hello World");
		TwitterTweets tweets = new TwitterTweets();
		try {
			tweetsList = tweets.getTopTweets();
			request.setAttribute("tweetsList", tweetsList);
			request.setAttribute("count", tweetsList.size());
			RequestDispatcher view = request.getRequestDispatcher("twitter.jsp");
			view.forward(request, response);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
