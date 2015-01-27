package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

class TwoD {
    int x;
    int y;

    TwoD(int a, int b) {
        x = a;
        y = b;
    }
}

class ThreeD extends TwoD {
    int z;

    ThreeD(int a, int b, int c) {
        super(a,b);
        z = c;
    }
}

class FourD extends ThreeD {
    int t;

    FourD(int a, int b, int c, int d) {
        super(a,b,c);
        t = d;
    }
}

class Coords<T extends TwoD> {
    T[] coords;

    Coords(T[] o) {
        coords = o;
    }
}
public class DemoBoundedWildcardArg1 {
    static void showXY(Coords<?> c) {
        System.out.println("X Y Coordinates:");
        for(int i=0 ; i<c.coords.length ; i++) {
            System.out.println(c.coords[i].x + " , " + c.coords[i].y);
        }
        System.out.println();
    }

    static void showXYZ(Coords<? extends ThreeD> c) {
        System.out.println("X Y Z Coordinates: ");
        for(int i=0 ; i<c.coords.length ; i++) {
            System.out.println(c.coords[i].x + " , " + c.coords[i].y + " , " + c.coords[i].z);
        }
        System.out.println();
    }

    static void showXYZT(Coords<? extends FourD> c) {
        System.out.println("X Y Z T Coordinates: ");
        for(int i=0 ; i<c.coords.length ; i++) {
            System.out.println(c.coords[i].x + " , " + c.coords[i].y + " , " + c.coords[i].z + " , " + c.coords[i].t);
        }
        System.out.println();

    }

    public static void main(String[] args) {
        TwoD[] td = {
                new TwoD(0,0),
                new TwoD(7,9),
                new TwoD(18,4),
                new TwoD(-1,-8)
        };

        Coords<TwoD> tdlocs = new Coords<>(td);

        System.out.println("Contents of tdlocs.");
        showXY(tdlocs);
        // showXYZ(tdlocs); // ERROR, not a ThreeD
        // showXYZT(tdlocs); // ERROR, not a FourD

        FourD[] fd = {
                new FourD(1,2,3,4),
                new FourD(-1,2,5,10),
                new FourD(22,9,10,1),
                new FourD(-1,-10,-22,11)
        };

        Coords<FourD> fdlocs = new Coords<>(fd);
        System.out.println("Contents of fdlocs.");
        showXY(fdlocs);
        showXYZ(fdlocs);
        showXYZT(fdlocs);
    }
}
