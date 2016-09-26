package com.passioncreativestudio.beast.inmemory;

import com.passioncreativestudio.beast.entities.Brother;
import com.passioncreativestudio.beast.infrastructure.BeastApplication;
import com.passioncreativestudio.beast.services.BrotherServices;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class InMemoryBrotherServices extends BaseInMemory {
    public InMemoryBrotherServices(BeastApplication application) {
        super(application);
    }

    @Subscribe
    public void getBrothers(BrotherServices.SearchBrotherRequest request) {
        BrotherServices.SearchBrotherResponse response = new BrotherServices.SearchBrotherResponse();
        response.brothers = new ArrayList<>();

        for(int i = 0; i < 32; i++) {
            response.brothers.add(new Brother(
                    i,
                    "Brother " + i,
                    "Brother " + i + " joined for this reason",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Computer Science",
                    "Spring 2015",
                    "I love to code my heart out"));
        }

        bus.post(response);
    }
}
