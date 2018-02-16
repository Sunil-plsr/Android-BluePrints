package com.plsr.sunil.dagger.Model;

/**
 * Created by sunil on 2/15/18.
 */

public class Motor {

    private int rpm;

    public Motor() {
        this.rpm = 0;
    }

    public int getRpm() {
        return rpm;
    }

    public void accelerate(int speed) {
        rpm += speed;
    }

    public void brake() {
        rpm = 0;
    }
}
