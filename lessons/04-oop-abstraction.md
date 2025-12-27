---
icon: '4'
---

# บทที่ 4: Introduction to OOP และ Abstraction

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:

1. อธิบายความหมายและหลักการของ Object-Oriented Programming (OOP) ได้
2. เข้าใจและประยุกต์ใช้ Abstraction ได้ **(CLO2)**
3. กำหนดความรับผิดชอบ (Responsibilities) ของ Class ได้ **(CLO2)**
4. สร้าง Class และ Object พื้นฐานได้
5. ออกแบบ Class ที่มี Single Responsibility ได้

## 1. ความหมายของ Object-Oriented Programming (OOP)

**Object-Oriented Programming (OOP)** คือแนวทางการเขียนโปรแกรมที่มุ่งเน้นการจัดระเบียบโค้ดโดยใช้ **Objects** ซึ่งรวม **Data (ข้อมูล)** และ **Behavior (พฤติกรรม)** เข้าด้วยกัน

### ความแตกต่างจาก Procedural Programming

**Procedural Programming:**

```java
// แยก Data และ Functions
String studentName = "สมชาย";
int studentAge = 20;
double studentGPA = 3.50;

void printStudent(String name, int age, double gpa) {
    System.out.println("Name: " + name);
    System.out.println("Age: " + age);
    System.out.println("GPA: " + gpa);
}
```

**Object-Oriented Programming:**

```java
// รวม Data และ Behavior ใน Class
class Student {
    String name;
    int age;
    double gpa;
    
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
    }
}

// ใช้งาน
Student student = new Student();
student.name = "สมชาย";
student.age = 20;
student.gpa = 3.50;
student.displayInfo();
```

### หลักการ 4 ประการของ OOP

1. **Abstraction (นามธรรม)** - แสดงเฉพาะสิ่งสำคัญ ซ่อนรายละเอียด
2. **Encapsulation (การห่อหุ้ม)** - ห่อหุ้มข้อมูลและควบคุมการเข้าถึง
3. **Inheritance (การสืบทอด)** - สืบทอดคุณสมบัติจาก Class อื่น
4. **Polymorphism (พหุสัณฐาน)** - ความสามารถในการมีหลายรูปแบบ

## 2. Abstraction (การนามธรรม)

**Abstraction** คือการ **แสดงเฉพาะสิ่งที่จำเป็น** และ **ซ่อนรายละเอียดที่ซับซ้อน**

### การเปรียบเทียบในชีวิตจริง

**รถยนต์:**

* **ที่เห็น (Abstract)**: พวงมาลัย, เบรก, คันเร่ง
* **ที่ซ่อนไว้ (Hidden)**: เครื่องยนต์, ระบบเกียร์, ระบบไฟฟ้า

คุณไม่ต้องรู้ว่าเครื่องยนต์ทำงานอย่างไร แค่รู้ว่าเหยียบคันเร่งแล้วรถจะวิ่ง

**โทรศัพท์มือถือ:**

* **ที่เห็น**: ปุ่มโทร, แป้นพิมพ์
* **ที่ซ่อนไว้**: สัญญาณ, การเชื่อมต่อเครือข่าย

### Abstraction ในโปรแกรม

```java
// User ไม่ต้องรู้ว่า send() ทำงานอย่างไร
class EmailService {
    // สิ่งที่แสดง (Public Interface)
    public void sendEmail(String to, String subject, String message) {
        // การทำงานที่ซับซ้อน (Hidden Details)
        validateEmail(to);
        connectToServer();
        authenticateUser();
        composeMessage(to, subject, message);
        transmitData();
        closeConnection();
    }
    
    // รายละเอียดที่ซ่อนไว้ (Private Implementation)
    private void validateEmail(String email) { /* ... */ }
    private void connectToServer() { /* ... */ }
    private void authenticateUser() { /* ... */ }
    // ...
}

// การใช้งาน - ง่ายและชัดเจน
EmailService email = new EmailService();
email.sendEmail("friend@example.com", "Hello", "How are you?");
```

## 3. Class และ Object

### 3.1 Class (คลาส)

