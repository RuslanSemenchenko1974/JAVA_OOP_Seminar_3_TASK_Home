public class NoutBook {
    int id;
    String manufacturer;
    String model;
    int ram;
    int hd;
    String oS;
    int price;
    String color;

      public  NoutBook(int id, String manufacturer, String model, int ram, int hd, String oS, int price, String color){
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.ram = ram;
        this.hd = hd;
        this.oS = oS;
        this.price = price;
        this.color = color;
    }
    @Override
    public boolean equals(Object obj) {
        var t = (NoutBook) obj;
        return t.id == id && t.manufacturer==manufacturer && t.model==model && t.ram == ram && t.hd ==hd && t.color == color;
    }
   @Override
    public String toString() {
        String res = String.format("%s, %s, ram : %d, %s, price : %d", manufacturer, model, ram, color, price);
        return res;
    }

}
