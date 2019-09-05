package com.avisos.mural.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.avisos.mural.notice.handler.NoticeEventHandler;
import com.avisos.mural.notice.model.Notice;

/**
 * Create Repository specific for Event Handler
 * @author Gisomar Jr.
 *
 */
@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer  {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Notice.class);
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
	}

	@Bean
	NoticeEventHandler personEventHandler() {
		return new NoticeEventHandler();
	}
}
