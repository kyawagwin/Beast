package com.passioncreativestudio.beast.inmemory;

import com.passioncreativestudio.beast.infrastructure.BeastApplication;

public class Module {
    public static void Register(BeastApplication application) {
        new InMemoryBrotherServices(application);
    }
}
