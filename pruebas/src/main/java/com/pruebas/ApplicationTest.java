package com.pruebas;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author <a href="mailto:estebancastanorincon@gmail.com">Juan Esteban Castano</a>
 * @project pruebas
 * @class ApplicationTest
 * @since Aug 11, 2016
 *
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.pruebas.service", "com.pruebas.repository" })
@EntityScan(basePackages = {"com.pruebas.model"})
public class ApplicationTest {

}
