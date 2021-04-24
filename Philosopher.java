public class Philosopher implements Runnable{

    private Fork forkLeft;
    private Fork forkRight;
    public boolean isUsingLeft;
    public boolean isUsingRight;
    
    
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

    public void eat() {

    
    }
}