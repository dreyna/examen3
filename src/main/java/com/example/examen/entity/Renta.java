package com.example.examen.entity;

import java.util.Calendar;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="TBL_RENTA")
public class Renta {
	@Id
	@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRentas")
    @SequenceGenerator(name = "seqRentas", allocationSize = 1, sequenceName = "SEQ_RENTAS")
    private Long id=0L;

	@Column(name = "FECHA_DATE", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
    private Calendar registerDate;
	
	@Column(name = "FECHA_DEVOLUCION")
	@JsonFormat(pattern = "dd-MM-yyyy")
    private Date fechaDevolucion;
	
	@Column(name = "FECHAENTREGA", updatable = false, nullable = false)
	@Temporal(TemporalType.DATE)
    private Date fechaEnrega;
	
	@ManyToOne
	@JoinColumn(name = "PELICULA_ID", nullable = false)
	private Pelicula pelicula;	
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_ID", nullable = false)
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "USUARIO_ID", nullable = false)
	private Usuario usuario;
	
	
}
