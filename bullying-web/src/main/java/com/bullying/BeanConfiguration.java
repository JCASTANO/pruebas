package com.bullying;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class BeanConfiguration {
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filterSecurity());
		registration.addUrlPatterns("/api/private/*");
		registration.setName("filterSecurity");
		registration.setOrder(1);
		return registration;
	}

	@Bean(name = "filterSecurity")
	public Filter filterSecurity() 
	{
		return new FilterSecurity();
	}
}
