package Model;

public class Person {

    private String name;
    private String id;
    private String image;
    private String birthday;
    private String bio;

    public Person(String name, String id, String imageView, String birthday, String biography) {
        this.name = name;
        this.id = id;
        this.image = imageView;
        this.birthday = birthday;
        this.bio = biography;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageView() {
        return image;
    }

    public void setImage(String imageView) {
        this.image = imageView;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return bio;
    }

    public void setBiography(String biography) {
        this.bio = biography;
    }
}
