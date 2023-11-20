package com.example.examen.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="TBL_PELICULA")
public class Pelicula {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPeliculas")
    @SequenceGenerator(name = "seqPeliculas", allocationSize = 1, sequenceName = "SEQ_PELICULAS")
    private Long id=0L;
	@Column(name = "NOMBRE")
	@NotNull @NotBlank    
    private String nombre;
	@Column(name = "DESCRIPCION")
	@NotNull @NotBlank    
    private String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "GENERO_ID", nullable = false)
	private Genero genero;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "pelicula")
	@JsonIgnore
	private Set<Renta> rentas;
}
