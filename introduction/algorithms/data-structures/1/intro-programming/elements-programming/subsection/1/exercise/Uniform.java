// Exercise 1.2.30, pag. 48, book Computer Science: An Interdisciplinary Approach
// Uniform random numbers. Write a program that prints five uniform
// random numbers between 0 and 1, their average value, and their minimum and
// maximum values. Use Math.random(), Math.min(), and Math.max().

public class Uniform 
{
    public static void main(String[] args) 
    {
        double a = Math.random();
        double b = Math.random();

        System.out.println(a);
        System.out.println(b);
        System.out.println("min(" + a + ", " + b + ") = " + Math.min(a,b));
        System.out.println("max(" + a + ", " + b + ") = " + Math.max(a,b));
        System.out.println("average(" + a + ", " + b + ") = " + (a+b)/2);
    }
}
