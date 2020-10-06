package cn.hit17.designPattern.statePattern;

public class ClientFactory {
    private Machine machine;

    public ClientFactory(Machine machine) {
        this.machine = machine;
    }

    public void execute(Machine machine, String operation) {
        if("addCoin".equalsIgnoreCase(operation)){
            machine.addCoin();
        }else if("backCoin".equalsIgnoreCase(operation)){
            machine.backCoin();
        }else if("turnCrank".equalsIgnoreCase(operation)){
            machine.turnCrank();
            machine.dispense();
        }else{
            System.out.println("您的输入有误，请重新输入");
        }
    }
}
