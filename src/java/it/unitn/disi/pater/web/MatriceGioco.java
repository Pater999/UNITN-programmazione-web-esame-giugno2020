package it.unitn.disi.pater.web;
import java.util.Random;

public class MatriceGioco {

    private int[][] matrice;

    public MatriceGioco() {
        this.matrice = new int[9][9];
        generaBombe();
        completaMatrice();
    }

    private void generaBombe() {
        Random rnd = new Random();
        int i = 0;
        int n, r, c;
        while (i < 10) {
            n = rnd.nextInt(81);
            r = n / 9;
            c = n % 9;

            if (this.matrice[r][c] != -1) {
                this.matrice[r][c] = -1;
                i++;
            }
        }
    }
    
    public int getValore(int riga, int colonna) {
        return matrice[riga][colonna];
    }

    private void completaMatrice() {
        int somma;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (matrice[i][j] != -1) {
                    somma = 0;
                    if (i - 1 >= 0) {
                        if (this.matrice[i - 1][j] == -1) {
                            somma++;
                        }
                        if (j - 1 >= 0 && this.matrice[i - 1][j - 1] == -1) {
                            somma++;
                        }
                        if (j + 1 < 9 && this.matrice[i - 1][j + 1] == -1) {
                            somma++;
                        }
                    }
                    if (j - 1 >= 0) {
                        if (this.matrice[i][j - 1] == -1) {
                            somma++;
                        }
                    }
                    if (i + 1 < 9) {
                        if (this.matrice[i + 1][j] == -1) {
                            somma++;
                        }
                        if (j - 1 >= 0 && this.matrice[i + 1][j - 1] == -1) {
                            somma++;
                        }
                        if (j + 1 < 9 && this.matrice[i + 1][j + 1] == -1) {
                            somma++;
                        }
                    }
                    if (j + 1 < 9) {
                        if (this.matrice[i][j + 1] == -1) {
                            somma++;
                        }
                    }
                    this.matrice[i][j] = somma;
                }
            }
        }
    }

}
