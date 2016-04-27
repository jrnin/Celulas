package br.com.jrnin.celulas.web;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import br.com.jrnin.celulas.cadastrocelulas.*;
import br.com.jrnin.celulas.usuario.*;

@ManagedBean
@SessionScoped
public class ContextoBean implements Serializable { 

	private static final long serialVersionUID = -2071855184464371947L; 
	private int codigoCelulasAtiva = 0;

	public Usuario getUsuarioLogado() { 
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser(); 
		if (login != null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			return usuarioRN.buscarPorLogin(login);
		}
		return null;
	}

	public Celulas getCelulasAtiva() {
		Celulas celulasAtiva = null;
		if (this.codigoCelulasAtiva == 0) {
			celulasAtiva = this.getCelulasAtivaPadrao();
		} else {
			CelulasRN celulasRN = new CelulasRN();
			celulasAtiva = celulasRN.carregar(this.codigoCelulasAtiva);
		}
		if (celulasAtiva != null) {
			this.codigoCelulasAtiva = celulasAtiva.getCelulas();
			return celulasAtiva;	
		}
		return null;
	}
	
	private Celulas getCelulasAtivaPadrao() {
		CelulasRN celulasRN = new CelulasRN();
		Celulas celulasAtiva = null;
		Usuario usuario = this.getUsuarioLogado();
	//	contaAtiva = celulasRN.buscarFavorita(usuario);
		if (celulasAtiva == null) {
			List<Celulas> celulas = celulasRN.listar(usuario);
			if (celulas != null && celulas.size() > 0) {
				celulasAtiva = celulas.get(0);
			}
		}
		return celulasAtiva;
	}

	public void changeCelulasAtiva(ValueChangeEvent event) { 
		this.codigoCelulasAtiva = (Integer) event.getNewValue();
	}
}
