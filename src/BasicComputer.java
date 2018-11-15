import java.text.DecimalFormat;
import java.util.Scanner;

public class BasicComputer {

    private int accumulator; // Accumulator register
    private int programCounter; // Memory location that contains current instruction
    private int instructRegister; // Next instruction to be performed
    private int opCode; // Operation currently being executed
    private int operand; // Memory location on which current instruction operates
    public int[] memory; // Array of memory values


    // Set all registers to 0 and memory size to 100
    public BasicComputer() {
        this.accumulator = 0000;
        this.programCounter = 00;
        this.instructRegister = 0000;
        this.opCode = 00;
        this.operand = 00;
        this.memory = new int[100];
    }

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

    // Add a word from memory location to the current value of accumulator (leaving result in accumulator)
    // Code 21
    private void add(int memoryLoc) {
        accumulator += memory[memoryLoc];
    }

    // Subtract a word at memory location from the current accumulator (leaving result in accumulator)
    // Code 20
    private void subtract(int memoryLoc) {
        accumulator -= memory[memoryLoc];
        //TODO check this is the right order
    }

    // Divide a word from memory location into the current accumulator (leaving result in accumulator)
    // Code 11
    private void divide(int memoryLoc) {
        accumulator = memory[memoryLoc] / accumulator;
        //TODO check this is the right order
    }

    // Load immediate operand into accumulator
    // Code 29
    private void loadImm(int operand) {
        accumulator = operand;
    }

    // Add immediate operand to the accumulator (leaving result in accumulator)
    // Code 06
    private void addImm(int operand) {
        accumulator += operand;
    }

    // Subtract immediate operand from accumulator (leaving result in accumulator)
    // Code 07
    private void decImm(int operand) {
        accumulator -= operand;
        //TODO check this is the right order
    }

    // Multiply accumulator by the immediate operand
    // Code 08
    private void multImm(int operand) {
        accumulator *= operand;
    }

    // Divide immediate operand into accumulator (leaving result in accumulator)
    // Code 09
    private void divideImm(int operand) {
        accumulator = operand / accumulator;
        //TODO check this is the right order
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
    private void increment(int memoryLoc) {
        memory[memoryLoc] += 1;
    }

    // Decrement word in memory location by 1
    // Code 26
    private void decrement(int memoryLoc) {
        memory[memoryLoc] -= 1;
    }

    // Halt the program and print a memory dump and all registers
    // Code 50
    private void halt() {
        System.out.println("---- Basic-Computer execution terminated ---");
        printAll();
    }

    // Print a memory dump and all registers
    public void printAll() {
        System.out.println();
        System.out.println("Registers:");
        System.out.println();
        System.out.printf("Accumulator           %+05d", accumulator);
        System.out.println();
        System.out.printf("Program Counter        %02d", programCounter);
        System.out.println();
        System.out.printf("Instruction Register  %+05d", instructRegister);
        System.out.println();
        System.out.printf("Operation Code         %02d", opCode);
        System.out.println();
        System.out.printf("Operand                %02d", operand);
        System.out.println();
        System.out.println();

        // Array of 10 lines of 10 elements from memory
        String[] lines = new String[10];
        // Shows memory in a consistent format with signs
        DecimalFormat fourNum = new DecimalFormat("+0000");
        DecimalFormat twoNum = new DecimalFormat("00");
        // Makes print friendly string from each 10 memory values
        for (int i = 0; i < lines.length; i++) {
            String line = "";
            for (int j = i * 10; j < i * 10 + 10; j++) {
                line += (fourNum.format(memory[j])) + "  ";
            }
            lines[i] = line;
        }
        System.out.println("Memory Dump:");
        System.out.println();
        System.out.println("     0      1      2      3      4      5      6      7      8      9");
        for (int i = 0; i < lines.length; i++) {
            System.out.println(twoNum.format(i) + "  " + lines[i]);
        }
    }

}
