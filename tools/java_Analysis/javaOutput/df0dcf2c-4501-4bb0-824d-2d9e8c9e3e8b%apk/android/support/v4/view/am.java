package android.support.v4.view;

import android.database.DataSetObserver;

final class am extends DataSetObserver
  implements bq, br
{
  private int b;

  private am(PagerTitleStripHacked paramPagerTitleStripHacked)
  {
  }

  public final void a(int paramInt)
  {
    if (this.b == 0)
      this.a.a(this.a.a.b(), this.a.a.a());
  }

  public final void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (paramFloat > 0.5F)
      paramInt1++;
    this.a.a(paramInt1, paramFloat);
  }

  public final void a(ah paramah1, ah paramah2)
  {
    this.a.a(paramah1, paramah2);
  }

  public final void b(int paramInt)
  {
    this.b = paramInt;
  }

  public final void onChanged()
  {
    this.a.a(this.a.a.b(), this.a.a.a());
  }
}

/* Location:
 * Qualified Name:     android.support.v4.view.am
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
