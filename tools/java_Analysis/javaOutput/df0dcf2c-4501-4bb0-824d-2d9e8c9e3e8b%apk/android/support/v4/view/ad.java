package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.MotionEvent;

public final class ad
{
  static final ag a = new ae();

  static
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      a = new af();
      return;
    }
  }

  public static int a(MotionEvent paramMotionEvent)
  {
    return 0xFF & paramMotionEvent.getAction();
  }

  public static int a(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.a(paramMotionEvent, paramInt);
  }

  public static int b(MotionEvent paramMotionEvent)
  {
    return (0xFF00 & paramMotionEvent.getAction()) >> 8;
  }

  public static int b(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.b(paramMotionEvent, paramInt);
  }

  public static float c(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.c(paramMotionEvent, paramInt);
  }

  public static int c(MotionEvent paramMotionEvent)
  {
    return a.a(paramMotionEvent);
  }

  public static float d(MotionEvent paramMotionEvent, int paramInt)
  {
    return a.d(paramMotionEvent, paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
