import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn; 
import edu.princeton.cs.algs4.StdOut; 
import edu.princeton.cs.algs4.Stopwatch;

public class Test {
    private static final String PROMPT  = ">>> ";
    private static final String KEYS    = "keys"; // show the keys in ST
    private static final String SIZE    = "size"; // show the 'size' ST

    // Exemple test unit for the ST
    public static void main(String[] args) {
        if (args.length == 0) {
            showUse();
            return;
        }
        String s;

    private static void showUse() {
        String msg = "Use: my_prompt> java Test <file name>\n" 
            + "    <file name>: name a file with a text\n"
            + "          ST will be created with the files of the text.";
        StdOut.println(msg);
    }

        // Initializes an input stream from a filename or web page name.
        In in = new In(args[0]);
        // Two ST
        BinarySearchST<String, Integer> st = new BinarySearchST<String, Integer>();
        // Loose off the watch
        Stopwatch sw = new Stopwatch();


        // We go proof the ST with word a file
        StdOut.println("Creating the ST with the words of the file '" + args[0] + "' ...");
        Integer val;

        while (!in.isEmpty()) {
            // Read and return the next line.
            String linha = in.readLine();
            String[] keys = linha.split("\\W+");
            for (int i = 0; i < keys.length; i++) {
                // StdOut.print("'" + keys[i] + "' ");
                val = st.get(keys[i]);
                if (val == null) {
                    st.put(keys[i], 1);
                }
                else {
                    st.put(keys[i], val+1);
                }
            }
        }
        
        // sw.elapsedTime(): Returns elapsed time (in seconds) since this object was created.
        StdOut.println("TS create in " + sw.elapsedTime() + " second");
        StdOut.println("TS contains " + st.size() + " items");
        StdOut.println("Interactive consultation starts. Press ctrl+D to close");
        StdOut.print(PROMPT);

        // Consult the created ST
        while (!StdIn.isEmpty()) {
            s = StdIn.readString();
            if (s.equals(SIZE)) {
                StdOut.println(st.size());
            }
            else if (s.equals(KEYS)) {
                for (String key: st.keys()) {
                    StdOut.println(key);
                }
            }
            else {
                // Search the number occurrence file 's'
                StdOut.println(st.get(s));
            }
            StdOut.print(PROMPT);
         }
    }
}
