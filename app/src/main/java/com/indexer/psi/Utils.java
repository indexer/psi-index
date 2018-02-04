package com.indexer.psi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.indexer.psi.model.Item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class Utils {


    private LinkedHashMap<String, AtomicReference<StringBuilder>> westlhm = new LinkedHashMap<>();

    public LinkedHashMap genereateSnippet(Item item) {

        AtomicReference<StringBuilder> mWestString;
        mWestString = new AtomicReference<>(new StringBuilder());
        AtomicReference<StringBuilder> mCentralString;
        mCentralString = new AtomicReference<>(new StringBuilder());
        AtomicReference<StringBuilder> mEastString;
        mEastString = new AtomicReference<>(new StringBuilder());
        AtomicReference<StringBuilder> mNorthString;
        mNorthString = new AtomicReference<>(new StringBuilder());
        AtomicReference<StringBuilder> southString;
        southString = new AtomicReference<>(new StringBuilder());
        AtomicReference<StringBuilder> nationalData;
        nationalData = new AtomicReference<>(new StringBuilder());

        Gson gson = new Gson();
        String reading = gson.toJson(item.getReadings());
        JsonElement json = gson.fromJson(reading, JsonElement.class);
        JsonObject jsonObj = json.getAsJsonObject();
        Set<Map.Entry<String, JsonElement>> entries = jsonObj.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {

            String west_data = entry.getKey() + " : " + entry.getValue().getAsJsonObject().get("west") + "\n";
            String central_data = entry.getKey() + " : " + entry.getValue().getAsJsonObject().get("central") + "\n";
            String east_data = entry.getKey() + " : " + entry.getValue().getAsJsonObject().get("east") + "\n";
            String north_data = entry.getKey() + " : " + entry.getValue().getAsJsonObject().get("north") + "\n";
            String south_data = entry.getKey() + " : " + entry.getValue().getAsJsonObject().get("south") + "\n";
            String national = entry.getKey() + " : " + entry.getValue().getAsJsonObject().get("national") + "\t";


            mWestString.get().append(west_data);
            mCentralString.get().append(central_data);
            mEastString.get().append(east_data);
            mNorthString.get().append(north_data);
            southString.get().append(south_data);
            nationalData.get().append(national);


        }
        westlhm.put("east", mEastString);
        westlhm.put("north", mNorthString);
        westlhm.put("south", southString);
        westlhm.put("central", mCentralString);
        westlhm.put("west", mWestString);
        westlhm.put("national", nationalData);

        return westlhm;
    }
}
