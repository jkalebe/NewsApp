package jota.kalebe.newsapp.ui.news;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import jota.kalebe.newsapp.data.NewsItem;
import jota.kalebe.newsapp.databinding.ItemNewsImageBinding;
import jota.kalebe.newsapp.databinding.ItemNewsTextBinding;

abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    public abstract void bindData(NewsItem item);

        //we will need these methods for shared view animation purpose
    public abstract ItemNewsTextBinding getItemNewsTextBinding();
    public abstract ItemNewsImageBinding getItemNewsImageBinding();


}
