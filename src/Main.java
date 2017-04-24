import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        Solovay s = new Solovay(new BigInteger("31"));
        System.out.println(s.isPrime(1000));


        Lucas l=new Lucas(new BigInteger("31"));
        System.out.println(l.isPrime());
    }
}
