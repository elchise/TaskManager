import java.util.*;

/*
ADTS LinkedListProject
Task manager/to do list organizer
Nov/Dec 2022
Ella Chi

List Class: 
Creates a doubly linked list to store tasks. Is used to create both to do lists and completed lists. Stores the head and tail as well as the size of list and a pointer to the current node to be displayed.
 */

public class List {
    private ListNode head;
    private ListNode tail;
    private ListNode ptr;
    private int size;
    
    //default constructor: create empty list
    public List(){
        head = null;
        tail = head;
        ptr = head;
        size = 0;
    }
    
    //second constructor: set head, find tail
    public List(ListNode head) {
        this.head = head;
        tail = head;
        
        size = 1;
        while (tail.getNext() != null){
            tail = head.getNext();
            size++;
        }
        
        ptr = head;

    }

    // third constructor: simply set head and tail.
    public List(ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
        
        size = 0;
        ListNode cur = head;
        while (cur != null){
            size++;
        }
        
        ptr = head;
    }
    
    public Object get(int index) {
        ListNode cur = head;
        if(head == null){
            return null;
        }

        for(int i = index; i > 0; i--){
            if (cur == null)
                return null;

            cur=cur.getNext();
            
        }
        return cur.getValue();
        
    }

    public void addFirst(Object obj) {
        ListNode newN = new ListNode(obj, null, head);
        head = newN;
        tail = head;
        
        size++;

    }

    public void addLast(Object obj) {

        if(head == null){
            addFirst(obj);
            // head = new ListNode(obj, null);
        } else{
            tail.setNext(new ListNode(obj, tail, null));
            tail = tail.getNext();
        }
        
        size++;

    }

    public Object remove(int index) {
        ListNode cur = head;
        if(cur == null){
            return null;
        }

        for(int i = index; i > 0; i--){
            cur = cur.getNext();
        }
        
        if (cur.getPrev() != null)
            cur.getPrev().setNext(cur.getNext());
        else
            head = cur.getNext();
        if (cur.getNext() != null)
            cur.getNext().setPrev(cur.getPrev());   
        else
            tail=cur;
        
        size--;
        return cur.getValue();

    }
    
    public boolean remove(Object e){
        ListNode cur = head;
        while (cur != null){
            if (cur.getValue() == e){
                if (cur.getPrev() != null)
                    cur.getPrev().setNext(cur.getNext());
                else
                    head = cur.getNext();
                if (cur.getNext() != null)
                    cur.getNext().setPrev(cur.getPrev());   
                else
                    tail=cur;
                
                size--;
                return true;
            }
            cur = cur.getNext();
        }
        
        return false;
    }

    public void insert(int index, Object obj) {
        ListNode cur = head;

        for(int i = index; i > 1; i--){
            cur=cur.getNext();
        }

        ListNode newN = new ListNode(obj, cur, cur.getNext().getNext());
        cur.setNext(newN);
        size++;
    }

    public int size(){
        return size;
    }
    
    @Override
    public String toString() {
        String s = "";

        for(ListNode cur = head; cur != null; cur = cur.getNext()){
            s += cur.getValue() + " ";
        }
        return s;
    }

    public String[] getTasks(){
        ArrayList<String> tasks = new ArrayList<String>();
        ptr = head;
        Task t;
        while (ptr != null){
            t = (Task) ptr.getValue();
            tasks.add(t.getTitle());
            ptr = ptr.getNext();
        }
        ptr = head;
        
        //return String[] tasks.toArray();
        String[] tnames = new String[tasks.size()];
        for (int i = 0; i < tnames.length; i++){
            tnames[i] = tasks.get(i);
        }
        return tnames;
    }
    
    public Object getNext(){
        if (head == null){
            return null;
        }else if (ptr.getNext() == null){
            ptr = head;
        } else {
            ptr = ptr.getNext(); 
        }
        
        return ptr.getValue();
    }
    
    public Object getPrev(){
        if (head == null){
            return null;
        } if (ptr.getPrev() == null){
            ptr = tail;
        } else {
            ptr = ptr.getPrev();
        }
        
        return ptr.getValue(); 
    }
    
    public Object removePtr(){
        if(ptr == null){
            return null;
        }
        
        ListNode cur = ptr;
        
        if (ptr.getPrev() != null)
            ptr.getPrev().setNext(ptr.getNext());
        else
            head = ptr.getNext();
        if (ptr.getNext() != null){
            ptr.getNext().setPrev(ptr.getPrev()); 
            ptr = ptr.getNext();
        }
        else {
            tail=ptr.getPrev();
            ptr = head;
        }
        size--;
        return cur.getValue();
    }
    
    public Object getCur(){
        if (ptr == null){
            return null;
        }
        return ptr.getValue();
    }

}
