package dao;

import users.Usuario;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.*;

;class UsuariosDAOTest {
	
	private DriverManagerDataSource dataSource;
	private UsuariosDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver;");;
		dataSource.setUrl("jdbc:mysql://localhost:3306/desafioSefaz");
		dataSource.setUsername("root");
		dataSource.setPassword("n0t.done");
		
		dao = new UsuarioDAOImplentacao(dataSource);
		
	}

	@Test
	void testSalvar() {
		Usuario usuario = new Usuario("reury araujo","reuryaraujo@gmail.com","123456",81,"67658589","fixo");
		int result  = dao.salvar(usuario);
		
		assertTrue(result>0);
	}

	@Test
	void testAtualizar() {
		Usuario usuario = new Usuario(2,"reury araujo","reury.araujo@gmail.com","123456",81,"67658589","fixo");
		int result = dao.atualizar(usuario);
		if(usuario != null) {
			System.out.println(usuario);
		}
		assertTrue(result>0);
	}

	@Test
	void testGet() {
		int id = 1;
		Usuario usuario = dao.get(id);
		
		assertNotNull(usuario);
	}

	@Test
	void testApagar() {
		int id = 2;
		int resultado = dao.apagar(id);
		
		assertTrue( resultado > 0);
	}

	@Test
	void testList() {
		List<Usuario> listaUsuarios = dao.list();
		
		for(Usuario umUsuario:listaUsuarios) {
			System.out.println(umUsuario);
		}
		assertTrue(!listaUsuarios.isEmpty());
	}

}
