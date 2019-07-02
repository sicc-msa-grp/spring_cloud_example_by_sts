package com.sicc.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sicc.api.service.OrganizationService;
import com.sicc.api.service.WorkRemoteService;
import com.sicc.model.Organization;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Organization ��Ʈ�ѷ�
 * @author Woongs
 */
@RestController
@RequestMapping(value="/organizations")
public class OrganizationServiceController {
    @Autowired
    private OrganizationService orgService;
    
    @Autowired
    private WorkRemoteService workRemoteService; // organization servcie -> work ������Ʈ ȣ���� ���� ���� Autowired
    
    private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceController.class);

    // get��� ����ID�� ��� select
    @RequestMapping(value="/{organizationId}", method = RequestMethod.GET)
    public String getOrganization( @PathVariable("organizationId") String organizationId) {
        logger.debug("Looking up data for org {}", organizationId);
        Organization org = orgService.getOrg(organizationId);
        org.setContactName(org.getContactName());
        
    	String workInfo = workRemoteService.getWorkInfo("121212");
        
        return String.format("[organizaions id = %s at %s %s ]", org.toString(), System.currentTimeMillis(), workInfo);
    }
    
    // put��� ����ID�� ��� update
    @RequestMapping(value="/{organizationId}", method = RequestMethod.PUT)
    public void updateOrganization( @PathVariable("organizationId") String orgId, @RequestBody Organization org) {
        orgService.updateOrg(org);
    }

    // post��� ����ID�� ��� insert
    @RequestMapping(value="/{organizationId}", method = RequestMethod.POST)
    public void saveOrganization(@RequestBody Organization org) {
       orgService.saveOrg( org );
    }

    // delete��� ����ID�� ��� delete
    @RequestMapping(value="/{organizationId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization( @PathVariable("organizationId") String orgId) {
        orgService.deleteOrg( orgId );
    }
}
