package co.com.ustaempresarial.servicio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.fachada.FacturacionFachada;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class FacturacionServicio {
	
	@EJB
	FacturacionFachada fachada;
	
	public List<CategoriaProducto> buscarPorNombre(String nombre) throws Exception{
		return fachada.buscarCategoriaPorNombre(nombre);
	}
	
	
	public CategoriaProducto editarCategoriaProducto(CategoriaProducto categoriaProducto) throws Exception {
		return fachada.editarCategoriaProducto(categoriaProducto);
	}
	
	public boolean borrarCategoriaProducto(int codigo) throws Exception {
		return fachada.borrarCategoriaProducto(codigo);
	}
	
	public List<CategoriaProducto> traerProductos() throws Exception {
		return fachada.traerProductos();
	}
	
	public void crearCagtegoriaProducto(CategoriaProducto producto) throws Exception {
		fachada.crearCagtegoriaProducto(producto);
	}
}
