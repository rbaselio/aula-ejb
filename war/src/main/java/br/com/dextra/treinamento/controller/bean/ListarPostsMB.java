package br.com.dextra.treinamento.controller.bean;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.EJBAccessException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostServiceLocal;

@ManagedBean(name = "listarPostsMB")
@SessionScoped
public class ListarPostsMB {

	private static final String INDEX_XHTML = "index.xhtml";

	private static final String INCLUIR_POST = "incluirPost.xhtml";

	private static final String LISTAR_POSTS = "listarPosts.xhtml";

	private static final String ALTERAR_POST = "alterarPost.xhtml";

	private List<Post> posts;

	private Post post = new Post();

	private Post novoPost;
	
	@EJB
	private PostServiceLocal postServiceLocal;

	public String listar() {
		posts = postServiceLocal.listar();
		return LISTAR_POSTS;
	}

	public String incluir() {
		this.novoPost = new Post();
		return INCLUIR_POST;
	}

	public String prepararAlteracao() {
		String id = obterParametroPorNome("id");
		post = postServiceLocal.buscarPorId(Long.valueOf(id));
		return ALTERAR_POST;
	}

	public String alterar() {
		postServiceLocal.salvar(post);
		adicionarMensagem("Post alterado com sucesso");
		posts = postServiceLocal.listar();
		return LISTAR_POSTS;
	}

	public String remover() {
		String id = obterParametroPorNome("id");
		try {
			postServiceLocal.remover(Long.valueOf(id));
			adicionarMensagem("Post removido com sucesso");
			
		} catch (EJBAccessException e) {
		
		} catch (NumberFormatException e) {
			
		}
		return listar();
		
		
	}

	public String salvar() {
		postServiceLocal.salvar(novoPost);
		posts = postServiceLocal.listar();
		adicionarMensagem("Post adicionado com sucesso");
		return LISTAR_POSTS;
	}

	public String cancelar() {
		return LISTAR_POSTS;
	}
	
	public String voltar() {
		return INDEX_XHTML;
	}

	private void adicionarMensagem(String mensagem) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		FacesMessage facesMessage = new FacesMessage(mensagem);
		facesContext.addMessage(null, facesMessage);
	}

	private String obterParametroPorNome(String nome) {
		Map<String, String> params = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap();
		return params.get(nome);
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Post getNovoPost() {
		return novoPost;
	}

	public void setNovoPost(Post novoPost) {
		this.novoPost = novoPost;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
