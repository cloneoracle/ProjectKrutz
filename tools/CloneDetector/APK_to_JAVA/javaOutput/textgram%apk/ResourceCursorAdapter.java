// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) disassembler 

package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.*;

// Referenced classes of package android.support.v4.widget:
//            CursorAdapter

public abstract class ResourceCursorAdapter extends CursorAdapter
{

    public ResourceCursorAdapter(Context context, int i, Cursor cursor)
    {
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_3         
    //    3    3:invokespecial   #15  <Method void CursorAdapter(Context, Cursor)>
    //    4    6:aload_0         
    //    5    7:iload_2         
    //    6    8:putfield        #17  <Field int mDropDownLayout>
    //    7   11:aload_0         
    //    8   12:iload_2         
    //    9   13:putfield        #19  <Field int mLayout>
    //   10   16:aload_0         
    //   11   17:aload_1         
    //   12   18:ldc1            #21  <String "layout_inflater">
    //   13   20:invokevirtual   #27  <Method Object Context.getSystemService(String)>
    //   14   23:checkcast       #29  <Class LayoutInflater>
    //   15   26:putfield        #31  <Field LayoutInflater mInflater>
    //   16   29:return          
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, int j)
    {
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_3         
    //    3    3:iload           4
    //    4    5:invokespecial   #35  <Method void CursorAdapter(Context, Cursor, int)>
    //    5    8:aload_0         
    //    6    9:iload_2         
    //    7   10:putfield        #17  <Field int mDropDownLayout>
    //    8   13:aload_0         
    //    9   14:iload_2         
    //   10   15:putfield        #19  <Field int mLayout>
    //   11   18:aload_0         
    //   12   19:aload_1         
    //   13   20:ldc1            #21  <String "layout_inflater">
    //   14   22:invokevirtual   #27  <Method Object Context.getSystemService(String)>
    //   15   25:checkcast       #29  <Class LayoutInflater>
    //   16   28:putfield        #31  <Field LayoutInflater mInflater>
    //   17   31:return          
    }

    public ResourceCursorAdapter(Context context, int i, Cursor cursor, boolean flag)
    {
    //    0    0:aload_0         
    //    1    1:aload_1         
    //    2    2:aload_3         
    //    3    3:iload           4
    //    4    5:invokespecial   #39  <Method void CursorAdapter(Context, Cursor, boolean)>
    //    5    8:aload_0         
    //    6    9:iload_2         
    //    7   10:putfield        #17  <Field int mDropDownLayout>
    //    8   13:aload_0         
    //    9   14:iload_2         
    //   10   15:putfield        #19  <Field int mLayout>
    //   11   18:aload_0         
    //   12   19:aload_1         
    //   13   20:ldc1            #21  <String "layout_inflater">
    //   14   22:invokevirtual   #27  <Method Object Context.getSystemService(String)>
    //   15   25:checkcast       #29  <Class LayoutInflater>
    //   16   28:putfield        #31  <Field LayoutInflater mInflater>
    //   17   31:return          
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
    //    0    0:aload_0         
    //    1    1:getfield        #31  <Field LayoutInflater mInflater>
    //    2    4:aload_0         
    //    3    5:getfield        #17  <Field int mDropDownLayout>
    //    4    8:aload_3         
    //    5    9:iconst_0        
    //    6   10:invokevirtual   #45  <Method View LayoutInflater.inflate(int, ViewGroup, boolean)>
    //    7   13:areturn         
    }

    public View newView(Context context, Cursor cursor, ViewGroup viewgroup)
    {
    //    0    0:aload_0         
    //    1    1:getfield        #31  <Field LayoutInflater mInflater>
    //    2    4:aload_0         
    //    3    5:getfield        #19  <Field int mLayout>
    //    4    8:aload_3         
    //    5    9:iconst_0        
    //    6   10:invokevirtual   #45  <Method View LayoutInflater.inflate(int, ViewGroup, boolean)>
    //    7   13:areturn         
    }

    public void setDropDownViewResource(int i)
    {
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #17  <Field int mDropDownLayout>
    //    3    5:return          
    }

    public void setViewResource(int i)
    {
    //    0    0:aload_0         
    //    1    1:iload_1         
    //    2    2:putfield        #19  <Field int mLayout>
    //    3    5:return          
    }

    private int mDropDownLayout;
    private LayoutInflater mInflater;
    private int mLayout;
}
