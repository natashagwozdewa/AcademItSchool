import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<Integer, String>();
        hashMap.put(1, "dddd");
        hashMap.put(7, "bbbb");
        hashMap.put(8, "aaaa");
        hashMap.put(17, "cccc");
     //   System.out.println(hashMap.get(1));
       // System.out.println(hashMap.toString());
     /*   System.out.println(hashMap.getSize());
        System.out.println(hashMap.remove(17));
        System.out.println(hashMap.toString());
        System.out.println(hashMap.getSize());
        System.out.println(hashMap.containsKey(8));
        System.out.println(hashMap.containsKey(17));
        hashMap.replace(1, "666");
        System.out.println(hashMap.toString());*/
       // System.out.println(hashMap.values());
       // System.out.println(hashMap.keySet());
        System.out.println(hashMap.entrySet());





       HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "0");
        map.put(7, "7");
        map.put(8, "8");
        map.put(17, "17");
        map.put(56, "9999999");
        map.put(9, "0");
        map.put(2, "7");
        map.put(3, "8");
        map.put(4, "17");
        map.put(55, "9999999");
        map.put(10, "17");
        map.put(54, "9999999");
        map.put(11, "17");
        map.put(53, "9999999");
       // System.out.println(map.toString());
       // System.out.println(map.size());
       // System.out.println(map.values());
       // System.out.println(map.keySet());
        hashMap.putAll(map);
       // System.out.println(map.entrySet());
    }
}
