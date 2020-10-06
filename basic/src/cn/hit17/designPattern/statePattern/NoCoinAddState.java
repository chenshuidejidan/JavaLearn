package cn.hit17.designPattern.statePattern;

public class NoCoinAddState implements IState{
    private Machine machine;

    public NoCoinAddState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void addCoin() {
        System.out.println("投币成功");
        machine.setCurrentState(machine.getCoinAddedState());
    }

    @Override
    public void backCoin() {
        System.out.println("退钱失败，您未投币，请投币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("转动摇杆失败，您未投币，请投币！");
    }

    @Override
    public void dispense() {
        System.out.println("?????卖不了");
    }
}
