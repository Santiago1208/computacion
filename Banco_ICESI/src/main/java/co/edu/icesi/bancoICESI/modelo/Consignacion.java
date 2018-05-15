package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the consignaciones database table.
 * 
 */
@Entity
@Table(name="consignaciones")
@NamedQuery(name="Consignacion.findAll", query="SELECT c FROM Consignacion c")
public class Consignacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConsignacionPK id;

	@Column(name="con_descripcion")
	private String conDescripcion;

	@Column(name="con_fecha")
	private Timestamp conFecha;

	@Column(name="con_habilitado")
	private String conHabilitado;

	@Column(name="con_valor")
	private BigDecimal conValor;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cue_numero")
	private Cuenta cuenta;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usu_cedula")
	private Usuario usuario;

	public Consignacion() {
	}

	public ConsignacionPK getId() {
		return this.id;
	}

	public void setId(ConsignacionPK id) {
		this.id = id;
	}

	public String getConDescripcion() {
		return this.conDescripcion;
	}

	public void setConDescripcion(String conDescripcion) {
		this.conDescripcion = conDescripcion;
	}

	public Timestamp getConFecha() {
		return this.conFecha;
	}

	public void setConFecha(Timestamp conFecha) {
		this.conFecha = conFecha;
	}

	public String getConHabilitado() {
		return this.conHabilitado;
	}

	public void setConHabilitado(String conHabilitado) {
		this.conHabilitado = conHabilitado;
	}

	public BigDecimal getConValor() {
		return this.conValor;
	}

	public void setConValor(BigDecimal conValor) {
		this.conValor = conValor;
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