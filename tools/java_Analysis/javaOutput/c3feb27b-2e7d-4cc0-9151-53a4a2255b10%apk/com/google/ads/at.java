package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.ads.internal.a;
import com.google.ads.util.f;
import java.util.Date;

public final class at
{
  private static final a a = (a)a.a.b();

  public static void a(Activity paramActivity)
  {
    new Thread(new at.a(paramActivity)).start();
  }

  public static boolean a(Context paramContext, long paramLong)
  {
    if (!a(paramContext, paramLong, PreferenceManager.getDefaultSharedPreferences(paramContext.getApplicationContext())))
      return false;
    new Thread(new at.1(paramContext)).start();
    return true;
  }

  static boolean a(Context paramContext, long paramLong, SharedPreferences paramSharedPreferences)
  {
    return (!paramSharedPreferences.contains("drt")) || (!paramSharedPreferences.contains("drt_ts")) || (paramSharedPreferences.getLong("drt_ts", 0L) < new Date().getTime() - paramLong);
  }
}

/* Location:
 * Qualified Name:     com.google.ads.at
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */