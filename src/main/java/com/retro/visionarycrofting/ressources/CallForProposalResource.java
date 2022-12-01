package com.retro.visionarycrofting.ressources;

import com.retro.visionarycrofting.entities.CallForProposal;
import com.retro.visionarycrofting.entities.Product;
import com.retro.visionarycrofting.services.CallForProposalService;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/call-for-proposal")
public class CallForProposalResource {
    private final CallForProposalService callForProposalService;

    @Autowired
    public CallForProposalResource(CallForProposalService callForProposalService) {
        this.callForProposalService = callForProposalService;
    }

    @GetMapping
    public List<CallForProposal> getAllCallForProposal() {
        return callForProposalService.findAllCallForProposal();
    }

    @GetMapping("/frs")
    public List<CallForProposal> findAllByFournisseurName(@RequestParam(value = "name", defaultValue = "null") String name) {
        return callForProposalService.findAllByFournisseurName(name);
    }

    @GetMapping("/stock")
    public List<CallForProposal> findAllByStockId(@RequestParam(value = "stockId", defaultValue = "null") Long stockId) {
        return callForProposalService.findAllByStockId(stockId);
    }

    @GetMapping("/product")
    public List<CallForProposal> findAllByProductRef(@RequestParam(value = "productRef", defaultValue = "null") String productRef) {
        return callForProposalService.findAllByProductRef(productRef);
    }

    @GetMapping("/status")
    public List<CallForProposal> findAllByStatus(@RequestParam(value = "status", defaultValue = "null") String status) {
        return callForProposalService.findAllByStatus(status);
    }

    @GetMapping("/ref")
    public CallForProposal findByRef(@RequestParam(value = "ref", defaultValue = "null") String ref) {
        return callForProposalService.findByRef(ref);
    }

    @PostMapping("/create-c-f-p")
    public CallForProposal addNewCallForProposal(@RequestBody CallForProposal callForProposal) {
        return callForProposalService.addNewCallForProposal(callForProposal);
    }


}
