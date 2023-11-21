package com.example.examen.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="TBL_GENERO")
public class Genero {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGenero")
    @SequenceGenerator(name = "seqGenero", allocationSize = 1, sequenceName = "SEQ_GENERO")
    private Long id;
	@Column(name="NOMBRE")
	@NotNull @NotBlank
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private GeneroStatus status;
	
	@OneToMany(cascade = CascadeType.ALL, fetch= FetchType.LAZY, mappedBy = "genero")
	@JsonIgnore
	private Set<Pelicula> peliculas;

	public static enum GeneroStatus{
		ENABLE, DISABLE
	}
}
