package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class ay extends ax
{
  ay()
  {
  }

  public final void a(View paramView, a parama)
  {
    paramView.setAccessibilityDelegate((View.AccessibilityDelegate)parama.a);
  }

  public final boolean a(View paramView, int paramInt)
  {
    return paramView.canScrollHorizontally(paramInt);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.ay
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
