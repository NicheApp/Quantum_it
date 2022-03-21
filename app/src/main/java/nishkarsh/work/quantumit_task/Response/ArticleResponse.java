package nishkarsh.work.quantumit_task.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import nishkarsh.work.quantumit_task.model.Article;

public class ArticleResponse {
    @SerializedName("articles")
    @Expose
    private List<Article> articles;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "NewsResponse{" +
                "articles=" + articles +
                '}';
    }
}
