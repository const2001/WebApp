package hua.WebApp.SpringBoot.entities.RecommendationLetter;


import javax.persistence.*;

@Entity
@Table(name ="RecommendationLetters")

public class RecommendationLetter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String Text;
    private Long Rid;
    private String Uid;
    public RecommendationLetter() {

    }

    public RecommendationLetter(Long id, String title, String text) {
        this.id = id;
        this.title = title;
        Text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Long getRid() {
        return Rid;
    }

    public void setRid(Long rid) {
        Rid = rid;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }
}
