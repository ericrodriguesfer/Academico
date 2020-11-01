using System;

namespace Questao06 {
    public class Program {
        static int fun(ref int k) {
            k += 4;
            return 3 * (k) - 1;
        }
        public static void Main (String [] args) {
            int i = 10, j = 10, sum1, sum2;
    
            sum1 = (i / 2) + fun(ref i);
            sum2 = fun(ref j) + (j / 2);

            Console.WriteLine("sum 1: " + sum1);
            Console.WriteLine("sum 2: " + sum2);
        }
    }
}