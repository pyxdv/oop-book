# บทที่ 3: Encapsulation (การห่อหุ้ม)

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:
1. อธิบายความหมายและความสำคัญของ Encapsulation ได้
2. ใช้ Access Modifiers (public, private, protected, default) ได้อย่างเหมาะสม
3. สร้าง Getters และ Setters สำหรับควบคุมการเข้าถึง Attributes ได้
4. ออกแบบ Class ที่มี Encapsulation ที่ดีได้
5. อธิบายประโยชน์ของ Encapsulation ในการพัฒนาซอฟต์แวร์ได้

## 1. ความหมายของ Encapsulation

**Encapsulation (การห่อหุ้ม)** คือหลักการพื้นฐานของ OOP ที่มีจุดประสงค์ 2 ประการ:

### 1.1 การรวมกลุ่ม (Bundling)
- รวม Data (Attributes) และ Methods ที่เกี่ยวข้องกันไว้ใน Class เดียวกัน
- สร้างหน่วยที่สมบูรณ์และเป็นอิสระ

### 1.2 การซ่อนข้อมูล (Information Hiding)
- ซ่อนรายละเอียดการทำงานภายใน
- ควบคุมการเข้าถึง Data ผ่าน Public Interface
- ป้องกันการเข้าถึงหรือแก้ไข Data โดยตรงจากภายนอก

### การเปรียบเทียบ

**เหมือนกับเครื่องใช้ไฟฟ้า:**
- **ภายใน**: วงจรไฟฟ้าซับซ้อน (ซ่อนไว้)
- **ภายนอก**: ปุ่มและสวิตช์ที่ใช้งานง่าย (Public Interface)
- **ผู้ใช้**: ไม่ต้องรู้วิธีทำงานภายใน แค่รู้วิธีใช้งาน

## 2. Access Modifiers (ตัวกำหนดการเข้าถึง)

Java มี Access Modifiers 4 ประเภท:

### 2.1 private
- เข้าถึงได้เฉพาะภายใน Class เดียวกันเท่านั้น
- ใช้กับ Attributes ที่ต้องการซ่อน

```java
class BankAccount {
    private double balance;  // ไม่สามารถเข้าถึงจากภายนอกได้
}
```

### 2.2 public
- เข้าถึงได้จากทุกที่
- ใช้กับ Methods ที่ต้องการให้เรียกใช้จากภายนอก

```java
class BankAccount {
    public void deposit(double amount) {
        // เรียกใช้ได้จากทุกที่
    }
}
```

### 2.3 protected
- เข้าถึงได้จาก Class เดียวกัน, Subclass, และ Package เดียวกัน
- จะเรียนรู้ใน Inheritance

### 2.4 default (ไม่ระบุ)
- เข้าถึงได้จาก Package เดียวกันเท่านั้น
- ไม่ต้องใส่คำว่า default

```java
class Example {
    int value;  // default access
}
```

### ตารางสรุป Access Modifiers

```
┌───────────┬─────────┬─────────┬───────────┬────────────┐
│ Modifier  │  Class  │ Package │ Subclass  │    World   │
├───────────┼─────────┼─────────┼───────────┼────────────┤
│ public    │    ✓    │    ✓    │     ✓     │      ✓     │
│ protected │    ✓    │    ✓    │     ✓     │      ✗     │
│ default   │    ✓    │    ✓    │     ✗     │      ✗     │
│ private   │    ✓    │    ✗    │     ✗     │      ✗     │
└───────────┴─────────┴─────────┴───────────┴────────────┘
```

## 3. Getters และ Setters

**Getters** และ **Setters** คือ Methods ที่ใช้เข้าถึง private Attributes

### 3.1 Getter (Accessor Method)
- ใช้อ่านค่าของ private Attribute
- ชื่อขึ้นต้นด้วย `get` ตามด้วยชื่อ Attribute

```java
public dataType getAttributeName() {
    return attributeName;
}
```

### 3.2 Setter (Mutator Method)
- ใช้กำหนดค่าให้กับ private Attribute
- ชื่อขึ้นต้นด้วย `set` ตามด้วยชื่อ Attribute
- สามารถตรวจสอบความถูกต้องของข้อมูลก่อนกำหนดค่า

```java
public void setAttributeName(dataType value) {
    // ตรวจสอบความถูกต้อง
    if (/* เงื่อนไขที่ถูกต้อง */) {
        this.attributeName = value;
    }
}
```

### ตัวอย่าง

```java
class Student {
    private String name;
    private double gpa;
    
    // Getter สำหรับ name
    public String getName() {
        return name;
    }
    
    // Setter สำหรับ name
    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
            System.out.println("ชื่อไม่ถูกต้อง!");
        }
    }
    
    // Getter สำหรับ gpa
    public double getGpa() {
        return gpa;
    }
    
    // Setter สำหรับ gpa พร้อมตรวจสอบความถูกต้อง
    public void setGpa(double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.gpa = gpa;
        } else {
            System.out.println("GPA ต้องอยู่ระหว่าง 0.0 - 4.0");
        }
    }
}
```

## 4. ประโยชน์ของ Encapsulation

### 4.1 ควบคุมการเข้าถึง Data
- ป้องกันการกำหนดค่าที่ไม่ถูกต้อง
- สามารถตรวจสอบข้อมูลก่อนกำหนดค่า

