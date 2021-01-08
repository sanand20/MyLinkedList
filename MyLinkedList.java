import java.util.*;
public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
 size = 0;}
 public int size(){
   return size;
 }
 public boolean add(String value){
     add(size, value);
     return true;
 };
 public void add(int index, String value){
     if (index >= 0 && index <= size){
         if (start != null){
             if (index == size){
                 Node temp = new Node(value);
                 end.setNext(temp);
                 temp.setPrev(end);
                 end = temp;
             }
             else if (index == 0){
                 Node temp = new Node(value);
                 start.setPrev(temp);
                 temp.setNext(start);
                 start = temp;
             }
             else{
               Node current = start;
                 for (int i = 0; i < index; i++){
                      current = current.getNext();
                 }
               Node temp = new Node(value);
               temp.setPrev(current.getPrev());
               temp.setNext(current);
               current.getPrev().setNext(temp);
               current.setPrev(temp);
             }
         }
         else{
             Node temp = new Node(value);
             start = temp;
             end = temp;


         }
         size += 1;
     }else{
         throw new IndexOutOfBoundsException();
     }
 };
 
}
