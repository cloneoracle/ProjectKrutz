package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.d;
import com.google.ads.util.b;
import java.util.HashMap;

public class p
  implements o
{
  public p()
  {
  }

  public void a(d paramd, HashMap<String, String> paramHashMap, WebView paramWebView)
  {
    String str = (String)paramHashMap.get("name");
    if (str == null)
    {
      b.b("Error: App event with no name parameter.");
      return;
    }
    paramd.a(str, (String)paramHashMap.get("info"));
  }
}

/* Location:
 * Qualified Name:     com.google.ads.p
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
