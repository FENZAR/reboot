package edu.reboot.task4;

import java.util.*;

public class SubTasks_3_4 {

    private static <T> Collection<T> removeDuplicates(Collection<T> someCollection) {
        HashSet<T> set = new HashSet<T>(someCollection);
        someCollection.clear();
        someCollection.addAll(set);

        return someCollection;
    }

    private static <K, V> HashMap<V, Collection<K>> reverse(Map<K, V> map) {
        HashMap<V, Collection<K>> rev = new HashMap<V, Collection<K>>();
        for(Map.Entry<K, V> entry : map.entrySet()) {
            if(rev.containsKey(entry.getValue())) {
                rev.get(entry.getValue()).add(entry.getKey());
            } else {
                rev.put(entry.getValue(), new LinkedList<>());
                rev.get(entry.getValue()).add(entry.getKey());
            }
        }
        return rev;
    }

    public static void main(String[] args) {
        // 4.3
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("reboot");
        arrayList.add("java");
        arrayList.add("reboot");
        System.out.println("Before removeDuplicates");
        System.out.println(arrayList);
        System.out.println("After removeDuplicates");
        System.out.println(removeDuplicates(arrayList));

        // 4.4
        Map<String, Integer> map = new HashMap<>();
        map.put("reboot", 1);
        map.put("reboot2", 2);
        map.put("reboot3", 2);
        System.out.println(map);
        System.out.println(reverse(map));

    }
}
