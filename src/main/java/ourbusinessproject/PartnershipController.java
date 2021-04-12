package ourbusinessproject;

import org.springframework.web.bind.annotation.*;

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
}
