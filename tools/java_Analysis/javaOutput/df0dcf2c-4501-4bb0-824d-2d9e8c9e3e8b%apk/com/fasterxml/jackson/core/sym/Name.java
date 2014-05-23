package com.fasterxml.jackson.core.sym;

public abstract class Name
{
  protected final int _hashCode;
  protected final String _name;

  protected Name(String paramString, int paramInt)
  {
    this._name = paramString;
    this._hashCode = paramInt;
  }

  public abstract boolean equals(int paramInt);

  public abstract boolean equals(int paramInt1, int paramInt2);

  public boolean equals(Object paramObject)
  {
    return paramObject == this;
  }

  public abstract boolean equals(int[] paramArrayOfInt, int paramInt);

  public String getName()
  {
    return this._name;
  }

  public final int hashCode()
  {
    return this._hashCode;
  }

  public String toString()
  {
    return this._name;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.sym.Name
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
