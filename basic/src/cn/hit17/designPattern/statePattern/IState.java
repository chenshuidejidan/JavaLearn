package cn.hit17.designPattern.statePattern;

/** 未投币状态：1.(投币)->已投币状态
 *  已投币状态：1.(退币)->未投币状态   2。(转动手柄)->售出商品状态
 *  售出商品状态： 1. (售出：商品数>0)->未投币状态  2.(售出：商品数<=0)->商品售罄状态
 *  商品售罄状态：
 */

public interface IState {
   public void addCoin();
   public void backCoin();
   public void turnCrank();
   public void dispense();
}
