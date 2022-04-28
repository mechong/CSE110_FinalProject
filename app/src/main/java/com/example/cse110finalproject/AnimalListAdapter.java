package com.example.cse110finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class AnimalListAdapter extends RecyclerView.Adapter<AnimalListAdapter.ViewHolder> {
    private List<SearchItem> searchItem = Collections.emptyList();

    public void setSearchItem(List<SearchItem> searchItem){
        this.searchItem.clear();
        this.searchItem = searchItem;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setSearchItem(searchItem.get(position));
    }

    @Override
    public int getItemCount() {
        return searchItem.size();
    }

    @Override
    public long getItemId(int position){
        return searchItem.get(position).id;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView textView;
        private final CheckBox checkBox;
        private SearchItem searchItem;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            this.textView = itemView.findViewById(R.id.search_items);
            this.checkBox = itemView.findViewById(R.id.added);
        }

        public void setSearchItem(SearchItem searchItem){
            this.searchItem = searchItem;
            this.checkBox.setChecked(searchItem.completed);
            this.textView.setText(searchItem.text);
        }
    }
}
