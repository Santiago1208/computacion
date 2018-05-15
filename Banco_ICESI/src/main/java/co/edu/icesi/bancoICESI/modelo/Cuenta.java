package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;


/**
 * The persistent class for the cuentas database table.
 * 
 */
@Entity
@Table(name="cuentas")
@NamedQuery(name="Cuenta.findAll", query="SELECT c FROM Cuenta c")
public class Cuenta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cue_numero")
	private String cueNumero;

	@Column(name="cue_activa")
	private String cueActiva;

	@Column(name="cue_clave")
	private String cueClave;

	@Column(name="cue_saldo")
	private BigDecimal cueSaldo;

	//bi-directional many-to-one association to Consignacion
	@OneToMany(mappedBy="cuenta")
	private Set<Consignacion> consignaciones;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cli_id")
	private Cliente cliente;

	//bi-directional many-to-one association to Retiro
	@OneToMany(mappedBy="cuenta")
	private Set<Retiro> retiros;

	//bi-directional many-to-one association to Transferencia
	@OneToMany(mappedBy="cuenta1")
	private Set<Transferencia> transferencias1;

	//bi-directional many-to-one association to Transferencia
	@OneToMany(mappedBy="cuenta2")
	private Set<Transferencia> transferencias2;

	public Cuenta() {
	}

	public String getCueNumero() {
		return this.cueNumero;
	}

	public void setCueNumero(String cueNumero) {
		this.cueNumero = cueNumero;
	}

	public String getCueActiva() {
		return this.cueActiva;
	}

	public void setCueActiva(String cueActiva) {
		this.cueActiva = cueActiva;
	}

	public String getCueClave() {
		return this.cueClave;
	}

	public void setCueClave(String cueClave) {
		this.cueClave = cueClave;
	}

	public BigDecimal getCueSaldo() {
		return this.cueSaldo;
	}

	public void setCueSaldo(BigDecimal cueSaldo) {
		this.cueSaldo = cueSaldo;
	}

	public Set<Consignacion> getConsignaciones() {
		return this.consignaciones;
	}

	public void setConsignaciones(Set<Consignacion> consignaciones) {
		this.consignaciones = consignaciones;
	}

	public Consignacion addConsignacione(Consignacion consignacione) {
		getConsignaciones().add(consignacione);
		consignacione.setCuenta(this);

		return consignacione;
	}

	public Consignacion removeConsignacione(Consignacion consignacione) {
		getConsignaciones().remove(consignacione);
		consignacione.setCuenta(null);

		return consignacione;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<Retiro> getRetiros() {
		return this.retiros;
	}

	public void setRetiros(Set<Retiro> retiros) {
		this.retiros = retiros;
	}

	public Retiro addRetiro(Retiro retiro) {
		getRetiros().add(retiro);
		retiro.setCuenta(this);

		return retiro;
	}

	public Retiro removeRetiro(Retiro retiro) {
		getRetiros().remove(retiro);
		retiro.setCuenta(null);

		return retiro;
	}

	public Set<Transferencia> getTransferencias1() {
		return this.transferencias1;
	}

	public void setTransferencias1(Set<Transferencia> transferencias1) {
		this.transferencias1 = transferencias1;
	}

	public Transferencia addTransferencias1(Transferencia transferencias1) {
		getTransferencias1().add(transferencias1);
		transferencias1.setCuenta1(this);

		return transferencias1;
	}

	public Transferencia removeTransferencias1(Transferencia transferencias1) {
		getTransferencias1().remove(transferencias1);
		transferencias1.setCuenta1(null);

		return transferencias1;
	}

	public Set<Transferencia> getTransferencias2() {
		return this.transferencias2;
	}

	public void setTransferencias2(Set<Transferencia> transferencias2) {
		this.transferencias2 = transferencias2;
	}

	public Transferencia addTransferencias2(Transferencia transferencias2) {
		getTransferencias2().add(transferencias2);
		transferencias2.setCuenta2(this);

		return transferencias2;
	}

	public Transferencia removeTransferencias2(Transferencia transferencias2) {
		getTransferencias2().remove(transferencias2);
		transferencias2.setCuenta2(null);

		return transferencias2;
	}

}