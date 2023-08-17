package com.ads.data;

import static com.ads.data.AdsControl.Applovin_native_ad;
import static com.ads.data.AdsControl.Applovin_small_native_Ad;
import static com.ads.data.AdsControl.Applovin_small_native_banner_Ad;
import static com.ads.data.AdsControl.admobMediam_Ragtangal;
import static com.ads.data.AdsControl.adxBannerAd;
import static com.ads.data.AdsControl.adxMediam_Ragtangal;
import static com.ads.data.AdsControl.app_data;
import static com.ads.data.AdsControl.applovin_Medium_Ragtangal_adview;
import static com.ads.data.AdsControl.applovin_banner_ad;
import static com.ads.data.AdsControl.applovin_maxnativeadview;
import static com.ads.data.AdsControl.applovin_small_native_Ad;
import static com.ads.data.AdsControl.applovin_small_native_banner_Ad;
import static com.ads.data.AdsControl.current_admob_BannerId;
import static com.ads.data.AdsControl.current_admob_medium_rectId;
import static com.ads.data.AdsControl.current_admob_native_Id;
import static com.ads.data.AdsControl.current_admob_small_native_BannerId;
import static com.ads.data.AdsControl.current_admob_small_native_Id;
import static com.ads.data.AdsControl.current_adx_BannerId;
import static com.ads.data.AdsControl.current_adx_medium_rectId;
import static com.ads.data.AdsControl.current_adx_native_Id;
import static com.ads.data.AdsControl.current_adx_small_native_BannerId;
import static com.ads.data.AdsControl.current_adx_small_native_Id;
import static com.ads.data.AdsControl.current_applovin_BannerId;
import static com.ads.data.AdsControl.current_applovin_medium_rectId;
import static com.ads.data.AdsControl.current_applovin_native_Id;
import static com.ads.data.AdsControl.current_applovin_small_native_BannerId;
import static com.ads.data.AdsControl.current_applovin_small_native_Id;
import static com.ads.data.AdsControl.current_fb_BannerId;
import static com.ads.data.AdsControl.current_fb_medium_rectId;
import static com.ads.data.AdsControl.current_fb_native_Id;
import static com.ads.data.AdsControl.current_fb_small_native_BannerId;
import static com.ads.data.AdsControl.current_fb_small_native_Id;
import static com.ads.data.AdsControl.current_wortise_BannerId;
import static com.ads.data.AdsControl.current_wortise_medium_rectId;
import static com.ads.data.AdsControl.current_wortise_native_Id;
import static com.ads.data.AdsControl.current_wortise_small_native_BannerId;
import static com.ads.data.AdsControl.current_wortise_small_native_Id;
import static com.ads.data.AdsControl.fb_Ragtangal_adView;
import static com.ads.data.AdsControl.fbadView;
import static com.ads.data.AdsControl.googleBannerAd;
import static com.ads.data.AdsControl.wBannerAd;
import static com.ads.data.AdsControl.w_medium_ragtangal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.wortise.ads.banner.BannerAd;
import com.wortise.ads.natives.GoogleNativeAd;

public class All_Type_Ads {
    Context activity;
    public static AdView extrgoogleBannerAd;
    public static AdManagerAdView extradxBannerAd;
    public static com.facebook.ads.AdView extrfbadView;
    public static BannerAd extrwBannerAd;
    public static MaxAdView extraapplovin_banner_ad;

    public static AdView extraadmobMediam_Ragtangal;
    public static AdManagerAdView extraadxMediam_Ragtangal;
    public static com.facebook.ads.AdView extrafb_Ragtangal_adView;
    public static MaxAdView extra_applovin_Medium_Ragtangal_adview;
    public static BannerAd extraw_medium_ragtangal;
    private ViewGroup parentView;
    private ViewGroup mrec_parentView;

    public All_Type_Ads(Context context) {
        this.activity = context;
    }

