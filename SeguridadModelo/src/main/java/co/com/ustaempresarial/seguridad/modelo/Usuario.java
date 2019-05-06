package co.com.ustaempresarial.seguridad.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * The persistent class for the usuario database table.
 */
@Entity
//@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
@Table(name = "usuario", schema = "seguridad")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String TRAER_USUARIO = "Usuario.TRAER_USUARIO";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;

    private String email;

    @Column(name = "fecha_fin")
    private Timestamp fechaFin;

    @Column(name = "fecha_inicio")
    private Timestamp fechaInicio;

    private String nombre;

    private String password;

    private Integer tipo;

    public Usuario() {
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getFechaFin() {
        return this.fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Timestamp getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getTipo() {
        return this.tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

}