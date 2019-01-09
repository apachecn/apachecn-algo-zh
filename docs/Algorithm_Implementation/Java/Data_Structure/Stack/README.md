## Stack Implementation

### Stack using Array

```java
public class Stack {

    private int[] nums;
    private int size;
    private int top; # 栈顶位置

    private Stack(int size) {
        this.size = size;
        this.nums = new int[size];
        this.top = -1;
    }

    private boolean isFull() {
        return this.top == this.size - 1;
    }

    public boolean push(int num) {
        if(isFull()) {
            System.out.println("the stack is full!");
            return false;
        } else {
            this.top++;
            this.nums[this.top] = num;
            return true;
        }
    }

    public int peek() {
        return this.nums[this.top];
    }

    public int pop() throws Exception {
        if(empty()) {
            throw new Exception("the stack is empty!");
        } else {
            return this.nums[this.top--];
        }
    }

    public boolean empty()     {
        return this.top == -1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack(20);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println("Now the peek num is:" + stack.peek());

        while(!stack.empty()) {
            try {
                System.out.println(stack.pop());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
```
