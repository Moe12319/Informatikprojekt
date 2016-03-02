/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasilein.the.original;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Moritz
 */
public class HasileinTheOriginal {

    static String[][] Spielfeld = new String[25][25];
    static String[][] Speicher_hat_gefressen = new String[25][25];
    static int Hasenanzahl = 0;
    static boolean Spiel = true;
    static boolean Fuchssetzen = true;
    static int Hunger = 0;
    static String[][] Hunger_Speicher = new String[25][25];
    static int Fuchsanzahl = 5;
    static int[][] Fuchskoordinaten = new int[Fuchsanzahl][2];
    static String[][] Hungerspeicher = new String[25][25];

    public static void Der_Hunger_Kommt() {
        for (int i = 0; i < Hungerspeicher.length; i++) {
            for (int j = 0; j < Hungerspeicher.length; j++) {
                Hungerspeicher[i][j] = "h";
            }
        }
    }
    
    public static void Den_Hungertot_sterben(){
        for(int i=0;i<Spielfeld.length;i++){
            for(int j=0;j<Spielfeld.length;j++){
                if(Spielfeld[i][j] == "  F" && Hungerspeicher[i][j]== "h"){
                    Spielfeld[i][j] = "  .";
                }
            }
        }
    } 

    public static void Das_Fressen_beginnt() {
        for (int i = 0; i < Speicher_hat_gefressen.length; i++) {
            for (int j = 0; j < Speicher_hat_gefressen.length; j++) {
                Speicher_hat_gefressen[i][j] = "n";
            }
        }
    }

