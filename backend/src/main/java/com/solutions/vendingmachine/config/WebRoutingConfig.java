package com.solutions.vendingmachine.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebRoutingConfig extends WebMvcConfigurerAdapter {

	/**
	 * This forwards all requests not handled otherwise to index.html.
	 * setOrder(Ordered.LOWEST_PRECEDENCE) is used to ensure, that this
	 * catch-all forwarding only applies after no other route has been found.
	 */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.LOWEST_PRECEDENCE);
        registry.addViewController("/**").setViewName("forward:/index.html");
    }

    /**
     * This allows front-end assets like images and styles to be found
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    	registry.addResourceHandler("/assets/**").addResourceLocations("/assets/");
    }
}
