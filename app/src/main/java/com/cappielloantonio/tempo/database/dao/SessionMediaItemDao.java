package com.cappielloantonio.tempo.database.dao;

import androidx.annotation.OptIn;
import androidx.lifecycle.LiveData;
import androidx.media3.common.util.UnstableApi;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.cappielloantonio.tempo.model.SessionMediaItem;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;

@OptIn(markerClass = UnstableApi.class)
@Dao
public interface SessionMediaItemDao {
    @Query("SELECT * FROM session_media_item WHERE id = :id")
    SessionMediaItem get(String id);

    @Query("SELECT * FROM session_media_item WHERE timestamp = :timestamp")
    List<SessionMediaItem> get(long timestamp);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(SessionMediaItem sessionMediaItem);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<SessionMediaItem> sessionMediaItems);

    @Query("DELETE FROM session_media_item")
    void deleteAll();
}