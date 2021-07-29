package interview;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Auther: c
 * @Date: 2021/7/21 - 07 - 21 - 21:15
 * @Description: interview
 * @Version: 1.0
 */
public class IsLittleEndian {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe"); //Unsafe构造方法私有，自身有个静态的属性是自己的实例
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null); //field.get方法，获取类或者实例的field值，实例要传入实例，类的传什么都可以
        long a = unsafe.allocateMemory(8);
        unsafe.putInt(a, 0x01020304);
        byte b = unsafe.getByte(a);
        System.out.println(b);
        unsafe.freeMemory(a);
    }
}
