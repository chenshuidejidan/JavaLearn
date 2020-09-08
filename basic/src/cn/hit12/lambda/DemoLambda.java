package cn.hit12.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DemoLambda {
    public static void main(String[] args) {
        String[] atp = {"Rafael Nadal", "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer","Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);

        //players.forEach((player)-> System.out.print(player+","));
        players.forEach(System.out::println);
        MyFunction myFunction = (s)-> System.out.println(s);
        myFunction.myMethod("anksajksjak");
    }
}
