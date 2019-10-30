package dao;

import java.util.List;

import users.Usuario;

public interface UsuariosDAO {
	public int salvar(Usuario usuario);
	
	public int atualizar(Usuario usuario);
	
	public Usuario get(int id);
	
	public int apagar(int id);
	
	public List<Usuario> list();
}
