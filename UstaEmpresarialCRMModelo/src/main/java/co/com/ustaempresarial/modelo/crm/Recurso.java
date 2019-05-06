package co.com.ustaempresarial.modelo.crm;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Recurso {
    private int codigo;
    private String nombre;
    private int tipo;
    private String descripcion;
    private BigInteger valor;
    private Collection<Medio> mediosByCodigo;

    @Id
    @Column(name = "codigo", nullable = false)
    public int getCodigo() {

        return codigo;

    }

    public void setCodigo(int codigo) {

        this.codigo = codigo;

    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 200)
    public String getNombre() {

        return nombre;

    }

    public void setNombre(String nombre) {

        this.nombre = nombre;

    }

    @Basic
    @Column(name = "tipo", nullable = false)
    public int getTipo() {

        return tipo;

    }

    public void setTipo(int tipo) {

        this.tipo = tipo;

    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 200)
    public String getDescripcion() {

        return descripcion;

    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }

    @Basic
    @Column(name = "valor", nullable = false, precision = 0)
    public BigInteger getValor() {

        return valor;

    }

    public void setValor(BigInteger valor) {

        this.valor = valor;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recurso recurso = (Recurso) o;
        return codigo == recurso.codigo &&
                tipo == recurso.tipo &&
                Objects.equals(nombre, recurso.nombre) &&
                Objects.equals(descripcion, recurso.descripcion) &&
                Objects.equals(valor, recurso.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, tipo, descripcion, valor);
    }

    @OneToMany(mappedBy = "recursoByRecursoCod")
    public Collection<Medio> getMediosByCodigo() {

        return mediosByCodigo;

    }

    public void setMediosByCodigo(Collection<Medio> mediosByCodigo) {

        this.mediosByCodigo = mediosByCodigo;

    }
}
