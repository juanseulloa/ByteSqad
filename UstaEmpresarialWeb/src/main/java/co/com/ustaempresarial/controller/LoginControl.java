package co.com.ustaempresarial.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TreeSet;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import co.com.facturacion.modelo.UsuarioLogin;
import co.com.ustaempresarial.servicio.AutenticacionServicio;



@ManagedBean(name="log")
@SessionScoped
@SuppressWarnings(value = { "all" })
public class LoginControl implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
//	@EJB 
//	private MenuServicio servicio;
	
	@EJB
	private AutenticacionServicio autenticacionServicio;

	public static final String AUTH_KEY="app.user.name";
	public static final String USERS="app.user";
	public String cadena="cadena del login control";
	Properties prop;
	private String user;
	private String pass;
	private boolean show=false;
	
	public LoginControl(){
		prop=new Properties();
		try {
			//prop.load(LoginControl.class.getResourceAsStream("ldap2.properties"));
			prop.load(LoginControl.class.getResourceAsStream("mensajes.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String accessCheck(){
		String login=null;
		UsuarioLogin usuarioLogin = new UsuarioLogin();
		if(user!=null && !user.equals("")) {
			String usaux= (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(AUTH_KEY);
			if(usaux==null||usaux.compareTo("")==0){
				try {
					usuarioLogin = autenticacionServicio.consultarUsuario(user, pass);
					if(usuarioLogin!=null) {
						FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(AUTH_KEY,user);
						login="/pages/comun/principal.faces";
					}
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("usarioVencido")));
					login="/login/loginFail";
				}
				
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("usarioVencido")));
				login="/login/loginFail";
			}
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",prop.getProperty("usarioVencido")));
		}
		
		return login;
	}
	
	public String metodo(){
		System.out.println("llega hasta el metodo------->");
		return "/login/login.faces";
		//return "/pages/empresas.faces";
	}
	
	public void closeDlg(){
		show=false;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isShow() {
		return show;
	}
}
