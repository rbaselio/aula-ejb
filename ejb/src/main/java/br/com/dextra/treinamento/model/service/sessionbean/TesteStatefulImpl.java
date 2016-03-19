package br.com.dextra.treinamento.model.service.sessionbean;

import javax.ejb.Stateful;
import javax.interceptor.Interceptors;

import br.com.dextra.treinamento.model.service.interceptor.LoggerInterceptor;

@Interceptors(value = {LoggerInterceptor.class})
@Stateful
public class TesteStatefulImpl implements TesteStatefulLocal {
	
	private Integer contador = 0;

	@Override
	public Integer adicionar() {
		contador++;
		return contador;
	}
}
