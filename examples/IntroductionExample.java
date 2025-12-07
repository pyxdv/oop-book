/**
 * IntroductionExample.java
 * ตัวอย่างแนวคิดพื้นฐานของ Object-Oriented Programming
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - การสร้าง Class
 * - การกำหนด Attributes (Fields)
 * - การกำหนด Methods (พฤติกรรม)
 * - การสร้างและใช้งาน Objects
 */

// Class: แบบพิมพ์หรือแม่แบบสำหรับสร้าง Objects
class Car {
    // Attributes (คุณสมบัติของรถยนต์)
    String brand;        // ยี่ห้อ
    String model;        // รุ่น
    String color;        // สี
    int currentSpeed;    // ความเร็วปัจจุบัน
    
    // Method: สตาร์ทเครื่องยนต์
    void start() {
        System.out.println(brand + " " + model + " กำลังสตาร์ทเครื่อง...");
        System.out.println("เครื่องยนต์ทำงานแล้ว!");
    }
    
    // Method: เร่งความเร็ว
    void accelerate(int speed) {
        currentSpeed += speed;
        System.out.println("เร่งความเร็วเป็น " + currentSpeed + " km/h");
    }
    
    // Method: เบรก
    void brake(int speed) {
        currentSpeed -= speed;
        if (currentSpeed < 0) {
            currentSpeed = 0;
        }
        System.out.println("ลดความเร็วเหลือ " + currentSpeed + " km/h");
    }
    
    // Method: ดับเครื่องยนต์
    void stop() {
        currentSpeed = 0;
        System.out.println(brand + " " + model + " ดับเครื่องแล้ว");
    }
    
    // Method: แสดงข้อมูลรถยนต์
    void displayInfo() {
        System.out.println("\n=== ข้อมูลรถยนต์ ===");
        System.out.println("ยี่ห้อ: " + brand);
        System.out.println("รุ่น: " + model);
        System.out.println("สี: " + color);
        System.out.println("ความเร็วปัจจุบัน: " + currentSpeed + " km/h");
        System.out.println("==================\n");
    }
}

// Main Class สำหรับรันโปรแกรม
public class IntroductionExample {
    public static void main(String[] args) {
        System.out.println("=== ตัวอย่าง Object-Oriented Programming ===\n");
        
        // สร้าง Object (Instance) จาก Class Car
        Car myCar = new Car();
        
        // กำหนดค่าให้กับ Attributes
        myCar.brand = "Toyota";
        myCar.model = "Camry";
        myCar.color = "สีเงิน";
        myCar.currentSpeed = 0;
        
        // แสดงข้อมูลรถยนต์
        myCar.displayInfo();
        
        // เรียกใช้ Methods (พฤติกรรม)
        myCar.start();
        System.out.println();
        
        myCar.accelerate(30);
        myCar.accelerate(20);
        myCar.accelerate(10);
        System.out.println();
        
        myCar.brake(15);
        myCar.brake(45);
        System.out.println();
        
        myCar.stop();
        
        // แสดงข้อมูลรถยนต์อีกครั้ง
        myCar.displayInfo();
        
        // สร้าง Object ตัวที่สอง
        System.out.println("\n=== สร้างรถยนต์อีกคัน ===\n");
        Car anotherCar = new Car();
        anotherCar.brand = "Honda";
        anotherCar.model = "Civic";
        anotherCar.color = "สีแดง";
        anotherCar.currentSpeed = 0;
        
        anotherCar.displayInfo();
        anotherCar.start();
        anotherCar.accelerate(50);
        anotherCar.displayInfo();
        
        // สรุป: แสดงให้เห็นว่าแต่ละ Object มีข้อมูลและพฤติกรรมของตัวเองแยกกัน
        System.out.println("\n=== สรุป ===");
        System.out.println("เราสร้าง 2 Objects จาก Class Car เดียวกัน");
        System.out.println("แต่ละ Object มีข้อมูลและสถานะของตัวเองแยกกัน");
        System.out.println("นี่คือแนวคิดพื้นฐานของ Object-Oriented Programming");
    }
}
