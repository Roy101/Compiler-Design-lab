import java.util.*;
import java.io.File;
import java.io.*;


public class LexicalAnalyzer {
    public void analyze() throws FileNotFoundException {

        try {
            String str = null;

            File file = new File("input.txt");

            Scanner sc = new Scanner(file);

            LexicalAnalyzer la = new LexicalAnalyzer();

            System.out.println("Methods:");
            while (sc.hasNext()) {
                String currentline = sc.nextLine();
                la.methodDetection(currentline);
            }

            sc.close();

        }

        catch (Exception e) {
            System.out.println(e);
        }

    }


    public void methodDetection(String e){
        String r = null;


        if ((e.contains("Static") ||e.contains("void")||e.contains("int") ||e.contains("double")||e.contains("String")||e.contains("float")) && (e.contains("("))){
            if ((!e.contains("main")) &&!e.contains("print")){

                StringTokenizer st = new StringTokenizer(e);

                String f= st.nextToken();

                if(f.equals("public")) {
                    f = st.nextToken();
                    r = f;
                }

                if (f.equals("static")){
                    f = st.nextToken();
                    r = f;
                }

                f= st.nextToken("{");
                System.out.print(f.trim()+",");
                System.out.println(" return type:"+r);
            }
        }

    }
}