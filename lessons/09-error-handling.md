---
icon: '9'
---

# บทที่ 9: Error Handling

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:

1. บอกความหมายและประเภทของ Exceptions ใน Java ได้
2. ใช้ try-catch blocks เพื่อจัดการ Errors ได้
3. สร้างโปรแกรมที่จัดการกับ Errors ได้อย่างเหมาะสม
4. เขียนโค้ดที่ Robust และไม่ crash ง่าย **(CLO7)**

## 1. ความหมายของ Error Handling

**Error Handling** คือการจัดการกับสถานการณ์ที่ผิดปกติ (Errors หรือ Exceptions) ที่เกิดขึ้นระหว่างการรันโปรแกรม

### ทำไมต้อง Handle Errors?

**ไม่มี Error Handling:**

```java
int result = 10 / 0;  // โปรแกรม crash!
System.out.println(result);  // ไม่ทำงาน
```

**มี Error Handling:**

```java
try {
    int result = 10 / 0;
    System.out.println(result);
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero");
}
System.out.println("Program continues...");
```

## 2. Exception Types (ประเภทของ Exception)

### 2.1 Checked Exceptions

Exception ที่ต้อง handle หรือ declare (Compiler บังคับ)

**ตัวอย่าง:**

* `IOException` - ปัญหาเกี่ยวกับ Input/Output
* `FileNotFoundException` - หาไฟล์ไม่เจอ
* `SQLException` - ปัญหาเกี่ยวกับ Database

```java
import java.io.*;

// ต้อง declare throws หรือใช้ try-catch
public void readFile() throws IOException {
    FileReader file = new FileReader("data.txt");
    // ...
}

// หรือ
public void readFile() {
    try {
        FileReader file = new FileReader("data.txt");
        // ...
    } catch (IOException e) {
        System.out.println("Error reading file");
    }
}
```

### 2.2 Unchecked Exceptions (Runtime Exceptions)

Exception ที่ไม่บังคับให้ handle

**ตัวอย่าง:**

* `NullPointerException` - ใช้ object ที่เป็น null
* `ArrayIndexOutOfBoundsException` - Index เกินขนาด array
* `ArithmeticException` - ข้อผิดพลาดทางคณิตศาสตร์
* `IllegalArgumentException` - Parameter ไม่ถูกต้อง

```java
// NullPointerException
String text = null;
System.out.println(text.length());  // Error!

// ArrayIndexOutOfBoundsException
int[] numbers = {1, 2, 3};
System.out.println(numbers[5]);  // Error!

// ArithmeticException
int result = 10 / 0;  // Error!
```

### 2.3 Errors

ปัญหาร้ายแรงที่โปรแกรมไม่สามารถ recover ได้

**ตัวอย่าง:**

* `OutOfMemoryError` - หน่วยความจำเต็ม
* `StackOverflowError` - Stack overflow (เช่น recursion ไม่สิ้นสุด)

## 3. try-catch Blocks

### 3.1 Syntax พื้นฐาน

```java
try {
    // โค้ดที่อาจเกิด exception
} catch (ExceptionType e) {
    // จัดการกับ exception
}
```

### 3.2 ตัวอย่างการใช้งาน

```java
import java.util.Scanner;

Scanner scanner = new Scanner(System.in);

try {
    System.out.print("Enter a number: ");
    int number = scanner.nextInt();
    
    System.out.print("Enter divisor: ");
    int divisor = scanner.nextInt();
    
    int result = number / divisor;
    System.out.println("Result: " + result);
    
} catch (ArithmeticException e) {
    System.out.println("Error: Cannot divide by zero!");
} catch (Exception e) {
    System.out.println("Error: Invalid input!");
}

System.out.println("Program continues...");
```

### 3.3 Multiple catch Blocks

```java
try {
    int[] numbers = {1, 2, 3};
    System.out.println(numbers[5]);
    
    int result = 10 / 0;
    
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Error: Array index out of bounds");
} catch (ArithmeticException e) {
    System.out.println("Error: Division by zero");
} catch (Exception e) {
    System.out.println("Error: Something went wrong");
}
```

**หมายเหตุ:** catch blocks ต้องเรียงจากเฉพาะเจาะจงไปทั่วไป (Specific → General)

### 3.4 Multi-catch (Java 7+)

```java
try {
    // โค้ดที่อาจเกิด exception
} catch (IOException | SQLException e) {
    System.out.println("Database or file error: " + e.getMessage());
}
```

## 4. finally Block

**finally** block จะทำงาน**เสมอ** ไม่ว่าจะเกิด exception หรือไม่

```java
try {
    // เปิดไฟล์
    FileReader file = new FileReader("data.txt");
    // อ่านข้อมูล
    
} catch (IOException e) {
    System.out.println("Error reading file");
    
} finally {
    // ปิดไฟล์ (ทำงานเสมอ)
    System.out.println("Closing file...");
}
```

### การใช้งาน finally

**ใช้สำหรับ:**

* ปิด resources (files, database connections)
* ทำความสะอาด (cleanup)
* Release resources

