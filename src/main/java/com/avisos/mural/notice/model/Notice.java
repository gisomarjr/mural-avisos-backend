package com.avisos.mural.notice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TB001_AVISO")
public class Notice {
	
	@Id
	@SequenceGenerator(name = "SQ001_AVISO", sequenceName = "SQ001_AVISO")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ001_AVISO")
	@Column(name = "ID", insertable = false, nullable = false)
	private Long id;
	
	@NotNull
	@Column(name = "titulo", nullable = false, length = 250)
	@NotBlank(message = "Favor informar o título")
	private String title;
	
	@NotNull
	@Column(name = "descricao", nullable = false, length = 800)
	@NotBlank(message = "Favor informar a descrição")
	private String description;
	
	@Column(name = "publicacao", nullable = false, 
	columnDefinition = "DEFAULT CURRENT_TIMESTAMP",
	insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date publication;

	@Column(name = "visualizacao", nullable = true, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date visualization;

}
