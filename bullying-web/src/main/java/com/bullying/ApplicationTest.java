package com.bullying;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
 * @project bullying-web
 * @class ApplicationTest
 * @since Aug 11, 2016
 *
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.bullying.service", "com.bullying.repository" })
@EntityScan(basePackages = {"com.bullying.model"})
public class ApplicationTest {

}
