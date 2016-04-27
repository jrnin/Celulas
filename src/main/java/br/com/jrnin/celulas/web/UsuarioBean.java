package br.com.jrnin.celulas.web;

import java.util.List;
import javax.faces.bean.*;
import br.com.jrnin.celulas.usuario.Usuario;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import br.com.jrnin.celulas.usuario.UsuarioRN;
import br.com.jrnin.celulas.cadastrocelulas.Celulas;
import br.com.jrnin.celulas.cadastrocelulas.CelulasRN;


@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private List<Usuario> lista;
	private String destinoSalvar;
	private Celulas celulas = new Celulas();

	public String novo() { 
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario"; 
	}
	public String editar() {
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}
	public String salvar() { 
		FacesContext context = FacesContext.getCurrentInstance();

		String senha = this.usuario.getSenha();
		if (!senha.equals(this.confirmarSenha)) { 
			FacesMessage facesMessage = new FacesMessage("A senha n�o foi confirmada corretamente");
			context.addMessage(null, facesMessage);
			return null; 
		}

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario); 
		
		if (this.celulas.getObservacao() != null) { 
			this.celulas.setUsuario(this.usuario); 
			//this.celulas.setFavorita(true); 
			CelulasRN celulasRN = new CelulasRN();
			celulasRN.salvar(this.celulas);
		}

		return this.destinoSalvar;
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}
	public String atribuiPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		java.util.Set<String> permissoes = this.usuario.getPermissao();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}
	public Celulas getCelulas() {
		return celulas;
	}

	public void setCelulas(Celulas celulas) {
		this.celulas = celulas;
	}

}
