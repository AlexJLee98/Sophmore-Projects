//CREATED: ALEXANDER LEE 06/03/2018

import java.io.*;
import java.util.*;
import java.math.*;

public class test {
    public static void main (String args[]) 
    {
        //Test Vector class
        System.out.println("Vector class testing.");
        //Default constructor
        System.out.println("Default constructor test:");
        Vector v1 = new Vector();
        v1.print();
        System.out.println();
        //Int constructor
        System.out.println("X and Y coordinates constructor test:");
        Vector v2 = new Vector(10, 5);
        v2.print();
        System.out.println();
        //Polar Vector
        System.out.println("Polar vector constructor test:");
        Vector v3 = new Vector();
        v3 = v3.polarVector((float) Math.PI, 2);
        v3.print();
        System.out.println();
        //Return x;
        System.out.println("Get x test:");
        float x1 = v2.getX();
        System.out.println("X value of v2 = " + x1);
        //Return y;
        System.out.println("Get y test:");
        float y1 = v2.getY();
        System.out.println("Y value of v2 = " + y1);
        //Return angle;
        System.out.println("Get angle test:");
        float a1 = v3.getAngle();
        System.out.println("Angle of v3 = " + a1 + " radians");
        //Return magnitude;
        System.out.println("Magnitude test:");
        float m1 = v3.getMagnitude();
        System.out.println("Magnitude of v3 = " + m1);
        //Add 2 vectors;
        System.out.println("Add vectors test:");
        Vector v4 = new Vector(20, 10);
        v2.print();
        System.out.print(" + ");
        v4.print();
        System.out.print(" = ");
        Vector v5 = new Vector();
        v5 = v2.add(v4);
        v5.print();
        System.out.println();
        //Subtract 2 vectors;
        System.out.println("Subtract vectors test:");
        Vector v6 = new Vector(30, 15);
        Vector v7 = new Vector(20, 20);
        Vector v8 = new Vector();
        v6.print();
        System.out.print(" - ");
        v7.print();
        System.out.print(" = ");
        v8 = v6.subtract(v7);
        v8.print();
        System.out.println();
        //Dot product of 2 vectors;
        System.out.println("Dot product test:");
        float dp;
        System.out.print("Dot product of ");
        v6.print();
        System.out.print(" & ");
        v7.print();
        System.out.print(" = ");
        dp = v6.dotProduct(v7);
        System.out.println(dp);
        //Scalar multiplication
        System.out.println("Scalar Multiply test:");
        Vector v9 = new Vector();
        float s1 = 3;
        System.out.print("Scalar of ");
        v6.print();
        System.out.print(" & ");
        System.out.print(s1);
        System.out.print(" = ");
        v9 = v6.scalarMultiply(s1);
        v9.print();
        System.out.println();
        //Normalize a vector;
        System.out.println("Normalize Vector test:");
        Vector v10 = new Vector();
        System.out.print("Normalization of ");
        v9.print();
        System.out.print(" = ");
        v10 = v9.normalize();
        v10.print();
        System.out.println();
        //Create a 3D vector
        System.out.println("3D vector test");
        Vector v11 = new Vector(1, 2, 3);
        v11.print3D();
        System.out.println();
        //Cross product of 2 vectors;
        System.out.println("Cross product test:");
        Vector v12 = new Vector(1, 5, 7);
        Vector v13 = new Vector();
        System.out.print("Cross product of ");
        v11.print3D();
        System.out.print(" & ");
        v12.print3D();
        System.out.print(" = ");
        v13 = v11.crossProduct(v12);
        v13.print3D();
        System.out.println();
        //Unit vector of a 3D vector
        System.out.println("Unit vector of 3D vector test:");
        Vector v14 = new Vector();
        System.out.print("Unit vector of ");
        v13.print3D();
        System.out.print(" = ");
        v14 = v13.normalize3D();
        v14.print3D();
        System.out.println();
        //Projection of a vector onto another
        System.out.println("Vector projection test:");
        Vector v15 = new Vector(1, 2);
        Vector v16 = new Vector(3, -8);
        Vector v17 = new Vector();
        System.out.print("Projection of ");
        v16.print();
        System.out.print(" onto ");
        v15.print();
        System.out.print(" = ");
        v17 = v15.projection(v16);
        v17.print();
        System.out.println();     
        //Dot product of 3D vector
        System.out.println("Dot product of 3D Vector test:");
        System.out.print("Dot product of : ");
        v12.print3D();
        System.out.print(" & ");
        v13.print3D();
        System.out.print(" = ");
        float p2 = v12.dotProduct3D(v13);
        System.out.print(p2);
        System.out.println();
        //Prjection of a 3D vector onto another
        System.out.println("3D Vector projection test:");
        Vector v18 = new Vector();
        System.out.print("Projection of ");
        v13.print3D();
        System.out.print(" onto ");
        v12.print3D();
        System.out.print(" = ");
        v18 = v12.projection3D(v13);
        v18.print3D();
        System.out.println();
    }
}

