/**
 * ErrorHandlingExample.java
 * ตัวอย่างการ Error Handling (CLO7)
 * 
 * แสดงการใช้งาน:
 * - try-catch blocks
 * - Multiple exception types
 * - finally block
 * - Input validation
 */

import java.util.Scanner;
import java.util.InputMismatchException;

public class ErrorHandlingExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Error Handling (CLO7)");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // Example 1: Division by zero
        System.out.println(">>> Example 1: Handling ArithmeticException");
        try {
            int result = 10 / 0;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("✗ Error: Cannot divide by zero!");
            System.out.println("  Message: " + e.getMessage());
        }
        
        // Example 2: Array index out of bounds
        System.out.println("\n>>> Example 2: Handling ArrayIndexOutOfBoundsException");
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("✗ Error: Array index out of bounds!");
        }
        
        // Example 3: Multiple catch blocks
        System.out.println("\n>>> Example 3: Multiple catch blocks");
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("✗ Error: Null pointer exception!");
        } catch (Exception e) {
            System.out.println("✗ Error: General exception!");
        }
        
        // Example 4: finally block
        System.out.println("\n>>> Example 4: finally block");
        Scanner scanner = null;
        try {
            scanner = new Scanner(System.in);
            System.out.println("Scanner created");
        } catch (Exception e) {
            System.out.println("Error creating scanner");
        } finally {
            System.out.println("✓ finally block always executes");
            if (scanner != null) {
                scanner.close();
                System.out.println("✓ Scanner closed");
            }
        }
        
        // Example 5: Input validation with error handling
        System.out.println("\n>>> Example 5: Input validation");
        demonstrateInputValidation();
        
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("✓ Error handling ทำให้โปรแกรมไม่ crash");
        System.out.println("✓ ใช้ try-catch จัดการ exceptions");
        System.out.println("✓ finally block ทำงานเสมอ");
        System.out.println("✓ รองรับ CLO7: Develop robust, maintainable software\n");
    }
    
    public static void demonstrateInputValidation() {
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        boolean validInput = false;
        
        while (!validInput) {
            try {
                System.out.print("Enter a number (1-10): ");
                number = scanner.nextInt();
                
                if (number < 1 || number > 10) {
                    System.out.println("✗ Number must be between 1 and 10");
                } else {
                    validInput = true;
                    System.out.println("✓ Valid input: " + number);
                }
                
            } catch (InputMismatchException e) {
                System.out.println("✗ Invalid input! Please enter a number.");
                scanner.nextLine();  // Clear buffer
            }
        }
        
        scanner.close();
    }
}
