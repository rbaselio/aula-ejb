package br.com.dextra.treinamento.controller.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.dextra.treinamento.model.service.timer.TesteTimerServiceLocal;

@ManagedBean(name = "testarTimerMB")
@SessionScoped
public class TestarTimerMB {

	@EJB
	private TesteTimerServiceLocal testeEJBTimerService;

	public void testarTimer() {
		long intervalo = 1*60*1000; //1 minuto
		testeEJBTimerService.agendarExecucao(intervalo, intervalo);
		System.out.println("Timer agendado :D");

	}

	public void cancelarTimer() {
		testeEJBTimerService.cancelar();
		System.out.println("Timer cancelado :/");
	}

}
