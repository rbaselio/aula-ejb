package br.com.dextra.treinamento.model.service.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import br.com.dextra.treinamento.model.domain.Post;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/minhaFila") })
public class ConsumidorQueue implements MessageListener {

	public void onMessage(Message message) {
		try {
//			TextMessage msg = (TextMessage) message;
//			String text = msg.getText();
			
			ObjectMessage obj = (ObjectMessage) message;
			Post post = (Post) obj.getObject();

//			System.out.println("Mensagem = " + text);
			
			System.out.println("Post: " + post.toString());
		} catch (JMSException e) {
			throw new RuntimeException(e);
		}
	}
}
