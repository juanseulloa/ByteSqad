package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import co.com.facturacion.modelo.CategoriaProducto;
import co.com.ustaempresarial.servicio.FacturacionServicio;

@ManagedBean(name="fact")
@SessionScoped
public class FactutacionControl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Properties prop = new Properties();
	private String user;
	private String nombreCategoria;
	private boolean verPanel;
	private boolean dialogCategoria;
	private boolean dialogCategoriaNuevo;
	private List<CategoriaProducto> categoriaProductos;
	private CategoriaProducto categoriaProductoEdit;
	private CategoriaProducto categoriaProductoNuevo;
	
	
	@EJB
	FacturacionServicio facturacionServicio;
	
	public FactutacionControl() {
		super();
		cargarPropiedades();
		
	}

	/**
	 * metodo especializado en inicializar variables
	 */
	public void cargarPropiedades() {
		prop = new Properties();
		try {
			nombreCategoria = null;
			verPanel = false;
			dialogCategoria = false;
			dialogCategoriaNuevo = false;
			categoriaProductos = new ArrayList<CategoriaProducto>();
			categoriaProductoEdit = new CategoriaProducto();
			categoriaProductoNuevo = new CategoriaProducto();
			prop.load(FactutacionControl.class.getResourceAsStream("mensajes.properties"));
			user = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("app.user.name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void cargarPermisos() {
		try {
			categoriaProductos = facturacionServicio.traerProductos();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}


	public void buscarPoNombre(){
		try {
			if(nombreCategoria!=null && !nombreCategoria.equals("")) {
				categoriaProductos = facturacionServicio.buscarPorNombre(nombreCategoria);
				if(categoriaProductos.size()>0) {
					verPanel = true;
				}
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", prop.getProperty("errorDatosBusqueda")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void crearCategoria() {
		try {
			if(categoriaProductoNuevo.getCodigo()>0) {
				dialogCategoria=false;
				facturacionServicio.crearCagtegoriaProducto(categoriaProductoNuevo);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", prop.getProperty("exitoGuardado")));
			}
			
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", prop.getProperty("erroProceso")));
		}
	}
	
	public void verEditarCategoria(CategoriaProducto categoriaProductoSeleccion){
		if(categoriaProductoSeleccion.getCodigo()>0) {
				categoriaProductoEdit = new CategoriaProducto();
				categoriaProductoEdit = categoriaProductoSeleccion;
				dialogCategoria = true;
				dialogCategoriaNuevo = false;
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", prop.getProperty("errorDatosBusqueda")));		
		}
	}
	
	public void editarCategoria() {
		try {
			if(categoriaProductoEdit.getCodigo()>0) {
				categoriaProductoEdit = facturacionServicio.editarCategoriaProducto(categoriaProductoEdit);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", prop.getProperty("exitoGuardado")));
				dialogCategoria = false;
			}else {
				dialogCategoria = false;
			}
		} catch (Exception e) {
			dialogCategoria = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", prop.getProperty("errorDatosBusqueda")));
		}
	}
	
	public void borrarCategoria(CategoriaProducto categoriaProductoSeleccion) {
		try {
			boolean borro = false;
			if(categoriaProductoSeleccion.getCodigo()>0) {
				borro = facturacionServicio.borrarCategoriaProducto(categoriaProductoSeleccion.getCodigo());
				if(borro) {
					categoriaProductos = facturacionServicio.traerProductos();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "", prop.getProperty("exitoElimino")));
				}
				
			}else {
				dialogCategoria = false;
			}
		} catch (Exception e) {
			dialogCategoria = false;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", prop.getProperty("errorDatosBusqueda")));
		}
	}
	
	public void cerrarDialogo() {
		categoriaProductoEdit = new CategoriaProducto();
		dialogCategoria = false;
	}
	
	public void abrirNuevo() {
		categoriaProductoNuevo = new CategoriaProducto();
		dialogCategoriaNuevo = true;
	}
	
	public void cerrarNuevo() {
		categoriaProductoNuevo = new CategoriaProducto();
		dialogCategoriaNuevo = false;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public boolean isVerPanel() {
		return verPanel;
	}

	public void setVerPanel(boolean verPanel) {
		this.verPanel = verPanel;
	}

	public List<CategoriaProducto> getCategoriaProductos() {
		return categoriaProductos;
	}

	public void setCategoriaProductos(List<CategoriaProducto> categoriaProductos) {
		this.categoriaProductos = categoriaProductos;
	}

	public boolean isDialogCategoria() {
		return dialogCategoria;
	}

	public void setDialogCategoria(boolean dialogCategoria) {
		this.dialogCategoria = dialogCategoria;
	}

	public CategoriaProducto getCategoriaProductoEdit() {
		return categoriaProductoEdit;
	}

	public void setCategoriaProductoEdit(CategoriaProducto categoriaProductoEdit) {
		this.categoriaProductoEdit = categoriaProductoEdit;
	}

	public CategoriaProducto getCategoriaProductoNuevo() {
		return categoriaProductoNuevo;
	}

	public void setCategoriaProductoNuevo(CategoriaProducto categoriaProductoNuevo) {
		this.categoriaProductoNuevo = categoriaProductoNuevo;
	}

	public FacturacionServicio getFacturacionServicio() {
		return facturacionServicio;
	}

	public void setFacturacionServicio(FacturacionServicio facturacionServicio) {
		this.facturacionServicio = facturacionServicio;
	}

	public boolean isDialogCategoriaNuevo() {
		return dialogCategoriaNuevo;
	}

	public void setDialogCategoriaNuevo(boolean dialogCategoriaNuevo) {
		this.dialogCategoriaNuevo = dialogCategoriaNuevo;
	}
	
}
