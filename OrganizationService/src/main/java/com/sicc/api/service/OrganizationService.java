package com.sicc.api.service;

import com.sicc.model.Organization;
import com.sicc.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

/**
 * JPA로 CRUD를 사용하기 위한 서비스
 * @author Woongs
 */
@Service
public class OrganizationService {
	@Autowired
    private OrganizationRepository orgRepository; // interface repository
	// select
    public Organization getOrg(String organizationId) {
      Optional<Organization> organization = orgRepository.findById(organizationId);
        if (!organization.isPresent())
          throw new NullPointerException("organizationId-" + organizationId);
        return organization.get();
    }
    // insert
    public void saveOrg(Organization org){
        org.setId(UUID.randomUUID().toString());
        orgRepository.save(org);
    }
    // update
    public void updateOrg(Organization org){
        orgRepository.save(org);
    }
    // delete
    public void deleteOrg(String orgId){
        orgRepository.deleteById(orgId);
    }
}