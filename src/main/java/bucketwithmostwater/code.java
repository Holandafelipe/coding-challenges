// Impl O(n) solution using recursion

// problem explanation -> https://leetcode.com/problems/container-with-most-water/description/

// You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
// Find two lines that together with the x-axis form a container, such that the container contains the most water.
// Return the maximum amount of water a container can store.
// Notice that you may not slant the container.

// Example 1:
// Input: height = [1,8,6,2,5,4,8,3,7]
// Output: 49
// Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.

// Example 2:
// Input: height = [1,1]
// Output: 1

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