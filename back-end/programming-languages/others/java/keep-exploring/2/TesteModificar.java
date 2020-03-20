class TesteModificador {
    public static void main(String[] args) {
        Conta anderson = new Conta();
        anderson.numero = 123;
        anderson.setLimite(600.0);
        anderson.deposita(1000.0);
        double valorASerSacado = 1200.0;

        anderson.saca(valorASerSacado);
        System.out.println(anderson.getSaldo());
    }
}
