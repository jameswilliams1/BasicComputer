import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        BasicComputer computer = new BasicComputer();
        computer.loadProgram("/home/user/IdeaProjects/BasicComputer/src/testProgram.txt");
        computer.run();

    }
}
