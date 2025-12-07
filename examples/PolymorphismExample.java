/**
 * PolymorphismExample.java
 * ตัวอย่างการใช้งาน Polymorphism (พหุสัณฐาน)
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - Method Overloading (Compile-time Polymorphism)
 * - Method Overriding (Runtime Polymorphism)
 * - Dynamic Binding
 * - การใช้ Polymorphism ในการออกแบบระบบ
 */

// ============================================
// ส่วนที่ 1: Method Overloading
// ============================================

class Calculator {
    // Method Overloading: ชื่อเดียวกัน พารามิเตอร์ต่างกัน
    
    // 1. บวกเลขจำนวนเต็ม 2 ตัว
    public int add(int a, int b) {
        System.out.println("เรียกใช้ add(int, int)");
        return a + b;
    }
    
    // 2. บวกเลขจำนวนเต็ม 3 ตัว
    public int add(int a, int b, int c) {
        System.out.println("เรียกใช้ add(int, int, int)");
        return a + b + c;
    }
    
    // 3. บวกเลขทศนิยม
    public double add(double a, double b) {
        System.out.println("เรียกใช้ add(double, double)");
        return a + b;
    }
    
    // 4. บวก String (ต่อข้อความ)
    public String add(String a, String b) {
        System.out.println("เรียกใช้ add(String, String)");
        return a + " " + b;
    }
    
    // 5. บวกเลขแบบผสม
    public double add(int a, double b) {
        System.out.println("เรียกใช้ add(int, double)");
        return a + b;
    }
}

// ============================================
// ส่วนที่ 2: Method Overriding
// ============================================

// Superclass: Payment (การชำระเงิน)
abstract class Payment {
    protected String paymentId;
    protected double amount;
    
    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }
    
    // Abstract method: ต้อง Override ใน Subclass
    abstract void processPayment();
    
    // Method ที่ใช้ร่วมกัน
    public void displayInfo() {
        System.out.println("ID: " + paymentId + ", จำนวน: " + amount + " บาท");
    }
}

// Subclass 1: CreditCardPayment
class CreditCardPayment extends Payment {
    private String cardNumber;
    
    public CreditCardPayment(String paymentId, double amount, String cardNumber) {
        super(paymentId, amount);
        this.cardNumber = cardNumber;
    }
    
    @Override
    void processPayment() {
        System.out.println("💳 ชำระเงินด้วยบัตรเครดิต");
        System.out.println("   หมายเลขบัตร: **** **** **** " + 
                         cardNumber.substring(cardNumber.length() - 4));
        System.out.println("   จำนวน: " + amount + " บาท");
        System.out.println("   ✓ ชำระเงินสำเร็จ");
    }
}

// Subclass 2: MobilePayment
class MobilePayment extends Payment {
    private String phoneNumber;
    
    public MobilePayment(String paymentId, double amount, String phoneNumber) {
        super(paymentId, amount);
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    void processPayment() {
        System.out.println("📱 ชำระเงินผ่าน Mobile Banking");
        System.out.println("   เบอร์โทร: " + phoneNumber);
        System.out.println("   จำนวน: " + amount + " บาท");
        System.out.println("   ✓ ชำระเงินสำเร็จ");
    }
}

// Subclass 3: QRCodePayment
class QRCodePayment extends Payment {
    private String qrCode;
    
    public QRCodePayment(String paymentId, double amount, String qrCode) {
        super(paymentId, amount);
        this.qrCode = qrCode;
    }
    
    @Override
    void processPayment() {
        System.out.println("🔲 ชำระเงินด้วย QR Code");
        System.out.println("   QR Code: " + qrCode);
        System.out.println("   จำนวน: " + amount + " บาท");
        System.out.println("   ✓ ชำระเงินสำเร็จ");
    }
}

// Subclass 4: CashPayment
class CashPayment extends Payment {
    
    public CashPayment(String paymentId, double amount) {
        super(paymentId, amount);
    }
    
    @Override
    void processPayment() {
        System.out.println("💵 ชำระเงินด้วยเงินสด");
        System.out.println("   จำนวน: " + amount + " บาท");
        System.out.println("   ✓ รับเงินสำเร็จ");
    }
}

// ============================================
// ส่วนที่ 3: ระบบการชำระเงิน
// ============================================

class PaymentProcessor {
    // Polymorphism: Method รับ Payment ทุกชนิด
    public void process(Payment payment) {
        System.out.println("\n--- เริ่มประมวลผลการชำระเงิน ---");
        payment.displayInfo();
        payment.processPayment();  // Dynamic Binding: เรียก Method ที่ถูกต้อง
        System.out.println("--- สิ้นสุดการประมวลผล ---");
    }
    
    // Polymorphism: Method รับ Array ของ Payment
    public void processMultiple(Payment[] payments) {
        System.out.println("\n╔═══════════════════════════════════════════╗");
        System.out.println("║  ประมวลผลการชำระเงินหลายรายการ          ║");
        System.out.println("╚═══════════════════════════════════════════╝");
        
        double total = 0;
        for (Payment payment : payments) {
            payment.processPayment();
            total += payment.amount;
            System.out.println();
        }
        
        System.out.println("══════════════════════════════════════════");
        System.out.println("รวมทั้งหมด: " + total + " บาท");
        System.out.println("══════════════════════════════════════════");
    }
}

// ============================================
// Main Class
// ============================================

public class PolymorphismExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Polymorphism ในภาษา Java");
        System.out.println("═══════════════════════════════════════════════════");
        
