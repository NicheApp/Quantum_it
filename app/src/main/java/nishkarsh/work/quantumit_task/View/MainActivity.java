package nishkarsh.work.quantumit_task.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import nishkarsh.work.quantumit_task.Adapter.ArticleAdapter;
import nishkarsh.work.quantumit_task.Google_SignIn;
import nishkarsh.work.quantumit_task.R;
import nishkarsh.work.quantumit_task.SIgnIn.SignInActivity;
import nishkarsh.work.quantumit_task.View_model.ArticleViewModel;
import nishkarsh.work.quantumit_task.model.Article;

import static java.lang.String.valueOf;

public class MainActivity extends AppCompatActivity {

ImageView img;
private  static  final String TAG = MainActivity.class.getSimpleName();
private RecyclerView recyclerView;
private ProgressBar progressBar;
private LinearLayoutManager layoutManager;
private ArrayList<Article> articleArrayList =new ArrayList<>();
ArticleViewModel articleViewModel;
private ArticleAdapter articleAdapter;
ImageView Signout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getArticles();
       /* img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Google_SignIn.class));
            }
        });*/
Signout.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("loggedin", "no");
        editor.commit();
        startActivity(new Intent(MainActivity.this, SignInActivity.class));
    }
});

    }

    private void getArticles() {

        articleViewModel.getDahsboardNewsLivedata().observe(this,articleResponse -> {

            if(articleResponse!=null && articleResponse.getArticles()!=null
                    && !articleResponse.getArticles().isEmpty() ){

                progressBar.setVisibility(View.GONE);
                List<Article> articleList =articleResponse.getArticles();
                articleArrayList.addAll(articleList);

                articleAdapter.notifyDataSetChanged();

            }
            else {

            }
        });
    }

    private void init(){

        progressBar =findViewById(R.id.progressbar);
        recyclerView=findViewById(R.id.recycler_view);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        articleAdapter=new ArticleAdapter(MainActivity.this,articleArrayList);
        recyclerView.setAdapter(articleAdapter);
        articleViewModel= ViewModelProviders.of(this).get(ArticleViewModel.class);
        Signout=findViewById(R.id.signout);

}

}