// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) disassembler 

package com.google.ads.mediation.customevent;

import android.view.View;

// Referenced classes of package com.google.ads.mediation.customevent:
//            CustomEventListener

public interface CustomEventBannerListener
    extends CustomEventListener
{

    public abstract void onClick();

    public abstract void onReceivedAd(View view);
}
