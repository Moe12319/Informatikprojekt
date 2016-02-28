/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hasilein.the.original;

import java.util.Scanner;

/**
 *
 * @author Lea
 */
public class HasileinTheOriginal {

    static String[][] Spielfeld = new String[25][25];
    static boolean hat_gefressen = false;
    static String[][] Speicher_hat_gefressen = new String[25][25];

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
                Spielfeld[i][j] = ".";
            }
        }

        int Hasenanzahl = 25;

        for (int i = 0; i < Hasenanzahl; i++) {
            Spielfeld[(int) (Math.random() * 25)][(int) (Math.random() * 25)] = "H";
        }
        int Fuchsanzahl = 10;

        for (int f = 0; f < Fuchsanzahl; f++) {
            Spielfeld[(int) (Math.random() * 25)][(int) (Math.random() * 25)] = "F";
        }
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
                if (Speicher[i][j].equals("H")) {
                    int Hasenbewegung_Vertikal = (int) (Math.random() * 3);
                    if (Hasenbewegung_Vertikal == 0) {
                        if (i == 24) {
                            Hasenbewegung_Vertikal = 1;
                        } else {
                            if (Spielfeld[i + 1][j].equals("H") || Spielfeld[i + 1][j].equals("F")) {
                                Hasenbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i + 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
                            }
                        }
                    }
                    if (Hasenbewegung_Vertikal == 1) {
                        if (i == 0) {
                            Hasenbewegung_Vertikal = 2;
                        } else {
                            if (Spielfeld[i - 1][j].equals("H") || Spielfeld[i - 1][j].equals("F")) {
                                Hasenbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i - 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
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
                if (Speicher[i][j].equals("H")) {
                    int Hasenbewegung_Horizontal = (int) (Math.random() * 3);
                    if (Hasenbewegung_Horizontal == 0) {
                        if (j == 24) {
                            Hasenbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j + 1].equals("H") || Spielfeld[i][j + 1].equals("F")) {
                                Hasenbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
                            }
                        }
                    }
                    if (Hasenbewegung_Horizontal == 1) {
                        if (j == 0) {
                            Hasenbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j - 1].equals("H") || Spielfeld[i][j - 1].equals("F")) {
                                Hasenbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j - 1] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
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
                if (Speicher[i][j].equals("F")) {
                    if (i != 0 && i != 24 && j != 0 && j != 24) {
                        if (Spielfeld[i + 1][j].equals("H")) {
                            Spielfeld[i + 1][j] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i + 1][j] = "j";
                        } else if (Spielfeld[i - 1][j].equals("H")) {
                            Spielfeld[i - 1][j] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i - 1][j] = "j";
                        } else if (Spielfeld[i][j + 1].equals("H")) {
                            Spielfeld[i][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i][j + 1] = "j";
                        } else if (Spielfeld[i][j - 1].equals("H")) {
                            Spielfeld[i][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i][j - 1] = "j";
                        } else if (Spielfeld[i + 1][j + 1].equals("H")) {
                            Spielfeld[i + 1][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i + 1][j + 1] = "j";
                        } else if (Spielfeld[i + 1][j - 1].equals("H")) {
                            Spielfeld[i + 1][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i + 1][j - 1] = "j";
                        } else if (Spielfeld[i - 1][j + 1].equals("H")) {
                            Spielfeld[i - 1][j + 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i - 1][j + 1] = "j";
                        } else if (Spielfeld[i - 1][j - 1].equals("H")) {
                            Spielfeld[i - 1][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";
                            Speicher_hat_gefressen[i - 1][j - 1] = "j";
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
                if (Speicher[i][j].equals("F") && Speicher_hat_gefressen[i][j].equals("n")) {
                    int Fuchsbewegung_Horizontal = (int) (Math.random() * 3);
                    if (Fuchsbewegung_Horizontal == 0) {
                        if (j == 24) {
                            Fuchsbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j + 1].equals("F")) {
                                Fuchsbewegung_Horizontal = 2;
                            } else {
                                Spielfeld[i][j + 1] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
                            }
                        }
                    }

                    if (Fuchsbewegung_Horizontal == 1) {
                        if (j == 0) {
                            Fuchsbewegung_Horizontal = 2;
                        } else {
                            if (Spielfeld[i][j - 1].equals("F")) {
                                Fuchsbewegung_Horizontal = 2;
                            }
                            Spielfeld[i][j - 1] = Speicher[i][j];
                            Spielfeld[i][j] = ".";

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
                if (Speicher[i][j].equals("F") && Speicher_hat_gefressen[i][j].equals("n")) {
                    int Fuchsbewegung_Vertikal = (int) (Math.random() * 3);
                    if (Fuchsbewegung_Vertikal == 0) {
                        if (i == 24) {
                            Fuchsbewegung_Vertikal = 1;
                        } else {
                            if (Spielfeld[i + 1][j].equals("F")) {
                                Fuchsbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i + 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
                            }
                        }
                    }
                    if (Fuchsbewegung_Vertikal == 1) {
                        if (i == 0) {
                            Fuchsbewegung_Vertikal = 2;
                        } else {
                            if (Spielfeld[i - 1][j].equals("F")) {
                                Fuchsbewegung_Vertikal = 2;
                            } else {
                                Spielfeld[i - 1][j] = Speicher[i][j];
                                Spielfeld[i][j] = ".";
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Spielfeld_Generator();
        Spielfeldausgabe();
        String Neue_Runde;
        boolean Spiel = true;
        int Rundenzähler = 1;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Bitte drücke (n) für eine neue Runde oder (ende) um das spiel zu beenden");
            Neue_Runde = sc.next();
            if (Neue_Runde.equals("n")) {
                Das_Fressen_beginnt();
                Fuchsfressen();
                Fuchsbewegung_Vertikal();
                Fuchsbewegung_Horizontal();
                Hasen_Bewegungvertikal();
                Hasen_Bewegunghorizontal();
                Spielfeldausgabe();
                System.out.println("Runde" + Rundenzähler);
                Rundenzähler++;
            }
            if (Neue_Runde.equals("ende")) {
                Spiel = false;
            }
        } while (Spiel);

    }

}
