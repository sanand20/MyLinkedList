public class Node{


private String data;
private Node next,prev;
public Node(String value){
 data = value;
  }
public String getData() {
  return data;
}

public void setData(String data){
  this.data = data;
}

public Node getNext(){
  return next;
}

public void setNext(Node node){
  next = node;
}
public Node getPrev(){
  return prev;
}
public void setPrev(Node node){
  prev = node;
}

//write get/set methods for all three instance variables.
}
