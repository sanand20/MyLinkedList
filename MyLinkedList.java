public class MyLinkedList{
 private int size;
 private Node start,end;
 public MyLinkedList(){
 size = 0;}
 public int size(){
   return size;
 }
 public boolean add(String value){
   if(size == 0){
     start = new Node(value);
     end = new Node(value);
   }
   else{
     end.setNext(new Node(value));
     end = Node(value);
     size++
   }
   return true;
 }
 public void add(int index, String value);
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
