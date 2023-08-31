package com.ads.data;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.ads.data.Api.APIClient;
import com.ads.data.Api.APIInterface;
import com.ads.data.Api.Data;
import com.ads.data.Api.Recover;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxAppOpenAd;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAd;
import com.google.android.gms.ads.admanager.AdManagerInterstitialAdLoadCallback;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.NativeAd;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiBanner;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.ads.listeners.BannerAdEventListener;
import com.inmobi.ads.listeners.InterstitialAdEventListener;
import com.wortise.ads.WortiseSdk;
import com.wortise.ads.banner.BannerAd;
import com.wortise.ads.natives.GoogleNativeAd;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;

public class AdsControl {
    @SuppressLint("StaticFieldLeak")
    private static AdsControl mInstance;
    @SuppressLint("StaticFieldLeak")
    static Context activity;
    // Banner
    public static boolean isGoogleBannerLoaded;
    public static boolean isAdxBannerLoaded;
    public static boolean isFBBannerLoaded;
    public static boolean isApplovinBannerLoaded;
    public static boolean isWortiseBannerLoaded;
    public static boolean isInmobiBannerLoaded;
    public static AdView googleBannerAd;
    public static AdManagerAdView adxBannerAd;
    public static com.facebook.ads.AdView fbadView;
    @SuppressLint("StaticFieldLeak")
    public static MaxAdView applovin_banner_ad;
    public static BannerAd wBannerAd;
    public static InMobiBanner InmobiBannerAd;

    // Mediam Ragtangal
    public static boolean isAdmob_Mediam_Ragtangal_Loaded;
    public static boolean isAdx_Mediam_Ragtangal_Loaded;
    public static boolean isFB_Mediam_Ragtangal_Loaded;
    public static boolean isApplovin_Mediam_Ragtangal_Loaded;
    public static boolean isWortise_medium_ragtangal_Loaded;
    public static AdView admobMediam_Ragtangal;
    public static AdManagerAdView adxMediam_Ragtangal;
    public static com.facebook.ads.AdView fb_Ragtangal_adView;
    @SuppressLint("StaticFieldLeak")
    public static MaxAdView applovin_Medium_Ragtangal_adview;
    public static BannerAd w_medium_ragtangal;

    // Native Ad
    public static boolean isadmob_native_Loaded;
    public static boolean isadx_native_Loaded;
    public static boolean isFB_Native_Loaded;
    public static boolean isApplovin_Native_Loaded;
    public static boolean isWortise_Native_Loaded;
    public static boolean isLocal_Native_Loaded;
    public static NativeAd Admob_native_Ad;
    public static NativeAd Adx_native_Ad;
    public static com.facebook.ads.NativeAd fb_native_Ad;
    public static MaxAd Applovin_native_ad;
    @SuppressLint("StaticFieldLeak")
    public static MaxNativeAdView applovin_maxnativeadview;
    public static NativeAd wortise_native_Ad;
    @SuppressLint("StaticFieldLeak")
    public static GoogleNativeAd wortise_google_native_Ad;

    // Small Native Ad
    public static boolean isAdmob_small_native_Loaded;
    public static boolean isadx_small_native_Loaded;
    public static boolean isFb_small_native_Loaded;
    public static boolean isapplovin_small_native_Loaded;
    public static boolean isWortise_small_Native_Loaded;
    public static boolean isLocal_small_Native_Loaded;
    public static NativeAd Admob_small_native_Ad;
    public static NativeAd Adx_small_native_Ad;
    public static NativeBannerAd fb_small_native_Ad;
    public static MaxAd Applovin_small_native_Ad;
    @SuppressLint("StaticFieldLeak")
    public static MaxNativeAdView applovin_small_native_Ad;
    public static NativeAd wortise_small_native_Ad;
    @SuppressLint("StaticFieldLeak")
    public static GoogleNativeAd wortise_google_small_native_Ad;

    // Small Naitive Banner Ad
    public static boolean isadmob_small_native_banner_Loaded;
    public static boolean isadx_small_native_banner_Loaded;
    public static boolean isFB_small_native_banner_Loaded;
    public static boolean isApplovin_small_native_banner_Loaded;
    public static boolean isWortise_small_Native_banner_Loaded;
    public static boolean isLocal_small_Native_banner_Loaded;
    public static NativeAd Admob_small_native_banner_Ad;
    public static NativeAd Adx_small_native_banner_Ad;
    public static NativeBannerAd fb_small_native_banner_Ad;
    public static MaxAd Applovin_small_native_banner_Ad;
    @SuppressLint("StaticFieldLeak")
    public static MaxNativeAdView applovin_small_native_banner_Ad;
    public static NativeAd wortise_small_native_banner_Ad;
    @SuppressLint("StaticFieldLeak")
    public static GoogleNativeAd wortise_small_google_native_banner_Ad;

    // Inter
    private boolean isGoogleInterLoaded;
    private boolean isAdxInterLoaded;
    private boolean isFBInterLoaded;
    private boolean isApplovinInterLoaded;
    private boolean isWortiseInterLoaded;
    private boolean isInmobiInterLoaded;
    private boolean isLocalInterLoaded;
    InterstitialAd ADMOBInterstitialAd;
    AdManagerInterstitialAd ADXInterstitialAd;
    com.facebook.ads.InterstitialAd FB_interstitialAd;
    MaxInterstitialAd Applovin_maxInterstitialAd;
    com.wortise.ads.interstitial.InterstitialAd Wortise_inter;
    InMobiInterstitial Inmobi_inter;

    // Appopen
    public static boolean isadmob_appopen_Loaded;
    public static boolean isadx_appopen_Loaded;
    public static boolean iswortise_appopen_Loaded;
    public static boolean isapplovin_appopen_Loaded;
    public static boolean islocal_appopen_Loaded;
    com.wortise.ads.appopen.AppOpenAd wortise_open;
    MaxAppOpenAd applovin_appopen;
    AppOpenAd admob_appOpenAd_inter;
    AppOpenAd adx_appOpenAd_inter;
    AppOpenAd admob_appOpenAd;
    AppOpenAd adx_appOpenAd;

    private int adCounter;
    SharedPreferences prefs;

    public AdsControl(Context context) {
        activity = context;
        prefs = activity.getSharedPreferences(activity.getPackageName(), 0);
    }

    public static AdsControl getInstance(Context context) {
        activity = context;
        if (mInstance == null) {
            mInstance = new AdsControl(context);
        }
        return mInstance;
    }

