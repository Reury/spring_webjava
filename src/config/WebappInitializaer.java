package config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;


public class WebappInitializaer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
		appContext.register(SringMvcConfig.class);
		
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet());
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
	}

}
