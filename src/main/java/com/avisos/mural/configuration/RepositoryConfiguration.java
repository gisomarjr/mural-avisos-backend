package com.avisos.mural.configuration;

import org.springframework.context.annotation.Bean;

import com.avisos.mural.notice.handler.NoticeEventHandler;

/**
 * Create Repository specific for Event Handler
 * @author Gisomar Jr.
 *
 */
public class RepositoryConfiguration {

	@Bean
	NoticeEventHandler personEventHandler() {
		return new NoticeEventHandler();
	}
}
