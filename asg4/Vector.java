//CREATED: ALEXANDER LEE 06/03/2018

import java.io.*;
import java.util.*;
import java.math.*;

// Vector.java
// A class that implements the Vector ADT.

// Notes:
// Angles are always in radians, not degrees.

class Vector 
{
    float x;
    float y;
    float z;
    float magnitude;
    float angle;
    
    //Power for floats
    public float power(final float base, final int power) 
    {
        float result = 1;
        for (int i = 0; i < power; i++) {
        result *= base;
    }
        return result;
    }
    
    //Create a new Vector with no magnitude.
    public Vector() 
    {
        this.x = 0;
        this.y = 0;
    }
    
    //Takes an x and a y coordinate for the Vector.
    public Vector(float x, float y) 
    {
        this.x = x;
        this.y = y;
        this.magnitude = (float)(Math.sqrt(power(x, 2) + power(y, 2)));
    }

    //Takes an angle and a magnitude for the Vector.
    public Vector polarVector(float angle, float magnitude) 
    {
        Vector polarVector = new Vector();
        polarVector.angle = angle;
        polarVector.magnitude = magnitude;
        polarVector.x = magnitude * (float) Math.cos(angle);
        polarVector.y = magnitude * (float) Math.sin(angle);
        return polarVector;
    }

    //Access functions

    //Returns the x coordinate of the Vector.
    public float getX() 
    {
        return this.x;  
    }

    //Returns the y coordinate of the Vector.
    public float getY() 
    {
        return this.y;    
    }

    //Returns the angle of the Vector.   
    public float getAngle() 
    {
        return this.angle;
    }

    //Returns the magnitude of the Vector.
    public float getMagnitude() 
    {
        return this.magnitude;  
    }
    
    //Adds two vectors
    public Vector add(Vector other) 
    {
        Vector answer = new Vector(0, 0);
        answer.x = this.x + other.x;
        answer.y = this.y + other.y;
        return answer;
    }
    
    //Subtracts two vectors
    public Vector subtract(Vector other) 
    {
        Vector answer = new Vector(0, 0); 
        answer.x = this.x - other.x;
        answer.y = this.y - other.y;
        return answer;
    }

    //Returns the dot product of this Vector and the given Vector.
    public float dotProduct(Vector other) 
    {
        float answer = (this.x * other.x) + (this.y * other.y);
        return answer;
    }

    //Returns this Vector scaled by the given scalar.
    public Vector scalarMultiply(float scalar) 
    {
        Vector answer = new Vector(0, 0);
        answer.x = this.x * scalar;
        answer.y = this.y * scalar;
        return answer;
    }

    //Returns the normalized version of this Vector, a Vector with the same
    //angle with magnitude 1.
    public Vector normalize() 
    {
        float denom;
        Vector answer = new Vector(0, 0);     
        denom = (float) Math.sqrt(power(this.x, 2) + power(this.y, 2));
        answer.x = x/denom;
        answer.y = y/denom;
        return answer;
    }
    
    //Print 2D vector
    public void print() 
    {
        System.out.print(this.x);
        System.out.print(',');
        System.out.print(this.y);
    }
    
    public void print3D() 
    {
        System.out.print(this.x);
        System.out.print(',');
        System.out.print(this.y); 
        System.out.print(',');
        System.out.print(this.z); 
    }
    
    //3D Vector int constructor
    public Vector(float x, float y, float z) 
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    //Cross product of 3D vector
    public Vector crossProduct(Vector other) 
    {
        Vector answer = new Vector(0, 0, 0);
        answer.x = (this.y * other.z) - (this.z * other.y);
        answer.y = (this.z * other.x) - (this.x * other.z);
        answer.z = (this.x * other.y) - (this.y * other.x);
        return answer;
    }
    
    //Unit vector of a 3D vector
    public Vector normalize3D() 
    {
        float denom;
        Vector answer = new Vector();   
        denom = (float) Math.sqrt(power(this.x, 2) + power(this.y, 2) + power(this.z, 2));
        answer.x = x/denom;
        answer.y = y/denom;
        answer.z = z/denom;
        return answer;
    }
  
    //Projection of a vector on another
    public Vector projection(Vector other) 
    {
        float numerator = dotProduct(other);
        float denominator = (float) Math.sqrt(power(this.x, 2) + power(this.y, 2));
        float multiplier = numerator/power(denominator, 2);
        Vector answer = new Vector();
        answer.x = multiplier * this.x;
        answer.y = multiplier * this.y;
        return answer;
    }
    
    //Dot product of a 3D vector
    public float dotProduct3D(Vector other) 
    {
        float answer = (this.x * other.x) + (this.y * other.y) + (this.z * other.z);
        return answer;
    }
    
     //Projection of a 3D vector on another
    public Vector projection3D(Vector other) 
    {
        float numerator = dotProduct3D(other);
        float denominator = (float) Math.sqrt(power(this.x, 2) + power(this.y, 2) + power(this.z, 2));
        float multiplier = numerator/power(denominator, 2);
        Vector answer = new Vector();
        answer.x = multiplier * this.x;
        answer.y = multiplier * this.y;
        return answer;
    }
    
  // Manipulation functions
  // None.  Vectors are immutable.

}

