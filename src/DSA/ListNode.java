package DSA;

public class ListNode<T> {
    private final T val;
    private ListNode<T> next;
    public ListNode(T val, ListNode<T> next){
        this.val = val;
        this.next = next;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public T getVal() {
        return val;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }
}
