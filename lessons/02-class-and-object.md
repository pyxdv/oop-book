# บทที่ 2: Class และ Object

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:
1. อธิบายความหมายและความแตกต่างระหว่าง Class และ Object ได้
2. สร้าง Class ด้วยภาษา Java ได้
3. สร้าง Object จาก Class (Instantiation) ได้
4. กำหนดและใช้งาน Attributes และ Methods ได้
5. เข้าใจความสัมพันธ์ระหว่าง Class และ Object ได้

## 1. ความหมายของ Class และ Object

### Class (คลาส)

**Class** คือ **แบบพิมพ์ (Blueprint)** หรือ **แม่แบบ (Template)** ที่ใช้สำหรับสร้าง Objects

- กำหนดโครงสร้างและพฤติกรรมของ Objects
- เป็นแค่คำจำกัดความ ไม่ได้จองพื้นที่ในหน่วยความจำ
- เปรียบเหมือน **แปลนบ้าน** ที่ยังไม่ได้สร้างจริง

**ตัวอย่างการเปรียบเทียบ:**
```
Class = แปลนบ้าน (พิมพ์เขียวการออกแบบ)
```

### Object (อ็อบเจกต์)

**Object** คือ **ตัวอย่างจริง (Instance)** ที่สร้างจาก Class

- เป็นสิ่งที่มีตัวตนจริงในหน่วยความจำ
- แต่ละ Object มีข้อมูล (State) ของตัวเองแยกกัน
- เปรียบเหมือน **บ้านที่สร้างจริง** จากแปลน

**ตัวอย่างการเปรียบเทียบ:**
```
Object = บ้านที่สร้างจริง (สร้างตามแปลน)
- บ้านหลังที่ 1, บ้านหลังที่ 2, ... (หลายหลังจากแปลนเดียว)
```

### ความสัมพันธ์ระหว่าง Class และ Object

```
Class "Student"                Objects (Instances)
┌─────────────────┐           ┌─────────────────┐
│ - name          │    -->    │ name: "สมชาย"   │
│ - id            │           │ id: "001"       │
│ - gpa           │           │ gpa: 3.50       │
│                 │           └─────────────────┘
│ + study()       │
│ + takeExam()    │           ┌─────────────────┐
└─────────────────┘    -->    │ name: "สมหญิง"  │
                               │ id: "002"       │
                               │ gpa: 3.75       │
                               └─────────────────┘
```

## 2. การสร้าง Class ในภาษา Java

### Syntax พื้นฐาน

```java
class ClassName {
    // Attributes (Fields/Properties)
    dataType attributeName;
    
    // Methods (Functions/Behaviors)
    returnType methodName(parameters) {
        // method body
    }
}
```

### ตัวอย่าง Class Student

```java
class Student {
    // Attributes (คุณสมบัติของนักเรียน)
    String name;
    String studentId;
    double gpa;
    
    // Methods (พฤติกรรมของนักเรียน)
    void study() {
        System.out.println(name + " กำลังเรียนหนังสือ");
    }
    
    void displayInfo() {
        System.out.println("ชื่อ: " + name);
        System.out.println("รหัส: " + studentId);
        System.out.println("GPA: " + gpa);
    }
}
```

## 3. Attributes (Fields)

**Attributes** หรือ **Fields** คือ **ตัวแปร (Variables)** ที่เก็บข้อมูลหรือสถานะของ Object

### ประเภทของ Attributes

**1. Primitive Types:**
```java
int age;           // จำนวนเต็ม
double salary;     // ทศนิยม
boolean isActive;  // true/false
char grade;        // อักขระเดี่ยว
```

**2. Reference Types:**
```java
String name;       // ข้อความ
Date birthDate;    // วันที่
Address address;   // Object อื่น
```

### การตั้งชื่อ Attributes

**Naming Convention:**
- ใช้ camelCase (อักษรตัวแรกเป็นตัวเล็ก)
- ชื่อควรสื่อความหมาย

```java
// ดี
String firstName;
int studentAge;
boolean isEnrolled;

// ไม่ดี
String s;
int x;
boolean b1;
```

## 4. Methods (เมธอด)

**Methods** คือ **ฟังก์ชัน (Functions)** ที่กำหนดพฤติกรรมของ Object

### Syntax ของ Method

```java
accessModifier returnType methodName(parameters) {
    // method body
    return value; // ถ้ามี return type
}
```

### ประเภทของ Methods

**1. Methods ที่ไม่คืนค่า (void):**
```java
void printMessage() {
    System.out.println("Hello!");
}
```

