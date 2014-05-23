package com.google.ads;

import android.content.Context;
import com.google.ads.util.AdUtil;
import com.google.ads.util.b;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ae
  implements Runnable
{
  private final Context a;
  private final String b;

  public ae(String paramString, Context paramContext)
  {
    this.b = paramString;
    this.a = paramContext;
  }

  protected HttpURLConnection a(URL paramURL)
    throws IOException
  {
    return (HttpURLConnection)paramURL.openConnection();
  }

  public void run()
  {
    try
    {
      b.a("Pinging URL: " + this.b);
      localHttpURLConnection = a(new URL(this.b));
      try
      {
        AdUtil.a(localHttpURLConnection, this.a);
        localHttpURLConnection.setInstanceFollowRedirects(true);
        localHttpURLConnection.connect();
        int i = localHttpURLConnection.getResponseCode();
        if ((i < 200) || (i >= 300))
          b.e("Did not receive 2XX (got " + i + ") from pinging URL: " + this.b);
        return;
      }
      finally
      {
        localHttpURLConnection.disconnect();
      }
    }
    catch (Throwable localThrowable)
    {
      HttpURLConnection localHttpURLConnection;
      b.d("Unable to ping the URL: " + this.b, localThrowable);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.ads.ae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
