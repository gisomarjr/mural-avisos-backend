package com.avisos.mural.notice.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.avisos.mural.notice.model.Notice;

@RepositoryRestResource
public interface INoticeRepository extends PagingAndSortingRepository<Notice, Long> {

}
