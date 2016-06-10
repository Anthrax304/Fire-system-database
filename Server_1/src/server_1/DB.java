package server_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DB {

    String s;
    String deckname;
    static Integer readings_temp;
    static String id_detector, readings_smoke, Name_tab;

    DB(String line, Integer rw1, String name, String IP) {
        id_detector = name;
        readings_smoke = line;
        readings_temp = rw1;
        s = IP;
        System.out.println("Имя датчика " + id_detector);

        System.out.print("Adress \t" + s+"\t");

        try {
            File toRead1 = new File("Domen.txt");
            InputStreamReader fis1 = new InputStreamReader(new FileInputStream(toRead1));
            Scanner sc1 = new Scanner(fis1);
            HashMap<String, String> mapInFile = new HashMap<String, String>();

            //read data from file line by line:
            String currentLine;
            while (sc1.hasNextLine()) {
                currentLine = sc1.nextLine();
                //now tokenize the currentLine:
                StringTokenizer st = new StringTokenizer(currentLine, "-", false);
                //put tokens ot currentLine in map
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis1.close();
//            
            //print All data in MAP
            for (Map.Entry<String, String> m : mapInFile.entrySet()) 
            {
                deckname = mapInFile.get(s);

            }
            System.out.println("Имя яруса \t" + deckname);
            //System.out.println(m.getKey() + " : " + m.getValue());

        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if ("Верхняя палуба".equals(deckname)) {

            Name_tab = "upper_deck";

        }
        if ("Батарейная палуба".equals(deckname)) {

            Name_tab = "gun_deck";
        }

        if ("Жилая палуба".equals(deckname)) {

            Name_tab = "residential_deck";
        }
        if ("Трюм".equals(deckname)) {

            Name_tab = "hold_deck";
        }

        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassForNameException");
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:odbc:Tables", "AURORA FIRE ALARM", "Aurora");
            Statement stat = conn.createStatement();
//         

            System.out.println("Таблица:" + Name_tab);
            String ins = "insert into " + Name_tab + "  VALUES ('" + id_detector + "',to_char(sysdate,'dd/mm/yyyy' ),to_char(sysdate,'hh24:mi:ss') ,'" + readings_smoke + "', " + readings_temp + ")";
            stat.execute(ins);
            System.out.println(ins);
            System.out.println(id_detector);
            System.out.print("\t" + id_detector + "\t" + s + "\t  " + readings_smoke + " \t " + readings_temp + "   \n");
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) {

    }

}
