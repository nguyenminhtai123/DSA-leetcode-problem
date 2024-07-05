package datastructures.linkedlist;

public class Merge_Nodes_in_Between_Zeros {
  public ListNode mergeNodes(ListNode head) {
    ListNode curr = head.next;  // Start from the node after head
    ListNode newList = new ListNode(0);  // Dummy node to start the new list
    ListNode newListTail = newList;  // Tail pointer for the new list

    int sum = 0;

    while (curr != null) {
      if (curr.val == 0) {
        // Create a new node with the sum and add it to the new list
        newListTail.next = new ListNode(sum);
        newListTail = newListTail.next;
        sum = 0;  // Reset the sum
      } else {
        sum += curr.val;  // Add the current value to the sum
      }
      curr = curr.next;
    }

    return newList.next;  // Return the new list, skipping the dummy node
  }
}
