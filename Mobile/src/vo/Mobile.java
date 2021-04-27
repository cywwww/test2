package vo;

/**
 * @Author 王承尧
 * @Date 2021/4/22 2:04 下午
 */
public class Mobile {
    private String brand;
    private String manufacturer;
    private String produce;

    public Mobile(String brand, String manufacturer, String produce) {
        this.brand = brand;
        this.manufacturer = manufacturer;
        this.produce = produce;
    }

    public Mobile() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }
}