**Class** คือ **แบบพิมพ์ (Blueprint)** หรือ **แม่แบบ** สำหรับสร้าง Objects

```java
class Student {
    // Attributes (คุณสมบัติ)
    String studentId;
    String name;
    double gpa;
    
    // Methods (พฤติกรรม)
    void study() {
        System.out.println(name + " กำลังเรียน");
    }
    
    void displayInfo() {
        System.out.println("ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}
```

### 3.2 Object (อ็อบเจกต์)

**Object** คือ **ตัวอย่างจริง (Instance)** ที่สร้างจาก Class

```java
// สร้าง Objects
Student student1 = new Student();
student1.studentId = "001";
student1.name = "สมชาย";
student1.gpa = 3.50;

Student student2 = new Student();
student2.studentId = "002";
student2.name = "สมหญิง";
student2.gpa = 3.75;

// แต่ละ Object มีข้อมูลของตัวเองแยกกัน
student1.displayInfo();
student2.displayInfo();
```

## 4. การกำหนดความรับผิดชอบของ Class (CLO2)

### 4.1 Single Responsibility Principle

**Class แต่ละ Class ควรมีความรับผิดชอบเพียงอย่างเดียว**

**ไม่ดี - มีหลายความรับผิดชอบ:**

```java
class Student {
    String name;
    double gpa;
    
    void displayInfo() { /* ... */ }
    
    // ❌ ไม่ใช่ความรับผิดชอบของ Student
    void connectToDatabase() { /* ... */ }
    void sendEmail() { /* ... */ }
    void generateReport() { /* ... */ }
}
```

**ดี - แยกความรับผิดชอบ:**

```java
class Student {
    String name;
    double gpa;
    
    void displayInfo() { /* ... */ }
}

class Database {
    void connect() { /* ... */ }
    void saveStudent(Student s) { /* ... */ }
}

class EmailService {
    void sendEmail(String to, String message) { /* ... */ }
}

class ReportGenerator {
    void generateStudentReport(Student s) { /* ... */ }
}
```

### 4.2 การออกแบบ Class ที่ดี

**ตัวอย่าง: ระบบห้องสมุด**

```java
// Class: Book - รับผิดชอบข้อมูลหนังสือ
class Book {
    String isbn;
    String title;
    String author;
    boolean isAvailable;
    
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Available: " + isAvailable);
    }
}

// Class: Member - รับผิดชอบข้อมูลสมาชิก
class Member {
    String memberId;
    String name;
    
    void displayInfo() {
        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);
    }
}

// Class: Library - รับผิดชอบการจัดการยืม-คืน
class Library {
    void borrowBook(Member member, Book book) {
        if (book.isAvailable) {
            book.isAvailable = false;
            System.out.println(member.name + " ยืม " + book.title);
        } else {
            System.out.println("หนังสือไม่ว่าง");
        }
    }
    
    void returnBook(Book book) {
        book.isAvailable = true;
        System.out.println("คืนหนังสือ " + book.title + " แล้ว");
    }
}
```

### 4.3 การระบุความรับผิดชอบ

**ขั้นตอนการออกแบบ:**

1. **ระบุ Nouns (คำนาม)** = Candidates สำหรับ Classes
2. **ระบุ Verbs (คำกริยา)** = Candidates สำหรับ Methods
3. **จัดกลุ่มความรับผิดชอบ**

**ตัวอย่าง: ระบบร้านอาหาร**

**Nouns:** ลูกค้า, เมนู, ออเดอร์, พนักงาน, โต๊ะ

**Verbs:** สั่งอาหาร, เสิร์ฟ, จ่ายเงิน, จองโต๊ะ

**Classes:**

```java
class Customer {
    String name;
    String phone;
}

class MenuItem {
    String name;
    double price;
}

class Order {
    Customer customer;
    MenuItem[] items;
    double totalAmount;
    
    void addItem(MenuItem item) { /* ... */ }
    double calculateTotal() { /* ... */ }
}

class Table {
    int tableNumber;
    boolean isOccupied;
    
    void reserve() { /* ... */ }
    void release() { /* ... */ }
}
```

## 5. Abstraction Levels (ระดับของ Abstraction)

### Level 1: High-Level (Abstract)

