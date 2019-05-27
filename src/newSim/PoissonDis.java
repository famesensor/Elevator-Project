package newSim;

public class PoissonDis {
    private double lambda; //mean value
    private double randomvalue;
    private double prob; // probability
    private int count;
//    private static int maxFloor = 10; // max floor of the building
    /* maxFloor should be defined in Building class*/

    public PoissonDis(){
//        System.out.println("Poisson Distribution random value is started.");
    }

    /* กำหนดให้ทุก ๆ 5 นาที จะมีคนมาที่ชั้น 1 10 คน */

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

//    protected void setMaxFloor(int num){
//        this.maxFloor = num;
//    }
//
//    protected int getMaxFloor(){
//        return this.maxFloor;
//    }

    /* ในเวลาปกติ กำหนดว่าทุก ๆ 15 คน จะมีคนลงไปชั้น 1 5 คน แล้วที่เหลือจะไปชั้นอื่น โดยถ้าความน่าจะเป็นที่จะไปชั้น 1 น้อยกว่า 40% จะเดินทางไปชั้นอื่น*/
    /* ในเวลาเร่งรีบ(เย็น) กำหนดว่าทุก ๆ 5 คนจะมีคนไปชั้น 1 4 คน */
    /* กำหนด ทุก ๆ 15 นาที มีคนเกิด 10 คน ทำให้ mean (lambda = 10) และนาฬิกาของโปรแกรมจะมีมีค่า 1 วินาทีจริง = 15 นาที) */

    protected int randomfloor(){
        int destinationFloor;
//        double Probval;

//        if(liftStatus == 1){
//            while(true){
//                randomvalue = (int)(Math.random()* Building.MAX_FLOORS)+1;
//                if(randomvalue > presentFloor) break;
//            }
//        }else if(liftStatus == -1){
//            while(true){
//                randomvalue = (int)(Math.random()* Building.MAX_FLOORS)+1;
//                if(randomvalue < presentFloor) break;
//            }
//        }else if(liftStatus == 0){
//            while(true){
//                randomvalue = (int)(Math.random()* Building.MAX_FLOORS)+1;
//                if(randomvalue != presentFloor) break;
//            }
//        }

        while(true){
            randomvalue = (int)(Math.random()* Building.MAX_FLOORS)+1;
//            if(randomvalue > presentFloor) break;
        }



//        Probval = PoissonProb(5,peopleNumber); // เวลาปกติ
//        System.out.println("Probval : "+Probval);
//
//        if(Probval*100 < 40){
//            while (true){
//                randomvalue = (int)(Math.random()*maxFloor)+1;
//                if(randomvalue != presentFloor && randomvalue != 1) break;
//            }
//        }else{
//            randomvalue = 1;
//        }

//        destinationFloor = (int)(randomvalue);
//        return destinationFloor;
    }

    private double PoissonProb(double mean, int humanNumber){
        lambda = mean * Math.ceil((double)(humanNumber)/15);
        double ProbVal = 0;


//        ProbVal = (Math.pow(lambda,humanNumber)*Math.exp(-lambda))/factorial(humanNumber);


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
