package co.edu.icesi.bancoICESI.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the tipos_documentos database table.
 * 
 */
@Entity
@Table(name="tipos_documentos")
@NamedQuery(name="TiposDocumento.findAll", query="SELECT t FROM TiposDocumento t")
public class TiposDocumento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="tdoc_codigo")
	private long tdocCodigo;

	@Column(name="tdoc_habilitado")
	private String tdocHabilitado;

	@Column(name="tdoc_nombre")
	private String tdocNombre;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tiposDocumento")
	private Set<Cliente> clientes;

	public TiposDocumento() {
	}

	public long getTdocCodigo() {
		return this.tdocCodigo;
	}

	public void setTdocCodigo(long tdocCodigo) {
		this.tdocCodigo = tdocCodigo;
	}

	public String getTdocHabilitado() {
		return this.tdocHabilitado;
	}

	public void setTdocHabilitado(String tdocHabilitado) {
		this.tdocHabilitado = tdocHabilitado;
	}

	public String getTdocNombre() {
		return this.tdocNombre;
	}

	public void setTdocNombre(String tdocNombre) {
		this.tdocNombre = tdocNombre;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setTiposDocumento(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setTiposDocumento(null);

		return cliente;
	}

}