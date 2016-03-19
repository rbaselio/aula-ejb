package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dextra.treinamento.model.service.jms.TesteJMSLocal;

@ManagedBean(name = "testarJMS")
@RequestScoped
public class TestarJMSMB {
	
	@EJB
	private TesteJMSLocal jmsLocal;

	/**
	 * Obtendo o Bean via JDNIA
	 * */
	public void testarQueue() throws NamingException {
		InitialContext initialContext = new InitialContext();
		TesteJMSLocal testeJMS = (TesteJMSLocal) initialContext
				.lookup("blog/TesteJMSImpl/local");
		testeJMS.enviarMensagemQueue();
	}

}
