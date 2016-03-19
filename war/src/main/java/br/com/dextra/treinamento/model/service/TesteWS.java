package br.com.dextra.treinamento.model.service;

public class TesteWS {
	public static void main(String[] args) {
		TesteWebServiceImplService ws = new TesteWebServiceImplService();
		TesteWebServiceImpl service = ws.getTesteWebServiceImplPort();
		service.adicionarPost("ws", "descricao");
		service.listarPosts();
	}

}
