/*
 * Histogramme.java
 *
 * Created on 23 septembre 2007, 20:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package ImageProcessing.Histogramme;

/**
 *
 * @author Jean-Marc
 */
public class Histogramme {

    public static int[] Histogramme256(int mat[][]) {
        int M = mat.length;
        int N = mat[0].length;
        int histo[] = new int[256];

        for (int i = 0; i < 256; i++) {
            histo[i] = 0;
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if ((mat[i][j] >= 0) && (mat[i][j] <= 255)) {
                    histo[mat[i][j]]++;
                }
            }
        }

        return histo;
    }

    // ETAPE 3 - part 1
    public static int minimum(int[][] image) {

        return 0;
    }

    public static int maximum(int[][] image) {

        return 0;
    }

    public static int luminance(int[][] image) {

        return 0;
    }

    public static double contraste1(int[][] image) {

        return 0;
    }

    public static double contraste2(int[][] image) {

        return 0;
    }

    // ETAPE 3 - part 2
    public static int[][] rehaussement(int[][] image, int[] courbeTonale) {

        return null;
    }

    public static int[] creeCourbeTonaleLineaireSaturation(int smin, int smax) {

        return null;
    }

    public static int[] creeCourbeTonaleGamma(double gamma) {

        return null;
    }

    public static int[] creeCourbeTonaleNegatif() {

        return null;
    }

    public static int[] creeCourbeTonaleEgalisation(int[][] image) {

        return null;
    }
}
