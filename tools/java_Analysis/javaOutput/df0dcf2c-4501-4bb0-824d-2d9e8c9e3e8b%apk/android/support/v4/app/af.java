package android.support.v4.app;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

final class af
  implements ac
{
  af()
  {
  }

  public final Notification a(aa paramaa)
  {
    Context localContext = paramaa.a;
    Notification localNotification = paramaa.r;
    CharSequence localCharSequence1 = paramaa.b;
    CharSequence localCharSequence2 = paramaa.c;
    CharSequence localCharSequence3 = paramaa.h;
    RemoteViews localRemoteViews = paramaa.f;
    int i = paramaa.i;
    PendingIntent localPendingIntent1 = paramaa.d;
    PendingIntent localPendingIntent2 = paramaa.e;
    Bitmap localBitmap = paramaa.g;
    int j = paramaa.n;
    int k = paramaa.o;
    boolean bool1 = paramaa.p;
    Notification.Builder localBuilder1 = new Notification.Builder(localContext).setWhen(localNotification.when).setSmallIcon(localNotification.icon, localNotification.iconLevel).setContent(localNotification.contentView).setTicker(localNotification.tickerText, localRemoteViews).setSound(localNotification.sound, localNotification.audioStreamType).setVibrate(localNotification.vibrate).setLights(localNotification.ledARGB, localNotification.ledOnMS, localNotification.ledOffMS);
    boolean bool2;
    boolean bool3;
    label187: boolean bool4;
    label209: Notification.Builder localBuilder4;
    if ((0x2 & localNotification.flags) != 0)
    {
      bool2 = true;
      Notification.Builder localBuilder2 = localBuilder1.setOngoing(bool2);
      if ((0x8 & localNotification.flags) == 0)
        break label304;
      bool3 = true;
      Notification.Builder localBuilder3 = localBuilder2.setOnlyAlertOnce(bool3);
      if ((0x10 & localNotification.flags) == 0)
        break label310;
      bool4 = true;
      localBuilder4 = localBuilder3.setAutoCancel(bool4).setDefaults(localNotification.defaults).setContentTitle(localCharSequence1).setContentText(localCharSequence2).setContentInfo(localCharSequence3).setContentIntent(localPendingIntent1).setDeleteIntent(localNotification.deleteIntent);
      if ((0x80 & localNotification.flags) == 0)
        break label316;
    }
    label304: label310: label316: for (boolean bool5 = true; ; bool5 = false)
    {
      return localBuilder4.setFullScreenIntent(localPendingIntent2, bool5).setLargeIcon(localBitmap).setNumber(i).setProgress(j, k, bool1).getNotification();
      bool2 = false;
      break;
      bool3 = false;
      break label187;
      bool4 = false;
      break label209;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.af
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
