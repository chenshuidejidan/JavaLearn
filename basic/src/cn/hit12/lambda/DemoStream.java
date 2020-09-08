package cn.hit12.lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class DemoStream {
    public static void main(String[] args) {
        //Integer[] a = {1,2,3,4,5};    //Stream.of()参数是泛型，必须传入包装类的数组
        Stream<Integer> stream1 = Stream.of(1,2,3,4,5);
        stream1.map(new Random()::nextInt).forEach(System.out::print);
        //stream1.forEach((Integer s1i)->System.out.print(s1i));
        //Stream<String> stream2 = Stream.of("上山", "打", "老虎");
        //stream2.peek(System.out::println).count();

        //Stream.concat(stream1, stream2).forEach(System.out::print);





    }
}
