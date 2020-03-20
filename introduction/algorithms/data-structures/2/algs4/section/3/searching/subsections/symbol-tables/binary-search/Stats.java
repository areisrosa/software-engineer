import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Stats {
    //-----------------------------------------------------------------
    // Exemplo de unit test para a ST
    // Alterem à vontade, pois este método não será corrigido.
    public static void main(String[] args) {
        if (args.length == 0) {
            showUse();
            return ;
        }
        String s;
        
        // Initializes an input stream from a filename or web page name.
        In in = new In(args[0]);
        // criamos duasST
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        // número de itens na TS do les-miserables
        int X = 26765;
        int Y = 10000; // chute
        // disparamos o cronometro
        VisualAccumulator acc = new VisualAccumulator(X, Y);

        // vamos povoar a ST com palavras de um arquivo 
        StdOut.println("Criando a ST com as palavras do arquivo '" + args[0] + "' ...");
        Integer val;
        while (!in.isEmpty()) {
            // Read and return the next line.
            String linha = in.readLine();
            String[] chaves = linha.split("\\W+");
            for (int i = 0; i < chaves.length; i++) {
                // StdOut.print("'" + chaves[i] + "' ");
                val = st.get(chaves[i]);
                if (val == null) {
                    st.put(chaves[i], 1);
                }
                else {
                    st.put(chaves[i], val+1);
                }
                // getHits() retorna o número de hits da última operação, no caso, put();
                acc.addDataValue(st.getHits());
            }
        }
        StdOut.println(acc); // invoca método toString de acc
        
        StdOut.println("ST contém " + st.size() + " itens");
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())  // foreach
            if (st.get(word) > st.get(max))
                max = word;
        StdOut.println(max + " " + st.get(max));
        st.randomSearchHit();
    }

    private static void showUse() {
        String msg = "Uso: meu_prompt> java Driver <nome arquivo>\n" 
            + "    <nome arquivo>: nome de um arqrivo com um texto\n"
            + "          TS será criada com as palavras do texto.";
        StdOut.println(msg);
    }

}
