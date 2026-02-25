---
icon: lightbulb-exclamation-on
---

# Final Exam Guideline

### Gemini said

English Version:

You are absolutely right. Because I wrapped the entire response in a ` ```markdown ` code block, your Markdown editor treated everything—including the HTML `<mark>` tags and the tables—as raw code instead of rendering them properly.

To fix this and ensure it works perfectly in any Markdown editor (like VS Code or Obsidian), I have removed the outer code block. I also replaced the HTML highlight tags with clean Markdown emojis (🔵, 🟢, 🟠, 🔴) to represent the colors, which matches the style you used in your original Midterm template.

You can simply copy the text below (starting from the `# Final Exam Guideline` heading) and paste it directly into your `.md` file!

***

Thai Version:

คุณสังเกตได้ถูกต้องเลยครับ! เป็นเพราะผมครอบข้อความทั้งหมดด้วยบล็อกโค้ด ` ```markdown ` โปรแกรม Markdown Editor ของคุณเลยอ่านแท็ก HTML `<mark>` รวมถึงตารางต่างๆ ว่าเป็นเพียงโค้ดดิบ (Raw text) และไม่ยอมเรนเดอร์ผลลัพธ์ให้

เพื่อแก้ไขปัญหานี้และเพื่อให้ไฟล์ `.md` ของคุณแสดงผลได้อย่างสมบูรณ์แบบในทุกโปรแกรม (เช่น VS Code หรือ Obsidian) ผมได้เอาบล็อกโค้ดที่ครอบอยู่ออกแล้วครับ นอกจากนี้ผมยังได้เปลี่ยนแท็ก HTML ให้เป็นข้อความ Markdown แบบมาตรฐาน โดยใช้ Emoji สีต่างๆ (🔵, 🟢, 🟠, 🔴) แทน ซึ่งจะตรงกับรูปแบบโปรเจกต์ที่คุณเคยใช้ในไฟล์ Midterm พอดีครับ

คุณสามารถคัดลอกข้อความด้านล่างนี้ (เริ่มตั้งแต่บรรทัด `# Final Exam Guideline`) ไปวางในไฟล์ `.md` ของคุณได้เลยครับ!

***

## Final Exam Guideline

### 📘 รายละเอียดเนื้อหาการสอบปลายภาค (Final Exam)

วิชา 31-407-101-105 / 31-407-102-201 การเขียนโปรแกรมเชิงวัตถุ (Object-Oriented Programming) 🎯 คะแนนเต็ม: 100 คะแนน | 🕒 เวลาสอบ: 3 ชั่วโมง

***

#### 📊 ตารางสรุปเนื้อหาและผลลัพธ์การเรียนรู้ (Course Learning Outcomes)

| หัวข้อหลัก (Topics)                                          | รายละเอียดสิ่งที่ต้องรู้ (Concepts to Review)                                                                                                                                                                                                                                                                                          | CLO ที่ประเมิน                     | รูปแบบข้อสอบ            | คะแนน |
| ------------------------------------------------------------ | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------- | ----------------------- | ----- |
| 1. ทฤษฎีและคอนเซปต์ OOP (Conceptual Understanding & Tracing) | <p>• Encapsulation, Class Anatomy, Access Modifiers</p><p><br></p><p>• Inheritance &#x26; Constructor Chaining (<code>super()</code>)</p><p><br></p><p>• Polymorphism &#x26; Dynamic Binding</p><p><br></p><p>• Abstraction &#x26; Interfaces</p><p><br></p><p>• การอ่าน UML (Association, Composition, Aggregation, Multiplicity)</p> | CLO2, CLO3, CLO4, CLO5             | ปรนัย (กากบาท) 40 ข้อ   | 40    |
| 2. การเติมคำสั่งลงในโค้ด (Fill in the Blanks)                | <p>• เลือกคำสั่ง Java (<code>extends</code>, <code>implements</code>, <code>super</code>, <code>@Override</code>, <code>abstract</code>) ไปเติมในช่องว่าง</p><p><br></p><p>• การประยุกต์ใช้ Inheritance และ Polymorphism กับสถานการณ์จริง</p>                                                                                          | CLO1, CLO4, CLO5                   | เติมคำในช่องว่าง 20 จุด | 20    |
| 3. การวิเคราะห์โค้ดกับเสาหลัก OOP (OOP Pillars Analysis)     | • วิเคราะห์โค้ดที่กำหนดให้ ว่าตรงกับหลักการใดใน 4 เสาหลัก (Encapsulation, Inheritance, Polymorphism, Abstraction) พร้อมอธิบายประโยชน์                                                                                                                                                                                                  | CLO2, CLO3, CLO4, CLO5             | เขียนตอบสั้น (5 ข้อ)    | 10    |
| 4. การเขียนโปรแกรมและอธิบายทฤษฎี (Coding & Explanation)      | <p>• แปลง UML Class Diagram ให้เป็นโค้ด Java</p><p><br></p><p>• สืบทอดคลาส (Inheritance) และเขียนทับเมธอด (Method Overriding)</p><p><br></p><p>• อธิบายความหมายและเขียนตัวอย่างโค้ดเรื่อง Polymorphism</p>                                                                                                                             | CLO1, CLO3, CLO4, CLO5, CLO6, CLO7 | เขียนโปรแกรมและอธิบาย   | 30    |
| รวม                                                          |                                                                                                                                                                                                                                                                                                                                        |                                    |                         | 100   |



{% hint style="info" %}
ข้อสอบมีการวิเคราะห์โค้ดจำนวนมาก ให้นักศึกษาเน้นทำความเข้าใจการทำงานของโปรแกรม (Code Tracing) และความสัมพันธ์ระหว่างคลาส มากกว่าการท่องจำไวยากรณ์&#x20;
{% endhint %}
