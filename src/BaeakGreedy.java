import java.util.Arrays;
import java.util.Scanner;

public class BaeakGreedy {
    private static void baek2437() {
        int n = 7;
        int[] weights = {3, 1, 6, 2, 7, 30, 1};
        int tempResult = 0;
        Arrays.sort(weights);
        int result = 0;
        for (int i = 1; i < 1000; i++) {
            tempResult = i;
            for(int weight : weights){
                System.out.println("i:" + i + "--weight:"+ weight);
                tempResult -= weight;
                if(tempResult==0){
                    break;
                }else if(tempResult<0){
                    result = i;
                    break;
                }
            }
            if(result != 0){
                System.out.println("result:" + result);
                break;
            }
        }
        System.out.println(result);
    }

    public static void baek1541() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
/*        String a = "abcb";
        String b = "aababcb";*/

        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        int tempResult = 0;
        int result = -1;

        for (int k = 0; k <= bb.length - aa.length; k++) {
            for (int i = 0; i < aa.length; i++) {
                if (aa[i] != bb[k + i]) {
                    tempResult += 1;
                }
            }
            result = result == -1 ? tempResult : result;
            result = tempResult < result ? tempResult : result;
            tempResult = 0;
        }
        System.out.println(result);
    }

    public static void baek2875() {
/*        int n = 6; // 여
        int m = 3; // 남
        int k = 2; // 팀*/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int result = 0;

        while (k != 0) {
            if (2 * m > n) { // 남자가 많음
                m = m - 1;
                k = k - 1;
            } else { // 여자가 많음, // 같은 비율이면 여자 제거
                n = n - 1;
                k = k - 1;
            }
        }

        if (2 * m > n) { // 남자가 많음
            result = n / 2;
        } else { // 여자가 많음
            result = m;
        }
        System.out.println(result);
    }

    public static void baek2217() {
        Scanner sc = new Scanner(System.in);
        int nRope = sc.nextInt();

        int[] ropeWeights = new int[nRope];
        for (int i = 0; i < ropeWeights.length; i++) {
            ropeWeights[i] = sc.nextInt();
        }
//        int nRope = 2;
//        int[] ropeWeights = {10,15, 20, 20};
        int result = 0;
        int tempResult = 0;
        Arrays.sort(ropeWeights);

        for (int k = 0; k < ropeWeights.length; k++) {
            tempResult = ropeWeights[k] * (ropeWeights.length - k);
            result = result < tempResult ? tempResult : result;
        }
        System.out.println(result);
    }


    public static void greedy5585() {
        Scanner sc = new Scanner(System.in);
        int coinSum = sc.nextInt();
        coinSum = 1000 - coinSum;
        int[] coin = {1, 5, 10, 50, 100, 500};

        int result = 0;
        for (int i = coin.length - 1; i >= 0; i--) {
            if (coinSum / coin[i] > 0) {
                if (coinSum / coin[i] > 0) {
                    int coinCnt = coinSum / coin[i];
                    coinSum = coinSum - (coin[i] * coinCnt);
                    result += coinCnt;
                }
            }
        }
        System.out.println(result);
    }


    public static void coinGreedy() {
        Scanner sc = new Scanner(System.in);
        int cNum = sc.nextInt();
        int coinSum = sc.nextInt();
        int[] coin = new int[cNum];

        for (int i = 0; i < cNum; i++) {
            coin[i] = sc.nextInt();
        }
        int result = 0;
        for (int i = coin.length - 1; i >= 0; i--) {
            if (coinSum / coin[i] > 0) {
                int coinCnt = coinSum / coin[i];
                coinSum = coinSum - (coin[i] * coinCnt);
                result += coinCnt;
            }
        }
        System.out.println(result);
    }

    public static void atmGreedy() {
        Scanner sc = new Scanner(System.in);
        int Pnum = sc.nextInt();

        int[] time = new int[Pnum];
        for (int i = 0; i < Pnum; i++) {
            time[i] = sc.nextInt();
        }
        Arrays.sort(time);
        int p = 0;
        int result = 0;
        for (int a = 0; a < time.length; a++) {
            p += time[a];
            result += p;
        }
        System.out.println(result);
    }
}




