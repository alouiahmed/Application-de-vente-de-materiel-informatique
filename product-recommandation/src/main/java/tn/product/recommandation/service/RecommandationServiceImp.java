package tn.product.recommandation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.product.recommandation.repository.RecommandationRepository;
import tn.product.recommandation.entity.Recommandation;

@Service
public class RecommandationServiceImp implements RecommandationService {
	@Autowired 
	RecommandationRepository recomRepo;

	@Override
	public Recommandation getRecommendationById(int idRecom) {
		try{
		return recomRepo.findById((long) idRecom).get();
		}
		catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean deleteRecommandation(int idRecom) {
		recomRepo.deleteById((long) idRecom);
		return true;
	}

	@Override
	public List<Recommandation> getAll() {
		return (List<Recommandation>) recomRepo.findAll();
	}


	@Override
	public boolean updateRecommandation(int idRecom, Recommandation recommandation) {
		Recommandation recom = getRecommendationById(idRecom);
			recom.setRating(recommandation.getRating());
			recomRepo.save(recom);
		    return true;

	}

	@Override
	public Recommandation saveRecommandation(Recommandation recommandation) {
		return recomRepo.save(recommandation);
	}

	@Override
	public List<Recommandation> getAllRecomByProduct(int idProduct) {
		//return recomRepo.findAllRatingByProduct(idProduct);
		return recomRepo.findByProductRecom(idProduct);
	}
}
