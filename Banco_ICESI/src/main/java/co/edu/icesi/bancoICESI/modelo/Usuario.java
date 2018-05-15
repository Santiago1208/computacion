package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the usuarios database table.
 * 
 */
@Entity
@Table(name="usuarios")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usu_cedula")
	private long usuCedula;

	@Column(name="usu_clave")
	private String usuClave;

	@Column(name="usu_habilitado")
	private String usuHabilitado;

	@Column(name="usu_login")
	private String usuLogin;

	@Column(name="usu_nombre")
	private String usuNombre;

	//bi-directional many-to-one association to Consignacion
	@OneToMany(mappedBy="usuario")
	private Set<Consignacion> consignaciones;

	//bi-directional many-to-one association to Retiro
	@OneToMany(mappedBy="usuario")
	private Set<Retiro> retiros;

	//bi-directional many-to-one association to Transferencia
	@OneToMany(mappedBy="usuario")
	private Set<Transferencia> transferencias;

	//bi-directional many-to-one association to TiposUsuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tusu_codigo")
	private TiposUsuario tiposUsuario;

	public Usuario() {
	}

	public long getUsuCedula() {
		return this.usuCedula;
	}

	public void setUsuCedula(long usuCedula) {
		this.usuCedula = usuCedula;
	}

	public String getUsuClave() {
		return this.usuClave;
	}

	public void setUsuClave(String usuClave) {
		this.usuClave = usuClave;
	}

	public String getUsuHabilitado() {
		return this.usuHabilitado;
	}

	public void setUsuHabilitado(String usuHabilitado) {
		this.usuHabilitado = usuHabilitado;
	}

	public String getUsuLogin() {
		return this.usuLogin;
	}

	public void setUsuLogin(String usuLogin) {
		this.usuLogin = usuLogin;
	}

	public String getUsuNombre() {
		return this.usuNombre;
	}

	public void setUsuNombre(String usuNombre) {
		this.usuNombre = usuNombre;
	}

	public Set<Consignacion> getConsignaciones() {
		return this.consignaciones;
	}

	public void setConsignaciones(Set<Consignacion> consignaciones) {
		this.consignaciones = consignaciones;
	}

	public Consignacion addConsignacione(Consignacion consignacione) {
		getConsignaciones().add(consignacione);
		consignacione.setUsuario(this);

		return consignacione;
	}

	public Consignacion removeConsignacione(Consignacion consignacione) {
		getConsignaciones().remove(consignacione);
		consignacione.setUsuario(null);

		return consignacione;
	}

	public Set<Retiro> getRetiros() {
		return this.retiros;
	}

	public void setRetiros(Set<Retiro> retiros) {
		this.retiros = retiros;
	}

	public Retiro addRetiro(Retiro retiro) {
		getRetiros().add(retiro);
		retiro.setUsuario(this);

		return retiro;
	}

	public Retiro removeRetiro(Retiro retiro) {
		getRetiros().remove(retiro);
		retiro.setUsuario(null);

		return retiro;
	}

	public Set<Transferencia> getTransferencias() {
		return this.transferencias;
	}

	public void setTransferencias(Set<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

	public Transferencia addTransferencia(Transferencia transferencia) {
		getTransferencias().add(transferencia);
		transferencia.setUsuario(this);

		return transferencia;
	}

	public Transferencia removeTransferencia(Transferencia transferencia) {
		getTransferencias().remove(transferencia);
		transferencia.setUsuario(null);

		return transferencia;
	}

	public TiposUsuario getTiposUsuario() {
		return this.tiposUsuario;
	}

	public void setTiposUsuario(TiposUsuario tiposUsuario) {
		this.tiposUsuario = tiposUsuario;
	}

}