package entities;

public class Book {
    private int id;
    private String title;
    private int ageOfPublication;
    private double price;
    private int idAuthor;
    private Author author;

    public Book(int id, String title, int ageOfPublication, double price, int idAuthor, Author author) {
        this.id = id;
        this.title = title;
        this.ageOfPublication = ageOfPublication;
        this.price = price;
        this.idAuthor = idAuthor;
        this.author = author;
    }

    public Book (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAgeOfPublication() {
        return ageOfPublication;
    }

    public void setAgeOfPublication(int ageOfPublication) {
        this.ageOfPublication = ageOfPublication;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", title: '" + title + '\'' +
                ", ageOfPublication: " + ageOfPublication +
                ", price: " + price +
                ", idAuthor: " + idAuthor + '\n';
    }
}
