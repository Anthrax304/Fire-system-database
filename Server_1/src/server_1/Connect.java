/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_1;
import java.io.*;
import java.net.*;

import static server_1.Server_1.IP;
import static server_1.Server_1.ipadress;
import static server_1.Server_1.line;
import static server_1.Server_1.pole1;
import static server_1.Server_1.pole2;

public class Connect extends Thread {

     Connect() throws IOException, FileNotFoundException, ClassNotFoundException {
        try (ServerSocket listener = new ServerSocket(8000)) {
            while (true) {

                new Connect(listener.accept()).start();

            }
        }
    }

    private Socket socket;

    public Connect(Socket socket) throws FileNotFoundException, IOException, ClassNotFoundException {
        this.socket = socket;       
        ipadress = socket.getInetAddress().toString().replaceAll("/", "");   // конвертируем IP адрес из InetAddress в String
        IP = ipadress;
        Compare compare = new Compare(IP);

        pole1.append("Подключен клиент " + compare.name + " с адресом " + IP + "\n");

    }

    @Override
    public void run() {
        Compare compare = new Compare(IP);
        try {
            DataInputStream in = new DataInputStream(socket.getInputStream());
            BufferedReader in1 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true) {
                line = in1.readLine();
                int rw1 = in.read();               
                System.out.print("rw0=" + line + "rw1=" + rw1 + "\n" + "ID= " + compare.name+"\t");
                DB db1 = new DB(line, rw1, compare.name, socket.getInetAddress().toString().replaceAll("/", ""));

                if ("smoke".equals(line)) {
                    pole2.append("От клиента " + compare.name + " : " + " Задымление\n");
                }
                if (rw1 > 70) {
                    pole2.append("От клиента " + compare.name + " : " + rw1 + " °С" + " - Возгарание!!!\n");
                } else {
                    pole2.append("От клиента " + compare.name + " : " + rw1 + " °С\n");
                }

            }
        } catch (IOException e) {
            pole1.append("Соединение с клиентом  " + compare.name + " разорвано \n");

        }
    }
}
