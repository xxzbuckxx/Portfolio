
/**
 * Write a description of class tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class tester
{
    public static void main(String args[]){
        Fraction n1 = new Fraction(1, 2);
        Fraction n2 = new Fraction(2, 4);
        Fraction n3 = new Fraction(3, 5);
        //System.out.println(n1);
        //System.out.println(n2);
        //System.out.println(n2.reduce(n2));
        //System.out.println(n2);
        System.out.println(n2.add(n1));
        System.out.println(n2.equals(n1));
        
        //System.out.println(n3.add(n1));
        //System.out.println(n1.add(n3));
        //System.out.println(n1.multiply(n3));
        //System.out.println(n3.multiply(n1));
    }
}
