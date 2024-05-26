package jingda.algo.overflow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 2024-05-12日 22:10:53
 */
public class InitTest {

    public static void main(String[] args) {
        "".toCharArray();
        for (Character c : "".toCharArray()) {

        }
        System.out.println((int) 111111111111L);



    }

    public void test() {
        List<String> test = new ArrayList<>();
        Iterator<String> iterator = test.iterator();
    }
}
