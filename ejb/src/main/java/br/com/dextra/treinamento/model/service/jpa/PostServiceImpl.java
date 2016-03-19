package br.com.dextra.treinamento.model.service.jpa;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.EJBAccessException;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.interceptor.LoggerInterceptor;

@Stateless
@Interceptors(LoggerInterceptor.class)
public class PostServiceImpl implements PostServiceLocal {

	@PersistenceContext(unitName = "blog-pu")
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<Post> listar() {
		String hql = "FROM Post";
		Query query = em.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public Post buscarPorId(Long id) {
		return em.find(Post.class, id);
	}

	@Override
	public void salvar(Post p) {
		em.merge(p);
	}

	@Override
	@RolesAllowed ("administrador")
	public void remover(Long id){
		Post post = em.find(Post.class, id);
		em.remove(post);
	}
}
