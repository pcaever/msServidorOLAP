package com.everis.msServidorOLAP.dal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sieca.Demo_TablaAdjuntos")
public class Adjuntos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "AdjuntoID")
	private Integer adjuntoId;

	@CreationTimestamp
	@Column(name = "fechaCreacion", updatable = false)
	private Date fechaCreacion;

	@UpdateTimestamp
	@Column(name = "fechaActualizacion")
	private Date fechaActualizacion;

	@Column(name = "usuarioCrea", updatable = false)
	private Integer usuarioCrea;

	@Column(name = "usuarioActualiza")
	private Integer usuarioActualiza;
}
