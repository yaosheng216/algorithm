
class Solution {
    int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;

        for (int index = 0;index < heights.length;index ++){
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        st.push(0);
        int result = 0;

        // 第一个元素已经入栈，从下标1开始
        for (int i = 1;i < heights.length;i ++) {
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); 
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { 
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}
