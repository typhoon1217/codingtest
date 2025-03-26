import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // 3명의 수포자 각각의 찍기 패턴 정의하기
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 각 수포자의 점수를 저장할 배열 
        int[] scores = new int[3];
        
        // 정답 체크
        for (int i = 0; i < answers.length; i++) {
            // 첫 번째 수포자 채점 나머지를 활용해 반복되는 패턴에 다시 처음으로 
            if (answers[i] == first[i % first.length]) {
                scores[0]++;
            }
            
            // 두 번째 수포자 채점
            if (answers[i] == second[i % second.length]) {
                scores[1]++;
            }
            
            // 세 번째 수포자 채점
            if (answers[i] == third[i % third.length]) {
                scores[2]++;
            }
        }
        
        // 최대 점수 찾기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // 최대 점수를 가진 수포자 찾기 리스트로 범위내에 최대 점수를 가진 수포자들 찾아서 결과로 리스트에 저장
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (scores[i] == maxScore) {
                result.add(i + 1);
            }
        }
        
        // List를 배열로 변환하는 스트림 데이터타입을 int로 바꿔서 결과를 배열로 반환
        return result.stream().mapToInt(i -> i).toArray();
    }
}