package android.support.v7.internal.widget;

import android.widget.PopupWindow;

final class x
  implements Runnable
{
  private x(ListPopupWindow paramListPopupWindow)
  {
  }

  public final void run()
  {
    if ((ListPopupWindow.a(this.a) != null) && (ListPopupWindow.a(this.a).getCount() > ListPopupWindow.a(this.a).getChildCount()) && (ListPopupWindow.a(this.a).getChildCount() <= this.a.a))
    {
      ListPopupWindow.b(this.a).setInputMethodMode(2);
      this.a.e();
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.internal.widget.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
