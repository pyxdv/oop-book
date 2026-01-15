---
icon: '1'
---

# บทที่ 1: Program Structure และ Basic Syntax

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:

1. อธิบาย (Explain) โครงสร้างพื้นฐานและหลักการทำงานของโปรแกรมภาษา Java ได้
2. เลือกใช้ (Select) ชนิดข้อมูล (Data Types) และตัวแปร (Variables) ให้เหมาะสมกับโจทย์ปัญหาได้
3. สร้าง (Construct) นิพจน์ทางคณิตศาสตร์และตรรกศาสตร์โดยใช้ตัวดำเนินการ (Operators) ประเภทต่างๆ ได้อย่างถูกต้อง
4. พัฒนา (Develop) โปรแกรม Java พื้นฐานที่มีการรับค่า (Input) ประมวลผล และแสดงผลลัพธ์ (Output) ได้ตามที่กำหนด&#x20;

## 1. โครงสร้างโปรแกรม Java

### 1.1 โปรแกรม Java พื้นฐาน

```java

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**องค์ประกอบ:**

* `public class HelloWorld` - ชื่อ Class (ต้องตรงกับชื่อไฟล์)
* `public static void main(String[] args)` - Method หลักที่โปรแกรมเริ่มทำงาน
* `System.out.println()` - แสดงผลบนหน้าจอ

### 1.2 Comments (คำอธิบาย)

```java
// Single-line comment (คอมเมนต์บรรทัดเดียว)

/*
 * Multi-line comment
 * (คอมเมนต์หลายบรรทัด)
 */

/** 
 * Documentation comment
 * ใช้สำหรับสร้างเอกสาร
 */
```

## 2. Variables และ Data Types

### 2.1 Primitive Data Types

```java
// Integer Types
byte age = 25;           // -128 to 127
short year = 2024;       // -32,768 to 32,767
int population = 70000000;  // -2,147,483,648 to 2,147,483,647
long distance = 9876543210L;  // ต้องใส่ L ท้าย

// Floating-Point Types
float price = 99.99f;    // ต้องใส่ f ท้าย
double pi = 3.14159265359;

// Character Type
char grade = 'A';
char symbol = '@';

// Boolean Type
boolean isStudent = true;
boolean hasLicense = false;
```

### 2.2 Reference Types

```java
String name = "สมชาย";
String message = "Hello, World!";
```

### 2.3 การประกาศ Variables

```java
// ประกาศ
int score;

// ประกาศและกำหนดค่า
int score = 95;

// ประกาศหลายตัวแปร
int x = 10, y = 20, z = 30;

// ค่าคงที่ (Constants)
final double PI = 3.14159;
final int MAX_STUDENTS = 50;
```

### 2.4 Naming Conventions

**ดี:**

```java
int studentAge;
String firstName;
double totalPrice;
```

**ไม่ดี:**

```java
int a;        // ชื่อไม่สื่อความหมาย
String N;     // ควรเป็นตัวเล็ก
double x1;    // ชื่อไม่ชัดเจน
```

## 3. Input และ Output

### 3.1 Output (แสดงผล)

```java
// println - แสดงแล้วขึ้นบรรทัดใหม่
System.out.println("Hello");
System.out.println("World");

// print - แสดงต่อกันบรรทัดเดียว
System.out.print("Hello ");
System.out.print("World");

// printf - จัดรูปแบบ
int age = 25;
double gpa = 3.75;
System.out.printf("Age: %d, GPA: %.2f\n", age, gpa);
```

### 3.2 Input (รับค่า)

```java
import java.util.Scanner;

public class InputExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // อ่านข้อความ
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        // อ่านตัวเลข
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        // อ่านทศนิยม
        System.out.print("Enter your GPA: ");
        double gpa = scanner.nextDouble();
        
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("GPA: " + gpa);
        
        scanner.close();
    }
}
```

## 4. Operators (ตัวดำเนินการ)

### 4.1 Arithmetic Operators (ตัวดำเนินการทางคณิตศาสตร์)

```java
int a = 10, b = 3;

System.out.println(a + b);  // 13 (บวก)
System.out.println(a - b);  // 7  (ลบ)
System.out.println(a * b);  // 30 (คูณ)
System.out.println(a / b);  // 3  (หาร - integer division)
System.out.println(a % b);  // 1  (เศษจากการหาร - modulo)

