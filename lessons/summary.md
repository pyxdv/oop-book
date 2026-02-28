---
description: คุณได้เรียนจบคอร์ส  Object-Oriented Programming แล้ว
---

# 🎓 Summary

### 4 Pillars of OOP

สรุปหัวใจสำคัญ 4 เสาหลักของการเขียนโปรแกรมเชิงวัตถุ (4 Pillars of OOP) พร้อมแทรกตัวอย่างโค้ดภาษา Java เพื่อให้เห็นภาพการทำงานชัดเจนยิ่งขึ้นครับ:

#### 1. Encapsulation (การห่อหุ้มข้อมูล)

* คอนเซปต์: การมัดรวมข้อมูลและเมธอดไว้ด้วยกัน และซ่อนข้อมูลโดยกำหนดตัวแปรเป็น private การเข้าถึงหรือแก้ไขจะต้องทำผ่านเมธอด public (Getters/Setters) เท่านั้น เพื่อป้องกันข้อมูลผิดเพี้ยน
* ตัวอย่างโค้ด:

```java
class BankAccount {
    // ซ่อนข้อมูลไม่ให้เข้าถึงโดยตรง (private)
    private double balance;

    // ใช้เมธอด public เพื่อควบคุมเงื่อนไขการแก้ไขข้อมูล
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // ใช้เมธอด public เพื่อดึงข้อมูลไปดู
    public double getBalance() {
        return balance;
    }
}

```

#### 2. Inheritance (การสืบทอดคุณสมบัติ)

* คอนเซปต์: คลาสลูก (Subclass) สามารถรับถ่ายทอดคุณสมบัติและเมธอดมาจากคลาสแม่ (Superclass) ผ่านคีย์เวิร์ด extends ช่วยให้นำโค้ดเดิมกลับมาใช้ใหม่ได้โดยไม่ต้องเขียนซ้ำ
* ตัวอย่างโค้ด:

```java
// คลาสแม่
class Animal {
    protected String name;
   
    public void eat() {
        System.out.println("Eating...");
    }
}

// คลาสลูกสืบทอดจากคลาสแม่
class Dog extends Animal {
    public void bark() {
        System.out.println("Woof! Woof!");
    }
}


```

#### 3. Polymorphism (พหุสัณฐาน)

* คอนเซปต์: การที่อ็อบเจกต์ต่างคลาสกัน (แต่สืบทอดมาจากคลาสแม่เดียวกัน) สามารถตอบสนองต่อคำสั่ง (เมธอด) เดียวกันในรูปแบบของตัวเองได้ผ่านการเขียนทับ (Method Overriding)
* ตัวอย่างโค้ด:

```java
class Animal {
    public void makeSound() {
        System.out.println("Some generic sound");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Meow");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof");
    }
}

// การใช้งาน: ตัวแปรเป็นคลาสแม่ แต่อ็อบเจกต์จริงเป็นคลาสลูก (Dynamic binding)
Animal myPet = new Cat();
myPet.makeSound(); // ผลลัพธ์: Meow (ระบบเลือกรันคำสั่งตามอ็อบเจกต์จริง)
```

#### 4. Abstraction

* คอนเซปต์: การแสดงเฉพาะสิ่งที่จำเป็นต้องใช้ (What to do) และซ่อนรายละเอียดความซับซ้อนของการทำงานเบื้องหลังไว้ (How to do) มักใช้ interface หรือ abstract class เป็นตัวกำหนดโครงสร้าง
*   การใช้ Abstraction ในแง่ของการนิยามคลาส (Class Definition) หรือที่มักเรียกว่า Data Abstraction คือกระบวนการคัดเลือกเฉพาะ "ข้อมูล" (Attributes) และ "พฤติกรรม" (Methods) ที่ จำเป็นและเกี่ยวข้องกับระบบที่เรากำลังสร้างเท่านั้น โดยตัดทอนรายละเอียดอื่นๆ ในโลกจริงที่ไม่สำคัญทิ้งไป

    หลักการนี้ช่วยให้คลาสมีขนาดกะทัดรัด ทำหน้าที่เฉพาะเจาะจง (Single Responsibility) และไม่เก็บข้อมูลที่ระบบไม่ได้ใช้งาน
