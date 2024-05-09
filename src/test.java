import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("sda");
        list.add("qew");
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
    }

}
