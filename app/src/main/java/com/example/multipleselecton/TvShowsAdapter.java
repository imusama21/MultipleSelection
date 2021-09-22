package com.example.multipleselecton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class TvShowsAdapter extends RecyclerView.Adapter<TvShowsAdapter.ViewHolder> {

    private List<TvShow> tvShows;
    private TvShowListener tvShowListener;

    public TvShowsAdapter(List<TvShow> tvShows, TvShowListener tvShowListener) {
        this.tvShows = tvShows;
        this.tvShowListener = tvShowListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_tv_show, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindTvShow(tvShows.get(position));
    }

    @Override
    public int getItemCount() {
        return tvShows.size();
    }

    public List<TvShow> getSelectedTvShow() {
        List<TvShow> selectedTvShows = new ArrayList<>();
        for (TvShow tvShow : tvShows) {
            if (tvShow.isSelected) {
                selectedTvShows.add(tvShow);
            }
        }
        return selectedTvShows;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ConstraintLayout layoutTvShow;
        private View viewBackground;
        private RoundedImageView imageTvShow;
        private RatingBar ratingBar;
        private TextView textName, textCreatedBy, textStory;
        private ImageView imageSelected;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            layoutTvShow = itemView.findViewById(R.id.layoutTvShow);
            viewBackground = itemView.findViewById(R.id.viewBackground);
            imageTvShow = itemView.findViewById(R.id.imageTvShow);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            textName = itemView.findViewById(R.id.textName);
            textCreatedBy = itemView.findViewById(R.id.textCreatedBy);
            textStory = itemView.findViewById(R.id.textStory);
            imageSelected = itemView.findViewById(R.id.imageSelected);

        }

        void bindTvShow(final TvShow tvShow) {
            imageTvShow.setImageResource(tvShow.image);
            textName.setText(tvShow.name);
            textCreatedBy.setText(tvShow.createdBy);
            textStory.setText(tvShow.story);
            ratingBar.setRating(tvShow.rating);
            if (tvShow.isSelected) {
                viewBackground.setBackgroundResource(R.drawable.tv_show_selected_background);
                imageSelected.setVisibility(View.VISIBLE);
            } else {
                viewBackground.setBackgroundResource(R.drawable.tv_show_background);
                imageSelected.setVisibility(View.GONE);
            }
            layoutTvShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (tvShow.isSelected) {
                        viewBackground.setBackgroundResource(R.drawable.tv_show_background);
                        imageSelected.setVisibility(View.GONE);
                        tvShow.isSelected = false;
                        if (getSelectedTvShow().size() == 0) {
                            tvShowListener.onTvShowAction(false);
                        }
                    } else {
                        viewBackground.setBackgroundResource(R.drawable.tv_show_selected_background);
                        imageSelected.setVisibility(View.VISIBLE);
                        tvShow.isSelected = true;
                        tvShowListener.onTvShowAction(true);
                    }
                }
            });
        }


    }
}
