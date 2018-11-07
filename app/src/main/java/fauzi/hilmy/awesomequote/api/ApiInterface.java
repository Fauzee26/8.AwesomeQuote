package fauzi.hilmy.awesomequote.api;

import fauzi.hilmy.awesomequote.model.ResponseQuote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("qotd")
    Call<ResponseQuote> getQuote();
}
