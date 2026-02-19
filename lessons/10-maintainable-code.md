---
icon: user-helmet-safety
---

# บทที่ 10: Maintainable Code Principles

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:

1. บอกหลักการของ Clean Code ได้
2. เขียนโค้ดที่อ่านง่ายและดูแลรักษาได้ **(CLO7)**
3. ใช้ Naming Conventions และ Code Organization ที่ดี **(CLO7)**
4. เขียน Comments และ Documentation ที่มีประโยชน์ได้
5. ทำ Refactoring พื้นฐานได้

## 1. ความหมายของ Maintainable Code

**Maintainable Code** คือโค้ดที่:

* **อ่านง่าย** (Readable) - คนอื่นเข้าใจได้
* **แก้ไขง่าย** (Modifiable) - เปลี่ยนแปลงได้โดยไม่กระทบส่วนอื่น
* **ทดสอบง่าย** (Testable) - เขียน test ได้
* **ขยายง่าย** (Extensible) - เพิ่ม features ได้

### ทำไมต้อง Maintainable?

**สถิติ:**

* 80% ของเวลาในการพัฒนาซอฟต์แวร์ใช้ใน **Maintenance**
* โค้ดที่ไม่ Maintainable ทำให้:
  * เพิ่ม bugs
  * ใช้เวลานานในการแก้ไข
  * ยากต่อการเพิ่ม features

## 2. Clean Code Principles

### 2.1 Meaningful Names (ชื่อที่สื่อความหมาย)

**ไม่ดี:**

```java
int d;  // elapsed time in days
String s1, s2, s3;
```

**ดี:**

```java
int elapsedTimeInDays;
String firstName, lastName, email;
```

**หลักการตั้งชื่อ:**

* ใช้ชื่อที่**สื่อความหมาย**
* **หลีกเลี่ยงตัวย่อ**ที่ไม่ชัดเจน
* ใช้ชื่อที่**ค้นหาได้** (searchable)

### 2.2 Functions Should Do One Thing

**ไม่ดี:**

```java
public void processUserData() {
    // Validate user
    if (user.name == null) return;
    
    // Save to database
    database.save(user);
    
    // Send email
    email.send(user.email, "Welcome!");
    
    // Log activity
    logger.log("User processed");
}
```

**ดี:**

```java
public void processUserData() {
    if (!isValidUser(user)) return;
    
    saveUser(user);
    sendWelcomeEmail(user);
    logUserActivity(user);
}

private boolean isValidUser(User user) {
    return user.name != null && user.email != null;
}

private void saveUser(User user) {
    database.save(user);
}

private void sendWelcomeEmail(User user) {
    email.send(user.email, "Welcome!");
}

private void logUserActivity(User user) {
    logger.log("User processed: " + user.name);
}
```

### 2.3 Small Functions

**หลักการ:**

* Functions ควรสั้น (ประมาณ 20-30 บรรทัด)
* ทำสิ่งเดียว (Single Responsibility)
* มีระดับ abstraction เดียว

```java
// ดี: สั้น ชัดเจน
public double calculateTotalPrice(List<Item> items) {
    double total = 0;
    for (Item item : items) {
        total += item.getPrice();
    }
    return total;
}

// ดี: แยกความรับผิดชอบ
public double calculateTotalWithDiscount(List<Item> items, double discountRate) {
    double total = calculateTotalPrice(items);
    double discount = calculateDiscount(total, discountRate);
    return total - discount;
}

private double calculateDiscount(double total, double rate) {
    return total * rate;
}
```

### 2.4 Avoid Deep Nesting

**ไม่ดี:**

```java
public void processOrder(Order order) {
    if (order != null) {
        if (order.isValid()) {
            if (order.hasItems()) {
                if (order.customer != null) {
                    if (order.customer.hasCreditCard()) {
                        // ซ้อนลึกเกินไป!
                        processPayment(order);
                    }
                }
            }
        }
    }
}
```

**ดี:**

```java
public void processOrder(Order order) {
    // Guard clauses - return early
    if (order == null) return;
    if (!order.isValid()) return;
    if (!order.hasItems()) return;
    if (order.customer == null) return;
    if (!order.customer.hasCreditCard()) return;
    
    processPayment(order);
}
```

## 3. Naming Conventions

### 3.1 Classes

```java
// PascalCase - คำนาม
public class Student { }
public class BankAccount { }
public class OrderProcessor { }
```

