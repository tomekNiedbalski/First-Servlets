package pl.sdacademy.model;

import pl.sdacademy.model.Image;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private String name;
    private List<Image> imageList;
    private LocalDate date;

    public Gallery(String name) {
        this.name = name;
        this.imageList = createImageList();
        this.date = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public LocalDate getDate() {
        return date;
    }

    private List<Image> createImageList(){
        List<Image> imageList = new ArrayList<>();
        Image image1 = new Image("photos/cristiano.jpg","Cristiano Ronaldo");
        Image image2 = new Image("photos/neymar.jpeg","Neymar");
        Image image3 = new Image("photos/lewandowski.jpg","Robert Lewandowski");
        Image image4 = new Image("photos/zlatan.jpg","Zlatan Ibrahimović");
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        imageList.add(image4);

        return imageList;
    }
}
