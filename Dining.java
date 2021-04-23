//Simulator 2 Operating Systems

//There are 5 philosophers eating & thinking together at a table
//Forks are placed between pairs of philosophers (5 forks)
//They need the fork to the right and left of them to eat
//Forks can only be held by one person at a time
//After eating they must put down the fork so that others can eat
//Infinite amount of food exists
//Challenge is to create a concurrent algorithm so that everyone can alternate between eating and thinking

public class Dining implements Runnable{
    //Running philosophers as seperate threads
    //Creating forks on both sides of the philosopher 
    private Object forkLeft;
    private Object forkRight; 

    public Dining(Object forkLeft, Object forkRight){
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try{
            synchronized(forkRight){
                forkRight.pickUp();
                synchronized(forkLeft){
                    forkLeft.pickUp();
                }
            }
            synchronized(forkRight){
                forkRight.putBack();
                synchronized(forkLeft){
                    forkLeft.putBack();
                }
            }

        }
        catch(InterruptedException inter){
            Thread.currentThread().interrupt();
            return;
        }
        
    }

}