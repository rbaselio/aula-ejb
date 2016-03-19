package br.com.dextra.treinamento.model.service.webservice;

import java.rmi.Remote;

public interface TesteWebServiceInterface extends Remote {

	public static final String WEB_SERVICE_NAME = "TesteWebServiceImpl";
	public static final String PORT_NAME = "TesteWebServiceImplPort"; 
	public static final String SERVICE_NAME = "TesteWebServiceImplService"; 
	public static final String TARGET_NAME_SPACE = "http://service.model.treinamento.dextra.com.br";

	void servicoInvocado();
	
	void listarPosts();
	
	void adicionarPost(String titulo, String descricao);

}