```java
restaurant.processOrder(customer, items);
```

### Level 2: Mid-Level

```java
Order order = new Order();
order.addItems(items);
order.calculateTotal();
order.process();
```

### Level 3: Low-Level (Detailed)

```java
for (MenuItem item : items) {
    validateItem(item);
    checkInventory(item);
    updateStock(item);
    addToOrder(item);
}
calculateTax();
applyDiscount();
generateReceipt();
```

**Abstraction ช่วยให้เราคิดในระดับสูงก่อน แล้วค่อยดำดิ่งลงไปในรายละเอียด**

## 6. ตัวอย่างโปรแกรมสมบูรณ์

ดูตัวอย่าง: [AbstractionExample.java](../examples/AbstractionExample.java)

โปรแกรมนี้แสดง:

* การออกแบบ Class ที่มี Abstraction ที่ดี
* Single Responsibility Principle
* การกำหนดความรับผิดชอบของแต่ละ Class
* ระบบธนาคารอย่างง่าย

## 7. Best Practices

### 7.1 ตั้งชื่อ Class

* ใช้คำนาม (Noun)
* ใช้ PascalCase: `Student`, `BankAccount`, `OrderService`
* ชื่อควรสื่อความหมาย

### 7.2 ตั้งชื่อ Method

* ใช้คำกริยา (Verb)
* ใช้ camelCase: `calculateTotal()`, `sendEmail()`, `displayInfo()`
* ชื่อควรบอกว่าทำอะไร

### 7.3 Keep It Simple

* Class ไม่ควรมีความรับผิดชอบมากเกินไป
* Method ควรทำงานเดียว
* Abstraction ต้องไม่ซับซ้อนเกินไป

## สรุป

* **OOP** คือการจัดระเบียบโค้ดด้วย Objects ที่รวม Data และ Behavior
* **Abstraction** คือการแสดงเฉพาะสิ่งสำคัญ ซ่อนรายละเอียด **(CLO2)**
* **Class** คือแบบพิมพ์ **Object** คือตัวอย่างจริง
* **Single Responsibility** คือแต่ละ Class มีความรับผิดชอบเดียว **(CLO2)**
* การออกแบบที่ดีเริ่มจากการระบุความรับผิดชอบของแต่ละ Class

## แบบฝึกหัด

1. ออกแบบ Classes สำหรับระบบจองโรงแรม (Hotel, Room, Guest, Reservation)
2. ระบุความรับผิดชอบของแต่ละ Class ในข้อ 1
3. เขียน Class `Calculator` ที่มี Methods: add(), subtract(), multiply(), divide()
4. ออกแบบ Classes สำหรับระบบโรงพยาบาล และอธิบายความรับผิดชอบ
5. เปรียบเทียบ Procedural และ OOP approach สำหรับระบบจัดการนักเรียน

## แนวข้อสอบ

1.  ข้อใดเป็นผลดีของการออกแบบคลาสให้มีความรับผิดชอบชัดเจน

    A) โค้ดยาวขึ้น                                           B) คลาสทำงานหลายอย่าง

    C) โปรแกรมดูแลรักษาและแก้ไขได้ง่าย       D) ใช้หน่วยความจำมากขึ้น
2.  ข้อใดเหมาะสมที่สุดที่จะเป็นชื่อคลาส

    A) calculate()                 B) balance                     C) Student                     D) print()
3.  เขียนคลาส Student ที่มีแอททริบิวท์ name สำหรับเก็บชื่อ และ id สำหรับเก็บรหัสนักศึกษา

    Student {

    &#x20;  `String`  name;

    &#x20;  `int`       id;        }
4.  &#x20;จากคลาส Student เขียนโค้ดสร้างวัตถุชื่อ s1

    `Student s1` = `new`  Student();
5. ข้อสอบอัตนัย เขียนโปรแกรม 3 ข้อ (โจทย์ไม่ได้ให้เขียน main method)&#x20;

&#x20;   &#x20;



***

[< บทก่อนหน้า: Arrays](03-arrays.md) | [กลับไปหน้าหลัก](../) | [บทถัดไป: Encapsulation >](05-encapsulation.md)
