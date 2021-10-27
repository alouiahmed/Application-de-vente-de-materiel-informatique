package tn.product.recommandation.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.product.recommandation.entity.Recommandation;

@Repository
public interface RecommandationRepository extends JpaRepository<Recommandation, Long> {

	public List<Recommandation> findByProductRecom(int productId);


	
}
