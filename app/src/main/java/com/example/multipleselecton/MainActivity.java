package com.example.multipleselecton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TvShowListener {

    private RecyclerView tvShowsRecyclerView;
    private Button buttonAddToWatchList;
    private List<TvShow> tvShows;
    private TvShowsAdapter tvShowsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvShowsRecyclerView = findViewById(R.id.tvShowsRecyclerView);
        buttonAddToWatchList = findViewById(R.id.buttonAddToWatchList);

        tvShows = new ArrayList<>();
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model1, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model2, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model13, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model15, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model16, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model7, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model18, 4.5f));
        tvShows.add(new TvShow("Elyse Perry", "Muhammad Usama", "Ellyse Alexandra Perry is an Australian sportswoman who has represented her country in cricket and association football", R.drawable.model11, 4.5f));
        tvShowsAdapter = new TvShowsAdapter(tvShows, this);
        tvShowsRecyclerView.setAdapter(tvShowsAdapter);
        buttonAddToWatchList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<TvShow> selectedTvShow = tvShowsAdapter.getSelectedTvShow();

                StringBuilder tvShowNames = new StringBuilder();
                for (int i = 0; i < selectedTvShow.size(); i++) {
                    if (i == 0) {
                        tvShowNames.append(selectedTvShow.get(i).name);
                    } else {
                        tvShowNames.append("\n").append(selectedTvShow.get(i).name);
                    }
                }
                Toast.makeText(MainActivity.this, tvShowNames.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onTvShowAction(Boolean isSelected) {
        if (isSelected) {
            buttonAddToWatchList.setVisibility(View.VISIBLE);
        } else {
            buttonAddToWatchList.setVisibility(View.GONE);
        }
    }
}