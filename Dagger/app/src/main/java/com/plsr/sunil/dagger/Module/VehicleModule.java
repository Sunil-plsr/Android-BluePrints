package com.plsr.sunil.dagger.Module;

import com.plsr.sunil.dagger.Model.Motor;
import com.plsr.sunil.dagger.Model.Vehicle;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sunil on 2/15/18.
 */

@Module
public class VehicleModule {

    /*every provider (or method) must have the @Provides annotation and the class must have the
    @Module annotation. The @Singleton annotation indicates that there will be only one instance of the object.*/

    @Provides @Singleton
    Motor provideMotor() {
        return new Motor();
    }

    @Provides @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor());
    }
}
