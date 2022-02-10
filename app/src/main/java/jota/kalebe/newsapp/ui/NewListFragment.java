package jota.kalebe.newsapp.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import jota.kalebe.newsapp.R;
import jota.kalebe.newsapp.data.FakeDataSource;
import jota.kalebe.newsapp.ui.news.DiffUtilNewsItemCallback;
import jota.kalebe.newsapp.ui.news.NewsListAdapter;


public class NewListFragment extends Fragment {

    RecyclerView recyclerView;
    NewsListAdapter adapter;
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv_list_news);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new NewsListAdapter(new DiffUtilNewsItemCallback());
        recyclerView.setAdapter(adapter);
        // we need a news list data to test the news recycleview
        // I have already created a data class that generate a random List of news item

        FakeDataSource fakeDataSource = new FakeDataSource();
        adapter.submitList(fakeDataSource.getFakeListNews());


        //let's instantiate the swiperefreshlayout we could use view binding, but i will use the classic findviewbyid method
        swipeRefreshLayout = view.findViewById(R.id.news_list_swipe);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // TODO: get the new list of news list will do that when we'll work a real  news api
                //for now i will just simulate a refresh process
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //here we update the news list  with new data
                        //i will just call a helper method to generate a new upload list
                        adapter.submitList(fakeDataSource.getFakeUpdatedStaticListNews());
                        swipeRefreshLayout.setRefreshing(false);
                        // as you can see the list news updated successfully but the recycleview doesn't notify the user about the new data
                        //to do that i will listen for anu data change on the recyclerview and if there is any data added or changed
                        //will scroll the rv to that data item position...

                        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
                            @Override
                            public void onItemRangeInserted(int positionStart, int itemCount) {
                                super.onItemRangeInserted(positionStart, itemCount);
                                recyclerView.smoothScrollToPosition(positionStart);
                                // now everything look great
                            }
                        });

                    }
                }, 1200);
            }
        });
    }

    public NewListFragment() {
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
        return inflater.inflate(R.layout.fragment_new_list, container, false);
    }
}