package co.com.ustaempresarial.finanzas.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the plan_contable database table.
 * 
 */
@Entity
@Table(name="plan_contable", schema="\"FINANZAS\"")
public class PlanContable implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name="codigo_padre")
	private Integer codigoPadre;

	private String descripcion;

	private String nombre;

	private Integer tipo;

	@Temporal(TemporalType.DATE)
	private Date vigencia;

	public PlanContable() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigoPadre() {
		return this.codigoPadre;
	}

	public void setCodigoPadre(Integer codigoPadre) {
		this.codigoPadre = codigoPadre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipo() {
		return this.tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Date getVigencia() {
		return this.vigencia;
	}

	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}

}