package algorithm.offer;

public class Demo11 {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(numbers[mid]>numbers[right])
                left = mid+1;
            else if(numbers[mid]<numbers[right])
                right = mid;
            else
                right--;
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3,4,5,6,7,1,3,3};
        int i = new Demo11().minArray(arr);
        System.out.println(i);
    }
}
