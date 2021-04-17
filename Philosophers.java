public class Philosophers {
    
    public static void main(String[] args) throws Exception{
        //Create the 5 philosophers as all seperate threads using Dining
        Dining[] philos = new Dining[5];
        //Create the forks based on the # of philosophers
        Object[] fork = new Object[philos.length];

        for(int i = 0; i < fork.length; i++){
            fork[i] = new Object();
            //make the forks objects
        }

    }
}
