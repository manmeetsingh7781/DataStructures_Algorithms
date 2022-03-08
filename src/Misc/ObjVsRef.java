package Misc;

import java.util.Arrays;

public class ObjVsRef {
    static class A {
        int data[];

        A(int x) {
            data = new int [] {x};
        }

        public void setX(int v) {
            data[0] = v;
        }

        @Override
        public String toString() {
            return Arrays.toString(data);
        }
    }

    public static void main(String[] args) {

        A a = new A(1000);  
        A b = a;                // b is a reference to a, which means whatever changes to b will also change a and vice versa
        b.setX(0);              // b.setX(0) will also change a.data[0] = 0
        System.out.println(a);
        System.out.println(b);
        
        

        int x = 10;
        int y = x;              // copies the value of x to y, does not create a reference to x so x and y are independent
        y = 100;                // doesnt change x, but changes y
        System.out.println(x);
        System.out.println(y);


        int [] ar = {10, 11};
        int [] br = ar;             // br is a reference to ar, so whatever changes to br will also change ar, does not create a copy of ar

        br[0] = -10;                // any changes to br will also change ar and vice versa

        System.out.println(Arrays.toString(ar));
        System.out.println(Arrays.toString(br));
        
    }
}
