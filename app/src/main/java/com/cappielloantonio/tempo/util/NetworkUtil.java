package com.cappielloantonio.tempo.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

import com.cappielloantonio.tempo.App;

public class NetworkUtil {
    public static boolean isOffline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager != null) {
            Network network = connectivityManager.getActiveNetwork();

            if (network != null) {
                NetworkCapabilities capabilities = connectivityManager.getNetworkCapabilities(network);

                if (capabilities != null) {
                    return !capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) || !capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
                }
            }
        }

        return true;
    }

    public static boolean isWifi() {
        ConnectivityManager manager = (ConnectivityManager)App.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = manager.getActiveNetwork();
        NetworkCapabilities networkCapabilities = manager.getNetworkCapabilities(network);
        return networkCapabilities != null && networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
    }
}
