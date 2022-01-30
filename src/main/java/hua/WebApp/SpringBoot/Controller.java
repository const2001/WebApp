package hua.WebApp.SpringBoot;

import hua.WebApp.SpringBoot.entities.RecommendationLetter.RecommendationLetter;
import hua.WebApp.SpringBoot.entities.RecommendationLetter.RecommendationLetterRepository;
import hua.WebApp.SpringBoot.entities.Request.Request;
import hua.WebApp.SpringBoot.entities.Request.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;



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
    public String homepage(){
        System.out.println(hasRole());
        if(hasRole().equals("[ROLE_STUDENT]"))
         return "StudentPage";

        else if(hasRole().equals("[ROLE_PROFESSOR]"))
            return "ProfessorPage";
        return "error";
}

    @GetMapping("/requestsPage")
    public String getRequests() {

        return "Requests";

    }
    @GetMapping("/requests")
    public List<Request> getAllRequests(){

        List<Request> requests = requestRepository.findAll();

        requests.removeIf(r -> !r.getUid().equals(GetLoggedInUsername()));
        if (requests.isEmpty()){
            throw  new IllegalStateException(
                    " No requests found."
            );
        }
        return requests;

    }

    @GetMapping("/addRequestPage")
    public String getAddRequest() {

        return "addRequest";
    }


    @PostMapping("/addRequest")
    public String addRequest (@RequestBody Request r){
       r.setUid(GetLoggedInUsername());
       r.setStatus(0);
        requestRepository.save(r);
        r.setUid(GetLoggedInUsername());
        requestRepository.save(r);
        return "Request added";
    }


    @PutMapping("/editRequest/{requestId}")
    public String editRequest(@PathVariable("requestId") Long requestId){
       //TODO
        return "Request Updated";
    }

    @DeleteMapping( "deleteRequest/{requestId}")
    public String deleteRequest(@PathVariable("requestId") Long requestId){
        Optional<Request> r = requestRepository.findById(requestId);

        boolean exists =  requestRepository.existsById(requestId);

        if (!exists ){
            throw  new IllegalStateException(
                    "request with id : "+ requestId + " does not exists"
            );
        }
        if (!r.get().getUid().equals(GetLoggedInUsername()) ){
            throw  new IllegalStateException(
                    "You dont have access to delete the request with id: "+ requestId
            );
        }
        requestRepository.deleteById(requestId);
        return "Request Deleted";
    }

    //Professor Endpoints
    @GetMapping("/pendingRequestsPage")
    public String getPendingRequestsPage(){

        return "pendingRequests";
    }

    @GetMapping("/pendingRequests")
    public List<Request> getAllPendingRequests(){


        List<Request> pendingRequests = requestRepository.findAll();

        pendingRequests.removeIf(r -> !r.getDest().equals(GetLoggedInUsername()) || r.getStatus()!=0 );

        return pendingRequests;
    }

    @PutMapping("/setRequestStatus/{requestId}")
    public String setRequestStatus(@PathVariable(value = "id") Long requestId,
                                   @Valid @RequestBody Request requestDetails){

        boolean exists =  requestRepository.existsById(requestId);
        if (!exists ){
            throw  new IllegalStateException(
                    "request with id : "+ requestId + " does not exists"
            );
        }
        Optional<Request> r =  requestRepository.findById(requestId);
        if (!r.get().getDest().equals(GetLoggedInUsername()) ){
            throw  new IllegalStateException(
                    "You dont have access to change the status of this request with id: "+ requestId
            );
        }

        Request request =  r.get();
        request.setStatus(requestDetails.getStatus()) ;
        requestRepository.save(request);

        return  "Request Updated";
    }

    @GetMapping("/addLetterPage")
    public String getAddLetterPage(){

        return "recommendation letter";
    }


    @PostMapping("/addLetter")
    public String addRecommendationLetter (@RequestBody RecommendationLetter rl){
        rl.setUid(GetLoggedInUsername());
        recommendationLetterRepository.save(rl);
        return "Recommendation Letter Saved";
    }

    @GetMapping("/viewLettersPage")
    public String getLettersPage(){

        return "letters";
    }



    @PutMapping("/editLetter/{letterId}")
    public String editLetter(@PathVariable("letterId") Long letterId){
       //TODO
        return "Recommendation Letter Updated";
    }

    @DeleteMapping( "deleteLetter/{letterId}")
    public void deleteRLetter(@PathVariable("letterId") Long letterId){
        recommendationLetterRepository.findById(letterId);

        boolean exists =  recommendationLetterRepository.existsById(letterId);
        if (!exists){
            throw  new IllegalStateException(
                    "student with id : "+ letterId + " does not exists"
            );
        }
        Optional<RecommendationLetter> recommendationLetter = recommendationLetterRepository.findById(letterId);
        if (!recommendationLetter.get().getUid().equals(GetLoggedInUsername()) ){
            throw  new IllegalStateException(
                    "You dont have access to change the status of this request with id: "+ letterId
            );
        }
        recommendationLetterRepository.deleteById(letterId);
    }

    private String GetLoggedInUsername(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();

        } else {
            username = principal.toString();

        }
        return username;

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

