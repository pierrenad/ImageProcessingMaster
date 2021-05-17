/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImageProcessing.NonLineaire;

/**
 *
 * @author Pierre
 */
public class MorphoElementaire {

    public static int[][] erosion(int[][] image, int tailleMasque) {
        int[] P = new int[9];

        int max = 0;
        int width = image.length;
        int height = image[0].length;
        // temporary image not to modify the source image 
        int[][] tmp = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                max = 0;
                // get current pixel and surround pixels 
                try {
                    P[0] = image[i - 1][j - 1];
                    P[1] = image[i - 1][j];
                    P[2] = image[i - 1][j + 1];
                    P[3] = image[i][j - 1];
                    P[4] = image[i][j];
                    P[5] = image[i][j + 1];
                    P[6] = image[i + 1][j - 1];
                    P[7] = image[i + 1][j];
                    P[8] = image[i + 1][j + 1];
                } catch (IndexOutOfBoundsException e) {
                    P[0] = 0;
                    P[1] = 0;
                    P[2] = 0;
                    P[3] = 0;
                    P[4] = image[i][j];
                    P[5] = 0;
                    P[6] = 0;
                    P[7] = 0;
                    P[8] = 0;
                }

                // search for the max value around current pixel
                for (int k = 0; k < 9; k++) {
                    if (P[k] == 255 && k != 4) {
                        max = 255;
                        break;
                    }
                    if (k != 4 && P[k] > max) {
                        max = P[k];
                    }
                }
                tmp[i][j] = max;
            }
        }
        return tmp;
    }

    public static int[][] dilatation(int[][] image, int tailleMasque) {
        int[] P = new int[9];

        int max = 255;
        int width = image.length;
        int height = image[0].length;
        // temporary image not to modify the source image 
        int[][] tmp = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                max = 255;
                // get current pixel and surround pixels 
                try {
                    P[0] = image[i - 1][j - 1];
                    P[1] = image[i - 1][j];
                    P[2] = image[i - 1][j + 1];
                    P[3] = image[i][j - 1];
                    P[4] = image[i][j];
                    P[5] = image[i][j + 1];
                    P[6] = image[i + 1][j - 1];
                    P[7] = image[i + 1][j];
                    P[8] = image[i + 1][j + 1];
                } catch (IndexOutOfBoundsException e) {
                    P[0] = 0;
                    P[1] = 0;
                    P[2] = 0;
                    P[3] = 0;
                    P[4] = image[i][j];
                    P[5] = 0;
                    P[6] = 0;
                    P[7] = 0;
                    P[8] = 0;
                }

                // search for the max value around current pixel
                for (int k = 0; k < 9; k++) {
                    if (P[k] == 0 && k != 4) {
                        max = 0;
                        break;
                    }
                    if (k != 4 && P[k] < max) {
                        max = P[k];
                    }
                }
                tmp[i][j] = max;
            }
        }
        return tmp;
    }

    public static int[][] ouverture(int[][] image, int tailleMasque) {
        int erosion[][] = erosion(image, tailleMasque);
        int tmp[][] = dilatation(erosion, tailleMasque);
        return tmp;
    }

    public static int[][] fermeture(int[][] image, int tailleMasque) {
        int dilatation[][] = dilatation(image, tailleMasque);
        int tmp[][] = erosion(dilatation, tailleMasque);
        return tmp;
    }
}
