/*
 * (C) Copyright 2018 BMC Software, Inc.
 * The source code embodied herein is a trade secret of BMC Software, Inc.
 * All use, disclosure, and/or reproduction not specifically and expressly
 * authorized, in writing, by BMC Software, Inc. is prohibited.
 */

package com.derive.real.time.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("com.derive.real.time.location")
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
