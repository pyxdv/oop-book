---
icon: '3'
---

# บทที่ 3: Arrays

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:

1. ประกาศและสร้าง Arrays ในภาษา Java ได้
2. เข้าถึงและแก้ไขข้อมูลใน Arrays ได้
3. ใช้ Loops เพื่อประมวลผล Arrays ได้
4. ทำงานกับ Multi-dimensional Arrays ได้
5. เขียนโปรแกรมที่ใช้ Arrays อย่างถูกต้อง **(CLO1)**

## 1. ความหมายของ Array

**Array** คือโครงสร้างข้อมูลที่เก็บค่าหลายค่าที่มี**ชนิดข้อมูลเดียวกัน**ในตัวแปรเดียว

### ทำไมต้องใช้ Array?

**ไม่ใช้ Array:**

```java
int score1 = 85;
int score2 = 90;
int score3 = 78;
int score4 = 92;
int score5 = 88;

int average = (score1 + score2 + score3 + score4 + score5) / 5;
```

**ใช้ Array:**

```java
int[] scores = {85, 90, 78, 92, 88};

int sum = 0;
for (int score : scores) {
    sum += score;
}
int average = sum / scores.length;
```

## 2. การประกาศ Array

### 2.1 Syntax

```java
// วิธีที่ 1: ประกาศและกำหนดขนาด
dataType[] arrayName = new dataType[size];

// วิธีที่ 2: ประกาศและกำหนดค่าเริ่มต้น
dataType[] arrayName = {value1, value2, value3, ...};
```

### 2.2 ตัวอย่างการประกาศ

```java
// Integer array
int[] numbers = new int[5];  // สร้าง array ขนาด 5 (ค่าเริ่มต้นเป็น 0)

// String array
String[] names = new String[3];  // ค่าเริ่มต้นเป็น null

// กำหนดค่าเริ่มต้นทันที
int[] scores = {85, 90, 78, 92, 88};
String[] fruits = {"Apple", "Banana", "Orange"};
double[] prices = {19.99, 29.99, 39.99, 49.99};

// สามารถใช้ [] ข้างหน้าหรือหลังก็ได้
int[] numbers1;  // แนะนำ
int numbers2[];  // ได้เหมือนกัน แต่ไม่แนะนำ
```

## 3. การเข้าถึงข้อมูลใน Array

### 3.1 Index (ตำแหน่ง)

Arrays ใน Java เริ่มนับจาก **0**

```java
int[] numbers = {10, 20, 30, 40, 50};

// Index:        0   1   2   3   4

System.out.println(numbers[0]);  // 10
System.out.println(numbers[2]);  // 30
System.out.println(numbers[4]);  // 50
```

### 3.2 การกำหนดค่า

```java
int[] scores = new int[5];

scores[0] = 85;
scores[1] = 90;
scores[2] = 78;
scores[3] = 92;
scores[4] = 88;

System.out.println(scores[2]);  // 78
```

### 3.3 Array Length

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers.length);  // 5

// ใช้ใน loop
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

**ข้อควรระวัง:**

```java
int[] numbers = {10, 20, 30};

// numbers.length คือ 3
// Index ที่ถูกต้องคือ 0, 1, 2

System.out.println(numbers[3]);  // Error! ArrayIndexOutOfBoundsException
```

## 4. การวนลูปกับ Array

### 4.1 for Loop (แบบ Index)

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println("numbers[" + i + "] = " + numbers[i]);
}
```

### 4.2 Enhanced for Loop (for-each)

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int num : numbers) {
    System.out.println(num);
}

// ใช้กับ String array
String[] names = {"สมชาย", "สมหญิง", "สมศรี"};

for (String name : names) {
    System.out.println("สวัสดี " + name);
}
```

**ข้อจำกัดของ for-each:**

* ไม่สามารถแก้ไขค่าใน array ได้
* ไม่ทราบ index

```java
int[] numbers = {1, 2, 3, 4, 5};

// ไม่ได้ผล: ค่าใน array ไม่เปลี่ยน
for (int num : numbers) {
    num = num * 2;  // แก้ไขแค่ตัวแปร num ไม่ใช่ array
}

// ต้องใช้ for loop แบบ index
for (int i = 0; i < numbers.length; i++) {
    numbers[i] = numbers[i] * 2;  // ได้ผล
}
```

## 5. Array Operations (การดำเนินการกับ Array)

### 5.1 หาผลรวม (Sum)

```java
int[] numbers = {10, 20, 30, 40, 50};
int sum = 0;

for (int num : numbers) {
    sum += num;
}

System.out.println("Sum = " + sum);  // 150
```

### 5.2 หาค่าเฉลี่ยค (Average)

```java
int[] scores = {85, 90, 78, 92, 88};
int sum = 0;

for (int score : scores) {
    sum += score;
}

double average = (double) sum / scores.length;
System.out.println("Average = " + average);  // 86.6
```

### 5.3 หาค่าสูงสุด/ต่ำสุด

```java
int[] numbers = {45, 23, 78, 12, 90, 56};

// หาค่าสูงสุด
int max = numbers[0];
for (int num : numbers) {
    if (num > max) {
        max = num;
    }
}
System.out.println("Maximum = " + max);  // 90

// หาค่าต่ำสุด
int min = numbers[0];
for (int num : numbers) {
    if (num < min) {
        min = num;
    }
}
System.out.println("Minimum = " + min);  // 12
```

### 5.4 การค้นหา (Search)

```java
int[] numbers = {10, 20, 30, 40, 50};
int target = 30;
boolean found = false;
int position = -1;

for (int i = 0; i < numbers.length; i++) {
    if (numbers[i] == target) {
        found = true;
        position = i;
        break;
    }
}

if (found) {
    System.out.println("Found at index " + position);
} else {
    System.out.println("Not found");
}
```

