# บทที่ 1: บทนำ Object-Oriented Programming (OOP)

## Learning Outcomes (ผลลัพธ์การเรียนรู้)

หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:
1. อธิบายความหมายและประวัติของ Object-Oriented Programming ได้
2. เปรียบเทียบความแตกต่างระหว่าง Procedural Programming และ OOP ได้
3. อธิบายหลักการพื้นฐาน 4 ประการของ OOP ได้
4. อธิบายประโยชน์ของการใช้ OOP ในการพัฒนาซอฟต์แวร์ได้

## 1. ความหมายของ Object-Oriented Programming (OOP)

**Object-Oriented Programming (OOP)** หรือ **การเขียนโปรแกรมเชิงวัตถุ** คือแนวทางการเขียนโปรแกรมที่มุ่งเน้นการจัดระเบียบโค้ดโดยใช้ **Objects (วัตถุ)** ซึ่งประกอบด้วยทั้ง **Data (ข้อมูล)** และ **Behavior (พฤติกรรม)** ที่เกี่ยวข้องกันอยู่ในหน่วยเดียว

### ประวัติความเป็นมา

- ทศวรรษ 1960s: เกิดแนวคิด OOP ครั้งแรกจากภาษา Simula
- ทศวรรษ 1970s-1980s: ภาษา Smalltalk พัฒนาแนวคิด OOP ให้สมบูรณ์ขึ้น
- ทศวรรษ 1990s: ภาษา Java และ C++ ทำให้ OOP เป็นที่นิยมอย่างแพร่หลาย
- ปัจจุบัน: OOP เป็นหนึ่งในแนวทางการเขียนโปรแกรมที่ได้รับความนิยมมากที่สุด

## 2. ความแตกต่างระหว่าง Procedural Programming และ OOP

### Procedural Programming (การเขียนโปรแกรมเชิงขั้นตอน)

- เน้นที่ **ขั้นตอน (Procedures)** หรือ **ฟังก์ชัน (Functions)**
- Data และ Functions แยกจากกัน
- เหมาะกับโปรแกรมเล็กๆ ที่ไม่ซับซ้อน
- ตัวอย่างภาษา: C, Pascal, BASIC

### Object-Oriented Programming (OOP)

- เน้นที่ **วัตถุ (Objects)** ที่รวม Data และ Behavior เข้าด้วยกัน
- Data และ Functions อยู่ในหน่วยเดียวกัน (Encapsulation)
- เหมาะกับโปรแกรมขนาดใหญ่และซับซ้อน
- ตัวอย่างภาษา: Java, Python, C++, C#

### ตัวอย่างเปรียบเทียบ

**Procedural Approach:**
```
ข้อมูล: name, age, salary
ฟังก์ชัน: calculateBonus(salary), printEmployee(name, age, salary)
```

**OOP Approach:**
```
Object: Employee
  - Data: name, age, salary
  - Behavior: calculateBonus(), displayInfo()
```

## 3. หลักการพื้นฐานของ OOP (4 Pillars of OOP)

### 3.1 Encapsulation (การห่อหุ้ม)
- การรวม Data และ Methods ที่เกี่ยวข้องไว้ใน Class เดียวกัน
- การซ่อนรายละเอียดการทำงานภายใน (Information Hiding)
- ควบคุมการเข้าถึง Data ผ่าน Access Modifiers

### 3.2 Inheritance (การสืบทอด)
- การสร้าง Class ใหม่จาก Class ที่มีอยู่แล้ว
- Class ใหม่จะได้รับ Properties และ Methods จาก Class เดิม
- ช่วยลดการเขียนโค้ดซ้ำซ้อน (Code Reusability)

### 3.3 Polymorphism (พหุสัณฐาน)
- ความสามารถในการแสดงพฤติกรรมที่แตกต่างกันในรูปแบบเดียวกัน
- Objects ต่างชนิดสามารถตอบสนองต่อ Method เดียวกันได้แตกต่างกัน
- ทำให้โค้ดมีความยืดหยุ่นและขยายได้ง่าย

