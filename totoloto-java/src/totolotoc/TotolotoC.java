package totolotoc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TotolotoC{
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        //declaração variaveis
        Scanner ler = new Scanner (System.in);
        SecureRandom rand = new SecureRandom();
        int[] v1 = new int[10];
        int[] v2 = new int[6];
        int i, j, a, pontos=1, ptotal=0;
        
        String nome = JOptionPane.showInputDialog("Nome:");
        String morada = JOptionPane.showInputDialog("Morada: ");
        //String Contato = JOptionPane.showInputDialog("Contato");
        
        /*menu
        for(i=1;i<50;i++){
            System.out.print(i+"\t");
            if( i==10 || i==20 || i==30 || i==40){
                System.out.println("");
            }
        }*/
        
        //escolher 10 numeros
        //System.out.println("\nEscolha 10 numeros abaixo: (press enter para escolher o proximo!");
        for (i=0; i<10; i++){
            //System.out.print(" >> ");
            v1[i]= Integer.parseInt(JOptionPane.showInputDialog(null, ""
                + "Escolha 10 numeros abaixo: (press enter para escolher o proximo!):\n\n"
                + "---------------------------------------------------------------------------------------------------------------------------------\n"
                + "|    1     |     2     |     3      |     4      |      5      |      6      |      7      |      8      |     9      |    10   |\n"
                + "---------------------------------------------------------------------------------------------------------------------------------\n"
                + "|    11    |     12    |     13     |     14     |      15     |      16     |      17     |      18     |     19     |    20   |\n"
                + "---------------------------------------------------------------------------------------------------------------------------------\n"
                + "|    21    |     22    |     23     |     24     |      25     |      26     |      27     |      28     |     29     |    30   |\n"
                + "---------------------------------------------------------------------------------------------------------------------------------\n"
                + "|    31    |     32    |     33     |     34     |      35     |      36     |      37     |      38     |     39     |    40   |\n"
                + "---------------------------------------------------------------------------------------------------------------------------------\n"
                + "|    41    |     42    |     43     |     44     |      45     |      46     |      47     |      48     |     49     |          \n"
                + "-----------------------------------------------------------------------------------------------------------------------\n"));
            //v1[i] = ler.nextInt();
            //condicao para nao introduzir numeros fora do intervalo
            if((v1[i]<1 || v1[i]>=50)){
                JOptionPane.showMessageDialog(null, "Atenção! Numero Invalido. Introduza novamente", "OK",JOptionPane.ERROR_MESSAGE);
                //System.out.println("Atenção! Numero Invalido. Introduza novamente");
                i--;
            }
            //condicao para nao repetir os numeros esclhidos
            for(j=i-1;j>=0;j--){
                if(i>0 && (v1[i]==v1[j])){
                    JOptionPane.showMessageDialog(null, "Atenção! Numero Repetido. Introduza um numero diferente", "OK",JOptionPane.ERROR_MESSAGE);
                    //System.out.println("Atenção! Numero Repetido. Introduza um numero diferente");
                    i--;
                }
            }
        }
        
        //ordenar crescente os numeros escolhidos
        Arrays.sort(v1);
                
        //apresentar os numeros escolhidos
        JOptionPane.showMessageDialog(null, ""
                + "Numeros Escolhidos:\n"
                + v1[0] + "  -  " + v1[1] + "  -  " + v1[2] + "  -  " + v1[3] + "  -  " + v1[4] + "  -  " 
                + v1[5] + "  -  " + v1[6] + "  -  " + v1[7] + "  -  " + v1[8] + "  -  " + v1[9]);
        //System.out.println("Numeros Escolhidos:");
        //for(int b:v1) System.out.printf("%d\t", b);
        
        //gerar os numeros aleatorios
        for(i=0, a=0;i<v2.length;i++)
        {
            a = 1+rand.nextInt(49); 
            v2[i]=a;
            //int location = Arrays.binarySearch(v2, a);    //if(location<0) v2[i]=a; else --i;
            for(j=i-1;j>=0;j--){
                if(i>0 && (v2[i]==v2[j])) i--;
            }
        }
        
        //ordenar crescente os numeros escolhidos
        Arrays.sort(v2);        
        
         //apresentar os numeros extraidos
        JOptionPane.showMessageDialog(null, ""
                + "Numeros Extraidos:\n"
                + v2[0] + ",   " + v2[1] + ",   " + v2[2] + ",   " + v2[3] + ",   " + v2[4] + ",   " + v2[5], "OK",
                JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("\n\nNumeros Extraídos:");
        //for(int b:v2) System.out.printf("%d\t", b);

        //System.out.println("\n\nNome: "+nome);
        //System.out.println("Morada: "+morada);
        
        //System.out.print("Numero(s) Acertado(s): ");
        for(i=0; i<v1.length; i++)
	{
            for (j=0; j<v2.length; j++)
            {
                if(v1[i] == v2[j]) {
                    JOptionPane.showMessageDialog(null, ""
                            + "Numero Acertado:\n"
                            + v1[i], "OK", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.print(v1[i]+",");
                    ptotal+=pontos;
                } 
            }
	}
        JOptionPane.showMessageDialog(null, ""
                            + "Ponto Total:\n"
                            + ptotal, "OK", JOptionPane.INFORMATION_MESSAGE);
        //System.out.println("\nPonto Total >> "+ ptotal);
        
        if(ptotal>=2)GravarDados(ptotal,nome,morada);
    }
    
    //Gravar Dados
    public static void GravarDados(int ptotal, String nome, String morada) throws IOException{
        
        File file = new File("Recordes.txt");
        FileWriter arq = new FileWriter(file, true);
        BufferedWriter escreverFile = new BufferedWriter(arq);
        try{
            escreverFile.write("\nNome: "+ nome+" \t|\t ");
            escreverFile.write("Morada: "+ morada+" \t|\t ");
            escreverFile.write("Ponto: "+ptotal+" \n");
            JOptionPane.showMessageDialog(null, "Novo Recorde Adicionado aos Registos!", "OK", JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("\n\nNovo Recorde Adicionado aos Registos!");
            escreverFile.close();
        }catch(IOException ioexception){
            JOptionPane.showMessageDialog(null, "Erro na escrita do ficheiro!", "OK", JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("Erro na escrita do ficheiro");
        }
    }
    
    //ler dados
    public static void LerDados() throws FileNotFoundException{
        
        File file = new File("Recordes.txt");
        FileReader lerFile = new FileReader(file);
        BufferedReader buf = new BufferedReader(lerFile);
        try{
            System.out.println("Conteudo do documento:");
            String frase;
            while((frase = buf.readLine()) != null){
                System.out.println(frase);
            }buf.close();
        }catch(IOException ioexception){
            System.out.println("Erro na leitura do ficheiro");
        }
    }
}   