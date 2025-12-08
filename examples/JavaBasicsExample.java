/**
 * JavaBasicsExample.java
 * ตัวอย่างพื้นฐาน Java Programming (CLO1)
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - Program Structure
 * - Variables และ Data Types
 * - Input/Output
 * - Operators (Arithmetic, Relational, Logical)
 * - Type Conversion
 */

import java.util.Scanner;

public class JavaBasicsExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่างพื้นฐาน Java Programming");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // ============================================
        // ส่วนที่ 1: Variables และ Data Types
        // ============================================
        System.out.println(">>> ส่วนที่ 1: Variables และ Data Types");
        
        // Primitive types
        byte age = 25;
        short year = 2024;
        int population = 70000000;
        long distance = 9876543210L;
        
        float price = 99.99f;
        double pi = 3.14159265359;
        
        char grade = 'A';
        boolean isStudent = true;
        
        // Reference type
        String name = "สมชาย ใจดี";
        
        System.out.println("Age (byte): " + age);
        System.out.println("Year (short): " + year);
        System.out.println("Population (int): " + population);
        System.out.println("Distance (long): " + distance);
        System.out.println("Price (float): " + price);
        System.out.println("Pi (double): " + pi);
        System.out.println("Grade (char): " + grade);
        System.out.println("Is Student (boolean): " + isStudent);
        System.out.println("Name (String): " + name);
        
        // Constants
        final double TAX_RATE = 0.07;
        final int MAX_STUDENTS = 50;
        System.out.println("\nConstants:");
        System.out.println("TAX_RATE: " + TAX_RATE);
        System.out.println("MAX_STUDENTS: " + MAX_STUDENTS);
        
        // ============================================
        // ส่วนที่ 2: Arithmetic Operators
        // ============================================
        System.out.println("\n>>> ส่วนที่ 2: Arithmetic Operators");
        
        int a = 10, b = 3;
        
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));    // 13
        System.out.println("a - b = " + (a - b));    // 7
        System.out.println("a * b = " + (a * b));    // 30
        System.out.println("a / b = " + (a / b));    // 3 (integer division)
        System.out.println("a % b = " + (a % b));    // 1 (modulo)
        
        // Increment and Decrement
        int x = 5;
        System.out.println("\nIncrement/Decrement:");
        System.out.println("x = " + x);
        System.out.println("x++ = " + x++);  // 5 (post-increment)
        System.out.println("x = " + x);      // 6
        System.out.println("++x = " + ++x);  // 7 (pre-increment)
        
        // ============================================
        // ส่วนที่ 3: Relational Operators
        // ============================================
        System.out.println("\n>>> ส่วนที่ 3: Relational Operators");
        
        int num1 = 5, num2 = 10;
        
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
        System.out.println("num1 == num2: " + (num1 == num2));  // false
        System.out.println("num1 != num2: " + (num1 != num2));  // true
        System.out.println("num1 > num2: " + (num1 > num2));    // false
        System.out.println("num1 < num2: " + (num1 < num2));    // true
        System.out.println("num1 >= num2: " + (num1 >= num2));  // false
        System.out.println("num1 <= num2: " + (num1 <= num2));  // true
        
        // ============================================
        // ส่วนที่ 4: Logical Operators
        // ============================================
        System.out.println("\n>>> ส่วนที่ 4: Logical Operators");
        
        boolean condition1 = true;
        boolean condition2 = false;
        
        System.out.println("condition1 = " + condition1 + ", condition2 = " + condition2);
        System.out.println("condition1 && condition2: " + (condition1 && condition2));  // false
        System.out.println("condition1 || condition2: " + (condition1 || condition2));  // true
        System.out.println("!condition1: " + (!condition1));  // false
        
        // Practical example
        int studentAge = 20;
        boolean hasID = true;
        
        if (studentAge >= 18 && hasID) {
            System.out.println("\nStudent can register (age >= 18 AND has ID)");
        }
        
        // ============================================
        // ส่วนที่ 5: Type Conversion
        // ============================================
        System.out.println("\n>>> ส่วนที่ 5: Type Conversion");
        
        // Implicit conversion (widening)
        int intValue = 100;
        double doubleValue = intValue;
        System.out.println("int to double: " + intValue + " → " + doubleValue);
        
        // Explicit conversion (narrowing/casting)
        double d = 9.7;
        int i = (int) d;
        System.out.println("double to int (casting): " + d + " → " + i);
        
        // String conversion
        int number = 123;
        String numberStr = String.valueOf(number);
        System.out.println("int to String: " + number + " → \"" + numberStr + "\"");
        
        String str = "456";
        int parsedNumber = Integer.parseInt(str);
        System.out.println("String to int: \"" + str + "\" → " + parsedNumber);
        
        // ============================================
        // ส่วนที่ 6: การคำนวณจริง
        // ============================================
        System.out.println("\n>>> ส่วนที่ 6: การคำนวณจริง");
        
        // คำนวณพื้นที่วงกลม
        double radius = 5.0;
        double area = Math.PI * radius * radius;
        System.out.printf("พื้นที่วงกลมรัศมี %.1f = %.2f ตารางหน่วย\n", radius, area);
        
        // คำนวณราคารวม VAT
        double basePrice = 1000.0;
        double vat = basePrice * 0.07;
        double totalPrice = basePrice + vat;
        System.out.printf("ราคา: %.2f บาท\n", basePrice);
        System.out.printf("VAT 7%%: %.2f บาท\n", vat);
        System.out.printf("รวมทั้งหมด: %.2f บาท\n", totalPrice);
        
        // แปลงอุณหภูมิ Celsius → Fahrenheit
        double celsius = 25.0;
        double fahrenheit = celsius * 9.0 / 5.0 + 32.0;
        System.out.printf("%.1f°C = %.1f°F\n", celsius, fahrenheit);
        
        // ============================================
        // ส่วนที่ 7: Input/Output
        // ============================================
        System.out.println("\n>>> ส่วนที่ 7: Input/Output");
        System.out.println("(การรับ Input จากผู้ใช้ถูกแสดงด้านล่าง)");
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("\nกรุณาใส่ชื่อของคุณ: ");
        String userName = scanner.nextLine();
        
        System.out.print("กรุณาใส่อายุของคุณ: ");
        int userAge = scanner.nextInt();
        
        System.out.print("กรุณาใส่ GPA ของคุณ: ");
        double userGPA = scanner.nextDouble();
        
        // แสดงผลข้อมูลที่รับมา
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│        ข้อมูลของคุณ                │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ ชื่อ: " + userName);
        System.out.println("│ อายุ: " + userAge + " ปี");
        System.out.printf("│ GPA: %.2f\n", userGPA);
        System.out.println("└─────────────────────────────────────┘");
        
        // ตรวจสอบเงื่อนไข
        if (userAge >= 18) {
            System.out.println("\n✓ คุณเป็นผู้ใหญ่แล้ว");
        } else {
            System.out.println("\n✗ คุณยังไม่ถึงอายุ 18 ปี");
        }
        
        if (userGPA >= 3.0) {
            System.out.println("✓ GPA ของคุณดีมาก!");
        } else if (userGPA >= 2.0) {
            System.out.println("✓ GPA ของคุณผ่านเกณฑ์");
        } else {
            System.out.println("✗ GPA ของคุณต่ำกว่าเกณฑ์");
        }
        
        scanner.close();
        
        // สรุป
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        สรุป");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n✓ เรียนรู้ Variables และ Data Types ทุกประเภท");
        System.out.println("✓ เรียนรู้ Operators (Arithmetic, Relational, Logical)");
        System.out.println("✓ เรียนรู้ Type Conversion");
        System.out.println("✓ เรียนรู้การรับ Input และแสดง Output");
        System.out.println("✓ นี่คือพื้นฐานสำหรับ CLO1: Write correct programs\n");
    }
}
