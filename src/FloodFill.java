import java.util.HashMap;

/**
 * Problem:
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and newColor.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel,
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all of the aforementioned pixels with newColor.
 *
 * Return the modified image after performing the flood fill.
 *
 * Eg: Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel),
 * all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels)
 * are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 *
 * Link: https://leetcode.com/problems/flood-fill/
 */


class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return floodFill(image, sr, sc, newColor, image[sr][sc]);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor, int currentColor) {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length) {
            return image;
        }
        if (image[sr][sc] == currentColor && image[sr][sc] != newColor) {
            image[sr][sc] = newColor;
            image = floodFill(image, sr + 1, sc, newColor, currentColor);
            image = floodFill(image, sr - 1, sc, newColor, currentColor);
            image = floodFill(image, sr, sc + 1, newColor, currentColor);
            image = floodFill(image, sr, sc - 1, newColor, currentColor);
        }
        return image;
    }
}
