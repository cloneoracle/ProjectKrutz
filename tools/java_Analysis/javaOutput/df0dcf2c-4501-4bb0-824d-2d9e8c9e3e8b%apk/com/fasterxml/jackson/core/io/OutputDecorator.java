package com.fasterxml.jackson.core.io;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

public abstract class OutputDecorator
  implements Serializable
{
  private static final long serialVersionUID = 1L;

  public abstract OutputStream decorate(IOContext paramIOContext, OutputStream paramOutputStream);

  public abstract Writer decorate(IOContext paramIOContext, Writer paramWriter);
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.core.io.OutputDecorator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
