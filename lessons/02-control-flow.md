---
icon: '2'
---

# บทที่ 2: Control Flow และ Loops

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:

1. ใช้ Conditional Statements (if, else, switch) ในการควบคุมการทำงานของโปรแกรมได้
2. ใช้ Loops (for, while, do-while) ในการทำงานซ้ำได้
3. ใช้ break และ continue เพื่อควบคุม Loop ได้
4. เลือกใช้ Control Structure ที่เหมาะสมกับแต่ละสถานการณ์ได้
5. เขียนโปรแกรมที่มี Control Flow ที่ถูกต้อง **(CLO1)**

## 1. Conditional Statements

### 1.1 if Statement

```java
int age = 18;

if (age >= 18) {
    System.out.println("คุณเป็นผู้ใหญ่แล้ว");
}
```

```java
// Some code
a >= b
```

### 1.2 if-else Statement

```java
int score = 75;

if (score >= 50) {
    System.out.println("ผ่าน");
} else {
    System.out.println("ไม่ผ่าน");
}
```

### 1.3 if-else-if Statement

```java
int score = 85;

if (score >= 80) {
    System.out.println("เกรด A");
} else if (score >= 70) {
    System.out.println("เกรด B");
} else if (score >= 60) {
    System.out.println("เกรด C");
} else if (score >= 50) {
    System.out.println("เกรด D");
} else {
    System.out.println("เกรด F");
}
```

### 1.4 Nested if (if ซ้อน)

```java
int age = 20;
boolean hasLicense = true;

if (age >= 18) {
    if (hasLicense) {
        System.out.println("สามารถขับรถได้");
    } else {
        System.out.println("ต้องมีใบขับขี่");
    }
} else {
    System.out.println("อายุไม่ถึง 18 ปี");
}
```

### 1.5 Ternary Operator (? :)

```java
int age = 20;
String status = (age >= 18) ? "ผู้ใหญ่" : "เด็ก";
System.out.println(status);  // ผู้ใหญ่

// เทียบกับ if-else
String status2;
if (age >= 18) {
    status2 = "ผู้ใหญ่";
} else {
    status2 = "เด็ก";
}
```

### 1.6 switch Statement

```java
int day = 3;
String dayName;

switch (day) {
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

System.out.println(dayName);  // พุธ
```

**หมายเหตุ**: ต้องใส่ `break` ไม่งั้นจะทำงานต่อไปเรื่อยๆ (fall-through)

### 1.7 switch กับ String (Java 7+)

```java
String grade = "A";

switch (grade) {
    case "A":
        System.out.println("ดีเยี่ยม");
        break;
    case "B":
        System.out.println("ดี");
        break;
    case "C":
        System.out.println("พอใช้");
        break;
    default:
        System.out.println("ต้องปรับปรุง");
}
```

## 2. Loops (การวนซ้ำ)

### 2.1 for Loop

**Syntax:**

```java
for (initialization; condition; update) {
    // code to repeat
}
```

**ตัวอย่าง:**

```java
// พิมพ์ 1 ถึง 5
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}

// นับถอยหลัง
for (int i = 10; i >= 1; i--) {
    System.out.println(i);
}

// เพิ่มทีละ 2
for (int i = 0; i <= 10; i += 2) {
    System.out.println(i);  // 0, 2, 4, 6, 8, 10
}
```

### 2.2 while Loop

**Syntax:**

```java
while (condition) {
    // code to repeat
}
```

**ตัวอย่าง:**

```java
int count = 1;

while (count <= 5) {
    System.out.println(count);
    count++;
}

// รับ input จนกว่าจะถูกต้อง
Scanner scanner = new Scanner(System.in);
int number = 0;

while (number < 1 || number > 10) {
    System.out.print("Enter number (1-10): ");
    number = scanner.nextInt();
}

System.out.println("Valid number: " + number);
```

### 2.3 do-while Loop

**Syntax:**

```java
do {
    // code to repeat
} while (condition);
```

**ตัวอย่าง:**

```java
int count = 1;

do {
    System.out.println(count);
    count++;
} while (count <= 5);

// ความแตกต่างจาก while: ทำงานอย่างน้อย 1 ครั้ง
int x = 10;

do {
    System.out.println("This runs once");
} while (x < 5);  // false แต่ก็ทำงาน 1 ครั้ง
```

### 2.4 Enhanced for Loop (for-each)

ใช้กับ Arrays และ Collections:

```java
int[] numbers = {1, 2, 3, 4, 5};

for (int num : numbers) {
    System.out.println(num);
}

String[] names = {"สมชาย", "สมหญิง", "สมศรี"};

for (String name : names) {
    System.out.println("สวัสดี " + name);
}
```

### 2.5 Nested Loops (Loop ซ้อน)

