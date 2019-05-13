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
import co.com.ustaempresarial.fachada.SeguridadFachada;
import co.com.ustaempresarial.seguridad.modelo.Permiso;
import co.com.ustaempresarial.seguridad.modelo.Rol;
import co.com.ustaempresarial.seguridad.modelo.Usuario;
import co.com.ustaempresarial.seguridad.modelo.UsuarioLog;


@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class SeguridadBean implements SeguridadFachada{
	@PersistenceContext(unitName = "ustaEmpresarialEjb")
	private EntityManager em;
	
	public SeguridadBean() {
		super();
	}

	@Override
	public List<Usuario> traerUsuarios() throws Exception {
		List<Usuario> users=new ArrayList<Usuario>();
		
		Query query = em.createNamedQuery(Usuario.FIND_ALL);
		users=query.getResultList();
		return users;
	}

	@Override
	public void crearUsuario(Usuario user) throws Exception {
		if (user.getNombre() != null && !user.getNombre().equals("")) {
			em.persist(user);
		}
	}

	@Override
	public Usuario editarUsuario(Usuario user) throws Exception {
		Usuario usuario = new Usuario();
		usuario = buscarPorId(user.getCodigo());
		if (usuario.getCodigo() > 0) {
			em.merge(user);
		} else
			usuario = null;

		return usuario;
	}

	@Override
	public boolean borrarUsuario(int codigo) throws Exception {
		Usuario user = buscarPorId(codigo);
		boolean retorno = false;
		if (user.getCodigo() > 0) {
			em.remove(user);
			retorno = true;
		}

		return retorno;
	}
	
	private Usuario buscarPorId(int codigoUser) throws Exception {
		Usuario u = new Usuario();
		u = em.find(Usuario.class, codigoUser);
		return u;
	}


	@Override
	public List<Usuario> buscarUsuarioPorNombre(String nombre) throws Exception {
		List<Usuario> usuario = new ArrayList<>();
		Query query = em.createNamedQuery(Usuario.ENCONTRAR_POR_NOMBRE);
		if (nombre != null) {
			query.setParameter("nombre", nombre);
			 usuario=query.getResultList();
		}
		return usuario;
		
	}
	//****************************************Usuariolog******************************************
		@Override
		public List<UsuarioLog> listarUsuarioLog() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void crearUsuarioLog(UsuarioLog usuarioLog) throws Exception {		
				if(usuarioLog.getProceso() != null && !usuarioLog.getProceso().equals("")) {
					em.persist(usuarioLog);
				}
			// TODO Auto-generated method stub
			
		}

		@Override
		public UsuarioLog editarUsuarioLog(UsuarioLog usuarioLog) throws Exception {
		      UsuarioLog objUsuarioLog;
		      objUsuarioLog =new UsuarioLog();
		      if(usuarioLog != null) {
		    	  objUsuarioLog = buscarUsuarioLog(usuarioLog.getCodigo());
		    	  em.merge(usuarioLog);
		      }else {
		    	  usuarioLog = null;
		      }
				// TODO Auto-generated method stub
				
			return null;
		}

		@Override
		public boolean eliminarUsuarioLog(int codigo) throws Exception {
			UsuarioLog objUsuarioLog;
			objUsuarioLog = new UsuarioLog();
			boolean retorno;
			objUsuarioLog = buscarUsuarioLog(codigo);
			retorno = false;
			if(objUsuarioLog.getCodigo()>0) {
				em.remove(objUsuarioLog);
				retorno= true;
			}
			return retorno;
		}

		@Override
		public UsuarioLog buscarUsuarioLog(int codigo) throws Exception {
			UsuarioLog objUsuarioLog;
			objUsuarioLog = new UsuarioLog();
			objUsuarioLog = em.find(UsuarioLog.class, codigo);
			// TODO Auto-generated method stub
			return objUsuarioLog;
		}
		
	//*************************************************************************************************
		//************************************Rol*****************************************************
		@Override
		public List<Rol> listarRol() throws Exception {
			List<Rol> rolList;
			Query q;
			
			rolList = new ArrayList<Rol>();
			
			return null;
		}

		@Override
		public void crearRol(Rol rol) throws Exception {
			if (rol.getNombre() != null && !rol.getNombre().equals("")) {
				if (rol.getDescripcion() != null && !rol.getDescripcion().equals("")) {
					em.persist(rol);
				}
			} else {

			}

		}

		@Override
		public Rol editarRol(Rol rol) throws Exception {
			Rol objRol;
			objRol = new Rol();
			if (objRol != null) {
				objRol = buscarRol(objRol.getCodigo());
				em.merge(objRol);
			} else {
			 objRol = null;	
			}

			return objRol;
		}

		@Override
		public boolean eliminarRol(int codigo) throws Exception {
			Rol objRol;
			boolean retorno;
			
			objRol = buscarRol(codigo);
			retorno = false;
			if (objRol.getCodigo() > 0) {
				em.remove(objRol);
				retorno = true;
			}
			return retorno;
		}

		@Override
		public Rol buscarRol(int codigo) throws Exception {
			Rol objRol;
			objRol = new Rol();
			objRol = em.find(Rol.class, codigo);
			return objRol;

		}

	//********************************************************************************************
		//**************************************Permiso****************************************************
		@Override
		public List<Permiso> listarPermiso() throws Exception {
			List<Permiso> rolList;
			Query q;

			rolList = new ArrayList<Permiso>();

			return null;
		}

		@Override
		public void crearPermiso(Permiso permiso) throws Exception {
			if (permiso.getNombre() != null && !permiso.getNombre().equals("")) {
				if (permiso.getDescripcion() != null && !permiso.getDescripcion().equals("")) {
					em.persist(permiso);
				}
			}

		}

		@Override
		public Permiso editarPermiso(Permiso permiso) throws Exception {
			Permiso objPermiso;
			objPermiso = new Permiso();
			if (objPermiso != null) {
				objPermiso = buscarPermiso(objPermiso.getCodigo());
				em.merge(objPermiso);
			} else {
				objPermiso = null;
			}

			return objPermiso;
		}

		@Override
		public boolean eliminarPermiso(int codigo) throws Exception {
			Permiso objPermiso;
			boolean retorno;

			objPermiso = buscarPermiso(codigo);
			retorno = false;
			if (objPermiso.getCodigo() > 0) {
				em.remove(objPermiso);
				retorno = true;
			}
			return retorno;
		}

		@Override
		public Permiso buscarPermiso(int codigo) throws Exception {
			Permiso objPermiso;
			objPermiso = new Permiso();
			objPermiso = em.find(Permiso.class, codigo);
			return objPermiso;
		}
	//*********************************************************************************************	
		
}
