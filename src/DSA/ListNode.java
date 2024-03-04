package DSA;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + (next != null ? next.toString() : "null") +
                '}';
    }

    public static ListNode<Integer> fromArray(int[] arr){
        ListNode<Integer> head = null;
        ListNode<Integer> current = null;
        for(int item: arr){
            if(head == null){
                head = new ListNode<Integer>(item, null);
                current = head;
            }else {
                current.next = new ListNode(item, null);
                current = current.next;
            }
        }
        return head;
    }

    public static int[] toArray(ListNode<Integer> head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.getVal());
            head = head.next;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
