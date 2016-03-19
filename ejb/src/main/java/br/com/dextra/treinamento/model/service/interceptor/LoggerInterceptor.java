package br.com.dextra.treinamento.model.service.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.dextra.treinamento.model.domain.PostAudit;

public class LoggerInterceptor {
	@PersistenceContext(unitName = "blog-pu")
	private EntityManager em;
	
	
	@AroundInvoke
	public Object log(InvocationContext ctx) throws Exception {
		
		
		
		String classe = ctx.getTarget().getClass().getName();
		String metodo = ctx.getMethod().getName();
		String parametros = "";
		if(ctx.getParameters().length > 0) {
			parametros = ctx.getParameters()[0].toString();
		}
		
		System.out.println("Classe: " + classe);
		System.out.println("Metodo: " + metodo);
		
		PostAudit audit = new PostAudit();
		audit.setClasse(classe);
		audit.setMetodo(metodo);
		audit.setParametro(parametros);
		em.persist(audit);
		
		return ctx.proceed();
	}
	
	
	@PostConstruct
	public void postConstruct(InvocationContext context) {
		System.out.println("EJB SENDO CRIADO " + context.getTarget().getClass().getName());
	}

	@PreDestroy
	public void preDestroy(InvocationContext context) {
		System.out.println("EJB SENDO DESTRUIDO " + context.getTarget().getClass().getName());
	}	
	
	
}

