package com.fasterxml.jackson.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
public @interface JacksonInject
{
  public abstract String value();
}

/* Location:
 * Qualified Name:     com.fasterxml.jackson.annotation.JacksonInject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
