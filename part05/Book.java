
public class Book {

    private String author;
    private String name;
    private int pages;

    public Book(String author, String name, int pages) {
        this.author = author;
        this.name = name;
        this.pages = pages;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public int getPages() {
        return this.pages;
    }

    @Override
    public String toString() {
        return this.author + ", " + this.name + ", " + this.pages + " pages";
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        if (!(compared instanceof Book)) {
            return false;
        }

        Book comparedBook = (Book) compared;

        return (this.name.equals(comparedBook.name)
                && this.author.equals(comparedBook.author)
                && this.pages == comparedBook.pages);
    }

}
