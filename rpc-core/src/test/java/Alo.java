import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 */
public class Alo {
    // 题目描述:小美拿到了一个大小为n的数组，她希望删除一个区间后，使得剩余所有元素的乘积未尾至少有k个0。小美想知道，一共有多少种不同的删除方案?输入:第一行输入两个正整数n,k。第二行输入n个正整数ai，代表小美拿到的数组。
    // 1<=n,k<=10^5
    // 1<=ai<=10^9
    // 输出:一个整数，代表删除的方案数。
    // Scanner scanner = new Scanner(System.in);
    // int n = scanner.nextInt();
    // int k = scanner.nextInt();
    // int[] nums = new int[n];
    // for (int i = 0; i < n; i++) {
    //     nums[i] = scanner.nextInt();
    // }
    // System.out.println(0);
    // return;
    public static void main(String[] args) {

    }

    /*
    import java.util.Scanner;

    public class Main {
        static final int N = 210;
        static int n;
        static char[][] a = new char[N][N];
        static int[][] s = new int[N][N];

        static int query(int x1, int y1, int x2, int y2) {
            return s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1];
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            for (int i = 1; i <= n; i++) {
                String line = scanner.next();
                for (int j = 1; j <= n; j++) {
                    a[i][j] = line.charAt(j - 1);
                }
            }

            for (int i = 1; i <= n; i++)
                for (int j = 1; j <= n; j++) {
                    int value = a[i][j] == '1' ? 1 : 0;
                    s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + value;
                }

            for (int len = 1; len <= n; len++) {
                int cnt = 0;
                for (int x = 1; x <= n - len + 1; x++) {
                    for (int y = 1; y <= n - len + 1; y++) {
                        int sum = query(x, y, x + len - 1, y + len - 1);
                        if (sum * 2 == len * len) {
                            cnt++;
                        }
                    }
                }
                System.out.println(cnt);
            }
        }
    }*/
}
