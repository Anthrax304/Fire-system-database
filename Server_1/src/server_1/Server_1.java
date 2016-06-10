package server_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Server_1 {

    static String line;
    static TextArea pole1 = new TextArea("Ожидание подключений...\n");
    static TextArea pole2 = new TextArea();
    static String IP;
    static String POI;
    static String ipadress;
  

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

        JFrame window = new JFrame("Пожарная система крейсера Аврора");
        window.setSize(800, 650);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        ImageIcon IMG = new ImageIcon("picture/Fire.png");
        window.setIconImage(IMG.getImage());

        JTabbedPane tp = new JTabbedPane();

        JPanel pn1 = new JPanel();
        JPanel pn2 = new JPanel();
        JPanel pn3 = new JPanel();
        JPanel pn4 = new JPanel();
        JPanel pn5 = new JPanel();
        tp.add(pn1, "Верхняя палуба");
        tp.add(pn2, "Батарейная палуба");
        tp.add(pn3, "Жилая палуба");
        tp.add(pn4, "Трюм");
        tp.add(pn5, "Добавление устройства");
        pn1.setBackground(Color.WHITE);
        pn2.setBackground(Color.WHITE);
        pn3.setBackground(Color.WHITE);
        pn4.setBackground(Color.WHITE);

        JButton button5 = new JButton("Добавить устройства");
        button5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button5.setBackground(Color.RED);
        button5.setForeground(Color.black);

        JPanel data_panel = new JPanel();
        data_panel.setBackground(Color.black);
        data_panel.setLayout(new GridLayout());

        JLabel imageLabel1 = new JLabel(new ImageIcon("picture/verhniaia paluba.jpg"));
        JLabel imageLabel2 = new JLabel(new ImageIcon("picture/batar palub.jpg"));
        JLabel imageLabel3 = new JLabel(new ImageIcon("picture/zhilaia paluba.jpg"));
        JLabel imageLabel4 = new JLabel(new ImageIcon("picture/trum.jpg"));


       

        window.add(tp);
        window.add(data_panel, BorderLayout.PAGE_END);
        data_panel.add(pole1);
        data_panel.add(pole2);
        pn1.add(imageLabel1);
        pn2.add(imageLabel2);
        pn3.add(imageLabel3);
        pn4.add(imageLabel4);
        pn5.add(button5);
         pole1.setEditable(false);
        pole2.setEditable(false);

 
        window.setVisible(true);


        button5.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent e) {
                Domen domen = new Domen();

            }

        });

        //-----------------------------------------------------------------------------------------------------------//
        //                               Подключение                                                                 //
        //-----------------------------------------------------------------------------------------------------------//
        Connect connect = new Connect();
    }
}