        // ============================================
        // ทดสอบ Method Overloading
        // ============================================
        System.out.println("\n┌─────────────────────────────────────────────────┐");
        System.out.println("│  ส่วนที่ 1: Method Overloading                  │");
        System.out.println("└─────────────────────────────────────────────────┘\n");
        
        Calculator calc = new Calculator();
        
        System.out.println("ผลลัพธ์: " + calc.add(5, 3));
        System.out.println();
        
        System.out.println("ผลลัพธ์: " + calc.add(5, 3, 2));
        System.out.println();
        
        System.out.println("ผลลัพธ์: " + calc.add(5.5, 3.2));
        System.out.println();
        
        System.out.println("ผลลัพธ์: " + calc.add("สวัสดี", "โลก"));
        System.out.println();
        
        System.out.println("ผลลัพธ์: " + calc.add(5, 3.7));
        
        // ============================================
        // ทดสอบ Method Overriding
        // ============================================
        System.out.println("\n┌─────────────────────────────────────────────────┐");
        System.out.println("│  ส่วนที่ 2: Method Overriding                   │");
        System.out.println("└─────────────────────────────────────────────────┘");
        
        PaymentProcessor processor = new PaymentProcessor();
        
        // สร้าง Payment Objects หลายชนิด
        Payment payment1 = new CreditCardPayment("P001", 1500, "1234567812345678");
        Payment payment2 = new MobilePayment("P002", 2500, "089-123-4567");
        Payment payment3 = new QRCodePayment("P003", 3000, "QR2024123456");
        Payment payment4 = new CashPayment("P004", 500);
        
        // ประมวลผลทีละรายการ
        processor.process(payment1);
        processor.process(payment2);
        processor.process(payment3);
        processor.process(payment4);
        
        // ============================================
        // ทดสอบ Polymorphic Array
        // ============================================
        System.out.println("\n┌─────────────────────────────────────────────────┐");
        System.out.println("│  ส่วนที่ 3: Polymorphic Array                   │");
        System.out.println("└─────────────────────────────────────────────────┘");
        
        // เก็บ Payment หลายชนิดใน Array เดียว
        Payment[] payments = {
            new CreditCardPayment("P101", 850, "9876543298765432"),
            new MobilePayment("P102", 1200, "092-888-9999"),
            new QRCodePayment("P103", 650, "QR2024789012"),
            new CashPayment("P104", 300),
            new CreditCardPayment("P105", 2100, "1111222233334444")
        };
        
        processor.processMultiple(payments);
        
        // ============================================
        // แสดงประโยชน์ของ Polymorphism
        // ============================================
        System.out.println("\n┌─────────────────────────────────────────────────┐");
        System.out.println("│  ส่วนที่ 4: ประโยชน์ของ Polymorphism            │");
        System.out.println("└─────────────────────────────────────────────────┘\n");
        
        System.out.println("✓ Flexibility (ความยืดหยุ่น)");
        System.out.println("  - รองรับการชำระเงินหลายรูปแบบด้วย Interface เดียวกัน");
        System.out.println("  - เพิ่มวิธีชำระเงินใหม่ได้โดยไม่แก้โค้ดเดิม\n");
        
        System.out.println("✓ Maintainability (ดูแลรักษาได้ง่าย)");
        System.out.println("  - PaymentProcessor ไม่ต้องรู้รายละเอียดของแต่ละประเภท");
        System.out.println("  - แก้ไขการชำระเงินแต่ละประเภทได้อิสระ\n");
        
        System.out.println("✓ Extensibility (ขยายได้)");
        System.out.println("  - เพิ่ม Class ใหม่ (เช่น CryptoPayment) ได้ง่าย");
        System.out.println("  - ไม่ต้องแก้ PaymentProcessor\n");
        
        System.out.println("✓ Code Reusability (นำกลับมาใช้ได้)");
        System.out.println("  - Method process() และ processMultiple() ใช้ได้กับทุกประเภท");
        System.out.println("  - ไม่ต้องเขียน Method แยกสำหรับแต่ละประเภท\n");
        
        // ============================================
        // ทดสอบ Dynamic Binding
        // ============================================
        System.out.println("\n┌─────────────────────────────────────────────────┐");
        System.out.println("│  ส่วนที่ 5: Dynamic Binding                     │");
        System.out.println("└─────────────────────────────────────────────────┘\n");
        
        System.out.println("ตัวอย่าง: ประกาศเป็น Payment แต่สร้างเป็น Subclass");
        
        Payment dynamicPayment;
        
        // กำหนดค่าตอน Runtime
        int paymentType = (int) (Math.random() * 4) + 1;
        
        switch (paymentType) {
            case 1:
                dynamicPayment = new CreditCardPayment("P201", 500, "1234123412341234");
                break;
            case 2:
                dynamicPayment = new MobilePayment("P202", 500, "081-111-2222");
                break;
            case 3:
                dynamicPayment = new QRCodePayment("P203", 500, "QR2024999999");
                break;
            default:
                dynamicPayment = new CashPayment("P204", 500);
        }
        
        System.out.println("ประเภทที่สุ่มได้: " + dynamicPayment.getClass().getSimpleName());
        dynamicPayment.processPayment();
        
        System.out.println("\n→ Java เลือก Method ที่ถูกต้องตอน Runtime");
        System.out.println("  นี่คือ Dynamic Binding (Runtime Polymorphism)\n");
    }
}
