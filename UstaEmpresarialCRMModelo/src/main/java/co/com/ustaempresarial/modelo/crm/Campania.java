package co.com.ustaempresarial.modelo.crm;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Campania {
    private int codigo;
    private String nombre;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private int periodoCod;
    private BigInteger valor;
    private boolean estado;
    private Periodo periodoByPeriodoCod;
    private Collection<Evento> eventosByCodigo;

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
    @Column(name = "fecha_inicio", nullable = false)
    public Date getFechaInicio() {

        return fechaInicio;

    }

    public void setFechaInicio(Date fechaInicio) {

        this.fechaInicio = fechaInicio;

    }

    @Basic
    @Column(name = "fecha_fin", nullable = false)
    public Date getFechaFin() {

        return fechaFin;

    }

    public void setFechaFin(Date fechaFin) {

        this.fechaFin = fechaFin;

    }

    @Basic
    @Column(name = "periodo_cod", nullable = false)
    public int getPeriodoCod() {

        return periodoCod;

    }

    public void setPeriodoCod(int periodoCod) {

        this.periodoCod = periodoCod;

    }

    @Basic
    @Column(name = "valor", nullable = false, precision = 0)
    public BigInteger getValor() {

        return valor;

    }

    public void setValor(BigInteger valor) {

        this.valor = valor;

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
        Campania campania = (Campania) o;
        return codigo == campania.codigo &&
                periodoCod == campania.periodoCod &&
                estado == campania.estado &&
                Objects.equals(nombre, campania.nombre) &&
                Objects.equals(descripcion, campania.descripcion) &&
                Objects.equals(fechaInicio, campania.fechaInicio) &&
                Objects.equals(fechaFin, campania.fechaFin) &&
                Objects.equals(valor, campania.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, descripcion, fechaInicio, fechaFin, periodoCod, valor, estado);
    }

    @ManyToOne
    @JoinColumn(name = "periodo_cod", referencedColumnName = "codigo", nullable = false)
    public Periodo getPeriodoByPeriodoCod() {

        return periodoByPeriodoCod;

    }

    public void setPeriodoByPeriodoCod(Periodo periodoByPeriodoCod) {

        this.periodoByPeriodoCod = periodoByPeriodoCod;

    }

    @OneToMany(mappedBy = "campaniaByCampaniaCod")
    public Collection<Evento> getEventosByCodigo() {

        return eventosByCodigo;

    }

    public void setEventosByCodigo(Collection<Evento> eventosByCodigo) {

        this.eventosByCodigo = eventosByCodigo;

    }
}
