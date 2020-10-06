package cn.hit17.designPattern.statePattern;

import java.util.Random;

public class SoldState implements IState{
    private Machine machine;

    public SoldState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void addCoin() {
        System.out.println("正在出货，请勿投币");
    }

    @Override
    public void backCoin() {
        System.out.println("正在出货，没有可退的钱");
    }

    @Override
    public void turnCrank() {
        System.out.println("正在出货，请勿重复转动手柄");
    }

    public void dispense(){
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int result = new Random().nextInt(10);
        if(result>7 && machine.getCount()>0){
            System.out.println("恭喜你！中奖了");
            machine.setCount(machine.getCount()-1);
            machine.setCurrentState(machine.getNoCoinAddState());
        }else if(result<=7){
            System.out.println("未中奖。。再接再厉！");
            machine.setCurrentState(machine.getNoCoinAddState());
        }else{
            System.out.println("已无更多商品，请联系管理员补货");
            machine.setCurrentState(machine.getSoldOutState());
        }
    }
}
