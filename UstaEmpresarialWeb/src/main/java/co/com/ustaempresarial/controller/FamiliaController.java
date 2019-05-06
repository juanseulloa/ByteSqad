package co.com.ustaempresarial.controller;

import java.io.IOException;
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

import co.com.UstaEmpresarial.familia.modelo.Pariente;
import co.com.ustaempresarial.servicio.FamiliaService;

@ManagedBean(name="familia")
@SessionScoped
public class FamiliaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Properties prop;
	private String user;
	private List<Pariente> listParientes;
	
	@EJB
	private FamiliaService familiaService;

	public FamiliaController() {
		super();
		cargarPropiedades();
	}
	
	public void cargarPropiedades() {
		try {
			this.prop = new Properties();
			this.listParientes = new ArrayList<Pariente>();
			prop.load(FactutacionControl.class.getResourceAsStream("mensajes.properties"));
			user = ((String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("app.user.name"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostConstruct
	public void cargarListas() {
		try {
			listParientes = familiaService.listarParienes();
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "ERROR CARGA", prop.getProperty("")));
		}
	}

	public List<Pariente> getListParientes() {
		return listParientes;
	}

	public void setListParientes(List<Pariente> listParientes) {
		this.listParientes = listParientes;
	}
	
	
	
	

}
