public class Philosopher implements Runnable{

    private Object forkLeft;
    private Object forkRight;
    
    
    
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
            Thread.currentThread().inteerupt();
            return;
        }
    }

}