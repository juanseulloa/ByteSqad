package co.com.ustaempresarial.finanzas.modelo;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the libro_mayor database table.
 * 
 */
@Embeddable
public class LibroMayorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="plan_contable_cod", insertable=false, updatable=false)
	private Integer planContableCod;

	@Column(name="periodo_cod", insertable=false, updatable=false)
	private Integer periodoCod;

	public LibroMayorPK() {
	}
	public Integer getPlanContableCod() {
		return this.planContableCod;
	}
	public void setPlanContableCod(Integer planContableCod) {
		this.planContableCod = planContableCod;
	}
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
		if (!(other instanceof LibroMayorPK)) {
			return false;
		}
		LibroMayorPK castOther = (LibroMayorPK)other;
		return 
			this.planContableCod.equals(castOther.planContableCod)
			&& this.periodoCod.equals(castOther.periodoCod);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.planContableCod.hashCode();
		hash = hash * prime + this.periodoCod.hashCode();
		
		return hash;
	}
}