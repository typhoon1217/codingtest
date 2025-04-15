import java.util.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // N을 읽어옵니다.
        int N = Integer.parseInt(reader.readLine());
        // 배열 A를 읽어옵니다.
        int[] A = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 배열 A를 정렬합니다.
        Arrays.sort(A);

        // M을 읽어옵니다.
        int M = Integer.parseInt(reader.readLine());
        // 쿼리를 읽어옵니다.
        int[] queries = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < M; i++) {
            int query = queries[i];
            // 이진 탐색을 수행합니다.
            if (binarySearch(A, query)) {
                writer.append("1\n");
            } else {
                writer.append("0\n");
            }
        }
        writer.flush();
    }

    private static boolean binarySearch(int[] A, int target) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) {
                return true;
            } else if (A[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}