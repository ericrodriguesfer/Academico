public class Questao06 {
    static int fun(int k) {
        k += 4;
        return 3 * (k) - 1;
    }
    
    public static void main (String [] args) {
        int i = 10, j = 10, sum1, sum2;
    
        sum1 = (i / 2) + fun(i);
        sum2 = fun(j) + (j / 2);

        System.out.println("sum 1: " + sum1);
        System.out.println("sum 2: " + sum2);
    }
}