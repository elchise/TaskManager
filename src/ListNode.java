/*
ADTS LinkedListProject
Task manager/to do list organizer
Nov/Dec 2022
Ella Chi

ListNode Class:
Creates individual nodes for the list. Allows for the creation of linked list by storing objects/tasks and the next node of the list.

 */
public class ListNode {
    private Object value;
    private ListNode next;
    private ListNode prev;

    public ListNode(Object value, ListNode prev, ListNode next) {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }
    
    public ListNode(){
        value = null;
        next = null;
        prev = null;
    }

    public Object getValue() { return value; }
    public ListNode getPrev() { return prev; }
    public ListNode getNext() { return next; }
    public void setValue(Object value) { this.value = value; }
    public void setPrev(ListNode prev) { this.prev = prev; }
    public void setNext(ListNode next) { this.next = next; }
}