    public static void Spielfeld_Generator() {
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                Spielfeld[i][j] = "  .";
            }
        }

        int Hasenanzahl = 25;

        for (int h = 0; h < Hasenanzahl; h++) {
            Spielfeld[(int) (Math.random() * 25)][(int) (Math.random() * 25)] = "  H";
        }

        for (int i = 0; i < Fuchsanzahl; i++) {
            int Fuchs = 1;
            int Fuchsi = (int) (Math.random() * 25);
            int Fuchsj = (int) (Math.random() * 25);
            Spielfeld[Fuchsi][Fuchsj] = "  F";
            Fuchs++;
        }

        Spielfeld[12][12] = "!F!";
    }

    public static void Spielfeldausgabe() {
        for (int i = 0; i < Spielfeld.length; i++) {

            for (int j = 0; j < Spielfeld.length; j++) {
                System.out.print(Spielfeld[i][j]);

            }
            System.out.println();

        }
    }

    public static void Hasen_Bewegungvertikal() {
        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                if (Speicher[i][j].equals("  H")) {
                    int Hasenbewegung_Vertikal = (int) (Math.random() * 3);
                    if (Hasenbewegung_Vertikal == 0) {
                        if (i == 24) {
                            Hasenbewegung_Vertikal = 1;
                        } else {
                            if (Spielfeld[i + 1][j].equals("  H") || Spielfeld[i + 1][j].equals("  F") || Spielfeld[i + 1][j].equals("!F!")) {
                                Hasenbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i + 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                            }
                        }
                    }
                    if (Hasenbewegung_Vertikal == 1) {
                        if (i == 0) {
                            Hasenbewegung_Vertikal = 2;
                        } else {
                            if (Spielfeld[i - 1][j].equals("  H") || Spielfeld[i - 1][j].equals("  F") || Spielfeld[i - 1][j].equals("!F!")) {
                                Hasenbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i - 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                            }
                        }
                    }
                    if (Hasenbewegung_Vertikal == 2) {
                        Spielfeld[i][j] = Speicher[i][j];
                    }
                }
            }
        }
    }

    public static void Hasen_Bewegunghorizontal() {
        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                if (Speicher[i][j].equals("  H")) {
                    int Hasenbewegung_Horizontal = (int) (Math.random() * 3);
                    if (Hasenbewegung_Horizontal == 0) {
                        if (j == 24) {
                            Hasenbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j + 1].equals("  H") || Spielfeld[i][j + 1].equals("  F") || Spielfeld[i][j + 1].equals("!F!")) {
                                Hasenbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                            }
                        }
                    }
                    if (Hasenbewegung_Horizontal == 1) {
                        if (j == 0) {
                            Hasenbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j - 1].equals("  H") || Spielfeld[i][j - 1].equals("  F") || Spielfeld[i][j - 1].equals("!F!")) {
                                Hasenbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                            }
                        }
                    }
                    if (Hasenbewegung_Horizontal == 2) {
                        Spielfeld[i][j] = Speicher[i][j];
                    }
                }
            }
        }
    }

    public static void Fuchsfressen() {

        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                if (Speicher[i][j].equals("  F")) {
                    if (i != 0 && i != 24 && j != 0 && j != 24) {
                        if (Spielfeld[i + 1][j].equals("  H")) {
                            Spielfeld[i + 1][j] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i + 1][j] = "j";
                            Hungerspeicher[i + 1][j] = "s";
                        } else if (Spielfeld[i - 1][j].equals("  H")) {
                            Spielfeld[i - 1][j] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i - 1][j] = "j";
                            Hungerspeicher[i - 1][j] = "s";
                        } else if (Spielfeld[i][j + 1].equals("  H")) {
                            Spielfeld[i][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i][j + 1] = "j";
                            Hungerspeicher[i][j + 1] = "s";
                        } else if (Spielfeld[i][j - 1].equals("  H")) {
                            Spielfeld[i][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i][j - 1] = "j";
                            Hungerspeicher[i][j - 1] = "s";
                        } else if (Spielfeld[i + 1][j + 1].equals("  H")) {
                            Spielfeld[i + 1][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i + 1][j + 1] = "j";
                            Hungerspeicher[i + 1][j + 1] = "s";
                        } else if (Spielfeld[i + 1][j - 1].equals("  H")) {
                            Spielfeld[i + 1][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i + 1][j - 1] = "j";
                            Hungerspeicher[i + 1][j - 1] = "s";
                        } else if (Spielfeld[i - 1][j + 1].equals("  H")) {
                            Spielfeld[i - 1][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i - 1][j + 1] = "j";
                            Hungerspeicher[i - 1][j + 1] = "s";
                        } else if (Spielfeld[i - 1][j - 1].equals("  H")) {
                            Spielfeld[i - 1][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                            Speicher_hat_gefressen[i - 1][j - 1] = "j";
                            Hungerspeicher[i - 1][j - 1] = "s";
                        }
                    } else {
                        if (i == 0 && j != 0 && j != 24) {
                            if (Spielfeld[i + 1][j].equals("  H")) {
                                Spielfeld[i + 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i + 1][j] = "j";
                                Hungerspeicher[i + 1][j] = "s";
                            }
                            if (Spielfeld[i + 1][j + 1].equals("  H")) {
                                Spielfeld[i + 1][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i + 1][j + 1] = "j";
                                Hungerspeicher[i + 1][j + 1] = "s";
                            }
                            if (Spielfeld[i + 1][j - 1].equals("  H")) {
                                Spielfeld[i + 1][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i + 1][j - 1] = "j";
                                Hungerspeicher[i + 1][j - 1] = "s";
                            }
                        } else if (i == 24 && j != 0 && j != 24) {
                            if (Spielfeld[i - 1][j].equals("  H")) {
                                Spielfeld[i - 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i - 1][j] = "j";
                                Hungerspeicher[i - 1][j] = "s";
                            }
                            if (Spielfeld[i - 1][j + 1].equals("  H")) {
                                Spielfeld[i - 1][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i - 1][j + 1] = "j";
                                Hungerspeicher[i - 1][j + 1] = "s";
                            }
                            if (Spielfeld[i - 1][j - 1].equals("  H")) {
                                Spielfeld[i - 1][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i - 1][j - 1] = "j";
                                Hungerspeicher[i - 1][j - 1] = "s";
                            }
                        } else if (j == 0 && i != 0 && i != 24) {
                            if (Spielfeld[i][j + 1].equals("  H")) {
                                Spielfeld[i][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i][j + 1] = "j";
                                Hungerspeicher[i][j + 1] = "s";
                            }
                            if (Spielfeld[i + 1][j + 1].equals("  H")) {
                                Spielfeld[i + 1][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i + 1][j + 1] = "j";
                                Hungerspeicher[i + 1][j + 1] = "s";
                            }
                            if (Spielfeld[i - 1][j + 1].equals("  H")) {
                                Spielfeld[i - 1][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i - 1][j + 1] = "j";
                                Hungerspeicher[i - 1][j + 1] = "s";
                            }
                        } else if (j == 24 && i != 0 && i != 24) {
                            if (Spielfeld[i][j - 1].equals("  H")) {
                                Spielfeld[i][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i][j - 1] = "j";
                                Hungerspeicher[i][j - 1] = "s";
                            }
                            if (Spielfeld[i + 1][j - 1].equals("  H")) {
                                Spielfeld[i + 1][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i + 1][j - 1] = "j";
                                Hungerspeicher[i + 1][j - 1] = "s";
                            }
                            if (Spielfeld[i - 1][j - 1].equals("  H")) {
                                Spielfeld[i - 1][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                Speicher_hat_gefressen[i - 1][j - 1] = "j";
                                Hungerspeicher[i - 1][j - 1] = "s";
                            }
                        }
                    }
                }
            }
        }
    }

    public static void Fuchsbewegung_Horizontal() {
        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                if (Speicher[i][j].equals("  F") && Speicher_hat_gefressen[i][j].equals("n")) {
                    int Fuchsbewegung_Horizontal = (int) (Math.random() * 3);
                    if (Fuchsbewegung_Horizontal == 0) {
                        if (j == 24) {
                            Fuchsbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j + 1].equals("  F") || Spielfeld[i][j + 1].equals("!F!")) {
                                Fuchsbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                if (Hungerspeicher[i][j] == "s") {
                                    Hungerspeicher[i][j + 1] = "s";
                                    Hungerspeicher[i][j] = "h";
                                }
                            }
                        }
                    }

                    if (Fuchsbewegung_Horizontal == 1) {
                        if (j == 0) {
                            Fuchsbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j - 1].equals("  F") || Spielfeld[i][j - 1].equals("!F!")) {
                                Fuchsbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                 if (Hungerspeicher[i][j] == "s") {
                                    Hungerspeicher[i][j - 1] = "s";
                                    Hungerspeicher[i][j] = "h";
                                 }
                            }

                        }
                    }
                    if (Fuchsbewegung_Horizontal == 2) {
                        Spielfeld[i][j] = Speicher[i][j];
                    }
                }
            }
        }
    }

    public static void Fuchsbewegung_Vertikal() {
        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                if (Speicher[i][j].equals("  F") && Speicher_hat_gefressen[i][j].equals("n")) {
                    int Fuchsbewegung_Vertikal = (int) (Math.random() * 3);
                    if (Fuchsbewegung_Vertikal == 0) {
                        if (i == 24) {
                            Fuchsbewegung_Vertikal = 1;
                        } else {
                            if (Spielfeld[i + 1][j].equals("  F") || Spielfeld[i + 1][j].equals("!F!")) {
                                Fuchsbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i + 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                  if (Hungerspeicher[i][j] == "s") {
                                    Hungerspeicher[i + 1][j] = "s";
                                    Hungerspeicher[i][j] = "h";
                                 }
                            }
                        }
                    }
                    if (Fuchsbewegung_Vertikal == 1) {
                        if (i == 0) {
                            Fuchsbewegung_Vertikal = 2;
                        } else {
                            if (Spielfeld[i - 1][j].equals("  F") || Speicher[i - 1][j].equals("!F!")) {
                                Fuchsbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i - 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = "  .";
                                 if (Hungerspeicher[i][j] == "s") {
                                    Hungerspeicher[i - 1][j] = "s";
                                    Hungerspeicher[i][j] = "h";
                                 }
                            }
                        }
                    }
                    if (Fuchsbewegung_Vertikal == 2) {
                        Spielfeld[i][j] = Speicher[i][j];
                    }

                }
            }
        }
    }

    public static void Spielerbewegung() {
        boolean Deine_Runde = true;
        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        Scanner sc = new Scanner(System.in);
        do {
            for (int i = 0; i < Speicher.length; i++) {
                for (int j = 0; j < Speicher.length; j++) {
                    if (Speicher[i][j].equals("!F!")) {
                        System.out.println("Steuere deinen Fuchs mit w a s d wohin du möchtest du kannst mit (warten) warten mit f kannst du !ein! mal einen fuchs über dich setzen!"
                                + "aber achte darauf nicht aus dem Spielfeld zu laufen!!"
                                + "mit doppeltem buchstaben sprintest du!");
                        String Spielerbewegung = sc.next();
                        if (Spielerbewegung.equals("w")) {
                            Spielfeld[i - 1][j] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("a")) {
                            Spielfeld[i][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("s")) {
                            Spielfeld[i + 1][j] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("d")) {
                            Spielfeld[i][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("ww")) {
                            Spielfeld[i - 5][j] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("aa")) {
                            Spielfeld[i][j - 5] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("ss")) {
                            Spielfeld[i + 5][j] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("dd")) {
                            Spielfeld[i][j + 5] = Speicher[i][j];
                            Spielfeld[i][j] = "  .";
                        }
                        if (Spielerbewegung.equals("warten")) {
                            Deine_Runde = false;
                        }
                        if (Spielerbewegung.equals("f") && Fuchssetzen) {
                            Spielfeld[i - 1][j] = "  F";
                            Fuchssetzen = false;
                        }
                        Deine_Runde = false;
                    }
                }
            }
        } while (Deine_Runde);
    }

    public static void Platzhalter() {
        System.out.println(""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + ""
                + "");
    }

    public static void Hasenzähler() {
        Hasenanzahl = 0;
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {
                if (Spielfeld[i][j].equals("  H")) {
                    Hasenanzahl++;
                }
            }
        }
        System.out.println(Hasenanzahl + " Hasen");
    }

    public static void Hasenvermehrung() {
        String[][] Speicher = new String[25][25];
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                Speicher[i][j] = Spielfeld[i][j];
            }
        }
        for (int i = 0; i < Speicher.length; i++) {
            for (int j = 0; j < Speicher.length; j++) {
                if (i != 0 && i != 24) {
                    if (Speicher[i][j] == "  H" && Speicher[i + 1][j] == "  H" && j != 24) {
                        if (Spielfeld[i][j + 1] != "  F" && Spielfeld[i + 1][j + 1] != "!F!" && j != 24) {
                            Spielfeld[i][j + 1] = "  H";
                            Spielfeld[i + 1][j + 1] = "  H";
                        }
                    }
                    if (Speicher[i][j] == "  H" && Speicher[i - 1][j] == "  H" && j != 24) {
                        if (Spielfeld[i][j + 1] != "  F" && Spielfeld[i - 1][j + 1] != "!F!" && j != 24) {
                            Spielfeld[i][j + 1] = "  H";
                            Spielfeld[i - 1][j + 1] = "  H";
                        }
                    }
                }
            }
        }
    }

    public static void Hunger() {
        for (int i = 0; i < Spielfeld.length; i++) {
            for (int j = 0; j < Spielfeld.length; j++) {

            }

        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*ArrayList<Point> arl = new ArrayList<Point>();
       
         int x1=4;
         int y1=5;
         arl.add(new Point(x1,y1));
         arl.add(new Point(1,3));
         arl.add(new Point(2,3));

         for(int i=0; i<arl.size(); i++)
         {
         System.out.println(arl.get(i).x +" "+arl.get(i).y );
            
            
         }
         for(int i=0; i<arl.size(); i++)
         {
            
         if(arl.get(i).x == 4)
         arl.remove(i);
         }
         System.out.println("Test");
         for(int i=0; i<arl.size(); i++)
         {

         System.out.println(arl.get(i).x +" "+arl.get(i).y );
            
           
         }*/
        Spielfeld_Generator();
        String Neue_Runde;
        int Rundenzähler = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Bitte drücke (n) für eine neue Runde oder (ende) um das spiel zu beenden");
            Neue_Runde = sc.next();
            if (Neue_Runde.equals("n")) {
                Das_Fressen_beginnt();
                Der_Hunger_Kommt();
                Platzhalter();
                Spielfeldausgabe();
                Spielerbewegung();
                Platzhalter();
                Spielfeldausgabe();
                Spielerbewegung();
                Platzhalter();
                Spielfeldausgabe();
                Spielerbewegung();
                Spielfeldausgabe();
                Platzhalter();
                Fuchsfressen();
                Fuchsbewegung_Vertikal();
                Fuchsbewegung_Horizontal();
                Das_Fressen_beginnt();
                Fuchsfressen();
                Fuchsbewegung_Vertikal();
                Fuchsbewegung_Horizontal();
                Das_Fressen_beginnt();
                Fuchsfressen();
                Fuchsbewegung_Vertikal();
                Fuchsbewegung_Horizontal();
                Das_Fressen_beginnt();
                Fuchsfressen();
                Fuchsbewegung_Vertikal();
                Fuchsbewegung_Horizontal();
                Das_Fressen_beginnt();
                Fuchsfressen();
                Fuchsbewegung_Vertikal();
                Fuchsbewegung_Horizontal();
                Den_Hungertot_sterben();
                Hasenvermehrung();
                Hasen_Bewegungvertikal();
                Hasen_Bewegunghorizontal();
                Spielfeldausgabe();
                Hasenzähler();
                Rundenzähler++;
                System.out.println("Runde" + Rundenzähler);

                if (Hasenanzahl == 0) {
                    System.out.println("Herzlichen Glückwunsch!! Du hast nach " + Rundenzähler + " Runden Gewonnen!");
                    Spiel = false;

                }
            }
            if (Neue_Runde.equals("ende")) {
                Spiel = false;
            }
        } while (Spiel);

    }

}
