package com.example.uasmpr;

public class Model {
    String name,detail,image;

    public Model() {
    }


    public Model(String image, String name, String food_detail) {
        this.image = image;
        this.name = name;
        this.detail = food_detail;
    }

//    public String getImage() {
//        return image;
//    }
//
//    public void setImage(String image) {
//        this.image = image;
//    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    //    public String getFood_name() {
//        return name;
//    }
//
//    public void setFood_name(String name) {
//        this.name = name;
//    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail.replace("_n","\n\n");
    }

//    public String get_detail() {
//        return detail;
//    }
//
//    public void setFood_detail(String detail) {
//        this.detail = detail.replace("_n","\n\n");
//    }
}

