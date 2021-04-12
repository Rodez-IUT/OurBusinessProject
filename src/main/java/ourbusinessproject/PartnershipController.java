package ourbusinessproject;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PartnershipController {

    private EnterpriseProjectService enterpriseProjectService;
    private PartnershipService partnershipService;

    public PartnershipController(EnterpriseProjectService enterpriseProjectService, PartnershipService partnershipService) {
        this.enterpriseProjectService = enterpriseProjectService;
        this.partnershipService = partnershipService;
    }

    @PostMapping("/api/v1/partnerships")
    public Partnership addPartnership(@RequestParam("project_id") long projectId, @RequestParam("enterprise_id")long enterpriseId) {
        Project project = enterpriseProjectService.findProjectById(projectId);
        Enterprise enterprise = enterpriseProjectService.findEnterpriseById(enterpriseId);
        return partnershipService.save(new Partnership(project,enterprise));
    }

    @DeleteMapping("/api/v1/partnerships/{partnership_id}")
    public void removePartnership(@PathVariable("partnership_id") long partnershipId) {
        Partnership partnership = partnershipService.findPartnershipById(partnershipId);
        partnershipService.remove(partnership);
    }

    @GetMapping("/api/v1/partnerships")
    public List<Partnership> findAllPartnerships() {
        return partnershipService.findAllPartnerships();
    }

    @RequestMapping(value = "/api/v1/partnerships/search", method = RequestMethod.GET)
    public Page<Partnership> searchPartnerships(@RequestParam(value = "project_title",required = false)String projectTitle,
                                                @RequestParam(value = "enterprise_name",required = false)String enterpriseName,
                                                Pageable pageable) {
        Example<Partnership> example = getPartnershipExample(projectTitle, enterpriseName);
        Page<Partnership> res = partnershipService.findAll(example, pageable);
        return res;
    }

    private Example<Partnership> getPartnershipExample(String projectTitle, String enterpriseName) {
        Partnership partnership = new Partnership();
        if (projectTitle != null) {
            Project project = new Project();
            project.setTitle(projectTitle);
            partnership.setProject(project);
        }
        if (enterpriseName != null) {
            Enterprise enterprise = new Enterprise();
            enterprise.setName(enterpriseName);
            partnership.setEnterprise(enterprise);
        }

        return Example.of(partnership);
    }
}
