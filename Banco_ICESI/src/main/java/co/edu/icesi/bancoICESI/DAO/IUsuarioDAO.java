package co.edu.icesi.bancoICESI.DAO;

import java.util.List;

import co.edu.icesi.bancoICESI.modelo.Usuario;

public interface IUsuarioDAO {
	
	public void save(Usuario usuario);
	
	public void update(Usuario usuario);
	
	public void delete(Usuario usuario);
	
	public Usuario findById(Long idUsuario);
	
	public List<Usuario> findAll();

}
