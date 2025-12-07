/**
 * ClassDiagramExample.java
 * ตัวอย่างการแปลง Class Diagram เป็น Java Code
 * 
 * ระบบร้านค้าออนไลน์อย่างง่าย (Simple Online Shop System)
 * 
 * Class Diagram:
 * 
 *            ┌──────────────┐
 *            │    Person    │
 *            ├──────────────┤
 *            │ - name       │
 *            │ - email      │
 *            ├──────────────┤
 *            │ + getName()  │
 *            │ + setName()  │
 *            └──────┬───────┘
 *                   △
 *                   │ (Inheritance)
 *        ┌──────────┴──────────┐
 *        │                     │
 * ┌──────┴─────┐       ┌──────┴─────┐
 * │  Customer  │       │   Admin    │
 * ├────────────┤       ├────────────┤
 * │ - address  │       │ - role     │
 * ├────────────┤       ├────────────┤
 * │ + order()  │       │ + manage() │
 * └──────┬─────┘       └────────────┘
 *        │
 *        │ 1
 *        │ places *
 *        │
 * ┌──────┴──────────┐
 * │     Order       │
 * ├─────────────────┤
 * │ - orderId       │
 * │ - orderDate     │
 * │ - totalAmount   │
 * ├─────────────────┤
 * │ + addItem()     │
 * │ + calculateTotal│
 * └────────┬────────┘
 *          │
 *          │ 1 contains *
 *          │
 *   ┌──────┴────────┐
 *   │   OrderItem   │
 *   ├───────────────┤
 *   │ - quantity    │
 *   │ - price       │
 *   ├───────────────┤
 *   │ + getSubtotal │
 *   └───────┬───────┘
 *           │
 *           │ * references 1
 *           │
 *    ┌──────┴───────┐
 *    │   Product    │
 *    ├──────────────┤
 *    │ - productId  │
 *    │ - name       │
 *    │ - price      │
 *    │ - stock      │
 *    ├──────────────┤
 *    │ + getInfo()  │
 *    │ + updateStock│
 *    └──────────────┘
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

// ============================================
// Superclass: Person (Inheritance)
// ============================================

abstract class Person {
    protected String name;
    protected String email;
    
    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public abstract void displayInfo();
}

// ============================================
// Subclass: Customer (Inheritance from Person)
// ============================================

class Customer extends Person {
    private String address;
    private List<Order> orders;
    
    public Customer(String name, String email, String address) {
        super(name, email);
        this.address = address;
        this.orders = new ArrayList<>();
    }
    
    // Association: Customer สร้าง Order (1 to many)
    public Order placeOrder() {
        Order order = new Order("ORD" + System.currentTimeMillis(), this);
        orders.add(order);
        System.out.println("✓ " + name + " สร้าง Order ID: " + order.getOrderId());
        return order;
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n┌─────────────────────────────┐");
        System.out.println("│   ข้อมูลลูกค้า              │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│ ชื่อ: " + name);
        System.out.println("│ อีเมล: " + email);
        System.out.println("│ ที่อยู่: " + address);
        System.out.println("│ จำนวน Orders: " + orders.size());
        System.out.println("└─────────────────────────────┘");
    }
    
    public List<Order> getOrders() {
        return orders;
    }
}

// ============================================
// Subclass: Admin (Inheritance from Person)
// ============================================

class Admin extends Person {
    private String role;
    
    public Admin(String name, String email, String role) {
        super(name, email);
        this.role = role;
    }
    
    public void manageProducts(Product product, int newStock) {
        System.out.println("🔧 Admin " + name + " กำลังจัดการสินค้า");
        product.updateStock(newStock);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("\n┌─────────────────────────────┐");
        System.out.println("│   ข้อมูลผู้ดูแลระบบ         │");
        System.out.println("├─────────────────────────────┤");
        System.out.println("│ ชื่อ: " + name);
        System.out.println("│ อีเมล: " + email);
        System.out.println("│ บทบาท: " + role);
        System.out.println("└─────────────────────────────┘");
    }
}

// ============================================
// Class: Product
// ============================================

class Product {
    private String productId;
    private String name;
    private double price;
    private int stock;
    
    public Product(String productId, String name, double price, int stock) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getStock() {
        return stock;
    }
    
    public void updateStock(int newStock) {
        this.stock = newStock;
        System.out.println("  → สต็อก " + name + " อัพเดทเป็น: " + stock);
    }
    
    public boolean reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
            return true;
        }
        return false;
    }
    
    public void displayInfo() {
        System.out.println("  [" + productId + "] " + name + 
                         " - ราคา: " + price + " บาท (สต็อก: " + stock + ")");
    }
}

// ============================================
// Class: OrderItem (Composition - ส่วนหนึ่งของ Order)
// ============================================

class OrderItem {
    private Product product;  // Association: OrderItem references Product
    private int quantity;
    private double price;
    
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.price = product.getPrice();
    }
    
    public double getSubtotal() {
        return price * quantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void displayInfo() {
        System.out.println("  - " + product.getName() + 
                         " x " + quantity + 
                         " = " + getSubtotal() + " บาท");
    }
}

// ============================================
// Class: Order (Composition relationship with OrderItem)
// ============================================

class Order {
    private String orderId;
    private Date orderDate;
    private Customer customer;
    private List<OrderItem> items;  // Composition: Order contains OrderItems
    private double totalAmount;
    
    public Order(String orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
        this.orderDate = new Date();
        this.items = new ArrayList<>();
        this.totalAmount = 0;
    }
    
    // Composition: สร้าง OrderItem ภายใน Order
    public void addItem(Product product, int quantity) {
        if (product.reduceStock(quantity)) {
            OrderItem item = new OrderItem(product, quantity);
            items.add(item);
            calculateTotal();
            System.out.println("  ✓ เพิ่มสินค้า: " + product.getName() + " x " + quantity);
        } else {
            System.out.println("  ✗ สต็อกไม่พอ: " + product.getName());
        }
    }
    
    public void calculateTotal() {
        totalAmount = 0;
        for (OrderItem item : items) {
            totalAmount += item.getSubtotal();
        }
    }
    
    public String getOrderId() {
        return orderId;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
    
    public void displayOrderSummary() {
        System.out.println("\n╔═══════════════════════════════════════╗");
        System.out.println("║         สรุปคำสั่งซื้อ                ║");
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ Order ID: " + orderId);
        System.out.println("║ ลูกค้า: " + customer.getName());
        System.out.println("║ วันที่: " + orderDate);
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ รายการสินค้า:");
        
        for (OrderItem item : items) {
            item.displayInfo();
        }
        
        System.out.println("╠═══════════════════════════════════════╣");
        System.out.println("║ ยอดรวมทั้งหมด: " + totalAmount + " บาท");
        System.out.println("╚═══════════════════════════════════════╝");
    }
}

// ============================================
// Main Class
// ============================================

public class ClassDiagramExample {
    public static void main(String[] args) {
        System.out.println("═══════════════════════════════════════════════════");
        System.out.println("  ตัวอย่างระบบร้านค้าออนไลน์ (Class Diagram)");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        // สร้าง Products
        System.out.println(">>> สร้างสินค้า");
        Product laptop = new Product("P001", "Laptop Dell", 25000, 10);
        Product mouse = new Product("P002", "Wireless Mouse", 500, 50);
        Product keyboard = new Product("P003", "Mechanical Keyboard", 2000, 30);
        Product monitor = new Product("P004", "Monitor 24\"", 5000, 20);
        
        System.out.println("สินค้าทั้งหมด:");
        laptop.displayInfo();
        mouse.displayInfo();
        keyboard.displayInfo();
        monitor.displayInfo();
        
        // สร้าง Customers
        System.out.println("\n>>> สร้างลูกค้า");
        Customer customer1 = new Customer("สมชาย ใจดี", "somchai@email.com", "123 ถ.สุขุมวิท กรุงเทพฯ");
        Customer customer2 = new Customer("สมหญิง รักเรียน", "somying@email.com", "456 ถ.พระราม 9 กรุงเทพฯ");
        
        customer1.displayInfo();
        customer2.displayInfo();
        
        // สร้าง Admin
        System.out.println("\n>>> สร้างผู้ดูแลระบบ");
        Admin admin = new Admin("ผู้จัดการ ระบบ", "admin@shop.com", "Super Admin");
        admin.displayInfo();
        
        // Customer 1 สั่งซื้อสินค้า
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  ลูกค้า 1 สั่งซื้อสินค้า");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        Order order1 = customer1.placeOrder();
        order1.addItem(laptop, 1);
        order1.addItem(mouse, 2);
        order1.addItem(keyboard, 1);
        
        order1.displayOrderSummary();
        
        // Customer 2 สั่งซื้อสินค้า
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  ลูกค้า 2 สั่งซื้อสินค้า");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        Order order2 = customer2.placeOrder();
        order2.addItem(monitor, 2);
        order2.addItem(mouse, 3);
        order2.addItem(keyboard, 2);
        
        order2.displayOrderSummary();
        
        // Admin จัดการสต็อก
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  Admin จัดการสต็อกสินค้า");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        admin.manageProducts(laptop, 15);
        admin.manageProducts(mouse, 100);
        
        // แสดงสต็อกปัจจุบัน
        System.out.println("\n>>> สต็อกสินค้าปัจจุบัน:");
        laptop.displayInfo();
        mouse.displayInfo();
        keyboard.displayInfo();
        monitor.displayInfo();
        
        // สรุปความสัมพันธ์
        System.out.println("\n═══════════════════════════════════════════════════");
        System.out.println("  สรุปความสัมพันธ์ใน Class Diagram");
        System.out.println("═══════════════════════════════════════════════════\n");
        
        System.out.println("✓ Inheritance (การสืบทอด):");
        System.out.println("  - Customer extends Person");
        System.out.println("  - Admin extends Person\n");
        
        System.out.println("✓ Association (ความสัมพันธ์):");
        System.out.println("  - Customer มี Order (1 to many)");
        System.out.println("  - Order มี Customer (many to 1)");
        System.out.println("  - OrderItem อ้างอิง Product\n");
        
        System.out.println("✓ Composition (ส่วนประกอบ):");
        System.out.println("  - Order ประกอบด้วย OrderItems");
        System.out.println("  - ถ้า Order ถูกลบ OrderItems ก็ถูกลบด้วย\n");
        
        System.out.println("✓ Multiplicity (จำนวนความสัมพันธ์):");
        System.out.println("  - 1 Customer : many Orders");
        System.out.println("  - 1 Order : many OrderItems");
        System.out.println("  - many OrderItems : 1 Product\n");
    }
}
