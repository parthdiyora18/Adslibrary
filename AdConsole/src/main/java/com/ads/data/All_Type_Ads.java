package com.ads.data;

import static com.ads.data.AdsControl.Applovin_native_ad;
import static com.ads.data.AdsControl.Applovin_small_native_Ad;
import static com.ads.data.AdsControl.Applovin_small_native_banner_Ad;
import static com.ads.data.AdsControl.InmobiBannerAd;
import static com.ads.data.AdsControl.admobMediam_Ragtangal;
import static com.ads.data.AdsControl.adxBannerAd;
import static com.ads.data.AdsControl.adxMediam_Ragtangal;
import static com.ads.data.AdsControl.app_data;
import static com.ads.data.AdsControl.applovin_Medium_Ragtangal_adview;
import static com.ads.data.AdsControl.applovin_banner_ad;
import static com.ads.data.AdsControl.applovin_maxnativeadview;
import static com.ads.data.AdsControl.applovin_small_native_Ad;
import static com.ads.data.AdsControl.applovin_small_native_banner_Ad;
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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.applovin.mediation.ads.MaxAdView;
import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.inmobi.ads.InMobiBanner;
import com.wortise.ads.banner.BannerAd;

public class All_Type_Ads {
    Context activity;
    AdView extrgoogleBannerAd;
    AdManagerAdView extradxBannerAd;
    com.facebook.ads.AdView extrfbadView;
    BannerAd extrwBannerAd;
    MaxAdView extraapplovin_banner_ad;
    InMobiBanner extrinmobi_banner_ad;
    AdView extraadmobMediam_Ragtangal;
    AdManagerAdView extraadxMediam_Ragtangal;
    com.facebook.ads.AdView extrafb_Ragtangal_adView;
    MaxAdView extra_applovin_Medium_Ragtangal_adview;
    BannerAd extraw_medium_ragtangal;
    ViewGroup parentView;
    ViewGroup mrec_parentView;

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
                    banner_container.removeAllViews();
                    banner_container.addView(extrgoogleBannerAd);
                    Log.d("Parth", "show Admob Banner Ad");
                    parentView = banner_container;
                }
                AdsControl.isGoogleBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extradxBannerAd);
                    Log.d("Parth", "show Adx Banner Ad");
                    parentView = banner_container;
                }
                AdsControl.isAdxBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extrfbadView);
                    Log.d("Parth", "show Fb Banner Ad");
                    parentView = banner_container;
                }
                AdsControl.isFBBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extrwBannerAd);
                    Log.d("Parth", "show Wortise Banner Ad");
                    parentView = banner_container;
                }
                AdsControl.isWortiseBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extraapplovin_banner_ad);
                    Log.d("Parth", "show Applovin Banner Ad");
                    parentView = banner_container;
                }
                AdsControl.isApplovinBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Inmobi Mode
    @SuppressLint("MissingPermission")
    public void show_banner_ad_Inmobi(final ViewGroup banner_container) {
        if (AdsControl.isInmobiBannerLoaded) {
            extrinmobi_banner_ad = InmobiBannerAd;
            try {
                if (parentView != null) {
                    parentView.removeAllViews();
                }
                if (banner_container != null && extrinmobi_banner_ad != null) {
                    banner_container.removeAllViews();
                    banner_container.addView(extrinmobi_banner_ad);
                    Log.d("Parth", "show Inmobi Banner Ad");
                    parentView = banner_container;
                }
                AdsControl.isInmobiBannerLoaded = false;
                AdsControl.getInstance(activity).banner_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    //===================================================== Small Native Banner Ad ====================================================

    // Admob Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Admob(final ViewGroup native_banner_ad) {
        if (AdsControl.isadmob_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Admob_small_native_banner_Ad, native_banner_ad);
            Log.d("Parth", "Admob Native Banner ad show");
            AdsControl.isadmob_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        }
    }

    // Adx Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_Adx(final ViewGroup native_banner_ad) {
        if (AdsControl.isadx_small_native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.Adx_small_native_banner_Ad, native_banner_ad);
            Log.d("Parth", "Adx Native Banner ad show");
            AdsControl.isadx_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        }
    }

    // FB Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_FB(final ViewGroup native_banner_ad) {
        if (AdsControl.isFB_small_native_banner_Loaded) {
            new NativeAds(activity).FB_Smalle_Native_Banner(AdsControl.fb_small_native_banner_Ad, native_banner_ad);
            Log.d("Parth", "FB Native Banner ad show");
            AdsControl.isFB_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        }
    }

    // Applovin Mode
    @SuppressLint("MissingPermission")
    public void show_small_native_banner_ad_Applovin(final ViewGroup native_banner_ad) {
        if (AdsControl.isApplovin_small_native_banner_Loaded) {
            if (Applovin_small_native_banner_Ad != null) {
                native_banner_ad.removeAllViews();
            }
            native_banner_ad.removeAllViews();
            native_banner_ad.addView(applovin_small_native_banner_Ad);
            Log.d("Parth", "Applovin Native Banner ad show");
            AdsControl.isApplovin_small_native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        }
    }

    // Wortise Mode
    @SuppressLint("MissingPermission")
    public void show_samll_native_bannerad_wortise(final ViewGroup native_banner_ad) {
        if (AdsControl.isWortise_small_Native_banner_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Banner_Ad(AdsControl.wortise_small_native_banner_Ad, native_banner_ad);
            Log.d("Parth", "Wortise Native Banner ad show");
            AdsControl.isWortise_small_Native_banner_Loaded = false;
            AdsControl.getInstance(activity).small_native_banner_Ads();
        }
    }

    // Local Mode
    @SuppressLint("SetTextI18n")
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
            Log.d("Parth", "Local Native Banner ad show");
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
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Adx(final ViewGroup small_native) {
        if (AdsControl.isadx_small_native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.Adx_small_native_Ad, small_native);
            Log.d("Parth", "Adx Small Native ad show");
            AdsControl.isadx_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_FB(final ViewGroup small_native) {
        if (AdsControl.isFb_small_native_Loaded) {
            new NativeAds(activity).FB_Smalle_Native(AdsControl.fb_small_native_Ad, small_native);
            Log.d("Parth", "FB Small Native ad show");
            AdsControl.isFb_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_ad_Applovin(final ViewGroup small_native) {
        if (AdsControl.isapplovin_small_native_Loaded) {
            if (Applovin_small_native_Ad != null) {
                small_native.removeAllViews();
            }
            small_native.removeAllViews();
            small_native.addView(applovin_small_native_Ad);
            Log.d("Parth", "Applovin Small Native ad show");
            AdsControl.isapplovin_small_native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_small_native_Wortise(final ViewGroup small_native) {
        if (AdsControl.isWortise_small_Native_Loaded) {
            new NativeAds(activity).Admob_Small_Native_Ad(AdsControl.wortise_small_native_Ad, small_native);
            Log.d("Parth", "Wortise Small Native ad show");
            AdsControl.isWortise_small_Native_Loaded = false;
            AdsControl.getInstance(activity).small_native_Ads();
        }
    }

    // Local Mode
    @SuppressLint("SetTextI18n")
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
            Log.d("Parth", "Local Small Native ad show");
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
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_Adx(final ViewGroup native_ad) {
        if (AdsControl.isadx_native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(AdsControl.Adx_native_Ad, native_ad);
            Log.d("Parth", "Adx Native ad show");
            AdsControl.isadx_native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_FB(final ViewGroup native_ad) {
        if (AdsControl.isFB_Native_Loaded) {
            new NativeAds(activity).FB_Native(AdsControl.fb_native_Ad, native_ad);
            Log.d("Parth", "FB Native ad show");
            AdsControl.isFB_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_Applovin(final ViewGroup native_ad) {
        if (AdsControl.isApplovin_Native_Loaded) {
            if (Applovin_native_ad != null) {
                native_ad.removeAllViews();
            }
            native_ad.removeAllViews();
            native_ad.addView(applovin_maxnativeadview);
            Log.d("Parth", "Applovin Native ad show");
            AdsControl.isApplovin_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        }
    }

    @SuppressLint("MissingPermission")
    public void show_native_ad_Wortise(final ViewGroup native_ad) {
        if (AdsControl.isWortise_Native_Loaded) {
            new NativeAds(activity).Admob_NativeAd(AdsControl.wortise_native_Ad, native_ad);
            Log.d("Parth", "Wortise Native ad show");
            AdsControl.isWortise_Native_Loaded = false;
            AdsControl.getInstance(activity).native_Ads();
        }
    }

    // Local Mode
    @SuppressLint("SetTextI18n")
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
            Log.d("Parth", "Local Native ad show");
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
                    banner_container.removeAllViews();
                    banner_container.addView(extraadmobMediam_Ragtangal);
                    Log.d("Parth", "show Admob mediam ragtangal Ad");
                    mrec_parentView = banner_container;
                }
                AdsControl.isAdmob_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extraadxMediam_Ragtangal);
                    Log.d("Parth", "show Adx mediam ragtangal Ad");
                    mrec_parentView = banner_container;
                }
                AdsControl.isAdx_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extrafb_Ragtangal_adView);
                    Log.d("Parth", "show Fb mediam ragtangal Ad");
                    mrec_parentView = banner_container;
                }
                AdsControl.isFB_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extra_applovin_Medium_Ragtangal_adview);
                    Log.d("Parth", "show Applovin mediam ragtangal Ad");
                    mrec_parentView = banner_container;
                }
                AdsControl.isApplovin_Mediam_Ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
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
                    banner_container.addView(extraw_medium_ragtangal);
                    Log.d("Parth", "show Wortise Banner Ad");
                    mrec_parentView = banner_container;
                }
                AdsControl.isWortise_medium_ragtangal_Loaded = false;
                AdsControl.getInstance(activity).medium_rect_Ads();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}