package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;

public final class CollectionType extends CollectionLikeType
{
  private static final long serialVersionUID = 7218006718717444365L;

  private CollectionType(Class<?> paramClass, JavaType paramJavaType, Object paramObject1, Object paramObject2)
  {
    super(paramClass, paramJavaType, paramObject1, paramObject2);
  }

  public static CollectionType construct(Class<?> paramClass, JavaType paramJavaType)
  {
    return new CollectionType(paramClass, paramJavaType, null, null);
  }

  protected final JavaType _narrow(Class<?> paramClass)
  {
    return new CollectionType(paramClass, this._elementType, null, null);
  }

  public final JavaType narrowContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._elementType.getRawClass())
      return this;
    return new CollectionType(this._class, this._elementType.narrowBy(paramClass), this._valueHandler, this._typeHandler);
  }

  public final String toString()
  {
    return "[collection type; class " + this._class.getName() + ", contains " + this._elementType + "]";
  }

  public final JavaType widenContentsBy(Class<?> paramClass)
  {
    if (paramClass == this._elementType.getRawClass())
      return this;
    return new CollectionType(this._class, this._elementType.widenBy(paramClass), this._valueHandler, this._typeHandler);
  }

  public final CollectionType withContentTypeHandler(Object paramObject)
  {
    return new CollectionType(this._class, this._elementType.withTypeHandler(paramObject), this._valueHandler, this._typeHandler);
  }

  public final CollectionType withContentValueHandler(Object paramObject)
  {
    return new CollectionType(this._class, this._elementType.withValueHandler(paramObject), this._valueHandler, this._typeHandler);
  }

  public final CollectionType withTypeHandler(Object paramObject)
  {
    return new CollectionType(this._class, this._elementType, this._valueHandler, paramObject);
  }

  public final CollectionType withValueHandler(Object paramObject)
  {
    return new CollectionType(this._class, this._elementType, paramObject, this._typeHandler);
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.type.CollectionType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
