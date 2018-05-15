package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.TiposDocumento;

public interface ITiposDocumentoDAO {
	
	public void save(TiposDocumento tipoDocumento);
	
	public void update(TiposDocumento tipoDocumento);
	
	public void delete(TiposDocumento tipoDocumento);
	
	public TiposDocumento findById(Long idTiposDocumento);
	
	public List<TiposDocumento> findAll();

}
