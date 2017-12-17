package com.beshoy.development.features.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.concurrent.atomic.AtomicLong;

import butterknife.ButterKnife;
import com.beshoy.development.UFLAndroidTaskApp;
import com.beshoy.development.injection.component.ConfigPersistentComponent;
import com.beshoy.development.injection.component.DaggerConfigPersistentComponent;
import com.beshoy.development.injection.component.FragmentComponent;
import com.beshoy.development.injection.module.FragmentModule;
import timber.log.Timber;

/**
 * Abstract Fragment that every other Fragment in this application must implement. It handles
 * creation of Dagger components and makes sure that instances of ConfigPersistentComponent are kept
 * across configuration changes.
 */
public abstract class BaseFragment extends Fragment {

    private static final String KEY_FRAGMENT_ID = "KEY_FRAGMENT_ID";
    private static final LongSparseArray<ConfigPersistentComponent> componentsArray =
            new LongSparseArray<>();
    private static final AtomicLong NEXT_ID = new AtomicLong(0);

    private long fragmentId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create the FragmentComponent and reuses cached ConfigPersistentComponent if this is
        // being called after a configuration change.
        fragmentId =
                savedInstanceState != null
                        ? savedInstanceState.getLong(KEY_FRAGMENT_ID)
                        : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (componentsArray.get(fragmentId) == null) {
            Timber.i("Creating new ConfigPersistentComponent id=%d", fragmentId);
            configPersistentComponent =
                    DaggerConfigPersistentComponent.builder()
                            .appComponent(UFLAndroidTaskApp.get(getActivity()).getComponent())
                            .build();
            componentsArray.put(fragmentId, configPersistentComponent);
        } else {
            Timber.i("Reusing ConfigPersistentComponent id=%d", fragmentId);
            configPersistentComponent = componentsArray.get(fragmentId);
        }
        FragmentComponent fragmentComponent =
                configPersistentComponent.fragmentComponent(new FragmentModule(this));
        inject(fragmentComponent);
        attachView();
    }

    @Nullable
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView(savedInstanceState, getActivity());
    }

    protected abstract int getLayout();

    protected abstract void inject(FragmentComponent fragmentComponent);

    protected abstract void attachView();

    protected abstract void initView(@Nullable Bundle savedInstanceState, Activity activity);

    protected abstract void detachPresenter();

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_FRAGMENT_ID, fragmentId);
    }

    @Override
    public void onDestroy() {
        if (!getActivity().isChangingConfigurations()) {
            Timber.i("Clearing ConfigPersistentComponent id=%d", fragmentId);
            componentsArray.remove(fragmentId);
        }
        detachPresenter();
        super.onDestroy();
    }

    public void setupToolbar(Toolbar toolbar, AppCompatActivity activity, boolean enableBackArrow) {
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null && enableBackArrow) {
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

}