```java
Scanner scanner = null;

try {
    scanner = new Scanner(System.in);
    // ใช้งาน scanner
    
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
    
} finally {
    if (scanner != null) {
        scanner.close();  // ปิดเสมอ
    }
}
```

## 5. try-with-resources (Java 7+)

Automatically ปิด resources หลังใช้งาน

```java
// แทนที่จะใช้ finally
try (Scanner scanner = new Scanner(System.in)) {
    int number = scanner.nextInt();
    System.out.println("Number: " + number);
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
}
// scanner จะถูกปิดอัตโนมัติ
```

**ใช้ได้กับ classes ที่ implement `AutoCloseable`:**

* `Scanner`
* `FileReader`, `FileWriter`
* `BufferedReader`, `BufferedWriter`
* Database connections

## 6. Exception Information

### 6.1 getMessage()

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println("Error: " + e.getMessage());
    // Output: / by zero
}
```

### 6.2 printStackTrace()

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    e.printStackTrace();
    // แสดง stack trace ทั้งหมด
}
```

### 6.3 toString()

```java
try {
    int result = 10 / 0;
} catch (ArithmeticException e) {
    System.out.println(e.toString());
    // Output: java.lang.ArithmeticException: / by zero
}
```

## 7. Best Practices

### 7.1 Catch Specific Exceptions

**ไม่ดี:**

```java
try {
    // โค้ด
} catch (Exception e) {  // ทั่วไปเกินไป
    System.out.println("Error");
}
```

**ดี:**

```java
try {
    // โค้ด
} catch (FileNotFoundException e) {
    System.out.println("File not found");
} catch (IOException e) {
    System.out.println("IO error");
}
```

### 7.2 Don't Ignore Exceptions

**ไม่ดี:**

```java
try {
    // โค้ด
} catch (Exception e) {
    // ไม่ทำอะไร - อันตราย!
}
```

**ดี:**

```java
try {
    // โค้ด
} catch (Exception e) {
    System.out.println("Error: " + e.getMessage());
    // หรือ log error
}
```

### 7.3 Provide Meaningful Messages

```java
try {
    double result = divide(10, 0);
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero. Please enter a non-zero divisor.");
}
```

### 7.4 Clean Up Resources

```java
// ใช้ try-with-resources
try (Scanner scanner = new Scanner(System.in)) {
    // ใช้งาน scanner
}

// หรือใช้ finally
Scanner scanner = null;
try {
    scanner = new Scanner(System.in);
} finally {
    if (scanner != null) {
        scanner.close();
    }
}
```

## 8. Common Exception Scenarios

### 8.1 Input Validation

```java
Scanner scanner = new Scanner(System.in);
int number = 0;
boolean validInput = false;

while (!validInput) {
    try {
        System.out.print("Enter a number: ");
        number = scanner.nextInt();
        validInput = true;
        
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a number.");
        scanner.nextLine();  // Clear buffer
    }
}
```

### 8.2 Array Access

```java
int[] numbers = {1, 2, 3, 4, 5};

public int getElement(int index) {
    try {
        return numbers[index];
    } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("Invalid index: " + index);
        return -1;  // หรือค่า default
    }
}
```

### 8.3 Null Check

```java
public void printLength(String text) {
    try {
        System.out.println("Length: " + text.length());
    } catch (NullPointerException e) {
        System.out.println("Text is null");
    }
}

// หรือตรวจสอบก่อน (ดีกว่า)
public void printLength(String text) {
    if (text != null) {
        System.out.println("Length: " + text.length());
    } else {
        System.out.println("Text is null");
    }
}
```

## 9. ตัวอย่างโปรแกรมสมบูรณ์

ดูตัวอย่าง: [ErrorHandlingExample.java](../examples/ErrorHandlingExample.java)

โปรแกรมนี้แสดง:

* การใช้ try-catch blocks
* Multiple catch blocks
* finally block
* try-with-resources
* Input validation
* Robust error handling

## สรุป

* **try-catch** ใช้จัดการ exceptions
* **finally** ทำงานเสมอ เหมาะสำหรับ cleanup
* **try-with-resources** ปิด resources อัตโนมัติ
* Catch **specific exceptions** แทน generic Exception
* ให้ **meaningful error messages**
* **Don't ignore exceptions**
* Error handling ทำให้โปรแกรม **robust** และไม่ crash ง่าย **(CLO7)**

## แบบฝึกหัด

1. เขียนโปรแกรมรับตัวเลข 2 ตัวและหาร พร้อม handle ArithmeticException
2. เขียนโปรแกรมอ่านไฟล์ พร้อม handle IOException
3. เขียน Method `parseInt(String)` ที่ handle NumberFormatException
4. เขียนโปรแกรมรับ input จาก user พร้อม validate ด้วย exception handling
5. สร้าง Calculator class ที่มี error handling สำหรับการหาร

***

[< บทก่อนหน้า: UML Diagrams](08-uml-diagrams.md) | [กลับไปหน้าหลัก](../) | [บทถัดไป: Maintainable Code >](10-maintainable-code.md)
