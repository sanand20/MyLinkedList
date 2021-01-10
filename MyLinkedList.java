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
 public String get(int index){
   if(index < 0 || index >= size)
       throw new IndexOutOfBoundsException();
    Node current = start;
    for(int i = 0; i < index; ++i) {
        current = current.getNext();
    }
    return current.getData();
 }
 private Node getNode(int index){
   if(index < 0 || index >= size)
       throw new IndexOutOfBoundsException();
    Node current = start;
    for(int i = 0; i < index; i++) {
        current = current.getNext();
    }
    return current;
 }

 public String set(int index, String value){
   if(index < 0 || index >= size) {
       throw new IndexOutOfBoundsException("out of bounds");
   }
   Node current = getNode(index);
   String ans = current.getData();
   current.setData(value);
   return ans;
 }

 public String remove(int index){
   if(index < 0 || index >= size || size == 0) {
       throw new IndexOutOfBoundsException("out of bounds");
   }
   String ans = get(index);
    if (size == 1 ){
     start = null;
     end = null;
     size =0;
   }
   else if (index == 0){
     start = start.getNext();
     start.getNext().setPrev(start);
     size--;
   }
   else if (index==size-1){
     end = end.getPrev();
     end.getPrev().setNext(end);
     size--;
   }
   else {
     Node current = start;
     for(int i = 0; i < index; i++) {
         current = current.getNext();
     }
     current.getPrev().setNext(current.getNext());
     current.getNext().setPrev(current.getPrev());
     size--;
   }
   return ans;
 }
 public String toString(){
 String ans = "[";
 Node current = start;
 for (int i = 0; i<size; i++){
   ans+= current.getData();

   if (current.getNext() != null){
     current = current.getNext();
     ans += ", ";
   }
 }
 ans += "]";
 return ans;
//Any helper method that returns a Node object MUST BE PRIVATE!
}
public String toStringReversed(){
String ans = "[";
Node current = end;
for (int i = 0; i<size; i++){
  ans+= current.getData();
  if (current.getPrev() != null){
    current = current.getPrev();
ans += ", ";
  }
}
ans += "]";
return ans;
//Any helper method that returns a Node object MUST BE PRIVATE!
}
}
