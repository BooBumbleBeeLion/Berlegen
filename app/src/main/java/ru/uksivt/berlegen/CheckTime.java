package ru.uksivt.berlegen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import androidx.annotation.NonNull;

import java.lang.Thread.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CheckTime {
    private final static String LOG = CheckTime.class.getSimpleName();
    public final static String PREF_KEY_IN_APP_PERIOD = "inAppPeriod";

    private static long Days, Hours, Minutes, Seconds;

    private Context ctx;
    private SharedPreferences pref;
    private long timeOnResume;

    private UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();

    public CheckTime(Context ctx)
    {
        this.ctx = ctx;
        pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        this.init();
    }

    private UncaughtExceptionHandler myUncaughtExceptionHandler = new UncaughtExceptionHandler()
    {
        public Thread.UncaughtExceptionHandler oldHandler = defaultUncaughtExceptionHandler;

        @Override
        public void uncaughtException(@NonNull Thread thread, Throwable ex)
        {
            String errMsg = (ex.getLocalizedMessage() != null) ? ex.getLocalizedMessage() : "NULL message";
            Log.e(LOG, "uncaughtException: " + errMsg);
            onPause();
            if (oldHandler != null)
            {
                oldHandler.uncaughtException(thread, ex);
            }
        }
    };

    public static long getInAppPeriod(Context ctx)
    {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(ctx);
        long out = pref.getLong(PREF_KEY_IN_APP_PERIOD, 0L);
        out = out / 1000L; // Секунды
//        if(out > 60L) { // Если число содержит минуты
//            if(out > 3600L){ // Если содержит часы
//                if(out > 86400L){ // Если содержит дни
//
//                }
//            }
//        }

        return out;
    }

    public void onResume()
    {
        timeOnResume = System.currentTimeMillis();
        this.setUncaughtExceptionHandler(myUncaughtExceptionHandler);
    }

    public void onPause()
    {
        long timeOnPause = System.currentTimeMillis();
        long inAppPeriod = timeOnPause - this.timeOnResume;

        long alreadyStoredInAppPeriod = this.pref.getLong(PREF_KEY_IN_APP_PERIOD, 0L);

        inAppPeriod += alreadyStoredInAppPeriod;
        this.pref.edit().putLong(PREF_KEY_IN_APP_PERIOD, inAppPeriod).commit();

        this.setUncaughtExceptionHandler(defaultUncaughtExceptionHandler);
    }

    private void setUncaughtExceptionHandler(UncaughtExceptionHandler handler)
    {
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    private void init()
    {
        this.setUncaughtExceptionHandler(myUncaughtExceptionHandler);
    }
}
