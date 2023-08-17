package com.ads.data.Api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("admob_splash_interid")
    @Expose
    private String admob_splash_interid;
    @SerializedName("admob_interid")
    @Expose
    private List<String> admobInterid;
    @SerializedName("admob_bannerid")
    @Expose
    private List<String> admobBannerid;
    @SerializedName("admob_medium_rectangleid")
    @Expose
    private List<String> admobMediumRectangleid;
    @SerializedName("admob_nativeid")
    @Expose
    private List<String> admobNativeid;
    @SerializedName("admob_appopenid")
    @Expose
    private String admobAppopenid;
    @SerializedName("adx_splash_inter_id")
    @Expose
    private String adx_splash_inter_id;
    @SerializedName("adx_inter_id")
    @Expose
    private List<String> adxInterId;
    @SerializedName("adx_banner_id")
    @Expose
    private List<String> adxBannerId;
    @SerializedName("adx_medium_rectangleid")
    @Expose
    private List<String> adxMediumRectangleid;
    @SerializedName("adx_native_id")
    @Expose
    private List<String> adxNativeId;
    @SerializedName("adx_appopen_id")
    @Expose
    private String adxAppopenId;
    @SerializedName("fb_splash_inter_id")
    @Expose
    private String fb_splash_inter_id;
    @SerializedName("fb_inter_id")
    @Expose
    private List<String> fbInterId;
    @SerializedName("fb_banner_id")
    @Expose
    private List<String> fbBannerId;
    @SerializedName("fb_medium_rectangle_id")
    @Expose
    private List<String> fbMediumRectangleId;
    @SerializedName("fb_native_id")
    @Expose
    private List<String> fbNativeId;
    @SerializedName("fb_native_banner_id")
    @Expose
    private List<String> fbNativeBannerId;
    @SerializedName("applovin_appopen_id")
    @Expose
    private String applovin_appopen_id;
    @SerializedName("applovin_splash_interid")
    @Expose
    private String applovin_splash_interid;
    @SerializedName("applovin_interid")
    @Expose
    private List<String> applovin_interid;
    @SerializedName("applovin_nativeid")
    @Expose
    private List<String> applovin_nativeid;
    @SerializedName("applovin_small_nativeid")
    @Expose
    private List<String> applovin_small_nativeid;
    @SerializedName("applovin_small_native_bannerid")
    @Expose
    private List<String> applovin_small_native_bannerid;
    @SerializedName("applovin_banner_id")
    @Expose
    private List<String> applovin_banner_id;
    @SerializedName("applovin_medium_rectangle_id")
    @Expose
    private List<String> applovin_medium_rectangle_id;
    @SerializedName("wortise_app_id")
    @Expose
    private String wortiseAppId;
    @SerializedName("wortise_appopen_id")
    @Expose
    private String wortiseAppopenId;
    @SerializedName("wortise_splash_inter_id")
    @Expose
    private String wortise_splash_inter_id;
    @SerializedName("wortise_inter_id")
    @Expose
    private List<String> wortiseInterId;
    @SerializedName("wortise_banner_id")
    @Expose
    private List<String> wortiseBannerId;
    @SerializedName("wortise_medium_rectangle_id")
    @Expose
    private List<String> wortiseMediumRectangleId;
    @SerializedName("wortise_native_id")
    @Expose
    private List<String> wortiseNativeId;
    @SerializedName("new_app_name")
    @Expose
    private String new_app_name;
    @SerializedName("new_app_icon")
    @Expose
    private String new_app_icon;
    @SerializedName("new_app_banner_ad")
    @Expose
    private String new_app_banner_ad;
    @SerializedName("new_app_banner")
    @Expose
    private String new_app_banner;
    @SerializedName("new_app_body")
    @Expose
    private String new_app_body;
    @SerializedName("new_app_link")
    @Expose
    private String new_app_link;
    @SerializedName("inter_count")
    @Expose
    private int interCount;
    @SerializedName("ads_show")
    @Expose
    private boolean ads_show;
    @SerializedName("tap_to_start_mode")
    @Expose
    private String tap_to_start_mode;
    @SerializedName("dev_option")
    @Expose
    private boolean dev_option;
    @SerializedName("vpn_option")
    @Expose
    private boolean vpn_option;
    @SerializedName("ad_splash")
    @Expose
    private String adSplash;
    @SerializedName("ad_secound_splash")
    @Expose
    private String ad_secound_splash;
    @SerializedName("ad_appopen")
    @Expose
    private String adAppopen;
    @SerializedName("ad_inter")
    @Expose
    private String adInter;
    @SerializedName("ad_small_native_banner")
    @Expose
    private String adSmallNativeBanner;
    @SerializedName("ad_small_native")
    @Expose
    private String adSmallNative;
    @SerializedName("ad_native")
    @Expose
    private String adNative;
    @SerializedName("ad_native_type")
    @Expose
    private String ad_native_type;
    @SerializedName("ad_medium_rect")
    @Expose
    private String ad_medium_rect;
    @SerializedName("ad_banner")
    @Expose
    private String adBanner;
    @SerializedName("privacy_url")
    @Expose
    private String privacyUrl;
    @SerializedName("redirect_app")
    @Expose
    private String redirectApp;

    public String getAdmob_splash_interid() {
        return admob_splash_interid;
    }

    public void setAdmob_splash_interid(String admob_splash_interid) {
        this.admob_splash_interid = admob_splash_interid;
    }

    public List<String> getAdmobInterid() {
        return admobInterid;
    }

    public void setAdmobInterid(List<String> admobInterid) {
        this.admobInterid = admobInterid;
    }

    public List<String> getAdmobBannerid() {
        return admobBannerid;
    }

    public void setAdmobBannerid(List<String> admobBannerid) {
        this.admobBannerid = admobBannerid;
    }

    public List<String> getAdmobMediumRectangleid() {
        return admobMediumRectangleid;
    }

    public void setAdmobMediumRectangleid(List<String> admobMediumRectangleid) {
        this.admobMediumRectangleid = admobMediumRectangleid;
    }

    public List<String> getAdmobNativeid() {
        return admobNativeid;
    }

    public void setAdmobNativeid(List<String> admobNativeid) {
        this.admobNativeid = admobNativeid;
    }

    public String getAdmobAppopenid() {
        return admobAppopenid;
    }

    public void setAdmobAppopenid(String admobAppopenid) {
        this.admobAppopenid = admobAppopenid;
    }

    public String getAdx_splash_inter_id() {
        return adx_splash_inter_id;
    }

    public void setAdx_splash_inter_id(String adx_splash_inter_id) {
        this.adx_splash_inter_id = adx_splash_inter_id;
    }

    public List<String> getAdxInterId() {
        return adxInterId;
    }

    public void setAdxInterId(List<String> adxInterId) {
        this.adxInterId = adxInterId;
    }

    public List<String> getAdxBannerId() {
        return adxBannerId;
    }

    public void setAdxBannerId(List<String> adxBannerId) {
        this.adxBannerId = adxBannerId;
    }

    public List<String> getAdxMediumRectangleid() {
        return adxMediumRectangleid;
    }

    public void setAdxMediumRectangleid(List<String> adxMediumRectangleid) {
        this.adxMediumRectangleid = adxMediumRectangleid;
    }

    public List<String> getAdxNativeId() {
        return adxNativeId;
    }

    public void setAdxNativeId(List<String> adxNativeId) {
        this.adxNativeId = adxNativeId;
    }

    public String getAdxAppopenId() {
        return adxAppopenId;
    }

    public void setAdxAppopenId(String adxAppopenId) {
        this.adxAppopenId = adxAppopenId;
    }

    public String getFb_splash_inter_id() {
        return fb_splash_inter_id;
    }

    public void setFb_splash_inter_id(String fb_splash_inter_id) {
        this.fb_splash_inter_id = fb_splash_inter_id;
    }

    public List<String> getFbInterId() {
        return fbInterId;
    }

    public void setFbInterId(List<String> fbInterId) {
        this.fbInterId = fbInterId;
    }

    public List<String> getFbBannerId() {
        return fbBannerId;
    }

    public void setFbBannerId(List<String> fbBannerId) {
        this.fbBannerId = fbBannerId;
    }

    public List<String> getFbMediumRectangleId() {
        return fbMediumRectangleId;
    }

    public void setFbMediumRectangleId(List<String> fbMediumRectangleId) {
        this.fbMediumRectangleId = fbMediumRectangleId;
    }

    public List<String> getFbNativeId() {
        return fbNativeId;
    }

    public void setFbNativeId(List<String> fbNativeId) {
        this.fbNativeId = fbNativeId;
    }

    public List<String> getFbNativeBannerId() {
        return fbNativeBannerId;
    }

    public void setFbNativeBannerId(List<String> fbNativeBannerId) {
        this.fbNativeBannerId = fbNativeBannerId;
    }

    public String getApplovin_appopen_id() {
        return applovin_appopen_id;
    }

    public void setApplovin_appopen_id(String applovin_appopen_id) {
        this.applovin_appopen_id = applovin_appopen_id;
    }

    public String getApplovin_splash_interid() {
        return applovin_splash_interid;
    }

    public void setApplovin_splash_interid(String applovin_splash_interid) {
        this.applovin_splash_interid = applovin_splash_interid;
    }

    public List<String> getApplovin_interid() {
        return applovin_interid;
    }

    public void setApplovin_interid(List<String> applovin_interid) {
        this.applovin_interid = applovin_interid;
    }

    public List<String> getApplovin_nativeid() {
        return applovin_nativeid;
    }

    public void setApplovin_nativeid(List<String> applovin_nativeid) {
        this.applovin_nativeid = applovin_nativeid;
    }

    public List<String> getApplovin_small_nativeid() {
        return applovin_small_nativeid;
    }

    public void setApplovin_small_nativeid(List<String> applovin_small_nativeid) {
        this.applovin_small_nativeid = applovin_small_nativeid;
    }

    public List<String> getApplovin_small_native_bannerid() {
        return applovin_small_native_bannerid;
    }

    public void setApplovin_small_native_bannerid(List<String> applovin_small_native_bannerid) {
        this.applovin_small_native_bannerid = applovin_small_native_bannerid;
    }

    public List<String> getApplovin_banner_id() {
        return applovin_banner_id;
    }

    public void setApplovin_banner_id(List<String> applovin_banner_id) {
        this.applovin_banner_id = applovin_banner_id;
    }

    public List<String> getApplovin_medium_rectangle_id() {
        return applovin_medium_rectangle_id;
    }

    public void setApplovin_medium_rectangle_id(List<String> applovin_medium_rectangle_id) {
        this.applovin_medium_rectangle_id = applovin_medium_rectangle_id;
    }

    public String getWortiseAppId() {
        return wortiseAppId;
    }

    public void setWortiseAppId(String wortiseAppId) {
        this.wortiseAppId = wortiseAppId;
    }

    public String getWortiseAppopenId() {
        return wortiseAppopenId;
    }

    public void setWortiseAppopenId(String wortiseAppopenId) {
        this.wortiseAppopenId = wortiseAppopenId;
    }

    public String getWortise_splash_inter_id() {
        return wortise_splash_inter_id;
    }

    public void setWortise_splash_inter_id(String wortise_splash_inter_id) {
        this.wortise_splash_inter_id = wortise_splash_inter_id;
    }

    public List<String> getWortiseInterId() {
        return wortiseInterId;
    }

    public void setWortiseInterId(List<String> wortiseInterId) {
        this.wortiseInterId = wortiseInterId;
    }

    public List<String> getWortiseBannerId() {
        return wortiseBannerId;
    }

    public void setWortiseBannerId(List<String> wortiseBannerId) {
        this.wortiseBannerId = wortiseBannerId;
    }

    public List<String> getWortiseMediumRectangleId() {
        return wortiseMediumRectangleId;
    }

    public void setWortiseMediumRectangleId(List<String> wortiseMediumRectangleId) {
        this.wortiseMediumRectangleId = wortiseMediumRectangleId;
    }

    public List<String> getWortiseNativeId() {
        return wortiseNativeId;
    }

    public void setWortiseNativeId(List<String> wortiseNativeId) {
        this.wortiseNativeId = wortiseNativeId;
    }

    public String getNew_app_name() {
        return new_app_name;
    }

    public void setNew_app_name(String new_app_name) {
        this.new_app_name = new_app_name;
    }

    public String getNew_app_icon() {
        return new_app_icon;
    }

    public void setNew_app_icon(String new_app_icon) {
        this.new_app_icon = new_app_icon;
    }

    public String getNew_app_banner_ad() {
        return new_app_banner_ad;
    }

    public void setNew_app_banner_ad(String new_app_banner_ad) {
        this.new_app_banner_ad = new_app_banner_ad;
    }

    public String getNew_app_banner() {
        return new_app_banner;
    }

    public void setNew_app_banner(String new_app_banner) {
        this.new_app_banner = new_app_banner;
    }

    public String getNew_app_body() {
        return new_app_body;
    }

    public void setNew_app_body(String new_app_body) {
        this.new_app_body = new_app_body;
    }

    public String getNew_app_link() {
        return new_app_link;
    }

    public void setNew_app_link(String new_app_link) {
        this.new_app_link = new_app_link;
    }

    public int getInterCount() {
        return interCount;
    }

    public void setInterCount(int interCount) {
        this.interCount = interCount;
    }

    public boolean isAds_show() {
        return ads_show;
    }

    public void setAds_show(boolean ads_show) {
        this.ads_show = ads_show;
    }

    public String getTap_to_start_mode() {
        return tap_to_start_mode;
    }

    public void setTap_to_start_mode(String tap_to_start_mode) {
        this.tap_to_start_mode = tap_to_start_mode;
    }

    public boolean isDev_option() {
        return dev_option;
    }

    public void setDev_option(boolean dev_option) {
        this.dev_option = dev_option;
    }

    public boolean isVpn_option() {
        return vpn_option;
    }

    public void setVpn_option(boolean vpn_option) {
        this.vpn_option = vpn_option;
    }

    public String getAdSplash() {
        return adSplash;
    }

    public void setAdSplash(String adSplash) {
        this.adSplash = adSplash;
    }

    public String getAd_secound_splash() {
        return ad_secound_splash;
    }

    public void setAd_secound_splash(String ad_secound_splash) {
        this.ad_secound_splash = ad_secound_splash;
    }

    public String getAdAppopen() {
        return adAppopen;
    }

    public void setAdAppopen(String adAppopen) {
        this.adAppopen = adAppopen;
    }

    public String getAdInter() {
        return adInter;
    }

    public void setAdInter(String adInter) {
        this.adInter = adInter;
    }

    public String getAdSmallNativeBanner() {
        return adSmallNativeBanner;
    }

    public void setAdSmallNativeBanner(String adSmallNativeBanner) {
        this.adSmallNativeBanner = adSmallNativeBanner;
    }

    public String getAdSmallNative() {
        return adSmallNative;
    }

    public void setAdSmallNative(String adSmallNative) {
        this.adSmallNative = adSmallNative;
    }

    public String getAdNative() {
        return adNative;
    }

    public void setAdNative(String adNative) {
        this.adNative = adNative;
    }

    public String getAd_native_type() {
        return ad_native_type;
    }

    public void setAd_native_type(String ad_native_type) {
        this.ad_native_type = ad_native_type;
    }

    public String getAd_medium_rect() {
        return ad_medium_rect;
    }

    public void setAd_medium_rect(String ad_medium_rect) {
        this.ad_medium_rect = ad_medium_rect;
    }

    public String getAdBanner() {
        return adBanner;
    }

    public void setAdBanner(String adBanner) {
        this.adBanner = adBanner;
    }

    public String getPrivacyUrl() {
        return privacyUrl;
    }

    public void setPrivacyUrl(String privacyUrl) {
        this.privacyUrl = privacyUrl;
    }

    public String getRedirectApp() {
        return redirectApp;
    }

    public void setRedirectApp(String redirectApp) {
        this.redirectApp = redirectApp;
    }
}