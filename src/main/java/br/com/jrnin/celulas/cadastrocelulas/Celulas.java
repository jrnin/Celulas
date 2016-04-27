package br.com.jrnin.celulas.cadastrocelulas;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.jrnin.celulas.usuario.Usuario;

@Entity
public class Celulas implements Serializable {

	@Id
	@GeneratedValue
	private Integer celulas;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(nullable = false)
	private Usuario usuario;

	private String nome;
	private String bairro;
	private String nomelider;
	private Date dataCelula;
	private String horario;
	private String anfitriao;
	private String local;
	private String observacao;
	@Column(nullable = false, updatable = false)
//	private Date dataCadastro;
	//private float saldoInicial;
	//private boolean favorita;
	
	public Integer getCelulas() {
		return celulas;
	}

	public void setCelulas(Integer celulas) {
		this.celulas = celulas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getNomelider() {
		return nomelider;
	}

	public void setNomelider(String nomelider) {
		this.nomelider = nomelider;
	}

	public Date getDataCelula() {
		return dataCelula;
	}

	public void setDataCelula(Date dataCelula) {
		this.dataCelula = dataCelula;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getAnfitriao() {
		return anfitriao;
	}

	public void setAnfitriao(String anfitriao) {
		this.anfitriao = anfitriao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celulas == null) ? 0 : celulas.hashCode());
		result = prime * result
				+ ((dataCelula == null) ? 0 : dataCelula.hashCode());
		result = prime * result
				+ ((observacao == null) ? 0 : observacao.hashCode());
		//result = prime * result + (favorita ? 1231 : 1237);
		//result = prime * result + Float.floatToIntBits(saldoInicial);
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Celulas other = (Celulas) obj;
		if (celulas == null) {
			if (other.celulas != null)
				return false;
		} else if (!celulas.equals(other.celulas))
			return false;
		if (dataCelula == null) {
			if (other.dataCelula != null)
				return false;
		} else if (!dataCelula.equals(other.dataCelula))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
	//	if (favorita != other.favorita)
	//		return false;
	//	if (Float.floatToIntBits(saldoInicial) != Float
	//			.floatToIntBits(other.saldoInicial))
	//		return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
