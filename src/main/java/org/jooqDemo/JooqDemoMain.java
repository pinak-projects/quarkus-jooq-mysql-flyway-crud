package org.jooqDemo;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class JooqDemoMain {

    public static void main(String[] args) {
        Quarkus.run(args);
    }
}
