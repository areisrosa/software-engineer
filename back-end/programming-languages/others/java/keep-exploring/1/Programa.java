class Conta {
    int numero;
    Pessoa titular;
    double saldo;
    int agencia;

    void deposita(double valorAserDepositado) {
        this.saldo += valorAserDepositado;
    }

    void saca(double valorASerSacado) {
        if(this.saldo >= valorASerSacado) {
        this.saldo -= valorASerSacado;
        }
    }

    void transfere(double valor, Conta destino) {
        this.saldo -= valor;
        destino.saldo += valor;
    }
}

class Pessoa {
    String nome;
    String cpf;
    String dataNascimento;
}

class Programa {
    public static void main(String[] args) {
        // Object Conta Anderson
        Conta anderson = new Conta(); // Cria uma conta (cria um objeto Conta)
        anderson.numero = 123;
        anderson.saldo = 800.0;
        anderson.agencia = 842;
        anderson.deposita(100.0);

        // Object Pessoa Anderson
        anderson.titular = new Pessoa();
        anderson.titular.nome = "Anderson Reis";
        anderson.titular.cpf = "123456789";
        anderson.titular.dataNascimento = "10/10/1999";

        // Object Conta Guilherme
        Conta guilherme = new Conta(); // Cria uma conta (cria um objeto Conta)
        guilherme.numero = 456;
        guilherme.saldo = 1200.0;
        guilherme.saca(0.0);
        anderson.transfere(100.0, guilherme);

        // Object Pessoa Guilherme
        guilherme.titular.nome = "Guilherme";
        guilherme.titular.cpf = "34567655555";
        guilherme.titular.dataNascimento = "11/11/1987";

        System.out.println(anderson.saldo);
        System.out.println(guilherme.saldo);
    }
}
