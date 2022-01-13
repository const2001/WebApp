package io.javabrains.springsecurityjpa;

import io.javabrains.springsecurityjpa.entities.Request.Request;
import io.javabrains.springsecurityjpa.entities.Request.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Controller {


    private final RequestRepository requestRepository;

    public Controller(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
    }

    @GetMapping("/")
    public String home() {
        return ("<h1>Welcome</h1>");
    }

    @GetMapping("/user")
    public String user() {
        return ("<h1>Welcome User</h1>");
    }

    @GetMapping("/admin")
    public String admin() {
        return ("<h1>Welcome Admin</h1>");
    }

    @PostMapping("/addRequest")
    public String registerNewStudent(@RequestBody Request r){
        requestRepository.save(r);
        return "added";
    }
}

