package elevatorSimulator;

public class PoissonDis {
    private double lambda; //mean value
    private double randomvalue;
    private double prob; // probability
    private int count;

    protected int PoissonRandom(double mean){
        lambda = Math.exp(-mean);
        count = 0;
        prob = 1;

        do{
            count++;
            randomvalue = (double)(Math.random()*1);
            prob *= randomvalue;
        }while (prob > lambda);
        return count - 1;
    }

    private double PoissonProb(double mean, int humanNumber){
        lambda = mean * Math.ceil((double)(humanNumber)/15);
        double ProbVal = 0;

        for(int i=0; i<=humanNumber; i++){
            ProbVal += (Math.pow(lambda,i)*Math.exp(-lambda))/factorial(i);
        }

        return ProbVal;
    }

    private double factorial(int val){
        double ans = 1;

        for(int i=1; i<=val ;i++){
            ans *= i;
        }

        return ans;
    }
}