    public static boolean isOnline(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        @SuppressLint("MissingPermission") NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    // --------------------------------------------------- Service -----------------------------------------------------------

    // TODO: 7/17/2023 Main Service Call
    public static ArrayList<Data> app_data = new ArrayList<>();

    @SuppressLint("ObsoleteSdkInt")
    public void init(final Activity activity, String packagename, String Service, getDataListner Callback) {
        boolean isBeingDebugged = Settings.Secure.getInt(activity.getContentResolver(), Settings.Global.ADB_ENABLED, 0) == 1;
        if (isNetworkAvailable()) {
            try {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
                    Call<Recover> call1 = apiInterface.getadsdetail(packagename, Service);
                    call1.enqueue(new retrofit2.Callback<>() {
                        @Override
                        public void onResponse(@NotNull Call<Recover> call, @NotNull retrofit2.Response<Recover> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                if (response.body().getData() != null) {
                                    app_data.clear();
                                    Log.d("Diyora", "Parth_Diyora " + response.body().getData());
                                    app_data.addAll(response.body().getData());
                                    WortiseSdk.initialize(activity, app_data.get(0).getWortiseAppId());
                                    String ridirect_app = app_data.get(0).getRedirectApp();
                                    if (!ridirect_app.equalsIgnoreCase("")) {
                                        activity.startActivity(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://play.google.com/store/apps/details?id=" + ridirect_app)));
                                    } else {
                                        if (app_data.get(0).isVpn_option()) {
                                            Conts conts = new Conts(activity);
                                            conts.check_VPN_App(activity, () -> {
                                                if (isBeingDebugged && app_data.get(0).isDev_option()) {
                                                    Conts conts1 = new Conts(activity);
                                                    conts1.Debugging(() -> preload_ads_call(Callback));
                                                } else {
                                                    preload_ads_call(Callback);
                                                }
                                            });
                                        } else {
                                            if (isBeingDebugged && app_data.get(0).isDev_option()) {
                                                Conts conts1 = new Conts(activity);
                                                conts1.Debugging(() -> preload_ads_call(Callback));
                                            } else {
                                                preload_ads_call(Callback);
                                            }
                                        }
                                    }
                                } else {
                                    preload_ads_call(Callback);
                                    Toast.makeText(activity, "Server not Response", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(@NonNull Call<Recover> call, @NonNull Throwable t) {
                            call.cancel();
                            preload_ads_call(Callback);
                        }
                    });
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            Conts conts = new Conts(activity);
            conts.App_Data(activity, packagename, Service);
        } else {
            Conts conts = new Conts(activity);
            conts.networkinfo();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    // TODO: 8/29/2023  Preload ads
    private void preload_ads_call(getDataListner myCallback) {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).isAds_show()) {
                if (app_data.get(0).isPreload_native_ads()) {
                    if (app_data.get(0).getAd_native_type().equalsIgnoreCase("mrec")) {
                        medium_rect_Ads();
                    } else {
                        native_Ads();
                    }
                    small_native_banner_Ads();
                    small_native_Ads();
                }
                if (app_data.get(0).isPreload_inter_ads()) {
                    if (app_data.get(0).getAd_inter_type().equalsIgnoreCase("appopen")) {
                        appopen_Ads();
                    } else {
                        inter_Ads();
                    }
                }
                if (app_data.get(0).isPreload_banner_ads()) {
                    banner_Ads();
                }
                call(myCallback);
            } else {
                call(myCallback);
            }
        } else {
            call(myCallback);
        }
    }

    // TODO: 7/17/2023 Call Intent
    private void call(getDataListner myCallback) {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String adnetwork = app_data.get(0).getAdSplash();
                    switch (adnetwork) {
                        case "native":
                            new Handler().postDelayed(() -> open_native(myCallback), 3000);
                            break;
                        case "inter":
                            AdsControl.getInstance(activity).show_splash_inter(() -> Next_Call(myCallback));
                            break;
                        case "admob":
                            AdsControl.getInstance(activity).show_Admob_Appopen(() -> Next_Call(myCallback));
                            break;
                        case "adx":
                            AdsControl.getInstance(activity).show_Adx_Appopen(() -> Next_Call(myCallback));
                            break;
                        case "applovin":
                            AdsControl.getInstance(activity).show_Applovin_Appopen(() -> Next_Call(myCallback));
                            break;
                        case "wortise":
                            AdsControl.getInstance(activity).show_Wortise_Appopen(() -> Next_Call(myCallback));
                            break;
                        case "local":
                            AdsControl.getInstance(activity).show_local_Appopen(() -> Next_Call(myCallback));
                            break;
                        case "off":
                            Next_Call(myCallback);
                            break;
                        default:
                    }
                } else {
                    Next_Call(myCallback);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // TODO: 7/17/2023  Open Native Dialog Ads
    Dialog ad_dialog;

    private void open_native(getDataListner callback) {
        Dialog dialog = new Dialog(activity);
        ad_dialog = dialog;
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        this.ad_dialog.setContentView(R.layout.open_native);
        AdsControl.getInstance(activity).show_native_ad(dialog.findViewById(R.id.ad_native));
        ImageView continuee = ad_dialog.findViewById(R.id.continuee);
        new Handler().postDelayed(() -> {
            continuee.setVisibility(View.VISIBLE);
            continuee.setOnClickListener(v -> {
                ad_dialog.dismiss();
                secound_splash_Ads(callback);
            });
        }, 2500);
        this.ad_dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(this.ad_dialog.getWindow()).setSoftInputMode(3);
        this.ad_dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        this.ad_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.ad_dialog.show();
    }

    private void secound_splash_Ads(getDataListner callback2) {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String adnetwork = app_data.get(0).getAd_secound_splash();
                    switch (adnetwork) {
                        case "inter":
                            AdsControl.getInstance(activity).show_splash_inter(() -> Next_Call(callback2));
                            break;
                        case "admob":
                            AdsControl.getInstance(activity).show_Admob_Appopen(() -> Next_Call(callback2));
                            break;
                        case "adx":
                            AdsControl.getInstance(activity).show_Adx_Appopen(() -> Next_Call(callback2));
                            break;
                        case "applovin":
                            AdsControl.getInstance(activity).show_Applovin_Appopen(() -> Next_Call(callback2));
                            break;
                        case "wortise":
                            AdsControl.getInstance(activity).show_Wortise_Appopen(() -> Next_Call(callback2));
                            break;
                        case "local":
                            AdsControl.getInstance(activity).show_local_Appopen(() -> Next_Call(callback2));
                            break;
                        case "off":
                            Next_Call(callback2);
                            break;
                        default:
                    }
                } else {
                    Next_Call(callback2);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void Next_Call(getDataListner myCallback) {
        new Handler().postDelayed(myCallback::onSuccess, 2500);
    }

    //-------------------------------------------------------- Banner Ads -------------------------------------------------------

    // TODO: 7/31/2023  Preload Banner Ads
    int ad_banner_network = 0;

    public void banner_Ads() {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAdBanner().split(",");
                    if (ad_banner_network < adnetwork.length) {
                        switch (adnetwork[ad_banner_network]) {
                            case "admob":
                                if (app_data.get(0).getAdmobBannerid().size() > 0) {
                                    preloadBannerAd_Admob();
                                }
                                ad_banner_network++;
                                break;
                            case "adx":
                                if (app_data.get(0).getAdxBannerId().size() > 0) {
                                    preloadBannerAd_Adx();
                                }
                                ad_banner_network++;
                                break;
                            case "fb":
                                if (app_data.get(0).getFbBannerId().size() > 0) {
                                    preloadBannerAd_FB();
                                }
                                ad_banner_network++;
                                break;
                            case "applovin":
                                if (app_data.get(0).getApplovin_banner_id().size() > 0) {
                                    preloadBannerAd_Applovin();
                                }
                                ad_banner_network++;
                                break;
                            case "wortise":
                                if (app_data.get(0).getWortiseBannerId().size() > 0) {
                                    preloadBannerAd_Wortise();
                                }
                                ad_banner_network++;
                                break;
                            case "inmobi":
                                if (app_data.get(0).getInmobi_banner_id().size() > 0) {
                                    preloadBannerAd_Inmobi();
                                }
                                ad_banner_network++;
                                break;
                            default:
                        }
                        if (ad_banner_network == adnetwork.length) {
                            ad_banner_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int current_admob_BannerId = 0;
    int current_adx_BannerId = 0;
    int current_fb_BannerId = 0;
    int current_applovin_BannerId = 0;
    int current_wortise_BannerId = 0;
    int current_inmobi_BannerId = 0;

    // Admob Mode
    @SuppressLint("MissingPermission")
    void preloadBannerAd_Admob() {
        if (app_data != null && app_data.size() > 0) {
            if (isGoogleBannerLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobBannerid().get(current_admob_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final AdView admob_Banner = new AdView(activity);
                admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                admob_Banner.setAdUnitId(placementId);
                AdRequest adRequest = new AdRequest.Builder().build();
                admob_Banner.loadAd(adRequest);
                admob_Banner.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        Log.d("Parth", "Admob Banner Loadedd ");
                        googleBannerAd = admob_Banner;
                        isGoogleBannerLoaded = true;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        super.onAdFailedToLoad(adError);
                        Log.d("Parth", "Admob Banner Failed" + adError.getMessage());
                        banner_Ads();
                    }
                });
                current_admob_BannerId++;
                if (current_admob_BannerId == app_data.get(0).getAdmobBannerid().size()) {
                    current_admob_BannerId = 0;
                }
            }
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    void preloadBannerAd_Adx() {
        if (app_data != null && app_data.size() > 0) {
            if (isAdxBannerLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxBannerId().get(current_adx_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                adx_Banner.setAdUnitId(placementId);
                @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                adx_Banner.loadAd(adRequest);
                adx_Banner.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.d("Parth", "Adx Banner Loadedd ");
                        adxBannerAd = adx_Banner;
                        isAdxBannerLoaded = true;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Banner Failed" + loadAdError.getMessage());
                        banner_Ads();
                    }
                });
                current_adx_BannerId++;
                if (current_adx_BannerId == app_data.get(0).getAdxBannerId().size()) {
                    current_adx_BannerId = 0;
                }
            }
        }
    }

    // FB Mode
    void preloadBannerAd_FB() {
        if (app_data != null && app_data.size() > 0) {
            if (isFBBannerLoaded) {
                return;
            }
            String placementId = app_data.get(0).getFbBannerId().get(current_fb_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, placementId, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "Fb Banner Loadedd ");
                        fbadView = fb_banner;
                        isFBBannerLoaded = true;
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Banner Failed" + adError.getErrorMessage());
                        banner_Ads();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };
                fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
                current_fb_BannerId++;
                if (current_fb_BannerId == app_data.get(0).getFbBannerId().size()) {
                    current_fb_BannerId = 0;
                }
            }
        }
    }

    // Applovin Mode
    void preloadBannerAd_Applovin() {
        if (app_data != null && app_data.size() > 0) {
            if (isApplovinBannerLoaded) {
                return;
            }
            String placementId = app_data.get(0).getApplovin_banner_id().get(current_applovin_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final MaxAdView applo_banner_ad = new MaxAdView(placementId, activity);
                applo_banner_ad.setLayoutParams(new ViewGroup.LayoutParams(320, 50));
                applo_banner_ad.setListener(new MaxAdViewAdListener() {
                    @Override
                    public void onAdExpanded(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdCollapsed(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdLoaded(MaxAd maxAd) {
                        Log.d("Parth", "Applovin Banner Loadedd ");
                        applovin_banner_ad = applo_banner_ad;
                        isApplovinBannerLoaded = true;
                    }

                    @Override
                    public void onAdDisplayed(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdHidden(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdClicked(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdLoadFailed(String s, MaxError maxError) {
                        Log.d("Parth", "Applovin Banner Failed" + maxError.getMessage());
                        banner_Ads();
                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                    }
                });
                applo_banner_ad.loadAd();
                current_applovin_BannerId++;
                if (current_applovin_BannerId == app_data.get(0).getApplovin_banner_id().size()) {
                    current_applovin_BannerId = 0;
                }
            }
        }
    }

    // Wortise Mode
    void preloadBannerAd_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            if (isWortiseBannerLoaded) {
                return;
            }
            String placementId = app_data.get(0).getWortiseBannerId().get(current_wortise_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final BannerAd wortise_BannerAd = new BannerAd(activity);
                wortise_BannerAd.setAdSize(com.wortise.ads.AdSize.HEIGHT_50);
                wortise_BannerAd.setAdUnitId(placementId);
                wortise_BannerAd.loadAd();
                wortise_BannerAd.setListener(new BannerAd.Listener() {
                    @Override
                    public void onBannerLoaded(@NonNull BannerAd bannerAd) {
                        Log.d("Parth", "Wortise Banner Loadedd ");
                        wBannerAd = wortise_BannerAd;
                        isWortiseBannerLoaded = true;
                    }

                    @Override
                    public void onBannerClicked(@NonNull BannerAd bannerAd) {
                    }

                    @Override
                    public void onBannerFailed(@NonNull BannerAd bannerAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise banner Failed " + adError);
                        banner_Ads();
                    }
                });
                current_wortise_BannerId++;
                if (current_wortise_BannerId == app_data.get(0).getWortiseBannerId().size()) {
                    current_wortise_BannerId = 0;
                }
            }
        }
    }

    // Inmobi Mode
    void preloadBannerAd_Inmobi() {
        if (app_data != null && app_data.size() > 0) {
            if (isInmobiBannerLoaded) {
                return;
            }
            Long placementId = app_data.get(0).getInmobi_banner_id().get(current_inmobi_BannerId);
            if (!(placementId == 0)) {
                final InMobiBanner inMobiBanner = new InMobiBanner(activity, placementId);
                inMobiBanner.setBannerSize(320, 50);
                inMobiBanner.load();

                inMobiBanner.setListener(new BannerAdEventListener() {
                    @Override
                    public void onAdFetchFailed(@NonNull InMobiBanner inMobiBanner, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                        super.onAdFetchFailed(inMobiBanner, inMobiAdRequestStatus);

                    }

                    public void onAdLoadFailed(@NonNull InMobiBanner inMobiBanner, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                        super.onAdLoadFailed(inMobiBanner, inMobiAdRequestStatus);
                        Log.d("Parth", "Inmobi banner Failed: " + inMobiAdRequestStatus.getMessage());
                        banner_Ads();
                    }

                    @Override
                    public void onAdFetchSuccessful(@NonNull InMobiBanner inMobiBanner, @NonNull AdMetaInfo adMetaInfo) {
                        super.onAdFetchSuccessful(inMobiBanner, adMetaInfo);
                    }

                    @Override
                    public void onAdLoadSucceeded(@NonNull InMobiBanner inMobiBanner, @NonNull AdMetaInfo adMetaInfo) {
                        super.onAdLoadSucceeded(inMobiBanner, adMetaInfo);
                        Log.d("Parth", "Inmobi banner loaded");
                        InmobiBannerAd = inMobiBanner;
                        isInmobiBannerLoaded = true;
                    }
                });
                current_inmobi_BannerId++;
                if (current_inmobi_BannerId == app_data.get(0).getInmobi_banner_id().size()) {
                    current_inmobi_BannerId = 0;
                }
            }
        }
    }

    // TODO: 7/17/2023  Show Banner Ads
    @SuppressLint("MissingPermission")
    public void show_banner_ad(final ViewGroup banner_container) {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).isAds_show()) {
                if (app_data.get(0).isPreload_banner_ads()) {
                    if (isGoogleBannerLoaded) {
                        try {
                            if (googleBannerAd.getParent() != null) {
                                ((ViewGroup) googleBannerAd.getParent()).removeView(googleBannerAd);
                            }
                            banner_container.addView(googleBannerAd);
                            AdsControl.isGoogleBannerLoaded = false;
                            banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isAdxBannerLoaded) {
                        try {
                            try {
                                if (adxBannerAd.getParent() != null) {
                                    ((ViewGroup) adxBannerAd.getParent()).removeView(adxBannerAd);
                                }
                                banner_container.addView(adxBannerAd);
                                AdsControl.isAdxBannerLoaded = false;
                                banner_Ads();
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isFBBannerLoaded) {
                        try {
                            if (fbadView.getParent() != null) {
                                ((ViewGroup) fbadView.getParent()).removeView(fbadView);
                            }
                            banner_container.addView(fbadView);
                            AdsControl.isFBBannerLoaded = false;
                            banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isApplovinBannerLoaded) {
                        try {
                            if (applovin_banner_ad.getParent() != null) {
                                ((ViewGroup) applovin_banner_ad.getParent()).removeView(applovin_banner_ad);
                            }
                            banner_container.addView(applovin_banner_ad);
                            AdsControl.isApplovinBannerLoaded = false;
                            banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isWortiseBannerLoaded) {
                        try {
                            if (wBannerAd.getParent() != null) {
                                ((ViewGroup) wBannerAd.getParent()).removeView(wBannerAd);
                            }
                            banner_container.addView(wBannerAd);
                            AdsControl.isWortiseBannerLoaded = false;
                            banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isInmobiBannerLoaded) {
                        try {
                            if (InmobiBannerAd.getParent() != null) {
                                ((ViewGroup) InmobiBannerAd.getParent()).removeView(InmobiBannerAd);
                            }
                            banner_container.addView(InmobiBannerAd);
                            AdsControl.isInmobiBannerLoaded = false;
                            banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    banner_Ads();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (isGoogleBannerLoaded) {
                                try {
                                    if (googleBannerAd.getParent() != null) {
                                        ((ViewGroup) googleBannerAd.getParent()).removeView(googleBannerAd);
                                    }
                                    banner_container.addView(googleBannerAd);
                                    AdsControl.isGoogleBannerLoaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isAdxBannerLoaded) {
                                try {
                                    try {
                                        if (adxBannerAd.getParent() != null) {
                                            ((ViewGroup) adxBannerAd.getParent()).removeView(adxBannerAd);
                                        }
                                        banner_container.addView(adxBannerAd);
                                        AdsControl.isAdxBannerLoaded = false;
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isFBBannerLoaded) {
                                try {
                                    if (fbadView.getParent() != null) {
                                        ((ViewGroup) fbadView.getParent()).removeView(fbadView);
                                    }
                                    banner_container.addView(fbadView);
                                    AdsControl.isFBBannerLoaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isApplovinBannerLoaded) {
                                try {
                                    if (applovin_banner_ad.getParent() != null) {
                                        ((ViewGroup) applovin_banner_ad.getParent()).removeView(applovin_banner_ad);
                                    }
                                    banner_container.addView(applovin_banner_ad);
                                    AdsControl.isApplovinBannerLoaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isWortiseBannerLoaded) {
                                try {
                                    if (wBannerAd.getParent() != null) {
                                        ((ViewGroup) wBannerAd.getParent()).removeView(wBannerAd);
                                    }
                                    banner_container.addView(wBannerAd);
                                    AdsControl.isWortiseBannerLoaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isInmobiBannerLoaded) {
                                try {
                                    if (InmobiBannerAd.getParent() != null) {
                                        ((ViewGroup) InmobiBannerAd.getParent()).removeView(InmobiBannerAd);
                                    }
                                    banner_container.addView(InmobiBannerAd);
                                    AdsControl.isInmobiBannerLoaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }, 3000);
                }
            }
        }
    }

    //---------------------------------------------Small Native banner type Ads ----------------------------------------------

    // TODO: 7/17/2023  Preload Small NAtive Banner Ads
    int ad_small_native_banner_network = 0;

    public void small_native_banner_Ads() {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAdSmallNativeBanner().split(",");
                    if (ad_small_native_banner_network < adnetwork.length) {
                        switch (adnetwork[ad_small_native_banner_network]) {
                            case "admob":
                                if (app_data.get(0).getAdmobNativeid().size() > 0) {
                                    preload_Admob_Native_Banner_Ad();
                                }
                                ad_small_native_banner_network++;
                                break;
                            case "adx":
                                if (app_data.get(0).getAdxNativeId().size() > 0) {
                                    preload_Adx_Native_Banner();
                                }
                                ad_small_native_banner_network++;
                                break;
                            case "fb":
                                if (app_data.get(0).getFbNativeBannerId().size() > 0) {
                                    preload_Fb_Native_BannerAd();
                                }
                                ad_small_native_banner_network++;
                                break;
                            case "applovin":
                                if (app_data.get(0).getApplovin_small_native_bannerid().size() > 0) {
                                    preload_Applovin_Native_BannerAd();
                                }
                                ad_small_native_banner_network++;
                                break;
                            case "wortise":
                                if (app_data.get(0).getWortiseNativeId().size() > 0) {
                                    preload_Wortise_Native_BannerAd();
                                }
                                ad_small_native_banner_network++;
                                break;
                            case "local":
                                preload_Local_Native_BannerAd();
                                ad_small_native_banner_network++;
                                break;
                            default:
                        }
                        if (ad_small_native_banner_network == adnetwork.length) {
                            ad_small_native_banner_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int current_admob_small_native_BannerId = 0;
    int current_adx_small_native_BannerId = 0;
    int current_fb_small_native_BannerId = 0;
    int current_applovin_small_native_BannerId = 0;
    int current_wortise_small_native_BannerId = 0;

    // Admob Mode
    void preload_Admob_Native_Banner_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isadmob_small_native_banner_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobNativeid().get(current_admob_small_native_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final AdLoader.Builder builder = new AdLoader.Builder(activity, placementId);
                builder.forNativeAd(nativeAd -> {
                    Admob_small_native_banner_Ad = nativeAd;
                    isadmob_small_native_banner_Loaded = true;
                    Log.d("Parth", "Admob Small Native Banner Ad Loaded");
                });
                builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Small Native Banner Ad Failed");
                        small_native_banner_Ads();
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                }).build().loadAd(new AdRequest.Builder().build());
                current_admob_small_native_BannerId++;
                if (current_admob_small_native_BannerId == app_data.get(0).getAdmobNativeid().size()) {
                    current_admob_small_native_BannerId = 0;
                }
            }
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    void preload_Adx_Native_Banner() {
        if (app_data != null && app_data.size() > 0) {
            if (isadx_small_native_banner_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxNativeId().get(current_adx_small_native_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final AdLoader.Builder builder = new AdLoader.Builder(activity, placementId);
                builder.forNativeAd(nativeAd -> {
                    Log.d("Parth", "Adx Small Native Banner Ad Loaded");
                    Adx_small_native_banner_Ad = nativeAd;
                    isadx_small_native_banner_Loaded = true;

                });
                builder.withAdListener(new AdListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Small Native Banner Ad Failed");
                        small_native_banner_Ads();
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                }).build().loadAd(new AdManagerAdRequest.Builder().build());
                current_adx_small_native_BannerId++;
                if (current_adx_small_native_BannerId == app_data.get(0).getAdxNativeId().size()) {
                    current_adx_small_native_BannerId = 0;
                }
            }
        }
    }

    // FB Mode
    void preload_Fb_Native_BannerAd() {
        if (app_data != null && app_data.size() > 0) {
            if (isFB_small_native_banner_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getFbNativeBannerId().get(current_fb_small_native_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final NativeBannerAd fb_nativeBanner_Ad = new NativeBannerAd(activity, placementId);
                NativeAdListener nativeAdListener = new NativeAdListener() {
                    @Override
                    public void onMediaDownloaded(Ad ad) {
                        Log.d("Parth", "FB Native ad finished downloading all assets.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Native ad failed to load: " + adError.getErrorMessage());
                        small_native_banner_Ads();
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "FB Native Banner ad is loaded");
                        fb_small_native_banner_Ad = fb_nativeBanner_Ad;
                        isFB_small_native_banner_Loaded = true;

                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        Log.d("Parth", "FB Native ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        Log.d("Parth", "FB Native ad impression logged!");
                    }
                };
                // Request an ad
                fb_nativeBanner_Ad.loadAd(fb_nativeBanner_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                current_fb_small_native_BannerId++;
                if (current_fb_small_native_BannerId == app_data.get(0).getFbNativeBannerId().size()) {
                    current_fb_small_native_BannerId = 0;
                }
            }
        }
    }

    // Applovin Mode
    void preload_Applovin_Native_BannerAd() {
        if (app_data != null && app_data.size() > 0) {
            if (isApplovin_small_native_banner_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getApplovin_small_native_bannerid().get(current_applovin_small_native_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(placementId, activity);
                nativeAdLoader.setRevenueListener(ad -> {
                });
                nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                    @Override
                    public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                        Log.d("Parth", "Applovin Small Native Banner ad Loaded");
                        applovin_small_native_banner_Ad = nativeAdView;
                        Applovin_small_native_banner_Ad = ad;
                        isApplovin_small_native_banner_Loaded = true;
                    }

                    @Override
                    public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                        Log.d("Parth", "Applovin Small Native Banner ad Failed " + error.getMessage());
                        small_native_banner_Ads();
                    }

                    @Override
                    public void onNativeAdClicked(final MaxAd ad) {
                    }
                });
                nativeAdLoader.loadAd(new NativeAds(activity).create_Small_Native_Banner_AdView());
                current_applovin_small_native_BannerId++;
                if (current_applovin_small_native_BannerId == app_data.get(0).getApplovin_small_native_bannerid().size()) {
                    current_applovin_small_native_BannerId = 0;
                }
            }
        }
    }

    // Wortise Mode
    void preload_Wortise_Native_BannerAd() {
        if (app_data != null && app_data.size() > 0) {
            if (isWortise_small_Native_banner_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getWortiseNativeId().get(current_wortise_small_native_BannerId);
            if (!placementId.equalsIgnoreCase("")) {
                final GoogleNativeAd wortise_google_native_banner = new GoogleNativeAd(activity, placementId, new GoogleNativeAd.Listener() {
                    @Override
                    public void onNativeClicked(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeFailed(@NonNull GoogleNativeAd googleNativeAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Small Native Banner Ad Failed");
                        small_native_banner_Ads();
                    }

                    @Override
                    public void onNativeImpression(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeLoaded(@NonNull GoogleNativeAd googleNativeAd, @NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Wortise Small Naive Banner Loaded");
                        wortise_small_google_native_banner_Ad = googleNativeAd;
                        wortise_small_native_banner_Ad = nativeAd;
                        isWortise_small_Native_banner_Loaded = true;

                    }
                });
                wortise_google_native_banner.load();
                current_wortise_small_native_BannerId++;
                if (current_wortise_small_native_BannerId == app_data.get(0).getWortiseNativeId().size()) {
                    current_wortise_small_native_BannerId = 0;
                }
            }
        }
    }

    // Local Mode
    void preload_Local_Native_BannerAd() {
        if (isLocal_small_Native_banner_Loaded) {
            return;
        }
        isLocal_small_Native_banner_Loaded = true;
    }

    @SuppressLint("SetTextI18n")
    void show_local_native_banner_ad(ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            RelativeLayout custm_native = native_banner_ad.findViewById(R.id.custm_native_ad);
            ImageView app_icon_native = native_banner_ad.findViewById(R.id.ad_app_icon);
            TextView app_name_native = native_banner_ad.findViewById(R.id.ad_headline);
            TextView app_ad_body = native_banner_ad.findViewById(R.id.ad_body);
            TextView ad_call_to_action = native_banner_ad.findViewById(R.id.ad_call_to_action);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(app_icon_native);
                app_name_native.setText(app_data.get(0).getNew_app_name());
                app_name_native.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                ad_call_to_action.setText("Install");
            } catch (Exception ignored) {
            }
            custm_native.setOnClickListener(view -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // TODO: 7/17/2023 Show Small Native Banner Ads
    public void show_small_native_banner_ad(final ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).isAds_show()) {
                if (app_data.get(0).isPreload_native_ads()) {
                    if (isadmob_small_native_banner_Loaded) {
                        new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Admob_small_native_banner_Ad, native_banner_ad);
                        Log.d("Parth", "Admob Native Banner ad show");
                        AdsControl.isadmob_small_native_banner_Loaded = false;
                        small_native_banner_Ads();
                    } else if (isadx_small_native_banner_Loaded) {
                        new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Adx_small_native_banner_Ad, native_banner_ad);
                        Log.d("Parth", "Adx Native Banner ad show");
                        AdsControl.isadx_small_native_banner_Loaded = false;
                        small_native_banner_Ads();
                    } else if (isFB_small_native_banner_Loaded) {
                        new NativeAds(activity).FB_Smalle_Native_Banner(AdsControl.fb_small_native_banner_Ad, native_banner_ad);
                        Log.d("Parth", "FB Native Banner ad show");
                        AdsControl.isFB_small_native_banner_Loaded = false;
                        small_native_banner_Ads();
                    } else if (isApplovin_small_native_banner_Loaded) {
                        if (Applovin_small_native_banner_Ad != null) {
                            native_banner_ad.removeAllViews();
                        }
                        native_banner_ad.removeAllViews();
                        native_banner_ad.addView(applovin_small_native_banner_Ad);
                        Log.d("Parth", "Applovin Native Banner ad show");
                        AdsControl.isApplovin_small_native_banner_Loaded = false;
                        small_native_banner_Ads();
                    } else if (isWortise_small_Native_banner_Loaded) {
                        new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.wortise_small_native_banner_Ad, native_banner_ad);
                        Log.d("Parth", "Wortise Native Banner ad show");
                        AdsControl.isWortise_small_Native_banner_Loaded = false;
                        small_native_banner_Ads();
                    } else if (isLocal_small_Native_banner_Loaded) {
                        @SuppressLint("InflateParams") ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.local_small_native_banner, null);
                        native_banner_ad.removeAllViews();
                        native_banner_ad.addView(viewGroup);
                        show_local_native_banner_ad(native_banner_ad);
                        Log.d("Parth", "Local Native Banner ad show");
                        AdsControl.isLocal_small_Native_banner_Loaded = false;
                        small_native_banner_Ads();
                    }
                } else {
                    small_native_banner_Ads();
                    new Handler().postDelayed(() -> {
                        if (isadmob_small_native_banner_Loaded) {
                            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Admob_small_native_banner_Ad, native_banner_ad);
                            Log.d("Parth", "Admob Native Banner ad show");
                            AdsControl.isadmob_small_native_banner_Loaded = false;
                        } else if (isadx_small_native_banner_Loaded) {
                            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Adx_small_native_banner_Ad, native_banner_ad);
                            Log.d("Parth", "Adx Native Banner ad show");
                            AdsControl.isadx_small_native_banner_Loaded = false;
                        } else if (isFB_small_native_banner_Loaded) {
                            new NativeAds(activity).FB_Smalle_Native_Banner(AdsControl.fb_small_native_banner_Ad, native_banner_ad);
                            Log.d("Parth", "FB Native Banner ad show");
                            AdsControl.isFB_small_native_banner_Loaded = false;
                        } else if (isApplovin_small_native_banner_Loaded) {
                            if (Applovin_small_native_banner_Ad != null) {
                                native_banner_ad.removeAllViews();
                            }
                            native_banner_ad.removeAllViews();
                            native_banner_ad.addView(applovin_small_native_banner_Ad);
                            Log.d("Parth", "Applovin Native Banner ad show");
                            AdsControl.isApplovin_small_native_banner_Loaded = false;
                        } else if (isWortise_small_Native_banner_Loaded) {
                            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.wortise_small_native_banner_Ad, native_banner_ad);
                            Log.d("Parth", "Wortise Native Banner ad show");
                            AdsControl.isWortise_small_Native_banner_Loaded = false;
                        } else if (isLocal_small_Native_banner_Loaded) {
                            @SuppressLint("InflateParams") ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.local_small_native_banner, null);
                            native_banner_ad.removeAllViews();
                            native_banner_ad.addView(viewGroup);
                            show_local_native_banner_ad(native_banner_ad);
                            Log.d("Parth", "Local Native Banner ad show");
                            AdsControl.isLocal_small_Native_banner_Loaded = false;
                        }
                    }, 3000);
                }
            }
        }
    }

    //--------------------------------------------- Small Native Ads --------------------------------------------------------------------------
// TODO: 7/17/2023  Preload Small Native Ads
    int ad_small_native_network = 0;

    public void small_native_Ads() {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAdSmallNative().split(",");
                    if (ad_small_native_network < adnetwork.length) {
                        switch (adnetwork[ad_small_native_network]) {
                            case "admob":
                                if (app_data.get(0).getAdmobNativeid().size() > 0) {
                                    preload_Admob_Small_Native_Ad();
                                }
                                ad_small_native_network++;
                                break;
                            case "adx":
                                if (app_data.get(0).getAdxNativeId().size() > 0) {
                                    preload_Adx_Small_Native_Ad();
                                }
                                ad_small_native_network++;
                                break;
                            case "fb":
                                if (app_data.get(0).getFbNativeBannerId().size() > 0) {
                                    preload_Fb_Small_Native_Ad();
                                }
                                ad_small_native_network++;
                                break;
                            case "applovin":
                                if (app_data.get(0).getApplovin_small_nativeid().size() > 0) {
                                    preload_Applovin_Small_NativeAd();
                                }
                                ad_small_native_network++;
                                break;
                            case "wortise":
                                if (app_data.get(0).getWortiseNativeId().size() > 0) {
                                    preload_Wortise_Small_Native_Ad();
                                }
                                ad_small_native_network++;
                                break;
                            case "local":
                                preload_Local_Small_Native_Ad();
                                ad_small_native_network++;
                                break;
                            default:
                        }
                        if (ad_small_native_network == adnetwork.length) {
                            ad_small_native_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int current_admob_small_native_Id = 0;
    int current_adx_small_native_Id = 0;
    int current_fb_small_native_Id = 0;
    int current_applovin_small_native_Id = 0;
    int current_wortise_small_native_Id = 0;

    // Admob Mode
    void preload_Admob_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isAdmob_small_native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobNativeid().get(current_admob_small_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final AdLoader.Builder builder = new AdLoader.Builder(activity, placementId);
                builder.forNativeAd(nativeAd -> {
                    Log.d("Parth", "Admob Small Native Ad Loaded");
                    Admob_small_native_Ad = nativeAd;
                    isAdmob_small_native_Loaded = true;
                });
                builder.withAdListener(new AdListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Small Native Ad Failed" + loadAdError.getMessage());
                        small_native_Ads();
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                }).build().loadAd(new AdRequest.Builder().build());
                current_admob_small_native_Id++;
                if (current_admob_small_native_Id == app_data.get(0).getAdmobNativeid().size()) {
                    current_admob_small_native_Id = 0;
                }
            }
        }
    }

    // Adx Mode
    void preload_Adx_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isadx_small_native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxNativeId().get(current_adx_small_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final AdLoader.Builder builder = new AdLoader.Builder(activity, placementId);
                builder.forNativeAd(nativeAd -> {
                    Log.d("Parth", "Adx Small Native Ad Loaded");
                    Adx_small_native_Ad = nativeAd;
                    isadx_small_native_Loaded = true;
                });
                builder.withAdListener(new AdListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Small Native Ad Failed" + loadAdError.getMessage());
                        small_native_Ads();
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                }).build().loadAd(new AdManagerAdRequest.Builder().build());
                current_adx_small_native_Id++;
                if (current_adx_small_native_Id == app_data.get(0).getAdxNativeId().size()) {
                    current_adx_small_native_Id = 0;
                }
            }
        }
    }

    // FB Mode
    void preload_Fb_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isFb_small_native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getFbNativeBannerId().get(current_fb_small_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final NativeBannerAd fb_small_native = new NativeBannerAd(activity, placementId);
                NativeAdListener nativeAdListener = new NativeAdListener() {

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "FB Small Native Banner ad is loaded");
                        fb_small_native_Ad = fb_small_native;
                        isFb_small_native_Loaded = true;
                    }

                    @Override
                    public void onMediaDownloaded(Ad ad) {
                        // Native ad finished downloading all assets
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                        small_native_Ads();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };
                // Request an ad
                fb_small_native.loadAd(fb_small_native.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                current_fb_small_native_Id++;
                if (current_fb_small_native_Id == app_data.get(0).getFbNativeBannerId().size()) {
                    current_fb_small_native_Id = 0;
                }
            }
        }
    }

    // Applovin Mode
    void preload_Applovin_Small_NativeAd() {
        if (app_data != null && app_data.size() > 0) {
            if (isapplovin_small_native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getApplovin_small_nativeid().get(current_applovin_small_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(placementId, activity);
                nativeAdLoader.setRevenueListener(ad -> {
                });
                nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                    @Override
                    public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                        Log.d("Parth", "Applovin Small Native ad Loaded");
                        applovin_small_native_Ad = nativeAdView;
                        Applovin_small_native_Ad = ad;
                        isapplovin_small_native_Loaded = true;
                    }

                    @Override
                    public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                        Log.d("Parth", "Applovin Small Native ad Failed " + error.getMessage());
                        small_native_Ads();
                    }

                    @Override
                    public void onNativeAdClicked(final MaxAd ad) {
                    }
                });
                nativeAdLoader.loadAd(new NativeAds(activity).create_Small_NativeAdView());
                current_applovin_small_native_Id++;
                if (current_applovin_small_native_Id == app_data.get(0).getApplovin_small_nativeid().size()) {
                    current_applovin_small_native_Id = 0;
                }
            }
        }
    }

    // Wortise Mode
    void preload_Wortise_Small_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isWortise_small_Native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getWortiseNativeId().get(current_wortise_small_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final GoogleNativeAd wortise_google_small_native = new GoogleNativeAd(activity, placementId, new GoogleNativeAd.Listener() {
                    @Override
                    public void onNativeClicked(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onNativeFailed(@NonNull GoogleNativeAd googleNativeAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Small Native Ad Failed" + adError);
                        small_native_Ads();
                    }

                    @Override
                    public void onNativeImpression(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeLoaded(@NonNull GoogleNativeAd googleNativeAd, @NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Wortise Small Native Ad Loaded");
                        wortise_google_small_native_Ad = googleNativeAd;
                        wortise_small_native_Ad = nativeAd;
                        isWortise_small_Native_Loaded = true;
                    }
                });
                wortise_google_small_native.load();
                current_wortise_small_native_Id++;
                if (current_wortise_small_native_Id == app_data.get(0).getWortiseNativeId().size()) {
                    current_wortise_small_native_Id = 0;
                }
            }
        }
    }

    // Local Mode
    void preload_Local_Small_Native_Ad() {
        if (isLocal_small_Native_Loaded) {
            return;
        }
        isLocal_small_Native_Loaded = true;
    }

    @SuppressLint("SetTextI18n")
    void show_local_small_native(ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            RelativeLayout custm_native = native_banner_ad.findViewById(R.id.custm_small_native_ad);
            ImageView app_icon_native = native_banner_ad.findViewById(R.id.ad_app_icon);
            TextView app_name_native = native_banner_ad.findViewById(R.id.ad_Tital);
            TextView app_ad_body = native_banner_ad.findViewById(R.id.ad_body);
            TextView ad_call_to_action = native_banner_ad.findViewById(R.id.ad_call_to_action);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(app_icon_native);
                app_name_native.setText(app_data.get(0).getNew_app_name());
                app_name_native.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                ad_call_to_action.setText("Install");
            } catch (Exception ignored) {
            }
            custm_native.setOnClickListener(view -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    // TODO: 7/17/2023  Show Small Native Ads
    @SuppressLint("MissingPermission")
    public void show_small_native_ad(final ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).isAds_show()) {
                if (app_data.get(0).isPreload_native_ads()) {
                    if (isAdmob_small_native_Loaded) {
                        new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Admob_small_native_Ad, native_banner_ad);
                        Log.d("Parth", "Admob Small Native ad show");
                        AdsControl.isAdmob_small_native_Loaded = false;
                        small_native_Ads();
                    } else if (isadx_small_native_Loaded) {
                        new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Adx_small_native_Ad, native_banner_ad);
                        Log.d("Parth", "Adx Small Native ad show");
                        AdsControl.isadx_small_native_Loaded = false;
                        small_native_Ads();
                    } else if (isFb_small_native_Loaded) {
                        new NativeAds(activity).FB_Smalle_Native(AdsControl.fb_small_native_Ad, native_banner_ad);
                        Log.d("Parth", "FB Small Native ad show");
                        AdsControl.isFb_small_native_Loaded = false;
                        small_native_Ads();
                    } else if (isapplovin_small_native_Loaded) {
                        if (Applovin_small_native_Ad != null) {
                            native_banner_ad.removeAllViews();
                        }
                        native_banner_ad.removeAllViews();
                        native_banner_ad.addView(applovin_small_native_Ad);
                        Log.d("Parth", "Applovin Small Native ad show");
                        AdsControl.isapplovin_small_native_Loaded = false;
                        small_native_Ads();
                    } else if (isWortise_small_Native_Loaded) {
                        new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.wortise_small_native_Ad, native_banner_ad);
                        Log.d("Parth", "Wortise Small Native ad show");
                        AdsControl.isWortise_small_Native_Loaded = false;
                        small_native_Ads();
                    } else if (isLocal_small_Native_Loaded) {
                        @SuppressLint("InflateParams") ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.local_small_native_ad, null);
                        show_local_small_native(viewGroup);
                        native_banner_ad.removeAllViews();
                        native_banner_ad.addView(viewGroup);
                        Log.d("Parth", "Local Small Native ad show");
                        AdsControl.isLocal_small_Native_Loaded = false;
                        small_native_Ads();
                    }
                } else {
                    small_native_Ads();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (isAdmob_small_native_Loaded) {
                                new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Admob_small_native_Ad, native_banner_ad);
                                Log.d("Parth", "Admob Small Native ad show");
                                AdsControl.isAdmob_small_native_Loaded = false;
                            } else if (isadx_small_native_Loaded) {
                                new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Adx_small_native_Ad, native_banner_ad);
                                Log.d("Parth", "Adx Small Native ad show");
                                AdsControl.isadx_small_native_Loaded = false;
                            } else if (isFb_small_native_Loaded) {
                                new NativeAds(activity).FB_Smalle_Native(AdsControl.fb_small_native_Ad, native_banner_ad);
                                Log.d("Parth", "FB Small Native ad show");
                                AdsControl.isFb_small_native_Loaded = false;
                            } else if (isapplovin_small_native_Loaded) {
                                if (Applovin_small_native_Ad != null) {
                                    native_banner_ad.removeAllViews();
                                }
                                native_banner_ad.removeAllViews();
                                native_banner_ad.addView(applovin_small_native_Ad);
                                Log.d("Parth", "Applovin Small Native ad show");
                                AdsControl.isapplovin_small_native_Loaded = false;
                            } else if (isWortise_small_Native_Loaded) {
                                new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.wortise_small_native_Ad, native_banner_ad);
                                Log.d("Parth", "Wortise Small Native ad show");
                                AdsControl.isWortise_small_Native_Loaded = false;
                            } else if (isLocal_small_Native_Loaded) {
                                @SuppressLint("InflateParams") ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.local_small_native_ad, null);
                                show_local_small_native(viewGroup);
                                native_banner_ad.removeAllViews();
                                native_banner_ad.addView(viewGroup);
                                Log.d("Parth", "Local Small Native ad show");
                                AdsControl.isLocal_small_Native_Loaded = false;
                            }
                        }
                    }, 3000);
                }
            }
        }
    }

    //--------------------------------------------- Native Ads --------------------------------------------------------------------------

    // TODO: 7/17/2023  Preload Native Ads
    int ad_native_network = 0;

    public void native_Ads() {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAdNative().split(",");
                    if (ad_native_network < adnetwork.length) {
                        switch (adnetwork[ad_native_network]) {
                            case "admob":
                                if (app_data.get(0).getAdmobNativeid().size() > 0) {
                                    preload_Admob_Native_Ad();
                                }
                                ad_native_network++;
                                break;
                            case "adx":
                                if (app_data.get(0).getAdxNativeId().size() > 0) {
                                    preload_Adx_Native_Ad();
                                }
                                ad_native_network++;
                                break;
                            case "fb":
                                if (app_data.get(0).getFbNativeId().size() > 0) {
                                    preloadFbNativeAd();
                                }
                                ad_native_network++;
                                break;
                            case "applovin":
                                if (app_data.get(0).getApplovin_nativeid().size() > 0) {
                                    preload_Applovin_NativeAd();
                                }
                                ad_native_network++;
                                break;
                            case "wortise":
                                if (app_data.get(0).getWortiseNativeId().size() > 0) {
                                    preload_Wortise_Native_Ad();
                                }
                                ad_native_network++;
                                break;
                            case "local":
                                preload_local_Native_ad();
                                ad_native_network++;
                                break;
                            default:
                        }
                        if (ad_native_network == adnetwork.length) {
                            ad_native_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int current_admob_native_Id = 0;
    int current_adx_native_Id = 0;
    int current_fb_native_Id = 0;
    int current_applovin_native_Id = 0;
    int current_wortise_native_Id = 0;

    // Admob Mode
    @SuppressLint("MissingPermission")
    void preload_Admob_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isadmob_native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobNativeid().get(current_admob_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final AdLoader.Builder builder = new AdLoader.Builder(activity, placementId);
                builder.forNativeAd(nativeAd -> {
                    Log.d("Parth", "Admob Native Ad Loaded");
                    Admob_native_Ad = nativeAd;
                    isadmob_native_Loaded = true;
                });
                builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Native Ad Failed" + loadAdError.getMessage());
                        native_Ads();
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                }).build().loadAd(new AdRequest.Builder().build());
                current_admob_native_Id++;
                if (current_admob_native_Id == app_data.get(0).getAdmobNativeid().size()) {
                    current_admob_native_Id = 0;
                }
            }
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    void preload_Adx_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isadx_native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxNativeId().get(current_adx_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final AdLoader.Builder builder = new AdLoader.Builder(activity, placementId);
                builder.forNativeAd(nativeAd -> {
                    Log.d("Parth", "Adx Native Ad Loaded");
                    Adx_native_Ad = nativeAd;
                    isadx_native_Loaded = true;
                });
                builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Native Ad Failed" + loadAdError.getMessage());
                        native_Ads();
                    }

                    public void onAdLoaded() {
                        super.onAdLoaded();
                    }
                }).build().loadAd(new AdRequest.Builder().build());
                current_adx_native_Id++;
                if (current_adx_native_Id == app_data.get(0).getAdxNativeId().size()) {
                    current_adx_native_Id = 0;
                }
            }
        }
    }

    // FB Mode
    void preloadFbNativeAd() {
        if (app_data != null && app_data.size() > 0) {
            if (isFB_Native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getFbNativeId().get(current_fb_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, placementId);
                NativeAdListener nativeAdListener = new NativeAdListener() {
                    @Override
                    public void onMediaDownloaded(Ad ad) {
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Native ad Failed " + adError.getErrorMessage());
                        native_Ads();
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", " FB Native ad is loaded");
                        fb_native_Ad = fbnative_Ad;
                        isFB_Native_Loaded = true;
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };
                // Request an ad
                fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
                current_fb_native_Id++;
                if (current_fb_native_Id == app_data.get(0).getFbNativeId().size()) {
                    current_fb_native_Id = 0;
                }
            }
        }
    }

    // Applovin Mode
    void preload_Applovin_NativeAd() {
        if (app_data != null && app_data.size() > 0) {
            if (isApplovin_Native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getApplovin_nativeid().get(current_applovin_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(placementId, activity);
                nativeAdLoader.setRevenueListener(ad -> {
                });
                nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                    @Override
                    public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                        Log.d("Parth", "Applovin Native ad Loaded");
                        applovin_maxnativeadview = nativeAdView;
                        Applovin_native_ad = ad;
                        isApplovin_Native_Loaded = true;
                    }

                    @Override
                    public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                        Log.d("Parth", "Applovin Native ad Failed " + error.getMessage());
                        native_Ads();
                    }

                    @Override
                    public void onNativeAdClicked(final MaxAd ad) {
                    }
                });
                nativeAdLoader.loadAd(new NativeAds(activity).createNativeAdView());
                current_applovin_native_Id++;
                if (current_applovin_native_Id == app_data.get(0).getApplovin_nativeid().size()) {
                    current_applovin_native_Id = 0;
                }
            }
        }
    }

    // Wortise Mode
    void preload_Wortise_Native_Ad() {
        if (app_data != null && app_data.size() > 0) {
            if (isWortise_Native_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getWortiseNativeId().get(current_wortise_native_Id);
            if (!placementId.equalsIgnoreCase("")) {
                final GoogleNativeAd wortise_google_native = new GoogleNativeAd(activity, placementId, new GoogleNativeAd.Listener() {
                    @Override
                    public void onNativeClicked(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onNativeFailed(@NonNull GoogleNativeAd googleNativeAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Native ad Failed" + adError);
                        native_Ads();
                    }

                    @Override
                    public void onNativeImpression(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeLoaded(@NonNull GoogleNativeAd googleNativeAd, @NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Wortise Naive ad Loaded");
                        wortise_google_native_Ad = googleNativeAd;
                        wortise_native_Ad = nativeAd;
                        isWortise_Native_Loaded = true;
                    }
                });
                wortise_google_native.load();
                current_wortise_native_Id++;
                if (current_wortise_native_Id == app_data.get(0).getWortiseNativeId().size()) {
                    current_wortise_native_Id = 0;
                }
            }
        }
    }

    // Local Mode
    void preload_local_Native_ad() {
        if (isLocal_Native_Loaded) {
            return;
        }
        isLocal_Native_Loaded = true;
    }

    @SuppressLint("SetTextI18n")
    void show_local_native(ViewGroup banner_container) {
        if (app_data != null && app_data.size() > 0) {
            if (AdsControl.isLocal_Native_Loaded) {
                RelativeLayout custm_native = banner_container.findViewById(R.id.custm_native_ad);
                ImageView app_icon_native = banner_container.findViewById(R.id.ad_app_icon);
                TextView app_name_native = banner_container.findViewById(R.id.ad_headline);
                ImageView app_banner = banner_container.findViewById(R.id.ad_banner);
                TextView app_ad_body = banner_container.findViewById(R.id.ad_body);
                TextView ad_call_to_action = banner_container.findViewById(R.id.ad_call_to_action);
                try {
                    Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(app_icon_native);
                    Glide.with(activity).load(app_data.get(0).getNew_app_banner()).into(app_banner);
                    app_name_native.setText(app_data.get(0).getNew_app_name());
                    app_name_native.setSelected(true);
                    app_ad_body.setText(app_data.get(0).getNew_app_body());
                    app_ad_body.setSelected(true);
                    ad_call_to_action.setText("Install");
                } catch (Exception ignored) {
                }
                custm_native.setOnClickListener(view -> {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(app_data.get(0).getNew_app_link()));
                        activity.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    // TODO: 8/3/2023  Medium Rect Ad
    int ad_medium_network = 0;

    public void medium_rect_Ads() {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAd_medium_rect().split(",");
                    if (ad_medium_network < adnetwork.length) {
                        switch (adnetwork[ad_medium_network]) {
                            case "admob":
                                if (app_data.get(0).getAdmobMediumRectangleid().size() > 0) {
                                    preload_medium_rectAd_Admob();
                                }
                                ad_medium_network++;
                                break;
                            case "adx":
                                if (app_data.get(0).getAdxMediumRectangleid().size() > 0) {
                                    preload_medium_rect_Adx();
                                }
                                ad_medium_network++;
                                break;
                            case "fb":
                                if (app_data.get(0).getFbMediumRectangleId().size() > 0) {
                                    preload_medium_rect_FB();
                                }
                                ad_medium_network++;
                                break;
                            case "applovin":
                                if (app_data.get(0).getApplovin_medium_rectangle_id().size() > 0) {
                                    preload_medium_rect_Applovin();
                                }
                                ad_medium_network++;
                                break;
                            case "wortise":
                                if (app_data.get(0).getWortiseMediumRectangleId().size() > 0) {
                                    preloadmedium_rect_Wortise();
                                }
                                ad_medium_network++;
                                break;
                            default:
                        }
                        if (ad_medium_network == adnetwork.length) {
                            ad_medium_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int current_admob_medium_rectId = 0;
    int current_adx_medium_rectId = 0;
    int current_fb_medium_rectId = 0;
    int current_applovin_medium_rectId = 0;
    int current_wortise_medium_rectId = 0;

    // Admob Mode
    @SuppressLint("MissingPermission")
    void preload_medium_rectAd_Admob() {
        if (app_data != null && app_data.size() > 0) {
            if (isAdmob_Mediam_Ragtangal_Loaded) {
                return;
            }
            String placmentId = app_data.get(0).getAdmobMediumRectangleid().get(current_admob_medium_rectId);
            if (!placmentId.equalsIgnoreCase("")) {
                final AdView admob_Mediam_Ragtangal = new AdView(activity);
                admob_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
                admob_Mediam_Ragtangal.setAdUnitId(placmentId);
                AdRequest adRequest = new AdRequest.Builder().build();
                admob_Mediam_Ragtangal.loadAd(adRequest);
                admob_Mediam_Ragtangal.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        Log.d("Parth", "admob mediam ragtangal loaded");
                        admobMediam_Ragtangal = admob_Mediam_Ragtangal;
                        isAdmob_Mediam_Ragtangal_Loaded = true;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        super.onAdFailedToLoad(adError);
                        Log.d("Parth", "admob mediam ragtangal failed" + adError.getMessage());
                        medium_rect_Ads();
                    }
                });
                current_admob_medium_rectId++;
                if (current_admob_medium_rectId == app_data.get(0).getAdmobMediumRectangleid().size()) {
                    current_admob_medium_rectId = 0;
                }
            }
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    void preload_medium_rect_Adx() {
        if (app_data != null && app_data.size() > 0) {
            if (isAdx_Mediam_Ragtangal_Loaded) {
                return;
            }
            String placmentId = app_data.get(0).getAdxMediumRectangleid().get(current_adx_medium_rectId);
            if (!placmentId.equalsIgnoreCase("")) {
                final AdManagerAdView adx_Mediam_Ragtangal = new AdManagerAdView(activity);
                adx_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
                adx_Mediam_Ragtangal.setAdUnitId(placmentId);
                AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                adx_Mediam_Ragtangal.loadAd(adRequest);
                adx_Mediam_Ragtangal.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.d("Parth", "adx mediam ragtangal loaded");
                        adxMediam_Ragtangal = adx_Mediam_Ragtangal;
                        isAdx_Mediam_Ragtangal_Loaded = true;
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "adx mediam ragtangal failed" + loadAdError.getMessage());
                        medium_rect_Ads();
                    }

                });
                current_adx_medium_rectId++;
                if (current_adx_medium_rectId == app_data.get(0).getAdxMediumRectangleid().size()) {
                    current_adx_medium_rectId = 0;
                }
            }
        }
    }

    // FB Mode
    void preload_medium_rect_FB() {
        if (app_data != null && app_data.size() > 0) {
            if (isFB_Mediam_Ragtangal_Loaded) {
                return;
            }
            String placmentId = app_data.get(0).getFbMediumRectangleId().get(current_fb_medium_rectId);
            if (!placmentId.equalsIgnoreCase("")) {
                final com.facebook.ads.AdView fb_Ragtangal = new com.facebook.ads.AdView(activity, placmentId, com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "FB mediam ragtangal Loadedd ");
                        fb_Ragtangal_adView = fb_Ragtangal;
                        isFB_Mediam_Ragtangal_Loaded = true;
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB mediam ragtangal Failed" + adError.getErrorMessage());
                        medium_rect_Ads();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };
                fb_Ragtangal.loadAd(fb_Ragtangal.buildLoadAdConfig().withAdListener(adListener).build());
                current_fb_medium_rectId++;
                if (current_fb_medium_rectId == app_data.get(0).getFbMediumRectangleId().size()) {
                    current_fb_medium_rectId = 0;
                }
            }
        }
    }

    // Applovin Mode
    void preload_medium_rect_Applovin() {
        if (app_data != null && app_data.size() > 0) {
            if (isApplovin_Mediam_Ragtangal_Loaded) {
                return;
            }
            String placmentId = app_data.get(0).getApplovin_medium_rectangle_id().get(current_applovin_medium_rectId);
            if (!placmentId.equalsIgnoreCase("")) {
                final MaxAdView applovin_medium_rect = new MaxAdView(placmentId, MaxAdFormat.MREC, activity);
                int widthPx = AppLovinSdkUtils.dpToPx(activity, 300);
                int heightPx = AppLovinSdkUtils.dpToPx(activity, 250);
                applovin_medium_rect.setLayoutParams(new ViewGroup.LayoutParams(widthPx, heightPx));
                applovin_medium_rect.loadAd();
                applovin_medium_rect.setListener(new MaxAdViewAdListener() {
                    @Override
                    public void onAdExpanded(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdCollapsed(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdLoaded(MaxAd maxAd) {
                        Log.d("Parth", "Applovin mediam ragtangal Loaded");
                        applovin_Medium_Ragtangal_adview = applovin_medium_rect;
                        isApplovin_Mediam_Ragtangal_Loaded = true;
                    }

                    @Override
                    public void onAdDisplayed(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdHidden(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdClicked(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdLoadFailed(String s, MaxError maxError) {
                        Log.d("Parth", "Applovin mediam ragtangal Failed " + maxError.getMessage());
                        medium_rect_Ads();
                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                    }
                });
                current_applovin_medium_rectId++;
                if (current_applovin_medium_rectId == app_data.get(0).getApplovin_medium_rectangle_id().size()) {
                    current_applovin_medium_rectId = 0;
                }
            }
        }
    }

    // Wortise Mode
    void preloadmedium_rect_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            if (isWortise_medium_ragtangal_Loaded) {
                return;
            }
            String placmentId = app_data.get(0).getWortiseMediumRectangleId().get(current_wortise_medium_rectId);
            if (!placmentId.equalsIgnoreCase("")) {
                final BannerAd wortise_medium_ragtangal = new BannerAd(activity);
                wortise_medium_ragtangal.setAdSize(com.wortise.ads.AdSize.HEIGHT_250);
                wortise_medium_ragtangal.setAdUnitId(placmentId);
                wortise_medium_ragtangal.loadAd();
                wortise_medium_ragtangal.setListener(new BannerAd.Listener() {
                    @Override
                    public void onBannerLoaded(@NonNull BannerAd bannerAd) {
                        Log.d("Parth", "Wortise Medium Ragtangal Loadedd ");
                        w_medium_ragtangal = wortise_medium_ragtangal;
                        isWortise_medium_ragtangal_Loaded = true;
                    }

                    @Override
                    public void onBannerClicked(@NonNull BannerAd bannerAd) {
                    }

                    @Override
                    public void onBannerFailed(@NonNull BannerAd bannerAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Medium Ragtangal failed " + adError);
                        medium_rect_Ads();
                    }
                });
                current_wortise_medium_rectId++;
                if (current_wortise_medium_rectId == app_data.get(0).getWortiseMediumRectangleId().size()) {
                    current_wortise_medium_rectId = 0;
                }
            }
        }
    }

    // TODO: 7/17/2023 Show Native Ads
    @SuppressLint("MissingPermission")
    public void show_native_ad(final ViewGroup native_ad) {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).isAds_show()) {
                if (app_data.get(0).isPreload_native_ads()) {
                    if (isadmob_native_Loaded) {
                        new NativeAds(activity).Admob_NativeAd(AdsControl.Admob_native_Ad, native_ad);
                        Log.d("Parth", "Admob Native ad show");
                        AdsControl.isadmob_native_Loaded = false;
                        native_Ads();
                    } else if (isadx_native_Loaded) {
                        new NativeAds(activity).Admob_NativeAd(AdsControl.Adx_native_Ad, native_ad);
                        Log.d("Parth", "Adx Native ad show");
                        AdsControl.isadx_native_Loaded = false;
                        native_Ads();
                    } else if (isFB_Native_Loaded) {
                        new NativeAds(activity).FB_Native(AdsControl.fb_native_Ad, native_ad);
                        Log.d("Parth", "FB Native ad show");
                        AdsControl.isFB_Native_Loaded = false;
                        native_Ads();
                    } else if (isApplovin_Native_Loaded) {
                        if (Applovin_native_ad != null) {
                            native_ad.removeAllViews();
                        }
                        native_ad.removeAllViews();
                        native_ad.addView(applovin_maxnativeadview);
                        Log.d("Parth", "Applovin Native ad show");
                        AdsControl.isApplovin_Native_Loaded = false;
                        native_Ads();
                    } else if (isWortise_Native_Loaded) {
                        new NativeAds(activity).Admob_NativeAd(AdsControl.wortise_native_Ad, native_ad);
                        Log.d("Parth", "Wortise Native ad show");
                        AdsControl.isWortise_Native_Loaded = false;
                        native_Ads();
                    } else if (isLocal_Native_Loaded) {
                        @SuppressLint("InflateParams") ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.local_native_ad, null);
                        show_local_native(viewGroup);
                        native_ad.removeAllViews();
                        native_ad.addView(viewGroup);
                        Log.d("Parth", "Local Native ad show");
                        AdsControl.isLocal_Native_Loaded = false;
                        native_Ads();
                    } else if (isAdmob_Mediam_Ragtangal_Loaded) {
                        try {
                            if (admobMediam_Ragtangal.getParent() != null) {
                                ((ViewGroup) admobMediam_Ragtangal.getParent()).removeView(admobMediam_Ragtangal);
                            }
                            native_ad.addView(admobMediam_Ragtangal);
                            AdsControl.isAdmob_Mediam_Ragtangal_Loaded = false;
                            medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isAdx_Mediam_Ragtangal_Loaded) {
                        try {
                            if (adxMediam_Ragtangal.getParent() != null) {
                                ((ViewGroup) adxMediam_Ragtangal.getParent()).removeView(adxMediam_Ragtangal);
                            }
                            native_ad.addView(adxMediam_Ragtangal);
                            AdsControl.isAdx_Mediam_Ragtangal_Loaded = false;
                            medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isFB_Mediam_Ragtangal_Loaded) {
                        try {
                            if (fb_Ragtangal_adView.getParent() != null) {
                                ((ViewGroup) fb_Ragtangal_adView.getParent()).removeView(fb_Ragtangal_adView);
                            }
                            native_ad.addView(fb_Ragtangal_adView);
                            AdsControl.isFB_Mediam_Ragtangal_Loaded = false;
                            medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isApplovin_Mediam_Ragtangal_Loaded) {
                        try {
                            if (applovin_Medium_Ragtangal_adview.getParent() != null) {
                                ((ViewGroup) applovin_Medium_Ragtangal_adview.getParent()).removeView(applovin_Medium_Ragtangal_adview);
                            }
                            native_ad.addView(applovin_Medium_Ragtangal_adview);
                            AdsControl.isApplovin_Mediam_Ragtangal_Loaded = false;
                            medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    } else if (isWortise_medium_ragtangal_Loaded) {
                        try {
                            if (w_medium_ragtangal.getParent() != null) {
                                ((ViewGroup) w_medium_ragtangal.getParent()).removeView(w_medium_ragtangal);
                            }
                            native_ad.addView(w_medium_ragtangal);
                            AdsControl.isWortise_medium_ragtangal_Loaded = false;
                            medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                } else {
                    if (app_data.get(0).getAd_native_type().equalsIgnoreCase("mrec")) {
                        medium_rect_Ads();
                    } else {
                        native_Ads();
                    }
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (isadmob_native_Loaded) {
                                new NativeAds(activity).Admob_NativeAd(AdsControl.Admob_native_Ad, native_ad);
                                Log.d("Parth", "Admob Native ad show");
                                AdsControl.isadmob_native_Loaded = false;
                            } else if (isadx_native_Loaded) {
                                new NativeAds(activity).Admob_NativeAd(AdsControl.Adx_native_Ad, native_ad);
                                Log.d("Parth", "Adx Native ad show");
                                AdsControl.isadx_native_Loaded = false;
                            } else if (isFB_Native_Loaded) {
                                new NativeAds(activity).FB_Native(AdsControl.fb_native_Ad, native_ad);
                                Log.d("Parth", "FB Native ad show");
                                AdsControl.isFB_Native_Loaded = false;
                            } else if (isApplovin_Native_Loaded) {
                                if (Applovin_native_ad != null) {
                                    native_ad.removeAllViews();
                                }
                                native_ad.removeAllViews();
                                native_ad.addView(applovin_maxnativeadview);
                                Log.d("Parth", "Applovin Native ad show");
                                AdsControl.isApplovin_Native_Loaded = false;
                            } else if (isWortise_Native_Loaded) {
                                new NativeAds(activity).Admob_NativeAd(AdsControl.wortise_native_Ad, native_ad);
                                Log.d("Parth", "Wortise Native ad show");
                                AdsControl.isWortise_Native_Loaded = false;
                            } else if (isLocal_Native_Loaded) {
                                @SuppressLint("InflateParams") ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.local_native_ad, null);
                                show_local_native(viewGroup);
                                native_ad.removeAllViews();
                                native_ad.addView(viewGroup);
                                Log.d("Parth", "Local Native ad show");
                                AdsControl.isLocal_Native_Loaded = false;
                            } else if (isAdmob_Mediam_Ragtangal_Loaded) {
                                try {
                                    if (admobMediam_Ragtangal.getParent() != null) {
                                        ((ViewGroup) admobMediam_Ragtangal.getParent()).removeView(admobMediam_Ragtangal);
                                    }
                                    native_ad.addView(admobMediam_Ragtangal);
                                    AdsControl.isAdmob_Mediam_Ragtangal_Loaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isAdx_Mediam_Ragtangal_Loaded) {
                                try {
                                    if (adxMediam_Ragtangal.getParent() != null) {
                                        ((ViewGroup) adxMediam_Ragtangal.getParent()).removeView(adxMediam_Ragtangal);
                                    }
                                    native_ad.addView(adxMediam_Ragtangal);
                                    AdsControl.isAdx_Mediam_Ragtangal_Loaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isFB_Mediam_Ragtangal_Loaded) {
                                try {
                                    if (fb_Ragtangal_adView.getParent() != null) {
                                        ((ViewGroup) fb_Ragtangal_adView.getParent()).removeView(fb_Ragtangal_adView);
                                    }
                                    native_ad.addView(fb_Ragtangal_adView);
                                    AdsControl.isFB_Mediam_Ragtangal_Loaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isApplovin_Mediam_Ragtangal_Loaded) {
                                try {
                                    if (applovin_Medium_Ragtangal_adview.getParent() != null) {
                                        ((ViewGroup) applovin_Medium_Ragtangal_adview.getParent()).removeView(applovin_Medium_Ragtangal_adview);
                                    }
                                    native_ad.addView(applovin_Medium_Ragtangal_adview);
                                    AdsControl.isApplovin_Mediam_Ragtangal_Loaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            } else if (isWortise_medium_ragtangal_Loaded) {
                                try {
                                    if (w_medium_ragtangal.getParent() != null) {
                                        ((ViewGroup) w_medium_ragtangal.getParent()).removeView(w_medium_ragtangal);
                                    }
                                    native_ad.addView(w_medium_ragtangal);
                                    AdsControl.isWortise_medium_ragtangal_Loaded = false;
                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }, 3000);
                }
            }
        }
    }

    //-------------------------------------------- Inter Ads ----------------------------------------------------------------------------
    static getDataListner callback;
    int ad_inter_network = 0;
    Dialog ad_inter_dialog;
    public static int ad_dialog_time_in_second = 2;

    // TODO: 7/31/2023  Preload Inter Ads
    public void inter_Ads() {

        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAdInter().split(",");
                    if (ad_inter_network < adnetwork.length) {
                        switch (adnetwork[ad_inter_network]) {
                            case "admob":
                                if (app_data.get(0).getAdmobInterid().size() > 0) {
                                    Load_interAds_Admob();
                                }
                                ad_inter_network++;
                                break;
                            case "adx":
                                if (app_data.get(0).getAdxInterId().size() > 0) {
                                    Load_interAds_Adx();
                                }
                                ad_inter_network++;
                                break;
                            case "fb":
                                if (app_data.get(0).getFbInterId().size() > 0) {
                                    Load_interAds_FB();
                                }
                                ad_inter_network++;
                                break;
                            case "applovin":
                                if (app_data.get(0).getApplovin_interid().size() > 0) {
                                    Load_interAds_Applovin();
                                }
                                ad_inter_network++;
                                break;
                            case "wortise":
                                if (app_data.get(0).getWortiseInterId().size() > 0) {
                                    Load_interAds_Wortise();
                                }
                                ad_inter_network++;
                                break;
                            case "inmobi":
                                if (app_data.get(0).getInmobi_inter_id().size() > 0) {
                                    Load_interAds_Inmobi();
                                }
                                ad_inter_network++;
                                break;
                            case "local":
                                Load_interAds_Local();
                                ad_inter_network++;
                            default:
                        }
                        if (ad_inter_network == adnetwork.length) {
                            ad_inter_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    int current_admob_IntrId = 0;
    int current_adx_IntrId = 0;
    int current_fb_IntrId = 0;
    int current_applovin_IntrId = 0;
    int current_wortise_IntrId = 0;
    int current_inmobi_IntrId = 0;

    // TODO: 7/17/2023  Preload Inter Ads
    // Admob Mode
    void Load_interAds_Admob() {
        if (app_data != null && app_data.size() > 0) {
            if (isGoogleInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobInterid().get(current_admob_IntrId);
            if (!placementId.equalsIgnoreCase("")) {
                final AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, placementId, adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        Log.d("Parth", "Admob Inter Loaded");
                        ADMOBInterstitialAd = interstitialAd;
                        isGoogleInterLoaded = true;
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("Parth", "Admob Inter Close");
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                Log.d("Parth", "Admob Inter failed to show" + adError.getMessage());
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                Log.d("Parth", "Admob Inter Show");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.d("Parth", "Admob Inter Failed");
                        inter_Ads();
                    }
                });
                current_admob_IntrId++;
                if (current_admob_IntrId == app_data.get(0).getAdmobInterid().size()) {
                    current_admob_IntrId = 0;
                }
            }
        }
    }

    // Adx Mode
    void Load_interAds_Adx() {
        if (app_data != null && app_data.size() > 0) {
            if (isAdxInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxInterId().get(current_adx_IntrId);
            if (!placementId.equalsIgnoreCase("")) {
                final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                AdManagerInterstitialAd.load(activity, placementId, adRequest, new AdManagerInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull AdManagerInterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        Log.d("Parth", "Adx Inter Loaded");
                        ADXInterstitialAd = interstitialAd;
                        isAdxInterLoaded = true;
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("Parth", "Adx Inter Close");
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                Log.d("Parth", "Adx Inter Show");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        Log.d("Parth", "Adx Inter Failed");
                        inter_Ads();
                    }
                });
                current_adx_IntrId++;
                if (current_adx_IntrId == app_data.get(0).getAdxInterId().size()) {
                    current_adx_IntrId = 0;
                }
            }
        }
    }

    // FB Mode
    void Load_interAds_FB() {
        if (app_data != null && app_data.size() > 0) {
            if (isFBInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getFbInterId().get(current_fb_IntrId);
            if (!placementId.equalsIgnoreCase("")) {
                final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, placementId);
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                    @Override
                    public void onInterstitialDisplayed(Ad ad) {
                        Log.d("Parth", "FB Inter Show");
                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        Log.d("Parth", "FB Inter ad Close.");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Inter Failed");
                        inter_Ads();
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "FB Inter ad Loaded");
                        FB_interstitialAd = FB_interstitial;
                        isFBInterLoaded = true;
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        Log.d("Parth", "FB Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        Log.d("Parth", "FB Interstitial ad impression logged!");
                    }
                };
                FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
                current_fb_IntrId++;
                if (current_fb_IntrId == app_data.get(0).getFbInterId().size()) {
                    current_fb_IntrId = 0;
                }
            }
        }
    }

    // Applovin Mode
    void Load_interAds_Applovin() {
        if (app_data != null && app_data.size() > 0) {
            if (isApplovinInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getApplovin_interid().get(current_applovin_IntrId);
            if (!placementId.equalsIgnoreCase("")) {
                MaxInterstitialAd interstitialAdmax = new MaxInterstitialAd(placementId, (Activity) activity);
                interstitialAdmax.setListener(new MaxAdListener() {
                    @Override
                    public void onAdLoaded(MaxAd ad) {
                        Log.d("Parth", "Applovin Inter Loaded");
                        Applovin_maxInterstitialAd = interstitialAdmax;
                        isApplovinInterLoaded = true;
                    }

                    @Override
                    public void onAdDisplayed(MaxAd ad) {
                        Log.d("Parth", "Applovin Inter Show");
                    }

                    @Override
                    public void onAdHidden(MaxAd ad) {
                        Log.d("Parth", "Applovin Inter Close");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onAdClicked(MaxAd ad) {
                    }

                    @Override
                    public void onAdLoadFailed(String adUnitId, MaxError error) {
                        Log.d("Parth", "Applovin Inter Failed");
                        inter_Ads();
                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                    }
                });
                interstitialAdmax.loadAd();
                current_applovin_IntrId++;
                if (current_applovin_IntrId == app_data.get(0).getApplovin_interid().size()) {
                    current_applovin_IntrId = 0;
                }
            }
        }
    }

    // Wortise Mode
    void Load_interAds_Wortise() {
        if (app_data != null && app_data.size() > 0) {
            if (isWortiseInterLoaded) {
                return;
            }
            String placementId = app_data.get(0).getWortiseInterId().get(current_wortise_IntrId);
            if (!placementId.equalsIgnoreCase("")) {
                final com.wortise.ads.interstitial.InterstitialAd Wortise_inter_ad = new com.wortise.ads.interstitial.InterstitialAd(activity, placementId);
                Wortise_inter_ad.loadAd();
                Wortise_inter_ad.setListener(new com.wortise.ads.interstitial.InterstitialAd.Listener() {
                    @Override
                    public void onInterstitialClicked(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                    }

                    @Override
                    public void onInterstitialDismissed(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                        Log.d("Parth", "Wortise Inter ad Close.");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onInterstitialFailed(@NonNull com.wortise.ads.interstitial.InterstitialAd ad, @NonNull com.wortise.ads.AdError error) {
                        Log.d("Parth", "Wortise Inter Failed");
                        inter_Ads();
                    }

                    @Override
                    public void onInterstitialLoaded(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                        Log.d("Parth", "Wortise Inter ad Loaded.");
                        Wortise_inter = Wortise_inter_ad;
                        isWortiseInterLoaded = true;
                    }

                    @Override
                    public void onInterstitialShown(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                        Log.d("Parth", "Wortise Inter Show");
                    }
                });
                current_wortise_IntrId++;
                if (current_wortise_IntrId == app_data.get(0).getWortiseInterId().size()) {
                    current_wortise_IntrId = 0;
                }
            }
        }
    }

    void Load_interAds_Inmobi() {
        if (app_data != null && app_data.size() > 0) {
            if (isInmobiInterLoaded) {
                return;
            }
            Long placementId = app_data.get(0).getInmobi_inter_id().get(current_inmobi_IntrId);
            if (!(placementId == 0)) {
                final InMobiInterstitial inMobiInterstitial = new InMobiInterstitial(activity, placementId, new InterstitialAdEventListener() {
                    @Override
                    public void onAdFetchFailed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                        super.onAdFetchFailed(inMobiInterstitial, inMobiAdRequestStatus);
                    }

                    @Override
                    public void onAdFetchSuccessful(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull AdMetaInfo adMetaInfo) {
                        super.onAdFetchSuccessful(inMobiInterstitial, adMetaInfo);
                        Log.d("Parth", "Inmobi Inter Show");
                    }

                    public void onAdDismissed(@NonNull InMobiInterstitial ad) {
                        Log.d("Parth", "Inmobi Inter ad Close.");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onAdLoadSucceeded(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull AdMetaInfo adMetaInfo) {
                        super.onAdLoadSucceeded(inMobiInterstitial, adMetaInfo);
                        Log.d("Parth", "Inmobi Inter ad Loaded.");
                        Inmobi_inter = inMobiInterstitial;
                        isInmobiInterLoaded = true;
                    }

                    @Override
                    public void onAdLoadFailed(@NonNull InMobiInterstitial inMobiInterstitial, @NonNull InMobiAdRequestStatus inMobiAdRequestStatus) {
                        super.onAdLoadFailed(inMobiInterstitial, inMobiAdRequestStatus);
                        Log.d("Parth", "Inmobi Inter ad Failed" + inMobiAdRequestStatus);
                        inter_Ads();
                    }
                });
                inMobiInterstitial.load();
                current_inmobi_IntrId++;
                if (current_inmobi_IntrId == app_data.get(0).getInmobi_inter_id().size()) {
                    current_inmobi_IntrId = 0;
                }
            }

        }
    }

    // Local Mode
    void Load_interAds_Local() {
        if (isLocalInterLoaded) {
            return;
        }
        isLocalInterLoaded = true;
    }

    // TODO: 7/17/2023 Show Inter Ads
    public void show_Interstitial(getDataListner callback2) {
        callback = callback2;
        ad_inter_dialog = new Dialog(activity);
        ad_inter_dialog.requestWindowFeature(1);
        this.ad_inter_dialog.setContentView(R.layout.ad_progress_dialog);
        ad_inter_dialog.setCancelable(false);
        this.ad_inter_dialog.setCanceledOnTouchOutside(false);
        Objects.requireNonNull(this.ad_inter_dialog.getWindow()).setSoftInputMode(3);
        this.ad_inter_dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        this.ad_inter_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).isAds_show()) {
                if (app_data.get(0).isPreload_inter_ads()) {
                    if (isGoogleInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        ADMOBInterstitialAd.show((Activity) activity);
                                        isGoogleInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                ADMOBInterstitialAd.show((Activity) activity);
                                isGoogleInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isAdxInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        ADXInterstitialAd.show((Activity) activity);
                                        isAdxInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                ADXInterstitialAd.show((Activity) activity);
                                isAdxInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isFBInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        FB_interstitialAd.show();
                                        isFBInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                FB_interstitialAd.show();
                                isFBInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isApplovinInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        Applovin_maxInterstitialAd.showAd();
                                        isApplovinInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                Applovin_maxInterstitialAd.showAd();
                                isApplovinInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isWortiseInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        Wortise_inter.showAd();
                                        isWortiseInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                Wortise_inter.showAd();
                                isWortiseInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isInmobiInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        Inmobi_inter.show();
                                        isInmobiInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                Inmobi_inter.show();
                                isInmobiInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isLocalInterLoaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        show_Interstitial_local(callback2);
                                        isLocalInterLoaded = false;
                                        inter_Ads();
                                    }
                                }.start();
                            } else {
                                show_Interstitial_local(callback2);
                                isLocalInterLoaded = false;
                                inter_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isadmob_appopen_Loaded) {
                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                admob_appOpenAd_inter = null;
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            }
                        };
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        admob_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                                        admob_appOpenAd_inter.show((Activity) activity);
                                        Log.d("Parth", "Admob Appopen Show");
                                        isadmob_appopen_Loaded = false;
                                        appopen_Ads();
                                    }
                                }.start();
                            } else {
                                admob_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                                admob_appOpenAd_inter.show((Activity) activity);
                                Log.d("Parth", "Admob Appopen Show");
                                isadmob_appopen_Loaded = false;
                                appopen_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isadx_appopen_Loaded) {
                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                adx_appOpenAd_inter = null;
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            }
                        };
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        adx_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                                        adx_appOpenAd_inter.show((Activity) activity);
                                        Log.d("Parth", "Adx Appopen Show");
                                        isadx_appopen_Loaded = false;
                                        appopen_Ads();
                                    }
                                }.start();
                            } else {
                                adx_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                                adx_appOpenAd_inter.show((Activity) activity);
                                Log.d("Parth", "Adx Appopen Show");
                                isadx_appopen_Loaded = false;
                                appopen_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (iswortise_appopen_Loaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        if (wortise_open.isAvailable()) {
                                            wortise_open.showAd((Activity) activity);
                                            Log.d("Parth", "Wortise Appopen Show");
                                            iswortise_appopen_Loaded = false;
                                            appopen_Ads();
                                        }
                                    }
                                }.start();
                            } else {
                                if (wortise_open.isAvailable()) {
                                    wortise_open.showAd((Activity) activity);
                                    Log.d("Parth", "Wortise Appopen Show");
                                    iswortise_appopen_Loaded = false;
                                    appopen_Ads();
                                }
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (isapplovin_appopen_Loaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        if (applovin_appopen.isReady()) {
                                            applovin_appopen.showAd();
                                            Log.d("Parth", "Applovin Appopen Show");
                                            appopen_Ads();
                                        } else {
                                            applovin_appopen.loadAd();
                                        }
                                    }
                                }.start();
                            } else {
                                if (applovin_appopen.isReady()) {
                                    applovin_appopen.showAd();
                                    Log.d("Parth", "Applovin Appopen Show");
                                    appopen_Ads();
                                } else {
                                    applovin_appopen.loadAd();
                                }
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else if (islocal_appopen_Loaded) {
                        adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                        if (adCounter == app_data.get(0).getInterCount()) {
                            Inter_Count.getInstance(activity).storeClicks(1);
                            if (app_data.get(0).isApp_inter_dialog_how()) {
                                ad_inter_dialog.show();
                                new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                    @Override
                                    public void onTick(long millisUntilFinished) {
                                        double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                    }

                                    @Override
                                    public void onFinish() {
                                        ad_inter_dialog.dismiss();
                                        show_local_Appopen_inter(callback2);
                                        Log.d("Parth", "Local Appopen Show");
                                        islocal_appopen_Loaded = false;
                                        appopen_Ads();
                                    }
                                }.start();
                            } else {
                                show_local_Appopen_inter(callback2);
                                Log.d("Parth", "Local Appopen Show");
                                islocal_appopen_Loaded = false;
                                appopen_Ads();
                            }
                        } else {
                            adCounter = adCounter + 1;
                            Inter_Count.getInstance(activity).storeClicks(adCounter);
                            if (callback != null) {
                                callback.onSuccess();
                                callback = null;
                            }
                        }
                    } else {
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }
                } else {
                    adCounter = Inter_Count.getInstance(activity).getNumberOfClicks();
                    if (adCounter == app_data.get(0).getInterCount()) {
                        Inter_Count.getInstance(activity).storeClicks(1);
                        if (app_data.get(0).getAd_inter_type().equalsIgnoreCase("appopen")) {
                            appopen_Ads();
                        } else {
                            inter_Ads();
                        }
                    } else {
                        adCounter = adCounter + 1;
                        Inter_Count.getInstance(activity).storeClicks(adCounter);
                    }
                    if (isGoogleInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    ADMOBInterstitialAd.show((Activity) activity);
                                    isGoogleInterLoaded = false;
                                }
                            }.start();
                        } else {
                            ADMOBInterstitialAd.show((Activity) activity);
                            isGoogleInterLoaded = false;
                        }
                    } else if (isAdxInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    ADXInterstitialAd.show((Activity) activity);
                                    isAdxInterLoaded = false;
                                }
                            }.start();
                        } else {
                            ADXInterstitialAd.show((Activity) activity);
                            isAdxInterLoaded = false;
                        }
                    } else if (isFBInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    FB_interstitialAd.show();
                                    isFBInterLoaded = false;
                                }
                            }.start();
                        } else {
                            FB_interstitialAd.show();
                            isFBInterLoaded = false;
                        }
                    } else if (isApplovinInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    Applovin_maxInterstitialAd.showAd();
                                    isApplovinInterLoaded = false;
                                }
                            }.start();
                        } else {
                            Applovin_maxInterstitialAd.showAd();
                            isApplovinInterLoaded = false;
                        }
                    } else if (isWortiseInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    Wortise_inter.showAd();
                                    isWortiseInterLoaded = false;
                                }
                            }.start();
                        } else {
                            Wortise_inter.showAd();
                            isWortiseInterLoaded = false;
                        }
                    } else if (isInmobiInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    Inmobi_inter.show();
                                    isInmobiInterLoaded = false;
                                }
                            }.start();
                        } else {
                            Inmobi_inter.show();
                            isInmobiInterLoaded = false;
                        }
                    } else if (isLocalInterLoaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    show_Interstitial_local(callback2);
                                    isLocalInterLoaded = false;
                                }
                            }.start();
                        } else {
                            show_Interstitial_local(callback2);
                            isLocalInterLoaded = false;
                        }
                    } else if (isadmob_appopen_Loaded) {
                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                admob_appOpenAd_inter = null;
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            }
                        };
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    admob_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                                    admob_appOpenAd_inter.show((Activity) activity);
                                    Log.d("Parth", "Admob Appopen Show");
                                    isadmob_appopen_Loaded = false;
                                }
                            }.start();
                        } else {
                            admob_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                            admob_appOpenAd_inter.show((Activity) activity);
                            Log.d("Parth", "Admob Appopen Show");
                            isadmob_appopen_Loaded = false;
                        }
                    } else if (isadx_appopen_Loaded) {
                        FullScreenContentCallback fullScreenContentCallback = new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                adx_appOpenAd_inter = null;
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                            }
                        };
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    adx_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                                    adx_appOpenAd_inter.show((Activity) activity);
                                    Log.d("Parth", "Adx Appopen Show");
                                    isadx_appopen_Loaded = false;
                                }
                            }.start();
                        } else {
                            adx_appOpenAd_inter.setFullScreenContentCallback(fullScreenContentCallback);
                            adx_appOpenAd_inter.show((Activity) activity);
                            Log.d("Parth", "Adx Appopen Show");
                            isadx_appopen_Loaded = false;
                        }
                    } else if (iswortise_appopen_Loaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    if (wortise_open.isAvailable()) {
                                        wortise_open.showAd((Activity) activity);
                                        Log.d("Parth", "Wortise Appopen Show");
                                        iswortise_appopen_Loaded = false;
                                    }
                                }
                            }.start();
                        } else {
                            if (wortise_open.isAvailable()) {
                                wortise_open.showAd((Activity) activity);
                                Log.d("Parth", "Wortise Appopen Show");
                                iswortise_appopen_Loaded = false;
                            }
                        }
                    } else if (isapplovin_appopen_Loaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    if (applovin_appopen.isReady()) {
                                        applovin_appopen.showAd();
                                        Log.d("Parth", "Applovin Appopen Show");
                                    } else {
                                        applovin_appopen.loadAd();
                                    }
                                }
                            }.start();
                        } else {
                            if (applovin_appopen.isReady()) {
                                applovin_appopen.showAd();
                                Log.d("Parth", "Applovin Appopen Show");
                            } else {
                                applovin_appopen.loadAd();
                            }
                        }
                    } else if (islocal_appopen_Loaded) {
                        if (app_data.get(0).isApp_inter_dialog_how()) {
                            ad_inter_dialog.show();
                            new CountDownTimer(ad_dialog_time_in_second * 1000, 10) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    double time = (millisUntilFinished / 10) / ad_dialog_time_in_second;
                                }

                                @Override
                                public void onFinish() {
                                    ad_inter_dialog.dismiss();
                                    show_local_Appopen_inter(callback2);
                                    Log.d("Parth", "Local Appopen Show");
                                    islocal_appopen_Loaded = false;
                                }
                            }.start();
                        } else {
                            show_local_Appopen_inter(callback2);
                            Log.d("Parth", "Local Appopen Show");
                            islocal_appopen_Loaded = false;
                        }
                    } else {
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }
                }
            } else {
                if (callback != null) {
                    callback.onSuccess();
                    callback = null;
                }
            }
        }
    }

    // Local Mode
    static Animation animZoomIn;

    @SuppressLint("SetTextI18n")
    private void show_Interstitial_local(getDataListner myCallback2) {
        callback = myCallback2;
        if (app_data != null && app_data.size() > 0) {
            Dialog dialog = new Dialog(activity, R.style.FullWidth_Dialog);
            @SuppressLint("InflateParams") View view = LayoutInflater.from(activity).inflate(R.layout.local_inter_ad, null);
            dialog.setContentView(view);
            dialog.setCancelable(false);
            Window window = dialog.getWindow();
            Objects.requireNonNull(window).setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            animZoomIn = AnimationUtils.loadAnimation(activity, R.anim.slide_in_bottom);
            CardView cvTopAd = dialog.findViewById(R.id.cvTopAd);
            RelativeLayout lat1 = dialog.findViewById(R.id.lat1);
            TextView install = dialog.findViewById(R.id.install);
            ImageView ad_close = dialog.findViewById(R.id.ad_close);
            TextView App_name = dialog.findViewById(R.id.appname);
            ImageView appicon = dialog.findViewById(R.id.app_icon);
            ImageView ad_banner = dialog.findViewById(R.id.ad_banner);
            TextView app_ad_body = dialog.findViewById(R.id.ad_body);
            cvTopAd.startAnimation(animZoomIn);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(appicon);
                Glide.with(activity).load(app_data.get(0).getNew_app_banner()).into(ad_banner);
                App_name.setText(app_data.get(0).getNew_app_name());
                App_name.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                install.setText("Install");
            } catch (Exception ignored) {
            }
            install.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            });

            lat1.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dialog.dismiss();
            });
            new Handler().postDelayed(() -> {
                ad_close.setVisibility(View.VISIBLE);
                ad_close.setOnClickListener(v -> dialog.dismiss());
            }, 2500);
            dialog.setOnDismissListener(dialog1 -> {
                if (callback != null) {
                    callback.onSuccess();
                    callback = null;
                }
            });
            dialog.show();
        }
    }

    //---------------------------------------------- Appopen Ads ---------------------------------------------------------

    // TODO: 7/17/2023  Appopen Ads
    // Admob
    public void show_Admob_Appopen(getDataListner callback2) {
        callback = callback2;
        if (app_data != null && app_data.size() > 0) {
            FullScreenContentCallback fullScreenContentCallback_admob = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    admob_appOpenAd = null;
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAdShowedFullScreenContent() {
                }
            };
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    Log.d("Parth", "Admob Open Ad loaded");
                    admob_appOpenAd = appOpenAd;
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback_admob);
                    Log.d("Parth", "Admob Open Ad show");
                    appOpenAd.show((Activity) activity);
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.e("Parth", "Admob Open Failed" + loadAdError.getMessage());
                }
            };
            AppOpenAd.load(activity, app_data.get(0).getAdmobAppopenid(), getAdRequest(), loadCallback);
        }
    }

    // Adx
    public void show_Adx_Appopen(getDataListner callback2) {
        callback = callback2;
        if (app_data != null && app_data.size() > 0) {
            FullScreenContentCallback fullScreenContentCallback_adx = new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    adx_appOpenAd = null;
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAdShowedFullScreenContent() {
                }
            };
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    Log.d("Parth", "Adx Open Ad loaded");
                    adx_appOpenAd = appOpenAd;
                    appOpenAd.setFullScreenContentCallback(fullScreenContentCallback_adx);
                    Log.d("Parth", "Adx Open Ad show");
                    appOpenAd.show((Activity) activity);
                }

                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.e("Parth", "Admob Open Failed" + loadAdError.getMessage());
                }
            };
            AppOpenAd.load(activity, app_data.get(0).getAdxAppopenId(), adManagerAdRequest(), loadCallback);
        }
    }

    // Wortise
    public void show_Wortise_Appopen(getDataListner callback2) {
        callback = callback2;
        if (app_data != null && app_data.size() > 0) {
            final com.wortise.ads.appopen.AppOpenAd wortise_open_ad = new com.wortise.ads.appopen.AppOpenAd(activity, app_data.get(0).getWortiseAppopenId());
            wortise_open_ad.loadAd();
            wortise_open_ad.setListener(new com.wortise.ads.appopen.AppOpenAd.Listener() {
                @Override
                public void onAppOpenShown(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                }

                @Override
                public void onAppOpenLoaded(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                    Log.d("Parth", "Wortise Open Ad loaded");
                    if (appOpenAd.isAvailable()) {
                        appOpenAd.showAd((Activity) activity);
                        Log.d("Parth", "Wortise Open Ad show");
                    }
                }

                @Override
                public void onAppOpenFailed(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd, @NonNull com.wortise.ads.AdError adError) {
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAppOpenDismissed(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                    Log.d("Parth", "Wortise Open Ad Close");
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAppOpenClicked(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                }
            });
        }
    }

    // Applovin Appopen
    public void show_Applovin_Appopen(getDataListner dataListner) {
        callback = dataListner;
        if (app_data != null && app_data.size() > 0) {
            final MaxAppOpenAd applovin_appOpenAd = new MaxAppOpenAd(app_data.get(0).getApplovin_appopen_id(), activity);
            applovin_appOpenAd.loadAd();
            applovin_appOpenAd.setListener(new MaxAdListener() {
                @Override
                public void onAdLoaded(MaxAd maxAd) {
                    Log.d("Parth", "Applovin Open Ad loaded");
                    if (applovin_appOpenAd.isReady()) {
                        applovin_appOpenAd.showAd();
                        Log.d("Parth", "Applovin Open Ad show");
                    } else {
                        applovin_appOpenAd.loadAd();
                    }
                }

                @Override
                public void onAdDisplayed(MaxAd maxAd) {
                }

                @Override
                public void onAdHidden(MaxAd maxAd) {
                    Log.d("Parth", "Applovin Close Open Ad");
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAdClicked(MaxAd maxAd) {
                }

                @Override
                public void onAdLoadFailed(String s, MaxError maxError) {
                    Log.e("Parth", "Applovin Failed Open Ad" + maxError.getMessage());
                    if (callback != null) {
                        callback.onSuccess();
                        callback = null;
                    }
                }

                @Override
                public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                }
            });
        }
    }

    // Local Appopen
    @SuppressLint("SetTextI18n")
    public void show_local_Appopen(getDataListner callback2) {
        callback = callback2;
        if (app_data != null && app_data.size() > 0) {
            Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar);
            @SuppressLint("InflateParams") View view = LayoutInflater.from(activity).inflate(R.layout.local_appopen, null);
            dialog.setContentView(view);
            dialog.setCancelable(false);
            Window window = dialog.getWindow();
            Objects.requireNonNull(window).setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            RelativeLayout lay1 = dialog.findViewById(R.id.llPersonalAd);
            TextView install = dialog.findViewById(R.id.install);
            LinearLayout linearLayout = dialog.findViewById(R.id.ll_continue_app);
            TextView App_name = dialog.findViewById(R.id.txt_appname);
            ImageView appicon = dialog.findViewById(R.id.app_icon);
            ImageView ad_banner = dialog.findViewById(R.id.ad_banner);
            TextView app_ad_body = dialog.findViewById(R.id.ad_body);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(appicon);
                Glide.with(activity).load(app_data.get(0).getNew_app_banner()).into(ad_banner);
                App_name.setText(app_data.get(0).getNew_app_name());
                App_name.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                install.setText("Install");
            } catch (Exception ignored) {
            }
            install.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            lay1.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            linearLayout.setOnClickListener(v -> dialog.dismiss());

            dialog.setOnDismissListener(dialog1 -> {
                if (callback != null) {
                    callback.onSuccess();
                    callback = null;
                }
            });
            dialog.show();
            Log.d("Parth", "Local Open Ad show");
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    @SuppressLint("VisibleForTests")
    private AdManagerAdRequest adManagerAdRequest() {
        return new AdManagerAdRequest.Builder().build();
    }

    // TODO: 8/22/2023  Appopen Inter Ads
    int ad_appopen_inter_network = 0;

    private void appopen_Ads() {
        try {
            if (app_data != null && app_data.size() > 0) {
                if (app_data.get(0).isAds_show()) {
                    String[] adnetwork = app_data.get(0).getAd_open_inter().split(",");
                    if (ad_appopen_inter_network < adnetwork.length) {
                        switch (adnetwork[ad_appopen_inter_network]) {
                            case "admob":
                                get_admob_appopen_AdsLoad();
                                ad_appopen_inter_network++;
                                break;
                            case "adx":
                                get_adx_appopen_AdsLoad();
                                ad_appopen_inter_network++;
                                break;
                            case "applovin":
                                get_applovin_appopen_AdsLoad();
                                ad_appopen_inter_network++;
                                break;
                            case "wortise":
                                get_wortise_appopen_AdsLoad();
                                ad_appopen_inter_network++;
                                break;
                            case "local":
                                get_local_Appopen_AdLoad();
                                ad_appopen_inter_network++;
                            default:
                        }
                        if (ad_appopen_inter_network == adnetwork.length) {
                            ad_appopen_inter_network = 0;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // Admob
    void get_admob_appopen_AdsLoad() {
        if (app_data != null && app_data.size() > 0) {
            if (isadmob_appopen_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdmobAppopenid();
            if (!placementId.equalsIgnoreCase("")) {
                AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                    public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                        super.onAdLoaded(appOpenAd);
                        Log.d("Parth", "Admob Open Ad loaded");
                        admob_appOpenAd_inter = appOpenAd;
                        isadmob_appopen_Loaded = true;
                    }

                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.e("Parth", "Admob Open Failed" + loadAdError.getMessage());
                        appopen_Ads();
                    }
                };
                AppOpenAd.load(activity, placementId, getAdRequest(), loadCallback);
            }
        }
    }

    // Adx
    void get_adx_appopen_AdsLoad() {
        if (app_data != null && app_data.size() > 0) {
            if (isadx_appopen_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getAdxAppopenId();
            if (!placementId.equalsIgnoreCase("")) {
                AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                    public void onAdLoaded(@NonNull AppOpenAd appOpenAd) {
                        super.onAdLoaded(appOpenAd);
                        Log.d("Parth", "Adx Open Ad loaded");
                        adx_appOpenAd_inter = appOpenAd;
                        isadx_appopen_Loaded = true;
                    }

                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.e("Parth", "Adx Open Failed" + loadAdError.getMessage());
                        appopen_Ads();
                    }
                };
                AppOpenAd.load(activity, placementId, adManagerAdRequest(), loadCallback);
            }
        }
    }

    // Wortise
    void get_wortise_appopen_AdsLoad() {
        if (app_data != null && app_data.size() > 0) {
            if (iswortise_appopen_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getWortiseAppopenId();
            if (!placementId.equalsIgnoreCase("")) {
                final com.wortise.ads.appopen.AppOpenAd wortise_open_ad = new com.wortise.ads.appopen.AppOpenAd(activity, placementId);
                wortise_open_ad.loadAd();
                wortise_open_ad.setListener(new com.wortise.ads.appopen.AppOpenAd.Listener() {
                    @Override
                    public void onAppOpenShown(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                    }

                    @Override
                    public void onAppOpenLoaded(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                        Log.d("Parth", "Wortise Open Ad loaded");
                        wortise_open = wortise_open_ad;
                        iswortise_appopen_Loaded = true;
                    }

                    @Override
                    public void onAppOpenFailed(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Open Ad Failed" + adError);
                        appopen_Ads();
                    }

                    @Override
                    public void onAppOpenDismissed(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                        Log.d("Parth", "Wortise Open Ad Close");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                        iswortise_appopen_Loaded = false;
                    }

                    @Override
                    public void onAppOpenClicked(@NonNull com.wortise.ads.appopen.AppOpenAd appOpenAd) {
                    }
                });
            }
        }
    }

    // Applovin
    void get_applovin_appopen_AdsLoad() {
        if (app_data != null && app_data.size() > 0) {
            if (isapplovin_appopen_Loaded) {
                return;
            }
            String placementId = app_data.get(0).getApplovin_appopen_id();
            if (!placementId.equalsIgnoreCase("")) {
                final MaxAppOpenAd applovin_appOpenAd = new MaxAppOpenAd(placementId, activity);
                applovin_appOpenAd.loadAd();
                applovin_appOpenAd.setListener(new MaxAdListener() {
                    @Override
                    public void onAdLoaded(MaxAd maxAd) {
                        Log.d("Parth", "Applovin appopen Loaded");
                        applovin_appopen = applovin_appOpenAd;
                        isapplovin_appopen_Loaded = true;
                    }

                    @Override
                    public void onAdDisplayed(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdHidden(MaxAd maxAd) {
                        Log.d("Parth", "Applovin Appopen Close");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                        isapplovin_appopen_Loaded = false;
                    }

                    @Override
                    public void onAdClicked(MaxAd maxAd) {
                    }

                    @Override
                    public void onAdLoadFailed(String s, MaxError maxError) {
                        Log.e("Parth", "Applovin Failed Open Ad" + maxError.getMessage());
                        appopen_Ads();

                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
                    }
                });
            }
        }
    }

    // Local
    void get_local_Appopen_AdLoad() {
        if (islocal_appopen_Loaded) {
            return;
        }
        islocal_appopen_Loaded = true;
    }

    // Local Appopen
    @SuppressLint("SetTextI18n")
    private void show_local_Appopen_inter(getDataListner callback2) {
        callback = callback2;
        if (app_data != null && app_data.size() > 0) {
            Dialog dialog = new Dialog(activity, android.R.style.Theme_Translucent_NoTitleBar);
            @SuppressLint("InflateParams") View view = LayoutInflater.from(activity).inflate(R.layout.local_appopen, null);
            dialog.setContentView(view);
            dialog.setCancelable(false);
            Window window = dialog.getWindow();
            Objects.requireNonNull(window).setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            RelativeLayout lay1 = dialog.findViewById(R.id.llPersonalAd);
            TextView install = dialog.findViewById(R.id.install);
            LinearLayout linearLayout = dialog.findViewById(R.id.ll_continue_app);
            TextView App_name = dialog.findViewById(R.id.txt_appname);
            ImageView appicon = dialog.findViewById(R.id.app_icon);
            ImageView ad_banner = dialog.findViewById(R.id.ad_banner);
            TextView app_ad_body = dialog.findViewById(R.id.ad_body);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(appicon);
                Glide.with(activity).load(app_data.get(0).getNew_app_banner()).into(ad_banner);
                App_name.setText(app_data.get(0).getNew_app_name());
                App_name.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                install.setText("Install");
            } catch (Exception ignored) {
            }
            install.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            lay1.setOnClickListener(v -> {
                try {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setData(Uri.parse(app_data.get(0).getNew_app_link()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    activity.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            linearLayout.setOnClickListener(v -> dialog.dismiss());

            dialog.setOnDismissListener(dialog1 -> {
                if (callback != null) {
                    callback.onSuccess();
                    callback = null;
                }
            });
            dialog.show();
        }
    }

    // TODO: 8/10/2023  Splash Inter Ads
    void show_splash_inter(getDataListner callback3) {
        callback = callback3;
        if (app_data != null && app_data.size() > 0) {
            String admob_splash_inter = app_data.get(0).getAdmob_splash_interid();
            String adx_splash_inter = app_data.get(0).getAdx_splash_inter_id();
            String fb_splash_inter = app_data.get(0).getFb_splash_inter_id();
            String applovin_splash_inter = app_data.get(0).getApplovin_splash_interid();
            String wortise_splash_inter = app_data.get(0).getWortise_splash_inter_id();
            if (!admob_splash_inter.equalsIgnoreCase("")) {
                final AdRequest adRequest = new AdRequest.Builder().build();
                InterstitialAd.load(activity, admob_splash_inter, adRequest, new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        super.onAdLoaded(interstitialAd);
                        interstitialAd.show((Activity) activity);
                        interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("Parth", "Admob Inter Close");
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                Log.d("Parth", "Admob Inter failed to show" + adError.getMessage());
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                Log.d("Parth", "Admob Inter Show");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Inter Failed " + loadAdError);
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }
                });
            } else if (!adx_splash_inter.equalsIgnoreCase("")) {
                @SuppressLint("VisibleForTests") final AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                AdManagerInterstitialAd.load(activity, adx_splash_inter, adRequest, new AdManagerInterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull AdManagerInterstitialAd adManagerInterstitialAd) {
                        super.onAdLoaded(adManagerInterstitialAd);
                        adManagerInterstitialAd.show((Activity) activity);
                        adManagerInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                            @Override
                            public void onAdDismissedFullScreenContent() {
                                Log.d("Parth", "Admob Inter Close");
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdFailedToShowFullScreenContent(@NonNull com.google.android.gms.ads.AdError adError) {
                                Log.d("Parth", "Admob Inter failed to show" + adError.getMessage());
                                if (callback != null) {
                                    callback.onSuccess();
                                    callback = null;
                                }
                            }

                            @Override
                            public void onAdShowedFullScreenContent() {
                                Log.d("Parth", "Adx Inter Show");
                            }
                        });
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Inter Failed " + loadAdError);
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }
                });
            } else if (!fb_splash_inter.equalsIgnoreCase("")) {
                final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, fb_splash_inter);
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                    @Override
                    public void onInterstitialDisplayed(Ad ad) {
                        Log.d("Parth", "Fb Inter Show");
                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "Fb Inter Failed " + adError);
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        FB_interstitial.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {

                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                    }
                };
                FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
            } else if (!applovin_splash_inter.equalsIgnoreCase("")) {
                final MaxInterstitialAd interstitialAdmax = new MaxInterstitialAd(applovin_splash_inter, (Activity) activity);
                interstitialAdmax.setListener(new MaxAdListener() {
                    @Override
                    public void onAdLoaded(MaxAd ad) {
                        Log.d("Parth", "Applovin Inter Loaded");
                        interstitialAdmax.showAd();
                    }

                    @Override
                    public void onAdDisplayed(MaxAd ad) {
                        Log.d("Parth", "Applovin Inter Show");
                    }

                    @Override
                    public void onAdHidden(MaxAd ad) {
                        Log.d("Parth", "Applovin Inter Close");
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onAdClicked(MaxAd ad) {
                    }

                    @Override
                    public void onAdLoadFailed(String adUnitId, MaxError error) {
                        Log.d("Parth", "Applovin Inter Failed " + error);
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onAdDisplayFailed(MaxAd ad, MaxError error) {
                    }
                });
                interstitialAdmax.loadAd();
            } else if (!wortise_splash_inter.equalsIgnoreCase("")) {
                final com.wortise.ads.interstitial.InterstitialAd Wortise_inter_ad = new com.wortise.ads.interstitial.InterstitialAd(activity, app_data.get(0).getWortise_splash_inter_id());
                Wortise_inter_ad.loadAd();
                Wortise_inter_ad.setListener(new com.wortise.ads.interstitial.InterstitialAd.Listener() {
                    @Override
                    public void onInterstitialClicked(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onInterstitialFailed(@NonNull com.wortise.ads.interstitial.InterstitialAd ad, @NonNull com.wortise.ads.AdError error) {
                        Log.d("Parth", "Wortise Inter Failed to Load: " + error);
                        if (callback != null) {
                            callback.onSuccess();
                            callback = null;
                        }
                    }

                    @Override
                    public void onInterstitialLoaded(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                        Log.d("Parth", "Wortise Inter ad Loaded.");
                        Wortise_inter_ad.showAd();
                    }

                    @Override
                    public void onInterstitialShown(@NonNull com.wortise.ads.interstitial.InterstitialAd ad) {
                        Log.d("Parth", "Wortise Inter Show");
                    }
                });
            }
        }
    }
}