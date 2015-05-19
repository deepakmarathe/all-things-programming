package com.deepakm.archaius.source;

import com.netflix.config.*;
import org.apache.commons.configuration.event.ConfigurationEvent;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.junit.Test;

public class InMemoryRandomServerSourceTest {
    @Test
    public void test1() throws InterruptedException {
        FixedDelayPollingScheduler schedular = new FixedDelayPollingScheduler(1000, 1000, true);

        PolledConfigurationSource source = new InMemoryRandomConfigSource();
        DynamicConfiguration myConf = new DynamicConfiguration(source, schedular);

        ConfigurationManager.install(myConf);

        myConf.addConfigurationListener(new ConfigurationListener() {
            public void configurationChanged(ConfigurationEvent configurationEvent) {
                System.out.println(configurationEvent.getPropertyName() + " changed to " + configurationEvent.getPropertyValue());
            }
        });

        Thread.sleep(1000000);
    }
}
