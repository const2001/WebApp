package hua.WebApp.SpringBoot.entities.Request;


import javax.persistence.*;

@Entity
@Table(name ="Requests")

public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private Long  mark;
    private String Dest;
    private String status = "Pending";
    private String Uid;

    public Request() {
    }

    public Request(Long id, String name, String email, Long mark, String dest, String status) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.mark = mark;
        Dest = dest;
        this.status = status;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public String getDest() {
        return Dest;
    }

    public void setDest(String dest) {
        Dest = dest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String agreed) {
        this.status = agreed;
    }

    public String getUid() {
        return Uid;
    }

    public void setUid(String uid) {
        Uid = uid;
    }

}