package br.com.dextra.treinamento.model.service.jms;

import javax.ejb.Local;

@Local
public interface TesteJMSLocal {

	void enviarMensagemQueue();

}
