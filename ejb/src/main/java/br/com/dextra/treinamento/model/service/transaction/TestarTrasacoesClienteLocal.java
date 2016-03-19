package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.Local;

@Local
public interface TestarTrasacoesClienteLocal {
	void testarRequired();
	void testarRequiresNew();
	
}
