interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer(); 
    }

    private void loadFromRemoteServer() {
        System.out.println("Downloading [" + filename + "] from remote server... (This takes time and bandwidth)");
    }

    @Override
    public void display() {
        System.out.println("Rendering high-resolution image: " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage; 
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
        
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Test Class
public class ProxyPatternExample {
    public static void main(String[] args) {
        
        System.out.println("--- Initializing Photo Gallery ---");
        Image photo1 = new ProxyImage("holiday_pic_1.jpg");
        Image photo2 = new ProxyImage("holiday_pic_2.jpg");
        System.out.println("Gallery loaded. (Memory usage is near zero)\n");

        System.out.println("--- User opens Photo 1 ---");
        photo1.display(); 

        System.out.println("\n--- User opens Photo 1 again ---");
        photo1.display(); 

        System.out.println("\n--- User opens Photo 2 ---");
        photo2.display();
    }
}