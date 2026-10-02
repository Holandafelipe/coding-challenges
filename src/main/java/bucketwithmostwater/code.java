class Solution {
    public int maxArea(int[] height) {
        int lastElem = height.length - 1;
        int maxArea = calculateMaxArea(0, 0, lastElem, height);

        return maxArea;
    }

    private int calculateMaxArea(int answer, int init, int last, int[] height) {
        int initHeight = height[init];
        int lastHeight = height[last];

        int ySize = initHeight <= lastHeight ? initHeight : lastHeight;
        int xSize = last - init;
        int calcArea = ySize * xSize;

        answer = calcArea > answer ? calcArea : answer;

        if (init + 1 == last) {
            return answer;
        } else if (initHeight <= lastHeight) {
            return calculateMaxArea(answer, init + 1, last, height);
        } else {
            return calculateMaxArea(answer, init, last - 1, height);
        }
    }
}