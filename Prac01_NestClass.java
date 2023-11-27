package mypack1;

import java.lang.Math;
import java.time.Clock;
class Outer01 {
    int Ary[];
    Outer01(int ary[]) {
        this.Ary = ary.clone();
    }

    int[] analytic() {
        inner_N inner01 = new inner_N();
        int Ary03[] = inner01.exp_n();
        return Ary03;
    }

    // inner class non-static
    class inner_N {
        int n = 3;
        int[] exp_n() {
            int nk = Outer01.this.Ary.length;
            int ary_n[] = new int[nk];
            int i = 0;
            for (int x:Outer01.this.Ary) {
                ary_n[i] = x*this.n;
                i++;
            }
            return ary_n;
        }
    }

}

class MainC {
    public static void main(String[] args) {
        int aryInput[] = {1,2,3,4,5};
        Outer01 out1 = new Outer01(aryInput);
        int Ary_M1[] = out1.analytic();
        for (int i:Ary_M1) {
            System.out.println("Out Analytics " + i);
        }
        // call the inner_n exp_n method from a new instance
        Outer01.inner_N in01 = out1.new inner_N();
        int Ary_In1[] = in01.exp_n();
        for (int i:Ary_In1) {System.out.println("inner_N exp_n "+ i);}
    }
}
