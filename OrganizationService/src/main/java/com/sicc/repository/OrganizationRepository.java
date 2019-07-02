package com.sicc.repository;

import com.sicc.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA의 CRUD 기능을 사용하기 위한 인터페이스
 * @author Woongs
 */
@Repository
public interface OrganizationRepository extends CrudRepository<Organization,String>  {
}
