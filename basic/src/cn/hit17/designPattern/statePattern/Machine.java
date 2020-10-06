package cn.hit17.designPattern.statePattern;

public class Machine {
    private IState noCoinAddState;
    private IState coinAddedState;
    private IState soldState;
    private IState soldOutState;
    private int count;
    private IState currentState;
    public Machine(int count) {
        this.count = count;
        noCoinAddState = new NoCoinAddState(this);
        coinAddedState = new CoinAddedState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        currentState = noCoinAddState;
    }
    public void addCoin(){
        currentState.addCoin();
    }
    public void backCoin(){
        currentState.backCoin();
    }
    public void turnCrank(){
        currentState.turnCrank();
    }
    public void dispense(){
        currentState.dispense();
    }

    public IState getNoCoinAddState() {
        return noCoinAddState;
    }

    public IState getCoinAddedState() {
        return coinAddedState;
    }

    public IState getSoldState() {
        return soldState;
    }

    public IState getSoldOutState() {
        return soldOutState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setCurrentState(IState state){
        this.currentState = state;
    }

    public IState getCurrentState() {
        return currentState;
    }
}
