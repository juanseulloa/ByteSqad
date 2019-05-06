package co.com.ustaempresarial.bean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.facturacion.modelo.UsuarioLogin;
import co.com.ustaempresarial.fachada.AutenticacionFachada;


@Stateless
@LocalBean
public class AutenticacionBean implements AutenticacionFachada{

	@PersistenceContext(unitName="facturacion")
	private EntityManager em;
	
	public AutenticacionBean() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * @see co.com.facturacion.fachada.AutenticacionFachada#consultarUsuario(java.lang.String, java.lang.String)
	 */
	@Override
	public UsuarioLogin consultarUsuario(String us, String clave) throws Exception {
		UsuarioLogin login = new UsuarioLogin();
		 Query q = em.createNamedQuery(UsuarioLogin.TRAER_USUARIO);
		 q.setParameter("usua", us);
		 q.setParameter("pass", clave);
		
		try {
			login = (UsuarioLogin) q.getSingleResult();
		} catch (NoResultException  e) {
			login = null;
		}
	
		return login;
	}

//	@Override
//	public List<OpcionesMenuUsuario> consultaPermisosOpcionesUser()
//			throws Exception {
//		return null;
//	}
//
//	@Override
//	public Funcionario consultarUsuario(String usuario) throws Exception {
//		List<Funcionario> listLog = new ArrayList<Funcionario>();
//		Funcionario user = new Funcionario();
//		Query q = em.createNamedQuery(Funcionario.USUARIO_PERMITIDO);
//		q.setParameter("user", usuario);
//		listLog = q.getResultList();
//		
//		if(listLog.size()>0){
//			for(Funcionario o : listLog){
//				user = new Funcionario();
//				user.setClave(o.getClave());
//				user.setEstadodel(o.getEstadodel());
//				user.setId(o.getId());
//				user.setIddependencia(o.getIddependencia());
//				user.setIdperfil(o.getIdperfil());
//				user.setIdpregunta(o.getIdpregunta());
//				user.setRespuesta(o.getRespuesta());
//				user.setUsuario(o.getUsuario());
//			}
//		}
//		
//		em.clear();
//		return user;
//	}

}
