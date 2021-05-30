package com.menora;


import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// Create Hashmap
// Bean is singelton
// HOLDER מחזיק את הDATA - הוא בעצם סוג של DB ומתווך בין הTaskSchedulerConfig לבין הקונטרולר
// TaskSchedulerConfig  - פעם בשעה כותב אל ההולדר
// Controller קורא נתונים בכל קריאה של REST מתוך ההולדר

@Component
public class Holder {
    Map<Long, RequestDetails> holderMap = new HashMap<>();


    public Map<Long, RequestDetails> getHolderMap() {
        return holderMap;
    }

    public void setHolderMap(Map<Long, RequestDetails> holderMap) {
        this.holderMap = holderMap;
    }
}
