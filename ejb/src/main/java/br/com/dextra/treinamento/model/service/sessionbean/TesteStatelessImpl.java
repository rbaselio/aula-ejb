package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

import br.com.dextra.treinamento.model.service.interceptor.LoggerInterceptor;

@Interceptors(value = {LoggerInterceptor.class})
@Stateless
public class TesteStatelessImpl implements TesteStatelessLocal {

	private Integer contador = 0;

	public Integer adicionar() {
		contador++;
		return contador;
	}
}
