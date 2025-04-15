import java.util.*;
import java.io.*;

public class Main {
  public static void main(String args[]) throws Exception {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    // N과 S를 읽어들입니다.
    String[] firstLine = reader.readLine().split(" ");
    int N = Integer.parseInt(firstLine[0]);
    int S = Integer.parseInt(firstLine[1]);

    // 수열을 읽어들입니다.
    int[] sequence = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    // 포인터와 변수를 초기화합니다.
    int start = 0, end = 0, currentSum = 0, minLength = Integer.MAX_VALUE;

    // 투 포인터 기법을 사용합니다.
    while (end < N) {
      // end 포인터를 확장합니다.
      currentSum += sequence[end++];

      // 시작 포인터를 줄여 최소 길이를 찾습니다.
      while (currentSum >= S) {
        minLength = Math.min(minLength, end - start);
        currentSum -= sequence[start++];
      }
    }

    // 결과를 출력합니다.
    if (minLength == Integer.MAX_VALUE) {
      writer.append("0\n");
    } else {
      writer.append(minLength + "\n");
    }
    writer.flush();
  }
}
