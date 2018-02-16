package com.plsr.sunil.dagger.Component;

import com.plsr.sunil.dagger.Model.Vehicle;
import com.plsr.sunil.dagger.Module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sunil on 2/15/18.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();
    
}