### 3.2 Methods

```java
// camelCase - คำกริยา
public void calculateTotal() { }
public double getPrice() { }
public void setName(String name) { }
public boolean isValid() { }
public boolean hasPermission() { }
```

### 3.3 Variables

```java
// camelCase - คำนาม
String firstName;
int studentCount;
double totalPrice;
boolean isActive;
```

### 3.4 Constants

```java
// UPPER_SNAKE_CASE
public static final int MAX_STUDENTS = 50;
public static final double PI = 3.14159;
public static final String DEFAULT_NAME = "Unknown";
```

### 3.5 Packages

```java
// lowercase - จุดแบ่ง
package com.company.project;
package th.ac.university.system;
```

## 4. Code Organization

### 4.1 Class Structure

```java
public class Student {
    // 1. Constants
    private static final int MAX_CREDITS = 24;
    
    // 2. Static variables
    private static int studentCount = 0;
    
    // 3. Instance variables
    private String studentId;
    private String name;
    private double gpa;
    
    // 4. Constructors
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        studentCount++;
    }
    
    // 5. Public methods
    public void enrollCourse(Course course) {
        // ...
    }
    
    public double getGpa() {
        return gpa;
    }
    
    // 6. Private methods
    private void calculateGpa() {
        // ...
    }
}
```

### 4.2 Method Ordering

* Public methods ก่อน
* Private methods หลัง
* Helper methods ใกล้กับ methods ที่เรียกใช้

### 4.3 Vertical Distance

**Methods ที่เกี่ยวข้องควรอยู่ใกล้กัน:**

```java
public void processOrder() {
    validateOrder();      // เรียก
    calculateTotal();     // เรียก
    applyDiscount();      // เรียก
}

private void validateOrder() {    // อยู่ใกล้ processOrder
    // ...
}

private void calculateTotal() {   // อยู่ใกล้ validateOrder
    // ...
}

private void applyDiscount() {    // อยู่ใกล้ calculateTotal
    // ...
}
```

## 5. Comments และ Documentation

### 5.1 เมื่อไหร่ควรเขียน Comments

**ควรเขียนเมื่อ:**

* อธิบาย **ทำไม** (Why) ไม่ใช่ **อะไร** (What)
* อธิบาย Business logic ที่ซับซ้อน
* ระบุ TODO หรือ FIXME

**ไม่ควรเขียนเมื่อ:**

* โค้ดอธิบายตัวเองได้แล้ว
* Redundant comments

### 5.2 Good Comments

```java
// ดี: อธิบาย "ทำไม"
// ต้องคูณด้วย 1.07 เพราะมี VAT 7%
double totalWithTax = price * 1.07;

// ดี: อธิบาย Business rule
// ลูกค้า VIP ได้ส่วนลด 20% เมื่อซื้อมากกว่า 1000 บาท
if (customer.isVIP() && totalAmount > 1000) {
    discount = 0.20;
}

// ดี: TODO comments
// TODO: ต้องเพิ่ม validation สำหรับ email format
public void setEmail(String email) {
    this.email = email;
}
```

### 5.3 Bad Comments

```java
// ไม่ดี: Redundant
// Get the name
public String getName() {
    return name;
}

// ไม่ดี: อธิบายสิ่งที่เห็นได้ชัด
// Loop through students
for (Student student : students) {
    // Print student name
    System.out.println(student.getName());
}

// ไม่ดี: Commented-out code (ควรลบทิ้ง)
// public void oldMethod() {
//     // old implementation
// }
```

### 5.4 Javadoc Comments

```java
/**
 * คำนวณพื้นที่วงกลม
 * 
 * @param radius รัศมีของวงกลม (ต้องมากกว่า 0)
 * @return พื้นที่ของวงกลม
 * @throws IllegalArgumentException ถ้า radius น้อยกว่าหรือเท่ากับ 0
 */
public double calculateCircleArea(double radius) {
    if (radius <= 0) {
        throw new IllegalArgumentException("Radius must be positive");
    }
    return Math.PI * radius * radius;
}
```

## 6. Basic Refactoring

### 6.1 Extract Method

**ก่อน:**

```java
public void printReport() {
    System.out.println("=== Report ===");
    
    // คำนวณยอดรวม
    double total = 0;
    for (Item item : items) {
        total += item.getPrice();
    }
    
    System.out.println("Total: " + total);
}
```

