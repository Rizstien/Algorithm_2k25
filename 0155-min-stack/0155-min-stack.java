class MinStack {

    Stack<Node> stack;
    int min = Integer.MAX_VALUE;
    Node head = null;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        /*
        min = Math.min(min, val);
        head = new Node(val,min,head);
        stack.push(head);
       // head = node;
       */


        if(head == null){
            head = new Node(val, val, null);
        }else{
            head = new Node(val, Math.min(val, head.min), head);
        }
        stack.push(head);
        
    }
    
    public void pop() {
        stack.pop();
        head = head.prev;
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}

class Node {
    int val;
    int min;
    Node prev;

    public Node(int val, int min, Node prev){
        this.val = val;
        this.min = min;
        this.prev = prev;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */