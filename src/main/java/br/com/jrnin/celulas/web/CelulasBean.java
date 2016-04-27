package br.com.jrnin.celulas.web;

import java.util.List;

import javax.faces.bean.*;
import br.com.jrnin.celulas.cadastrocelulas.Celulas;
import br.com.jrnin.celulas.cadastrocelulas.CelulasRN;

@ManagedBean
@RequestScoped
public class CelulasBean {
	private Celulas selecionada = new Celulas();
	private List<Celulas> lista = null;
	@ManagedProperty(value = "#{contextoBean}")
	private ContextoBean contextoBean;

	public String salvar() {
		this.selecionada.setUsuario(this.contextoBean.getUsuarioLogado());
		CelulasRN celulasRN = new CelulasRN();
		celulasRN.salvar(this.selecionada);
		this.selecionada = new Celulas();
		this.lista = null;
		return null;
	}

	public String excluir() {
		CelulasRN celulasRN = new CelulasRN();
		celulasRN.excluir(this.selecionada);
		this.selecionada = new Celulas();
		this.lista = null;
		return null;
	}

	/*public String tornarFavorita() {
		CelulasRN celulasRN = new CelulasRN();
		celulasRN.tornarFavorita(this.selecionada);
		this.selecionada = new Celulas();
		return null;
	}*/

	public Celulas getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Celulas selecionada) {
		this.selecionada = selecionada;
	}

	public List<Celulas> getLista() {
		if (this.lista == null) {
			CelulasRN celulasRN = new CelulasRN();
			this.lista = celulasRN.listar(this.contextoBean.getUsuarioLogado());
		}
		return this.lista;

	}

	public void setLista(List<Celulas> lista) {
		this.lista = lista;
	}

	public ContextoBean getContextoBean() {
		return contextoBean;
	}

	public void setContextoBean(ContextoBean contextoBean) {
		this.contextoBean = contextoBean;
	}

}
