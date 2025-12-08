/**
 * EncapsulationExample.java
 * ตัวอย่างการใช้งาน Encapsulation (การห่อหุ้ม)
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - การสร้าง Class ที่มี Encapsulation ที่ดี
 * - การใช้ private Attributes
 * - การสร้าง Getters และ Setters พร้อม Validation
 * - การป้องกันข้อมูลที่ไม่ถูกต้อง
 * - ประโยชน์ของ Encapsulation
 */

// Class: BankAccount (บัญชีธนาคาร) - แสดงตัวอย่าง Encapsulation ที่ดี
class BankAccount {
    // Private Attributes - ไม่สามารถเข้าถึงจากภายนอก Class ได้
    private String accountNumber;
    private String accountName;
    private double balance;
    private String pin;  // รหัส PIN (ควรเป็นความลับ)
    
    // Constructor - สร้างบัญชีใหม่
    public BankAccount(String accountNumber, String accountName, String pin) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.pin = pin;
        this.balance = 0.0;  // เริ่มต้นยอดเงินที่ 0
    }
    
    // Getter สำหรับ accountNumber (Read-Only: ไม่มี Setter)
    public String getAccountNumber() {
        return accountNumber;
    }
    
    // Getter สำหรับ accountName
    public String getAccountName() {
        return accountName;
    }
    
    // Setter สำหรับ accountName พร้อม Validation
    public void setAccountName(String accountName) {
        if (accountName != null && !accountName.trim().isEmpty()) {
            this.accountName = accountName;
            System.out.println("✓ เปลี่ยนชื่อบัญชีเป็น: " + accountName);
        } else {
            System.out.println("✗ ข้อผิดพลาด: ชื่อบัญชีต้องไม่เป็นค่าว่าง");
        }
    }
    
    // Getter สำหรับ balance
    public double getBalance() {
        return balance;
    }
    
    // ไม่มี Setter สำหรับ balance โดยตรง
    // ต้องใช้ Methods deposit() และ withdraw() เท่านั้น
    
    // Method: ฝากเงิน (Deposit)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("✓ ฝากเงิน " + amount + " บาท สำเร็จ");
            System.out.println("  ยอดเงินคงเหลือ: " + balance + " บาท");
        } else {
            System.out.println("✗ ข้อผิดพลาด: จำนวนเงินต้องมากกว่า 0");
        }
    }
    
    // Method: ถอนเงิน (Withdraw) พร้อม PIN Verification
    public void withdraw(double amount, String pin) {
        // ตรวจสอบ PIN
        if (!this.pin.equals(pin)) {
            System.out.println("✗ ข้อผิดพลาด: PIN ไม่ถูกต้อง");
            return;
        }
        
        // ตรวจสอบจำนวนเงิน
        if (amount <= 0) {
            System.out.println("✗ ข้อผิดพลาด: จำนวนเงินต้องมากกว่า 0");
            return;
        }
        
        // ตรวจสอบยอดเงินคงเหลือ
        if (amount > balance) {
            System.out.println("✗ ข้อผิดพลาด: ยอดเงินไม่เพียงพอ (คงเหลือ " + balance + " บาท)");
            return;
        }
        
        // ถอนเงินสำเร็จ
        balance -= amount;
        System.out.println("✓ ถอนเงิน " + amount + " บาท สำเร็จ");
        System.out.println("  ยอดเงินคงเหลือ: " + balance + " บาท");
    }
    
    // Method: โอนเงิน (Transfer)
    public void transfer(BankAccount targetAccount, double amount, String pin) {
        // ตรวจสอบ PIN
        if (!this.pin.equals(pin)) {
            System.out.println("✗ ข้อผิดพลาด: PIN ไม่ถูกต้อง");
            return;
        }
        
        // ตรวจสอบยอดเงิน
        if (amount <= 0) {
            System.out.println("✗ ข้อผิดพลาด: จำนวนเงินต้องมากกว่า 0");
            return;
        }
        
        if (amount > balance) {
            System.out.println("✗ ข้อผิดพลาด: ยอดเงินไม่เพียงพอ");
            return;
        }
        
        // โอนเงิน
        balance -= amount;
        targetAccount.balance += amount;  // เข้าถึง private member ของ Object ชนิดเดียวกันได้
        System.out.println("✓ โอนเงิน " + amount + " บาท ไปยังบัญชี " + 
                         targetAccount.accountNumber + " สำเร็จ");
        System.out.println("  ยอดเงินคงเหลือ: " + balance + " บาท");
    }
    
    // Method: เปลี่ยน PIN
    public void changePin(String oldPin, String newPin) {
        if (!this.pin.equals(oldPin)) {
            System.out.println("✗ ข้อผิดพลาด: PIN เดิมไม่ถูกต้อง");
            return;
        }
        
        if (newPin.length() < 4) {
            System.out.println("✗ ข้อผิดพลาด: PIN ใหม่ต้องมีอย่างน้อย 4 หลัก");
            return;
        }
        
        this.pin = newPin;
        System.out.println("✓ เปลี่ยน PIN สำเร็จ");
    }
    
    // Method: แสดงข้อมูลบัญชี (ไม่แสดง PIN)
    public void displayAccountInfo() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│        ข้อมูลบัญชีธนาคาร           │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ เลขที่บัญชี: " + accountNumber);
        System.out.println("│ ชื่อบัญชี: " + accountName);
        System.out.println("│ ยอดเงินคงเหลือ: " + balance + " บาท");
        System.out.println("│ PIN: ****  (ซ่อนไว้เพื่อความปลอดภัย)");
        System.out.println("└─────────────────────────────────────┘");
    }
}

