
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente{
    public static void main(String[] args) throws IOException, InterruptedException{
        
        
        boolean connect = false;
        int limite = 3;
        
       
        while(connect==false){
             if(limite>=1){
     try{
        Socket s = new Socket("localhost",4999);
       
         //int i = 1;
    
        
            
            System.out.println("Procurando servidor para se conectar...");
  
            
        
        if(s.isConnected()){
            connect = true;
            System.out.println("Conectado...");
        
        Scanner sc = new Scanner(System.in); 
    
        //Envia mensagem para o servidor
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        int want = 1;
        while(want==1){
            System.out.println("Deseja enviar uma mensagem ? Sim=1");
            want = Integer.parseInt(sc.nextLine());
            pr.println(want);
        //    pr.flush();
        System.out.println("Digite uma mensagem para o servidor");
        String msg = sc.nextLine();
        pr.println(msg);
        pr.flush();
        }
        
        
         
        
        //Recebe menssagem para o servidor
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = new BufferedReader(in);         
      String  str = bf.readLine();
       System.out.println("Server: "+str);
    }else{

        }
       
    }catch(ConnectException ex){
         System.out.println("Conexão com o servidor recusada,uma nova tentativa sera feita");
         limite--;
         System.out.println("Tentativas restantes: "+limite);
         Thread.sleep(5000);
    }}else{
            System.out.println("Limite de tentativas excedido");
System.exit(0);         
             }}
    }
}
