package datastructures.linkedlist;

public class LinkedList {
  private Node head;
  private Node tail;
  private int length;

  public LinkedList(int value) {
    Node newNode = new Node(value);
    this.head = newNode;
    this.tail = newNode;
    this.length = 1;
  }

  public void printList() {
    Node current = head;
    while (current != null) {
      System.out.print(current.value);
      current = current.next;
    }
  }

  public void getHead() {
    System.out.println(head.value);
  }

  public void getTail() {
    System.out.println(tail.value);
  }

  public void getLength() {
    System.out.println(length);
  }

  public void append(int value) {
    Node newNode = new Node(value);
    if (head == null) {
      head = newNode;
      tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    length++;
  }

  public Node removeLast() {
    if (length == 0) {
      return null;
    }
    Node pre = head;
    Node temp = head;
    while (temp.next != null) {
      pre = temp;
      temp = temp.next;
    }
    tail = pre;
    tail.next = null;
    length--;
    if (length == 0) {
      head = null;
      tail = null;
    }
    return temp;
  }

  public void prepend(int value) {
    Node newNode = new Node(value);
    if (length== 0) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.next = head;
      head = newNode;
    }
    length++;
  }

  public Node removeFirst() {
    if (length == 0) {
      return null;
    }
    Node temp = head;
    head = head.next;
    length--;
    if (length == 0) {
      tail = null;
    }
    return temp;
  }

  public Node get(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    Node temp = head;
    for (int i = 0; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  public boolean set(int index, int value) {
    Node temp = get(index);
    if (temp != null) {
      temp.value = value;
      return true;
    }
    return false;
  }

  public boolean insert(int index, int value) {
    if (index < 0 || index > length) {
      return false;
    }
    if (index == 0) {
      prepend(value);
      return true;
    }
    if (index == length) {
      append(value);
      return true;
    }
    Node newNode = new Node(value);
    Node temp = get(index - 1);
    newNode.next = temp.next;
    temp.next = newNode;
    length++;
    return true;
  }

  public Node remove(int index) {
    if (index < 0 || index >= length) {
      return null;
    }
    if (index == 0) {
      return removeFirst();
    }
    if (index == length - 1) {
      return removeLast();
    }
    Node pre = get(index - 1);
    Node temp = pre.next;
    pre.next = temp.next;
    temp.next = null;
    length--;
    return temp;
  }

  public void reverse() {
    Node temp = head;
    head = tail;
    tail = temp;
    Node after = temp.next;
    Node before = null;
    for (int i = 0; i < length; i++) {
      after = temp.next;
      temp.next = before;
      before = temp;
      temp = after;
    }
  }

  public Node findMiddleNode() {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next  != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  public boolean hasLoop() {
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next  != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public Node findKthFromEnd(int k) {
    if (k < 0 || head == null) {
      return null;
    }
    Node first = head;
    Node second = head;
    for (int  i = 0; i<k;   i++ ) {
      if(first == null){
        return null;
      }
      first =  first.next;
    }
    while(first != null) {
      first = first.next;
      second = second.next;
    }

    return temp;

  }


}

