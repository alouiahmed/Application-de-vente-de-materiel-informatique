package tn.product.recommandation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import tn.product.recommandation.entity.Recommandation;

@Service
public interface RecommandationService {
	Recommandation getRecommendationById(int idRecom);
	List<Recommandation> getAll();
	boolean deleteRecommandation(int idRecom);
	boolean updateRecommandation(int idRecom, Recommandation recommandation);
    Recommandation saveRecommandation(Recommandation recommandation);
    List<Recommandation> getAllRecomByProduct(int idProduct);
	
}
