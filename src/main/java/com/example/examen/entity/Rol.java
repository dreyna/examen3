package com.example.examen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="TBL_ROLES")
public class Rol {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRoles")
    @SequenceGenerator(name = "seqRoles", allocationSize = 1, sequenceName = "SEQ_ROLES")
    @Builder.Default
    private Long id=0L;
	@Column(name = "NOMBRE")
	@NotNull @NotBlank  
    private String nombre;
	@Column(name = "ESTADO")
	@NotBlank    
    private boolean estado;
}
