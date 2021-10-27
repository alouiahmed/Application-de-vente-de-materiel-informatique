package com.esprit.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository  extends JpaRepository<Order, Integer> {
	//http://localhost:8081/orders/search/ordersByUsername?username=aymen
	@Query("select o from Order o where o.username like :username")
	public Page<Order> ordersByUsername(@Param("username") String username , Pageable pageable );
	@Query("select SUM(o.prix) from Order o where o.username like :username")
	public Page<Order> total(@Param("username") String username , Pageable pageable );
}
