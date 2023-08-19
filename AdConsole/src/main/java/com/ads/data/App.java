package com.ads.data;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;

import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class App extends Application {
    private static App _instance;
    AppOpen appOpenManager;
    public void onCreate() {
        super.onCreate();
        _instance = this;
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
            }
        });
//        AdSettings.setDataProcessingOptions( new String[] {"LDU"}, 1, 1000 );
        AudienceNetworkAds.initialize(this);
        AppLovinSdk.getInstance(_instance).isInitialized();
        AppLovinSdk.getInstance(_instance).setMediationProvider("max");
        AppLovinSdk.initializeSdk(_instance, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration) {
                // AppLovin SDK is initialized, start loading ads
            }
        });
        appOpenManager = new AppOpen(this);
        if (!AdsControl.isOnline(_instance)) {
            brodCarst(_instance);
        }
    }

    public static synchronized App getInstance() {
        App app;
        synchronized (App.class) {
            app = _instance;
        }
        return app;
    }

    private NetworkChangeReceiver brd;

    public void brodCarst(final Context ctx) {
        try {
            brd = new NetworkChangeReceiver();
            IntentFilter filter = new IntentFilter();
            filter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            ctx.registerReceiver(brd, filter);
        } catch (Exception e) {
        }
    }

    public boolean check;
    private boolean wifinet = false;
    private boolean datanet = false;

    public class NetworkChangeReceiver extends BroadcastReceiver {
        boolean c = true;

        @Override
        public void onReceive(final Context context, final Intent intent) {
            if (c) {
                c = false;
                check = true;
            }
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            @SuppressLint("MissingPermission") NetworkInfo activeNetwork1 = cm.getActiveNetworkInfo();
            if (activeNetwork1 != null) {
                if (activeNetwork1.getType() == ConnectivityManager.TYPE_WIFI) {
                    wifinet = true;
                } else if (activeNetwork1.getType() == ConnectivityManager.TYPE_MOBILE) {
                    datanet = true;
                }
            }
            if (wifinet || datanet) {
                if (AdsControl.isOnline(context)) {
                    check = false;
                    Conts conts = new Conts(context);
                    conts.App_Data();
                }
            }
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}