### 5.5 การคัดลอก Array

```java
int[] original = {1, 2, 3, 4, 5};

// วิธีที่ 1: Manual copy
int[] copy1 = new int[original.length];
for (int i = 0; i < original.length; i++) {
    copy1[i] = original[i];
}

// วิธีที่ 2: Arrays.copyOf()
import java.util.Arrays;
int[] copy2 = Arrays.copyOf(original, original.length);

// วิธีที่ 3: System.arraycopy()
int[] copy3 = new int[original.length];
System.arraycopy(original, 0, copy3, 0, original.length);
```

### 5.6 การเรียงลำดับ (Sorting)

```java
import java.util.Arrays;

int[] numbers = {45, 23, 78, 12, 90};

Arrays.sort(numbers);  // เรียงจากน้อยไปมาก

System.out.println(Arrays.toString(numbers));  // [12, 23, 45, 78, 90]
```

## 6. Multi-dimensional Arrays

### 6.1 2D Array (Array สองมิติ)

```java
// ประกาศ 2D array
int[][] matrix = new int[3][4];  // 3 rows, 4 columns

// กำหนดค่าเริ่มต้น
int[][] matrix2 = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
};

// เข้าถึงข้อมูล
System.out.println(matrix2[0][0]);  // 1
System.out.println(matrix2[1][2]);  // 7
System.out.println(matrix2[2][3]);  // 12

// กำหนดค่า
matrix[0][0] = 100;
matrix[1][2] = 200;
```

### 6.2 วนลูปกับ 2D Array

```java
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};

// แบบ index
for (int i = 0; i < matrix.length; i++) {        // rows
    for (int j = 0; j < matrix[i].length; j++) { // columns
        System.out.print(matrix[i][j] + " ");
    }
    System.out.println();
}

// แบบ for-each
for (int[] row : matrix) {
    for (int value : row) {
        System.out.print(value + " ");
    }
    System.out.println();
}
```

### 6.3 ตัวอย่างการใช้งาน 2D Array

**ตารางคะแนน:**

```java
// นักเรียน 3 คน, วิชา 4 วิชา
int[][] scores = {
    {85, 90, 78, 92},  // นักเรียนคนที่ 1
    {88, 85, 90, 87},  // นักเรียนคนที่ 2
    {75, 80, 85, 90}   // นักเรียนคนที่ 3
};

// หาค่าเฉลี่ยของแต่ละคน
for (int i = 0; i < scores.length; i++) {
    int sum = 0;
    for (int j = 0; j < scores[i].length; j++) {
        sum += scores[i][j];
    }
    double average = (double) sum / scores[i].length;
    System.out.printf("Student %d average: %.2f\n", i + 1, average);
}
```

## 7. Common Pitfalls (ข้อผิดพลาดที่พบบ่อย)

### 7.1 ArrayIndexOutOfBoundsException

```java
int[] numbers = {10, 20, 30};

// ผิด: index เกินขนาด
System.out.println(numbers[3]);  // Error!

// ถูก: ใช้ length ตรวจสอบ
if (3 < numbers.length) {
    System.out.println(numbers[3]);
}
```

### 7.2 NullPointerException

```java
int[] numbers = null;

// ผิด: array ยัง null
System.out.println(numbers.length);  // Error!

// ถูก: ตรวจสอบก่อน
if (numbers != null) {
    System.out.println(numbers.length);
}
```

### 7.3 การเปรียบเทียบ Array

```java
int[] arr1 = {1, 2, 3};
int[] arr2 = {1, 2, 3};

// ผิด: เปรียบเทียบ reference ไม่ใช่เนื้อหา
System.out.println(arr1 == arr2);  // false

// ถูก: ใช้ Arrays.equals()
import java.util.Arrays;
System.out.println(Arrays.equals(arr1, arr2));  // true
```

## 8. ตัวอย่างโปรแกรมสมบูรณ์

ดูตัวอย่าง: [ArraysExample.java](../examples/ArraysExample.java)

โปรแกรมนี้แสดงการใช้งาน:

* การสร้างและใช้งาน Arrays
* Array operations (sum, average, max, min)
* 2D Arrays
* Array manipulation

## สรุป

* **Array**: เก็บข้อมูลหลายค่าชนิดเดียวกัน
* **Index**: เริ่มนับจาก 0
* **Length**: `array.length` บอกขนาดของ array
* **for Loop**: ใช้เมื่อต้องการ index
* **for-each**: ใช้เมื่อต้องการอ่านค่าเท่านั้น
* **2D Array**: Array ของ arrays (แถวและคอลัมน์)
* **Arrays class**: มี methods ช่วยเหลือต่างๆ (sort, copyOf, equals, toString)

## แบบฝึกหัด

1. เขียนโปรแกรมรับคะแนนของนักเรียน 5 คน เก็บใน array และหาค่าเฉลี่ย
2. เขียนโปรแกรมหาว่ามีเลขซ้ำใน array หรือไม่
3. เขียนโปรแกรมกลับด้าน array เช่น {1, 2, 3, 4, 5} กลายเป็น {5, 4, 3, 2, 1}
4. เขียนโปรแกรมสร้างตารางสูตรคูณ 12x12 โดยใช้ 2D array
5. เขียนโปรแกรมรวม 2 arrays เข้าด้วยกัน

## แนวข้อสอบ

1. การนับสมาชิก array ตามเงื่อนไขที่โจทย์กำหนด [https://onlinegdb.com/usPeZEuDUG](https://onlinegdb.com/usPeZEuDUG)

***

[< บทก่อนหน้า: Control Flow](02-control-flow.md) | [กลับไปหน้าหลัก](../) | [บทถัดไป: OOP และ Abstraction >](04-oop-abstraction.md)
