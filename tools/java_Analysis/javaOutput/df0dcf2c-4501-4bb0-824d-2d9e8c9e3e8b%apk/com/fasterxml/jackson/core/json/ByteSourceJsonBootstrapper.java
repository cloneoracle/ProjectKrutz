package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.MergedStream;
import com.fasterxml.jackson.core.io.UTF32Reader;
import com.fasterxml.jackson.core.sym.BytesToNameCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.io.ByteArrayInputStream;
import java.io.CharConversionException;
import java.io.InputStream;
import java.io.InputStream;;
import java.io.InputStreamReader;
import java.io.Reader;

public final class ByteSourceJsonBootstrapper
{
  protected boolean _bigEndian = true;
  private final boolean _bufferRecyclable;
  protected int _bytesPerChar = 0;
  protected final IOContext _context;
  protected final InputStream _in;
  protected final byte[] _inputBuffer;
  private int _inputEnd;
  protected int _inputProcessed;
  private int _inputPtr;

  public ByteSourceJsonBootstrapper(IOContext paramIOContext, InputStream paramInputStream)
  {
    this._context = paramIOContext;
    this._in = paramInputStream;
    this._inputBuffer = paramIOContext.allocReadIOBuffer();
    this._inputPtr = 0;
    this._inputEnd = 0;
    this._inputProcessed = 0;
    this._bufferRecyclable = true;
  }

  public ByteSourceJsonBootstrapper(IOContext paramIOContext, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this._context = paramIOContext;
    this._in = null;
    this._inputBuffer = paramArrayOfByte;
    this._inputPtr = paramInt1;
    this._inputEnd = (paramInt1 + paramInt2);
    this._inputProcessed = (-paramInt1);
    this._bufferRecyclable = false;
  }

  private boolean checkUTF16(int paramInt)
  {
    if ((0xFF00 & paramInt) == 0);
    for (this._bigEndian = true; ; this._bigEndian = false)
    {
      this._bytesPerChar = 2;
      boolean bool = true;
      int i;
      do
      {
        return bool;
        i = paramInt & 0xFF;
        bool = false;
      }
      while (i != 0);
    }
  }

  private boolean checkUTF32(int paramInt)
  {
    if (paramInt >> 8 == 0)
      this._bigEndian = true;
    while (true)
    {
      this._bytesPerChar = 4;
      boolean bool = true;
      int i;
      do
      {
        return bool;
        if ((0xFFFFFF & paramInt) == 0)
        {
          this._bigEndian = false;
          break;
        }
        if ((0xFF00FFFF & paramInt) == 0)
        {
          reportWeirdUCS4("3412");
          break;
        }
        i = 0xFFFF00FF & paramInt;
        bool = false;
      }
      while (i != 0);
      reportWeirdUCS4("2143");
    }
  }

  private boolean handleBOM(int paramInt)
  {
    switch (paramInt)
    {
    default:
    case 65279:
    case -131072:
    case 65534:
    case -16842752:
    }
    int i;
    while (true)
    {
      i = paramInt >>> 16;
      if (i != 65279)
        break;
      this._inputPtr = (2 + this._inputPtr);
      this._bytesPerChar = 2;
      this._bigEndian = true;
      return true;
      this._bigEndian = true;
      this._inputPtr = (4 + this._inputPtr);
      this._bytesPerChar = 4;
      return true;
      this._inputPtr = (4 + this._inputPtr);
      this._bytesPerChar = 4;
      this._bigEndian = false;
      return true;
      reportWeirdUCS4("2143");
      reportWeirdUCS4("3412");
    }
    if (i == 65534)
    {
      this._inputPtr = (2 + this._inputPtr);
      this._bytesPerChar = 2;
      this._bigEndian = false;
      return true;
    }
    if (paramInt >>> 8 == 15711167)
    {
      this._inputPtr = (3 + this._inputPtr);
      this._bytesPerChar = 1;
      this._bigEndian = true;
      return true;
    }
    return false;
  }

  private void reportWeirdUCS4(String paramString)
  {
    throw new CharConversionException("Unsupported UCS-4 endianness (" + paramString + ") detected");
  }

