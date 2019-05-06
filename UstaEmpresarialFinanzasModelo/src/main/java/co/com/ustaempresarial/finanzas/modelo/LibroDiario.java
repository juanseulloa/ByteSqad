package co.com.ustaempresarial.finanzas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the libro_diario database table.
 * 
 */
@Entity
@Table(name="libro_diario", schema="\"FINANZAS\"")
public class LibroDiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer asiento;

	@Column(name="concepto_cod")
	private Integer conceptoCod;

	private Boolean estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="periodo_cod")
	private Integer periodoCod;

	private BigDecimal valor;

	public LibroDiario() {
	}

	public Integer getAsiento() {
		return this.asiento;
	}

	public void setAsiento(Integer asiento) {
		this.asiento = asiento;
	}

	public Integer getConceptoCod() {
		return this.conceptoCod;
	}

	public void setConceptoCod(Integer conceptoCod) {
		this.conceptoCod = conceptoCod;
	}

	public Boolean getEstado() {
		return this.estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getPeriodoCod() {
		return this.periodoCod;
	}

	public void setPeriodoCod(Integer periodoCod) {
		this.periodoCod = periodoCod;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}