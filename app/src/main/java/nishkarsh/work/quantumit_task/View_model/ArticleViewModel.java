package nishkarsh.work.quantumit_task.View_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import nishkarsh.work.quantumit_task.Repository.ArticleRepository;
import nishkarsh.work.quantumit_task.Response.ArticleResponse;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository articleRepository;
    private LiveData<ArticleResponse> articleResponseLiveData;

    public ArticleViewModel(@NonNull Application application) {
        super(application);
        this.articleRepository = new ArticleRepository();
        this.articleResponseLiveData = articleRepository.getDashboardNews();
    }

    public  LiveData<ArticleResponse> getDahsboardNewsLivedata(){
        return  articleResponseLiveData;

    }
}
