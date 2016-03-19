package br.com.dextra.treinamento.model.service.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostServiceLocal;

@Stateless
@WebService(name = TesteWebServiceInterface.WEB_SERVICE_NAME, 
serviceName = TesteWebServiceInterface.SERVICE_NAME, 
targetNamespace = TesteWebServiceInterface.TARGET_NAME_SPACE, 
portName = TesteWebServiceInterface.PORT_NAME)

@SOAPBinding(style = Style.RPC)
public class TesteWebServiceImpl implements TesteWebServiceInterface {
	
	@EJB
	PostServiceLocal postService;

	@WebMethod
	@Override
	public void servicoInvocado() {
		System.out.println("O servico foi invocado!");
	}

	@WebMethod
	@Override
	public void listarPosts() {
		List<Post> posts = postService.listar();
		for (Post post : posts) {
			System.out.println("Post: " + post.toString());
		}
	}

	@WebMethod
	@Override
	public void adicionarPost(@WebParam(name = "titulo") String titulo, 
			@WebParam(name = "descricao") String descricao) {
		postService.salvar(new Post(titulo,descricao));
	}
}
