package br.com.jrnin.celulas.cadastrocelulas;
import java.util.List;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import br.com.jrnin.celulas.usuario.Usuario;

public class CelulasDAOHibernate implements CelulasDAO{

	private Session session;
	public void setSession(Session session) {
		this.session = session;
	}
	public void excluir(Celulas celulas) {
		this.session.delete(celulas);
	}
	public void salvar(Celulas celulas) { 
		this.session.saveOrUpdate(celulas); 
	}
	public Celulas carregar(Integer celulas) {
		return (Celulas) this.session.get(Celulas.class, celulas);
	}
	public List<Celulas> listar(Usuario usuario) { 
		Criteria criteria = this.session.createCriteria(Celulas.class); 
		criteria.add(Restrictions.eq("usuario", usuario)); 
		return criteria.list();
	}
	public Celulas buscarFavorita(Usuario usuario) { 
		Criteria criteria = this.session.createCriteria(Celulas.class);
		criteria.add(Restrictions.eq("usuario", usuario));
		criteria.add(Restrictions.eq("favorita", true));
		return (Celulas) criteria.uniqueResult();	
	}
}