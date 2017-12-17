package com.beshoy.development.injection.component;

import dagger.Subcomponent;
import com.beshoy.development.injection.PerFragment;
import com.beshoy.development.injection.module.FragmentModule;

/**
 * This component inject dependencies to all Fragments across the application
 */
@PerFragment
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
}
