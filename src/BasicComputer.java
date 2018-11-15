import java.util.Scanner;

public class BasicComputer {

    private int accumulator = 00; // Accumulator register
    private int programCounter = 00; // Memory location that contains current instruction
    private int instructRegister = 00; // Next instruction to be performed
    private int opCode = 00; // Operation currently being executed
    private int operand = 00; // Memory location on which current instruction operates
    private int[] memory; // Array of memory values

    // Write series of words (ints) from memory from index memoryLoc, with length given by accumulator
    // Code 34
    private void writeValue(int memoryLoc) {
        int i = 0;
        int memoryIndex = memoryLoc; // Initial memory location to write from
        while (i < accumulator) {
            System.out.print(memory[memoryIndex]);
            i++;
            memoryIndex++;
        }
    }

    // Write series of words from memory from index memoryLoc, with length given by accumulator
    // Code 35
    private void writeAscii(int memoryLoc) {
        int i = 0;
        int memoryIndex = memoryLoc;
        while (i < accumulator) {
            System.out.print((char) memory[memoryIndex]);
            i++;
            memoryIndex++;
        }
    }

    // Read a word from keyboard to a specific memory location
    // Code 33
    private void read(int memoryLoc, Scanner keyboard) {
        memory[memoryLoc] = keyboard.nextInt();
    }

    // Write a word from memory location to console
    // Code 32
    private void write(int memoryLoc) {
        System.out.print(memory[memoryLoc]);
    }

    // Load a word from memory location to the accumulator
    // Code 31
    private void load(int memoryLoc) {
        accumulator = memory[memoryLoc];
    }

    // Store a word from accumulator into specific memory location
    // Code 30
    private void store(int memoryLoc) {
        memory[memoryLoc] = accumulator;
    }

    // Add a word from memory location to the current value of accumulator
    // Code 21
    private void add(int memoryLoc) {
        accumulator += memory[memoryLoc];
    }

    // Subtract the current accumulator from a word at memory location (leaving result in accumulator)
    // Code 20
    private void subtract(int memoryLoc) {
        accumulator = memory[memoryLoc] - accumulator;
    }

    // Divide a word from memory location into the current accumulator (leaving result in accumulator)
    // Code 11
    private void divide(int memoryLoc) {
        accumulator = memory[memoryLoc] / accumulator;
    }

    // Load immediate operand into accumulator
    // Code 29
    private void loadImm(int operand) {
        accumulator = operand;
    }

    // Add immediate operand to the accumlator
    // Code 06
    private void addImm(int operand) {
        accumulator += operand;
    }

    // Subtract immediate operand from accumulator
    // Code 07
    private void decImm(int operand) {
        accumulator -= operand;
    }

    // Multiply accumulator by the immediate operand
    // Code 10
    private void multImm(int operand) {
        accumulator *= operand;
    }

    // Divide immediate operand into accumulator (leaving result in accumulator)
    // Code 09
    private void divideImm(int operand) {
        accumulator = operand / accumulator;
    }

    // Multiply accumulator by a word from memory location
    // Code 10
    private void multiply(int memoryLoc) {
        accumulator *= memory[memoryLoc];
    }

    // Branch to memory location and continue execution from the value there
    // Code 43
    private void branch(int memoryLoc) {
        programCounter = memory[memoryLoc];
        //TODO execute program in programCounter here
    }

    // Branch to memory location and continue execution from the value there if accumulator is negative
    // Code 42
    private void branchNeg(int memoryLoc) {
        if (accumulator < 0) {
            branch(memoryLoc);
        }
    }

    // Branch to memory location and continue execution from the value there if accumulator is positive
    // Code 41
    private void branchPos(int memoryLoc) {
        if (accumulator > 0) {
            branch(memoryLoc);
        }
    }

    // Branch to memory location and continue execution from the value there if accumulator is 0
    // Code 40
    private void branchZero(int memoryLoc) {
        if (accumulator == 0) {
            branch(memoryLoc);
        }
    }

    // Increment word in memory location by 1
    // Code 25
    private void increment(int memoryLoc){
        memory[memoryLoc] += 1;
    }

    // Decrement word in memory location by 1
    // Code 25
    private void decrement(int memoryLoc){
        memory[memoryLoc] -= 1;
    }

    // Halt the program and print a memory dump
    // Code 50
    private void halt(){
        System.out.println("---- Basic-Computer execution terminated ---");
        //TODO print memory dump
    }

}
