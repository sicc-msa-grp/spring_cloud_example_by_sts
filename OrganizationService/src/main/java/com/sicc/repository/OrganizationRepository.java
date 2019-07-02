package com.sicc.repository;

import com.sicc.model.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * JPA�� CRUD ����� ����ϱ� ���� �������̽�
 * @author Woongs
 */
@Repository
public interface OrganizationRepository extends CrudRepository<Organization,String>  {
}
