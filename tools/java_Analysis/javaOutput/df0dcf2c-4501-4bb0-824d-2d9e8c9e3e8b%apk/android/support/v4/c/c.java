package android.support.v4.c;

public final class c
{
  public static void a(Object paramObject, StringBuilder paramStringBuilder)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("null");
      return;
    }
    String str = paramObject.getClass().getSimpleName();
    if ((str == null) || (str.length() <= 0))
    {
      str = paramObject.getClass().getName();
      int i = str.lastIndexOf('.');
      if (i > 0)
        str = str.substring(i + 1);
    }
    paramStringBuilder.append(str);
    paramStringBuilder.append((char)'{');
    paramStringBuilder.append(Integer.toHexString(System.identityHashCode(paramObject)));
  }
}

/* Location:
 * Qualified Name:     android.support.v4.c.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
