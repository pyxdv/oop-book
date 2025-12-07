/**
 * ControlFlowExample.java
 * ตัวอย่าง Control Flow และ Loops (CLO1)
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - Conditional statements (if, switch)
 * - Loops (for, while, do-while)
 * - break และ continue
 * - Nested loops
 */

public class ControlFlowExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Control Flow และ Loops");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // ============================================
        // ส่วนที่ 1: if-else Statements
        // ============================================
        System.out.println(">>> ส่วนที่ 1: if-else Statements");
        
        int score = 85;
        System.out.println("คะแนน: " + score);
        
        if (score >= 80) {
            System.out.println("เกรด: A (ดีเยี่ยม)");
        } else if (score >= 70) {
            System.out.println("เกรด: B (ดี)");
        } else if (score >= 60) {
            System.out.println("เกรด: C (พอใช้)");
        } else if (score >= 50) {
            System.out.println("เกรด: D (ผ่าน)");
        } else {
            System.out.println("เกรด: F (ไม่ผ่าน)");
        }
        
        // Ternary operator
        String status = (score >= 50) ? "ผ่าน" : "ไม่ผ่าน";
        System.out.println("สถานะ: " + status);
        
        // ============================================
        // ส่วนที่ 2: switch Statement
        // ============================================
        System.out.println("\n>>> ส่วนที่ 2: switch Statement");
        
        int dayOfWeek = 3;
        String dayName;
        
        switch (dayOfWeek) {
            case 1:
                dayName = "จันทร์";
                break;
            case 2:
                dayName = "อังคาร";
                break;
            case 3:
                dayName = "พุธ";
                break;
            case 4:
                dayName = "พฤหัสบดี";
                break;
            case 5:
                dayName = "ศุกร์";
                break;
            case 6:
                dayName = "เสาร์";
                break;
            case 7:
                dayName = "อาทิตย์";
                break;
            default:
                dayName = "ไม่ถูกต้อง";
        }
        
        System.out.println("วันที่ " + dayOfWeek + " คือ " + dayName);
        
        // switch กับ String
        String grade = "B";
        System.out.println("\nเกรด " + grade + " หมายความว่า: ");
        
        switch (grade) {
            case "A":
                System.out.println("ดีเยี่ยม (80-100)");
                break;
            case "B":
                System.out.println("ดี (70-79)");
                break;
            case "C":
                System.out.println("พอใช้ (60-69)");
                break;
            case "D":
                System.out.println("ผ่าน (50-59)");
                break;
            case "F":
                System.out.println("ไม่ผ่าน (0-49)");
                break;
            default:
                System.out.println("ไม่ทราบ");
        }
        
        // ============================================
        // ส่วนที่ 3: for Loop
        // ============================================
        System.out.println("\n>>> ส่วนที่ 3: for Loop");
        
        System.out.println("นับ 1 ถึง 5:");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("\nนับถอยหลัง 10 ถึง 1:");
        for (int i = 10; i >= 1; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        System.out.println("\nเลขคู่ 0 ถึง 10:");
        for (int i = 0; i <= 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // คำนวณผลรวม
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }
        System.out.println("\nผลรวม 1 ถึง 10 = " + sum);
        
        // ============================================
        // ส่วนที่ 4: while Loop
        // ============================================
        System.out.println("\n>>> ส่วนที่ 4: while Loop");
        
        int count = 1;
        System.out.println("นับด้วย while loop:");
        while (count <= 5) {
            System.out.print(count + " ");
            count++;
        }
        System.out.println();
        
        // หา factorial
        int n = 5;
        int factorial = 1;
        int temp = n;
        
        while (temp > 0) {
            factorial *= temp;
            temp--;
        }
        
        System.out.println("\n" + n + "! = " + factorial);
        
        // ============================================
        // ส่วนที่ 5: do-while Loop
        // ============================================
        System.out.println("\n>>> ส่วนที่ 5: do-while Loop");
        
        int number = 1;
        System.out.println("นับด้วย do-while loop:");
        do {
            System.out.print(number + " ");
            number++;
        } while (number <= 5);
        System.out.println();
        
        // ความแตกต่างจาก while
        System.out.println("\nความแตกต่าง: do-while ทำงานอย่างน้อย 1 ครั้ง");
        int x = 10;
        do {
            System.out.println("ทำงานแม้ว่า x = " + x + " (x < 5 = false)");
        } while (x < 5);
        
        // ============================================
        // ส่วนที่ 6: break Statement
        // ============================================
        System.out.println("\n>>> ส่วนที่ 6: break Statement");
        
        System.out.println("หาเลขแรกที่หารด้วย 7 ลงตัว:");
        for (int i = 1; i <= 100; i++) {
            if (i % 7 == 0) {
                System.out.println("พบ: " + i);
                break;  // หยุด loop
            }
        }
        
        // ============================================
        // ส่วนที่ 7: continue Statement
        // ============================================
        System.out.println("\n>>> ส่วนที่ 7: continue Statement");
        
        System.out.println("พิมพ์เลขคี่ 1-10 (ข้ามเลขคู่):");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;  // ข้ามเลขคู่
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // ============================================
        // ส่วนที่ 8: Nested Loops
        // ============================================
        System.out.println("\n>>> ส่วนที่ 8: Nested Loops");
        
        System.out.println("สี่เหลี่ยม 3x5:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nสามเหลี่ยม:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        
        System.out.println("\nสูตรคูณ 5x5:");
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 5; j++) {
                System.out.printf("%3d ", i * j);
            }
            System.out.println();
        }
        
        // ============================================
        // ส่วนที่ 9: ตัวอย่างการใช้งานจริง
        // ============================================
        System.out.println("\n>>> ส่วนที่ 9: ตัวอย่างการใช้งานจริง");
        
        // หาจำนวนเฉพาะ
        System.out.println("จำนวนเฉพาะ 2-30:");
        for (int num = 2; num <= 30; num++) {
            boolean isPrime = true;
            
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            
            if (isPrime) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
        
        // Fibonacci sequence
        System.out.println("\nFibonacci 10 ตัวแรก:");
        int fib1 = 0, fib2 = 1;
        System.out.print(fib1 + " " + fib2 + " ");
        
        for (int i = 3; i <= 10; i++) {
            int next = fib1 + fib2;
            System.out.print(next + " ");
            fib1 = fib2;
            fib2 = next;
        }
        System.out.println();
        
        // สรุป
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        สรุป");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n✓ เรียนรู้ Conditional statements (if, switch)");
        System.out.println("✓ เรียนรู้ Loops (for, while, do-while)");
        System.out.println("✓ เรียนรู้ break และ continue");
        System.out.println("✓ เรียนรู้ Nested loops");
        System.out.println("✓ รองรับ CLO1: Write correct programs with control flow\n");
    }
}
