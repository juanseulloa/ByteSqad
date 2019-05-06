package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.facturacion.modelo.VentaDetalle;
import co.com.facturacion.modelo.VentaDetallePK;
import co.com.ustaempresarial.fachada.FacturacionFachada;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class FacturacionBean implements FacturacionFachada {

	@PersistenceContext(unitName = "facturacion")
	private EntityManager em;

	public FacturacionBean() {
		super();
	}

	@Override
	public List<CategoriaProducto> traerProductos() throws Exception {
		List<CategoriaProducto> categoriaProductos = new ArrayList<CategoriaProducto>();

		Query query = em.createNamedQuery(CategoriaProducto.FILL_ALL);

		categoriaProductos = query.getResultList();

		return categoriaProductos;
	}

	@Override
	public void crearCagtegoriaProducto(CategoriaProducto producto) throws Exception {
		if (producto.getNombre() != null && !producto.getNombre().equals("")) {
			em.persist(producto);
		}

	}

	@Override
	public CategoriaProducto editarCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception {
		CategoriaProducto producto = new CategoriaProducto();
		producto = buscarPorId(categoriaProducto.getCodigo());
		if (producto.getCodigo() > 0) {
			em.merge(categoriaProducto);
		} else
			producto = null;

		return producto;
	}

	@Override
	public boolean borrarCategoriaProducto(int codigo) throws Exception {
		CategoriaProducto categoriaProducto = buscarPorId(codigo);
		boolean retorno = false;
		if (categoriaProducto.getCodigo() > 0) {
			em.remove(categoriaProducto);
			retorno = true;
		}

		return retorno;
	}

	private CategoriaProducto buscarPorId(int codigoCategoria) throws Exception {
		CategoriaProducto p = new CategoriaProducto();
		p = em.find(CategoriaProducto.class, codigoCategoria);
		return p;
	}

	@Override
	public List<CategoriaProducto> buscarCategoriaPorNombre(String nombre) throws Exception {
		List<CategoriaProducto> catProd = new ArrayList<CategoriaProducto>();
		Query query = em.createNamedQuery(CategoriaProducto.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			catProd =query.getResultList();
		}
		return catProd;
	}

	@Override
	public VentaDetalle actualizarVentaDetalle(VentaDetalle detalle) throws Exception {
		VentaDetalle ventaDetalle = new VentaDetalle();
		ventaDetalle = em.find(VentaDetalle.class, detalle.getId());
		if(ventaDetalle.getId().getVentaCodigo()>0) {
			em.merge(detalle);
			ventaDetalle = detalle;
		}
		
		return ventaDetalle;
	}

	@Override
	public void crearVentaDetalle(VentaDetalle detalle) throws Exception {
		if (detalle.getId().getProductoCodigo()>0 && detalle.getId().getProveedorCodigo()>0
				&& detalle.getId().getVentaCodigo()>0) {
			em.persist(detalle);
		}
		
	}

	@Override
	public boolean borrarVentaDetalle(VentaDetallePK id) throws Exception {
		boolean venta=false;
		if(id.getProductoCodigo()>0 && id.getProveedorCodigo()>0&& id.getVentaCodigo()>0) {
			em.remove(buscarPorID(id));
			venta= true;
		}
		
		return venta;
	}
	
	private VentaDetalle buscarPorID(VentaDetallePK id) throws Exception{
		VentaDetalle ve = new VentaDetalle();
		ve = em.find(VentaDetalle.class, id);
		return ve;
	}

}
