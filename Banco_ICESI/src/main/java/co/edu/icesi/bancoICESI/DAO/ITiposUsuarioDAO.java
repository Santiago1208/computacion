package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.TiposUsuario;

public interface ITiposUsuarioDAO {
	
	public void save(TiposUsuario tipoUsuario);
	
	public void update(TiposUsuario tipoUsuario);
	
	public void delete(TiposUsuario tipoUsuario);
	
	public TiposUsuario findById(Long idTipoUsuario);
	
	public List<TiposUsuario> findAll();

}
