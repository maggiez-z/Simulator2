public class Simulation {

    public boolean deadlock;
    static Philosopher[] phils = new Philosopher[5];
    Fork[] forks = new Fork[6];

    public void simulate() throws InterruptedException{

        for(int i = 0; i < 5; i++){
            if(i == 0) { //Extra fork on the left (assignment choice #1)
                phils[i] = new Philosopher(forks[6], forks[i], forks[i+1], null); //Fork 6 on the left
                Thread thread = new Thread(phils[i], "The philosopher " + (i+1));
                thread.start();
            }
            else if(i == 4) {
                phils[i] = new Philosopher(null, forks[i], forks[i+1], forks[i+2]); //Fork 6 on the right
                Thread thread = new Thread(phils[i], "The philosopher " + (i+1));
                thread.start();                
            }
            else {
                phils[i] = new Philosopher(null, forks[i], forks[i+1], null); //Left fork = i, Right fork = i+1
                Thread thread = new Thread(phils[i], "The philosopher " + (i+1));
                thread.start();
            }
        }

        while(true){ //Check every second if there is a resource deadlock
            Thread.sleep(1000);
            if(!phils[0].isEating && !phils[1].isEating && !phils[2].isEating && !phils[3].isEating && !phils[4].isEating){
                Thread.sleep(1000); //See if it doesn't change
                if(!phils[0].isEating && !phils[1].isEating && !phils[2].isEating && !phils[3].isEating && !phils[4].isEating){
                    //Random Drop Strategy: Something where if no philosophers have eaten for 5 seconds, pick one to randomly drop their forks
                    //int r = (int)(Math.random() * 5.0);
                    //phils[r].dropLeftFork();
                    //phils[r].dropRightFork();

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
        System.out.println("Starting Simulation:\n");

        for(int i = 0; i < 100; i++){ //total number of iterations/steps (can be any number)
            for(int j = 0; j < 5; j++){ //for each philosopher
                //Print if they're eating or thinking
                if(phils[i].isEating)
                    System.out.println("Philosopher " + i + " is eating");
                else
                    System.out.println("Philosopher " + i + " is thinking");
            }
        }
        /* Each philosopher has a left and right fork
            Adjacent philosophers share a fork
            The fork is either held or not held (by one of the philosophers)
            A philosopher can pick up the fork if it isn't held
            When a phil wants to eat, they need to hold both forks 
                -maybe phil has boolean for holdingLeft and holdingRight
            
        */
    }
}