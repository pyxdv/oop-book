# บทที่ 4: Inheritance (การสืบทอด)

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:
1. อธิบายความหมายและความสำคัญของ Inheritance ได้
2. สร้าง Subclass ที่สืบทอดจาก Superclass ได้
3. ใช้ extends keyword ในการสร้าง Inheritance ได้
4. เข้าใจและใช้งาน super keyword ได้
5. อธิบายประโยชน์ของ Inheritance ในการพัฒนาซอฟต์แวร์ได้

## 1. ความหมายของ Inheritance

**Inheritance (การสืบทอด)** คือกลไกที่ช่วยให้ Class หนึ่งสามารถ **รับคุณสมบัติและพฤติกรรม** จาก Class อื่นได้

### แนวคิดพื้นฐาน

- **Superclass (Parent Class/Base Class)**: Class ต้นแบบที่ถูกสืบทอด
- **Subclass (Child Class/Derived Class)**: Class ใหม่ที่สืบทอดจาก Superclass

### การเปรียบเทียบในชีวิตจริง

```
พ่อแม่ (Superclass)
├── มีคุณสมบัติ: สีผม, สีตา, รูปหน้า
└── มีพฤติกรรม: เดิน, กิน, นอน

ลูก (Subclass)
├── รับคุณสมบัติจากพ่อแม่
├── รับพฤติกรรมจากพ่อแม่
└── เพิ่มคุณสมบัติและพฤติกรรมของตัวเอง
```

## 2. Syntax การสร้าง Inheritance

### การใช้ extends keyword

```java
class Superclass {
    // Attributes และ Methods
}

class Subclass extends Superclass {
    // Subclass สืบทอด Attributes และ Methods จาก Superclass
    // สามารถเพิ่ม Attributes และ Methods ใหม่ได้
}
```

### ตัวอย่างพื้นฐาน

```java
// Superclass: สัตว์
class Animal {
    String name;
    int age;
    
    void eat() {
        System.out.println(name + " กำลังกินอาหาร");
    }
    
    void sleep() {
        System.out.println(name + " กำลังนอนหลับ");
    }
}

// Subclass: สุนัข
class Dog extends Animal {
    String breed;  // คุณสมบัติเพิ่มเติม
    
    // พฤติกรรมเพิ่มเติม
    void bark() {
        System.out.println(name + " เห่า: โฮ่ง โฮ่ง!");
    }
}
```

## 3. ความสัมพันธ์แบบ IS-A

Inheritance สร้างความสัมพันธ์แบบ **IS-A** (เป็น)

### ตัวอย่าง

```
Dog IS-A Animal          (✓ ถูกต้อง)
Cat IS-A Animal          (✓ ถูกต้อง)
Car IS-A Animal          (✗ ไม่ถูกต้อง)
```

### การทดสอบความสัมพันธ์

```java
Dog dog = new Dog();
System.out.println(dog instanceof Animal);  // true
System.out.println(dog instanceof Dog);     // true
```

## 4. การเข้าถึง Members ของ Superclass

### 4.1 Access Modifiers กับ Inheritance

```
┌──────────────┬──────────────┬─────────────┐
│   Modifier   │   Subclass   │   Outside   │
├──────────────┼──────────────┼─────────────┤
│   public     │      ✓       │      ✓      │
│   protected  │      ✓       │      ✗      │
│   default    │   ✓ (pkg)    │      ✗      │
│   private    │      ✗       │      ✗      │
└──────────────┴──────────────┴─────────────┘
```

### 4.2 ตัวอย่างการเข้าถึง

```java
class Vehicle {
    public String brand;        // เข้าถึงได้จากทุกที่
    protected int year;         // เข้าถึงได้จาก Subclass
    String model;               // default: เข้าถึงได้ใน Package เดียวกัน
    private double price;       // เข้าถึงได้เฉพาะใน Vehicle
    
    protected void start() {
        System.out.println("เครื่องยนต์สตาร์ท");
    }
}

class Car extends Vehicle {
    void displayInfo() {
        System.out.println(brand);    // ✓ เข้าถึงได้
        System.out.println(year);     // ✓ เข้าถึงได้
        System.out.println(model);    // ✓ เข้าถึงได้ (ถ้าอยู่ในแพคเกจเดียวกัน)
        // System.out.println(price); // ✗ เข้าถึงไม่ได้
        start();                      // ✓ เรียกได้
    }
}
```

## 5. super Keyword

**super** คือตัวแปรพิเศษที่อ้างอิงถึง **Superclass**

### 5.1 การเข้าถึง Members ของ Superclass

```java
class Vehicle {
    String type = "ยานพาหนะ";
    
    void move() {
        System.out.println("ยานพาหนะเคลื่อนที่");
    }
}

class Car extends Vehicle {
    String type = "รถยนต์";
    
    void displayType() {
        System.out.println(type);        // รถยนต์ (ของ Car)
        System.out.println(super.type);  // ยานพาหนะ (ของ Vehicle)
    }
    
    void move() {
        super.move();  // เรียก move() ของ Superclass
        System.out.println("รถยนต์วิ่งบนถนน");
    }
}
```

### 5.2 การเรียก Constructor ของ Superclass

