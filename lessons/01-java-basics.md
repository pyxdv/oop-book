1| # บทที่ 1: Program Structure และ Basic Syntax
2| 
3| ## Learning Outcomes (ผลลัพธ์การเรียนรู้)
4| 
5| หลังจากเรียนจบบทนี้ นักเรียนจะสามารถ:
6| 1. เข้าใจโครงสร้างพื้นฐานของโปรแกรม Java ได้
7| 2. ประกาศและใช้งาน Variables และ Data Types ต่างๆ ได้
8| 3. รับ Input จากผู้ใช้และแสดง Output ได้
9| 4. ใช้ Operators ต่างๆ (Arithmetic, Relational, Logical) ได้อย่างถูกต้อง
10| 5. เขียนโปรแกรม Java พื้นฐานที่ Compile และ Run ได้ **(CLO1)**
11| 
12| ## 1. โครงสร้างโปรแกรม Java
13| 
14| ### 1.1 โปรแกรม Java พื้นฐาน
15| 
16| ```java
17| public class HelloWorld {
18|     public static void main(String[] args) {
19|         System.out.println("Hello, World!");
20|     }
21| }
22| ```
23| 
24| **องค์ประกอบ:**
25| - `public class HelloWorld` - ชื่อ Class (ต้องตรงกับชื่อไฟล์)
26| - `public static void main(String[] args)` - Method หลักที่โปรแกรมเริ่มทำงาน
27| - `System.out.println()` - แสดงผลบนหน้าจอ
28| 
29| ### 1.2 Comments (คำอธิบาย)
30| 
31| ```java
32| // Single-line comment (คอมเมนต์บรรทัดเดียว)
33| 
34| /*
35|  * Multi-line comment
36|  * (คอมเมนต์หลายบรรทัด)
37|  */
38| 
39| /** 
40|  * Documentation comment
41|  * ใช้สำหรับสร้างเอกสาร
42|  */
43| ```
44| 
45| ## 2. Variables และ Data Types
46| 
47| ### 2.1 Primitive Data Types
48| 
49| ```java
50| // Integer Types
51| byte age = 25;           // -128 to 127
52| short year = 2024;       // -32,768 to 32,767
53| int population = 70000000;  // -2,147,483,648 to 2,147,483,647
54| long distance = 9876543210L;  // ต้องใส่ L ท้าย
55| 
56| // Floating-Point Types
57| float price = 99.99f;    // ต้องใส่ f ท้าย
58| double pi = 3.14159265359;
59| 
60| // Character Type
61| char grade = 'A';
62| char symbol = '@';
63| 
64| // Boolean Type
65| boolean isStudent = true;
66| boolean hasLicense = false;
67| ```
68| 
69| ### 2.2 Reference Types
70| 
71| ```java
72| String name = "สมชาย";
73| String message = "Hello, World!";
74| ```
75| 
76| ### 2.3 การประกาศ Variables
77| 
78| ```java
79| // ประกาศ
80| int score;
81| 
82| // ประกาศและกำหนดค่า
83| int score = 95;
84| 
85| // ประกาศหลายตัวแปร
86| int x = 10, y = 20, z = 30;
87| 
88| // ค่าคงที่ (Constants)
89| final double PI = 3.14159;
90| final int MAX_STUDENTS = 50;
91| ```
92| 
93| ### 2.4 Naming Conventions
94| 
95| **ดี:**
96| ```java
97| int studentAge;
98| String firstName;
99| double totalPrice;
100| ```
101| 
102| **ไม่ดี:**
103| ```java
104| int a;        // ชื่อไม่สื่อความหมาย
105| String N;     // ควรเป็นตัวเล็ก
106| double x1;    // ชื่อไม่ชัดเจน
107| ```
108| 
109| ## 3. Input และ Output
110| 
111| ### 3.1 Output (แสดงผล)
112| 
113| ```java
114| // println - แสดงแล้วขึ้นบรรทัดใหม่
115| System.out.println("Hello");
116| System.out.println("World");
117| 
118| // print - แสดงต่อกันบรรทัดเดียว
119| System.out.print("Hello ");
120| System.out.print("World");
121| 
122| // printf - จัดรูปแบบ
123| int age = 25;
124| double gpa = 3.75;
125| System.out.printf("Age: %d, GPA: %.2f\n", age, gpa);
126| ```
127| 
128| ### 3.2 Input (รับค่า)
129| 
130| ```java
131| import java.util.Scanner;
132| 
133| public class InputExample {
134|     public static void main(String[] args) {
135|         Scanner scanner = new Scanner(System.in);
136|         
137|         // อ่านข้อความ
138|         System.out.print("Enter your name: ");
139|         String name = scanner.nextLine();
140|         
141|         // อ่านตัวเลข
142|         System.out.print("Enter your age: ");
143|         int age = scanner.nextInt();
144|         
145|         // อ่านทศนิยม
146|         System.out.print("Enter your GPA: ");
147|         double gpa = scanner.nextDouble();
148|         
149|         System.out.println("Name: " + name);
150|         System.out.println("Age: " + age);
151|         System.out.println("GPA: " + gpa);
152|         
153|         scanner.close();
154|     }
155| }
156| ```
157| 
158| ## 4. Operators (ตัวดำเนินการ)
159| 
160| ### 4.1 Arithmetic Operators (ตัวดำเนินการทางคณิตศาสตร์)
161| 
162| ```java
163| int a = 10, b = 3;
164| 
165| System.out.println(a + b);  // 13 (บวก)
166| System.out.println(a - b);  // 7  (ลบ)
167| System.out.println(a * b);  // 30 (คูณ)
168| System.out.println(a / b);  // 3  (หาร - integer division)
169| System.out.println(a % b);  // 1  (เศษจากการหาร - modulo)
170| 
171| // Increment และ Decrement
172| int x = 5;
173| x++;  // x = x + 1  → 6
174| x--;  // x = x - 1  → 5
175| ```
176| 
177| ### 4.2 Relational Operators (ตัวดำเนินการเปรียบเทียบ)
178| 
179| ```java
180| int x = 5, y = 10;
181| 
182| System.out.println(x == y);  // false (เท่ากับ)
183| System.out.println(x != y);  // true  (ไม่เท่ากับ)
184| System.out.println(x > y);   // false (มากกว่า)
185| System.out.println(x < y);   // true  (น้อยกว่า)
186| System.out.println(x >= y);  // false (มากกว่าหรือเท่ากับ)
187| System.out.println(x <= y);  // true  (น้อยกว่าหรือเท่ากับ)
188| ```
189| 
190| ### 4.3 Logical Operators (ตัวดำเนินการทางตรรกะ)
191| 
192| ```java
193| boolean a = true, b = false;
194| 
195| System.out.println(a && b);  // false (AND - ทั้งสองเป็น true)
196| System.out.println(a || b);  // true  (OR - อย่างน้อยหนึ่งเป็น true)
197| System.out.println(!a);      // false (NOT - กลับค่า)
198| 
199| // ตัวอย่างการใช้งาน
200| int age = 20;
201| boolean isStudent = true;
202| 
203| if (age >= 18 && isStudent) {
204|     System.out.println("Adult student");
205| }
206| ```
207| 
208| ### 4.4 Assignment Operators (ตัวดำเนินการกำหนดค่า)
209| 
210| ```java
211| int x = 10;
212| 
213| x += 5;  // x = x + 5  → 15
214| x -= 3;  // x = x - 3  → 12
215| x *= 2;  // x = x * 2  → 24
216| x /= 4;  // x = x / 4  → 6
217| x %= 4;  // x = x % 4  → 2
218| ```
219| 
220| ### 4.5 Operator Precedence (ลำดับความสำคัญ)
221| 
222| ```java
223| int result = 10 + 5 * 2;  // 20 (คูณก่อน แล้วบวก)
224| int result2 = (10 + 5) * 2;  // 30 (วงเล็บมีความสำคัญสูงสุด)
225| 
226| // ลำดับ (สูง → ต่ำ):
227| // 1. ()
228| // 2. *, /, %
229| // 3. +, -
230| // 4. <, >, <=, >=
231| // 5. ==, !=
232| // 6. &&
233| // 7. ||
234| // 8. =, +=, -=, etc.
235| ```
236| 
237| ## 5. Type Conversion (การแปลงชนิดข้อมูล)
238| 
239| ### 5.1 Implicit Conversion (แปลงอัตโนมัติ)
240| 
241| ```java
242| int i = 100;
243| double d = i;  // int → double (ไม่สูญเสียข้อมูล)
244| System.out.println(d);  // 100.0
245| ```
246| 
247| ### 5.2 Explicit Conversion (Casting - แปลงโดยระบุ)
248| 
249| ```java
250| double d = 9.7;
251| int i = (int) d;  // 9 (ตัดทศนิยมทิ้ง)
252| 
253| int x = 5;
254| int y = 2;
255| double result = (double) x / y;  // 2.5
256| ```
257| 
258| ### 5.3 String Conversion
259| 
260| ```java
261| // ตัวเลข → String
262| int age = 25;
263| String ageStr = String.valueOf(age);
264| String ageStr2 = "" + age;  // ใช้ + กับ String
265| 
266| // String → ตัวเลข
267| String numStr = "123";
268| int num = Integer.parseInt(numStr);
269| double d = Double.parseDouble("3.14");
270| ```
271| 
272| ## 6. ตัวอย่างโปรแกรมสมบูรณ์
273| 
274| ดูตัวอย่าง: [JavaBasicsExample.java](../examples/JavaBasicsExample.java)
275| 
276| โปรแกรมนี้แสดงการใช้งาน:
277| - Variables และ Data Types
278| - Input/Output
279| - Operators ทุกประเภท
280| - Type Conversion
281| 
282| ## สรุป
283| 
284| - **Program Structure**: `public class` + `main method`
285| - **Variables**: ประกาศด้วย `type name = value;`
286| - **Data Types**: Primitive (int, double, boolean, char) และ Reference (String)
287| - **Input**: ใช้ `Scanner` class
288| - **Output**: ใช้ `System.out.println()`, `print()`, `printf()`
289| - **Operators**: Arithmetic (+, -, *, /, %), Relational (==, !=, <, >), Logical (&&, ||, !)
290| - **Type Conversion**: Implicit (อัตโนมัติ) และ Explicit (casting)
291| 
292| ## แบบฝึกหัด
293| 
294| 1. เขียนโปรแกรมรับชื่อและอายุจากผู้ใช้ แล้วแสดงผล
295| 2. เขียนโปรแกรมคำนวณพื้นที่วงกลม (π × r²) โดยรับค่ารัศมีจากผู้ใช้
296| 3. เขียนโปรแกรมรับตัวเลข 2 ตัว และแสดงผลการคำนวณ +, -, *, /, %
297| 4. เขียนโปรแกรมแปลงอุณหภูมิจาก Celsius เป็น Fahrenheit (F = C × 9/5 + 32)
298| 
299| ---
300| 
301| [กลับไปหน้าหลัก](../README.md) | [บทถัดไป: Control Flow และ Loops >](02-control-flow.md)