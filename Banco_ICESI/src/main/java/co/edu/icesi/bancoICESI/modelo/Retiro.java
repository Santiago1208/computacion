package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the retiros database table.
 * 
 */
@Entity
@Table(name="retiros")
@NamedQuery(name="Retiro.findAll", query="SELECT r FROM Retiro r")
public class Retiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RetiroPK id;

	@Column(name="ret_descripcion")
	private String retDescripcion;

	@Column(name="ret_fecha")
	private Timestamp retFecha;

	@Column(name="ret_habilitado")
	private String retHabilitado;

	@Column(name="ret_valor")
	private BigDecimal retValor;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cue_numero")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usu_cedula")
	private Usuario usuario;

	public Retiro() {
	}

	public RetiroPK getId() {
		return this.id;
	}

	public void setId(RetiroPK id) {
		this.id = id;
	}

	public String getRetDescripcion() {
		return this.retDescripcion;
	}

	public void setRetDescripcion(String retDescripcion) {
		this.retDescripcion = retDescripcion;
	}

	public Timestamp getRetFecha() {
		return this.retFecha;
	}

	public void setRetFecha(Timestamp retFecha) {
		this.retFecha = retFecha;
	}

	public String getRetHabilitado() {
		return this.retHabilitado;
	}

	public void setRetHabilitado(String retHabilitado) {
		this.retHabilitado = retHabilitado;
	}

	public BigDecimal getRetValor() {
		return this.retValor;
	}

	public void setRetValor(BigDecimal retValor) {
		this.retValor = retValor;
	}

	public Cuenta getCuenta() {
		return this.cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}