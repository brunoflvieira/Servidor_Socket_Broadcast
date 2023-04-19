package Principal;

import java.net.*;
import java.io.*;

public class Principal {

    public static void main(String args[]) {
        try {
            DatagramSocket con = new DatagramSocket(4444); //conexao(porta)
            while (true) {
                byte dado[] = new byte[100]; //Configura o pacote
                DatagramPacket pacote = new DatagramPacket(dado, dado.length); //Configura o pacote
                System.out.println("Inicio servidor");
                String mensagem = "";
                while (!mensagem.equals("fim")) {
                    con.receive(pacote); //espera pacote
                    System.out.println("\n\nPacote recebido do Cliente :"
                            + "\n do Host: " + pacote.getAddress()
                            + "\n da Porta: " + pacote.getPort()
                            + "\n de Tamanho: " + pacote.getLength()
                            + "\n contendo: ");
//Recupera o texto recebido
                    mensagem = new String(pacote.getData(), 0, pacote.getLength());
                    System.out.println(" " + mensagem); //escreve mensagem
                }
            }
        } catch (IOException io) {
            System.err.println("Problemas de IO");
        }
    }
}
