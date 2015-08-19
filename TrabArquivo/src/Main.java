/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;
import java.util.*;

/**
 *
 * @author Aula
 */
public class P22 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String loopAsk, disciplina, resposta = null;
        Scanner tec = new Scanner(System.in);
        ArrayList<String> testes = new ArrayList<>();
        System.out.println("");
        while (true) {
            System.out.println("Nome do Aluno");
            loopAsk = tec.next();
            System.out.println("Resposta do Aluno");
            for (int i = 1; i < 11; i++) {
                System.out.println("Digite a resposta da " + i + "a questao.");
                if (resposta == null) {
                    resposta = tec.next().toUpperCase();
                } else {
                    resposta = resposta + tec.next().toUpperCase();
                }
                // System.err.println(loopAsk);
            }
            loopAsk = loopAsk + "/" + resposta + "/" + "99";
            testes.add(loopAsk);
            resposta = null;
            //   System.err.println( testes.indexOf(loopAsk));
            System.out.println("Continuar s/n");
            loopAsk = tec.next();
            if (loopAsk.equals("n")) {
                break;
            }
        }
        Collections.sort(testes, String.CASE_INSENSITIVE_ORDER);
        for (String t : testes) {
            System.out.println(t);
        }
        while (true) {
            System.out.println("Qual o nome da disciplina?");
            disciplina = tec.next();
            File diretorio = new File(disciplina);
            diretorio.mkdir();
            loopAsk = null;
            for (int i = 1; i < 11; i++) {
                System.out.println("Digite a resposta da " + i + "a questao.");
                if (loopAsk == null) {
                    loopAsk = tec.next().toUpperCase();
                } else {
                    loopAsk = loopAsk + tec.next().toUpperCase();
                }
                System.err.println(loopAsk);
            }
            FileWriter fw1 = new FileWriter(disciplina + "\\Gabarito.txt");
            BufferedWriter bw1 = new BufferedWriter(fw1);
            bw1.write(loopAsk);
            bw1.close();
            fw1.close();
            System.out.println("Continuar s/n");
            loopAsk = tec.next();
            if (loopAsk.equals("n")) {
                break;
            }
        }
        ////Conferir Respostas
        String Gab;
        String GabE[];
        int acertos = 0;
        String estudante;
        while (true) {
            System.out.println("Nome da Disciplina para Conferir");
            loopAsk = tec.next();
            try {
                FileReader fr2 = new FileReader(loopAsk + "\\Gabarito.txt");
                BufferedReader br2 = new BufferedReader(fr2);
                Gab = br2.readLine();
                br2.close();
                fr2.close();
                FileWriter fw1 = new FileWriter(disciplina + "\\ResultadoOrdenado01.txt");
                BufferedWriter bw1 = new BufferedWriter(fw1);
                for (String teste : testes) {
                    GabE = teste.split("/");
                    for (int i = 0; i < 10; i++) {
                        if (Gab.charAt(i) == GabE[1].charAt(i)) {
                            acertos++;
                        }
                    }
                    estudante = GabE[0] + "/" + GabE[1] + "/" + acertos;
                    acertos = 0;
                    bw1.write(estudante);
                    bw1.newLine();
                }
                bw1.close();
                fw1.close();
                break;
            } catch (IOException e) {
                System.out.println("Nome da Disciplina Invalido");
            }

        }

    }

}
