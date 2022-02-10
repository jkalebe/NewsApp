package jota.kalebe.newsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jota.kalebe.newsapp.R;
import jota.kalebe.newsapp.data.FakeDataSource;
import jota.kalebe.newsapp.ui.news.DiffUtilNewsItemCallback;
import jota.kalebe.newsapp.ui.news.NewsListAdapter;

public class NewFavFragment extends Fragment {

    private RecyclerView rvFav;
    private NewsListAdapter adapter;

    public NewFavFragment() {
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
        return inflater.inflate(R.layout.fragment_new_fav, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initFavList(view);
    }

    private void initFavList(@NonNull View view) {
        rvFav = view.findViewById(R.id.rv_fav);
        rvFav.setLayoutManager(new GridLayoutManager(getContext(), 2));
        rvFav.setHasFixedSize(true);
        adapter = new NewsListAdapter(new DiffUtilNewsItemCallback());
        rvFav.setAdapter(adapter);
        //get a testing news list from the fake data source
        FakeDataSource fakeDataSource = new FakeDataSource();
        adapter.submitList(fakeDataSource.getFakeStaticListNews());
    }
}