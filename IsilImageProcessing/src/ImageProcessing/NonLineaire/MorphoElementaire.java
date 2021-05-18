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
        int[] P = new int[tailleMasque * tailleMasque];
        int pix = 0;

        int max = 0;
        int width = image.length;
        int height = image[0].length;
        // temporary image not to modify the source image 
        int[][] tmp = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                max = 0;
                pix = 0;
                // get current pixel and surround pixels 
                try {
                    for (int l = tailleMasque / 2; l >= -tailleMasque / 2; l--) {
                        for (int m = tailleMasque / 2; m >= -tailleMasque / 2; m--, pix++) {
                            P[pix] = image[i - l][j - m];
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    pix = 0;
                    for (int l = tailleMasque / 2; l > -tailleMasque / 2; l--) {
                        for (int m = tailleMasque / 2; m > -tailleMasque / 2; m--, pix++) {
                            if (pix == tailleMasque + 1) {
                                P[pix] = image[i][j];
                            } else {
                                P[pix] = 0;
                            }
                        }
                    }
                }

                // search for the max value around current pixel
                for (int k = 0; k < tailleMasque * tailleMasque; k++) {
                    if (P[k] == 255 && k != tailleMasque + 1) {
                        max = 255;
                        break;
                    }
                    if (k != tailleMasque + 1 && P[k] > max) {
                        max = P[k];
                    }
                }
                tmp[i][j] = max;
            }
        }
        return tmp;
    }

    public static int[][] dilatation(int[][] image, int tailleMasque) {
        int[] P = new int[tailleMasque * tailleMasque];
        int pix = 0;

        int max = 255;
        int width = image.length;
        int height = image[0].length;
        // temporary image not to modify the source image 
        int[][] tmp = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                max = 255;
                pix = 0;
                // get current pixel and surround pixels 
                try {
                    for (int l = tailleMasque / 2; l >= -tailleMasque / 2; l--) {
                        for (int m = tailleMasque / 2; m >= -tailleMasque / 2; m--, pix++) {
                            P[pix] = image[i - l][j - m];
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    pix = 0;
                    for (int l = tailleMasque / 2; l > -tailleMasque / 2; l--) {
                        for (int m = tailleMasque / 2; m > -tailleMasque / 2; m--, pix++) {
                            if (pix == tailleMasque + 1) {
                                P[pix] = image[i][j];
                            } else {
                                P[pix] = 0;
                            }
                        }
                    }
                }

                // search for the max value around current pixel
                for (int k = 0; k < tailleMasque * tailleMasque; k++) {
                    if (P[k] == 0 && k != tailleMasque + 1) {
                        max = 0;
                        break;
                    }
                    if (k != tailleMasque + 1 && P[k] < max) {
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
