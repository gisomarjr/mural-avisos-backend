package com.avisos.mural.notice.handler;

import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.avisos.mural.notice.model.Notice;

@RepositoryEventHandler
public class NoticeEventHandler {

	@HandleBeforeSave
	public void handleNoticeSave(Notice notice) {
		// … you can now deal with Person in a type-safe way
	}
	
}
