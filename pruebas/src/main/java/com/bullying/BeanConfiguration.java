package com.bullying;

import javax.servlet.Filter;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bullying.security.FilterSecurity;

/**
 * 
 * @author juan.botero
 *
 */
@Configuration
class BeanConfiguration {
	private static final String FILTER_SECURITY = "filterSecurity";
	private static final String API_PRIVATE = "/api/private/*";

	/**
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(filterSecurity());
		registration.addUrlPatterns(API_PRIVATE);
		registration.setName(FILTER_SECURITY);
		registration.setOrder(1);
		return registration;
	}

	/**
	 * 
	 * @return
	 */
	@Bean(name = FILTER_SECURITY)
	public Filter filterSecurity() 
	{
		return new FilterSecurity();
	}
}
