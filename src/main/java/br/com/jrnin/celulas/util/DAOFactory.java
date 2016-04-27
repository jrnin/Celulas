package br.com.jrnin.celulas.util;
import br.com.jrnin.celulas.cadastrocelulas.CelulasDAO;
import br.com.jrnin.celulas.cadastrocelulas.CelulasDAOHibernate;
import br.com.jrnin.celulas.usuario.UsuarioDAO;
import br.com.jrnin.celulas.usuario.UsuarioDAOHibernate;
public class DAOFactory {

	public static UsuarioDAO criarUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
		usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAO; 
	}
	
	public static CelulasDAO criarCelulasDAO() { 
		CelulasDAOHibernate celulasDAO = new CelulasDAOHibernate();
		celulasDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return celulasDAO;
	}

}
