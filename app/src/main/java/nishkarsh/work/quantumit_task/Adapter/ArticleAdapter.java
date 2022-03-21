package nishkarsh.work.quantumit_task.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import nishkarsh.work.quantumit_task.R;
import nishkarsh.work.quantumit_task.model.Article;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    private  final Context context;
    ArrayList<Article> articleArrayList;

    public ArticleAdapter(Context context, ArrayList<Article> articleArrayList) {
        this.context = context;
        this.articleArrayList = articleArrayList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ArticleAdapter.ViewHolder holder, int position) {
        Article article =articleArrayList.get(position);
        System.out.println("++++"+position+"=="+article.getTittle());
        holder.tvTittle.setText(article.getTittle());
        holder.tvTime.setText(article.getPublishedAt());
        holder.desc.setText(article.getDescription());
        Glide.with(context)
                .load(article.getUrlToImage())
                .into(holder.imgv);

    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder {

        private  final ImageView imgv;
        private final TextView tvTittle;
        private final TextView tvTime;
        private  final TextView desc;



        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            imgv= itemView.findViewById(R.id.newsphoto);
            tvTittle=itemView.findViewById(R.id.title);
            tvTime= itemView.findViewById(R.id.time);
            desc= itemView.findViewById(R.id.desc);

        }
    }
}
