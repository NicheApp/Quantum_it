package nishkarsh.work.quantumit_task.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import nishkarsh.work.quantumit_task.Response.ArticleResponse;
import nishkarsh.work.quantumit_task.Retrofit.ApiRequest;
import nishkarsh.work.quantumit_task.Retrofit.RetrofitRequest;
import nishkarsh.work.quantumit_task.model.Article;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleRepository {
    private  static final String TAG = ArticleRepository.class.getSimpleName();
    private  final ApiRequest apiRequest;

    public  ArticleRepository(){

        apiRequest= RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);


    }

    public LiveData<ArticleResponse> getDashboardNews(){

        final MutableLiveData<ArticleResponse> data = new MutableLiveData<>();
        apiRequest.getHeadlines().enqueue(new Callback<ArticleResponse>() {
            @Override
            public void onResponse(Call<ArticleResponse> call, Response<ArticleResponse> response) {

                if(response.body()!=null){

                    data.setValue(response.body());
                }
                Log.i("++++repolevel +++ ",response.body().toString()) ;

            }

            @Override
            public void onFailure(Call<ArticleResponse> call, Throwable t) {
                data.setValue(null);



            }
        });
        return data;
    }

}
