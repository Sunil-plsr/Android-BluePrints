package com.plsr.sunil.dagger.Model;

import javax.inject.Inject;

/**
 * Created by sunil on 2/15/18.
 */

public class Vehicle {

    private Motor motor;

    @Inject
    public Vehicle(Motor motor) {
        this.motor = motor;
    }

    public void increaseSpeed(int speed) {
        motor.accelerate(speed);
    }

    public void stop() {
        motor.brake();
    }

    public int getSpeed() {
        return motor.getRpm();
    }
}
