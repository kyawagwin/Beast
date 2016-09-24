package com.passioncreativestudio.beast.infrastructure;

import android.app.Application;

import com.squareup.otto.Bus;

public class BeastApplication extends Application {
    private Bus bus;

    public Bus getBus() {
        return bus;
    }

    public BeastApplication() {
        this.bus = new Bus();
    }
}
