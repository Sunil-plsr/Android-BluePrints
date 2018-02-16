package com.plsr.sunil.dagger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.plsr.sunil.dagger.Component.DaggerVehicleComponent;
import com.plsr.sunil.dagger.Component.VehicleComponent;
import com.plsr.sunil.dagger.Model.Vehicle;
import com.plsr.sunil.dagger.Module.VehicleModule;

public class MainActivity extends AppCompatActivity {

    private Vehicle vehicle;

//    https://code.tutsplus.com/tutorials/dependency-injection-with-dagger-2-on-android--cms-23345


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
        vehicle = component.provideVehicle();

        /*Line 24,25 are the result of the dependency injection instead of the below code.
        *
        * vehicle = new Vehicle(new Motor());
        *
        * As we can observe, by using Dependency Injection we eliminate the need to create a dependent
        * object 'Motor' in this case.
        *
        * This may seem like a Large fix for small problem, but remember when the project size increases
        * the number of dependent objects we need to create increases and in a large project to create
        * a new object we may have to write over 50 lines of code for dependencies. Dagger eliminates that
        * */

        Toast.makeText(this, vehicle.getSpeed(), Toast.LENGTH_SHORT).show();


    }
}
