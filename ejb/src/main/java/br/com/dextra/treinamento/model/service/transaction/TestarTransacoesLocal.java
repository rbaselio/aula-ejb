package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.Local;

@Local
public interface TestarTransacoesLocal {
	
	void criarPostRquired(String titulo);
	void criarPostRquiredNew(String titulo);

}
