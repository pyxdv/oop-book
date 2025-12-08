/**
 * AbstractionExample.java
 * ตัวอย่างการใช้งาน Abstraction (CLO2)
 * 
 * แสดงการออกแบบ Class ที่มี:
 * - Single Responsibility Principle
 * - การกำหนดความรับผิดชอบของ Class
 * - Abstraction ที่ดี (ซ่อนรายละเอียด แสดงเฉพาะสิ่งสำคัญ)
 */

// Class: BankAccount - รับผิดชอบจัดการบัญชีธนาคาร
class BankAccount {
    private String accountNumber;
    private String accountName;
    private double balance;
    
    public BankAccount(String accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 0.0;
    }
    
    // Public Interface - สิ่งที่แสดงให้ผู้ใช้เห็น
    public void deposit(double amount) {
        if (validateAmount(amount)) {
            performDeposit(amount);
            logTransaction("Deposit", amount);
        }
    }
    
    public void withdraw(double amount) {
        if (validateAmount(amount) && checkBalance(amount)) {
            performWithdrawal(amount);
            logTransaction("Withdrawal", amount);
        }
    }
    
    public void displayInfo() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Name: " + accountName);
        System.out.println("Balance: " + balance + " บาท");
    }
    
    // Private Implementation - รายละเอียดที่ซ่อนไว้
    private boolean validateAmount(double amount) {
        if (amount <= 0) {
            System.out.println("✗ จำนวนเงินต้องมากกว่า 0");
            return false;
        }
        return true;
    }
    
    private boolean checkBalance(double amount) {
        if (amount > balance) {
            System.out.println("✗ ยอดเงินไม่เพียงพอ");
            return false;
        }
        return true;
    }
    
    private void performDeposit(double amount) {
        balance += amount;
        System.out.println("✓ ฝากเงิน " + amount + " บาท สำเร็จ");
    }
    
    private void performWithdrawal(double amount) {
        balance -= amount;
        System.out.println("✓ ถอนเงิน " + amount + " บาท สำเร็จ");
    }
    
    private void logTransaction(String type, double amount) {
        // ซ่อนรายละเอียดการ log
        System.out.println("  [Log] " + type + ": " + amount);
    }
}

public class AbstractionExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Abstraction (CLO2)");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        BankAccount account = new BankAccount("001-1-12345", "สมชาย ใจดี");
        
        account.displayInfo();
        System.out.println();
        
        // ผู้ใช้ใช้งาน Public Interface ง่ายๆ
        // ไม่ต้องรู้รายละเอียดว่า validate, log อย่างไร
        account.deposit(5000);
        account.deposit(-100);  // Validation ทำงาน
        System.out.println();
        
        account.withdraw(2000);
        account.withdraw(10000);  // Check balance ทำงาน
        System.out.println();
        
        account.displayInfo();
        
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("✓ Abstraction: แสดงเฉพาะสิ่งสำคัญ (deposit, withdraw)");
        System.out.println("✓ ซ่อนรายละเอียด (validation, logging)");
        System.out.println("✓ Single Responsibility: BankAccount จัดการบัญชีเท่านั้น");
        System.out.println("✓ รองรับ CLO2: Apply abstraction to define class responsibilities\n");
    }
}
