package com.allere.sample.properties;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by G_dragon on 2017/3/1.
 */
public class FileLoader {

    private Properties properties = new Properties();

    public  void loadProperties() throws IOException {
        properties.load(ClassLoader.getSystemResourceAsStream("benchmark.properties"));
    }


}
