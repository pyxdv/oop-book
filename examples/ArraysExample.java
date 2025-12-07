/**
 * ArraysExample.java
 * ตัวอย่างการใช้งาน Arrays (CLO1)
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - การสร้างและใช้งาน Arrays
 * - Array operations (sum, average, max, min, search)
 * - 2D Arrays
 * - Array manipulation
 */

import java.util.Arrays;

public class ArraysExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่างการใช้งาน Arrays");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // ============================================
        // ส่วนที่ 1: การสร้าง Arrays
        // ============================================
        System.out.println(">>> ส่วนที่ 1: การสร้าง Arrays");
        
        // วิธีที่ 1: ประกาศและกำหนดค่า
        int[] numbers1 = {10, 20, 30, 40, 50};
        System.out.println("Array 1: " + Arrays.toString(numbers1));
        
        // วิธีที่ 2: ประกาศขนาดแล้วกำหนดค่าทีละตัว
        int[] numbers2 = new int[5];
        numbers2[0] = 1;
        numbers2[1] = 2;
        numbers2[2] = 3;
        numbers2[3] = 4;
        numbers2[4] = 5;
        System.out.println("Array 2: " + Arrays.toString(numbers2));
        
        // String array
        String[] fruits = {"Apple", "Banana", "Orange", "Mango"};
        System.out.println("Fruits: " + Arrays.toString(fruits));
        
        // ============================================
        // ส่วนที่ 2: การเข้าถึง Array
        // ============================================
        System.out.println("\n>>> ส่วนที่ 2: การเข้าถึง Array");
        
        int[] scores = {85, 90, 78, 92, 88};
        
        System.out.println("Length: " + scores.length);
        System.out.println("scores[0]: " + scores[0]);
        System.out.println("scores[2]: " + scores[2]);
        System.out.println("scores[4]: " + scores[4]);
        
        // Loop through array
        System.out.println("\nAll scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("scores[" + i + "] = " + scores[i]);
        }
        
        // ============================================
        // ส่วนที่ 3: Enhanced for Loop
        // ============================================
        System.out.println("\n>>> ส่วนที่ 3: Enhanced for Loop");
        
        String[] names = {"สมชาย", "สมหญิง", "สมศรี", "สมหมาย"};
        
        System.out.println("Student names:");
        for (String name : names) {
            System.out.println("- " + name);
        }
        
        // ============================================
        // ส่วนที่ 4: Array Operations
        // ============================================
        System.out.println("\n>>> ส่วนที่ 4: Array Operations");
        
        int[] data = {45, 23, 78, 12, 90, 56, 34};
        
        // Sum
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        
        // Average
        double average = (double) sum / data.length;
        System.out.printf("Average: %.2f\n", average);
        
        // Max
        int max = data[0];
        for (int num : data) {
            if (num > max) {
                max = num;
            }
        }
        System.out.println("Maximum: " + max);
        
        // Min
        int min = data[0];
        for (int num : data) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println("Minimum: " + min);
        
        // ============================================
        // ส่วนที่ 5: การค้นหา
        // ============================================
        System.out.println("\n>>> ส่วนที่ 5: การค้นหา");
        
        int[] numbers = {10, 20, 30, 40, 50};
        int target = 30;
        boolean found = false;
        int position = -1;
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == target) {
                found = true;
                position = i;
                break;
            }
        }
        
        if (found) {
            System.out.println("Found " + target + " at index " + position);
        } else {
            System.out.println(target + " not found");
        }
        
        // ============================================
        // ส่วนที่ 6: การเรียงลำดับ
        // ============================================
        System.out.println("\n>>> ส่วนที่ 6: การเรียงลำดับ");
        
        int[] unsorted = {45, 23, 78, 12, 90};
        System.out.println("Before sort: " + Arrays.toString(unsorted));
        
        Arrays.sort(unsorted);
        System.out.println("After sort: " + Arrays.toString(unsorted));
        
        // ============================================
        // ส่วนที่ 7: 2D Arrays
        // ============================================
        System.out.println("\n>>> ส่วนที่ 7: 2D Arrays");
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3d ", matrix[i][j]);
            }
            System.out.println();
        }
        
        // การเข้าถึงแบบ for-each
        System.out.println("\nUsing for-each:");
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%3d ", value);
            }
            System.out.println();
        }
        
        // ============================================
        // ส่วนที่ 8: ตารางคะแนน
        // ============================================
        System.out.println("\n>>> ส่วนที่ 8: ตารางคะแนน");
        
        // นักเรียน 3 คน, วิชา 4 วิชา
        int[][] studentScores = {
            {85, 90, 78, 92},  // นักเรียนคนที่ 1
            {88, 85, 90, 87},  // นักเรียนคนที่ 2
            {75, 80, 85, 90}   // นักเรียนคนที่ 3
        };
        
        String[] students = {"สมชาย", "สมหญิง", "สมศรี"};
        String[] subjects = {"Math", "Science", "English", "Social"};
        
        System.out.println("ตารางคะแนน:");
        System.out.printf("%-12s", "Student");
        for (String subject : subjects) {
            System.out.printf("%8s", subject);
        }
        System.out.printf("%10s\n", "Average");
        System.out.println("─".repeat(60));
        
        for (int i = 0; i < studentScores.length; i++) {
            System.out.printf("%-12s", students[i]);
            
            int studentSum = 0;
            for (int j = 0; j < studentScores[i].length; j++) {
                System.out.printf("%8d", studentScores[i][j]);
                studentSum += studentScores[i][j];
            }
            
            double studentAvg = (double) studentSum / studentScores[i].length;
            System.out.printf("%10.2f\n", studentAvg);
        }
        
        // คำนวณค่าเฉลี่ยแต่ละวิชา
        System.out.println("\nค่าเฉลี่ยแต่ละวิชา:");
        for (int j = 0; j < subjects.length; j++) {
            int subjectSum = 0;
            for (int i = 0; i < studentScores.length; i++) {
                subjectSum += studentScores[i][j];
            }
            double subjectAvg = (double) subjectSum / studentScores.length;
            System.out.printf("%s: %.2f\n", subjects[j], subjectAvg);
        }
        
        // สรุป
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        สรุป");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n✓ เรียนรู้การสร้างและใช้งาน Arrays");
        System.out.println("✓ เรียนรู้ Array operations (sum, avg, max, min, search)");
        System.out.println("✓ เรียนรู้ 2D Arrays");
        System.out.println("✓ เรียนรู้การจัดการข้อมูลด้วย Arrays");
        System.out.println("✓ รองรับ CLO1: Write correct programs with arrays\n");
    }
}
