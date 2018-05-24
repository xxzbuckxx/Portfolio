import java.math.*;
/**
 * Write a description of class Fraction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fraction implements Comparison
{
    private int numerator;
    private int denominator;
    
    public Fraction(int n, int d){
        numerator = n;
        denominator = d;
    }
    
    public int getNum(){return numerator;}
    
    public int getDen(){return denominator;}
    
    public String toString(){return numerator + "/" + denominator;}
    
    public boolean equals(Fraction other){return !(greaterThan(other) || lessThan(other));}
    
    public Fraction add(Fraction other){
        int num1 = reduce(other).getNum();
        int den1 = reduce(other).getDen();
        int num2 = reduce(this).getNum();
        int den2 = reduce(this).getDen();
        int gcd = gcd(den1, den2);
        num1 *= den2;
        num2 *= den1;
        num1 += num2;
        
        return reduce(new Fraction(num1, den1*den2));
    }
    
    public Fraction subtract(Fraction other){
        return add(new Fraction(other.getNum()*-1, other.getDen()));
    }
    
    public Fraction multiply(Fraction other){
        return new Fraction(reduce(new Fraction(numerator*other.getNum(), denominator*other.getDen())).getNum(), reduce(new Fraction(numerator*other.getNum(), denominator*other.getDen())).getDen());
    }
    
    public Fraction divide(Fraction other){
        return multiply(new Fraction(other.getDen(), other.getNum()));
    }
    
    public static Fraction reduce(Fraction other){
        int gcd = gcd(other.getNum(), other.getDen());
        return new Fraction(other.getNum()/gcd, other.getDen()/gcd);
    }
    
    public static int gcd(int num, int den){
        return BigInteger.valueOf(den).gcd(BigInteger.valueOf(num)).intValue();
    }
    
    public double evaluate(){
        return (double)((double)numerator/(double)denominator);
    }
    
    public boolean greaterThan(Object other){
        return ((Fraction) other).evaluate() < evaluate();
    }
    
    public boolean lessThan(Object other){
        return ((Fraction) other).evaluate() > evaluate();
    }
}
