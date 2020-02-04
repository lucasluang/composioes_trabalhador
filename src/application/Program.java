package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoHora;
import entities.Departamento;
import entities.Funcionario;
import entities.enums.FuncionarioLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Digite os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = sc.nextLine();
		System.out.print("Level: ");
		String levelTrabalhador = sc.nextLine();
		System.out.print("Salário base: ");
		double salarioBase = sc.nextDouble();
		Funcionario funcionario = new Funcionario(nomeTrabalhador, FuncionarioLevel.valueOf(levelTrabalhador),
					salarioBase, new Departamento(nomeDepartamento)); 
		
		System.out.println("Digite quantos contratos este funcionário possui? ");
		int numeroContratos = sc.nextInt();
		
		for (int i = 1; i <= numeroContratos; i++) {
			System.out.println("Digite o contrato #" + i + "Dados: ");
			System.out.print("Data: (DD/MM/YYYY): ");
			Date contratoData = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("Duração do contrato (horas): ");
			int horas = sc.nextInt();
			ContratoHora contratohora = new ContratoHora(contratoData, valorPorHora, horas);
			funcionario.adicionaContrato(contratohora);
		}
		
		System.out.println();
		System.out.println("Digite o Mês e Ano para calcular a renda do funcionário: ");
		String mesEAno = sc.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + funcionario.getName());
		System.out.println("Departamento: " + funcionario.getDepartamento().getName());
		System.out.println("Renda para " + mesEAno + ": " + String.format("%.2f", funcionario.renda(ano, mes)));
			
		
		sc.close();
	}

}
