package Stack;

public class minStack {
    int[] stack;
    int top;
    int[] min;

    public minStack(){
        stack = new int[10];
        min = new int[10];
        top = -1;
    }

    public minStack(int size){
        stack = new int[size];
        min = new int[size];
        top = -1;// -1表示栈里面没有元素
    }

    public void push(int val){
        if(top < stack.length){
            top++;
            stack[top] = val;
            if (top == 0) {
                min[top] = val;
            } else {
                min[top] = Math.min(min[top - 1], val);
            }// 将每一个元素作为top的情况的最小值存起来
        }   
    }

    public int top(){
        return stack[top];
    }

    public int getMin(){
        return min[top];
        // 思路错误:这个最小是有可能被pop出去的，因此我们不可以使用一个变量来存，我们需要使用一个stack存
    }

    public void pop(){
        top--;
    }

    public static void main(String[] args) {
        minStack minStack = new minStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
