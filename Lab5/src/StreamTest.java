
import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        StreamTest s = new StreamTest();

        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 2, 2, 3, 4, 4);
        System.out.println(list);
        System.out.print("平均值：");
        System.out.println(s.average(list));
        List<String> l2 = new ArrayList<>();
        Collections.addAll(l2, "aa", "bb", "Cc", "xx", "abC", "ajj", "aJ");
        System.out.println(l2);
        List<String> l3 = s.convert(l2);
        System.out.print("大写并加上前缀结果：");
        System.out.println(l3);
        System.out.println(list);
        System.out.print("去重，平方：");
        System.out.println(s.distinctList(list));

        System.out.println(l2);
        System.out.print("以a开头：");
        System.out.println(s.selectInitial(l2, 'a'));

        System.out.println(l2);
        System.out.println("最后一个元素" + s.findLast(l2));
        System.out.println(list);
        System.out.println("偶数和：" + s.evenSum(list));
        System.out.println(l2);
        System.out.print("第一个为键，后面为值：");
        System.out.println(s.convertMap(l2));
    }

    public double average(List<Integer> list) {

        return (double) list.stream().reduce(0, Integer::sum) / list.size();
    }

    //将字符串转为大写，同时添加前缀_new_
    public List<String> convert(List<String> list) {
        //先把所有字符串弄成大写，然后加上前缀
        return list.stream().map(s -> s.toUpperCase()).map(s -> "_new_" + s).collect(Collectors.toList());
    }

    //找出只出现一次的数字，并返回他们的平方
    public List<Integer> distinctList(List<Integer> list) {
        //先找出不同的，然后用map成平方
        return list.stream().filter(a -> Collections.frequency(list, a) == 1).map(i -> i * i).collect(Collectors.toList());
    }

    public List<String> selectInitial(List<String> List, char begin) {
        //先保证首字母与begin相同，然后排序
        return List.stream().filter(s -> s.charAt(0) == begin).sorted().collect(Collectors.toList());
    }

    //返回最后一个元素，否则返回null
    public String findLast(List<String> list) {
        return list.stream().skip(list.size() - 1).findFirst()
                        .orElseThrow(()-> new IllegalArgumentException("The collection is empty"));
    }

    //然后偶数之和，没有则返回0
    public int evenSum(List<Integer> a) {
        //先过滤出偶数的，然后求和
        return a.stream().filter(i -> i % 2 == 0).reduce(0, Integer::sum);
    }

    public HashMap<String, List<String>> convertMap(List<String> list) {
        ;
        HashMap<String, List<String>> map = new HashMap<>();
        //把第一个放入键，后面的放入值
        map.put(list.get(0), list.stream().skip(1).collect(Collectors.toList()));
        return map;
    }
}


