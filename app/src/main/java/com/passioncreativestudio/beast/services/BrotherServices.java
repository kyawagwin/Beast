package com.passioncreativestudio.beast.services;


import com.passioncreativestudio.beast.entities.Brother;

import java.util.List;

public class BrotherServices {
    public BrotherServices () {

    }

    public static class SearchBrotherRequest {
        public String firebaseUrl;

        public SearchBrotherRequest(String firebaseUrl) {
            this.firebaseUrl = firebaseUrl;
        }
    }

    public static class SearchBrotherResponse {
        public List<Brother> brothers;
    }
}
