package br.com.resource.webapp.livraria.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//Essa classe será inicializada automaticamente pelo Spring e efetuara todas as configurações 
//descritas nos métodos abaixo
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() { //método responsável pela configuração de componentes externos (ex: hibernate)
		return new Class[] {
				HibernateConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//método responsável pela configuração do MVC para spring
		return new Class[] {
				WebMvcConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {//método responsável pela configuração do mapeamento do Dispatcher Servlet
		
		return new String[] {
				"/"
		};
	}

}
