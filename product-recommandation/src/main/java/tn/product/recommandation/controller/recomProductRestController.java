package tn.product.recommandation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import tn.product.recommandation.entity.Recommandation;
import tn.product.recommandation.repository.RecommandationRepository;
import tn.product.recommandation.service.RecommandationService;

@RestController

public class recomProductRestController {
	@Autowired
	RecommandationService recomService;
	
	@Autowired
	RecommandationRepository recomRepo;

	@GetMapping("/getRecom/{idRecom}")
	@ResponseBody
	public ResponseEntity<Recommandation> getRecomById(@PathVariable("idRecom")int idRecom){
		Recommandation recommandation= recomService.getRecommendationById(idRecom);
		if(recommandation != null){
			try{
		        return new ResponseEntity<Recommandation>(recommandation,HttpStatus.OK);
	
			}
			catch(Exception e){
    			return new ResponseEntity<Recommandation>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		return new ResponseEntity<Recommandation>(HttpStatus.NOT_FOUND);

	}
	
	/*Delete recommandation*/
    @DeleteMapping(value = "/deleteRecommendation/{idRecom}")
    @ResponseBody
	    public ResponseEntity<Void> deleteRecommendation(@PathVariable("idRecom") int idRecom){
	    	Recommandation recommendation = recomService.getRecommendationById(idRecom);
	    	if(recommendation != null) {
	    		try {
	    			recomService.deleteRecommandation(idRecom);
	    			return new ResponseEntity<Void>(HttpStatus.OK);
	    		}catch (Exception e) {
	    			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	    		}
	    	} 
		 return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	    	
	    }

    /*Update recommandation*/
	 @PutMapping(value = "/updateRecommandation/{idRecom}")
	 @ResponseBody
	    public ResponseEntity<Void> updateRecommendation(@PathVariable("idRecom") int idRecom, @RequestBody Recommandation recommandationBody){
				Recommandation recommendation = recomService.getRecommendationById(idRecom);
			 	if(recommendation != null) {
					try {
		    			recomService.updateRecommandation(idRecom, recommandationBody);
		    			return new ResponseEntity<Void>(HttpStatus.OK);
		    		}catch (Exception e) {
		    			return new ResponseEntity<Void>(
		    					HttpStatus.INTERNAL_SERVER_ERROR);	
		    		}
			 	}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	
	    }
	 /*add recommandation*/
	 @PostMapping(value="/addRecommandation")
	 @ResponseBody
	 	public ResponseEntity<Void> postRecommandation(@RequestBody Recommandation recommandation){
			 try {
	 			recomService.saveRecommandation(recommandation);
	 			return new ResponseEntity<Void>(HttpStatus.OK);
	 		}catch (Exception e) {
	 			return new ResponseEntity<Void>(
	 					HttpStatus.INTERNAL_SERVER_ERROR);	
	 		}
	 }
	 
	 /*find rating by product*/
	 @GetMapping(value="/getRecomByProduct/{idProd}")
	 @ResponseBody
	   public ResponseEntity<List<Recommandation>> getRatingByProduct(@PathVariable("idProd") int idProd){
		 try {
			 List<Recommandation> recommandations=recomService.getAllRecomByProduct(idProd);
	 			return new ResponseEntity<List<Recommandation>>(recommandations,HttpStatus.OK);
	 		}catch (Exception e) {
	 			return new ResponseEntity<List<Recommandation>>(
	 					HttpStatus.INTERNAL_SERVER_ERROR);	
	 		}
	 }
 }

	
