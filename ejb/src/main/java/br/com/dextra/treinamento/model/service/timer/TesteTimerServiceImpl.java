package br.com.dextra.treinamento.model.service.timer;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;

import br.com.dextra.treinamento.model.domain.Post;
import br.com.dextra.treinamento.model.service.jpa.PostServiceLocal;

@Stateless
public class TesteTimerServiceImpl implements TesteTimerServiceLocal {

	@Resource
	private SessionContext ctx;
	private static String TIMER_NAME = "ListarPostsTimer";

	@EJB
	private PostServiceLocal postServiceLocal;

	@Resource
	TimerService timerService;

	@Override
	public void agendarExecucao(long inicio, long intervalo) {
		timerService.createTimer(inicio, intervalo, TIMER_NAME);
	}

	@Timeout
	public void execute(Timer timer) {
		Serializable param = (String) timer.getInfo();
		System.out.println("Timer " + param + " executado!");

		List<Post> posts = postServiceLocal.listar();
		for (Post post : posts) {
			System.out.println(post.toString());
		}
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void cancelar() {
		Collection timers = timerService.getTimers();
		for (Object t : timers) {
			Timer timer = (Timer) t;
			if (timer.getInfo().equals(TIMER_NAME)) {
				timer.cancel();
			}
		}
	}

}
