import cn.hutool.core.util.ArrayUtil;
import org.junit.Test;

import java.math.BigInteger;
import java.util.*;


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
    // public static void main(String[] args) {
    //
    // }

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

    // 游游拿到了一个数组，她可以进行最多一次操作：选择一个元素全是偶数的区间，使这个区间所有元素除以2。
    // 游游希望最终所有元素之和尽可能大，你能帮帮她吗？
    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int n = in.nextInt();
    //     // int m = in.nextInt();
    //     int[] a = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         a[i] = in.nextInt();
    //     }
    //     int left = 0, right = 0;
    //     LinkedList<Integer> windows = new LinkedList<>();
    //     Integer ans = Integer.MIN_VALUE;
    //     while (right < n) {
    //         windows.push(a[right]);
    //         right++;
    //         if (isOu(windows)) {
    //             int res = 0;
    //             for (int i = 0; i < left; i++) {
    //                 res += a[i];
    //             }
    //             res += sum(windows);
    //             for (int i = right + 1; i < n; i++) {
    //                 res += a[i];
    //             }
    //             res = Math.max(ans, res);
    //         } else {
    //             while (!isOu(windows) && left < right) {
    //                 windows.removeFirst();
    //                 left++;
    //
    //             }
    //         }
    //     }
    //     System.out.println(ans);
    // }



    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int n = in.nextInt();
    //     // int m = in.nextInt();
    //     int[] a = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         a[i] = in.nextInt();
    //     }
    //     int[] dp = new int[n];
    //     int[] index = new int[n];
    //     for(int i = 0; i < n; i++){
    //         if(a[i] % 2 == 0 && a[i - 1] % 2 == 0){
    //             // dp[i] = dp[i - 1] + 1;
    //             // index[i] = i - 1;
    //             dp(a, dp, index, i);
    //             // LinkedList<Integer> windows = new LinkedList<>();
    //             // for(int j = index[i - 1]; j <= i; j++) {
    //             //     windows.add(a[j]);
    //             // }
    //             // int res = 0;
    //             // for (int k = 0; k < index[i - 1]; k++) {
    //             //     res += a[k];
    //             // }
    //             // res += sum(windows);
    //             // for (int k = i + 1; k < n; k++) {
    //             //     res += a[i];
    //             // }
    //             // boolean b = dp[i - 1] > res;
    //             // dp[i] = Math.max(dp[i - 1], res);
    //             // if(b) {
    //             //     index[i] = index[i - 1];
    //             // } else {
    //             //     index[i] = i;
    //             // }
    //         }else if(a[i] % 2 == 0){
    //             // dp[i] = dp[i - 1];
    //             // index[i] = i;
    //             int res = 0;
    //             for(int i1 = 0; i < n; i1++) {
    //                 res += a[i1];
    //             }
    //             res = res - a[i];
    //             res += a[i] / 2;
    //             dp[i] = res;
    //         } else {
    //             dp[i] = dp[i - 1];
    //         }
    //     }
    //
    // }

    // public static void main(String[] args) {
    //     Scanner in = new Scanner(System.in);
    //     int n = in.nextInt();
    //     // int m = in.nextInt();
    //     int[] a = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         a[i] = in.nextInt();
    //     }
    //     BigInteger
    //     for(int i = 0; i < n; i++){
    //         for(int j = i; j < n; j++){
    //             LinkedList<Integer> windows = new LinkedList<>();
    //             for(int k = i; k <= j; k++) {
    //                 windows.add(a[k]);
    //             }
    //         }
    //     }
    // }

    public static void dp(int[] a, int[] dp, int[] index, int i) {
        BigInteger sqrt = sqrt(BigInteger.valueOf(1));
        LinkedList<Integer> windows = new LinkedList<>();
        for(int j = index[i - 1]; j <= i; j++) {
            windows.add(a[j]);
        }
        int res = 0;
        for (int k = 0; k < index[i - 1]; k++) {
            res += a[k];
        }
        res += sum(windows);
        for (int k = i + 1; k < a.length; k++) {
            res += a[i];
        }
        boolean b = res > dp[i - 1];
        dp[i] = Math.max(dp[i - 1], res);
        if(b) {
            index[i] = index[i - 1];
        } else {
            index[i] = i;
        }
    }

    // 判断集合是否全是偶数
    public static boolean isOu(LinkedList<Integer> windows) {
        return windows.stream().allMatch(x -> x % 2 == 0);
    }

    // 返回集合当中所有数除以2的和
    public static int sum(LinkedList<Integer> windows) {
        int res = 0;
        for (Integer integer : windows) {
            res += integer / 2;
        }
        return res;
    }

    @Test
    public void test() {
        System.out.println(-4 % 2);
    }

    // public static BigInteger sqrt(BigInteger x) {
    //     BigInteger lo = BigInteger.ZERO;
    //     BigInteger hi = x.divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
    //     while(lo.compareTo(hi) <= 0) {
    //         BigInteger mid = lo.add(hi).divide(BigInteger.valueOf(2));
    //         if(mid.multiply(mid).compareTo(x) <= 0) {
    //             lo = mid.add(BigInteger.ONE);
    //         }
    //         else {
    //             hi = mid;
    //         }
    //     }
    //     return lo.subtract(BigInteger.ONE);
    // }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // int n = in.nextInt();
        // // int m = in.nextInt();
        // int[] a = new int[n];
        // for (int i = 0; i < n; i++) {
        //     a[i] = in.nextInt();
        // }
        int[] a = new int[]{1, 2, 3};
        int result = countFactor(a);
        System.out.println(result);
    }

    public static int countFactor(int[] nums) {
        BigInteger product = BigInteger.ONE;
        for(int n : nums) {
            product = product.multiply(factorial(n));
        }
        return countFactors(product);
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for(int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static int countFactors(BigInteger num) {
        int count = 0;
        BigInteger sqrt = sqrt(num);
        for(BigInteger i = BigInteger.ONE; i.compareTo(sqrt) <= 0; i = i.add(BigInteger.ONE)) {
            if(num.mod(i).equals(BigInteger.ZERO)) {
                count++;
                if(!i.equals(num.divide(i))) {
                    count++;
                }
            }

        }
        return count;
    }

    public static BigInteger sqrt(BigInteger x) {
        BigInteger lo = BigInteger.ZERO;
        BigInteger hi = x.divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
        while(lo.compareTo(hi) <= 0) {
            BigInteger mid = lo.add(hi).divide(BigInteger.valueOf(2));
            if(mid.multiply(mid).compareTo(x) <= 0) {
                lo = mid.add(BigInteger.ONE);
            }
            else {
                hi = mid;
            }
        }
        return lo.subtract(BigInteger.ONE);
    }
}