**ตัวอย่าง:**
```java
// ไม่มี Encapsulation (อันตราย!)
student.gpa = -5.0;  // ค่าไม่ถูกต้องแต่ยอมรับ

// มี Encapsulation (ปลอดภัย)
student.setGpa(-5.0);  // ตรวจสอบและปฏิเสธ
```

### 4.2 ซ่อนการทำงานภายใน
- ผู้ใช้ไม่ต้องรู้รายละเอียดการทำงาน
- เปลี่ยนการทำงานภายในได้โดยไม่กระทบผู้ใช้

### 4.3 ดูแลรักษาได้ง่าย
- เปลี่ยน Implementation โดยไม่กระทบโค้ดภายนอก
- แก้ไขที่เดียวส่งผลทั่วทั้งโปรแกรม

### 4.4 ความยืดหยุ่น
- สามารถเพิ่ม Validation หรือ Logic ได้ในอนาคต
- ไม่ต้องแก้ไขโค้ดผู้ใช้

### 4.5 Read-Only หรือ Write-Only Properties
```java
// Read-Only: มีแค่ Getter
public String getId() {
    return id;
}

// Write-Only: มีแค่ Setter
public void setPassword(String password) {
    this.password = encryptPassword(password);
}
```

## 5. หลักการออกแบบที่ดี

### 5.1 เริ่มจาก private
- ทำ Attributes เป็น private เสมอ
- สร้าง public Methods สำหรับเข้าถึงเท่าที่จำเป็น

### 5.2 มี Validation
- ตรวจสอบความถูกต้องของข้อมูลใน Setters
- แจ้งเตือนหรือปฏิเสธค่าที่ไม่ถูกต้อง

### 5.3 Immutable Objects
- Object ที่ไม่สามารถเปลี่ยนแปลงได้หลังสร้าง
- ไม่มี Setters, กำหนดค่าผ่าน Constructor เท่านั้น

### 5.4 Minimal Interface
- เปิดเผยเฉพาะสิ่งที่จำเป็น
- Methods ที่ไม่จำเป็นควรเป็น private

## 6. ตัวอย่างการใช้งานจริง

ดูตัวอย่างโค้ด Java ที่สมบูรณ์: [EncapsulationExample.java](../examples/EncapsulationExample.java)

### สิ่งที่จะเห็นในตัวอย่าง:

1. **การสร้าง Class ที่มี Encapsulation ที่ดี**
2. **การใช้ private Attributes**
3. **การสร้าง Getters และ Setters พร้อม Validation**
4. **การป้องกันข้อมูลที่ไม่ถูกต้อง**
5. **การแสดงประโยชน์ของ Encapsulation**

## 7. Anti-Patterns ที่ควรหลีกเลี่ยง

### 7.1 Getter/Setter ที่ไม่มีจุดประสงค์
```java
// ไม่ดี: แค่ return ค่าโดยไม่มี Logic
public String getName() {
    return name;
}
```

**หมายเหตุ**: แม้จะดูเหมือนไม่มีประโยชน์ แต่ก็ยังดีกว่าเข้าถึง Attribute โดยตรง เพราะสามารถเพิ่ม Logic ในอนาคตได้

### 7.2 public Attributes
```java
// ไม่ดี: ไม่มีการควบคุม
public class Student {
    public String name;  // ควรเป็น private
    public double gpa;   // ควรเป็น private
}
```

### 7.3 Getter ที่คืน Reference ของ Mutable Object
```java
// อันตราย!
public List<String> getStudents() {
    return students;  // ผู้เรียกสามารถแก้ไข List ได้
}

// ปลอดภัยกว่า
public List<String> getStudents() {
    return new ArrayList<>(students);  // คืน Copy
}
```

## 8. Encapsulation กับหลักการอื่นๆ

### 8.1 กับ Abstraction
- **Encapsulation**: ซ่อนรายละเอียด (How)
- **Abstraction**: แสดงเฉพาะสิ่งสำคัญ (What)

### 8.2 กับ Inheritance
- protected Members สามารถเข้าถึงได้จาก Subclass
- ช่วยให้ Subclass ขยายความสามารถได้

## สรุป

- **Encapsulation** คือการรวม Data และ Methods พร้อมควบคุมการเข้าถึง
- **private Attributes** ป้องกันการเข้าถึงโดยตรง
- **Getters/Setters** ให้ควบคุมการเข้าถึงและตรวจสอบข้อมูล
- **Access Modifiers**: private, public, protected, default
- **ประโยชน์**: ความปลอดภัย, ดูแลรักษาได้ง่าย, ยืดหยุ่น

## แบบฝึกหัด

1. สร้าง Class "Person" พร้อม private Attributes: name, age, email
2. เพิ่ม Getters และ Setters พร้อม Validation:
   - name: ต้องไม่เป็นค่าว่าง
   - age: ต้องอยู่ระหว่าง 0-150
   - email: ต้องมี @ และ .
3. ทดสอบโดยพยายามกำหนดค่าที่ถูกต้องและไม่ถูกต้อง
4. อธิบายว่า Encapsulation ช่วยป้องกันข้อมูลผิดพลาดอย่างไร

---

[< บทก่อนหน้า: Class และ Object](02-class-and-object.md) | [กลับไปหน้าหลัก](../README.md) | [บทถัดไป: Inheritance >](04-inheritance.md)
