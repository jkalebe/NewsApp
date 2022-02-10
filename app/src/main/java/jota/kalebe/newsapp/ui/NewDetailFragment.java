package jota.kalebe.newsapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import jota.kalebe.newsapp.R;
import jota.kalebe.newsapp.data.FakeDataSource;
import jota.kalebe.newsapp.data.NewsItem;
import jota.kalebe.newsapp.databinding.FragmentNewDetailBinding;

public class NewDetailFragment extends Fragment {

    public NewDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        FragmentNewDetailBinding fragmentNewDetailBinding =
                DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.fragment_new_detail, container, false);

        //we can to test if databinding works fine : so we need a news item
        //we can get a random item from the datasource class

        FakeDataSource fakeDataSource = new FakeDataSource();
        NewsItem item = fakeDataSource.generateRandomNewsItem();

        item.setFav(true);

        fragmentNewDetailBinding.setNewsItemData(item);

        return fragmentNewDetailBinding.getRoot();

        //now let's test this out, for now we can't acess this fragment
        //i'll make some changes to navigation graph so i can display this fragment...
    }
}