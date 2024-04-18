import java.util.*;

/**
 *
 */
public class Demo {

    static int df = -1;
    static TreeSet<Integer> rSet = new TreeSet<>();
    static TreeSet<Integer> eSet = new TreeSet<>();
    static TreeSet<Integer> dSet = new TreeSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入一个字符串，找出包含'r'和'e'并且不包含'd'的连续字串
        String str = in.next();
        System.out.println(solution(str));
        // HashSet<Character> windows = new HashSet<>();
        // int left = 0, right = 0;
        // int count = 0;
        // int valid = 0;
        // while (right < str.length()) {
        //     char c = str.charAt(right);
        //     right++;
        //     if (c == 'r' || c == 'e') {
        //         if(!windows.contains(c)) {
        //             windows.add(c);
        //             valid++;
        //
        //         }
        //     } else if(c == 'd') {
        //         while(windows.contains(c) && left < right) {
        //             Character d = str.charAt(left);
        //             if(d == 'r' || d == 'e') {
        //                 valid--;
        //             }
        //             windows.remove(d);
        //             left++;
        //         }
        //     }
        //     count += valid == 2 ? 1 : 0;
        // }
        // System.out.println(count);

    }

    public static int solution(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'r')  {
                rSet.add(i);
            } else if (ch == 'e') {
                eSet.add(i);
            } else if (ch == 'd') {
                dSet.add(i);
            }

        }
        int ans = 1;
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if(ch == 'd') {
                df = j;
                continue;
            }
            ans += len(ch == 'r' ? eSet : rSet, dSet, j, s.length());
        }
        return ans;
    }

    private static int len(TreeSet<Integer> integers, TreeSet<Integer> dSet, int j, int length) {
        Integer ei = integers.ceiling(j + 1);
        int ans = 0;
        if(ei != null) {
            Integer di = dSet.floor(ei - 1);
            if(di == null || di < j) {
                Integer celling = dSet.ceiling(ei + 1);
                celling = celling == null ? length : celling;
                ans = (j - df) * (celling - ei);
                df = j;
            }

        }
        return ans;
    }

    public static int maxAppleFork(int m, int n, int k) {
        if (k > n) {
            return -1;
        }
        int left = k - 1;
        int right = n - k;
        int used = n;
        int lnum = 0,  rnum = 0;
        int i = 1, count = 1;
        for(i = 1; i <= n && used <= m;) {
            count++;
            used += i;
            if(used >= m) {
                return used > m ? count - 1 : count;
            }
            i += lnum >= left ? 0 : 1;
            i += rnum >= right ? 0 : 1;
            lnum++;
            rnum++;

        }
        return -1;
    }
}
