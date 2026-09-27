package siga;

import java.util.List;

public class ServicoMatricula {

    public void matricular(Aluno aluno) {
        if (aluno.getMedia() < 0 || aluno.getMedia() > 10) {
            throw new IllegalArgumentException("Média inválida: " + aluno.getMedia());
        }

        String sql = "INSERT INTO aluno (nome, matricula, media) VALUES ('"
                + aluno.getNome() + "', '"
                + aluno.getMatricula() + "', "
                + aluno.getMedia() + ")";
        BancoSimulado.executar(sql, aluno.toString());
    }

    public void gerarRelatorio() {
        String sql = "SELECT nome, matricula, media FROM aluno";
        List<String> linhas = BancoSimulado.consultar(sql);

        System.out.println("=== Relatório de Alunos ===");
        for (String linha : linhas) {
            System.out.println(linha);
        }
    }
}
