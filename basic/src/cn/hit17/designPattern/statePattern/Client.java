package cn.hit17.designPattern.statePattern;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Machine machine = new Machine(10);
        ClientFactory clientFactory = new ClientFactory(machine);
        Scanner sc = new Scanner(System.in);
        while(true){
            if(machine.getCurrentState()==machine.getNoCoinAddState()){
                System.out.println("请投币:");
            }
            String operation = sc.nextLine();
            clientFactory.execute(machine, operation);
        }
    }
}