* สมมติว่าเราต้องการสร้างคลาส `Person` (บุคคล) ในโลกจริงบุคคลคนหนึ่งมีข้อมูลและพฤติกรรมเยอะมาก (เช่น สีผม, งานอดิเรก, ประวัติการรักษา, ข้อมูลบัตรเครดิต) แต่เวลาเราเขียนโปรแกรม เราจะใช้ Abstraction เพื่อดึงมาเฉพาะสิ่งที่ระบบนั้นๆ ต้องการ:
  *   &#x20;หากเป็นระบบโรงพยาบาล (Hospital System)

      ระบบนี้ไม่สนใจว่าคนไข้ชอบช้อปปิ้งอะไร หรือมีประวัติการสั่งซื้อสินค้าอย่างไร



      ```java
      class Patient {
          // ดึงมาเฉพาะข้อมูลทางการแพทย์ (Attributes)
          private String patientId;
          private String bloodType;
          private String medicalHistory;

          // พฤติกรรมที่เกี่ยวข้องกับโรงพยาบาล (Methods)
          public void admitToHospital() {
              System.out.println("Admitting patient...");
          }
          
          public void prescribeMedicine() {
              System.out.println("Prescribing medicine...");
          }
      }
      ```


  *   หากเป็นระบบอีคอมเมิร์ซ (E-commerce System)

      ระบบนี้ไม่สนใจว่าลูกค้าเลือดกรุ๊ปอะไร หรือมีโรคประจำตัวหรือไม่



      ```java
      class Customer {
          // ดึงมาเฉพาะข้อมูลการซื้อขาย (Attributes)
          private String customerId;
          private String shippingAddress;
          private String paymentMethod;

          // พฤติกรรมที่เกี่ยวข้องกับการซื้อของ (Methods)
          public void addToCart(String item) {
              System.out.println("Adding " + item + " to cart...");
          }
          
          public void checkout() {
              System.out.println("Processing payment...");
          }
      }
      ```
* #### สรุปข้อดีของการทำ Abstraction ในการออกแบบคลาส
  * ลดความซับซ้อน: คลาสจะมีเฉพาะสิ่งที่จำเป็นต่อบริบทการทำงานนั้นๆ
  * เพิ่มประสิทธิภาพ: ไม่เปลืองหน่วยความจำไปกับการเก็บข้อมูลที่ระบบไม่ได้ใช้
  * ดูแลรักษาง่าย (Maintainability): โค้ดอ่านเข้าใจง่ายขึ้น เพราะสะท้อนถึงขอบเขตความรับผิดชอบของคลาสได้อย่างชัดเจน

```java
// Interface ทำหน้าที่เสมือน "สัญญา" บังคับว่าต้องมีคำสั่งอะไรบ้าง
interface Playable {
    void play(); // บอกแค่ว่าต้อง "เล่น" (What) แต่ไม่บอกว่าเล่นอย่างไร
}

// คลาสที่นำไปใช้งานจริง (Concrete class) จะเป็นผู้กำหนดรายละเอียด
class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Strumming the guitar chords..."); // ระบุวิธี "เล่น" (How)
    }
}
```

### **สิ่งที่ได้เรียนรู้ บทที่ 1-10:**

✅ **Java Fundamentals** &#x20;

* Program Structure, Variables, Data Types
* Control Flow (if, switch, loops)
* Arrays

✅ **OOP Core Concepts**

* Abstraction - กำหนดความรับผิดชอบของ Class &#x20;
* Encapsulation - ควบคุมการเข้าถึงข้อมูล &#x20;
* Inheritance - สร้างโครงสร้างที่นำกลับมาใช้ได้ &#x20;
* Polymorphism - เปลี่ยนแปลงพฤติกรรม Object&#x20;

✅ **Design & Best Practices**&#x20;

* UML Class Diagrams และ Model-Based Coding
* Error Handling
* Maintainable Code Principles

**ขั้นตอนต่อไป:**

* ฝึกเขียนโปรเจกต์จริง
* ศึกษา Design Patterns
* เรียนรู้ Frameworks
* พัฒนาทักษะ Debugging และ Testing
