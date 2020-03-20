class Turma {
    // Atributos da Turma
    Aluno[] alunos; // Array de notas. A variável
                // notas é Array e este (Array) é um um objeto, por isso,
                // precisamos criar um objeto notas com tamanho fixo.
    // Métodos da class Turma
    void imprimeNotas() {
        for(int i = 0; i < this.alunos.length; i++) {
            Aluno aluno = this.alunos[i];
            if(aluno == null)
                continue;
            System.out.println(aluno.nota);
        }
    }
}
class Aluno {
    String nome;
    int nota;
}
class TesteDaTurma {
    public static void main(String[] args) {

        Turma a = new Turma();
        a.alunos = new Aluno[10]; // Objeto notas criado com tamanho 10.

        a.alunos[0] = new Aluno();
        a.alunos[0].nome = "Anderson";
        a.alunos[0].nota = 9;

        a.alunos[1] = new Aluno();
        a.alunos[1].nome = "Marcelo";
        a.alunos[1].nota = 5;

        a.alunos[2] = new Aluno();
        a.alunos[2].nome = "Guilherme";
        a.alunos[2].nota = 7;

        a.imprimeNotas();
    }
}
