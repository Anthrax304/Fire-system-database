/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Compare {


    String name;
    String  s;
    public void method1(HashMap<String, String> map) {

    }

    Compare(String IP) {
        s = IP;

        try {
            File toRead1 = new File("Верхняя палуба.txt");
            File toRead2 = new File("Батарейная палуба.txt");
            File toRead3 = new File("Жилая палуба.txt");
            File toRead4 = new File("Трюм.txt");
            FileInputStream fis1 = new FileInputStream(toRead1);
            FileInputStream fis2 = new FileInputStream(toRead2);
            FileInputStream fis3 = new FileInputStream(toRead3);
            FileInputStream fis4 = new FileInputStream(toRead4);
            Scanner sc1 = new Scanner(fis1);
            Scanner sc2 = new Scanner(fis2);
            Scanner sc3 = new Scanner(fis3);
            Scanner sc4 = new Scanner(fis4);

            HashMap<String, String> mapInFile = new HashMap<String, String>();
            String currentLine;
            while (sc1.hasNextLine()) {
                currentLine = sc1.nextLine();
                StringTokenizer st = new StringTokenizer(currentLine, "-", false);
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis1.close();
            while (sc2.hasNextLine()) {
                currentLine = sc2.nextLine();
                StringTokenizer st = new StringTokenizer(currentLine, "-", false);
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis2.close();
            while (sc3.hasNextLine()) {
                currentLine = sc3.nextLine();
                StringTokenizer st = new StringTokenizer(currentLine, "-", false);
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis3.close();
            while (sc4.hasNextLine()) {
                currentLine = sc4.nextLine();
                StringTokenizer st = new StringTokenizer(currentLine, "-", false);
                mapInFile.put(st.nextToken(), st.nextToken());
            }
            fis4.close();
            for (Map.Entry<String, String> m : mapInFile.entrySet()) {
                name = mapInFile.get(s);
            }
        } catch (Exception e) {e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {

    }

}
