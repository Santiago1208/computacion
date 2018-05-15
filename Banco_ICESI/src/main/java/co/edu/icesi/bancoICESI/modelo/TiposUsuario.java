package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipos_usuarios database table.
 * 
 */
@Entity
@Table(name="tipos_usuarios")
@NamedQuery(name="TiposUsuario.findAll", query="SELECT t FROM TiposUsuario t")
public class TiposUsuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tusu_codigo")
	private long tusuCodigo;

	@Column(name="tusu_habilitado")
	private String tusuHabilitado;

	@Column(name="tusu_nombre")
	private String tusuNombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tiposUsuario")
	private Set<Usuario> usuarios;

	public TiposUsuario() {
	}

	public long getTusuCodigo() {
		return this.tusuCodigo;
	}

	public void setTusuCodigo(long tusuCodigo) {
		this.tusuCodigo = tusuCodigo;
	}

	public String getTusuHabilitado() {
		return this.tusuHabilitado;
	}

	public void setTusuHabilitado(String tusuHabilitado) {
		this.tusuHabilitado = tusuHabilitado;
	}

	public String getTusuNombre() {
		return this.tusuNombre;
	}

	public void setTusuNombre(String tusuNombre) {
		this.tusuNombre = tusuNombre;
	}

	public Set<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTiposUsuario(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTiposUsuario(null);

		return usuario;
	}

}