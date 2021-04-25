public class Simulation {

    public boolean deadlock;
    static Philosopher[] phils = new Philosopher[5];
    Fork[] forks = new Fork[6];

    public void setup() throws InterruptedException{
        for(int i = 0; i < 6; i++){
            forks[i] = new Fork();
        }
    
        for(int i = 0; i < 5; i++){
            if(i == 0) { //Extra fork on the left (assignment choice #1)
                phils[i] = new Philosopher(forks[5], forks[i], forks[i+1], null); //Fork 6 on the left
                Thread thread = new Thread(phils[i], "The philosopher " + (i+1));
                thread.start();
            }
            else if(i == 4) {
                phils[i] = new Philosopher(null, forks[i], forks[i+1], forks[0]); //Fork 6 on the right
                Thread thread = new Thread(phils[i], "The philosopher " + (i+1));
                thread.start();                
            }
            else {
                phils[i] = new Philosopher(null, forks[i], forks[i+1], null); //Left fork = i, Right fork = i+1
                Thread thread = new Thread(phils[i], "The philosopher " + (i+1));
                thread.start();
            }
            System.out.println("test");
        }
    }

    public void simulate() throws InterruptedException{

        //For loop for every step in the simulation
        for(int i = 0; i < 100; i++){
            //run for each philosopher
            for(int j = 0; j < 5; j++){
                phils[j].run();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int numThinks = 0;
        int numEats = 0;
        double thinkTime = 0;
        double eatTime = 0;
        Simulation sim = new Simulation();
        sim.setup();
        System.out.println("Starting Simulation:\n");
        //sim.simulate();
        

        for(int i = 0; i < 100; i++){ //total number of iterations/steps (can be any number)
            System.out.println("Step " + i + ":\n");
            for(int j = 0; j < 5; j++){ //for each philosopher
                //Print if they're eating or thinking
                phils[j].run();
                if(phils[j].isEating){
                    System.out.println("Philosopher " + (j + 1) + " is eating");
                    numEats++;
                }
                else{
                    System.out.println("Philosopher " + (j + 1) + " is thinking");
                    numThinks++;
                }
                eatTime = numEats / (i+1);
                thinkTime = numThinks / (i+1);
            }        
            System.out.println(numEats + " Eats, " + numThinks + " Thinks");
            System.out.println("Eating fraction = " + eatTime);
            System.out.println("Thinking fraction = " + thinkTime);
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