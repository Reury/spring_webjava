package config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import dao.UsuarioDAOImplentacao;
import dao.UsuariosDAO;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "Usuarios")
public class SringMvcConfig implements WebMvcConfigurer{
	

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver;");;
		dataSource.setUrl("jdbc:mysql://localhost:3306/desafioSefaz");
		dataSource.setUsername("root");
		dataSource.setPassword("n0t.done");
		
		return dataSource;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/VIEWS/");
		resolver.setSuffix(".jsp");
		
		return resolver;
	}
	
	@Bean
	public UsuariosDAO getUsuarioDAO() {
		return new UsuarioDAOImplentacao(getDataSource());
		
	}
	
}
