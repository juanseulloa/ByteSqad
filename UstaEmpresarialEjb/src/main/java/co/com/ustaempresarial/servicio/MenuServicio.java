package co.com.ustaempresarial.servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import co.com.ustaempresarial.fachada.MenuFachada;

/**
 * Session Bean implementation class UserSerivcio
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MenuServicio{
	
	
	@EJB
	MenuFachada beanMenu;

    /**
     * Default constructor. 
     */
    public MenuServicio() {
        // TODO Auto-generated constructor stub
    }
    
//    public List<OpcionesMenuUsuario> consultarPermisos(String usuario) throws Exception{
//    	List<OpcionesMenuUsuario> menuUsuario = new ArrayList<OpcionesMenuUsuario>();
//    	menuUsuario = beanMenu.opcionesMenu(usuario);
//    	return menuUsuario;
//    }

}
