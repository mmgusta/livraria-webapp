package br.com.resource.webapp.livraria.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Essa classe ser� inicializada automaticamente pelo Spring e efetuara todas as configura��es 
//descritas nos m�todos abaixo
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { //m�todo respons�vel pela configura��o de componentes externos (ex: hibernate)
		return new Class[] {
				HibernateConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//m�todo respons�vel pela configura��o do MVC para spring
		return new Class[] {
				WebMvcConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {//m�todo respons�vel pela configura��o do mapeamento do Dispatcher Servlet
		
		return new String[] {
				"/"
		};
	}

}
