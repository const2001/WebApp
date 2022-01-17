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


@RestController
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


    @GetMapping("/requests")
    public List<Request> getAllRequests(){


        List<Request> requests = requestRepository.findAll();
        List<Request> userRequests = null;
       for (Request r:requests) {
           if(r.getUid().equals(GetLoggedInUsername()))
               userRequests.add(r);

       }
        if (userRequests==null ){
            throw  new IllegalStateException(
                    " No requests found."
            );
        }


        return userRequests;
    }

    @PostMapping("/addRequest")
    public String addRequest (@RequestBody Request r){
       r.setUid(GetLoggedInUsername());
       r.setStatus(0);
        requestRepository.save(r);
        return "Request Saved";
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
    @GetMapping("/pendingRequests")
    public List<Request> getAllPendingRequests(){


        List<Request> requests = requestRepository.findAll();
        List<Request> pendingRequests = null;
        for (Request r:requests) {
            if(r.getDest().equals(GetLoggedInUsername()) && r.getStatus()==0)
                pendingRequests.add(r);

        }

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

    @PostMapping("/addLetter")
    public String addRecommendationLetter (@RequestBody RecommendationLetter rl){
        rl.setUid(GetLoggedInUsername());
        recommendationLetterRepository.save(rl);
        return "Recommendation Letter Saved";
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



}

