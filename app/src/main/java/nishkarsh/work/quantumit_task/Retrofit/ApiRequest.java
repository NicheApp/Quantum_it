package nishkarsh.work.quantumit_task.Retrofit;

import nishkarsh.work.quantumit_task.Response.ArticleResponse;
import retrofit2.Call;
import retrofit2.http.GET;

import static nishkarsh.work.quantumit_task.Constants.AppConstants.Api_key;

public interface ApiRequest {


    @GET("top-headlines?country=in&apikey="+Api_key)
    Call<ArticleResponse> getHeadlines();
}
