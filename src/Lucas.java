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
        int p=getP();
        if(isPrime(p)==false)
            return false;
        BigInteger s=new BigInteger("4");
        int iteration=1;
        while(iteration!=p-1){
            BigInteger sPatrat=s.pow(2);
            if(sPatrat.intValue()-2>n.intValue())
                s=new BigInteger(String.valueOf(modularReduction(sPatrat.intValue()-2,p,n.intValue()))).mod(n);
            else
                s=sPatrat.subtract(new BigInteger("2"));

            iteration++;
        }
        return s.intValue()==0;
    }

    private boolean isPrime(int p)
    {
        for(int i=2;i<=p/2;i++)
            if(p%i==0)
                return false;
        return true;
    }

    public int modularReduction(int value,int p,int n){
        int currX1=1;
        int prevX1=1;
        while(currX1*Math.pow(2,p)<value)
        {
            prevX1=currX1;
            currX1++;
        }
        int x1=prevX1;
        int x2=value - (int) (Math.pow(2,p)*x1);
        return x1+x2;
    }
}
