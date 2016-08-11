package com.bullying;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.bullying.service", "com.bullying.repository" })
@EntityScan(basePackages = {"com.bullying.model"})
public class ApplicationTest {

}
