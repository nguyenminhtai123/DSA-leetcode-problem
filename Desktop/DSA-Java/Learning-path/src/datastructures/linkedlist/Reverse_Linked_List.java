package datastructures.linkedlist;
public class Reverse_Linked_List {
  public ListNode reverseList(ListNode head) {
      ListNode before = null;
      ListNode temp = head;
      while(temp != null) {
        ListNode next = temp.next;
        temp.next = before;
        before = temp;
        temp = next;
      }
      return before;
  }

}
