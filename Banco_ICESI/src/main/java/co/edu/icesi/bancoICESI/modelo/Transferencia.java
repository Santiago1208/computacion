package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * The persistent class for the transferencias database table.
 * 
 */
@Entity
@Table(name="transferencias")
@NamedQuery(name="Transferencia.findAll", query="SELECT t FROM Transferencia t")
public class Transferencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="transf_codigo")
	private long transfCodigo;

	@Column(name="transf_descripcion")
	private String transfDescripcion;

	@Column(name="transf_fecha")
	private Timestamp transfFecha;

	@Column(name="transf_habilitado")
	private String transfHabilitado;

	@Column(name="transf_monto")
	private BigDecimal transfMonto;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transf_cue_origen")
	private Cuenta cuenta1;

	//bi-directional many-to-one association to Cuenta
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="transf_cue_destino")
	private Cuenta cuenta2;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usu_cedula")
	private Usuario usuario;

	public Transferencia() {
	}

	public long getTransfCodigo() {
		return this.transfCodigo;
	}

	public void setTransfCodigo(long transfCodigo) {
		this.transfCodigo = transfCodigo;
	}

	public String getTransfDescripcion() {
		return this.transfDescripcion;
	}

	public void setTransfDescripcion(String transfDescripcion) {
		this.transfDescripcion = transfDescripcion;
	}

	public Timestamp getTransfFecha() {
		return this.transfFecha;
	}

	public void setTransfFecha(Timestamp transfFecha) {
		this.transfFecha = transfFecha;
	}

	public String getTransfHabilitado() {
		return this.transfHabilitado;
	}

	public void setTransfHabilitado(String transfHabilitado) {
		this.transfHabilitado = transfHabilitado;
	}

	public BigDecimal getTransfMonto() {
		return this.transfMonto;
	}

	public void setTransfMonto(BigDecimal transfMonto) {
		this.transfMonto = transfMonto;
	}

	public Cuenta getCuenta1() {
		return this.cuenta1;
	}

	public void setCuenta1(Cuenta cuenta1) {
		this.cuenta1 = cuenta1;
	}

	public Cuenta getCuenta2() {
		return this.cuenta2;
	}

	public void setCuenta2(Cuenta cuenta2) {
		this.cuenta2 = cuenta2;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}