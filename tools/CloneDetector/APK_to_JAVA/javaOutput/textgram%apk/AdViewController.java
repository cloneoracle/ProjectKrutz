// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) disassembler 

package com.applovin.adview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.applovin.sdk.*;

public interface AdViewController
{

    public abstract void destroy();

    public abstract AppLovinAdSize getSize();

    public abstract void initializeAdView(ViewGroup viewgroup, Context context, AppLovinAdSize applovinadsize, AppLovinSdk applovinsdk, AttributeSet attributeset);

    public abstract boolean isAutoDestroy();

    public abstract void loadNextAd();

    public abstract void onDetachedFromWindow();

    public abstract void onVisibilityChanged(int i);

    public abstract void pause();

    public abstract void renderAd(AppLovinAd applovinad);

    public abstract void resume();

    public abstract void setAdClickListener(AppLovinAdClickListener applovinadclicklistener);

    public abstract void setAdDisplayListener(AppLovinAdDisplayListener applovinaddisplaylistener);

    public abstract void setAdLoadListener(AppLovinAdLoadListener applovinadloadlistener);

    public abstract void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener applovinadvideoplaybacklistener);

    public abstract void setAutoDestroy(boolean flag);
}
