// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) disassembler 

package com.google.ads;


// Referenced classes of package com.google.ads:
//            Ad

public interface SwipeableAdListener
{

    public abstract void onAdActivated(Ad ad);

    public abstract void onAdDeactivated(Ad ad);
}
