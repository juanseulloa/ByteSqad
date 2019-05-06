package co.com.ustaempresarial.modelo.crm;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Evento {
    private int codigo;
    private String nombre;
    private String descripcion;
    private Date fecha;
    private int campaniaCod;
    private boolean estado;
    private Campania campaniaByCampaniaCod;
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
    @Column(name = "fecha", nullable = false)
    public Date getFecha() {

        return fecha;

    }

    public void setFecha(Date fecha) {

        this.fecha = fecha;

    }

    @Basic
    @Column(name = "campania_cod", nullable = false)
    public int getCampaniaCod() {

        return campaniaCod;

    }

    public void setCampaniaCod(int campaniaCod) {

        this.campaniaCod = campaniaCod;

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
        Evento evento = (Evento) o;
        return codigo == evento.codigo &&
                campaniaCod == evento.campaniaCod &&
                estado == evento.estado &&
                Objects.equals(nombre, evento.nombre) &&
                Objects.equals(descripcion, evento.descripcion) &&
                Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, descripcion, fecha, campaniaCod, estado);
    }

    @ManyToOne
    @JoinColumn(name = "campania_cod", referencedColumnName = "codigo", nullable = false)
    public Campania getCampaniaByCampaniaCod() {

        return campaniaByCampaniaCod;

    }

    public void setCampaniaByCampaniaCod(Campania campaniaByCampaniaCod) {

        this.campaniaByCampaniaCod = campaniaByCampaniaCod;

    }

    @OneToMany(mappedBy = "eventoByEventoCod")
    public Collection<Medio> getMediosByCodigo() {

        return mediosByCodigo;

    }

    public void setMediosByCodigo(Collection<Medio> mediosByCodigo) {

        this.mediosByCodigo = mediosByCodigo;

    }
}
