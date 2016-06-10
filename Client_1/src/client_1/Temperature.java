/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Temperature {

    JLabel label2 = new JLabel();
    JLabel label = new JLabel("Введите занчение температуры");
    String serverAddress;
    static int serverPort = 8000; // здесь обязательно нужно указать порт к которому привязывается сервер.
    static JTextField textField = new JTextField(10);
    static JTextField textField1 = new JTextField(10);
    static JPanel panel1 = new JPanel();
    static JPanel panel2 = new JPanel();
    static JButton button_send = new JButton("Отправить");
    static String line;
    static String line1;
//    byte[] DBM;
    //static  String line2;
    BufferedReader in;
    DataOutputStream out;
    PrintWriter out1;
    BufferedReader inu;
    JFrame window = new JFrame("fire detector");

    public Temperature() {

        window.setSize(320, 240);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setLayout(new BorderLayout());

        panel1.setBackground(Color.RED);
        panel2.setBackground(new Color(204, 204, 204));
        panel2.setLayout(new GridBagLayout());

        button_send.setBackground(new Color(10, 200, 22));
        button_send.setForeground(Color.black);
        button_send.setCursor(new Cursor(Cursor.HAND_CURSOR));
        window.add(panel1, BorderLayout.SOUTH);
        window.add(panel2);
        panel1.add(label2);
        panel2.add(label, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel2.add(textField, new GridBagConstraints(1, 1, 1, 1, 0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 2, 2), 0, 0));
        panel2.add(textField1, new GridBagConstraints(1, 100, 1, 1, 0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 2, 2), 0, 0));
        panel2.add(button_send, new GridBagConstraints(0, 500, 2, 1, 0, 0.9,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 2, 2, 2), 0, 0));
        window.pack();

    }

    public void connectToServer() throws IOException {

        serverAddress = JOptionPane.showInputDialog(window, "Введите IP адрес сервера:");

        InetAddress ipAddress = InetAddress.getByName(serverAddress);
        label2.setText("IP " + serverAddress + " and port " + serverPort);
        Socket socket = new Socket(ipAddress, serverPort);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new DataOutputStream(socket.getOutputStream());
        out1 = new PrintWriter(socket.getOutputStream(), true);
        inu = new BufferedReader(new InputStreamReader(System.in));

// ActionListener 
        button_send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

//                    String s = textField.getText();
//                    String t = textField1.getText();
//                    out.println("Температура,С: "+s);
//                    DBM[0]=1;
//                    DBM[1]=98;
//                  out.println(g2);
//                   out = DB[];
                    //int s1 = Integer.parseInt(line)
                    line = textField.getText();
                    out1.println(line);

                    textField.setText("");
                    line1 = textField1.getText();
//                String s1 = line;
                    int s2 = Integer.parseInt(line1);
                    //int Id_tab = 2;
                    //  textField.setText("");
                    textField1.setText("");
                    //out1.write(line);
                    out.write(s2);
//                    out.write(Id_tab);

//                    System.out.println("Дым: "+s1);
//                    System.out.println("Температура,С: "+s2);
                    System.out.print("s1=" + line + "s2=" + s2);
                    line = "";
                    System.out.print("stroka=" + line );
            
                    out.flush(); // заставляем поток закончить передачу данных. 
                } catch (IOException ex) {
                    Logger.getLogger(Temperature.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    public static void main(String[] args) throws Exception {
        Temperature client = new Temperature();
        client.connectToServer();
    }
}
