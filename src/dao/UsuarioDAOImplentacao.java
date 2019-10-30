package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.*;

import users.Usuario;

public class UsuarioDAOImplentacao implements UsuariosDAO {

	private JdbcTemplate jdbcTemplate;
	
	public UsuarioDAOImplentacao(DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int salvar(Usuario u) {
		String sql = "INSERT INTO USUARIOS(nome, email,senha) VALUES (?,?,?)"
				+ "INSERT INTO TELEFONES(dd,numero,tipo) VALUES (?,?,?)";
		return jdbcTemplate.update(sql,u.getNome(),u.getEmail(),u.getSenha()
				,u.getDd(),u.getNumero(),u.getTipo());
	}

	@Override
	public int atualizar(Usuario u) {
		String sql = "UPDATE Usuarios SET nome=?, email=? , phone=? WHERE usuarios_id=?"
				+ "UPDATE Telefones set dd= ? , numero=? ,tipo=? WHERE usuarios_id=?";
		return jdbcTemplate.update(sql,u.getNome(),u.getEmail(),u.getSenha()
				,u.getDd(),u.getNumero(),u.getTipo());
	}

	@Override
	public Usuario get(int id) {
		String sql = "SELECT * FROM Usuarios join Telefones on Usuarios.usuarios_id = telefones.usuarios_id";
		
		
		
		ResultSetExtractor<Usuario> extractor = new ResultSetExtractor<Usuario>() {
			@Override
			public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException{
				if(rs.next()) {
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String senha = rs.getString("senha");
					int dd = rs.getInt("ddd");
					String numero = rs.getString("numero");
					String tipo = rs.getString("tipo");
					
					return new Usuario(id,nome,senha,email,dd,numero,tipo);
				}	
				return null;
			}
		};
		return jdbcTemplate.query(sql,extractor);
	}

	@Override
	public int apagar(int id) {
		String sql = "DELETE FROM telefones WHERE usuario_id="
				+ "DELETE FROM Usuarios WHERE usuario_id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Usuario> list() {
		String sql = "Select * from Usuario join Telefones";
		
		RowMapper<Usuario> rowMapper = new RowMapper<Usuario>() {
			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
			int id = rs.getInt("usuario_id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String senha = rs.getString("senha");
			int dd = rs.getInt("ddd");
			String numero = rs.getString("numero");
			String tipo = rs.getString("tipo");
			
			return new Usuario(id,nome,senha,email,dd,numero,tipo);
				
			}

		};
		
		
		jdbcTemplate.query(sql,rowMapper);
		return null;
	}

}
