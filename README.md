# หนังสือสอน Object-Oriented Programming (OOP) ภาษา Java

## เกี่ยวกับหนังสือเล่มนี้

หนังสือเล่มนี้มีวัตถุประสงค์เพื่อสอนการเขียนโปรแกรม Java และหลักการ Object-Oriented Programming (OOP) เนื้อหาเขียนเป็นภาษาไทย โดยมีคำศัพท์เทคนิคเป็นภาษาอังกฤษ (ไทย) เพื่อให้ง่ายต่อการเข้าใจและสามารถนำไปใช้ในการพัฒนาซอฟต์แวร์ที่สะอาด ถูกต้อง และดูแลรักษาได้ง่าย

หนังสือเล่มนี้เริ่มต้นจากพื้นฐาน Java Syntax และ Control Flow จนถึงหลักการ OOP ขั้นสูง รวมถึงการเขียนโปรแกรมตาม Class Diagram และการจัดการ Error

## เป้าหมายการเรียนรู้ (Course Learning Outcomes)

หลังจากเรียนจบหนังสือเล่มนี้ นักเรียนจะสามารถ:

**CLO1:** เขียนโปรแกรมที่ถูกต้องโดยใช้ Syntax พื้นฐานและ Control Flow (Write correct programs using basic syntax + control flow)

**CLO2:** ประยุกต์ใช้ Abstraction เพื่อกำหนดความรับผิดชอบของ Class (Apply abstraction to define class responsibilities)

**CLO3:** ใช้ Encapsulation และ Access Control ในการออกแบบ Class (Use encapsulation and access control in class design)

**CLO4:** สร้างโครงสร้างที่นำกลับมาใช้ได้โดยใช้ Inheritance (Build reusable structures using inheritance)

**CLO5:** ใช้งาน Polymorphism เพื่อเปลี่ยนแปลงพฤติกรรมของ Object (Implement polymorphism to vary object behavior)

**CLO6:** เขียนโค้ดตาม Class Diagram (Code according to class diagrams)

**CLO7:** พัฒนาซอฟต์แวร์ OOP ที่สะอาด ถูกต้อง และดูแลรักษาได้ง่าย (Develop clean, correct, maintainable OOP software)

## โครงสร้างเนื้อหา

### ส่วนที่ 1: พื้นฐาน Java Programming

### [บทที่ 1: Program Structure และ Basic Syntax](lessons/01-java-basics.md)
- โครงสร้างโปรแกรม Java
- Variables และ Data Types
- User Input และ Output
- Operators (Arithmetic, Relational, Logical)
- **รองรับ CLO1**

### [บทที่ 2: Control Flow และ Loops](lessons/02-control-flow.md)
- Conditional Statements (if, else, switch)
- Loops (for, while, do-while)
- Break และ Continue
- **รองรับ CLO1**

### [บทที่ 3: Arrays](lessons/03-arrays.md)
- การประกาศและใช้งาน Arrays
- Array Manipulation
- Multi-dimensional Arrays
- **รองรับ CLO1**

### ส่วนที่ 2: Object-Oriented Programming Fundamentals

### [บทที่ 4: Introduction to OOP และ Abstraction](lessons/04-oop-abstraction.md)
- ความหมายของ OOP
- หลักการ Abstraction
- การกำหนดความรับผิดชอบของ Class
- Class และ Object พื้นฐาน
- **รองรับ CLO2**

### [บทที่ 5: Encapsulation และ Access Control](lessons/05-encapsulation.md)
- ความหมายของ Encapsulation
- Access Modifiers (public, private, protected, default)
- Getters และ Setters
- การออกแบบ Class ที่ดี
- **รองรับ CLO3**

### [บทที่ 6: Inheritance](lessons/06-inheritance.md)
- ความหมายของ Inheritance
- Superclass และ Subclass
- การใช้ extends keyword
- Code Reusability
- **รองรับ CLO4**

### [บทที่ 7: Polymorphism](lessons/07-polymorphism.md)
- ความหมายของ Polymorphism
- Method Overloading
- Method Overriding
- Dynamic Binding
- **รองรับ CLO5**

### ส่วนที่ 3: Design และ Best Practices

### [บทที่ 8: UML Class Diagrams และ Model-Based Coding](lessons/08-uml-diagrams.md)
- UML Class Diagram พื้นฐาน
- Relationships (Association, Inheritance, Composition)
- การอ่านและสร้าง Class Diagram
- Model-Based Coding: การเขียนโค้ดตาม Diagram
- **รองรับ CLO6**

### [บทที่ 9: Error Handling](lessons/09-error-handling.md)
- Try-Catch Blocks
- Exception Types
- Basic Error Handling Strategies
- **รองรับ CLO7**

### [บทที่ 10: Maintainable Code Principles](lessons/10-maintainable-code.md)
- Clean Code Principles
- Code Organization
- Naming Conventions
- Comments และ Documentation
- Refactoring Basics
- **รองรับ CLO7**

## วิธีการใช้งานหนังสือเล่มนี้

1. **อ่านเนื้อหา**: เริ่มต้นจากบทที่ 1 และอ่านตามลำดับ
2. **ศึกษาตัวอย่าง**: แต่ละบทจะมีตัวอย่าง code Java ที่สามารถทดลองรันได้
3. **ฝึกปฏิบัติ**: ลองเขียน code ตามตัวอย่างและดัดแปลงเพื่อทดลอง
4. **ทำความเข้าใจ**: อย่าท่องจำ แต่ควรทำความเข้าใจหลักการ

## ข้อกำหนดเบื้องต้น (Prerequisites)

- มีความรู้พื้นฐานเกี่ยวกับการเขียนโปรแกรม
- มีความเข้าใจในตัวแปร (Variables), เงื่อนไข (Conditionals), และลูป (Loops)
- ติดตั้ง Java Development Kit (JDK) เวอร์ชัน 8 ขึ้นไป
- มี Text Editor หรือ IDE สำหรับเขียน Java (แนะนำ: IntelliJ IDEA, Eclipse, VS Code)

## การคอมไพล์และรัน Java Code

```bash
# คอมไพล์ไฟล์ Java
javac FileName.java

# รันโปรแกรม
java FileName
```

## การมีส่วนร่วม (Contributing)

หากพบข้อผิดพลาดหรือต้องการปรับปรุงเนื้อหา สามารถส่ง Pull Request หรือเปิด Issue ได้ที่ Repository นี้

## ใบอนุญาต (License)

โปรเจกต์นี้อยู่ภายใต้ MIT License - ดูรายละเอียดได้ที่ไฟล์ [LICENSE](LICENSE)

## ผู้เขียน

หนังสือเล่มนี้จัดทำขึ้นเพื่อการศึกษา โดยมีเป้าหมายในการสร้างชุมชนนักพัฒนาซอฟต์แวร์ที่เข้าใจและสามารถประยุกต์ใช้หลักการ OOP ได้อย่างถูกต้อง

---

**หมายเหตุ**: เนื้อหาในหนังสือเล่มนี้เหมาะสำหรับผู้เริ่มต้นเรียนรู้ OOP และผู้ที่ต้องการทบทวนความรู้พื้นฐาน