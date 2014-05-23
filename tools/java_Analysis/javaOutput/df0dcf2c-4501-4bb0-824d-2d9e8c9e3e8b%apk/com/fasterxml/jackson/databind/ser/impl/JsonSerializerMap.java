package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.SerializerCache.TypeKey;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class JsonSerializerMap
{
  private final JsonSerializerMap.Bucket[] _buckets;
  private final int _size;

  public JsonSerializerMap(Map<SerializerCache.TypeKey, JsonSerializer<Object>> paramMap)
  {
    int i = findSize(paramMap.size());
    this._size = i;
    int j = i - 1;
    JsonSerializerMap.Bucket[] arrayOfBucket = new JsonSerializerMap.Bucket[i];
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      SerializerCache.TypeKey localTypeKey = (SerializerCache.TypeKey)localEntry.getKey();
      int k = j & localTypeKey.hashCode();
      arrayOfBucket[k] = new JsonSerializerMap.Bucket(arrayOfBucket[k], localTypeKey, (JsonSerializer)localEntry.getValue());
    }
    this._buckets = arrayOfBucket;
  }

  private static final int findSize(int paramInt)
  {
    if (paramInt <= 64);
    int j;
    for (int i = paramInt + paramInt; ; i = paramInt + (paramInt >> 2))
    {
      j = 8;
      while (j < i)
        j += j;
    }
    return j;
  }

  public JsonSerializer<Object> find(SerializerCache.TypeKey paramTypeKey)
  {
    int i = paramTypeKey.hashCode() & -1 + this._buckets.length;
    JsonSerializerMap.Bucket localBucket = this._buckets[i];
    if (localBucket == null)
      return null;
    if (paramTypeKey.equals(localBucket.key))
      return localBucket.value;
    do
    {
      localBucket = localBucket.next;
      if (localBucket == null)
        break;
    }
    while (!paramTypeKey.equals(localBucket.key));
    return localBucket.value;
    return null;
  }
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.databind.ser.impl.JsonSerializerMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */