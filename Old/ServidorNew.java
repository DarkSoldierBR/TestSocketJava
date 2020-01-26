import java.io.IOException;
import java.net.ServerSocket;

public class ServidorNew {
    int port = 4999;

    public void accept() throws IOException {
        new Thread() {
            ServerSocket ss = new ServerSocket(port);
//            System.out.println("Esperando Conexao na Porta " + port);

        };

    }

}