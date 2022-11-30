package com.retro.visionarycrofting.services;

import com.retro.visionarycrofting.entities.CallForProposal;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public interface CallForProposalService {

    List<CallForProposal> findAllCallForProposal();

    List<CallForProposal> findAllByFournisseurName(String name);

    List<CallForProposal> findAllByStockId(Long id);

    List<CallForProposal> findAllByProductRef(String ref);

    List<CallForProposal> findAllByStatus(String status);

    CallForProposal findByRef(String ref);

    CallForProposal addNewCallForProposal(String productReference, int quantity, Long stock);

    void deleteCallForProposal(String ref);

    @Transactional
    void updateCallForProposal(CallForProposal callForProposal, boolean stock);
}
