package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dextra.treinamento.model.service.transaction.TestarTrasacoesClienteLocal;

@ManagedBean(name="testarTransacoesMb")
@SessionScoped
public class TestarTransacoesMB {
	
	@EJB
	TestarTrasacoesClienteLocal clienteLocal;
	
	public void testarRequired(){
		try {
			clienteLocal.testarRequired();
		} catch (Exception e) {
			System.err.println("ERROU");
			
		}
	}
	
	public void testarRequesNew(){
		clienteLocal.testarRequiresNew();
	}

}
