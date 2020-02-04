package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.FuncionarioLevel;

public class Funcionario {
	
	private String name;
	private FuncionarioLevel level;
	private Double SalarioBase;
	
	private Departamento departamento;
	private List<ContratoHora> contratos = new ArrayList<>();
	
	public Funcionario() {
	}

	public Funcionario(String name, FuncionarioLevel level, Double salarioBase, Departamento departamento) {
		this.name = name;
		this.level = level;
		SalarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FuncionarioLevel getLevel() {
		return level;
	}

	public void setLevel(FuncionarioLevel level) {
		this.level = level;
	}

	public Double getSalarioBase() {
		return SalarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		SalarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoHora> getContratos() {
		return contratos;
	}
	
	public void adicionaContrato(ContratoHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrtato(ContratoHora contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = SalarioBase;
		Calendar cal = Calendar.getInstance();

		for (ContratoHora ch : contratos) {
			cal.setTime(ch.getDate());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			
			if (ano == c_ano && mes == c_mes) {
				soma += ch.valorTotal();
			}
		}
		return soma;
	}
	
}