  public final JsonParser constructParser(int paramInt, ObjectCodec paramObjectCodec, BytesToNameCanonicalizer paramBytesToNameCanonicalizer, CharsToNameCanonicalizer paramCharsToNameCanonicalizer, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((detectEncoding() == JsonEncoding.UTF8) && (paramBoolean1))
    {
      BytesToNameCanonicalizer localBytesToNameCanonicalizer = paramBytesToNameCanonicalizer.makeChild(paramBoolean1, paramBoolean2);
      return new UTF8StreamJsonParser(this._context, paramInt, this._in, paramObjectCodec, localBytesToNameCanonicalizer, this._inputBuffer, this._inputPtr, this._inputEnd, this._bufferRecyclable);
    }
    return new ReaderBasedJsonParser(this._context, paramInt, constructReader(), paramObjectCodec, paramCharsToNameCanonicalizer.makeChild(paramBoolean1, paramBoolean2));
  }

  public final Reader constructReader()
  {
    JsonEncoding localJsonEncoding = this._context.getEncoding();
    switch (ByteSourceJsonBootstrapper.1.$SwitchMap$com$fasterxml$jackson$core$JsonEncoding[localJsonEncoding.ordinal()])
    {
    default:
      throw new RuntimeException("Internal error");
    case 1:
    case 2:
      return new UTF32Reader(this._context, this._in, this._inputBuffer, this._inputPtr, this._inputEnd, this._context.getEncoding().isBigEndian());
    case 3:
    case 4:
    case 5:
    }
    InputStream localInputStream = this._in;
    Object localObject;
    if (localInputStream == null)
      localObject = new ByteArrayInputStream(this._inputBuffer, this._inputPtr, this._inputEnd);
    while (true)
    {
      return new InputStreamReader((InputStream)localObject, localJsonEncoding.getJavaName());
      if (this._inputPtr < this._inputEnd)
        localObject = new MergedStream(this._context, localInputStream, this._inputBuffer, this._inputPtr, this._inputEnd);
      else
        localObject = localInputStream;
    }
  }

  public final JsonEncoding detectEncoding()
  {
    int i = 1;
    int j;
    JsonEncoding localJsonEncoding;
    if (ensureLoaded(4))
    {
      j = this._inputBuffer[this._inputPtr] << 24 | (0xFF & this._inputBuffer[(1 + this._inputPtr)]) << 16 | (0xFF & this._inputBuffer[(2 + this._inputPtr)]) << 8 | 0xFF & this._inputBuffer[(3 + this._inputPtr)];
      if (handleBOM(j))
      {
        if (i != 0)
          break label177;
        localJsonEncoding = JsonEncoding.UTF8;
      }
    }
    while (true)
    {
      this._context.setEncoding(localJsonEncoding);
      return localJsonEncoding;
      if ((checkUTF32(j)) || (checkUTF16(j >>> 16)))
        break;
      do
      {
        i = 0;
        break;
      }
      while ((!ensureLoaded(2)) || (!checkUTF16((0xFF & this._inputBuffer[this._inputPtr]) << 8 | 0xFF & this._inputBuffer[(1 + this._inputPtr)])));
      break;
      label177: switch (this._bytesPerChar)
      {
      case 3:
      default:
        throw new RuntimeException("Internal error");
      case 1:
        localJsonEncoding = JsonEncoding.UTF8;
        break;
      case 2:
        if (this._bigEndian)
          localJsonEncoding = JsonEncoding.UTF16_BE;
        else
          localJsonEncoding = JsonEncoding.UTF16_LE;
        break;
      case 4:
        if (this._bigEndian)
          localJsonEncoding = JsonEncoding.UTF32_BE;
        else
          localJsonEncoding = JsonEncoding.UTF32_LE;
      }
    }
  }

  protected final boolean ensureLoaded(int paramInt)
  {
    int j;
    for (int i = this._inputEnd - this._inputPtr; i < paramInt; i = j + i)
    {
      if (this._in == null);
      for (j = -1; j <= 0; j = this._in.read(this._inputBuffer, this._inputEnd, this._inputBuffer.length - this._inputEnd))
        return false;
      this._inputEnd = (j + this._inputEnd);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
