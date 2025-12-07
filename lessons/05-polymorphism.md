# บทที่ 5: Polymorphism (พหุสัณฐาน)

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:
1. อธิบายความหมายและความสำคัญของ Polymorphism ได้
2. เข้าใจและใช้งาน Method Overloading ได้
3. เข้าใจและใช้งาน Method Overriding ได้
4. อธิบายความแตกต่างระหว่าง Compile-time และ Runtime Polymorphism ได้
5. ประยุกต์ใช้ Polymorphism ในการพัฒนาซอฟต์แวร์ได้

## 1. ความหมายของ Polymorphism

**Polymorphism (พหุสัณฐาน)** มาจากภาษากรีก:
- **Poly** = หลาย (Many)
- **Morph** = รูปแบบ (Form)

หมายถึง **ความสามารถที่ Object หรือ Method สามารถมีหลายรูปแบบได้**

### การเปรียบเทียบในชีวิตจริง

**ตัวอย่าง: คนๆ หนึ่ง**
- ที่บ้าน → เป็น "ลูก"
- ที่โรงเรียน → เป็น "นักเรียน"
- ที่ทำงาน → เป็น "พนักงาน"

**คนคนเดียวกัน แต่มีบทบาทหลายแบบ** = Polymorphism

## 2. ประเภทของ Polymorphism

```
Polymorphism
    ├── Compile-time Polymorphism (Static)
    │   └── Method Overloading
    │
    └── Runtime Polymorphism (Dynamic)
        └── Method Overriding
```

## 3. Method Overloading (Compile-time Polymorphism)

**Method Overloading** คือการสร้าง Methods หลายๆ ตัวที่มี**ชื่อเดียวกัน** แต่มี**พารามิเตอร์ต่างกัน**

### 3.1 เงื่อนไขของ Method Overloading

Methods ต้องแตกต่างกันในด้าน:
1. **จำนวนพารามิเตอร์**
2. **ชนิดของพารามิเตอร์**
3. **ลำดับของพารามิเตอร์**

**หมายเหตุ**: Return type อย่างเดียวไม่เพียงพอ

### 3.2 ตัวอย่าง Method Overloading

```java
class Calculator {
    // Method 1: บวกเลขจำนวนเต็ม 2 ตัว
    int add(int a, int b) {
        return a + b;
    }
    
    // Method 2: บวกเลขจำนวนเต็ม 3 ตัว (จำนวนพารามิเตอร์ต่าง)
    int add(int a, int b, int c) {
        return a + b + c;
    }
    
    // Method 3: บวกเลขทศนิยม (ชนิดพารามิเตอร์ต่าง)
    double add(double a, double b) {
        return a + b;
    }
    
    // Method 4: บวกเลขแบบผสม (ลำดับพารามิเตอร์ต่าง)
    double add(int a, double b) {
        return a + b;
    }
    
    double add(double a, int b) {
        return a + b;
    }
}
```

### 3.3 ประโยชน์ของ Method Overloading

- **ใช้งานง่าย**: ไม่ต้องจำชื่อ Method หลายๆ ชื่อ
- **Code ชัดเจน**: ชื่อเดียวกันแสดงว่าทำหน้าที่คล้ายกัน
- **ยืดหยุ่น**: รองรับข้อมูลหลายรูปแบบ

### 3.4 ตัวอย่างใน Java API

```java
System.out.println(10);           // println(int)
System.out.println("Hello");      // println(String)
System.out.println(3.14);         // println(double)
System.out.println(true);         // println(boolean)
```

## 4. Method Overriding (Runtime Polymorphism)

**Method Overriding** คือการ**เขียน Method ใหม่**ใน Subclass ที่มีชื่อและพารามิเตอร์**เหมือนกับ Superclass**

### 4.1 เงื่อนไขของ Method Overriding

1. **ชื่อ Method เหมือนกัน**
2. **พารามิเตอร์เหมือนกัน** (ชนิดและจำนวน)
3. **Return type เหมือนกันหรือเป็น Subtype**
4. **Access modifier ต้องเท่ากันหรือกว้างกว่า**
5. **ต้องมี Inheritance relationship**

### 4.2 ตัวอย่าง Method Overriding

```java
class Animal {
    void makeSound() {
        System.out.println("สัตว์ส่งเสียง");
    }
}

class Dog extends Animal {
    @Override  // Annotation แนะนำให้ใช้
    void makeSound() {
        System.out.println("สุนัขเห่า: โฮ่ง โฮ่ง!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("แมวร้อง: เหมียว เหมียว!");
    }
}
```

### 4.3 @Override Annotation

**@Override** เป็น Annotation ที่:
- แจ้ง Compiler ว่าเรา Override Method
- ช่วยตรวจจับข้อผิดพลาด (เช่น สะกดผิด)
- **แนะนำให้ใช้เสมอ**

### 4.4 การเรียกใช้ Override Method

```java
Animal animal1 = new Dog();
Animal animal2 = new Cat();

animal1.makeSound();  // "สุนัขเห่า: โฮ่ง โฮ่ง!"
animal2.makeSound();  // "แมวร้อง: เหมียว เหมียว!"
```

**นี่คือ Dynamic Binding** - Java เลือก Method ที่ถูกต้องตอน Runtime

## 5. Dynamic Binding (Late Binding)

**Dynamic Binding** คือการตัดสินใจว่าจะเรียก Method ไหน**ตอน Runtime** (ไม่ใช่ Compile time)

### ตัวอย่าง

```java
Animal animal;  // ประกาศเป็น Animal

if (someCondition) {
    animal = new Dog();
} else {
    animal = new Cat();
}

animal.makeSound();  // เรียก Method ไหน? ขึ้นอยู่กับ Runtime!
```

