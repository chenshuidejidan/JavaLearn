package cn.hit17.designPattern.statePattern;

public class SoldOutState implements IState {
    private Machine machine;

    public SoldOutState(Machine machine) {
        this.machine = machine;
    }

    @Override
    public void addCoin() {
        System.out.println("已无更多商品，请联系管理员补货");
    }

    @Override
    public void backCoin() {
        System.out.println("已无更多商品，请联系管理员补货");
    }

    @Override
    public void turnCrank() {
        System.out.println("已无更多商品，请联系管理员补货");
    }

    @Override
    public void dispense() {
        System.out.println("?????卖不了");
    }
}
