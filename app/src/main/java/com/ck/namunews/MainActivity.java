package com.ck.namunews;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String[] category = {"종합", "정치", "경제", "사회", "문화", "세계", "IT/과학"};

    int rank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI newsAPI = retrofit.create(RetrofitAPI.class);

        Call<NewsPojo> call = newsAPI.getNews();
        call.enqueue(new Callback<NewsPojo>() {
            @Override
            public void onResponse(Call<NewsPojo> call, Response<NewsPojo> response) {
                if(response.isSuccessful()){
                    List<NewsDTO> newsList = Arrays.asList(response.body().getItemList());
                    ArrayList<NewsDTO> list = new ArrayList<>(newsList);

                    rank = 1;
                    for(NewsDTO news : list) {
                        news.setRank(rank);
//                        list2.add(rank);
                        rank++;
                    }

                    ViewPager2 viewpager = findViewById(R.id.viewpager);
                    viewpager.setAdapter(new MyPagerAdapter(MainActivity.this, list));
                    viewpager.setPageTransformer(new ZoomOutPageTransformer());

                    MyTabLayout tabs = findViewById(R.id.tabs);

                    new TabLayoutMediator(tabs, viewpager, (tab, position) -> {
                    }).attach();

                    for(int i = 0; i < category.length; i++){
                        tabs.setText(i, category[i]);
                    }

                }
                else{
                    Log.e(TAG, "API 요청 실패 - " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<NewsPojo> call, Throwable t) {
                // 통신 실패 처리 로직 작성
                Log.e(TAG, "API 요청 실패 - " + t.getMessage());
            }
        });


    }
}