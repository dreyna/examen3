package com.example.examen.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name="TBL_ACCESOS")
public class Acceso {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAccesos")
    @SequenceGenerator(name = "seqAccesos", allocationSize = 1, sequenceName = "SEQ_ACCESO")
    private Long id;
	@Column(name = "TITULO")
	@NotNull @NotBlank  
    private String titulo;
	@Column(name = "ICONO")
    private String icono;
	@Column(name = "URL")
	@NotNull @NotBlank  
    private String url;
	@Column(name = "ESTADO")
	@NotBlank    
    private char estado;
	@ManyToMany(
			cascade=CascadeType.ALL
	)
	@JoinTable(
	  name = "TBL_ACCESO_ROL", 
	  joinColumns = @JoinColumn(name = "ACCESO_ID", referencedColumnName = "ID"), 
	  inverseJoinColumns = @JoinColumn(name = "ROL_ID", referencedColumnName = "ID")
	 )
	private Set<Rol> roles;
}
