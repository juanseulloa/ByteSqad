package co.com.facturacion.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the producto database table.
 * 
 */
@Entity
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="\"CODIGO\"")
	private Integer codigo;

	@Column(name="\"CARACTERISTICA\"")
	private String caracteristica;

	@Column(name="\"CATE_PROD_CODIGO\"")
	private Integer cateProdCodigo;

	@Column(name="\"NOMBRE\"")
	private String nombre;

	public Producto() {
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

	public Integer getCateProdCodigo() {
		return this.cateProdCodigo;
	}

	public void setCateProdCodigo(Integer cateProdCodigo) {
		this.cateProdCodigo = cateProdCodigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}