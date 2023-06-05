import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //TODO:第一题
        System.out.println("请输入需要反转的整数");
        int n = in.nextInt();
        int r = reverse(n);
        System.out.println(r);

        //TODO:第二题
        System.out.println("请输入楼梯的阶数");
        int nn = in.nextInt();
        int a = 0, b = 0, c = 1;
        for (int i = 1; i <= nn; ++i) {
            a = b;
            b = c;
            c = a + b;
        }
        System.out.println(c);

        //TODO:第三题
        int[] nums = {1,2,3};

        System.out.println(subsets(nums));
    }

    public static int reverse(int n) {
        int temp, r = 0;
        while (n != 0) {
            temp = n % 10;
            r = r * 10 + temp;
            n = n / 10;
        }
        if (r > Math.pow(2, 31) || r < Math.pow(-2, 31) - 1)
            r = 0;
        return r;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int l = nums.length;
        int m = (int) Math.pow(2, l);
        for (int i = 0; i < m; i++) {
            String b = Integer.toBinaryString(i);
            int re = nums.length - b.length();
            List<Integer> list = new ArrayList<>();
            for (int j = b.length() - 1; j >= 0; j--) {
                if (b.charAt(j) == '1') {
                    list.add(nums[j + re]); // 索引回去
                }
            }
            result.add(list);
        }
        return result;
    }
}
