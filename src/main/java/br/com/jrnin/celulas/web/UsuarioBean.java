package br.com.jrnin.celulas.web;

import javax.faces.bean.*;
import br.com.jrnin.celulas.usuario.Usuario;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import br.com.jrnin.celulas.usuario.UsuarioRN;


@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	private Usuario usuario = new Usuario();
	private String confirmarSenha;

	public String novo() { 
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
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

		return "usuariosucesso"; 
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

}