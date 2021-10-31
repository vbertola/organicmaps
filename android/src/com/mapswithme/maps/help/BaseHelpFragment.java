package com.mapswithme.maps.help;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;

import com.mapswithme.maps.base.BaseMwmFragment;

public abstract class BaseHelpFragment extends BaseMwmFragment
{
  protected abstract @LayoutRes int getLayoutRes();

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
  {
    return inflater.inflate(getLayoutRes(), container, false);
  }

  protected HelpActivity getHelpActivity()
  {
      return (HelpActivity) getActivity();
  }
}
