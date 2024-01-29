package DSA;

public class ListNode<T> {
    private T val;
    private ListNode next;
    public ListNode(T val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public ListNode getNext() {
        return next;
    }

    public T getVal() {
        return val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
