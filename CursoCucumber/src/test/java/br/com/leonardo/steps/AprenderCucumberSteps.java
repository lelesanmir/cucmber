package br.com.leonardo.steps;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import br.com.leonardo.converters.DateConverter;
import cucumber.api.Transform;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {

	@Dado("^que eu criei o arquivo corretamente$")
	public void queEuCrieiOArquivoCorretamente() throws Throwable {
		System.out.println("Qualquer coisa!");
	}

	@Quando("^executa-lo$")
	public void executaLo() throws Throwable {

	}

	@Entao("^expecificacao deve finalizar com sucesso$")
	public void expecificacaoDeveFinalizarComSucesso() throws Throwable {

	}

	private int contador = 0;

	@Dado("^que o valor do contador e (\\d+)$")
	public void queOValorDoContadorE(int arg1) throws Throwable {
		contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Entao("^o valor do contador sera (\\d+)$")
	public void oValorDoContadorSera(int arg1) throws Throwable {
		Assert.assertEquals(arg1, contador);
	}

	Date entrega = new Date();

	//@Dado("^que a entrega e (\\d+)/(\\d+)/(\\d+)$")  Facilitando a vida e usando um metodo transforme crinado uma classe DateConverter tbm.
	@Dado("^que a entrega e (.*)$")
	public void queAEntregaE(@Transform(DateConverter.class) Date data) throws Throwable {
//		Calendar cal = Calendar.getInstance();
//		cal.set(Calendar.DAY_OF_MONTH, dia);
//		cal.set(Calendar.MONTH, mes - 1); // No java janeiro começa como zero então toda vez no mes tem que decrementar
//											// 1.
//		cal.set(Calendar.YEAR, ano);
//		entrega = cal.getTime();
		entrega = data;
		System.out.println(entrega);
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$") // modificado pelo site regex para entrar no
																	// aproveitamento no dia e no mês
	public void aEntregaAtrasarEmDias(int arg1, String tempo) throws Throwable { // Expressão regular é muito poderoso
																					// mais tem q estudas bastante
		Calendar cal = Calendar.getInstance();
		cal.setTime(entrega);
		if (tempo.equals("dias")) {
			cal.add(Calendar.DAY_OF_MONTH, arg1);
		}
		if (tempo.equals("meses")) {
			cal.add(Calendar.MONTH, arg1);
		}
		entrega = cal.getTime();
	}

	@Entao("^a entrega sera efetuda  em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeraEfetudaEm(String data) throws Throwable {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = format.format(entrega);
		Assert.assertEquals(data, dataFormatada);
	}

	@Dado("^que o ticket( especial)? é (A.\\d{3})$")
	public void que_o_ticket_é_AF(String tipo, String arg1) throws Throwable {
		
	}

	//@Dado("^que o valor da passagem é R\\$ (\\d+),(\\d+)$") Mapeamento generico
	@Dado("^que o valor da passagem é R\\$ (.*)$")
	public void que_o_valor_da_passagem_é_R$(Double numero) throws Throwable {
		System.out.println(numero);
	}

	@Dado("^que o nome do passageiro é \"(.{5,20})\"$")
	public void que_o_nome_do_passageiro_é(String arg1) throws Throwable {
		
	}

	@Dado("^que o telefone do passageiro é (9\\d{3}-\\d{4})$")
	public void que_o_telefone_do_passageiro_é(String telefone) throws Throwable {
		
	}

	@Quando("^criar os steps$")
	public void criar_os_steps() throws Throwable {
		
	}

	@Então("^o teste vai funcionar$")
	public void o_teste_vai_funcionar() throws Throwable {
		
	}

}
