public final class ct extends cm
{
  private static final char[] a = { '+' };
  private static final char[] b = "0123456789ABCDEF".toCharArray();
  private final boolean c;
  private final boolean[] d;

  public ct(String paramString, boolean paramBoolean)
  {
    if (paramString.matches(".*[0-9A-Za-z].*"))
      throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    if (paramString.contains("%"))
      throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
    this.c = false;
    this.d = b(paramString);
  }

  private static boolean[] b(String paramString)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int i = arrayOfChar.length;
    int j = 0;
    int k = 122;
    while (j < i)
    {
      k = Math.max(arrayOfChar[j], k);
      j++;
    }
    boolean[] arrayOfBoolean = new boolean[k + 1];
    for (int m = 48; m <= 57; m++)
      arrayOfBoolean[m] = true;
    for (int n = 65; n <= 90; n++)
      arrayOfBoolean[n] = true;
    for (int i1 = 97; i1 <= 122; i1++)
      arrayOfBoolean[i1] = true;
    int i2 = arrayOfChar.length;
    for (int i3 = 0; i3 < i2; i3++)
      arrayOfBoolean[arrayOfChar[i3]] = true;
    return arrayOfBoolean;
  }

  protected final int a(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    for (int i = paramInt1; i < paramInt2; i++)
    {
      int j = paramCharSequence.charAt(i);
      if ((j >= this.d.length) || (this.d[j] == 0))
        break;
    }
    return i;
  }

  public final String a(String paramString)
  {
    int i = paramString.length();
    for (int j = 0; j < i; j++)
    {
      int k = paramString.charAt(j);
      if ((k >= this.d.length) || (this.d[k] == 0))
        return a(paramString, j);
    }
    return paramString;
  }

  protected final char[] a(int paramInt)
  {
    if ((paramInt < this.d.length) && (this.d[paramInt] != 0))
      return null;
    if ((paramInt == 32) && (this.c))
      return a;
    if (paramInt <= 127)
    {
      char[] arrayOfChar4 = new char[3];
      arrayOfChar4[0] = '%';
      arrayOfChar4[2] = b[(paramInt & 0xF)];
      arrayOfChar4[1] = b[(paramInt >>> 4)];
      return arrayOfChar4;
    }
    if (paramInt <= 2047)
    {
      char[] arrayOfChar3 = new char[6];
      arrayOfChar3[0] = '%';
      arrayOfChar3[3] = '%';
      arrayOfChar3[5] = b[(paramInt & 0xF)];
      int i6 = paramInt >>> 4;
      arrayOfChar3[4] = b[(0x8 | i6 & 0x3)];
      int i7 = i6 >>> 2;
      arrayOfChar3[2] = b[(i7 & 0xF)];
      int i8 = i7 >>> 4;
      arrayOfChar3[1] = b[(i8 | 0xC)];
      return arrayOfChar3;
    }
    if (paramInt <= 65535)
    {
      char[] arrayOfChar2 = new char[9];
      arrayOfChar2[0] = '%';
      arrayOfChar2[1] = 'E';
      arrayOfChar2[3] = '%';
      arrayOfChar2[6] = '%';
      arrayOfChar2[8] = b[(paramInt & 0xF)];
      int i2 = paramInt >>> 4;
      arrayOfChar2[7] = b[(0x8 | i2 & 0x3)];
      int i3 = i2 >>> 2;
      arrayOfChar2[5] = b[(i3 & 0xF)];
      int i4 = i3 >>> 4;
      arrayOfChar2[4] = b[(0x8 | i4 & 0x3)];
      int i5 = i4 >>> 2;
      arrayOfChar2[2] = b[i5];
      return arrayOfChar2;
    }
    if (paramInt <= 1114111)
    {
      char[] arrayOfChar1 = new char[12];
      arrayOfChar1[0] = '%';
      arrayOfChar1[1] = 'F';
      arrayOfChar1[3] = '%';
      arrayOfChar1[6] = '%';
      arrayOfChar1[9] = '%';
      arrayOfChar1[11] = b[(paramInt & 0xF)];
      int i = paramInt >>> 4;
      arrayOfChar1[10] = b[(0x8 | i & 0x3)];
      int j = i >>> 2;
      arrayOfChar1[8] = b[(j & 0xF)];
      int k = j >>> 4;
      arrayOfChar1[7] = b[(0x8 | k & 0x3)];
      int m = k >>> 2;
      arrayOfChar1[5] = b[(m & 0xF)];
      int n = m >>> 4;
      arrayOfChar1[4] = b[(0x8 | n & 0x3)];
      int i1 = n >>> 2;
      arrayOfChar1[2] = b[(i1 & 0x7)];
      return arrayOfChar1;
    }
    throw new IllegalArgumentException("Invalid unicode character value " + paramInt);
  }
}

/* Location:
 * Qualified Name:     ct
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */