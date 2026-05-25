package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Subjects {
    @Id
    private int id;
    private int english;
    private int hindi;
    private int maths;
    private int science;

    @ManyToMany
    private List<Student> studs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getHindi() {
        return hindi;
    }

    public void setHindi(int hindi) {
        this.hindi = hindi;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getScience() {
        return science;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public List<Student> getStuds() {
        return studs;
    }

    public void setStuds(List<Student> studs) {
        this.studs = studs;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "id=" + id +
                ", english=" + english +
                ", hindi=" + hindi +
                ", maths=" + maths +
                ", science=" + science +
                ", studs=" + studs +
                '}';
    }
}
