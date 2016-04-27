package br.com.jrnin.celulas.cadastrocelulas;

import java.util.Date;
import java.util.List;
import br.com.jrnin.celulas.usuario.Usuario;
import br.com.jrnin.celulas.util.DAOFactory;

public class CelulasRN {
	private CelulasDAO celulasDAO;

	public CelulasRN() {
		this.celulasDAO = DAOFactory.criarCelulasDAO();
	}

	public List<Celulas> listar(Usuario usuario) {
		return this.celulasDAO.listar(usuario);
	}

	public Celulas carregar(Integer celulas) {
		return this.celulasDAO.carregar(celulas);
	}

	public void salvar(Celulas celulas) {
		celulas.setDataCelula(new Date());
		this.celulasDAO.salvar(celulas);
	}

	public void excluir(Celulas celulas) {
		this.celulasDAO.excluir(celulas);
	}

//	public void tornarFavorita(Celulas celulasFavorita) {
	//	Celulas conta = this.buscarFavorita(celulasFavorita.getUsuario());
	//	if (celulas != null) {
	//		celulas.setFavorita(false);
	//		this.celulasDAO.salvar(conta);
	//	}
	//	contaFavorita.setFavorita(true);
	//	this.contaDAO.salvar(contaFavorita);
//	}

//	public Conta buscarFavorita(Usuario usuario) {
	//	return this.contaDAO.buscarFavorita(usuario);
//	}
}
