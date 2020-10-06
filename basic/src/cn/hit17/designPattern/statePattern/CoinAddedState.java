package cn.hit17.designPattern.statePattern;

public class CoinAddedState implements IState{
    private Machine machine;

    public CoinAddedState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void addCoin() {
        System.out.println("已投币，无需投币！");
    }

    @Override
    public void backCoin() {
        System.out.println("退给你，请收好你的币！");
        machine.setCount(machine.getCount()-1);
        machine.setCurrentState(machine.getNoCoinAddState());
    }

    @Override
    public void turnCrank() {
        System.out.println("正在转动摇杆");
        machine.setCurrentState(machine.getSoldState());
    }

    @Override
    public void dispense() {
        System.out.println("?????卖不了");
    }
}
