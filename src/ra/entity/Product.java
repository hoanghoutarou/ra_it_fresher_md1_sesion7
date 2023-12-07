package ra.entity;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Product {
    private String productid, productName, descriptions;
    private Float importPrice, exportPrice, profit;
    private int quantity;
    private Boolean status;
    Boolean isExit = true;

    public Product() {
    }

    public Product(String productid, String productName, String descriptions, Float importPrice, Float exportPrice, Float profit, int quantity, Boolean status) {
        this.productid = productid;
        this.productName = productName;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.profit = profit;
        this.quantity = quantity;
        this.status = status;
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(Float importPrice) {
        this.importPrice = importPrice;
    }

    public Float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(Float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void inputData(Scanner sc, Product[] arrProduct, int index) {
        do {
            System.out.println("Nhập mã san pham:");
            this.productid = sc.nextLine();
            Pattern p = Pattern.compile("P([//w]|[//d]){4}");

            boolean isExit = false;
            for (int i = 0; i < index; i++) {
                if (this.productid.equals(arrProduct[i].getProductid())) {
                    isExit = true;
                    System.out.println("Mã sách bị trùng!");
                    break;
                }
            }
            if (!isExit) {
                break;
            }
        } while (!isExit);
        do {
            System.out.println("Nhập ten san pham:");
            this.productName = sc.nextLine();
            if (this.productid.length() < 4 || this.productid.length() > 4) {
                System.out.println("Ma san pham chi co 4 ki tu vui long nhap lai");
            } else {
                if (this.productid.charAt(0) != 'P') {
                    System.out.println("Mã sản phẩm phải bắt đầu bằng ký tự 'B' !");
                } else {
                    boolean isExit = false;
                    for (int i = 0; i < index; i++) {
                        if (this.productid.equals(arrProduct[i].getProductid())) {
                            isExit = true;
                            System.out.println("Mã sách bị trùng!");
                            break;
                        }
                    }
                    if (!isExit) {
                        break;
                    }
                }
            }
        }while (!isExit);
        boolean validImportPrice = false;
        while (!validImportPrice){
            System.out.println("Nhập giá nhập sản phẩm: ");
            this.importPrice = Float.parseFloat(sc.nextLine());
            if (this.importPrice > 0) {
                validImportPrice = true;
            }else {
                System.out.println("Vui lòng nhập lại.");
            }
        }



        boolean validExportPrice = false;
        while (!validExportPrice) {
            System.out.println("Nhập giá xuất (giá xuất phải lớn hơn giá nhập và tăng ít nhất 20% so với giá nhập): ");
            this.exportPrice = sc.nextFloat();

            // Kiểm tra điều kiện lợi nhuận ít nhất 20%
            if (this.exportPrice >= this.importPrice * 1.2) {
                validExportPrice = true;
            } else {
                System.out.println("Giá xuất không hợp lệ. Hãy nhập lại.");
            }
        }

        boolean validQuantity = false;
        while (!validQuantity){
            System.out.println("Nhập số lượng sản phẩm: ");
            this.quantity = sc.nextInt();
            if (this.quantity > 0) {
                validQuantity = true;
            }else {
                System.out.println("Vui lòng nhập lại.");
            }
        }

        System.out.println("Nhập mô tả sản phẩm: ");
        this.descriptions = sc.nextLine();
        this.status = inputStatus(sc);
    }
    public boolean inputStatus(Scanner sc) {
        System.out.print("Nhập trạng thái sản phẩm (true – Đang bán, false – Không bán): ");
        do {
            String status = sc.nextLine();
            if (status.equals("true") || status.equals("false")) {
                return Boolean.parseBoolean(status);
            } else {
                System.err.println("Nhập sai vui lòng nhập lại");
            }
        } while (true);
    }
    public void displayData(){
        System.out.printf("Product ID: %s product Name: %s import Price: %f export Price: %f profit : %f quantity: %d description: %s status: %b",this.productid,this.productName,this.importPrice,this.exportPrice,this.quantity,this.descriptions,this.status? "Active" : "Inactive");
    }
    public void calculateInterest(){
        this.profit=this.exportPrice-this.importPrice;
    }
}



