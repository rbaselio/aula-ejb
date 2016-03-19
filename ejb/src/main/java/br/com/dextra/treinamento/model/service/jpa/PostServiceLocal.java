package br.com.dextra.treinamento.model.service.jpa;

import java.util.List;

import br.com.dextra.treinamento.model.domain.Post;

public interface PostServiceLocal {

	Post buscarPorId(Long id);

	List<Post> listar();

	void salvar(Post p);

	void remover(Long id);

}
