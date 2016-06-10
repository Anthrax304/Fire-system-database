/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class Domen {

    static Object Server_1;

    public Domen() {
        JFrame window = new JFrame("Добавление датчика");
        window.setSize(220, 170);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setLayout(new GridBagLayout());
        final JTextField tf1 = new JTextField(10), tf2 = new JTextField(10);
        JLabel l = new JLabel("Выберите палубу");
        JLabel l1 = new JLabel("Введите IP адрес");
        JLabel l2 = new JLabel("Введите именной идентификатор");
        JButton save = new JButton("Добавить");
        final String item1 = "Верхняя палуба";
        final String item2 = "Батарейная палуба";
        final String item3 = "Жилая палуба";
        final String item4 = "Трюм";
        String[] items = {item1, item2, item3, item4};
        final JComboBox box = new JComboBox(items);
        Container container = window.getContentPane();
        container.add(box);

        window.add(l, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));//добавление лейбла "Выберите палубу"
        window.add(l1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));//добавление лейбла "Введите IP адрес"
        window.add(l2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));//добавление лейбла "Введите именной идентификатор"
        window.add(box, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0)); //добавляем 1-е поле
        window.add(tf1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0)); //добавляем 2-е поле
        window.add(tf2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0)); //добавляем 3-е поле
        window.add(save, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.9, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(1, 2, 3, 4), 0, 0));
        window.pack();

        save.addActionListener(new ActionListener() {               //кнопка сохранения в файл
            @Override
            public void actionPerformed(ActionEvent e) {
                HashMap<String, String> mapw = new HashMap<String, String>();
                HashMap<String, String> maps = new HashMap<String, String>();
                String IPs = tf1.getText();
                String POI = tf2.getText();
                System.out.println(box.getSelectedItem().toString());
                String sdeck = box.getSelectedItem().toString();
                try {

                    mapw.put(IPs, POI);
                    FileOutputStream f = new FileOutputStream(box.getSelectedItem().toString() + ".txt", true);
                    PrintWriter s = new PrintWriter(f);

                    for (Map.Entry<String, String> m : mapw.entrySet()) {
                        s.println(m.getKey() + "-" + m.getValue());
                    }
                    s.flush();
                    s.close();
                    f.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    maps.put(IPs, sdeck);
                    FileOutputStream f1 = new FileOutputStream("Domen.txt", true);
                    PrintWriter s1 = new PrintWriter(f1);

                    for (Map.Entry<String, String> m1 : maps.entrySet()) {
                        s1.println(m1.getKey() + "-" + m1.getValue());
                        s1.flush();
                        s1.close();
                        f1.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }      
            }

        });

    }

}
