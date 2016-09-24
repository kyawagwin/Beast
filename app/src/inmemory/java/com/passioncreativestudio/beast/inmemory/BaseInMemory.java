package com.passioncreativestudio.beast.inmemory;

import com.passioncreativestudio.beast.infrastructure.BeastApplication;
import com.squareup.otto.Bus;

public class BaseInMemory {
    protected final Bus bus;
    protected final BeastApplication application;

    public BaseInMemory(BeastApplication application) {
        this.application = application;

        this.bus = application.getBus();
        bus.register(this);
    }
}
