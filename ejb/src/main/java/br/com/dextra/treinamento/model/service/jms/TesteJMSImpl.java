package br.com.dextra.treinamento.model.service.jms;

import java.util.Calendar;

import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.dextra.treinamento.model.domain.Post;

@Stateless
public class TesteJMSImpl implements TesteJMSLocal {

	@Override
	public void enviarMensagemQueue() {
		ConnectionFactory factory = null;
		Connection conn = null;
		Session session = null;
		MessageProducer publisher = null;

		try {
			Context ctx = new InitialContext();
			factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			conn = factory.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Queue queue = (Queue) ctx.lookup("queue/minhaFila");
			publisher = session.createProducer(queue);

			Post post = new Post();
			post.setData(Calendar.getInstance().getTime());
			post.setTitulo("Titulo do post");
			post.setDescricao("Descricao do post");
			
			ObjectMessage message = session.createObjectMessage(post);
			publisher.send(message);

			// TextMessage msg =
			// session.createTextMessage("Esta eh a mensagem enviada para fila");
			// publisher.send(msg);

		} catch (JMSException e) {
			// Tratar excecao
		} catch (NamingException e) {
			// Tratar excecao
			e.printStackTrace();
		} finally {
			try {
				session.close();
				conn.close();
				publisher.close();
			} catch (JMSException e) {
				throw new RuntimeException(e);
			}
		}
	}



}
