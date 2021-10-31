package com.mapswithme.maps.help;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.mapswithme.maps.base.BaseToolbarActivity;

public class HelpActivity extends BaseToolbarActivity
{
  @Nullable
  private String mLastTitle;

  @Override
  protected Class<? extends Fragment> getFragmentClass()
  {
    return HelpFragment.class;
  }

  public void replaceFragment(@NonNull Class<? extends Fragment> fragmentClass,
                              @Nullable String title, @Nullable Bundle args)
  {
    final int resId = getFragmentContentResId();
    if (resId <= 0 || findViewById(resId) == null)
      throw new IllegalStateException("Fragment can't be added, since getFragmentContentResId() " +
          "isn't implemented or returns wrong resourceId.");

    String name = fragmentClass.getName();
    final Fragment fragment = Fragment.instantiate(this, name, args);
    getSupportFragmentManager().beginTransaction()
        .replace(resId, fragment, name)
        .addToBackStack(null)
        .commitAllowingStateLoss();
    getSupportFragmentManager().executePendingTransactions();

    if (title != null)
    {
      Toolbar toolbar = getToolbar();
      if (toolbar != null && toolbar.getTitle() != null)
      {
        mLastTitle = toolbar.getTitle().toString();
        toolbar.setTitle(title);
      }
    }
  }

  @Override
  public void onBackPressed()
  {
    if (mLastTitle != null)
      getToolbar().setTitle(mLastTitle);

    super.onBackPressed();
  }
}