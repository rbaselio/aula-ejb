package br.com.dextra.treinamento.controller.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dextra.treinamento.model.service.sessionbean.TesteStatefulLocal;
import br.com.dextra.treinamento.model.service.sessionbean.TesteStatelessLocal;

@ManagedBean(name = "testarSessionBeanMB")
@RequestScoped
public class TestarSessionBeanMB {

	public void testarStateless() {
		try {
			InitialContext initialContext = new InitialContext();
			TesteStatelessLocal stateless = (TesteStatelessLocal) initialContext.lookup("blog/TesteStatelessImpl/local");

			List<Integer> lista = new ArrayList<Integer>();

			lista.add(stateless.adicionar());
			lista.add(stateless.adicionar());

			stateless = (TesteStatelessLocal) initialContext.lookup("blog/TesteStatelessImpl/local");

			lista.add(stateless.adicionar());
			lista.add(stateless.adicionar());

			System.out.println("Lista = " + lista.toString());
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public void testarStateful() {
		try {
			InitialContext initialContext = new InitialContext();
			TesteStatefulLocal stateful = (TesteStatefulLocal) initialContext.lookup("blog/TesteStatefulImpl/local");

			List<Integer> lista = new ArrayList<Integer>();

			lista.add(stateful.adicionar());
			lista.add(stateful.adicionar());

			stateful = (TesteStatefulLocal) initialContext.lookup("blog/TesteStatefulImpl/local");

			lista.add(stateful.adicionar());
			lista.add(stateful.adicionar());

			System.out.println("Lista = " + lista.toString());
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}
}
