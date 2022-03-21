package nishkarsh.work.quantumit_task.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static nishkarsh.work.quantumit_task.Constants.AppConstants.Base_url;

public class RetrofitRequest {

    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(){
        if(retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(Base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

     return  retrofit;
    }


}
