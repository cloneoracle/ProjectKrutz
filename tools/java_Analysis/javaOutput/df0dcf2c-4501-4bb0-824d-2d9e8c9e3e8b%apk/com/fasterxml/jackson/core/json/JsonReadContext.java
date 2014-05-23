package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.io.CharTypes;

public final class JsonReadContext extends JsonStreamContext
{
  protected JsonReadContext _child = null;
  protected int _columnNr;
  protected String _currentName;
  protected int _lineNr;
  protected final JsonReadContext _parent;

  public JsonReadContext(JsonReadContext paramJsonReadContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this._type = paramInt1;
    this._parent = paramJsonReadContext;
    this._lineNr = paramInt2;
    this._columnNr = paramInt3;
    this._index = -1;
  }

  public static JsonReadContext createRootContext()
  {
    return new JsonReadContext(null, 0, 1, 0);
  }

  public static JsonReadContext createRootContext(int paramInt1, int paramInt2)
  {
    return new JsonReadContext(null, 0, paramInt1, paramInt2);
  }

  public final JsonReadContext createChildArrayContext(int paramInt1, int paramInt2)
  {
    JsonReadContext localJsonReadContext1 = this._child;
    if (localJsonReadContext1 == null)
    {
      JsonReadContext localJsonReadContext2 = new JsonReadContext(this, 1, paramInt1, paramInt2);
      this._child = localJsonReadContext2;
      return localJsonReadContext2;
    }
    localJsonReadContext1.reset(1, paramInt1, paramInt2);
    return localJsonReadContext1;
  }

  public final JsonReadContext createChildObjectContext(int paramInt1, int paramInt2)
  {
    JsonReadContext localJsonReadContext1 = this._child;
    if (localJsonReadContext1 == null)
    {
      JsonReadContext localJsonReadContext2 = new JsonReadContext(this, 2, paramInt1, paramInt2);
      this._child = localJsonReadContext2;
      return localJsonReadContext2;
    }
    localJsonReadContext1.reset(2, paramInt1, paramInt2);
    return localJsonReadContext1;
  }

  public final boolean expectComma()
  {
    int i = 1 + this._index;
    this._index = i;
    return (this._type != 0) && (i > 0);
  }

  public final String getCurrentName()
  {
    return this._currentName;
  }

  public final JsonReadContext getParent()
  {
    return this._parent;
  }

  public final JsonLocation getStartLocation(Object paramObject)
  {
    return new JsonLocation(paramObject, -1L, this._lineNr, this._columnNr);
  }

  protected final void reset(int paramInt1, int paramInt2, int paramInt3)
  {
    this._type = paramInt1;
    this._index = -1;
    this._lineNr = paramInt2;
    this._columnNr = paramInt3;
    this._currentName = null;
  }

  public final void setCurrentName(String paramString)
  {
    this._currentName = paramString;
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    switch (this._type)
    {
    default:
    case 0:
    case 1:
      while (true)
      {
        return localStringBuilder.toString();
        localStringBuilder.append("/");
        continue;
        localStringBuilder.append((char)'[');
        localStringBuilder.append(getCurrentIndex());
        localStringBuilder.append((char)']');
      }
    case 2:
    }
    localStringBuilder.append((char)'{');
    if (this._currentName != null)
    {
      localStringBuilder.append((char)'"');
      CharTypes.appendQuoted(localStringBuilder, this._currentName);
      localStringBuilder.append((char)'"');
    }
    while (true)
    {
      localStringBuilder.append((char)'}');
      break;
      localStringBuilder.append((char)'?');
    }
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.JsonReadContext
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
