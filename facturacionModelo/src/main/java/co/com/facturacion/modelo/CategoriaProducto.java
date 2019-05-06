package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the categoria_producto database table.
 * 
 */
@Entity
@Table(name="categoria_producto",schema="facturacion")
public class CategoriaProducto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String ENCONTRAR_POR_NOMBRE="CategoriaProducto.ENCONTRAR_POR_NOMBRE";
	
	public static final String FILL_ALL = "CategoriaProducto.findAll";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"CODIGO\"")
	private Integer codigo;

	@Column(name="\"CARACTERISTICA\"")
	private String caracteristica;

	@Column(name="\"NOMBRE\"")
	private String nombre;

	public CategoriaProducto() {
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(String caracteristica) {
		this.caracteristica = caracteristica;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}