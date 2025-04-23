class Solution {
    /**
     * 주어진 명함들을 모두 수납할 수 있는 가장 작은 지갑의 크기를 반환합니다.
     * 각 명함은 가로 또는 세로로 회전하여 수납할 수 있습니다.
     *
     * @param sizes 명함의 가로 길이와 세로 길이를 담은 2차원 배열입니다. 각 원소는 [가로, 세로] 형태입니다.
     * @return 모든 명함을 수납할 수 있는 가장 작은 지갑의 크기 (가로 * 세로).
     */
    public int solution(int[][] sizes) {
        // 가장 큰 가로 길이를 저장할 변수 초기화
        int maxWidth = 0;
        // 가장 큰 세로 길이를 저장할 변수 초기화
        int maxHeight = 0;

        // 주어진 모든 명함의 크기를 순회합니다.
        for (int[] size : sizes) {
            int width = size[0]; // 현재 명함의 가로 길이
            int height = size[1]; // 현재 명함의 세로 길이

            // 각 명함을 가로 또는 세로로 회전하여 더 긴 변이 가로가 되도록 합니다.
            // 이렇게 하면 모든 명함을 수납하는 데 필요한 전체 가로 길이와 세로 길이를 최소화할 수 있습니다.
            int currentMaxWidth = Math.max(width, height); // 현재 명함의 최대 길이
            int currentMaxHeight = Math.min(width, height); // 현재 명함의 최소 길이

            // 지금까지 발견된 가장 큰 가로 길이와 현재 명함의 최대 길이를 비교하여 갱신합니다.
            if (currentMaxWidth > maxWidth) {
                maxWidth = currentMaxWidth;
            }

            // 지금까지 발견된 가장 큰 세로 길이와 현재 명함의 최소 길이를 비교하여 갱신합니다.
            if (currentMaxHeight > maxHeight) {
                maxHeight = currentMaxHeight;
            }
        }

        // 모든 명함을 수납할 수 있는 가장 작은 지갑의 크기는 가장 큰 가로 길이와 가장 큰 세로 길이의 곱입니다.
        int answer = maxWidth * maxHeight;
        return answer;
    }
}
