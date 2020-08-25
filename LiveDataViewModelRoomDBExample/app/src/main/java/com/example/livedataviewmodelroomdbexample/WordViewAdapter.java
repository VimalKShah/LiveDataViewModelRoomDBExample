package com.example.livedataviewmodelroomdbexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordViewAdapter extends RecyclerView.Adapter<WordViewAdapter.WordViewHolder> {

    private List<Word> mWords;

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.words.setText(current.getWord());
        } else {
            // Covers the case of data not being ready yet.
            holder.words.setText("No Word");
        }
    }

    @Override
    public int getItemCount() {
        if(mWords == null) {
            return 0;
        }
        return mWords.size();
    }

    public void setWords(List<Word> words) {
        mWords = words;
        notifyDataSetChanged();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        public TextView words;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            words = itemView.findViewById(R.id.textView);
        }
    }
}
