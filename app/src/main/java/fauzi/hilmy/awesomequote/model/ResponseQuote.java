package fauzi.hilmy.awesomequote.model;

import com.google.gson.annotations.SerializedName;

public class ResponseQuote{

	@SerializedName("quote")
	private Quote quote;

	@SerializedName("qotd_date")
	private String qotdDate;

	public void setQuote(Quote quote){
		this.quote = quote;
	}

	public Quote getQuote(){
		return quote;
	}

	public void setQotdDate(String qotdDate){
		this.qotdDate = qotdDate;
	}

	public String getQotdDate(){
		return qotdDate;
	}
}