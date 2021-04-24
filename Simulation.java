import java.lang.Math;

public class Simulation {

    public boolean deadlock;
    Philosopher[] phils = new Philosopher[5];
    Fork[] forks = new Fork[5];

    public void simulate() throws InterruptedException{

        for(int i = 0; i < 5; i++){
            phils[i] = new Philosopher(forks[i], forks[i+1]); //Left fork = i, Right fork = i+1
            new Thread(phils[i], "The philosopher " + (i+1));
        }

        while(true){ //Check every second if there is a resource deadlock
            Thread.sleep(1000);
            if(!phils[0].isEating && !phils[1].isEating && !phils[2].isEating && !phils[3].isEating && !phils[4].isEating){
                Thread.sleep(1000); //See if it doesn't change
                if(!phils[0].isEating && !phils[1].isEating && !phils[2].isEating && !phils[3].isEating && !phils[4].isEating){
                    //Random Drop Strategy: Something where if no philosophers have eaten for 5 seconds, pick one to randomly drop their forks
                    int r = (int)(Math.random() * 5.0);
                    phils[r].dropLeftFork();
                    phils[r].dropRightFork();

                    /*Full Reset: Tell everyone to drop their forks (do one or the other)
                    for(int i = 0; i < 5; i++){
                    phils[i].dropLeftFork();
                    phils[i].dropRightFork();
                    }*/
                }
            }

            
        }
        
    }

    public static void main(String[] args) throws InterruptedException{

        Simulation sim = new Simulation();
        sim.simulate();
        System.out.println("stuff");
        /* Each philosopher has a left and right fork
            Adjacent philosophers share a fork
            The fork is either held or not held (by one of the philosophers)
            A philosopher can pick up the fork if it isn't held
            When a phil wants to eat, they need to hold both forks 
                -maybe phil has boolean for holdingLeft and holdingRight
            
        */
    }
}