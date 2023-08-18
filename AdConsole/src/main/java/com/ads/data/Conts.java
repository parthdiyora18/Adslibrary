package com.ads.data;

import static com.ads.data.AdsControl.app_data;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ads.data.Api.APIClient;
import com.ads.data.Api.APIInterface;
import com.ads.data.Api.Recover;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.android.play.core.tasks.OnFailureListener;
import com.google.android.play.core.tasks.Task;

import org.jetbrains.annotations.NotNull;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

import retrofit2.Call;

public class Conts {

    private final Context ctx;

    public Conts(Context ctx) {
        this.ctx = ctx;
    }

    // TODO: 8/17/2023  Cheack NetWork Dailog
    public void networkinfo() {
        Dialog dialog = new Dialog(ctx, R.style.FullWidth_Dialog);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.network_check);
        TextView network = dialog.findViewById(R.id.network);
        network.setOnClickListener(v -> {
            dialog.dismiss();
            finishActivity((Activity) ctx);
        });
        dialog.show();
    }

    // TODO: 7/17/2023 Check VPN
    @SuppressLint("ObsoleteSdkInt")
    public static void VPN(Activity mContext) {
        String iface = "";
        try {
            for (NetworkInterface networkInst : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInst.isUp()) iface = networkInst.getName();
                if (iface.contains("tun") || iface.contains("ppp") || iface.contains("pptp")) {
                    Conts conts = new Conts(mContext);
                    conts.showVpnDialog();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    public void showVpnDialog() {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_app_vpn);
        dialog.setCancelable(false);
        dialog.findViewById(R.id.iv_vpn_close).setOnClickListener(view -> finishActivity((Activity) ctx));
        dialog.findViewById(R.id.tv_vpn_submit).setOnClickListener(view -> finishActivity((Activity) ctx));
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    public void finishActivity(Activity activity) {
        activity.finish();
    }

    // TODO: 7/17/2023  AppReview
    public static void showInappReview(final Activity activity) {
        ReviewManager create = ReviewManagerFactory.create(activity);
        Task<ReviewInfo> requestReviewFlow = create.requestReviewFlow();
        requestReviewFlow.addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                ReviewInfo reviewInfo = task.getResult();
                Task<Void> flow = create.launchReviewFlow(activity, reviewInfo);
                flow.addOnCompleteListener(task1 -> {
                });
            } else {
                onOpenReview(activity, activity.getPackageName());
            }
        });
        requestReviewFlow.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(Exception exc) {
                Activity activity = null;
                onOpenReview(activity, activity.getPackageName());
            }
        });
    }

    @SuppressLint("WrongConstant")
    public static void onOpenReview(Context context, String str) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + str));
        boolean z = false;
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                if (next.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                    ActivityInfo activityInfo = next.activityInfo;
                    ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                    intent.setFlags(270532608);
                    intent.setComponent(componentName);
                    context.startActivity(intent);
                    z = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!z) {
            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent2);
        }
    }

    // TODO: 7/17/2023 No_Game_Dailog
    public void Show_No_Live_Game() {
        Dialog dialog = new Dialog(ctx);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.no_game);
        dialog.setCancelable(false);
        dialog.findViewById(R.id.iv_close).setOnClickListener(view -> dialog.dismiss());
        dialog.findViewById(R.id.tv_submit).setOnClickListener(view -> dialog.dismiss());
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.show();
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }

    @SuppressLint("ObsoleteSdkInt")
    public static void IsRTL(Activity mContext) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                mContext.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    public static void IsScreen_landscape_mode(Activity mContext) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                mContext.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                mContext.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"ObsoleteSdkInt", "SourceLockedOrientationActivity"})
    public static void IsScreen_portrait_mode(Activity mContext) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                mContext.getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                mContext.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // TODO: 7/17/2023 Don't Click Screen Short
    public static void IsScreenshort(Activity mContext) {
        Window window = mContext.getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
    }

    // TODO: 7/24/2023  Debuug Mode
    @SuppressLint("UseCompatLoadingForDrawables")
    public void Debugging() {
        if (Settings.Secure.getInt(ctx.getContentResolver(), Settings.Global.ADB_ENABLED, 0) == 1) {
            // debugging enabled
            Dialog dialog = new Dialog(ctx);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.dialog_app_vpn);
            dialog.setCancelable(false);
            TextView tital = dialog.findViewById(R.id.tital);
            TextView sub_tital = dialog.findViewById(R.id.sub_tital);
            TextView detail = dialog.findViewById(R.id.detail);
            TextView tv_vpn_submit = dialog.findViewById(R.id.tv_vpn_submit);
            tital.setText("Devloper Option Mode");
            sub_tital.setText("Error!");
            detail.setText("Please Disable USB Debugging from your phone to use the app!");
            tv_vpn_submit.setText("Go To Disable");
            dialog.findViewById(R.id.iv_vpn_close).setOnClickListener(view -> finishActivity((Activity) ctx));
            tv_vpn_submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);
                    ctx.startActivity(intent);
                }
            });
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
            dialog.show();
            Window window = dialog.getWindow();
            window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        }
    }

    // TODO: 8/17/2023  StatusBar
    public static void StatusBar(Activity act) {
        Window window = act.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        act.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        window.setStatusBarColor(act.getResources().getColor(R.color.white));
    }

    // TODO: 8/17/2023  Exit Dailog
    Dialog exit_dialog;

    public void Exit_Daillog(Activity activity) {
        Dialog dialog = new Dialog(activity);
        exit_dialog = dialog;
        dialog.requestWindowFeature(1);
        dialog.setCancelable(false);
        this.exit_dialog.setContentView(R.layout.exit_dg);
        AdsControl.getInstance(activity).show_native_ad(exit_dialog.findViewById(R.id.exit_native));
        ((ImageView) this.exit_dialog.findViewById(R.id.continuee)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit_dialog.dismiss();
            }
        });
        ((ImageView) this.exit_dialog.findViewById(R.id.exit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exit_dialog.dismiss();
                activity.finishAffinity();
            }
        });
        this.exit_dialog.setCanceledOnTouchOutside(false);
        this.exit_dialog.setCancelable(false);
        this.exit_dialog.getWindow().setSoftInputMode(3);
        this.exit_dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        this.exit_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.exit_dialog.show();
    }

    // TODO: 8/15/2023  Net Lost Service Call
    Activity activity1;
    String paksg;
    String Service;

    public void App_Data(Activity activity, String packagename, String service) {
        activity1 = activity;
        paksg = packagename;
        Service = service;
    }

    public void App_Data() {
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Recover> call1 = apiInterface.getadsdetail(paksg, Service);
        call1.enqueue(new retrofit2.Callback<Recover>() {
            @Override
            public void onResponse(@NotNull Call<Recover> call, @NotNull retrofit2.Response<Recover> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getData() != null) {
//                        app_data.clear();
                        Log.d("Diyora", "Parth_Diyora " + response.body().getData());
                        app_data.addAll(response.body().getData());
                    } else {
                        Toast.makeText(activity1, "Server not Response", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Recover> call, Throwable t) {
                call.cancel();
            }
        });
    }

   /* @SuppressLint("ObsoleteSdkInt")
    public static void ifSupported(Activity mContext) {
        if (app_data != null && app_data.size() > 0) {
            if (app_data.get(0).getAdQurekaInter().equals("on")) {
                CustomTabsIntent.Builder customIntent = new CustomTabsIntent.Builder();
                customIntent.setToolbarColor(ContextCompat.getColor(mContext, R.color.colorPrimary));
                openCustomTab(mContext, customIntent.build(), Uri.parse(app_data.get(0).getQurekaUrl()));
            }
        }
    }

    public static void openCustomTab(Activity activity, CustomTabsIntent customTabsIntent, Uri uri) {
        String packageName = "com.android.chrome";
        if (packageName != null) {
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(activity, uri);
        } else {
            activity.startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
    }*/
}