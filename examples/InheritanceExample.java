/**
 * InheritanceExample.java
 * ตัวอย่างการใช้งาน Inheritance (การสืบทอด)
 * 
 * ตัวอย่างนี้แสดงให้เห็นถึง:
 * - การสร้าง Superclass และ Subclasses
 * - การสืบทอด Attributes และ Methods
 * - การเพิ่ม Members ใหม่ใน Subclass
 * - การใช้ super keyword
 * - ประโยชน์ของ Code Reusability
 */

// Superclass: Employee (พนักงาน)
class Employee {
    // Protected Attributes - เข้าถึงได้จาก Subclass
    protected String employeeId;
    protected String name;
    protected String department;
    protected double baseSalary;
    
    // Constructor
    public Employee(String employeeId, String name, String department, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.baseSalary = baseSalary;
        System.out.println("✓ สร้าง Employee: " + name);
    }
    
    // Method: คำนวณเงินเดือน (Method พื้นฐาน)
    public double calculateSalary() {
        return baseSalary;
    }
    
    // Method: แสดงข้อมูลพนักงาน
    public void displayInfo() {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│ รหัสพนักงาน: " + employeeId);
        System.out.println("│ ชื่อ: " + name);
        System.out.println("│ แผนก: " + department);
        System.out.println("│ เงินเดือนพื้นฐาน: " + baseSalary + " บาท");
    }
    
    // Method: ทำงาน
    public void work() {
        System.out.println(name + " กำลังทำงาน...");
    }
    
    // Method: พักเที่ยง
    public void takeBreak() {
        System.out.println(name + " พักเที่ยง");
    }
}

// Subclass 1: Manager (ผู้จัดการ)
class Manager extends Employee {
    // Attributes เพิ่มเติม
    private double managementBonus;
    private int teamSize;
    
    // Constructor
    public Manager(String employeeId, String name, String department, 
                   double baseSalary, double managementBonus, int teamSize) {
        // เรียก Constructor ของ Superclass
        super(employeeId, name, department, baseSalary);
        this.managementBonus = managementBonus;
        this.teamSize = teamSize;
        System.out.println("  → เป็นตำแหน่ง Manager");
    }
    
    // Override Method: คำนวณเงินเดือน (เพิ่มโบนัสผู้จัดการ)
    @Override
    public double calculateSalary() {
        return baseSalary + managementBonus;
    }
    
    // Override Method: แสดงข้อมูล (เพิ่มข้อมูลของ Manager)
    @Override
    public void displayInfo() {
        super.displayInfo();  // เรียกแสดงข้อมูลพื้นฐานจาก Superclass
        System.out.println("│ ตำแหน่ง: Manager");
        System.out.println("│ โบนัสผู้จัดการ: " + managementBonus + " บาท");
        System.out.println("│ จำนวนทีม: " + teamSize + " คน");
        System.out.println("│ เงินเดือนรวม: " + calculateSalary() + " บาท");
        System.out.println("└─────────────────────────────────────┘");
    }
    
    // Method เพิ่มเติม: จัดประชุม
    public void conductMeeting() {
        System.out.println(name + " กำลังจัดประชุมทีม (" + teamSize + " คน)");
    }
    
    // Method เพิ่มเติม: ประเมินพนักงาน
    public void evaluateEmployee(String employeeName) {
        System.out.println(name + " กำลังประเมินผลงานของ " + employeeName);
    }
}

// Subclass 2: Programmer (โปรแกรมเมอร์)
class Programmer extends Employee {
    // Attributes เพิ่มเติม
    private String programmingLanguage;
    private int projectCount;
    private double projectBonus;
    
    // Constructor
    public Programmer(String employeeId, String name, String department,
                     double baseSalary, String programmingLanguage) {
        super(employeeId, name, department, baseSalary);
        this.programmingLanguage = programmingLanguage;
        this.projectCount = 0;
        this.projectBonus = 0;
        System.out.println("  → เป็นตำแหน่ง Programmer (" + programmingLanguage + ")");
    }
    
    // Override Method: คำนวณเงินเดือน (เพิ่มโบนัสโปรเจกต์)
    @Override
    public double calculateSalary() {
        return baseSalary + projectBonus;
    }
    
    // Override Method: แสดงข้อมูล
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("│ ตำแหน่ง: Programmer");
        System.out.println("│ ภาษาโปรแกรม: " + programmingLanguage);
        System.out.println("│ จำนวนโปรเจกต์: " + projectCount);
        System.out.println("│ โบนัสโปรเจกต์: " + projectBonus + " บาท");
        System.out.println("│ เงินเดือนรวม: " + calculateSalary() + " บาท");
        System.out.println("└─────────────────────────────────────┘");
    }
    
    // Method เพิ่มเติม: เขียนโค้ด
    public void writeCode() {
        System.out.println(name + " กำลังเขียนโค้ด " + programmingLanguage);
    }
    
    // Method เพิ่มเติม: ทำโปรเจกต์เสร็จ
    public void completeProject(double bonus) {
        projectCount++;
        projectBonus += bonus;
        System.out.println(name + " ทำโปรเจกต์เสร็จ! ได้โบนัส " + bonus + " บาท");
        System.out.println("  → โปรเจกต์ทั้งหมด: " + projectCount + ", โบนัสรวม: " + projectBonus + " บาท");
    }
    
    // Method เพิ่มเติม: Debug
    public void debugCode() {
        System.out.println(name + " กำลัง Debug โค้ด");
    }
}

