package zimmer.adapterex1.model;

public class Product {

    private String name;
    private double price;
    private String category;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String verifyCategory(){
        switch (this.category){
            case "Acessories":
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/music-metronome-audio-512.png";
            case "Audio":
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/headset-audio-headphones-music-512.png";
            case "Strings":
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/instrument-guitar-audio-acoustic-music-512.png";
            case "Keys":
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/instrument-audio-keys-piano-music-512.png";
            case "Wind":
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/trumpet-instrument-audio-music-512.png";
            case "Percussion":
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/set-modern-drums-audio-music-drum-512.png";
            default:
                return "https://cdn0.iconfinder.com/data/icons/music-audio-10/24/headset-audio-headphones-music-512.png";
        }
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nPrice: " + price +
                "\nCategory: " + category;
    }
}
