package com.ck.namunews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolderPage>{

    private ArrayList<NewsDTO> data;

    public NewsAdapter(ArrayList<NewsDTO> data){
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolderPage onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new ViewHolderPage(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPage holder, int position) {
        if(holder != null){
            holder.onBind(data.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public int getMaxItem(){
        return data.size();
    }

    public static class ViewHolderPage extends RecyclerView.ViewHolder{

        private final TextView textRank;
        private final TextView textTitle;
        private final TextView textWriter;
        private final ImageView imageImage;

        NewsDTO data;

        public ViewHolderPage(@NonNull View itemView) {
            super(itemView);

            this.textRank = itemView.findViewById(R.id.text_ranking);
            this.textTitle = itemView.findViewById(R.id.text_title);
            this.textWriter = itemView.findViewById(R.id.text_writer);
            this.imageImage = itemView.findViewById(R.id.imageView);
        }

        public void onBind(NewsDTO data){
            this.data = data;
            textRank.setText(Integer.toString(data.getRank()));

            textTitle.setText(data.getTitle());

            textWriter.setText(data.getCompany() + "  " + data.getDate());

            int picNum = data.getRank() % 10 ;

            if(picNum <=5 && picNum != 0) {
                Glide.with(itemView.getContext()).load(data.getUrl()).into(imageImage);
                imageImage.setVisibility(View.VISIBLE);
            }
            else{
                imageImage.setVisibility(View.GONE);
            }
        }
    }
}