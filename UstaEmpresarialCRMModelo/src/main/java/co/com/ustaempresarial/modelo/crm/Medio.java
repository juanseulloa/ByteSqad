package co.com.ustaempresarial.modelo.crm;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Objects;

@Entity
public class Medio {
    private int codigo;
    private String nombre;
    private String descripcion;
    private int tipoMedioCod;
    private int eventoCod;
    private int recursoCod;
    private BigInteger valor;
    private boolean estado;
    private TipoMedio tipoMedioByTipoMedioCod;
    private Evento eventoByEventoCod;
    private Recurso recursoByRecursoCod;

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
    @Column(name = "tipo_medio_cod", nullable = false)
    public int getTipoMedioCod() {

        return tipoMedioCod;

    }

    public void setTipoMedioCod(int tipoMedioCod) {

        this.tipoMedioCod = tipoMedioCod;

    }

    @Basic
    @Column(name = "evento_cod", nullable = false)
    public int getEventoCod() {

        return eventoCod;

    }

    public void setEventoCod(int eventoCod) {

        this.eventoCod = eventoCod;

    }

    @Basic
    @Column(name = "recurso_cod", nullable = false)
    public int getRecursoCod() {

        return recursoCod;

    }

    public void setRecursoCod(int recursoCod) {

        this.recursoCod = recursoCod;

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
        Medio medio = (Medio) o;
        return codigo == medio.codigo &&
                tipoMedioCod == medio.tipoMedioCod &&
                eventoCod == medio.eventoCod &&
                recursoCod == medio.recursoCod &&
                estado == medio.estado &&
                Objects.equals(nombre, medio.nombre) &&
                Objects.equals(descripcion, medio.descripcion) &&
                Objects.equals(valor, medio.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, descripcion, tipoMedioCod, eventoCod, recursoCod, valor, estado);
    }

    @ManyToOne
    @JoinColumn(name = "tipo_medio_cod", referencedColumnName = "codigo", nullable = false)
    public TipoMedio getTipoMedioByTipoMedioCod() {

        return tipoMedioByTipoMedioCod;

    }

    public void setTipoMedioByTipoMedioCod(TipoMedio tipoMedioByTipoMedioCod) {

        this.tipoMedioByTipoMedioCod = tipoMedioByTipoMedioCod;

    }

    @ManyToOne
    @JoinColumn(name = "evento_cod", referencedColumnName = "codigo", nullable = false)
    public Evento getEventoByEventoCod() {

        return eventoByEventoCod;

    }

    public void setEventoByEventoCod(Evento eventoByEventoCod) {

        this.eventoByEventoCod = eventoByEventoCod;

    }

    @ManyToOne
    @JoinColumn(name = "recurso_cod", referencedColumnName = "codigo", nullable = false)
    public Recurso getRecursoByRecursoCod() {

        return recursoByRecursoCod;

    }

    public void setRecursoByRecursoCod(Recurso recursoByRecursoCod) {

        this.recursoByRecursoCod = recursoByRecursoCod;

    }
}
