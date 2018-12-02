package NearbyElements;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a number for x: ");
        int x = reader.nextInt();

        System.out.println("Enter a number for y: ");
        int y = reader.nextInt();

        System.out.println("Enter a number for range: ");
        int range = reader.nextInt();
        reader.close();

        DataHandler results = new DataHandler();
        String stuff = Arrays.toString(results.nearby(x, y, range));
        System.out.println(stuff);
    }

}

class DataHandler {

    int[] nearby(int x, int y, int range){
        int[][] multiArray = multi;
        if (x > multiArray.length-1) {
            System.out.println("Wrong initial data");
            int[] values = new int[0];
            return values;
        } else if (y > multiArray[x].length-1) {
            System.out.println("Wrong initial data");
            int[] values = new int[0];
            return values;
        }
        int yMin;
        if (y < range){
            yMin = 0;
        } else {
            yMin = y - range;
        }
        int yMax;
        if (y + range >= multiArray[x].length){
            yMax = multiArray[x].length-1;
        } else {
            yMax = y + range;
        }
        int[] values = new int[yMax-yMin];
        for (int i = 0; i < yMax-yMin; i++) {
            if (yMin+i >= y){
                values[i] = multiArray[x][yMin+i+1];
            } else {
                values[i] = multiArray[x][yMin+i];
            }
        }
        return values;
    }

    private int[][] multi = new int[][]{
            { 2, 0, 4, 1241, 12, 5, 11, 1110, -42, 424, 1, 12323 },
            { 1, 3, 5, 7 },
            { 321, 320, 32, 3, 41241, -11, -12, -13, -66, -688 }
    };

}
