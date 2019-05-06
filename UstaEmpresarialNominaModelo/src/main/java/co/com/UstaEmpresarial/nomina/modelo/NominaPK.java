package co.com.UstaEmpresarial.nomina.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the nomina database table.
 * 
 */
@Embeddable
public class NominaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer contratoCod;
	private Integer conceptoCod;
	private Integer periodoCod;

	public NominaPK() {
	}

	@Column(name="contrato_cod", insertable=false, updatable=false)
	public Integer getContratoCod() {
		return this.contratoCod;
	}
	public void setContratoCod(Integer contratoCod) {
		this.contratoCod = contratoCod;
	}

	@Column(name="concepto_cod", insertable=false, updatable=false)
	public Integer getConceptoCod() {
		return this.conceptoCod;
	}
	public void setConceptoCod(Integer conceptoCod) {
		this.conceptoCod = conceptoCod;
	}

	@Column(name="periodo_cod", insertable=false, updatable=false)
	public Integer getPeriodoCod() {
		return this.periodoCod;
	}
	public void setPeriodoCod(Integer periodoCod) {
		this.periodoCod = periodoCod;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof NominaPK)) {
			return false;
		}
		NominaPK castOther = (NominaPK)other;
		return 
			this.contratoCod.equals(castOther.contratoCod)
			&& this.conceptoCod.equals(castOther.conceptoCod)
			&& this.periodoCod.equals(castOther.periodoCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.contratoCod.hashCode();
		hash = hash * prime + this.conceptoCod.hashCode();
		hash = hash * prime + this.periodoCod.hashCode();
		
		return hash;
	}
}