// Increment และ Decrement
int x = 5;
x++;  // x = x + 1  → 6
x--;  // x = x - 1  → 5
```

### 4.2 Relational Operators (ตัวดำเนินการเปรียบเทียบ)

```java
int x = 5, y = 10;

System.out.println(x == y);  // false (เท่ากับ)
System.out.println(x != y);  // true  (ไม่เท่ากับ)
System.out.println(x > y);   // false (มากกว่า)
System.out.println(x < y);   // true  (น้อยกว่า)
System.out.println(x >= y);  // false (มากกว่าหรือเท่ากับ)
System.out.println(x <= y);  // true  (น้อยกว่าหรือเท่ากับ)
```

### 4.3 Logical Operators (ตัวดำเนินการทางตรรกะ)

```java
boolean a = true, b = false;

System.out.println(a && b);  // false (AND - ทั้งสองเป็น true)
System.out.println(a || b);  // true  (OR - อย่างน้อยหนึ่งเป็น true)
System.out.println(!a);      // false (NOT - กลับค่า)

// ตัวอย่างการใช้งาน
int age = 20;
boolean isStudent = true;

if (age >= 18 && isStudent) {
    System.out.println("Adult student");
}
```

### 4.4 Assignment Operators (ตัวดำเนินการกำหนดค่า)

```java
int x = 10;

x += 5;  // x = x + 5  → 15
x -= 3;  // x = x - 3  → 12
x *= 2;  // x = x * 2  → 24
x /= 4;  // x = x / 4  → 6
x %= 4;  // x = x % 4  → 2
```

### 4.5 Operator Precedence (ลำดับความสำคัญ)

```java
int result = 10 + 5 * 2;  // 20 (คูณก่อน แล้วบวก)
int result2 = (10 + 5) * 2;  // 30 (วงเล็บมีความสำคัญสูงสุด)

// ลำดับ (สูง → ต่ำ):
// 1. ()
// 2. *, /, %
// 3. +, -
// 4. <, >, <=, >=
// 5. ==, !=
// 6. &&
// 7. ||
// 8. =, +=, -=, etc.
```

## 5. Type Conversion (การแปลงชนิดข้อมูล)

### 5.1 Implicit Conversion (แปลงอัตโนมัติ)

```java
int i = 100;
double d = i;  // int → double (ไม่สูญเสียข้อมูล)
System.out.println(d);  // 100.0
```

### 5.2 Explicit Conversion (Casting - แปลงโดยระบุ)

```java
double d = 9.7;
int i = (int) d;  // 9 (ตัดทศนิยมทิ้ง)

int x = 5;
int y = 2;
double result = (double) x / y;  // 2.5
```

### 5.3 String Conversion

```java
// ตัวเลข → String
int age = 25;
String ageStr = String.valueOf(age);
String ageStr2 = "" + age;  // ใช้ + กับ String

// String → ตัวเลข
String numStr = "123";
int num = Integer.parseInt(numStr);
double d = Double.parseDouble("3.14");
```

## 6. ตัวอย่างโปรแกรมสมบูรณ์

ดูตัวอย่าง: [JavaBasicsExample.java](../examples/JavaBasicsExample.java)

โปรแกรมนี้แสดงการใช้งาน:

* Variables และ Data Types
* Input/Output
* Operators ทุกประเภท
* Type Conversion

## สรุป

* **Program Structure**: `public class` + `main method`
* **Variables**: ประกาศด้วย `type name = value;`
* **Data Types**: Primitive (int, double, boolean, char) และ Reference (String)
* **Input**: ใช้ `Scanner` class
* **Output**: ใช้ `System.out.println()`, `print()`, `printf()`
* **Operators**: Arithmetic (+, -, \*, /, %), Relational (==, !=, <, >), Logical (&&, ||, !)
* **Type Conversion**: Implicit (อัตโนมัติ) และ Explicit (casting)

## แบบฝึกหัด

1. เขียนโปรแกรมรับชื่อและอายุจากผู้ใช้ แล้วแสดงผล
2. เขียนโปรแกรมคำนวณพื้นที่วงกลม (π × r²) โดยรับค่ารัศมีจากผู้ใช้
3. เขียนโปรแกรมรับตัวเลข 2 ตัว และแสดงผลการคำนวณ +, -, \*, /, %
4. เขียนโปรแกรมแปลงอุณหภูมิจาก Celsius เป็น Fahrenheit (F = C × 9/5 + 32)

***

[กลับไปหน้าหลัก](../) | [บทถัดไป: Control Flow และ Loops >](02-control-flow.md)
