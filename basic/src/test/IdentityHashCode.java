package test;

import java.util.HashMap;

/**
 * @Auther: c
 * @Date: 2021/7/28 - 07 - 28 - 22:00
 * @Description: test
 * @Version: 1.0
 */
public class IdentityHashCode {
    public static void main(String[] args) {
        class User {
            String Name;
        }
        User user = new User();
        user.Name = "jjj";
        HashMap<User, Integer> map = new HashMap<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (user){
                    user.Name = "jjj";
                }
            }
        }).start();
        synchronized (user) {
            map.put(user, 1);
            Integer integer = map.get(user);
            System.out.println(integer);
        }
    }
}
