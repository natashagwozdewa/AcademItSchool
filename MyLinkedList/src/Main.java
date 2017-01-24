import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<Integer>();
        linkedList.add(0,1);
        linkedList.add(0,2);
        linkedList.add(1,3);
       // linkedList.removeFirst();
       // linkedList.remove(0);
      //  linkedList.add(1,4);
       // linkedList.set(0,6);
      //  linkedList.remove(6);
       // linkedList.addLast(null);
       // linkedList.remove(null);
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLength());
       // linkedList.add(1,4);
       // linkedList.add(3,5);
       // linkedList.add(5,6 );
       // linkedList.removeLast();
       // linkedList.removeLast();
       // linkedList.add(0,7 );
        System.out.println(linkedList.toString());
       // linkedList.add(1);
      //  linkedList.add(3);
      //  linkedList.insert(1, 2);
       // System.out.println(linkedList.toString());
       // linkedList.removeLast();
       // linkedList.set(0, 0);
       // linkedList.insert(5, 2);
      //  System.out.println(linkedList.toString());
       // System.out.println(linkedList.get(1));

     /*   while (linkedList.iterator().hasNext())
        {
            System.out.println(linkedList.iterator().next());
        }*/
        System.out.println(linkedList.indexOf(null));

        LinkedList list = new LinkedList();
        list.indexOf(0);
    }
}
