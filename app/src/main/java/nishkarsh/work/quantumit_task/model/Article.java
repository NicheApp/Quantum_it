package nishkarsh.work.quantumit_task.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Article {
     @SerializedName("urlToImage")
     @Expose
     private String urlToImage;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("title")
    @Expose
    private String tittle;
    @SerializedName("publishedAt")
    @Expose
    private String publishedAt;


    public String getUrlToImage() {
        return urlToImage;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }



    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    @Override
    public  String toString(){
        return "BashboardNews{"+
                "urlToImage='" +urlToImage+'\'' +
                        ",description='" +description+'\'' +
                        ",title='" +tittle+'\'' +
                ",publishedAt'" +publishedAt+'\'' +
                '}';

    }


}
