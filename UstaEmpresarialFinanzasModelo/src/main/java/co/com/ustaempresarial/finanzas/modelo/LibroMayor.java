package co.com.ustaempresarial.finanzas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the libro_mayor database table.
 * 
 */
@Entity
@Table(name="libro_mayor", schema="\"FINANZAS\"")
public class LibroMayor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private LibroMayorPK id;

	private BigDecimal debe;

	private Boolean estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal haber;

	public LibroMayor() {
	}

	public LibroMayorPK getId() {
		return this.id;
	}

	public void setId(LibroMayorPK id) {
		this.id = id;
	}

	public BigDecimal getDebe() {
		return this.debe;
	}

	public void setDebe(BigDecimal debe) {
		this.debe = debe;
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

	public BigDecimal getHaber() {
		return this.haber;
	}

	public void setHaber(BigDecimal haber) {
		this.haber = haber;
	}

}