### 3.4 Abstraction (นามธรรม)
- การแสดงเฉพาะรายละเอียดที่จำเป็น ซ่อนรายละเอียดที่ซับซ้อน
- ช่วยให้โปรแกรมเมอร์มุ่งเน้นที่สิ่งที่ Object ทำได้ มากกว่าวิธีการทำงาน
- ลดความซับซ้อนและเพิ่มความเข้าใจในโค้ด

## 4. ประโยชน์ของ OOP

### 4.1 Modularity (โครงสร้างแบบแยกส่วน)
- แต่ละ Object เป็นหน่วยอิสระ
- สามารถพัฒนาและทดสอบแยกกันได้
- ง่ายต่อการแก้ไขและปรับปรุง

### 4.2 Reusability (การนำกลับมาใช้ได้)
- สามารถนำ Class ที่สร้างไว้แล้วมาใช้ซ้ำได้
- ใช้ Inheritance เพื่อขยาย Functionality
- ลดเวลาในการพัฒนา

### 4.3 Maintainability (ดูแลรักษาได้ง่าย)
- โค้ดมีโครงสร้างที่ชัดเจน
- แก้ไขได้ง่ายโดยไม่กระทบส่วนอื่น
- ลดโอกาสเกิด Bugs

### 4.4 Scalability (ขยายได้)
- สามารถเพิ่ม Features ใหม่ได้ง่าย
- รองรับการเติบโตของโปรเจกต์
- ไม่ต้องเขียนโค้ดใหม่ทั้งหมด

### 4.5 Security (ความปลอดภัย)
- ใช้ Encapsulation ป้องกัน Data
- ควบคุมการเข้าถึง Data ผ่าน Access Modifiers
- ลดความเสี่ยงในการเปลี่ยนแปลง Data โดยไม่ตั้งใจ

## 5. การประยุกต์ใช้ OOP ในโลกจริง

OOP เป็นแนวทางที่เหมาะกับการสร้าง:
- **ระบบธนาคาร**: จัดการบัญชี ลูกค้า ธุรกรรม
- **เกม**: จัดการตัวละคร ไอเทม สถานที่
- **ระบบอีคอมเมิร์ซ**: จัดการสินค้า ลูกค้า คำสั่งซื้อ
- **แอปพลิเคชันมือถือ**: จัดการ UI Components และ Data
- **ระบบจัดการเนื้อหา**: จัดการ Users, Posts, Comments

## 6. ตัวอย่างแนวคิด OOP ในชีวิตจริง

### ตัวอย่าง: รถยนต์ (Car)

**เป็น Object ที่มี:**

**Properties (คุณสมบัติ):**
- สี (color)
- ยี่ห้อ (brand)
- รุ่น (model)
- ความเร็วปัจจุบัน (currentSpeed)

**Methods (พฤติกรรม):**
- สตาร์ทเครื่อง (start())
- ดับเครื่อง (stop())
- เร่งความเร็ว (accelerate())
- เบรก (brake())

## 7. ตัวอย่างโค้ด Java แรก

ดูตัวอย่างโค้ด Java ที่แสดงแนวคิดพื้นฐานของ OOP: [IntroductionExample.java](../examples/IntroductionExample.java)

โค้ดนี้แสดงให้เห็นถึง:
- การสร้าง Class และ Object
- การกำหนด Attributes และ Methods
- การใช้งาน Object ในโปรแกรม

## สรุป

- **OOP** คือการเขียนโปรแกรมที่มุ่งเน้น Objects ซึ่งรวม Data และ Behavior
- **หลักการ 4 ประการ**: Encapsulation, Inheritance, Polymorphism, Abstraction
- **ประโยชน์หลัก**: Modularity, Reusability, Maintainability, Scalability, Security
- OOP ช่วยให้เขียนโค้ดที่สะอาด ถูกต้อง และดูแลรักษาได้ง่าย

## แบบฝึกหัด

1. อธิบายความแตกต่างระหว่าง Procedural Programming และ OOP
2. ยกตัวอย่าง Object จากชีวิตจริง พร้อมระบุ Properties และ Methods
3. อธิบายประโยชน์ของการใช้ OOP ในการพัฒนาซอฟต์แวร์ขนาดใหญ่

---

[< กลับไปหน้าหลัก](../README.md) | [บทถัดไป: Class และ Object >](02-class-and-object.md)
