import java.math.BigInteger;
import java.util.Random;

/**
 * Created by stfcr on 4/23/2017.
 */
public class Solovay {
    private BigInteger n;
    public Solovay(BigInteger number){
        this.n=number;
    }

    public boolean isPrime(int iterations){
        boolean afirmation=true;
        Random r= new Random();
        for(int i=0;i<iterations;i++){
            int e = r.nextInt(n.intValue()/2);
            if(e<n.intValue()/2 && e>=2)
                afirmation=afirmation && isPrime(new BigInteger(String.valueOf(e)));
        }
        return afirmation;

    }

    public boolean isPrime(BigInteger e){
        BigInteger rest =  n.mod(new BigInteger("2"));
        if(rest.equals(new BigInteger("1"))==false)
            return false;
        else{
            try {
                rest = n.mod(e);
                if (rest.equals(new BigInteger("0")) == true)
                    return false;
                else {
                    BigInteger nMinus1 = n.subtract(new BigInteger("1"));
                    BigInteger nMinusDiv2 = nMinus1.divide(new BigInteger("2"));
                    BigInteger eValue = e.modPow(nMinusDiv2, n);
                    BigInteger jacoby = new BigInteger(String.valueOf(Jacoby(e, n))).mod(n);
                    if (eValue.equals(jacoby))
                        return true;
                    return false;
                }
            }
            catch (ArithmeticException exception) {
            }
        }
        return true;
    }


    public int Jacoby(BigInteger e,BigInteger n){
        int a=e.intValue();
        int p=n.intValue();
        if(p<=0 || p%2==0)
            return 0;
        int j=1;
        if(a<0){
            a=-a;
            if(p%4==3)
                j=-j;
        }
        while(a!=0){
            while(a%2==0)
            {   a/=2;
                if(p%8==3 || p%8==5) {
                    j=-j;
                }
            }
            int aux=a;
            a=p;
            p=aux;
            if(a%4==3 && p%4==3)
            {
                j=-j;
            }
            a=a%p;
        }
        if(p==1)
            return j;
        return 0;
    }
}
