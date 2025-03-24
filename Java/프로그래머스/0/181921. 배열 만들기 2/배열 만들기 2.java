class Solution {
    public int[] solution(int l, int r) {
        int count = 0;
        //배열의 크기를 정하기 위해 몇개인지 카운트
        for (int i = l; i <= r; i++) {
            if (isOnlyZeroOrFive(i)) {
                count++;
            }
        }
        //하나도 없는값에 대해 예외처리
        if (count == 0) {
            return new int[]{-1};
        }
        //배열에 맞는 숫자 넣기
        int[] answer = new int[count];
        int index = 0;
        for (int i = l; i <= r; i++) {
            if (isOnlyZeroOrFive(i)) {
                answer[index++] = i;
            }
        }
        return answer;
    }

    //5개인지 아닌지 확인
    private boolean isOnlyZeroOrFive(int n) {
        String s = String.valueOf(n);
        for (char c : s.toCharArray()) {
            if (c != '0' && c != '5') {
                return false;
            }
        }
        return true;
    }
}