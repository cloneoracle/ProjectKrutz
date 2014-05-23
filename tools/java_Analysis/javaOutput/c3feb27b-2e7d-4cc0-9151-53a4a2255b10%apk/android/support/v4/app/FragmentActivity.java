package android.support.v4.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FragmentActivity extends Activity
{
  static final String FRAGMENTS_TAG = "android:support:fragments";
  private static final int HONEYCOMB = 11;
  static final int MSG_REALLY_STOPPED = 1;
  static final int MSG_RESUME_PENDING = 2;
  private static final String TAG = "FragmentActivity";
  SimpleArrayMap<String, LoaderManagerImpl> mAllLoaderManagers;
  boolean mCheckedForLoaderManager;
  final FragmentContainer mContainer = new FragmentActivity.2(this);
  boolean mCreated;
  final FragmentManagerImpl mFragments = new FragmentManagerImpl();
  final Handler mHandler = new FragmentActivity.1(this);
  LoaderManagerImpl mLoaderManager;
  boolean mLoadersStarted;
  boolean mOptionsMenuInvalidated;
  boolean mReallyStopped;
  boolean mResumed;
  boolean mRetaining;
  boolean mStopped;

  public FragmentActivity()
  {
  }

  private void dumpViewHierarchy(String paramString, PrintWriter paramPrintWriter, View paramView)
  {
    paramPrintWriter.print(paramString);
    if (paramView == null)
      paramPrintWriter.println("null");
    while (true)
    {
      return;
      paramPrintWriter.println(viewToString(paramView));
      if ((paramView instanceof ViewGroup))
      {
        ViewGroup localViewGroup = (ViewGroup)paramView;
        int i = localViewGroup.getChildCount();
        if (i > 0)
        {
          String str = paramString + "  ";
          for (int j = 0; j < i; j++)
            dumpViewHierarchy(str, paramPrintWriter, localViewGroup.getChildAt(j));
        }
      }
    }
  }

  private static String viewToString(View paramView)
  {
    c1 = 'F';
    c2 = '.';
    localStringBuilder = new StringBuilder(128);
    localStringBuilder.append(paramView.getClass().getName());
    localStringBuilder.append((char)'{');
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(paramView)));
    localStringBuilder.append((char)' ');
    switch (paramView.getVisibility())
    {
    default:
      localStringBuilder.append(c2);
      while (true)
        if (paramView.isFocusable())
        {
          c3 = c1;
          label108: localStringBuilder.append(c3);
          if (!paramView.isEnabled())
            break label533;
          c4 = 'E';
          label126: localStringBuilder.append(c4);
          if (!paramView.willNotDraw())
            break label539;
          c5 = c2;
          label143: localStringBuilder.append(c5);
          if (!paramView.isHorizontalScrollBarEnabled())
            break label546;
          c6 = 'H';
          label161: localStringBuilder.append(c6);
          if (!paramView.isVerticalScrollBarEnabled())
            break label552;
          c7 = 'V';
          label179: localStringBuilder.append(c7);
          if (!paramView.isClickable())
            break label558;
          c8 = 'C';
          label197: localStringBuilder.append(c8);
          if (!paramView.isLongClickable())
            break label564;
          c9 = 'L';
          label215: localStringBuilder.append(c9);
          localStringBuilder.append((char)' ');
          if (!paramView.isFocused())
            break label570;
          label236: localStringBuilder.append(c1);
          if (!paramView.isSelected())
            break label575;
          c10 = 'S';
          label253: localStringBuilder.append(c10);
          if (paramView.isPressed())
            c2 = 'P';
          localStringBuilder.append(c2);
          localStringBuilder.append((char)' ');
          localStringBuilder.append(paramView.getLeft());
          localStringBuilder.append((char)',');
          localStringBuilder.append(paramView.getTop());
          localStringBuilder.append((char)'-');
          localStringBuilder.append(paramView.getRight());
          localStringBuilder.append((char)',');
          localStringBuilder.append(paramView.getBottom());
          i = paramView.getId();
          if (i != -1)
          {
            localStringBuilder.append(" #");
            localStringBuilder.append(Integer.toHexString(i));
            localResources = paramView.getResources();
            if ((i != 0) && (localResources != null))
              switch (0xFF000000 & i)
              {
              default:
                try
                {
                  String str1 = localResources.getResourcePackageName(i);
                  while (true)
                  {
                    String str2 = localResources.getResourceTypeName(i);
                    String str3 = localResources.getResourceEntryName(i);
                    localStringBuilder.append(" ");
                    localStringBuilder.append(str1);
                    localStringBuilder.append(":");
                    localStringBuilder.append(str2);
                    localStringBuilder.append("/");
                    localStringBuilder.append(str3);
                    localStringBuilder.append("}");
                    return localStringBuilder.toString();
                    localStringBuilder.append((char)'V');
                    break;
                    localStringBuilder.append((char)'I');
                    break;
                    localStringBuilder.append((char)'G');
                    break;
                    c3 = c2;
                    break label108;
                    c4 = c2;
                    break label126;
                    c5 = 'D';
                    break label143;
                    c6 = c2;
                    break label161;
                    c7 = c2;
                    break label179;
                    c8 = c2;
                    break label197;
                    c9 = c2;
                    break label215;
                    c1 = c2;
                    break label236;
                    c10 = c2;
                    break label253;
                    str1 = "app";
                    continue;
                    str1 = "android";
                  }
                }
                catch (Resources.NotFoundException localNotFoundException)
                {
                  break label485;
                }
              case 2130706432:
              case 16777216:
              }
          }
        }
    case 0:
    case 4:
    case 8:
    }
  }

  void doReallyStop(boolean paramBoolean)
  {
    if (!this.mReallyStopped)
    {
      this.mReallyStopped = true;
      this.mRetaining = paramBoolean;
      this.mHandler.removeMessages(1);
      onReallyStop();
    }
  }

  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 11);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("Local FragmentActivity ");
    paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
    paramPrintWriter.println(" State:");
    String str = paramString + "  ";
    paramPrintWriter.print(str);
    paramPrintWriter.print("mCreated=");
    paramPrintWriter.print(this.mCreated);
    paramPrintWriter.print("mResumed=");
    paramPrintWriter.print(this.mResumed);
    paramPrintWriter.print(" mStopped=");
    paramPrintWriter.print(this.mStopped);
    paramPrintWriter.print(" mReallyStopped=");
    paramPrintWriter.println(this.mReallyStopped);
    paramPrintWriter.print(str);
    paramPrintWriter.print("mLoadersStarted=");
    paramPrintWriter.println(this.mLoadersStarted);
    if (this.mLoaderManager != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("Loader Manager ");
      paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this.mLoaderManager)));
      paramPrintWriter.println(":");
      this.mLoaderManager.dump(paramString + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
    this.mFragments.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.println("View Hierarchy:");
    dumpViewHierarchy(paramString + "  ", paramPrintWriter, getWindow().getDecorView());
  }

  public Object getLastCustomNonConfigurationInstance()
  {
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = (FragmentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null)
      return localNonConfigurationInstances.custom;
    return null;
  }

  LoaderManagerImpl getLoaderManager(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.mAllLoaderManagers == null)
      this.mAllLoaderManagers = new SimpleArrayMap();
    LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
    if (localLoaderManagerImpl == null)
    {
      if (paramBoolean2)
      {
        localLoaderManagerImpl = new LoaderManagerImpl(paramString, this, paramBoolean1);
        this.mAllLoaderManagers.put(paramString, localLoaderManagerImpl);
      }
      return localLoaderManagerImpl;
    }
    localLoaderManagerImpl.updateActivity(this);
    return localLoaderManagerImpl;
  }

  public FragmentManager getSupportFragmentManager()
  {
    return this.mFragments;
  }

  public LoaderManager getSupportLoaderManager()
  {
    if (this.mLoaderManager != null)
      return this.mLoaderManager;
    this.mCheckedForLoaderManager = true;
    this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, true);
    return this.mLoaderManager;
  }

  void invalidateSupportFragment(String paramString)
  {
    if (this.mAllLoaderManagers != null)
    {
      LoaderManagerImpl localLoaderManagerImpl = (LoaderManagerImpl)this.mAllLoaderManagers.get(paramString);
      if ((localLoaderManagerImpl != null) && (!localLoaderManagerImpl.mRetaining))
      {
        localLoaderManagerImpl.doDestroy();
        this.mAllLoaderManagers.remove(paramString);
      }
    }
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mFragments.noteStateNotSaved();
    int i = paramInt1 >> 16;
    if (i != 0)
    {
      int j = i - 1;
      if ((this.mFragments.mActive == null) || (j < 0) || (j >= this.mFragments.mActive.size()))
      {
        Log.w("FragmentActivity", "Activity result fragment index out of range: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      Fragment localFragment = (Fragment)this.mFragments.mActive.get(j);
      if (localFragment == null)
      {
        Log.w("FragmentActivity", "Activity result no fragment exists for index: 0x" + Integer.toHexString(paramInt1));
        return;
      }
      localFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onAttachFragment(Fragment paramFragment)
  {
  }

  public void onBackPressed()
  {
    if (!this.mFragments.popBackStackImmediate())
      finish();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.mFragments.dispatchConfigurationChanged(paramConfiguration);
  }

  protected void onCreate(Bundle paramBundle)
  {
    this.mFragments.attachActivity(this, this.mContainer, null);
    if (getLayoutInflater().getFactory() == null)
      getLayoutInflater().setFactory(this);
    super.onCreate(paramBundle);
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = (FragmentActivity.NonConfigurationInstances)getLastNonConfigurationInstance();
    if (localNonConfigurationInstances != null)
      this.mAllLoaderManagers = localNonConfigurationInstances.loaders;
    if (paramBundle != null)
    {
      Parcelable localParcelable = paramBundle.getParcelable("android:support:fragments");
      FragmentManagerImpl localFragmentManagerImpl = this.mFragments;
      ArrayList localArrayList = null;
      if (localNonConfigurationInstances != null)
        localArrayList = localNonConfigurationInstances.fragments;
      localFragmentManagerImpl.restoreAllState(localParcelable, localArrayList);
    }
    this.mFragments.dispatchCreate();
  }

  public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
  {
    if (paramInt == 0)
    {
      boolean bool = super.onCreatePanelMenu(paramInt, paramMenu) | this.mFragments.dispatchCreateOptionsMenu(paramMenu, getMenuInflater());
      if (Build.VERSION.SDK_INT >= 11)
        return bool;
      return true;
    }
    return super.onCreatePanelMenu(paramInt, paramMenu);
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString))
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, FragmentActivity.FragmentTag.Fragment);
    if (str1 == null)
      str1 = localTypedArray.getString(0);
    int i = localTypedArray.getResourceId(1, -1);
    String str2 = localTypedArray.getString(2);
    localTypedArray.recycle();
    if (!Fragment.isSupportFragmentClass(this, str1))
      return super.onCreateView(paramString, paramContext, paramAttributeSet);
    int j = 0;
    if (0 != 0)
      j = null.getId();
    if ((j == -1) && (i == -1) && (str2 == null))
      throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
    Fragment localFragment = null;
    if (i != -1)
      localFragment = this.mFragments.findFragmentById(i);
    if ((localFragment == null) && (str2 != null))
      localFragment = this.mFragments.findFragmentByTag(str2);
    if ((localFragment == null) && (j != -1))
      localFragment = this.mFragments.findFragmentById(j);
    if (FragmentManagerImpl.DEBUG)
      Log.v("FragmentActivity", "onCreateView: id=0x" + Integer.toHexString(i) + " fname=" + str1 + " existing=" + localFragment);
    int k;
    if (localFragment == null)
    {
      localFragment = Fragment.instantiate(this, str1);
      localFragment.mFromLayout = true;
      if (i != 0)
      {
        k = i;
        localFragment.mFragmentId = k;
        localFragment.mContainerId = j;
        localFragment.mTag = str2;
        localFragment.mInLayout = true;
        localFragment.mFragmentManager = this.mFragments;
        localFragment.onInflate(this, paramAttributeSet, localFragment.mSavedFragmentState);
        this.mFragments.addFragment(localFragment, true);
      }
    }
    while (true)
    {
      if (localFragment.mView != null)
        break label540;
      throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
      k = j;
      break;
      if (localFragment.mInLayout)
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(i) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(j) + " with another fragment for " + str1);
      localFragment.mInLayout = true;
      if (!localFragment.mRetaining)
        localFragment.onInflate(this, paramAttributeSet, localFragment.mSavedFragmentState);
      this.mFragments.moveToState(localFragment);
    }
    label540: if (i != 0)
      localFragment.mView.setId(i);
    if (localFragment.mView.getTag() == null)
      localFragment.mView.setTag(str2);
    return localFragment.mView;
  }

  protected void onDestroy()
  {
    super.onDestroy();
    doReallyStop(false);
    this.mFragments.dispatchDestroy();
    if (this.mLoaderManager != null)
      this.mLoaderManager.doDestroy();
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((Build.VERSION.SDK_INT < 5) && (paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      onBackPressed();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    this.mFragments.dispatchLowMemory();
  }

  public boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem))
      return true;
    switch (paramInt)
    {
    default:
      return false;
    case 0:
      return this.mFragments.dispatchOptionsItemSelected(paramMenuItem);
    case 6:
    }
    return this.mFragments.dispatchContextItemSelected(paramMenuItem);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.mFragments.noteStateNotSaved();
  }

  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    switch (paramInt)
    {
    default:
    case 0:
    }
    while (true)
    {
      super.onPanelClosed(paramInt, paramMenu);
      return;
      this.mFragments.dispatchOptionsMenuClosed(paramMenu);
    }
  }

  protected void onPause()
  {
    super.onPause();
    this.mResumed = false;
    if (this.mHandler.hasMessages(2))
    {
      this.mHandler.removeMessages(2);
      onResumeFragments();
    }
    this.mFragments.dispatchPause();
  }

  protected void onPostResume()
  {
    super.onPostResume();
    this.mHandler.removeMessages(2);
    onResumeFragments();
    this.mFragments.execPendingActions();
  }

  protected boolean onPrepareOptionsPanel(View paramView, Menu paramMenu)
  {
    return super.onPreparePanel(0, paramView, paramMenu);
  }

  public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
  {
    if ((paramInt == 0) && (paramMenu != null))
    {
      if (this.mOptionsMenuInvalidated)
      {
        this.mOptionsMenuInvalidated = false;
        paramMenu.clear();
        onCreatePanelMenu(paramInt, paramMenu);
      }
      return onPrepareOptionsPanel(paramView, paramMenu) | this.mFragments.dispatchPrepareOptionsMenu(paramMenu);
    }
    return super.onPreparePanel(paramInt, paramView, paramMenu);
  }

  void onReallyStop()
  {
    if (this.mLoadersStarted)
    {
      this.mLoadersStarted = false;
      if (this.mLoaderManager != null)
      {
        if (this.mRetaining)
          break label41;
        this.mLoaderManager.doStop();
      }
    }
    while (true)
    {
      this.mFragments.dispatchReallyStop();
      return;
      label41: this.mLoaderManager.doRetain();
    }
  }

  protected void onResume()
  {
    super.onResume();
    this.mHandler.sendEmptyMessage(2);
    this.mResumed = true;
    this.mFragments.execPendingActions();
  }

  protected void onResumeFragments()
  {
    this.mFragments.dispatchResume();
  }

  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }

  public final Object onRetainNonConfigurationInstance()
  {
    if (this.mStopped)
      doReallyStop(true);
    Object localObject = onRetainCustomNonConfigurationInstance();
    ArrayList localArrayList = this.mFragments.retainNonConfig();
    SimpleArrayMap localSimpleArrayMap = this.mAllLoaderManagers;
    int i = 0;
    if (localSimpleArrayMap != null)
    {
      int j = this.mAllLoaderManagers.size();
      LoaderManagerImpl[] arrayOfLoaderManagerImpl = new LoaderManagerImpl[j];
      for (int k = j - 1; k >= 0; k--)
        arrayOfLoaderManagerImpl[k] = ((LoaderManagerImpl)this.mAllLoaderManagers.valueAt(k));
      int m = 0;
      if (m < j)
      {
        LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[m];
        if (localLoaderManagerImpl.mRetaining)
          i = 1;
        while (true)
        {
          m++;
          break;
          localLoaderManagerImpl.doDestroy();
          this.mAllLoaderManagers.remove(localLoaderManagerImpl.mWho);
        }
      }
    }
    if ((localArrayList == null) && (i == 0) && (localObject == null))
      return null;
    FragmentActivity.NonConfigurationInstances localNonConfigurationInstances = new FragmentActivity.NonConfigurationInstances();
    localNonConfigurationInstances.activity = null;
    localNonConfigurationInstances.custom = localObject;
    localNonConfigurationInstances.children = null;
    localNonConfigurationInstances.fragments = localArrayList;
    localNonConfigurationInstances.loaders = this.mAllLoaderManagers;
    return localNonConfigurationInstances;
  }

  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    Parcelable localParcelable = this.mFragments.saveAllState();
    if (localParcelable != null)
      paramBundle.putParcelable("android:support:fragments", localParcelable);
  }

  protected void onStart()
  {
    super.onStart();
    this.mStopped = false;
    this.mReallyStopped = false;
    this.mHandler.removeMessages(1);
    if (!this.mCreated)
    {
      this.mCreated = true;
      this.mFragments.dispatchActivityCreated();
    }
    this.mFragments.noteStateNotSaved();
    this.mFragments.execPendingActions();
    if (!this.mLoadersStarted)
    {
      this.mLoadersStarted = true;
      if (this.mLoaderManager == null)
        break label146;
      this.mLoaderManager.doStart();
    }
    int i;
    LoaderManagerImpl[] arrayOfLoaderManagerImpl;
    while (true)
    {
      this.mCheckedForLoaderManager = true;
      this.mFragments.dispatchStart();
      if (this.mAllLoaderManagers == null)
        return;
      i = this.mAllLoaderManagers.size();
      arrayOfLoaderManagerImpl = new LoaderManagerImpl[i];
      for (int j = i - 1; j >= 0; j--)
        arrayOfLoaderManagerImpl[j] = ((LoaderManagerImpl)this.mAllLoaderManagers.valueAt(j));
      label146: if (!this.mCheckedForLoaderManager)
      {
        this.mLoaderManager = getLoaderManager("(root)", this.mLoadersStarted, false);
        if ((this.mLoaderManager != null) && (!this.mLoaderManager.mStarted))
          this.mLoaderManager.doStart();
      }
    }
    for (int k = 0; k < i; k++)
    {
      LoaderManagerImpl localLoaderManagerImpl = arrayOfLoaderManagerImpl[k];
      localLoaderManagerImpl.finishRetain();
      localLoaderManagerImpl.doReportStart();
    }
  }

  protected void onStop()
  {
    super.onStop();
    this.mStopped = true;
    this.mHandler.sendEmptyMessage(1);
    this.mFragments.dispatchStop();
  }

  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    if ((paramInt != -1) && ((0xFFFF0000 & paramInt) != 0))
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, paramInt);
  }

  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    if (paramInt == -1)
    {
      super.startActivityForResult(paramIntent, -1);
      return;
    }
    if ((0xFFFF0000 & paramInt) != 0)
      throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
    super.startActivityForResult(paramIntent, (1 + paramFragment.mIndex << 16) + (0xFFFF & paramInt));
  }

  public void supportInvalidateOptionsMenu()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      ActivityCompatHoneycomb.invalidateOptionsMenu(this);
      return;
    }
    this.mOptionsMenuInvalidated = true;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.FragmentActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.6.1-SNAPSHOT
 */
