package com.example.examen.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
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
@Table(name="TBL_EMPLEADOS")
public class Empleado {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmpleados")
    @SequenceGenerator(name = "seqEmpleados", allocationSize = 1, sequenceName = "SEQ_EMPLEADOS")
    @Builder.Default
    private Long id=0L;
	@Column(name = "NOMBRES")
	@NotNull @NotBlank    
    private String nombres;
	@Column(name = "APELLIDOS")
	@NotNull @NotBlank    
    private String apellidos;
	@Column(name = "DOCUMENTO")
	@NotNull @NotBlank    
    private Integer documento;
	@Column(name = "TELEFONO")
	@NotNull @NotBlank    
    private Integer telefono;
	@Column(name = "CORREO")
	@NotNull @NotBlank    
    private String correo;
	@Column(name = "ESTADO")
	@NotBlank    
    private char estado;
	
	@OneToOne(mappedBy = "empleado")
    private Usuario usuario;
}