### ประโยชน์

- **ความยืดหยุ่น**: เปลี่ยน Object ได้ตอน Runtime
- **Extensibility**: เพิ่ม Subclass ใหม่ไม่กระทบโค้ดเดิม
- **Polymorphic Behavior**: Object ต่างชนิดตอบสนองแตกต่างกัน

## 6. Polymorphism กับ Inheritance

```java
class Shape {
    void draw() {
        System.out.println("วาดรูปทรง");
    }
    
    double calculateArea() {
        return 0;
    }
}

class Circle extends Shape {
    double radius;
    
    @Override
    void draw() {
        System.out.println("วาดวงกลม");
    }
    
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;
    
    @Override
    void draw() {
        System.out.println("วาดสี่เหลี่ยม");
    }
    
    @Override
    double calculateArea() {
        return width * height;
    }
}

// การใช้งาน
Shape[] shapes = {new Circle(), new Rectangle()};
for (Shape shape : shapes) {
    shape.draw();  // เรียก Method ที่ถูกต้องตาม Object จริง
}
```

## 7. ประโยชน์ของ Polymorphism

### 7.1 Code Flexibility (ความยืดหยุ่น)
- รองรับ Objects หลายชนิดด้วย Interface เดียว
- เปลี่ยน Implementation ได้ง่าย

### 7.2 Maintainability (ดูแลรักษาได้ง่าย)
- เพิ่ม Subclass ใหม่ไม่กระทบโค้ดเดิม
- แก้ไขที่เดียวส่งผลทั้งระบบ

### 7.3 Extensibility (ขยายได้)
- เพิ่ม Features ใหม่ได้โดยไม่แก้โค้ดเดิม
- รองรับ Open/Closed Principle

### 7.4 Code Reusability (นำกลับมาใช้ได้)
- เขียน Method ครั้งเดียว ใช้ได้หลายชนิด
- ลดการเขียนโค้ดซ้ำ

## 8. ตัวอย่างการใช้งานจริง

ดูตัวอย่างโค้ด Java ที่สมบูรณ์: [PolymorphismExample.java](../examples/PolymorphismExample.java)

### สิ่งที่จะเห็นในตัวอย่าง:

1. **Method Overloading**: Methods ชื่อเดียวกันพารามิเตอร์ต่างกัน
2. **Method Overriding**: Override Methods ใน Subclasses
3. **Dynamic Binding**: เรียก Method ที่ถูกต้องตอน Runtime
4. **Polymorphic Arrays**: เก็บ Objects หลายชนิดใน Array เดียว
5. **ประโยชน์ของ Polymorphism** ในการออกแบบระบบ

## 9. การเปรียบเทียบ Overloading vs Overriding

```
┌─────────────────┬──────────────────────┬──────────────────────┐
│    คุณสมบัติ    │   Overloading        │     Overriding       │
├─────────────────┼──────────────────────┼──────────────────────┤
│ ชื่อ Method     │  เหมือนกัน           │  เหมือนกัน           │
│ พารามิเตอร์     │  ต่างกัน             │  เหมือนกัน           │
│ Return Type     │  ไม่จำเป็นต้องเหมือน │  เหมือนหรือ Subtype │
│ ต้องมี Inherit │  ไม่ต้อง             │  ต้องมี              │
│ Binding         │  Compile-time        │  Runtime             │
│ ใช้ @Override   │  ไม่ใช้              │  แนะนำให้ใช้         │
└─────────────────┴──────────────────────┴──────────────────────┘
```

## 10. ข้อควรระวัง

### 10.1 Static Methods ไม่สามารถ Override ได้

```java
class Parent {
    static void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    static void display() {  // นี่คือ Method Hiding ไม่ใช่ Overriding
        System.out.println("Child");
    }
}
```

### 10.2 Private Methods ไม่สามารถ Override ได้

```java
class Parent {
    private void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {
    private void show() {  // นี่เป็น Method ใหม่ ไม่ได้ Override
        System.out.println("Child");
    }
}
```

### 10.3 Final Methods ไม่สามารถ Override ได้

```java
class Parent {
    final void display() {
        System.out.println("Cannot override");
    }
}

class Child extends Parent {
    // void display() { }  // Error! ไม่สามารถ Override final method
}
```

## สรุป

- **Polymorphism** = ความสามารถที่มีได้หลายรูปแบบ
- **Method Overloading**: ชื่อเดียวกัน พารามิเตอร์ต่างกัน (Compile-time)
- **Method Overriding**: Subclass เขียน Method ใหม่ทับ Superclass (Runtime)
- **Dynamic Binding**: Java เลือก Method ที่ถูกต้องตอน Runtime
- **ประโยชน์**: Flexibility, Maintainability, Extensibility, Reusability

## แบบฝึกหัด

1. สร้าง Class "Calculator" พร้อม Method Overloading สำหรับ add(), subtract(), multiply()
2. สร้าง Class "Shape" และ Subclasses (Circle, Rectangle, Triangle)
3. Override Method calculateArea() และ draw() ในแต่ละ Subclass
4. สร้าง Array ของ Shape และวนลูปคำนวณพื้นที่และวาดรูป
5. อธิบายว่า Polymorphism ช่วยให้โค้ดยืดหยุ่นและขยายได้ง่ายอย่างไร

---

[< บทก่อนหน้า: Inheritance](04-inheritance.md) | [กลับไปหน้าหลัก](../README.md) | [บทถัดไป: Class Diagrams >](06-class-diagrams.md)
