package jota.kalebe.newsapp.ui.news;

import androidx.annotation.NonNull;

import jota.kalebe.newsapp.data.NewsItem;
import jota.kalebe.newsapp.databinding.ItemNewsImageBinding;
import jota.kalebe.newsapp.databinding.ItemNewsTextBinding;

public class ImageViewHolder extends BaseViewHolder{
    ItemNewsImageBinding itemNewsImageBinding;

    public ImageViewHolder(@NonNull ItemNewsImageBinding itemNewsImageBinding) {
        super(itemNewsImageBinding.getRoot());
        this.itemNewsImageBinding = itemNewsImageBinding;
    }

    @Override
    public void bindData(NewsItem item) {

        itemNewsImageBinding.setNewsItemImage(item);

    }

    @Override
    public ItemNewsTextBinding getItemNewsTextBinding() {
        return null;
    }

    @Override
    public ItemNewsImageBinding getItemNewsImageBinding() {
        return null;
    }
}