**2. Methods ที่คืนค่า:**
```java
double calculateAverage(double score1, double score2) {
    return (score1 + score2) / 2.0;
}
```

**3. Methods ที่มี Parameters:**
```java
void setName(String newName) {
    name = newName;
}
```

**4. Methods ที่ไม่มี Parameters:**
```java
String getName() {
    return name;
}
```

## 5. การสร้าง Object (Instantiation)

### Syntax

```java
ClassName objectName = new ClassName();
```

### ขั้นตอนการสร้าง Object

**1. ประกาศตัวแปร (Declaration):**
```java
Student student1;
```

**2. สร้าง Object (Instantiation):**
```java
student1 = new Student();
```

**3. รวมเป็นบรรทัดเดียว:**
```java
Student student1 = new Student();
```

## 6. การเข้าถึง Members ของ Object

### การเข้าถึง Attributes

```java
// การอ่านค่า
String name = student1.name;

// การกำหนดค่า
student1.name = "สมชาย";
student1.studentId = "650001";
student1.gpa = 3.50;
```

### การเรียกใช้ Methods

```java
// Method ที่ไม่คืนค่า
student1.study();
student1.displayInfo();

// Method ที่คืนค่า
double avg = student1.calculateAverage(85.5, 90.0);
```

## 7. ตัวอย่างการใช้งานจริง

ดูตัวอย่างโค้ด Java ที่สมบูรณ์: [ClassAndObjectExample.java](../examples/ClassAndObjectExample.java)

### สิ่งที่จะเห็นในตัวอย่าง:

1. **การสร้าง Class "Book"** พร้อม Attributes และ Methods
2. **การสร้างหลาย Objects** จาก Class เดียวกัน
3. **การกำหนดค่าให้กับ Attributes** ของแต่ละ Object
4. **การเรียกใช้ Methods** เพื่อแสดงพฤติกรรม
5. **แสดงให้เห็นว่าแต่ละ Object มีข้อมูลของตัวเองแยกกัน**

## 8. การใช้งาน this Keyword

**`this`** คือตัวแปรพิเศษที่อ้างอิงถึง Object ปัจจุบัน

### การใช้งาน

```java
class Student {
    String name;
    
    void setName(String name) {
        this.name = name;  // this.name คือ attribute, name คือ parameter
    }
}
```

## 9. หลักการออกแบบ Class ที่ดี

### 1. Single Responsibility Principle
- Class ควรมีหน้าที่เดียว มีเป้าหมายชัดเจน
- ไม่ควรทำหลายอย่างเกินไป

### 2. Meaningful Names
- ตั้งชื่อ Class ให้สื่อความหมาย
- ใช้คำนาม (Noun) เป็นชื่อ Class

### 3. Cohesion
- Attributes และ Methods ควรเกี่ยวข้องกัน
- ทำงานร่วมกันเพื่อบรรลุเป้าหมายเดียว

## 10. ข้อควรระวัง

### 1. การเข้าถึง Attributes โดยตรง

```java
// ควรห่อไว้ แต่เรายังไม่ได้เรียน Encapsulation
student1.gpa = -1.0;  // ข้อมูลไม่ถูกต้อง!
```

**หมายเหตุ:** เราจะเรียนวิธีป้องกันปัญหานี้ในบท Encapsulation

### 2. Null Reference

```java
Student student1;
student1.study();  // Error! student1 ยังไม่ได้สร้าง Object
```

**แก้ไข:**
```java
Student student1 = new Student();
student1.study();  // ถูกต้อง
```

## สรุป

- **Class** คือแบบพิมพ์หรือแม่แบบสำหรับสร้าง Objects
- **Object** คือตัวอย่างจริงที่สร้างจาก Class
- **Attributes** เก็บข้อมูลหรือสถานะของ Object
- **Methods** กำหนดพฤติกรรมของ Object
- **Instantiation** คือการสร้าง Object จาก Class ด้วย `new` keyword
- **this** keyword ใช้อ้างอิงถึง Object ปัจจุบัน

## แบบฝึกหัด

1. สร้าง Class "BankAccount" ที่มี Attributes: accountNumber, accountName, balance
2. เพิ่ม Methods: deposit(), withdraw(), displayBalance()
3. สร้าง 2 Objects และทดลองใช้งาน Methods ต่างๆ
4. อธิบายความแตกต่างระหว่าง Class และ Object

---

[< บทก่อนหน้า: บทนำ OOP](01-introduction.md) | [กลับไปหน้าหลัก](../README.md) | [บทถัดไป: Encapsulation >](03-encapsulation.md)
