package br.com.dextra.treinamento.controller.bean;

import java.net.MalformedURLException;
import java.net.URL;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

import br.com.dextra.treinamento.model.service.webservice.TesteWebServiceInterface;

@ManagedBean(name = "testarWebServiceMB")
public class TestarWebServiceMB {

	private static final String INDEX = "index.xhtml";
	private String titulo;
	private String descricao;

	public String adicionarPostViaWS() throws MalformedURLException, ServiceException {
		TesteWebServiceInterface testeWebService = obtemWS();
		testeWebService.adicionarPost(titulo, descricao);
		testeWebService.listarPosts();
		adicionarMensagem("Post adicionado com sucesso!");
		return INDEX;
	}
	
	public void testarWebService() throws MalformedURLException, ServiceException {
		TesteWebServiceInterface testeWebService = obtemWS();
		testeWebService.servicoInvocado();
	}

	private TesteWebServiceInterface obtemWS() throws ServiceException,
			MalformedURLException {
		String wsdlURL = "http://localhost:8080/blog-ejb-1.0-SNAPSHOT/TesteWebServiceImplService/TesteWebServiceImpl?wsdl";
		
		String targetNamespace = TesteWebServiceInterface.TARGET_NAME_SPACE;
		String serviceName = TesteWebServiceInterface.SERVICE_NAME;
		String portName = TesteWebServiceInterface.PORT_NAME;

		QName serviceQN = new QName(targetNamespace, serviceName);

		ServiceFactory serviceFactory = ServiceFactory.newInstance();
		Service service = serviceFactory.createService(new URL(wsdlURL), serviceQN);
		System.out.println("Criou o servico");
		
		TesteWebServiceInterface testeWebService = (TesteWebServiceInterface) service
				.getPort(new QName(targetNamespace, portName),
						TesteWebServiceInterface.class);
		return testeWebService;
	}
	
	private void adicionarMensagem(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(mensagem);
		facesContext.addMessage(null, facesMessage);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
