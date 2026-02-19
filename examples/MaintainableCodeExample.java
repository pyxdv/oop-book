/**
 * MaintainableCodeExample.java
 * ตัวอย่าง Maintainable Code Principles (CLO7)
 * 
 * แสดงหลักการ Clean Code:
 * - Meaningful names
 * - Single responsibility functions
 * - Avoiding deep nesting
 * - Proper code organization
 */

public class MaintainableCodeExample {
    
    // Constants - ชัดเจน searchable
    private static final double TAX_RATE = 0.07;
    private static final int DISCOUNT_THRESHOLD = 1000;
    private static final double DISCOUNT_RATE = 0.10;
    
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("     ตัวอย่าง Maintainable Code (CLO7)");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // Example: ระบบคำนวณราคา
        double basePrice = 1500.0;
        
        System.out.println(">>> การคำนวณราคา (Maintainable Code)");
        double finalPrice = calculateFinalPrice(basePrice);
        displayPriceSummary(basePrice, finalPrice);
        
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("✓ ใช้ชื่อที่สื่อความหมาย (meaningful names)");
        System.out.println("✓ Functions ทำสิ่งเดียว (single responsibility)");
        System.out.println("✓ ใช้ Constants แทน Magic numbers");
        System.out.println("✓ Code organization ที่ชัดเจน");
        System.out.println("✓ รองรับ CLO7: Develop clean, maintainable software\n");
    }
    
    /**
     * คำนวณราคาสุดท้ายรวม Tax และ Discount
     * 
     * @param basePrice ราคาฐาน
     * @return ราคาสุดท้าย
     */
    public static double calculateFinalPrice(double basePrice) {
        double priceAfterDiscount = applyDiscount(basePrice);
        double priceWithTax = addTax(priceAfterDiscount);
        return priceWithTax;
    }
    
    /**
     * ใช้ส่วนลดถ้าราคาเกินเกณฑ์
     */
    private static double applyDiscount(double price) {
        if (isEligibleForDiscount(price)) {
            double discount = price * DISCOUNT_RATE;
            return price - discount;
        }
        return price;
    }
    
    /**
     * ตรวจสอบว่าได้รับส่วนลดหรือไม่
     */
    private static boolean isEligibleForDiscount(double price) {
        return price >= DISCOUNT_THRESHOLD;
    }
    
    /**
     * คำนวณภาษี
     */
    private static double addTax(double price) {
        return price * (1 + TAX_RATE);
    }
    
    /**
     * แสดงสรุปราคา
     */
    private static void displayPriceSummary(double basePrice, double finalPrice) {
        System.out.println("\n┌─────────────────────────────────────┐");
        System.out.println("│        สรุปราคา                     │");
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf("│ ราคาฐาน:        %10.2f บาท │\n", basePrice);
        
        if (isEligibleForDiscount(basePrice)) {
            double discount = basePrice * DISCOUNT_RATE;
            System.out.printf("│ ส่วนลด (10%%):   -%9.2f บาท │\n", discount);
            System.out.printf("│ หลังส่วนลด:     %10.2f บาท │\n", basePrice - discount);
        }
        
        double priceAfterDiscount = applyDiscount(basePrice);
        double tax = priceAfterDiscount * TAX_RATE;
        System.out.printf("│ ภาษี (7%%):      +%9.2f บาท │\n", tax);
        System.out.println("├─────────────────────────────────────┤");
        System.out.printf("│ ราคาสุดท้าย:    %10.2f บาท │\n", finalPrice);
        System.out.println("└─────────────────────────────────────┘");
    }
}

/* 
 * CLEAN CODE PRINCIPLES ที่ใช้ในตัวอย่างนี้:
 * 
 * 1. Meaningful Names:
 *    - calculateFinalPrice() แทน calc()
 *    - isEligibleForDiscount() แทน check()
 *    - TAX_RATE แทน 0.07
 * 
 * 2. Single Responsibility:
 *    - applyDiscount() ทำแค่ส่วนลด
 *    - addTax() ทำแค่ภาษี
 *    - displayPriceSummary() ทำแค่แสดงผล
 * 
 * 3. Avoid Magic Numbers:
 *    - ใช้ constants (TAX_RATE, DISCOUNT_RATE)
 * 
 * 4. Small Functions:
 *    - แต่ละ function สั้น ทำสิ่งเดียว
 * 
 * 5. Good Comments:
 *    - Javadoc อธิบาย purpose
 *    - ไม่มี redundant comments
 */