```java
// พิมพ์สี่เหลี่ยม
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 5; j++) {
        System.out.print("* ");
    }
    System.out.println();
}

// Output:
// * * * * * 
// * * * * * 
// * * * * * 

// สูตรคูณ
for (int i = 1; i <= 5; i++) {
    for (int j = 1; j <= 5; j++) {
        System.out.printf("%2d ", i * j);
    }
    System.out.println();
}
```

## 3. break และ continue

### 3.1 break Statement

หยุด Loop ทันที:

```java
// หาเลขแรกที่หาร 3 ลงตัว
for (int i = 1; i <= 10; i++) {
    if (i % 3 == 0) {
        System.out.println("Found: " + i);
        break;  // หยุด loop
    }
}
// Output: Found: 3

// ใช้กับ while
int count = 0;
while (true) {
    count++;
    if (count > 5) {
        break;  // หยุด infinite loop
    }
    System.out.println(count);
}
```

### 3.2 continue Statement

ข้ามรอบปัจจุบัน ไปรอบถัดไป:

```java
// พิมพ์เลขคี่เท่านั้น
for (int i = 1; i <= 10; i++) {
    if (i % 2 == 0) {
        continue;  // ข้ามเลขคู่
    }
    System.out.println(i);
}
// Output: 1, 3, 5, 7, 9

// ข้ามค่าที่ไม่ต้องการ
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;  // ข้าม 3
    }
    System.out.println(i);
}
// Output: 1, 2, 4, 5
```

## 4. การเลือกใช้ Control Structure

### 4.1 if vs switch

**ใช้ if เมื่อ:**

* ต้องการเปรียบเทียบช่วงค่า (ranges)
* มีเงื่อนไขที่ซับซ้อน
* ตรวจสอบหลายตัวแปร

**ใช้ switch เมื่อ:**

* ตรวจสอบค่าที่เฉพาะเจาะจง
* มีหลายทางเลือก (หลาย case)
* ตรวจสอบตัวแปรเดียว

### 4.2 for vs while vs do-while

**for Loop:**

* รู้จำนวนรอบที่แน่นอน
* มี counter ชัดเจน

**while Loop:**

* ไม่รู้จำนวนรอบ
* ตรวจสอบเงื่อนไขก่อนทำงาน
* อาจไม่ทำงานเลย (ถ้าเงื่อนไขเป็น false ตั้งแต่แรก)

**do-while Loop:**

* ต้องการทำงานอย่างน้อย 1 ครั้ง
* ตรวจสอบเงื่อนไขหลังทำงาน

## 5. Common Patterns (รูปแบบที่ใช้บ่อย)

### 5.1 Input Validation

```java
Scanner scanner = new Scanner(System.in);
int age = -1;

while (age < 0 || age > 150) {
    System.out.print("Enter age (0-150): ");
    age = scanner.nextInt();
    
    if (age < 0 || age > 150) {
        System.out.println("Invalid age!");
    }
}
```

### 5.2 Sum Calculation

```java
int sum = 0;
for (int i = 1; i <= 100; i++) {
    sum += i;
}
System.out.println("Sum = " + sum);  // 5050
```

### 5.3 Finding Maximum

```java
int[] numbers = {45, 23, 78, 12, 90};
int max = numbers[0];

for (int num : numbers) {
    if (num > max) {
        max = num;
    }
}
System.out.println("Maximum: " + max);
```

## 6. ตัวอย่างโปรแกรมสมบูรณ์

ดูตัวอย่าง: [ControlFlowExample.java](../examples/ControlFlowExample.java)

โปรแกรมนี้แสดงการใช้งาน:

* Conditional statements (if, switch)
* Loops ทุกประเภท
* break และ continue
* Nested loops

## สรุป

* **if-else**: ตรวจสอบเงื่อนไข มีทางเลือก 2 ทาง
* **switch**: เลือกทางเดียวจากหลายทางเลือก
* **for**: วนซ้ำจำนวนครั้งที่รู้
* **while**: วนซ้ำจนกว่าเงื่อนไขเป็น false
* **do-while**: วนซ้ำอย่างน้อย 1 ครั้ง
* **break**: หยุด loop ทันที
* **continue**: ข้ามไปรอบถัดไป

## แบบฝึกหัด

1. เขียนโปรแกรมตรวจสอบว่าตัวเลขเป็นเลขคู่หรือคี่
2. เขียนโปรแกรมหาค่า factorial (n!)
3. เขียนโปรแกรมพิมพ์สามเหลี่ยม:

```
*
**
***
****
*****
```

4. เขียนโปรแกรมตรวจสอบว่าเลขเป็นจำนวนเฉพาะหรือไม่
5. เขียนโปรแกรมหาตัวเลข Fibonacci 10 ตัวแรก

***

[< บทก่อนหน้า: Java Basics](01-java-basics.md) | [กลับไปหน้าหลัก](../) | [บทถัดไป: Arrays >](03-arrays.md)
