public class Philosophers {
    
    public static void main(String[] args) throws Exception{
        //Create the 5 philosophers as all seperate threads using Dining
        final Dining[] philos = new Dining[5];
        //Create the forks based on the # of philosophers
        Object[] fork = new Object[philos.length];

        for(int i = 0; i < fork.length; i++){
            fork[i] = new Object();
            //make the forks objects
        }

        //make philosophers pick up forks
        for(int i = 0; i < philos.length; i++){
            philos[i] = new Dining(fork[i], fork[i+1]);
            Thread thread = new Thread(philos[i], "Philosopher " + i);
            thread.start();
        }

        
    }
}
