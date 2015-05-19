package com.deepakm.archaius.source;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.netflix.config.*;

import java.util.Map;
import java.util.Random;

/**
 * Created by dmarathe on 4/29/15.
 */
public class InMemoryRandomConfigSource implements PolledConfigurationSource {

    private final Map<String, Object> source;
    private final Random random;
    private final int LIMIT = 10;

    public InMemoryRandomConfigSource() {
        source = Maps.newHashMap();
        random = new Random();
    }

    public PollResult poll(boolean b, Object o) throws Exception {

        ImmutableMap<String, Object> addMap = null;
        ImmutableMap<String, Object> changeMap = null, deleteMap = null;

        if (b == true) {
            addMap = ImmutableMap.of(String.valueOf(random.nextInt(100)), (Object) Long.valueOf(random.nextInt()));
            source.putAll(addMap);
        } else {
            if (source.keySet().size() > 1) {

                //change
                int index = random.nextInt(source.keySet().size());
                String updateKey = (String) source.keySet().toArray()[index];
                source.put(updateKey, random.nextInt());
                changeMap = ImmutableMap.of(updateKey, (Object) source.get(updateKey));

                //delete
                String deleteKey = (String) source.keySet().toArray()[random.nextInt(source.keySet().size())];
                Object value = source.remove(deleteKey);
                deleteMap = ImmutableMap.of(deleteKey, value);

                //add
                String addKey = String.valueOf(random.nextInt(100));
                Object addValue = String.valueOf(random.nextInt());
                source.put(addKey, addValue);
                addMap = ImmutableMap.of(addKey, addValue);
            }
        }
        PollResult result = PollResult.createIncremental(addMap, changeMap, deleteMap, o);
        return result;
    }

}
