class Solution {
    static int answer;
    static int Target;
    public int solution(int[] numbers, int target) {
        Target = target;
        answer = 0;
        find(numbers, 0, 0);
        return answer;
    }
    public void find (int[] numbers, int ord, int sum) {
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (ord == numbers.length -1) {
                    if (sum + numbers[ord] == Target) {
                        answer+=1;
                    }
                    continue;
                }
                find(numbers, ord+1, sum + numbers[ord]);
            }
            else if (i == 1) {
                if (ord == numbers.length -1) {
                    if (sum - numbers[ord] == Target) {
                        answer+=1;
                    }
                    continue;
                }
                find(numbers, ord+1, sum - numbers[ord]);
            }
        }
    }
}