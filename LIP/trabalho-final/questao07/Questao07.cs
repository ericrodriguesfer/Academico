using System;

namespace Questao07 {
    public class Program {
        public static void Main (String [] args) {
            int n = 10;
            int[,] x = new int[n][n] {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                     {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (x[i][j] == 0) {
                        Console.WriteLine("First all-zero row is: " + i);
                    }

                    break;
                }
            }
        }
    }
}