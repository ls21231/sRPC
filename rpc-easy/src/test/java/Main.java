import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    /*public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        while(q-- > 0) {
            int x = scanner.nextInt();
            for(int i = 0; i < n; i++) {
                if(i == x - 1) {
                    continue;
                }
                a[i] = a[i] * 2;
            }
        }
        BigInteger  bigInteger = new BigInteger("0");
        BigInteger m = new BigInteger("1000000007");
        for(int i = 0; i < n; i++) {
            bigInteger = bigInteger.add(BigInteger.valueOf(a[i]));
            if(bigInteger.compareTo(m) > 0) {
                bigInteger = bigInteger.mod(m);
            }
        }
        System.out.println(bigInteger);
    }*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[]{2, 1, 2};
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        List<List<Integer>> subsets = subsets(a);
        System.out.println(subsets);


    }


    static List<Integer> list = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < (1 << n); mask++) {
            list.clear();
            System.out.println("外层");
            for (int i = 0; i < n; i++) {
                System.out.println("内层");
                if ((mask & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }

    public static void dfs(int[] nums, int index) {
        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            res.add(new ArrayList<>(list));
            dfs(nums, i + 1);
            list.remove(list.size() - 1);
        }
    }

    // 逆序对数量

    public static int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        count += merge(nums, left, mid, right);
        return count;
    }

    public static int merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0, count = 0;
        while (i <= mid && j <= right) {
            if(nums[i] > nums[j]) {
                temp[k++] = nums[j++];
                count += mid - i + 1;
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int m = 0; m < temp.length; m++) {
            nums[left + m] = temp[m];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }




}