// Main Class สำหรับรันโปรแกรม
public class EncapsulationExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Encapsulation ในภาษา Java");
        System.out.println("═══════════════════════════════════════════════════");
        
        // สร้างบัญชีธนาคาร 2 บัญชี
        System.out.println("\n>>> สร้างบัญชีธนาคาร");
        BankAccount account1 = new BankAccount("001-1-12345-6", "สมชาย ใจดี", "1234");
        BankAccount account2 = new BankAccount("001-1-67890-1", "สมหญิง รักเรียน", "5678");
        
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        // ทดสอบการฝากเงิน
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การฝากเงิน");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        account1.deposit(5000);
        account1.deposit(3000);
        account1.deposit(-100);  // จำนวนเงินไม่ถูกต้อง
        
        account2.deposit(10000);
        
        // ทดสอบการถอนเงิน
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การถอนเงิน");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        account1.withdraw(2000, "1234");     // ถอนสำเร็จ
        account1.withdraw(1000, "0000");     // PIN ผิด
        account1.withdraw(10000, "1234");    // ยอดเงินไม่พอ
        account1.withdraw(-500, "1234");     // จำนวนเงินไม่ถูกต้อง
        
        // ทดสอบการโอนเงิน
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การโอนเงิน");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        account1.transfer(account2, 3000, "1234");  // โอนสำเร็จ
        account1.transfer(account2, 5000, "1234");  // ยอดเงินไม่พอ
        
        // แสดงข้อมูลบัญชีหลังทำธุรกรรม
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        ข้อมูลบัญชีหลังทำธุรกรรม");
        System.out.println("═══════════════════════════════════════════════════");
        
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        // ทดสอบการเปลี่ยน PIN
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การเปลี่ยน PIN");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        account1.changePin("1234", "9999");   // สำเร็จ
        account1.changePin("1234", "8888");   // PIN เดิมไม่ถูกต้อง
        account1.changePin("9999", "12");     // PIN ใหม่สั้นเกินไป
        
        // ทดสอบการเปลี่ยนชื่อบัญชี
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การเปลี่ยนชื่อบัญชี");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        account1.setAccountName("สมชาย ใจดีมาก");  // สำเร็จ
        account1.setAccountName("");              // ล้มเหลว
        
        // แสดงข้อมูลบัญชีสุดท้าย
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        ข้อมูลบัญชีสุดท้าย");
        System.out.println("═══════════════════════════════════════════════════");
        
        account1.displayAccountInfo();
        account2.displayAccountInfo();
        
        // สรุป
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        สรุปประโยชน์ของ Encapsulation");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n✓ ป้องกันการเข้าถึงข้อมูลสำคัญ (balance, PIN) โดยตรง");
        System.out.println("✓ ตรวจสอบความถูกต้องของข้อมูลก่อนกำหนดค่า");
        System.out.println("✓ ควบคุมการเปลี่ยนแปลงข้อมูลผ่าน Methods เท่านั้น");
        System.out.println("✓ ซ่อนรายละเอียดการทำงานภายใน");
        System.out.println("✓ ทำให้โค้ดปลอดภัย ดูแลรักษาได้ง่าย และใช้งานได้ถูกต้อง\n");
    }
}
