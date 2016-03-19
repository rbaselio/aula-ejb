package br.com.dextra.treinamento.model.service.transaction;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TestarTrasacoesClienteImpl implements TestarTrasacoesClienteLocal {

	@EJB
	private TestarTransacoesLocal testarTransacoes;
	
	@Override
	public void testarRequired() {
		testarTransacoes.criarPostRquired("titulo required");
		testarTransacoes.criarPostRquired(null);
		
	}

	@Override
	public void testarRequiresNew() {
		testarTransacoes.criarPostRquiredNew("titulo requiresNew");
		testarTransacoes.criarPostRquiredNew(null);
		
	}


}
