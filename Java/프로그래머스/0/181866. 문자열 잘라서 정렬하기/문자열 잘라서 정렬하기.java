import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] splitString = myString.split("x");
        List<String> resultList = new ArrayList<>();
        for (String s : splitString) {
            if(!s.isEmpty()){
                resultList.add(s);
            }
        }
        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }
}