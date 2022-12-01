package com.retro.visionarycrofting.repositories;
import com.retro.visionarycrofting.entities.CallForProposal;
import com.retro.visionarycrofting.enumeration.CallForProposalStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CallForProposalRepository extends JpaRepository<CallForProposal, Long> {
    CallForProposal findByRef(String ref);
    List<CallForProposal> findAllByFournisseurName(String name);
    List<CallForProposal> findAllByStockId(Long id);
    List<CallForProposal> findAllByRefProduct(String ref);
    List<CallForProposal> findAllByStatus(CallForProposalStatus status);
}
