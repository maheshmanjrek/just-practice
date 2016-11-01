/*
 * Write a program that will determine the type of a triangle. 
 * It should take the lengths of the triangle's three sides as input, and 
 * return whether the triangle is equilateral, isosceles or scalene.
 */
package trianglechecker;

/**
 *
 * @author Mahesh Manjrekar
 */
public class Triangle {
    
    private final double sideA, sideB, sideC;

    //Constructor
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }
    
    //Define types of triangle
    public enum TriangleType {EQUILATERAL, SCALENE, ISOSCELES};
    
    public TriangleType getTriangleType () {
        //Check length positive
        if (!checkSideLengthPositive())
            throw new IllegalArgumentException("The length of the side cannot be zero or negative");
        
        //Check side equality
        if (!checkSideEquality())
            throw new IllegalArgumentException("The length of 2 sides should be greater than third");
        
        //Equilateral has all sides of equal length
        if (sideA == sideB && sideB == sideC) 
            return TriangleType.EQUILATERAL;
        
        //Isosceles has 2 sides equal
        if (sideA == sideB || sideA == sideC || sideB == sideC)
            return TriangleType.ISOSCELES;
        
        //Scalene has all 3 sides unequal
        return TriangleType.SCALENE;
        
    }
    
    //Side of triangle cannot be 0 or negative
    public boolean checkSideLengthPositive() {    
        //Check if lengtth of side is positive
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) 
            return false;   
        else
            return true;
        
    }
    
    //If side of a triangle is greater than sum of other 2 sides 
    //then its an invalid triangle
    public boolean checkSideEquality() {
        
        //Check if one side is greater than or equal to two other sides
        if (sideA > (sideB + sideC) || 
            sideB > (sideA + sideC) ||
            sideC > (sideA + sideB))
            return false;
        else
            return true;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Uncomment to test negative condition
        //Triangle tri1 = new Triangle(-2, 4.2, 6);
        //System.out.println("Triangle type ="  + tri1.getTriangleType().toString());
        
        //Uncomment to test negative condition
        //Triangle tri2 = new Triangle(2, 4.2, 7.5);
        //System.out.println("Triangle type ="  + tri2.getTriangleType().toString());
        
        Triangle tri3 = new Triangle(2, 4.2, 6);
        System.out.println("Triangle type ="  + tri3.getTriangleType().toString());
        
        Triangle tri4 = new Triangle(2, 6, 6);
        System.out.println("Triangle type ="  + tri4.getTriangleType().toString());
        
        Triangle tri5 = new Triangle(4.5, 4.5, 4.5);
        System.out.println("Triangle type ="  + tri5.getTriangleType().toString());
    }
    
}