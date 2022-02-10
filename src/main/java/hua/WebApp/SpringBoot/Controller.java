package hua.WebApp.SpringBoot;

import hua.WebApp.SpringBoot.entities.RecommendationLetter.RecommendationLetterRepository;
import hua.WebApp.SpringBoot.entities.Request.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    UserDetailsService userDetailsService;

    private final RequestRepository requestRepository;
    private final RecommendationLetterRepository recommendationLetterRepository;



    public Controller(RequestRepository requestRepository, RecommendationLetterRepository recommendationLetterRepository, UserRepository userRepository){
        this.requestRepository = requestRepository;
        this.recommendationLetterRepository = recommendationLetterRepository;

    }

    //Student Endpoints


    @GetMapping("/")
    public String home(){
        hasRole();
        return "redirect:/homepage";
    }

//    @GetMapping("/")
//    public String home(){
//        hasRole();
//        return "redirect:/homepage";
//    }


    @GetMapping("/homepage")
    public String homepage(){
        String error = "error message";
        System.out.println(hasRole());
        if(hasRole().equals("[ROLE_STUDENT]"))
            return "StudentPage";

        else if(hasRole().equals("[ROLE_PROFESSOR]"))
            return "ProfessorPage";
        return error;
    }

    @GetMapping("/requestsPage")
    public String getRequests() {

        return "Requests";

    }

    @GetMapping("/editRequestPage/{requestId}")
    public String getEditRequest() {

        return "editRequestPage";

    }

    @GetMapping("/acceptedRequestsPage")
    public String getAcceptedRequests() {

        return "acceptedRequests";

    }


    @GetMapping("/addRequestPage")
    public String getAddRequest() {

        return "addRequest";
    }


    //Professor Endpoints
    @GetMapping("/pendingRequestsPage")
    public String getPendingRequestsPage(){

        return "pendingRequests";
    }


    @GetMapping("/addLetterPage")
    public String getAddLetterPage(){

        return "recommendation letter";
    }


    @GetMapping("/viewLettersPage")
    public String getLettersPage(){

        return "letters";
    }
    public static String returnHome(){
        return "redirect:/homepage";
    }

    private String hasRole(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String role;
        if (principal instanceof UserDetails) {
            role = ((UserDetails)principal).getAuthorities().toString();


        } else {
            role = principal.toString();

        }
        return role;
    }




}
