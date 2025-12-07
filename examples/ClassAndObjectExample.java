/**
 * ClassAndObjectExample.java
 * ตัวอย่างการสร้างและใช้งาน Class และ Object
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - การสร้าง Class พร้อม Attributes และ Methods
 * - การสร้าง Objects (Instances) จาก Class
 * - การกำหนดค่าและเข้าถึง Attributes
 * - การเรียกใช้ Methods
 * - การแสดงให้เห็นว่าแต่ละ Object มีข้อมูลของตัวเองแยกกัน
 */

// Class: Book (หนังสือ)
class Book {
    // Attributes (คุณสมบัติของหนังสือ)
    String title;          // ชื่อหนังสือ
    String author;         // ชื่อผู้แต่ง
    String isbn;           // รหัส ISBN
    int numberOfPages;     // จำนวนหน้า
    double price;          // ราคา
    boolean isAvailable;   // สถานะว่าง (ยืมได้หรือไม่)
    
    // Method: แสดงข้อมูลหนังสือ
    void displayInfo() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│        ข้อมูลหนังสือ               │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.println("│ ชื่อหนังสือ: " + title);
        System.out.println("│ ผู้แต่ง: " + author);
        System.out.println("│ ISBN: " + isbn);
        System.out.println("│ จำนวนหน้า: " + numberOfPages + " หน้า");
        System.out.println("│ ราคา: " + price + " บาท");
        System.out.println("│ สถานะ: " + (isAvailable ? "ว่าง (ยืมได้)" : "ไม่ว่าง (ถูกยืมแล้ว)"));
        System.out.println("└─────────────────────────────────────┘");
    }
    
    // Method: ยืมหนังสือ
    void borrowBook(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("✓ " + borrowerName + " ยืมหนังสือ \"" + title + "\" สำเร็จ");
        } else {
            System.out.println("✗ ไม่สามารถยืมได้ หนังสือ \"" + title + "\" ถูกยืมไปแล้ว");
        }
    }
    
    // Method: คืนหนังสือ
    void returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("✓ คืนหนังสือ \"" + title + "\" สำเร็จ");
        } else {
            System.out.println("✗ หนังสือ \"" + title + "\" ยังไม่ได้ถูกยืม");
        }
    }
    
    // Method: คำนวณราคาหลังหักส่วนลด
    double calculateDiscountedPrice(double discountPercent) {
        double discount = price * (discountPercent / 100);
        double finalPrice = price - discount;
        System.out.println("ราคาเต็ม: " + price + " บาท");
        System.out.println("ส่วนลด " + discountPercent + "%: -" + discount + " บาท");
        System.out.println("ราคาหลังหักส่วนลด: " + finalPrice + " บาท");
        return finalPrice;
    }
    
    // Method: เปรียบเทียบราคากับหนังสือเล่มอื่น
    void comparePrice(Book otherBook) {
        System.out.println("\n=== เปรียบเทียบราคา ===");
        System.out.println("\"" + this.title + "\": " + this.price + " บาท");
        System.out.println("\"" + otherBook.title + "\": " + otherBook.price + " บาท");
        
        if (this.price > otherBook.price) {
            System.out.println("\"" + this.title + "\" แพงกว่า " + (this.price - otherBook.price) + " บาท");
        } else if (this.price < otherBook.price) {
            System.out.println("\"" + otherBook.title + "\" แพงกว่า " + (otherBook.price - this.price) + " บาท");
        } else {
            System.out.println("ราคาเท่ากัน");
        }
    }
}

// Main Class สำหรับรันโปรแกรม
public class ClassAndObjectExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Class และ Object ในภาษา Java");
        System.out.println("═══════════════════════════════════════════════════");
        
        // สร้าง Object ตัวที่ 1 จาก Class Book
        System.out.println("\n>>> สร้าง Object ตัวที่ 1");
        Book book1 = new Book();
        
        // กำหนดค่าให้กับ Attributes
        book1.title = "Object-Oriented Programming with Java";
        book1.author = "James Gosling";
        book1.isbn = "978-0-13-123456-7";
        book1.numberOfPages = 450;
        book1.price = 890.00;
        book1.isAvailable = true;
        
        // แสดงข้อมูล
        book1.displayInfo();
        
        // สร้าง Object ตัวที่ 2 จาก Class เดียวกัน
        System.out.println("\n>>> สร้าง Object ตัวที่ 2");
        Book book2 = new Book();
        book2.title = "Clean Code";
        book2.author = "Robert C. Martin";
        book2.isbn = "978-0-13-235088-4";
        book2.numberOfPages = 464;
        book2.price = 1200.00;
        book2.isAvailable = true;
        
        book2.displayInfo();
        
        // สร้าง Object ตัวที่ 3
        System.out.println("\n>>> สร้าง Object ตัวที่ 3");
        Book book3 = new Book();
        book3.title = "Design Patterns";
        book3.author = "Gang of Four";
        book3.isbn = "978-0-20-163361-0";
        book3.numberOfPages = 395;
        book3.price = 950.00;
        book3.isAvailable = false;  // ถูกยืมไปแล้ว
        
        book3.displayInfo();
        
        // ทดสอบการยืมและคืนหนังสือ
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การยืมและคืนหนังสือ");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        book1.borrowBook("สมชาย");
        book1.borrowBook("สมหญิง");  // พยายามยืมซ้ำ
        book1.returnBook();
        book1.returnBook();  // พยายามคืนซ้ำ
        
        // คำนวณราคาหลังหักส่วนลด
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        คำนวณส่วนลด");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        System.out.println("หนังสือ: \"" + book2.title + "\"");
        double discountedPrice = book2.calculateDiscountedPrice(15);
        
        // เปรียบเทียบราคาระหว่างหนังสือ 2 เล่ม
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        เปรียบเทียบราคา");
        System.out.println("═══════════════════════════════════════════════════");
        
        book1.comparePrice(book2);
        book2.comparePrice(book3);
        
        // สรุปการใช้งาน
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        สรุป");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n✓ เราสร้าง 3 Objects (book1, book2, book3) จาก Class Book เดียวกัน");
        System.out.println("✓ แต่ละ Object มีข้อมูล (Attributes) ของตัวเองแยกกัน");
        System.out.println("✓ แต่ละ Object สามารถเรียกใช้ Methods เดียวกันได้");
        System.out.println("✓ การเปลี่ยนแปลงข้อมูลใน Object หนึ่งไม่กระทบ Object อื่น");
        System.out.println("✓ นี่คือหลักการพื้นฐานของ Object-Oriented Programming\n");
    }
}
