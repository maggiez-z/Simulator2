public class Philosopher implements Runnable{

    private Fork forkLeft;
    private Fork forkRight;
    public boolean isHoldingLeft;
    public boolean isHoldingRight;
    public boolean isEating;
    
    public Philosopher(Fork left, Fork right){
        this.left = forkLeft;
        this.right = forkRight;
        isHoldingLeft = false;
        isHoldingRight = false;
        isEating = false;
    }

    @Override
    public void run(){
        try{
            while(true){
                synchronized(forkLeft){
                    synchronized(forkRight){

                    }
                }
                synchronized(forkLeft){
                    synchronized(forkRight){

                    }
                }
            }
        }
        catch(InterruptedException interrupt){
            Thread.currentThread().interrupt();
            return;
        }
    }

    public void takeLeftFork(){
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

    public void dine() {
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
    
    }
}