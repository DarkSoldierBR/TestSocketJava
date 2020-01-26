
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {

        //   int i = 1;
        //     while(i==1){
        int port = 4999;

        ServerSocket ss = new ServerSocket(port);

        System.out.println("Esperando Conexao na Porta " + port);

        int i = 1;
        int id = 0;
        while (i == 1) {

            try {

                Socket s = ss.accept();

                if (s.isConnected()) {

                    id++;

                    System.out.println("Client" + id + " connected(" + s.getLocalAddress() + ")");

                    
                 //   ClientHandler clientthread = new ClientHandler();
                    InputStreamReader in = new InputStreamReader(s.getInputStream());
                    BufferedReader bf = new BufferedReader(in);

                    int want = 1;

                    while(want==1){

                    want = Integer.parseInt(bf.readLine());
                    if(want==1){
                        System.out.println("O cliente quer dizer algo");
                    }
                    String str = bf.readLine();

                    System.out.println("Client " + id + ": " + str);

                    
                }
                    int quer = 0;

                    // PrintWriter pr = new PrintWriter(s.getOutputStream());
                    //  pr.println("");
                    //  pr.flush();
                } else {

                }
                System.out.println("Você quer enviar algo?");

        Scanner sc = new Scanner(System.in);

       // Socket s = ss.accept();

        int quer = sc.nextInt();

        if (quer == 1) {

            System.out.println("Digite a mensagem :");
            String msg = sc.next();
            PrintWriter pr = new PrintWriter(s.getOutputStream());
            System.out.println(msg);
            pr.println(msg);
            pr.flush();
        }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        
        
    }
//}
}
