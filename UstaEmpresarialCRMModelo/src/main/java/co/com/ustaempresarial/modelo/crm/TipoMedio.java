package co.com.ustaempresarial.modelo.crm;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_medio", schema = "crm", catalog = "usta_empresarial")
public class TipoMedio {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int valorProm;
    private boolean estado;
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
    @Column(name = "descripcion", nullable = false, length = 200)
    public String getDescripcion() {

        return descripcion;

    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;

    }

    @Basic
    @Column(name = "valor_prom", nullable = false)
    public int getValorProm() {

        return valorProm;

    }

    public void setValorProm(int valorProm) {

        this.valorProm = valorProm;

    }

    @Basic
    @Column(name = "estado", nullable = false)
    public boolean isEstado() {

        return estado;

    }

    public void setEstado(boolean estado) {

        this.estado = estado;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoMedio tipoMedio = (TipoMedio) o;
        return codigo == tipoMedio.codigo &&
                valorProm == tipoMedio.valorProm &&
                estado == tipoMedio.estado &&
                Objects.equals(nombre, tipoMedio.nombre) &&
                Objects.equals(descripcion, tipoMedio.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, descripcion, valorProm, estado);
    }

    @OneToMany(mappedBy = "tipoMedioByTipoMedioCod")
    public Collection<Medio> getMediosByCodigo() {

        return mediosByCodigo;

    }

    public void setMediosByCodigo(Collection<Medio> mediosByCodigo) {

        this.mediosByCodigo = mediosByCodigo;

    }
}
