import java.lang.Math;

public class Philosopher implements Runnable{

    private Fork forkLeft;
    private Fork forkRight;
    private Fork forkLeft2;
    private Fork forkRight2;
    public boolean isEating; //if not, they are "thinking"
    public double doneEatingProb;
    
    public Philosopher(Fork forkLeft2, Fork forkLeft, Fork forkRight, Fork forkRight2){
        this.forkLeft2 = forkLeft2;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
        this.forkRight2 = forkRight2;
        isEating = false;
        doneEatingProb = Math.random();
    }

    /*public Philosopher(Fork forkLeft2, Fork forkLeft, Fork forkRight){
        this.forkLeft2 = forkLeft2;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
        isEating = false;
    }

    public Philosopher(Fork forkLeft, Fork forkRight, Fork forkRight2){
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
        this.forkRight2 = forkRight2;
        isEating = false;
    }*/

    @Override
    public void run(){
        try{
            if(isEating){
                if(Math.random() < doneEatingProb)
                    isEating = false; //stop eating
            }
            else {
                if(forkLeft2 != null){
                    synchronized(forkRight){
                        isEating = true;
                    }
                }
                else if(forkRight2 != null){
                    synchronized(forkLeft){
                        isEating = true;
                    }
                }
                else{
                    synchronized(forkLeft){
                        synchronized(forkRight){
                            isEating = true;;
                        }
                    }
                }
            }
        } finally{
            Thread.currentThread().interrupt();

        }
    }

    /*public void takeLeftFork(){
        forkLeft.isHeld = true;
        isHoldingLeft = true;
    }
    public void takeRightFork(){
        forkRight.isHeld = true;
        isHoldingRight = true;
    }
    public void dropLeftFork(){
        forkLeft.isHeld = false;
        isHoldingLeft = false;
    }
    public void dropRightFork(){
        forkRight.isHeld = false;
        isHoldingRight = false;
    }

    public void dine() throws InterruptedException { //This is mostly covered by the synchronized section
        while(true){
            //Basic scenario where you take the fork if you can (doesnt avoid deadlocks)
            if(!forkLeft.isHeld)
                takeLeftFork();
            if(!forkRight.isHeld)
                takeRightFork();
            //Eat if you have both forks
            if(isHoldingLeft && isHoldingRight) { 
                //Eat for 1 second
                isEating = true;
                Thread.sleep(1000); 
                isEating = false;
                dropLeftFork();
                dropRightFork();
            }
        }
    }*/
}