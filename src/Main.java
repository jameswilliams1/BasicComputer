import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        BasicComputer computer = new BasicComputer();
        for(int i = 0; i<100; i++){
            computer.memory[i] = i;
        }
        //computer.printAll();
    }
}
