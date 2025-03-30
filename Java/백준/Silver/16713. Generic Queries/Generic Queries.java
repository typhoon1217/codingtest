import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // N: 수열의 길이, Q: 쿼리의 개수
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        // 입력받은 수열을 저장할 배열 (1-indexed로 사용)
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // XOR 누적합(prefix XOR) 배열 계산
        // prefixXOR[i]는 arr[1] ^ arr[2] ^ ... ^ arr[i]의 값을 저장
        int[] prefixXOR = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixXOR[i] = prefixXOR[i - 1] ^ arr[i];
        }
        
        // 모든 쿼리 결과를 XOR한 최종 결과값
        int result = 0;
        
        // Q개의 쿼리 처리
        for (int q = 0; q < Q; q++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()); // 시작 인덱스
            int e = Integer.parseInt(st.nextToken()); // 끝 인덱스
            
            // 구간 XOR 계산: arr[s] ^ arr[s+1] ^ ... ^ arr[e]
            // XOR의 특성을 활용하여 누적합으로 구간 계산
            // a ^ a = 0, 0 ^ a = a 라는 XOR의 성질을 이용
            // prefixXOR[e] = arr[1] ^ arr[2] ^ ... ^ arr[e]
            // prefixXOR[s-1] = arr[1] ^ arr[2] ^ ... ^ arr[s-1]
            // 따라서 prefixXOR[e] ^ prefixXOR[s-1] = arr[s] ^ ... ^ arr[e]
            int rangeXOR = prefixXOR[e] ^ prefixXOR[s - 1];
            
            // 현재 쿼리 결과를 최종 결과에 XOR 연산
            result ^= rangeXOR;
        }
        
        // 최종 결과 출력
        System.out.println(result);
    }
}