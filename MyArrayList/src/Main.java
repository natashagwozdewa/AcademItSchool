import java.util.ArrayList;

/**
 * Created by Наталия on 13.01.2017.
 */
public class Main {
    public static void main(String[] args) {

        MyArrayList<Integer> list = new MyArrayList<Integer>();
        System.out.println(list.size());
        list.add(2);
        list.add(0,1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(4);
        list.remove(1);



        System.out.println(list.toString());
        while (list.iterator().hasNext())
        {
            System.out.println(list.iterator().next());
        }
        System.out.println(list.lastIndexOf(4));

       // list.removeAt(1);
        // System.out.println(list.remove(4));
        // System.out.println(list.remove(1));
        //list.add(0,6);
        //list.removeAt(8);
        //System.out.println(list.toString());
        //  System.out.println(list.indexOf(6));
        // System.out.println(list.get(2));
        //  list.set(2,7);
        // System.out.println(list.toString());
        //list.clear();
        // System.out.println(list.size());
        // list.removeLast();
        // System.out.println(list.toString());
    }
}