```java
class Animal {
    String name;
    
    Animal(String name) {
        this.name = name;
        System.out.println("สร้าง Animal: " + name);
    }
}

class Dog extends Animal {
    String breed;
    
    Dog(String name, String breed) {
        super(name);  // เรียก Constructor ของ Animal
        this.breed = breed;
        System.out.println("สร้าง Dog สายพันธุ์: " + breed);
    }
}
```

**หมายเหตุ**: `super()` ต้องเป็นคำสั่งแรกใน Constructor

## 6. Types of Inheritance

### 6.1 Single Inheritance
Java รองรับ Single Inheritance เท่านั้น

```
   Animal
     ↑
     |
    Dog
```

```java
class Animal { }
class Dog extends Animal { }
```

### 6.2 Multilevel Inheritance

```
   Animal
     ↑
     |
  Mammal
     ↑
     |
    Dog
```

```java
class Animal { }
class Mammal extends Animal { }
class Dog extends Mammal { }
```

### 6.3 Hierarchical Inheritance

```
     Animal
    /  |  \
   /   |   \
 Dog  Cat  Bird
```

```java
class Animal { }
class Dog extends Animal { }
class Cat extends Animal { }
class Bird extends Animal { }
```

### 6.4 Multiple Inheritance (Java ไม่รองรับ)

```
  ClassA    ClassB
      \      /
       \    /
       ClassC
```

**Java ไม่รองรับ Multiple Inheritance เพื่อหลีกเลี่ยงปัญหา Diamond Problem**

แต่สามารถใช้ **Interfaces** แทนได้ (จะเรียนในหัวข้อขั้นสูง)

## 7. ประโยชน์ของ Inheritance

### 7.1 Code Reusability (นำโค้ดกลับมาใช้ได้)
- ไม่ต้องเขียนโค้ดซ้ำ
- ใช้โค้ดที่ทดสอบแล้วซ้ำได้

### 7.2 Extensibility (ขยายได้)
- เพิ่มความสามารถใหม่ได้ง่าย
- ไม่กระทบโค้ดเดิม

### 7.3 Maintainability (ดูแลรักษาได้ง่าย)
- แก้ไขที่ Superclass ส่งผลไปยัง Subclass ทั้งหมด
- ลดจุดที่ต้องแก้ไข

### 7.4 Polymorphism
- รองรับ Polymorphism (จะเรียนในบทถัดไป)
- เพิ่มความยืดหยุ่นของโค้ด

## 8. ตัวอย่างการใช้งานจริง

ดูตัวอย่างโค้ด Java ที่สมบูรณ์: [InheritanceExample.java](../examples/InheritanceExample.java)

### สิ่งที่จะเห็นในตัวอย่าง:

1. **การสร้าง Superclass และหลาย Subclasses**
2. **การสืบทอด Attributes และ Methods**
3. **การเพิ่ม Members ใหม่ใน Subclass**
4. **การใช้ super keyword**
5. **การแสดงประโยชน์ของ Code Reusability**

## 9. หลักการออกแบบที่ดี

### 9.1 Favor Composition Over Inheritance
- ไม่ใช่ทุกกรณีที่ควรใช้ Inheritance
- บางครั้ง Composition เหมาะสมกว่า

### 9.2 Liskov Substitution Principle
- Subclass ต้องสามารถแทนที่ Superclass ได้
- พฤติกรรมต้องสอดคล้องกัน

### 9.3 Don't Break Encapsulation
- ไม่ควรทำให้ private members เป็น public
- ใช้ protected อย่างระมัดระวัง

## 10. ข้อควรระวัง

### 10.1 ไม่ควรใช้ Inheritance เพื่อ Code Reuse เพียงอย่างเดียว
```java
// ไม่ดี: ไม่มีความสัมพันธ์ IS-A
class Stack extends ArrayList { }  // Stack ไม่ใช่ ArrayList
```

### 10.2 Fragile Base Class Problem
- การเปลี่ยนแปลง Superclass อาจกระทบ Subclass
- ควรออกแบบอย่างระมัดระวัง

### 10.3 ไม่ควร Inherit จาก Concrete Class หลายๆ ชั้น
- ทำให้โครงสร้างซับซ้อน
- ดูแลรักษายาก

## สรุป

- **Inheritance** คือการสืบทอดคุณสมบัติและพฤติกรรมจาก Superclass
- **extends** keyword ใช้สร้าง Inheritance
- **super** keyword ใช้เข้าถึง Members ของ Superclass
- **IS-A** relationship: Subclass IS-A Superclass
- **ประโยชน์**: Code Reusability, Extensibility, Maintainability
- Java รองรับ **Single Inheritance** เท่านั้น

## แบบฝึกหัด

1. สร้าง Class "Vehicle" ที่มี Attributes: brand, year และ Methods: start(), stop()
2. สร้าง Subclass "Car" ที่เพิ่ม Attribute: numberOfDoors และ Method: openTrunk()
3. สร้าง Subclass "Motorcycle" ที่เพิ่ม Attribute: hasSidecar และ Method: wheelie()
4. ทดสอบการสร้าง Objects และเรียกใช้ Methods
5. อธิบายประโยชน์ของการใช้ Inheritance ในตัวอย่างนี้

---

[< บทก่อนหน้า: Encapsulation](05-encapsulation.md) | [กลับไปหน้าหลัก](../README.md) | [บทถัดไป: Polymorphism >](07-polymorphism.md)
