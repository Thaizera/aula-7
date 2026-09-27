package siga;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== SIGA - Atividade de Persistência e DAO (código inicial) ===\n");

        ServicoMatricula servico = new ServicoMatricula();

        servico.matricular(new Aluno("Maria Silva", "2026001", 8.5));
        servico.matricular(new Aluno("João Souza", "2026002", 6.0));
        System.out.println();

        servico.gerarRelatorio();

        System.out.println();
        try {
            servico.matricular(new Aluno("Teste Inválido", "2026003", -1));
        } catch (IllegalArgumentException e) {
            System.out.println("Regra de negócio funcionou: " + e.getMessage());
        }

        System.out.println("\nObserve: para testar a regra da média, foi preciso passar");
        System.out.println("pela camada de persistência. O SQL está dentro da classe de");
        System.out.println("negócio (viola SRP e DIP) e o acesso a dados está duplicado.");
        System.out.println("Sua tarefa é extrair a interface AlunoDAO e injetá-la no serviço.");
    }
}
