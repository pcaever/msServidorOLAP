package com.everis.msServidorOLAP.dal.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@DynamicUpdate
@Table(name = "sieca.Demo_TablaPrincipal")
public class Principal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "direccion")
	private String direccion;

	@Column(name = "telefono")
	private String telefono;

	@Column(name = "observaciones")
	private String observaciones;

	@Column(name = "PaisID")
	private Integer paisId;
	
	@Column(name = "activo")
	private boolean activo;

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "Demo_TablaPrincipalID", nullable = false, updatable = false)
	private List<Adjuntos> adjuntos;
}
