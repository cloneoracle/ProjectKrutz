package android.support.v4.hardware.display;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.Display;
import java.util.WeakHashMap;

public abstract class DisplayManagerCompat
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap();

  DisplayManagerCompat()
  {
  }

  public static DisplayManagerCompat getInstance(Context paramContext)
  {
    synchronized (sInstances)
    {
      Object localObject2 = (DisplayManagerCompat)sInstances.get(paramContext);
      if (localObject2 == null)
      {
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject2 = new DisplayManagerCompat.JellybeanMr1Impl(paramContext);
          sInstances.put(paramContext, localObject2);
        }
      }
      else
        return localObject2;
      localObject2 = new DisplayManagerCompat.LegacyImpl(paramContext);
    }
  }

  public abstract Display getDisplay(int paramInt);

  public abstract Display[] getDisplays();

  public abstract Display[] getDisplays(String paramString);
}

/* Location:
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */