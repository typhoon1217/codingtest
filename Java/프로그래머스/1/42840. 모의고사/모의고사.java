import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 이차원 배열로 수포자들의 찍기 패턴 정의
        int[][] patterns = {
            {1, 2, 3, 4, 5},             // 첫 번째 수포자 패턴
            {2, 1, 2, 3, 2, 4, 2, 5},    // 두 번째 수포자 패턴
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}  // 세 번째 수포자 패턴
        };
        
        // 각 수포자의 점수를 저장할 배열 
        int[] scores = new int[3];
        
        // 정답 체크
        for (int i = 0; i < answers.length; i++) {
            // 각 수포자마다 반복
            for (int j = 0; j < patterns.length; j++) {
                // 현재 문제의 답과 수포자의 찍은 답 비교
                if (answers[i] == patterns[j][i % patterns[j].length]) {
                    scores[j]++;
                }
            }
        }
        
        // 최대 점수 찾기
        int maxScore = Arrays.stream(scores).max().getAsInt();
        
        // 최대 점수를 가진 수포자 찾기
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }
        
        // List를 배열로 변환
        return result.stream().mapToInt(i -> i).toArray();
    }
}