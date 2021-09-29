package com.everis.msServidorOLAP.dal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.everis.msServidorOLAP.dal.entity.Principal;

public interface PrincipalRepository extends JpaRepository<Principal, Integer> {
	@Modifying
	@Query(QuerysJPQL.QUERY_UPDATE_PRINCIPALBYNOMBRE)
	public void updatePrincipalPresave(@Param("nombre") String nombre);
}