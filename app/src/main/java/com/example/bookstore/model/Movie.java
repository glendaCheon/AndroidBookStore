package com.example.bookstore.model;

import com.google.gson.annotations.SerializedName;

//영화 상세 정보
public class Movie {
    long id;
    String title;
    String desc;
    String summary;
    @SerializedName(value = "small_cover_image") // page에선 small_cover_image로 뿌려오므로 camel case로 매핑해줌.
    String smallCoverImage;
    @SerializedName(value = "medium_cover_image") // page에선 small_cover_image로 뿌려오므로 camel case로 매핑해줌.
    String mediumCoverImage;

    public String getMediumCoverImage() {
        return mediumCoverImage;
    }

    public void setMediumCoverImage(String mediumCoverImage) {
        this.mediumCoverImage = mediumCoverImage;
    }

    public String getSmallCoverImage() {
        return smallCoverImage;
    }

    public void setSmallCoverImage(String smallCoverImage) {
        this.smallCoverImage = smallCoverImage;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", summary='" + summary + '\'' +
                ", smallCoverImage='" + smallCoverImage + '\'' +
                '}';
    }
}
