class Solution {
    public int trap(int[] height) {
        int sum=0;
        int current=0;
        Stack<Integer> stack=new Stack<>();
        while(current<height.length) {
            while(!stack.empty()&&height[current]>height[stack.peek()]) {
                int p=height[stack.peek()];
                stack.pop();
                if(stack.empty()) break;               
                int distance=current-stack.peek()-1;
                int min=Math.min(height[current],height[stack.peek()]);
                sum+=distance*(min-p);
            }
            stack.push(current);
            current++;     
        }
        return sum;
        
    }
}