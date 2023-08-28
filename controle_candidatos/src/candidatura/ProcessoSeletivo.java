// CASE 1
//Vamos imaginar que um processo seletivo exite o valor base salarial de R$2.000,00 e o 
//sal�rio pretendido pelo candido. Elabore um controle de fluxo onde:
// - Se o valor salario base for maior que o valor salario pretentido, imprima:
//LIGAR PARA O CANDIDATO;
// - Se o valor salario base for igual ao valor salario pretendido, imprima:
//LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA
// - Sen�o imorima: AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS

// CASE 2
//Foi solicitado que nosso sistema garanta que diante das in�meras candidaturas sejam
//selecionados apenas no m�ximo 5 candidatos para entrevista onde o sal�rio pretendido
//seja menor ou igual o salario base

// CASE 3
// Agora � hora de imprimir a lista dos candidatos selecionados para disponibilizar
//para o RH entrar em contato

// CASE 4
// O RH dever� realizar uma liga��o com no m�ximo 03 tentativas para cada candidato
//selecionado e caso o candidato atenda, deve-se imprimir:
// - "CONSEGUIMOS  CONTATO COM [candidato] AP�S [tentativa] TENTATIVA(S)"
// Do contr�rio imprima:
// - "N�O CONSEGUIMOS CONTATO COM O [candidato]"




package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo { 

	public static void main(String[] args) {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
		for(String candidato: candidatos) {
			entrandoEmContato(candidato);
		}
	}
	static void entrandoEmContato(String candidato) {
			int tentativasRealizadas = 1;
			boolean continuarTentando = true;
			boolean atendeu = false;
			do {
				atendeu = atender();
				continuarTentando = ! atendeu;
				if(continuarTentando)
					tentativasRealizadas ++;
				else
					System.out.println("CONTATO REALIZADO COM SUCESSO");
				
			} while(continuarTentando && tentativasRealizadas < 3 );
			if(atendeu)
				System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
			else
				System.out.println("N�O CONSEGUIMOS CONTATO COM " + candidato + " N�MERO MAXIMO TENTATIVAS " + tentativasRealizadas + " REALIZADA");
			
	}
	
	static boolean atender() {
		return new Random().nextInt(3) == 1;
	}
	
	static void imprimirSelecionados() {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO"};
		System.out.println("Imprimindo a lista de candidatos informando o indice do elemento");
		for(int indice=0; indice < candidatos.length; indice++ ){
			System.out.println("O candidato de n�mero " + (indice+1) + " � o(a) " + candidatos[indice]);
		}
		
		System.out.println("Forma abreviada de intera��o for each");
		for(String candidato: candidatos ) {
			System.out.println("O candidato selecionado foi " + candidato);
		}
		
	}
	
	
	static void selecaoCandidatos() {
		String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
		
		int candidatosSelecionados = 0;
		int candidatosAtual = 0;
		double salarioBase = 2000.0;
		while(candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
			String candidato = candidatos[candidatosAtual];
			double salarioPretendido = valorPretendido();
			
			System.out.println("O candidato " + candidato + "solicitou este valor de sal�rio " + salarioPretendido);
			if(salarioBase >= salarioPretendido) {
				System.out.println("O candidato " + candidato + "foi selecionado para a vaga");
				candidatosSelecionados ++;
			}
			candidatosAtual ++;
		} 
	}
	static double valorPretendido() {
		return ThreadLocalRandom.current().nextDouble(1800, 2200);
	}
	static void analisarCandidato (double salarioPretendido) {
		double salarioBase = 2000.0;
		if(salarioBase > salarioPretendido ) {
			System.out.println("Ligar para o candidato!");
		}
		else if (salarioBase == salarioPretendido ) {
			System.out.println("Ligar para o candidato com contra proposta");
		}
		else {
			System.out.println("Aguardando o resultado dos demais candidatos");
		}
		
	}

}
