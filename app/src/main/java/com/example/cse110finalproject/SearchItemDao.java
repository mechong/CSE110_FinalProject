package com.example.cse110finalproject;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SearchItemDao {
    @Insert
    long insert(SearchItem searchListItem);

    @Query("SELECT * FROM `search_items` WHERE `id`+:id")
    SearchItem get(long id);

    @Query("SELECT * FROM `search_items` ORDER BY `order`")
    List<SearchItem> getAll();

    @Update
    int update(SearchItem searchItem);

    @Delete
    int delete(SearchItem searchItem);

    @Insert
    List<Long> insertAll(List<SearchItem> searchItem);

    @Query("SELECT * FROM `search_items` ORDER BY `order`")
    LiveData<List<SearchItem>> getAllLive();
}
