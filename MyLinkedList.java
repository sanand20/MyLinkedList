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
    String ans = get(index);
    if(index < 0 || index >= size ) {
       throw new IndexOutOfBoundsException("out of bounds");
   }

   else if (size == 1 ){
     start = null;
     end = null;
     size--;;
   }

   else if (index == 0){
     if (size == 2){
       start = end;
     }
     else{start = start.getNext();
     start.getNext().setPrev(start);}
     size--;
   }
   else if (index==size-1){
     if (size == 2){
       end = start;
     }
     else{end = end.getPrev();
     end.getPrev().setNext(end);}
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

 public void extend (MyLinkedList other){
   if (this.size == 0 || other.size == 0){
     if (this.size == 0){
       this.start = other.start;
       this.end = other.end;
     }
   }
   else {
       this.end.setNext(other.start);
       other.start.setPrev(end);
       this.end = other.end;
       size += other.size;
       }
       while(other.size>0){
         other.remove(0);
       }
       other.size=0;
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
