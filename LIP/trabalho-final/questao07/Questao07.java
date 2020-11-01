public class Questao07 {
    
    public static void main (String [] args) {
        int n = 10;
        int x[][] = new int [10][10];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                x[i][j] = 0;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i][j] == 0) {
                    System.out.println("First all-zero row is: " + i);
                }

                break;
            }
        }
    }
}