// Subclass 3: Designer (นักออกแบบ)
class Designer extends Employee {
    // Attributes เพิ่มเติม
    private String designTool;
    private int designCount;
    
    // Constructor
    public Designer(String employeeId, String name, String department,
                   double baseSalary, String designTool) {
        super(employeeId, name, department, baseSalary);
        this.designTool = designTool;
        this.designCount = 0;
        System.out.println("  → เป็นตำแหน่ง Designer (" + designTool + ")");
    }
    
    // Override Method: แสดงข้อมูล
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("│ ตำแหน่ง: Designer");
        System.out.println("│ เครื่องมือออกแบบ: " + designTool);
        System.out.println("│ จำนวนงานออกแบบ: " + designCount);
        System.out.println("│ เงินเดือนรวม: " + calculateSalary() + " บาท");
        System.out.println("└─────────────────────────────────────┘");
    }
    
    // Method เพิ่มเติม: ออกแบบ
    public void createDesign(String designType) {
        designCount++;
        System.out.println(name + " กำลังออกแบบ " + designType + " ด้วย " + designTool);
        System.out.println("  → งานออกแบบทั้งหมด: " + designCount);
    }
    
    // Method เพิ่มเติม: นำเสนอออกแบบ
    public void presentDesign() {
        System.out.println(name + " กำลังนำเสนอผลงานออกแบบ");
    }
}

// Main Class
public class InheritanceExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Inheritance ในภาษา Java");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // สร้าง Manager
        System.out.println(">>> สร้างพนักงานตำแหน่ง Manager");
        Manager manager = new Manager(
            "M001", "สมชาย ใจดี", "IT Management",
            50000, 15000, 10
        );
        
        // สร้าง Programmers
        System.out.println("\n>>> สร้างพนักงานตำแหน่ง Programmer");
        Programmer prog1 = new Programmer(
            "P001", "สมหญิง รักเรียน", "Software Development",
            35000, "Java"
        );
        
        Programmer prog2 = new Programmer(
            "P002", "สมศรี ขยัน", "Software Development",
            38000, "Python"
        );
        
        // สร้าง Designer
        System.out.println("\n>>> สร้างพนักงานตำแหน่ง Designer");
        Designer designer = new Designer(
            "D001", "สมหมาย สร้างสรรค์", "Design",
            32000, "Adobe Photoshop"
        );
        
        // แสดงข้อมูลพนักงานทั้งหมด
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        ข้อมูลพนักงาน");
        System.out.println("═══════════════════════════════════════════════════");
        
        manager.displayInfo();
        prog1.displayInfo();
        prog2.displayInfo();
        designer.displayInfo();
        
        // ทดสอบ Methods ที่สืบทอดมา
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การทำงาน (Methods ที่สืบทอดมา)");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        manager.work();
        prog1.work();
        designer.work();
        System.out.println();
        manager.takeBreak();
        prog1.takeBreak();
        designer.takeBreak();
        
        // ทดสอบ Methods เฉพาะของแต่ละ Subclass
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        การทำงานเฉพาะตำแหน่ง");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        manager.conductMeeting();
        manager.evaluateEmployee("สมหญิง");
        System.out.println();
        
        prog1.writeCode();
        prog1.completeProject(5000);
        prog1.debugCode();
        System.out.println();
        
        prog2.writeCode();
        prog2.completeProject(6000);
        prog2.completeProject(4500);
        System.out.println();
        
        designer.createDesign("Logo");
        designer.createDesign("UI/UX");
        designer.presentDesign();
        
        // แสดงข้อมูลหลังทำงาน
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        ข้อมูลพนักงานหลังทำงาน");
        System.out.println("═══════════════════════════════════════════════════");
        
        prog1.displayInfo();
        prog2.displayInfo();
        designer.displayInfo();
        
        // สรุป
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("        สรุปประโยชน์ของ Inheritance");
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("\n✓ Code Reusability: ไม่ต้องเขียน employeeId, name, etc. ซ้ำในทุก Class");
        System.out.println("✓ Extensibility: เพิ่มตำแหน่งงานใหม่ได้ง่าย โดยสืบทอดจาก Employee");
        System.out.println("✓ Maintainability: แก้ไข Employee ที่เดียว ส่งผลไปยัง Subclass ทั้งหมด");
        System.out.println("✓ Polymorphism: สามารถใช้ Employee reference กับ Object ทุกประเภทได้");
        System.out.println("✓ Logical Hierarchy: สร้างโครงสร้างที่เข้าใจง่ายและสอดคล้องกับโลกจริง\n");
    }
}
