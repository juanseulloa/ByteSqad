package co.com.UstaEmpresarial.familia.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the pariente database table.
 * 
 */
@Entity
@Table(name="pariente", schema="parientes")
public class Pariente implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String LISTAR_PARIENTES = "Pariente.LISTAR_PARIENTES";
	
	public static final String TRAER_PARIENTE_POR_CODIGO = "Pariente.TRAER_PARIENTE_POR_CODIGO";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;

	@Column(name="codigo_padre")
	private java.math.BigDecimal codigoPadre;

	private String genero;

	private String nombre;

	public Pariente() {
	}

	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public java.math.BigDecimal getCodigoPadre() {
		return this.codigoPadre;
	}

	public void setCodigoPadre(java.math.BigDecimal codigoPadre) {
		this.codigoPadre = codigoPadre;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}