    //==================================================== Banner Ads ==================================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_Admob(final ViewGroup banner_container) {
        if (AdsControl.isGoogleBannerLoaded) {
            extrgoogleBannerAd = googleBannerAd;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrgoogleBannerAd != null) {
                    Log.d("Parth", "show Admob Banner Ad");
                    banner_container.removeAllViews();
                    banner_container.addView(extrgoogleBannerAd);
                    parentView = banner_container;
                }
                AdsControl.isGoogleBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Admob
                final AdView admob_Banner = new AdView(activity);
                admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                admob_Banner.setAdUnitId(app_data.get(0).getAdmobBannerid().get(current_admob_BannerId));
                AdRequest adRequest = new AdRequest.Builder().build();
                admob_Banner.loadAd(adRequest);
                admob_Banner.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        Log.d("Parth", "Admob Banner Loaded");
                        try {
                            if (parentView != null) {
                                parentView.removeAllViews();
                            }
                            if (banner_container != null && admob_Banner != null) {
                                Log.d("Parth", "show Admob Banner Ad");
                                banner_container.removeAllViews();
                                banner_container.addView(admob_Banner);
                                parentView = banner_container;
                            }
                            AdsControl.isGoogleBannerLoaded = false;
                            AdsControl.getInstance(activity).banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        super.onAdFailedToLoad(adError);
                        Log.d("Parth", "Admob Banner Failed");
                        AdsControl.isGoogleBannerLoaded = false;
                        AdsControl.getInstance(activity).banner_Ads();
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
    public void show_banner_ad_Adx(final ViewGroup banner_container) {
        if (AdsControl.isAdxBannerLoaded) {
            extradxBannerAd = adxBannerAd;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extradxBannerAd != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Adx Banner Ad");
                    banner_container.addView(extradxBannerAd);
                    parentView = banner_container;
                }
                AdsControl.isAdxBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Adx
                final AdManagerAdView adx_Banner = new AdManagerAdView(activity);
                adx_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
                adx_Banner.setAdUnitId(app_data.get(0).getAdxBannerId().get(current_adx_BannerId));
                @SuppressLint("VisibleForTests") AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                adx_Banner.loadAd(adRequest);
                adx_Banner.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.d("Parth", "Adx Banner Loadedd ");
                        try {
                            if (parentView != null) {
                                parentView.removeAllViews();
                            }
                            if (banner_container != null && adx_Banner != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Adx Banner Ad");
                                banner_container.addView(adx_Banner);
                                parentView = banner_container;
                            }
                            AdsControl.isAdxBannerLoaded = false;
                            AdsControl.getInstance(activity).banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        AdsControl.isAdxBannerLoaded = false;
                        AdsControl.getInstance(activity).banner_Ads();
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
    @SuppressLint("MissingPermission")
    public void show_banner_ad_FB(final ViewGroup banner_container) {
        if (AdsControl.isFBBannerLoaded) {
            extrfbadView = fbadView;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrfbadView != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Fb Banner Ad");
                    banner_container.addView(extrfbadView);
                    parentView = banner_container;
                }
                AdsControl.isFBBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // FB
                final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, app_data.get(0).getFbBannerId().get(current_fb_BannerId), com.facebook.ads.AdSize.BANNER_HEIGHT_50);
                com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "Fb Banner Loadedd ");
                        try {
                            if (parentView != null) {
                                parentView.removeAllViews();
                            }
                            if (banner_container != null && fb_banner != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Fb Banner Ad");
                                banner_container.addView(fb_banner);
                                parentView = banner_container;
                            }
                            AdsControl.isFBBannerLoaded = false;
                            AdsControl.getInstance(activity).banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Banner Failed");
                        AdsControl.isFBBannerLoaded = false;
                        AdsControl.getInstance(activity).banner_Ads();
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

    // Wortise Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_Wortise(final ViewGroup banner_container) {
        if (AdsControl.isWortiseBannerLoaded) {
            extrwBannerAd = wBannerAd;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrwBannerAd != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Wortise Banner Ad");
                    banner_container.addView(extrwBannerAd);
                    parentView = banner_container;
                }
                AdsControl.isWortiseBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Wortise
                final BannerAd wortise_BannerAd = new BannerAd(activity);
                wortise_BannerAd.setAdSize(com.wortise.ads.AdSize.HEIGHT_50);
                wortise_BannerAd.setAdUnitId(app_data.get(0).getWortiseBannerId().get(current_wortise_BannerId));
                wortise_BannerAd.loadAd();
                wortise_BannerAd.setListener(new BannerAd.Listener() {
                    @Override
                    public void onBannerLoaded(@NonNull BannerAd bannerAd) {
                        Log.d("Parth", "Wortise Banner Loadedd ");
                        try {
                            if (parentView != null) {
                                parentView.removeAllViews();
                            }
                            if (banner_container != null && wortise_BannerAd != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Wortise Banner Ad");
                                banner_container.addView(wortise_BannerAd);
                                parentView = banner_container;
                            }
                            AdsControl.isWortiseBannerLoaded = false;
                            AdsControl.getInstance(activity).banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onBannerClicked(@NonNull BannerAd bannerAd) {
                    }

                    @Override
                    public void onBannerFailed(@NonNull BannerAd bannerAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise banner onError: " + adError);
                        AdsControl.isWortiseBannerLoaded = false;
                        AdsControl.getInstance(activity).banner_Ads();
                    }
                });
                current_wortise_BannerId++;
                if (current_wortise_BannerId == app_data.get(0).getWortiseBannerId().size()) {
                    current_wortise_BannerId = 0;
                }
            }
        }
    }

    // Applovin Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_Applovin(final ViewGroup banner_container) {
        if (AdsControl.isApplovinBannerLoaded) {
            extraapplovin_banner_ad = applovin_banner_ad;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extraapplovin_banner_ad != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Applovin Banner Ad");
                    banner_container.addView(extraapplovin_banner_ad);
                    parentView = banner_container;
                }
                AdsControl.isApplovinBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                final MaxAdView applo_banner_ad = new MaxAdView(app_data.get(0).getApplovin_banner_id().get(current_applovin_BannerId), MaxAdFormat.BANNER, activity);
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
                        try {
                            if (parentView != null) {
                                parentView.removeAllViews();
                            }
                            if (banner_container != null && applo_banner_ad != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Applovin Banner Ad");
                                banner_container.addView(applo_banner_ad);
                                parentView = banner_container;
                            }
                            AdsControl.isApplovinBannerLoaded = false;
                            AdsControl.getInstance(activity).banner_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
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
                        Log.d("Parth", "Applovin Banner Failed");
                        AdsControl.isApplovinBannerLoaded = false;
                        AdsControl.getInstance(activity).banner_Ads();
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


    //===================================================== Small Native Banner Ad ====================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob(final ViewGroup native_banner_ad) {
        if (AdsControl.isadmob_small_native_banner_Loaded) {
            Log.d("Parth", "Admob Native Banner ad show");
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Admob_small_native_banner_Ad, native_banner_ad);
            AdsControl.isadmob_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Admob
                final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid().get(current_admob_small_native_BannerId));
                builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Admob Native Banner ad show");
                        new NativeAds(activity).Admob_Small_Native_Banner_Ad(nativeAd, native_banner_ad);
                        AdsControl.isadmob_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
                    }
                });
                builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Small Native Banner Ad Failed");
                        AdsControl.isadmob_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
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
    public void show_samll_native_bannerad_Adx(final ViewGroup native_banner_ad) {
        if (AdsControl.isadx_small_native_banner_Loaded) {
            Log.d("Parth", "Adx Native Banner ad show");
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Adx_small_native_banner_Ad, native_banner_ad);
            AdsControl.isadx_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Adx
                final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId().get(current_adx_small_native_BannerId));
                builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Adx Native Banner ad show");
                        new NativeAds(activity).Admob_Small_Native_Banner_Ad(nativeAd, native_banner_ad);
                        AdsControl.isadx_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
                    }
                });
                builder.withAdListener(new AdListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Small Native Banner Ad Failed");
                        AdsControl.isadx_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
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
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_FB(final ViewGroup native_banner_ad) {
        if (AdsControl.isFB_small_native_banner_Loaded) {
            Log.d("Parth", "FB Native Banner ad show");
            new NativeAds(activity).FB_Smalle_Native_Banner(AdsControl.fb_small_native_banner_Ad, native_banner_ad);
            AdsControl.isFB_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // fb
                final NativeBannerAd fb_nativeBanner_Ad = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId().get(current_fb_small_native_BannerId));
                NativeAdListener nativeAdListener = new NativeAdListener() {
                    @Override
                    public void onMediaDownloaded(Ad ad) {
                        Log.d("Parth", "FB Native ad finished downloading all assets.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Native ad failed to load: " + adError.getErrorMessage());
                        AdsControl.isFB_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "FB Native Banner ad show");
                        new NativeAds(activity).FB_Smalle_Native_Banner(fb_nativeBanner_Ad, native_banner_ad);
                        AdsControl.isFB_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
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
    @SuppressLint("MissingPermission")
    public void show_small_native_banner_ad_Applovin(final ViewGroup native_banner_ad) {
        if (AdsControl.isApplovin_small_native_banner_Loaded) {
            Log.d("Parth", "Applovin Small Native Banner ad show");
            if (Applovin_small_native_banner_Ad != null) {
                native_banner_ad.removeAllViews();
            }
            native_banner_ad.removeAllViews();
            native_banner_ad.addView(applovin_small_native_banner_Ad);
            AdsControl.isApplovin_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Applovin
                final MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(app_data.get(0).getApplovin_small_native_bannerid().get(current_applovin_small_native_BannerId), activity);
                nativeAdLoader.setRevenueListener(ad -> {
                });
                nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                    @Override
                    public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                        Log.d("Parth", "Applovin Small Native Banner ad Loaded");
                        if (ad != null) {
                            nativeAdLoader.destroy(ad);
                        }
                        native_banner_ad.removeAllViews();
                        native_banner_ad.addView(nativeAdView);
                        AdsControl.isApplovin_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
                    }

                    @Override
                    public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                        Log.d("Parth", "Applovin Small Native Banner ad Failed " + error.getMessage());
                        AdsControl.isApplovin_small_native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
                    }

                    @Override
                    public void onNativeAdClicked(final MaxAd ad) {
                    }
                });
                nativeAdLoader.loadAd(new NativeAds(activity).create_Small_NativeAdView());
                current_applovin_small_native_BannerId++;
                if (current_applovin_small_native_BannerId == app_data.get(0).getApplovin_small_native_bannerid().size()) {
                    current_applovin_small_native_BannerId = 0;
                }
            }
        }
    }

    // Wortise Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_wortise(final ViewGroup native_banner_ad) {
        if (AdsControl.isWortise_small_Native_banner_Loaded) {
            Log.d("Parth", "Wortise Native Banner ad show");
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.wortise_small_native_banner_Ad, native_banner_ad);
            AdsControl.isWortise_small_Native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Wortise
                final GoogleNativeAd wortise_google_native_banner = new GoogleNativeAd(activity, app_data.get(0).getWortiseNativeId().get(current_wortise_small_native_BannerId), new GoogleNativeAd.Listener() {
                    @Override
                    public void onNativeClicked(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeFailed(@NonNull GoogleNativeAd googleNativeAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Small Native Banner Ad Failed");
                        AdsControl.isWortise_small_Native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
                    }

                    @Override
                    public void onNativeImpression(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeLoaded(@NonNull GoogleNativeAd googleNativeAd, @NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Wortise Native Banner ad show");
                        new NativeAds(activity).Admob_Small_Native_Banner_Ad(nativeAd, native_banner_ad);
                        AdsControl.isWortise_small_Native_banner_Loaded = false;
                        AdsControl.getInstance(activity).small_native_banner_Ads();
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
    public void show_local_native_banner_ad(ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            RelativeLayout custm_native = (RelativeLayout) native_banner_ad.findViewById(R.id.custm_native_ad);
            ImageView app_icon_native = (ImageView) native_banner_ad.findViewById(R.id.ad_app_icon);
            TextView app_name_native = (TextView) native_banner_ad.findViewById(R.id.ad_headline);
            TextView app_ad_body = (TextView) native_banner_ad.findViewById(R.id.ad_body);
            TextView ad_call_to_action = (TextView) native_banner_ad.findViewById(R.id.ad_call_to_action);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(app_icon_native);
                app_name_native.setText(app_data.get(0).getNew_app_name());
                app_name_native.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                ad_call_to_action.setText("Install");
            } catch (Exception e) {
            }
            custm_native.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW")
                                .setData(Uri.parse(app_data.get(0).getNew_app_link()));
                        activity.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            AdsControl.isLocal_small_Native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        }
    }

    //===================================================== Small Native Ad ==============================================================

    @SuppressLint("MissingPermission")
    public void show_small_native_Admob(final ViewGroup small_native) {
        if (AdsControl.isAdmob_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Admob_small_native_Ad, small_native);
            Log.d("Parth", "Admob Small Native ad show");
            AdsControl.isAdmob_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Admob
                final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid().get(current_admob_small_native_Id));
                builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                        new NativeAds(activity).Admob_Small_Native_Ad(nativeAd, small_native);
                        Log.d("Parth", "Admob Small Native ad show");
                        AdsControl.isAdmob_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
                    }
                });
                builder.withAdListener(new AdListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Small Native Ad Failed");
                        AdsControl.isAdmob_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
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

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx(final ViewGroup small_native) {
        if (AdsControl.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Adx_small_native_Ad, small_native);
            Log.d("Parth", "Adx Small Native ad show");
            AdsControl.isadx_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Adx
                final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId().get(current_adx_small_native_Id));
                builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Adx Small Native ad show");
                        new NativeAds(activity).Admob_Small_Native_Ad(nativeAd, small_native);
                        AdsControl.isadx_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
                    }
                });
                builder.withAdListener(new AdListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Small Native Ad Failed");
                        AdsControl.isadx_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
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

    @SuppressLint("MissingPermission")
    public void show_small_native_FB(final ViewGroup small_native) {
        if (AdsControl.isFb_small_native_Loaded) {
            Log.d("Parth", "FB Small Native ad show");
            new NativeAds(activity).FB_Smalle_Native(AdsControl.fb_small_native_Ad, small_native);
            AdsControl.isFb_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // fb
                final NativeBannerAd fb_small_native = new NativeBannerAd(activity, app_data.get(0).getFbNativeBannerId().get(current_fb_small_native_Id));
                NativeAdListener nativeAdListener = new NativeAdListener() {

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "FB Small Native ad show");
                        new NativeAds(activity).FB_Smalle_Native(fb_small_native, small_native);
                        AdsControl.isFb_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
                    }

                    @Override
                    public void onMediaDownloaded(Ad ad) {
                        // Native ad finished downloading all assets
                        Log.d("Parth", "FB Small Native ad finished downloading all assets.");
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB Small Native ad failed to load: " + adError.getErrorMessage());
                        AdsControl.isFb_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        Log.d("Parth", "FB Small Native ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        Log.d("Parth", "FB Small Native ad impression logged!");
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

    @SuppressLint("MissingPermission")
    public void show_small_native_ad_Applovin(final ViewGroup small_native) {
        if (AdsControl.isapplovin_small_native_Loaded) {
            Log.d("Parth", "Applovin Small Native ad show");
            if (Applovin_small_native_Ad != null) {
                small_native.removeAllViews();
            }
            small_native.removeAllViews();
            small_native.addView(applovin_small_native_Ad);
            AdsControl.isapplovin_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Applovin
                final MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(app_data.get(0).getApplovin_small_nativeid().get(current_applovin_small_native_Id), activity);
                nativeAdLoader.setRevenueListener(ad -> {
                });
                nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                    @Override
                    public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                        Log.d("Parth", "Applovin Small Native ad Loaded");
                        if (ad != null) {
                            nativeAdLoader.destroy(ad);
                        }
                        small_native.removeAllViews();
                        small_native.addView(nativeAdView);
                        AdsControl.isapplovin_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
                    }

                    @Override
                    public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                        Log.d("Parth", "Applovin Small Native ad Failed " + error.getMessage());
                        AdsControl.isapplovin_small_native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
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

    @SuppressLint("MissingPermission")
    public void show_small_native_Wortise(final ViewGroup small_native) {
        if (AdsControl.isWortise_small_Native_Loaded) {
            Log.d("Parth", "Wortise Small Native ad show");
            new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.wortise_small_native_Ad, small_native);
            AdsControl.isWortise_small_Native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Wortise
                final GoogleNativeAd wortise_google_small_native = new GoogleNativeAd(activity, app_data.get(0).getWortiseNativeId().get(current_wortise_small_native_Id), new GoogleNativeAd.Listener() {
                    @Override
                    public void onNativeClicked(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onNativeFailed(@NonNull GoogleNativeAd googleNativeAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Small Native Ad Failed");
                        AdsControl.isWortise_small_Native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
                    }

                    @Override
                    public void onNativeImpression(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeLoaded(@NonNull GoogleNativeAd googleNativeAd, @NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Wortise Small Native ad show");
                        new NativeAds(activity).Admob_Small_Native_Ad(nativeAd, small_native);
                        AdsControl.isWortise_small_Native_Loaded = false;
                        AdsControl.getInstance(activity).small_native_Ads();
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
    public void show_local_small_native(ViewGroup native_banner_ad) {
        if (app_data != null && app_data.size() > 0) {
            RelativeLayout custm_native = (RelativeLayout) native_banner_ad.findViewById(R.id.custm_small_native_ad);
            ImageView app_icon_native = (ImageView) native_banner_ad.findViewById(R.id.ad_app_icon);
            TextView app_name_native = (TextView) native_banner_ad.findViewById(R.id.ad_Tital);
            TextView app_ad_body = (TextView) native_banner_ad.findViewById(R.id.ad_body);
            TextView ad_call_to_action = (TextView) native_banner_ad.findViewById(R.id.ad_call_to_action);
            try {
                Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(app_icon_native);
                app_name_native.setText(app_data.get(0).getNew_app_name());
                app_name_native.setSelected(true);
                app_ad_body.setText(app_data.get(0).getNew_app_body());
                app_ad_body.setSelected(true);
                ad_call_to_action.setText("Install");
            } catch (Exception e) {
            }
            custm_native.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("WrongConstant")
                @Override
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent("android.intent.action.VIEW")
                                .setData(Uri.parse(app_data.get(0).getNew_app_link()));
                        activity.startActivity(intent);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            AdsControl.isLocal_small_Native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        }
    }


    //====================================================== Native Ad =====================================================================

    @SuppressLint("MissingPermission")
    public void show_native_ad_Admob(final ViewGroup native_ad) {
        if (AdsControl.isadmob_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(AdsControl.Admob_native_Ad, native_ad);
            Log.d("Parth", "Admob Native ad show");
            AdsControl.isadmob_native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Admob Native
                final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdmobNativeid().get(current_admob_native_Id));
                builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Admob Native ad show");
                        new NativeAds(activity).Admob_NativeAd(nativeAd, native_ad);
                        AdsControl.isadmob_native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
                    }
                });
                builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Admob Native Ad Failed");
                        AdsControl.isadmob_native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
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

    @SuppressLint("MissingPermission")
    public void show_native_ad_Adx(final ViewGroup native_ad) {
        if (AdsControl.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(AdsControl.Adx_native_Ad, native_ad);
            Log.d("Parth", "Adx Native ad show");
            AdsControl.isadx_native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Adx
                final AdLoader.Builder builder = new AdLoader.Builder(activity, app_data.get(0).getAdxNativeId().get(current_adx_native_Id));
                builder.forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                    @Override
                    public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                        Log.d("Parth", "Adx Native Ad Loaded");
                        new NativeAds(activity).Admob_NativeAd(nativeAd, native_ad);
                        AdsControl.isadx_native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
                    }
                });
                builder.withAdListener(new AdListener() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        Log.d("Parth", "Adx Native Ad Failed");
                        AdsControl.isadx_native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
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

    @SuppressLint("MissingPermission")
    public void show_native_ad_FB(final ViewGroup native_ad) {
        if (AdsControl.isFB_Native_Loaded) {
            new NativeAds(activity).FB_Native(AdsControl.fb_native_Ad, native_ad);
            Log.d("Parth", "FB Native ad show");
            AdsControl.isFB_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                //Fb
                final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, app_data.get(0).getFbNativeId().get(current_fb_native_Id));
                NativeAdListener nativeAdListener = new NativeAdListener() {
                    @Override
                    public void onMediaDownloaded(Ad ad) {
                        // Native ad finished downloading all assets
                        Log.d("Parth", "Native ad finished downloading all assets.");
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "Native ad Failed " + adError.getErrorMessage());
                        AdsControl.isFB_Native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        new NativeAds(activity).FB_Native(fbnative_Ad, native_ad);
                        Log.d("Parth", "FB Native ad show");
                        AdsControl.isFB_Native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        Log.d("Parth", "Native ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        Log.d("Parth", "Native ad impression logged!");
                    }
                };
                // Request an ad
//            fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).build());
                fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
                current_fb_native_Id++;
                if (current_fb_native_Id == app_data.get(0).getFbNativeId().size()) {
                    current_fb_native_Id = 0;
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_Applovin(final ViewGroup native_ad) {
        if (AdsControl.isApplovin_Native_Loaded) {
            Log.d("Parth", "Admob Native ad show");
            if (Applovin_native_ad != null) {
                native_ad.removeAllViews();
            }
            native_ad.removeAllViews();
            native_ad.addView(applovin_maxnativeadview);
            AdsControl.isApplovin_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Applovin
                final MaxNativeAdLoader nativeAdLoader = new MaxNativeAdLoader(app_data.get(0).getApplovin_nativeid().get(current_applovin_native_Id), activity);
                nativeAdLoader.setRevenueListener(ad -> {
                });
                nativeAdLoader.setNativeAdListener(new MaxNativeAdListener() {
                    @Override
                    public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad) {
                        Log.d("Parth", "Applovin Native ad Loaded");
                        if (ad != null) {
                            nativeAdLoader.destroy(ad);
                        }
                        native_ad.removeAllViews();
                        native_ad.addView(nativeAdView);
                        AdsControl.isApplovin_Native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
                    }

                    @Override
                    public void onNativeAdLoadFailed(final String adUnitId, final MaxError error) {
                        Log.d("Parth", "Applovin Native ad Failed " + error.getMessage());
                        AdsControl.isApplovin_Native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
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

    @SuppressLint("MissingPermission")
    public void show_native_ad_Wortise(final ViewGroup native_ad) {
        if (AdsControl.isWortise_Native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(AdsControl.wortise_native_Ad, native_ad);
            Log.d("Parth", "Wortise Native ad show");
            AdsControl.isWortise_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Wortise Native
                final GoogleNativeAd wortise_google_native = new GoogleNativeAd(activity, app_data.get(0).getWortiseNativeId().get(current_wortise_native_Id), new GoogleNativeAd.Listener() {
                    @Override
                    public void onNativeClicked(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @SuppressLint("MissingPermission")
                    @Override
                    public void onNativeFailed(@NonNull GoogleNativeAd googleNativeAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Native ad Failed");
                        AdsControl.isWortise_Native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
                    }

                    @Override
                    public void onNativeImpression(@NonNull GoogleNativeAd googleNativeAd) {
                    }

                    @Override
                    public void onNativeLoaded(@NonNull GoogleNativeAd googleNativeAd, @NonNull NativeAd nativeAd) {
                        new NativeAds(activity).Admob_NativeAd(nativeAd, native_ad);
                        Log.d("Parth", "Wortise Native ad show");
                        AdsControl.isWortise_Native_Loaded = false;
                        AdsControl.getInstance(activity).native_Ads();
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
    public void show_local_native(ViewGroup banner_container) {
        if (app_data != null && app_data.size() > 0) {
            if (AdsControl.isLocal_Native_Loaded) {
                RelativeLayout custm_native = (RelativeLayout) banner_container.findViewById(R.id.custm_native_ad);
                ImageView app_icon_native = (ImageView) banner_container.findViewById(R.id.ad_app_icon);
                TextView app_name_native = (TextView) banner_container.findViewById(R.id.ad_headline);
                ImageView app_banner = (ImageView) banner_container.findViewById(R.id.ad_banner);
                TextView app_ad_body = (TextView) banner_container.findViewById(R.id.ad_body);
                TextView ad_call_to_action = (TextView) banner_container.findViewById(R.id.ad_call_to_action);
                try {
                    Glide.with(activity).load(app_data.get(0).getNew_app_icon()).into(app_icon_native);
                    Glide.with(activity).load(app_data.get(0).getNew_app_banner()).into(app_banner);
                    app_name_native.setText(app_data.get(0).getNew_app_name());
                    app_name_native.setSelected(true);
                    app_ad_body.setText(app_data.get(0).getNew_app_body());
                    app_ad_body.setSelected(true);
                    ad_call_to_action.setText("Install");
                } catch (Exception e) {
                }
                custm_native.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("WrongConstant")
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent("android.intent.action.VIEW")
                                    .setData(Uri.parse(app_data.get(0).getNew_app_link()));
                            activity.startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            AdsControl.isLocal_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        }
    }

    //====================================================== Medium Rect Ad =====================================================
    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_medium_ad_Admob(final ViewGroup banner_container) {
        if (AdsControl.isAdmob_Mediam_Ragtangal_Loaded) {
            extraadmobMediam_Ragtangal = admobMediam_Ragtangal;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (banner_container != null && extraadmobMediam_Ragtangal != null) {
                    Log.d("Parth", "show Admob mediam ragtangal Ad");
                    banner_container.removeAllViews();
                    banner_container.addView(extraadmobMediam_Ragtangal);
                    mrec_parentView = banner_container;
                }
                AdsControl.isAdmob_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Admob
                final AdView admob_Mediam_Ragtangal = new AdView(activity);
                admob_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
                admob_Mediam_Ragtangal.setAdUnitId(app_data.get(0).getAdmobMediumRectangleid().get(current_admob_medium_rectId));
                AdRequest adRequest = new AdRequest.Builder().build();
                admob_Mediam_Ragtangal.loadAd(adRequest);
                admob_Mediam_Ragtangal.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        Log.d("Parth", "admob mediam ragtangal loaded");
                        try {
                            if (mrec_parentView != null) {
                                mrec_parentView.removeAllViews();
                            }
                            if (banner_container != null && admob_Mediam_Ragtangal != null) {
                                Log.d("Parth", "show Admob mediam ragtangal Ad");
                                banner_container.removeAllViews();
                                banner_container.addView(admob_Mediam_Ragtangal);
                                mrec_parentView = banner_container;
                            }
                            AdsControl.isAdmob_Mediam_Ragtangal_Loaded = false;
                            AdsControl.getInstance(activity).medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError adError) {
                        super.onAdFailedToLoad(adError);
                        Log.d("Parth", "Admob Banner Failed");
                        AdsControl.isAdmob_Mediam_Ragtangal_Loaded = false;
                        AdsControl.getInstance(activity).medium_rect_Ads();
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
    public void show_medium_ad_Adx(final ViewGroup banner_container) {
        if (AdsControl.isAdx_Mediam_Ragtangal_Loaded) {
            extraadxMediam_Ragtangal = adxMediam_Ragtangal;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (banner_container != null && extraadxMediam_Ragtangal != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Adx mediam ragtangal Ad");
                    banner_container.addView(extraadxMediam_Ragtangal);
                    mrec_parentView = banner_container;
                }
                AdsControl.isAdx_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Adx
                final AdManagerAdView adx_Mediam_Ragtangal = new AdManagerAdView(activity);
                adx_Mediam_Ragtangal.setAdSize(AdSize.MEDIUM_RECTANGLE);
                adx_Mediam_Ragtangal.setAdUnitId(app_data.get(0).getAdxMediumRectangleid().get(current_adx_medium_rectId));
                AdManagerAdRequest adRequest = new AdManagerAdRequest.Builder().build();
                adx_Mediam_Ragtangal.loadAd(adRequest);
                adx_Mediam_Ragtangal.setAdListener(new AdListener() {
                    @Override
                    public void onAdLoaded() {
                        super.onAdLoaded();
                        Log.d("Parth", "adx mediam ragtangal loaded");
                        try {
                            if (mrec_parentView != null) {
                                mrec_parentView.removeAllViews();
                            }
                            if (banner_container != null && adx_Mediam_Ragtangal != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Adx mediam ragtangal Ad");
                                banner_container.addView(adx_Mediam_Ragtangal);
                                mrec_parentView = banner_container;
                            }
                            AdsControl.isAdx_Mediam_Ragtangal_Loaded = false;
                            AdsControl.getInstance(activity).medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        super.onAdFailedToLoad(loadAdError);
                        AdsControl.isAdx_Mediam_Ragtangal_Loaded = false;
                        AdsControl.getInstance(activity).medium_rect_Ads();
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
    @SuppressLint("MissingPermission")
    public void show_medium_ad_FB(final ViewGroup banner_container) {
        if (AdsControl.isFB_Mediam_Ragtangal_Loaded) {
            extrafb_Ragtangal_adView = fb_Ragtangal_adView;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (banner_container != null && extrafb_Ragtangal_adView != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Fb mediam ragtangal Ad");
                    banner_container.addView(extrafb_Ragtangal_adView);
                    mrec_parentView = banner_container;
                }
                AdsControl.isFB_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // FB
                final com.facebook.ads.AdView fb_Ragtangal = new com.facebook.ads.AdView(activity, app_data.get(0).getFbMediumRectangleId().get(current_fb_medium_rectId), com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250);
                com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d("Parth", "Fb mediam ragtangal Loadedd ");
                        try {
                            if (mrec_parentView != null) {
                                mrec_parentView.removeAllViews();
                            }
                            if (banner_container != null && fb_Ragtangal != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Fb mediam ragtangal Ad");
                                banner_container.addView(fb_Ragtangal);
                                mrec_parentView = banner_container;
                            }
                            AdsControl.isFB_Mediam_Ragtangal_Loaded = false;
                            AdsControl.getInstance(activity).medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        Log.d("Parth", "FB mediam ragtangal Failed");
                        AdsControl.isFB_Mediam_Ragtangal_Loaded = false;
                        AdsControl.getInstance(activity).medium_rect_Ads();
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
    @SuppressLint("MissingPermission")
    public void show_medium_ad_Applovin(final ViewGroup banner_container) {
        if (AdsControl.isApplovin_Mediam_Ragtangal_Loaded) {
            extra_applovin_Medium_Ragtangal_adview = applovin_Medium_Ragtangal_adview;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (banner_container != null && extra_applovin_Medium_Ragtangal_adview != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Applovin mediam ragtangal Ad");
                    banner_container.addView(extra_applovin_Medium_Ragtangal_adview);
                    mrec_parentView = banner_container;
                }
                AdsControl.isApplovin_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // applovin
                final MaxAdView applovin_medium_rect = new MaxAdView(app_data.get(0).getApplovin_medium_rectangle_id().get(current_applovin_medium_rectId), MaxAdFormat.MREC, activity);
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
                        Log.d("Parth", "Applovin mediam ragtangal Loadedd ");
                        try {
                            if (mrec_parentView != null) {
                                mrec_parentView.removeAllViews();
                            }
                            if (banner_container != null && applovin_medium_rect != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Applovin mediam ragtangal Ad");
                                banner_container.addView(applovin_medium_rect);
                                mrec_parentView = banner_container;
                            }
                            AdsControl.isApplovin_Mediam_Ragtangal_Loaded = false;
                            AdsControl.getInstance(activity).medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
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
                        Log.d("Parth", "Applovin mediam ragtangal Failed");
                        AdsControl.isApplovin_Mediam_Ragtangal_Loaded = false;
                        AdsControl.getInstance(activity).medium_rect_Ads();
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
    @SuppressLint("MissingPermission")
    public void show_medium_ad_Wortise(final ViewGroup banner_container) {
        if (AdsControl.isWortise_medium_ragtangal_Loaded) {
            extraw_medium_ragtangal = w_medium_ragtangal;
            try {
                if (mrec_parentView != null) {
                    mrec_parentView.removeAllViews();
                }
                if (banner_container != null && extraw_medium_ragtangal != null) {
                    banner_container.removeAllViews();
                    Log.d("Parth", "show Wortise Banner Ad");
                    banner_container.addView(extraw_medium_ragtangal);
                    mrec_parentView = banner_container;
                }
                AdsControl.isWortise_medium_ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            if (app_data != null && app_data.size() > 0) {
                // Wortise
                final BannerAd wortise_medium_ragtangal = new BannerAd(activity);
                wortise_medium_ragtangal.setAdSize(com.wortise.ads.AdSize.HEIGHT_250);
                wortise_medium_ragtangal.setAdUnitId(app_data.get(0).getWortiseMediumRectangleId().get(current_wortise_medium_rectId));
                wortise_medium_ragtangal.loadAd();
                wortise_medium_ragtangal.setListener(new BannerAd.Listener() {
                    @Override
                    public void onBannerLoaded(@NonNull BannerAd bannerAd) {
                        Log.d("Parth", "Wortise Medium Ragtangal Loadedd ");
                        try {
                            if (mrec_parentView != null) {
                                mrec_parentView.removeAllViews();
                            }
                            if (banner_container != null && wortise_medium_ragtangal != null) {
                                banner_container.removeAllViews();
                                Log.d("Parth", "show Wortise Medium Ragtangal Ad");
                                banner_container.addView(wortise_medium_ragtangal);
                                mrec_parentView = banner_container;
                            }
                            AdsControl.isWortise_medium_ragtangal_Loaded = false;
                            AdsControl.getInstance(activity).medium_rect_Ads();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }

                    @Override
                    public void onBannerClicked(@NonNull BannerAd bannerAd) {
                    }

                    @Override
                    public void onBannerFailed(@NonNull BannerAd bannerAd, @NonNull com.wortise.ads.AdError adError) {
                        Log.d("Parth", "Wortise Medium Ragtangal onError: " + adError);
                        AdsControl.isWortise_medium_ragtangal_Loaded = false;
                        AdsControl.getInstance(activity).medium_rect_Ads();
                    }
                });
                current_wortise_medium_rectId++;
                if (current_wortise_medium_rectId == app_data.get(0).getWortiseMediumRectangleId().size()) {
                    current_wortise_medium_rectId = 0;
                }
            }
        }
    }
}