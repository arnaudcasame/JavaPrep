package PrepApp.leetcode.Queue;

import DSA.ListNode;

public class QueueLikeStack {

    private ListNode<Integer> head;
    private ListNode<Integer> tail;
    public QueueLikeStack() {}

    public void push(int x) {
        if(head == null){
            head = new ListNode<Integer>(x, null);
            tail = head;
        }else{
            ListNode<Integer> list = new ListNode<Integer>(x, null);
            tail.setNext(list);
            tail = list;
        }
    }

    public int pop() {
        ListNode<Integer> popped = head;
        head = head.getNext();
        popped.setNext(null);
        return popped.getVal();
    }

    public int peek() {
        return head.getVal();
    }

    public boolean empty() {
        return head == null;
    }

    public int getTail_(){
        return tail.getVal();
    }
}
