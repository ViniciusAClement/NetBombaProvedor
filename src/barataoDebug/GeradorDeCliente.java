package barataoDebug;

import java.util.Random;

import main.model.service.ClienteService;

public class GeradorDeCliente {
	public static String geradorDeNomes() {
		String[] nomes = {"Ana", "Bruno", "Carlos", "Daniela", "Eduardo", "Fernanda", "Gabriel", "Helena"};
        String[] sobrenomes = {"Silva", "Santos", "Oliveira", "Souza", "Lima", "Pereira", "Costa", "Rodrigues"};

        Random rand = new Random();
        
        String nomeAleatorio = nomes[rand.nextInt(nomes.length)] + " " + sobrenomes[rand.nextInt(sobrenomes.length)];
        
        return nomeAleatorio;
	}
	
	public static String geradorDeRuas() {
		String[] prefixos = {"Rua", "Avenida", "Travessa", "Alameda", "Rodovia"};
        String[] nomes = {
            "das Flores", "dos Andradas", "São João", "Getúlio Vargas", 
            "Presidente Vargas", "15 de Novembro", "Dom Pedro II", 
            "dos Pinheiros", "da Independência", "do Comércio"
        };

        Random rand = new Random();

        String ruaAleatoria = prefixos[rand.nextInt(prefixos.length)] + " " +
                              nomes[rand.nextInt(nomes.length)];
        
        return ruaAleatoria;
	}
	
	public static int geradorDeNumerosDeCasas() {
		Random random = new Random();
		int numeroDeCasa = random.nextInt(1000)+1;
		return numeroDeCasa;
	}
	
	public static int geradorDeNumerosDePlano() {
		Random random = new Random();
		int numeroDePlano = random.nextInt(4)+1;
		return numeroDePlano;
	}
	
	public static String gerarCPF() {
        Random rand = new Random();
        int[] cpf = new int[11];

        for (int i = 0; i < 9; i++) {
            cpf[i] = rand.nextInt(10);
        }

        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpf[i] * (10 - i);
        }
        int dig1 = 11 - (soma % 11);
        cpf[9] = (dig1 >= 10) ? 0 : dig1;

        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += cpf[i] * (11 - i);
        }
        int dig2 = 11 - (soma % 11);
        cpf[10] = (dig2 >= 10) ? 0 : dig2;

        return String.format("%d%d%d.%d%d%d.%d%d%d-%d%d",
                cpf[0], cpf[1], cpf[2],
                cpf[3], cpf[4], cpf[5],
                cpf[6], cpf[7], cpf[8],
                cpf[9], cpf[10]);
    }
	
	public static void gerarClienteAleatorio () {
		ClienteService.createCliente(geradorDeNomes(), gerarCPF(), geradorDeRuas(), geradorDeNumerosDeCasas(), geradorDeNumerosDePlano());
	}
}
