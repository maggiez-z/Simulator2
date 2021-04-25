import java.lang.Math;

public class Philosopher implements Runnable{

    private Fork forkLeft;
    private Fork forkRight;
    private Fork forkLeft2;
    private Fork forkRight2;
    //public boolean isHoldingLeft;
    //public boolean isHoldingRight;
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
                        Thread.sleep(10);
                    }
                }
                else if(forkRight2 != null){
                    synchronized(forkLeft){
                        isEating = true;
                        Thread.sleep(10);
                    }
                }
                else{
                    synchronized(forkLeft){
                        synchronized(forkRight){
                            isEating = true;;
                            Thread.sleep(10);
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
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

    public void run() { //This is mostly covered by the synchronized section
        if(isEating){
            if(Math.random() < doneEatingProb)
                isEating = false; //stop eating
                dropLeftFork();
                dropRightFork();
        }
        else {
            if(forkLeft2 != null && !forkRight.isHeld) {
                takeRightFork();
                isEating = true;
            }  
            else if(forkRight2 != null && !forkLeft.isHeld){
                takeLeftFork();
                isEating = true;
            }
            //Basic scenario where you take the fork (no duplicate)
            else if(!forkLeft.isHeld && !forkRight.isHeld) {              
                    takeLeftFork();
                    takeRightFork();
                    isEating = true;
                }
        }
            //Eat if you have both forks
            //if(isHoldingLeft && isHoldingRight) { 
            //Eat for 1 second
    }*/
}