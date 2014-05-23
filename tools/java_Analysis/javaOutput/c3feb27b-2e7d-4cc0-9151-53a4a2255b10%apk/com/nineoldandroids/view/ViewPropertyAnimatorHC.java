package com.nineoldandroids.view;

import android.view.View;
import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.ValueAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class ViewPropertyAnimatorHC extends ViewPropertyAnimator
{
  private static final int ALPHA = 512;
  private static final int NONE = 0;
  private static final int ROTATION = 16;
  private static final int ROTATION_X = 32;
  private static final int ROTATION_Y = 64;
  private static final int SCALE_X = 4;
  private static final int SCALE_Y = 8;
  private static final int TRANSFORM_MASK = 511;
  private static final int TRANSLATION_X = 1;
  private static final int TRANSLATION_Y = 2;
  private static final int X = 128;
  private static final int Y = 256;
  private Runnable mAnimationStarter = new ViewPropertyAnimatorHC.1(this);
  private ViewPropertyAnimatorHC.AnimatorEventListener mAnimatorEventListener = new ViewPropertyAnimatorHC.AnimatorEventListener(this, null);
  private HashMap<Animator, ViewPropertyAnimatorHC.PropertyBundle> mAnimatorMap = new HashMap();
  private long mDuration;
  private boolean mDurationSet = false;
  private Interpolator mInterpolator;
  private boolean mInterpolatorSet = false;
  private Animator.AnimatorListener mListener = null;
  ArrayList<ViewPropertyAnimatorHC.NameValuesHolder> mPendingAnimations = new ArrayList();
  private long mStartDelay = 0L;
  private boolean mStartDelaySet = false;
  private final WeakReference<View> mView;

  ViewPropertyAnimatorHC(View paramView)
  {
    this.mView = new WeakReference(paramView);
  }

  private void animateProperty(int paramInt, float paramFloat)
  {
    float f = getValue(paramInt);
    animatePropertyBy(paramInt, f, paramFloat - f);
  }

  private void animatePropertyBy(int paramInt, float paramFloat)
  {
    animatePropertyBy(paramInt, getValue(paramInt), paramFloat);
  }

  private void animatePropertyBy(int paramInt, float paramFloat1, float paramFloat2)
  {
    Iterator localIterator;
    Object localObject;
    if (this.mAnimatorMap.size() > 0)
    {
      localIterator = this.mAnimatorMap.keySet().iterator();
      boolean bool = localIterator.hasNext();
      localObject = null;
      if (bool)
        break label111;
    }
    while (true)
    {
      if (localObject != null)
        localObject.cancel();
      ViewPropertyAnimatorHC.NameValuesHolder localNameValuesHolder = new ViewPropertyAnimatorHC.NameValuesHolder(paramInt, paramFloat1, paramFloat2);
      this.mPendingAnimations.add(localNameValuesHolder);
      View localView = (View)this.mView.get();
      if (localView != null)
      {
        localView.removeCallbacks(this.mAnimationStarter);
        localView.post(this.mAnimationStarter);
      }
      return;
      label111: Animator localAnimator = (Animator)localIterator.next();
      ViewPropertyAnimatorHC.PropertyBundle localPropertyBundle = (ViewPropertyAnimatorHC.PropertyBundle)this.mAnimatorMap.get(localAnimator);
      if ((!localPropertyBundle.cancel(paramInt)) || (localPropertyBundle.mPropertyMask != 0))
        break;
      localObject = localAnimator;
    }
  }

  private float getValue(int paramInt)
  {
    View localView = (View)this.mView.get();
    if (localView != null);
    switch (paramInt)
    {
    default:
      return 0.0F;
    case 1:
      return localView.getTranslationX();
    case 2:
      return localView.getTranslationY();
    case 16:
      return localView.getRotation();
    case 32:
      return localView.getRotationX();
    case 64:
      return localView.getRotationY();
    case 4:
      return localView.getScaleX();
    case 8:
      return localView.getScaleY();
    case 128:
      return localView.getX();
    case 256:
      return localView.getY();
    case 512:
    }
    return localView.getAlpha();
  }

  private void setValue(int paramInt, float paramFloat)
  {
    View localView = (View)this.mView.get();
    if (localView != null);
    switch (paramInt)
    {
    default:
      return;
    case 1:
      localView.setTranslationX(paramFloat);
      return;
    case 2:
      localView.setTranslationY(paramFloat);
      return;
    case 16:
      localView.setRotation(paramFloat);
      return;
    case 32:
      localView.setRotationX(paramFloat);
      return;
    case 64:
      localView.setRotationY(paramFloat);
      return;
    case 4:
      localView.setScaleX(paramFloat);
      return;
    case 8:
      localView.setScaleY(paramFloat);
      return;
    case 128:
      localView.setX(paramFloat);
      return;
    case 256:
      localView.setY(paramFloat);
      return;
    case 512:
    }
    localView.setAlpha(paramFloat);
  }

  private void startAnimation()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    ArrayList localArrayList = (ArrayList)this.mPendingAnimations.clone();
    this.mPendingAnimations.clear();
    int i = 0;
    int j = localArrayList.size();
    for (int k = 0; ; k++)
    {
      if (k >= j)
      {
        this.mAnimatorMap.put(localValueAnimator, new ViewPropertyAnimatorHC.PropertyBundle(i, localArrayList));
        localValueAnimator.addUpdateListener(this.mAnimatorEventListener);
        localValueAnimator.addListener(this.mAnimatorEventListener);
        if (this.mStartDelaySet)
          localValueAnimator.setStartDelay(this.mStartDelay);
        if (this.mDurationSet)
          localValueAnimator.setDuration(this.mDuration);
        if (this.mInterpolatorSet)
          localValueAnimator.setInterpolator(this.mInterpolator);
        localValueAnimator.start();
        return;
      }
      i |= ((ViewPropertyAnimatorHC.NameValuesHolder)localArrayList.get(k)).mNameConstant;
    }
  }

  public ViewPropertyAnimator alpha(float paramFloat)
  {
    animateProperty(512, paramFloat);
    return this;
  }

  public ViewPropertyAnimator alphaBy(float paramFloat)
  {
    animatePropertyBy(512, paramFloat);
    return this;
  }

  public void cancel()
  {
    Iterator localIterator;
    if (this.mAnimatorMap.size() > 0)
      localIterator = ((HashMap)this.mAnimatorMap.clone()).keySet().iterator();
    while (true)
    {
      if (!localIterator.hasNext())
      {
        this.mPendingAnimations.clear();
        View localView = (View)this.mView.get();
        if (localView != null)
          localView.removeCallbacks(this.mAnimationStarter);
        return;
      }
      ((Animator)localIterator.next()).cancel();
    }
  }

  public long getDuration()
  {
    if (this.mDurationSet)
      return this.mDuration;
    return new ValueAnimator().getDuration();
  }

  public long getStartDelay()
  {
    if (this.mStartDelaySet)
      return this.mStartDelay;
    return 0L;
  }

  public ViewPropertyAnimator rotation(float paramFloat)
  {
    animateProperty(16, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationBy(float paramFloat)
  {
    animatePropertyBy(16, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationX(float paramFloat)
  {
    animateProperty(32, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationXBy(float paramFloat)
  {
    animatePropertyBy(32, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationY(float paramFloat)
  {
    animateProperty(64, paramFloat);
    return this;
  }

  public ViewPropertyAnimator rotationYBy(float paramFloat)
  {
    animatePropertyBy(64, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleX(float paramFloat)
  {
    animateProperty(4, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleXBy(float paramFloat)
  {
    animatePropertyBy(4, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleY(float paramFloat)
  {
    animateProperty(8, paramFloat);
    return this;
  }

  public ViewPropertyAnimator scaleYBy(float paramFloat)
  {
    animatePropertyBy(8, paramFloat);
    return this;
  }

  public ViewPropertyAnimator setDuration(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.mDurationSet = true;
    this.mDuration = paramLong;
    return this;
  }

  public ViewPropertyAnimator setInterpolator(Interpolator paramInterpolator)
  {
    this.mInterpolatorSet = true;
    this.mInterpolator = paramInterpolator;
    return this;
  }

  public ViewPropertyAnimator setListener(Animator.AnimatorListener paramAnimatorListener)
  {
    this.mListener = paramAnimatorListener;
    return this;
  }

  public ViewPropertyAnimator setStartDelay(long paramLong)
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("Animators cannot have negative duration: " + paramLong);
    this.mStartDelaySet = true;
    this.mStartDelay = paramLong;
    return this;
  }

  public void start()
  {
    startAnimation();
  }

  public ViewPropertyAnimator translationX(float paramFloat)
  {
    animateProperty(1, paramFloat);
    return this;
  }

  public ViewPropertyAnimator translationXBy(float paramFloat)
  {
    animatePropertyBy(1, paramFloat);
    return this;
  }

  public ViewPropertyAnimator translationY(float paramFloat)
  {
    animateProperty(2, paramFloat);
    return this;
  }

  public ViewPropertyAnimator translationYBy(float paramFloat)
  {
    animatePropertyBy(2, paramFloat);
    return this;
  }

  public ViewPropertyAnimator x(float paramFloat)
  {
    animateProperty(128, paramFloat);
    return this;
  }

  public ViewPropertyAnimator xBy(float paramFloat)
  {
    animatePropertyBy(128, paramFloat);
    return this;
  }

  public ViewPropertyAnimator y(float paramFloat)
  {
    animateProperty(256, paramFloat);
    return this;
  }

  public ViewPropertyAnimator yBy(float paramFloat)
  {
    animatePropertyBy(256, paramFloat);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.nineoldandroids.view.ViewPropertyAnimatorHC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
