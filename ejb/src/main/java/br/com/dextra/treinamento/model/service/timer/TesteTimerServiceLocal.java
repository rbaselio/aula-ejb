package br.com.dextra.treinamento.model.service.timer;

import javax.ejb.Local;

@Local
public interface TesteTimerServiceLocal {
	
	void agendarExecucao(long inicio, long intervalo);
	
	void cancelar();

}
