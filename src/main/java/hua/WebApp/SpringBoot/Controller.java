package hua.WebApp.SpringBoot;

import hua.WebApp.SpringBoot.entities.RecommendationLetter.RecommendationLetter;
import hua.WebApp.SpringBoot.entities.RecommendationLetter.RecommendationLetterRepository;
import hua.WebApp.SpringBoot.entities.Request.Request;
import hua.WebApp.SpringBoot.entities.Request.RequestRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class Controller {


    private final RequestRepository requestRepository;
    private final RecommendationLetterRepository recommendationLetterRepository;

    public Controller(RequestRepository requestRepository, RecommendationLetterRepository recommendationLetterRepository){
        this.requestRepository = requestRepository;
        this.recommendationLetterRepository = recommendationLetterRepository;
    }

    //Student Endpoints

    @GetMapping("/requests")
    public List<Request> getAllStudents(){
        return requestRepository.findAll();
    }

    @PostMapping("/addRequest")
    public String addRequest (@RequestBody Request r){
        requestRepository.save(r);
        return "Request Saved";
    }
    @PutMapping("/editRequest/{requestId}")
    public String editRequest(@PathVariable("requestId") Long requestId){
       // requestRepository.save(requestId);

        return "Request Updated";
    }

    @DeleteMapping( "deleteRequest/{requestId}")
    public void deleteRequest(@PathVariable("requestId") Long requestId){
        requestRepository.findById(requestId);

        boolean exists =  requestRepository.existsById(requestId);
        if (!exists){
            throw  new IllegalStateException(
                    "student with id : "+ requestId + " does not exists"
            );
        }
        requestRepository.deleteById(requestId);
    }

    //Professor Endpoints
    @PutMapping("/setRequestStatus")
    public String setRequestStatus(@RequestBody Request r){
        requestRepository.save(r);
        return "Request Updated";
    }

    @PostMapping("/addLetter")
    public String addRecommendationLetter (@RequestBody RecommendationLetter rl){
        recommendationLetterRepository.save(rl);
        return "Recommendation Letter Saved";
    }
    @PutMapping("/editLetter/{letterId}")
    public String editLetter(@PathVariable("letterId") Long letterId){
        // RecommendationLetterRepository.save(letterId);

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
        recommendationLetterRepository.deleteById(letterId);
    }



}

