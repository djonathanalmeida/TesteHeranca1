package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entidades.Colaborador;
import entidades.ColaboradorTerceirizado;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Colaborador> list = new ArrayList<>();

		System.out.println("Insira o número de colaboradores: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Colaborador #" + i + ": ");
			System.out.println("Adicional?");
			char ad = sc.next().charAt(0); // s ou n
			System.out.println("Nome: ");
			String nome = sc.next();
			System.out.println("Horas: ");
			Integer horas = sc.nextInt();
			System.out.println("Valor por Hora: ");
			Double valorHora = sc.nextDouble();

			if (ad == 's') {
				System.out.println("Adicional: ");
				Double adc = sc.nextDouble();
				list.add(new ColaboradorTerceirizado(nome, horas, valorHora, adc));
			} else {
				list.add(new Colaborador(nome, horas, valorHora));
			}

		}
		
		System.out.println("Pagamentos: ");
		for(Colaborador l : list) {
			System.out.println(l.getNome() + " - R$" + String.format("%.2f", l.pagamento()));
		}

		sc.close();

	}

}