**หลัง:**

```java
public void printReport() {
    printHeader();
    double total = calculateTotal();
    printTotal(total);
}

private void printHeader() {
    System.out.println("=== Report ===");
}

private double calculateTotal() {
    double total = 0;
    for (Item item : items) {
        total += item.getPrice();
    }
    return total;
}

private void printTotal(double total) {
    System.out.println("Total: " + total);
}
```

### 6.2 Rename Variable/Method

**ก่อน:**

```java
int d;  // elapsed time in days
public void calc() { }
```

**หลัง:**

```java
int elapsedTimeInDays;
public void calculateTotal() { }
```

### 6.3 Replace Magic Numbers

**ก่อน:**

```java
if (age >= 18) {
    // ...
}

double tax = price * 0.07;
```

**หลัง:**

```java
private static final int LEGAL_AGE = 18;
private static final double TAX_RATE = 0.07;

if (age >= LEGAL_AGE) {
    // ...
}

double tax = price * TAX_RATE;
```

## 7. SOLID Principles (พื้นฐาน)

### 7.1 Single Responsibility Principle (SRP)

**Class ควรมีเหตุผลในการเปลี่ยนแปลงเพียงอย่างเดียว**

```java
// ดี
class Student {
    String name;
    double gpa;
}

class StudentRepository {
    void save(Student student) { /* ... */ }
}

class StudentPrinter {
    void print(Student student) { /* ... */ }
}
```

### 7.2 Open/Closed Principle (OCP)

**Open for extension, Closed for modification**

ใช้ Inheritance และ Polymorphism เพื่อขยาย functionality โดยไม่แก้ไขโค้ดเดิม

### 7.3 Liskov Substitution Principle (LSP)

**Subclass ต้องสามารถแทนที่ Superclass ได้**

ถ้า Class แม่ (Superclass) สัญญาว่า "ทำสิ่งนี้ได้" Class ลูก (Subclass) ต้องทำสิ่งนั้นได้จริง โดยไม่ทำให้โปรแกรมพัง ถ้าลูกไปเปลี่ยนพฤติกรรมจนคนใช้งานตกใจ หรือโปรแกรม Error นั่นคือผิดหลัก LSP

## 8. Code Smells (สัญญาณโค้ดไม่ดี)

### 8.1 Long Method

Method ที่ยาวเกินไป → แบ่งเป็น methods เล็กๆ

### 8.2 Large Class

Class ที่มี responsibilities มากเกินไป → แยก Class

### 8.3 Duplicate Code

Code ซ้ำ → Extract เป็น method

### 8.4 Dead Code

Code ที่ไม่ได้ใช้ → ลบทิ้ง

## 9. ตัวอย่างโปรแกรมสมบูรณ์

ดูตัวอย่าง: [MaintainableCodeExample.java](../examples/MaintainableCodeExample.java)

โปรแกรมนี้แสดง:

* Clean Code principles
* Good naming conventions
* Proper code organization
* Meaningful comments
* Refactoring examples

## สรุป

* **Maintainable Code** คือโค้ดที่อ่านง่าย แก้ไขง่าย ขยายง่าย **(CLO7)**
* ใช้**ชื่อที่สื่อความหมาย**
* **Functions ควรสั้นและทำสิ่งเดียว**
* **หลีกเลี่ยง Deep Nesting**
* ใช้ **Naming Conventions** ที่เหมาะสม
* **จัดระเบียบโค้ด**ให้เป็นหมวดหมู่
* เขียน **Comments ที่มีประโยชน์**
* ทำ **Refactoring** เพื่อปรับปรุงโค้ด
* ปฏิบัติตาม **SOLID Principles**

## แบบฝึกหัด

1. Refactor โค้ดที่มี nested if มากกว่า 3 ระดับ
2. แยก Long Method (มากกว่า 50 บรรทัด) ออกเป็น smaller methods
3. ตั้งชื่อ variables และ methods ใหม่ให้สื่อความหมายมากขึ้น
4. หา Magic Numbers ในโค้ดและแทนที่ด้วย Constants
5. ลบ Dead Code และ Commented-out code
6. เขียน Javadoc สำหรับ public methods

***

[< บทก่อนหน้า: Error Handling](09-error-handling.md) | [กลับไปหน้าหลัก](../)
