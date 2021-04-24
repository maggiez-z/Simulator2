public class Simulation {


    Philosopher[] phils = new Philosopher[5];
    Object[] forks = new Object[5];

    public void simulate(){

        for(int i = 0; i < 5; i++){
            phils[i] = new Philosopher();
            phils[i].forkLeft = forks[i]; //Left fork
            phils[i].forkRight = forks[i+1]; //Right fork
        }

    }

    public static void main(String[] args){

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