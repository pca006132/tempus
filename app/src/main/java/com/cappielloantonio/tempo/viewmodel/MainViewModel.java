package com.cappielloantonio.tempo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.cappielloantonio.tempo.github.models.LatestRelease;
import com.cappielloantonio.tempo.repository.QueueRepository;
import com.cappielloantonio.tempo.repository.SystemRepository;
import com.cappielloantonio.tempo.subsonic.models.OpenSubsonicExtension;
import com.cappielloantonio.tempo.subsonic.models.SubsonicResponse;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.List;
import java.util.Queue;

import io.reactivex.rxjava3.core.Single;

public class MainViewModel extends AndroidViewModel {
    private static final String TAG = "SearchViewModel";

    private final SystemRepository systemRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);

        systemRepository = new SystemRepository();
    }

    public Single<Boolean> isQueueLoaded() {
        return new QueueRepository().count().map(count -> count != 0);
    }

    public LiveData<SubsonicResponse> ping() {
        return systemRepository.ping();
    }

    public LiveData<List<OpenSubsonicExtension>> getOpenSubsonicExtensions() {
        return systemRepository.getOpenSubsonicExtensions();
    }

    public LiveData<LatestRelease> checkTempoUpdate() {
        return systemRepository.checkTempoUpdate();
    }
}
