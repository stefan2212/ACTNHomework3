import java.math.BigInteger;

/**
 * Created by stfcr on 4/24/2017.
 */
public class Lucas {
    private BigInteger n;
    public Lucas(BigInteger n){
        this.n=n;
    }

    private int getP(){
        int p=1;
        while(Math.pow(2,p)-1!=n.intValue())
            p++;
        return p;
    }

    public boolean isPrime(){
        BigInteger s=new BigInteger("4");
        int p=getP();
        int iteration=1;
        while(iteration!=p-1){
            BigInteger sPatrat=s.pow(2);
            s=sPatrat.subtract(new BigInteger("2")).mod(n);
            iteration++;
        }
        return s.intValue()==0;
    }
}
