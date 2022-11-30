package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.CallForProposal;
import com.retro.visionarycrofting.entities.Stock;
import com.retro.visionarycrofting.enumeration.CallForProposalStatus;
import com.retro.visionarycrofting.repositories.CallForProposalRepository;
import com.retro.visionarycrofting.services.CallForProposalService;
import com.retro.visionarycrofting.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CallForProposalServiceImp implements CallForProposalService {

    private final CallForProposalRepository callForProposalRepository;
    @Autowired
    StockService stockService;
    @Autowired
    public CallForProposalServiceImp(CallForProposalRepository callForProposalRepository) {
        this.callForProposalRepository = callForProposalRepository;
    }
    @Override
    public List<CallForProposal> findAllCallForProposal() {return callForProposalRepository.findAll();}
    @Override
    public List<CallForProposal> findAllByFournisseurName(String name){return callForProposalRepository.findAllByFournisseurName(name);}
    @Override
    public List<CallForProposal> findAllByStockId(Long id){return callForProposalRepository.findAllByStockId(id);}
    @Override
    public List<CallForProposal> findAllByProductRef(String ref){return callForProposalRepository.findAllByRefProduct(ref);}
    @Override
    public List<CallForProposal> findAllByStatus(String status){return callForProposalRepository.findAllByStatus(status);}
    @Override
    public CallForProposal findByRef(String ref){return callForProposalRepository.findByRef(ref);}
    @Override
    public CallForProposal addNewCallForProposal(CallForProposal callForProposal){
        Stock stockToSet = stockService.findById(callForProposal.getStock().getId());
        CallForProposal callForProposalToSave = new CallForProposal(callForProposal.getRefProduct(), callForProposal.getQuantity(), stockToSet);
        callForProposalToSave.setStatus(CallForProposalStatus.Open);
        return callForProposalRepository.save(callForProposalToSave);
    }
    @Override
    public void deleteCallForProposal(String ref){
        CallForProposal callForProposalToDelete = callForProposalRepository.findByRef(ref);
        if(callForProposalToDelete != null){
            callForProposalRepository.delete(callForProposalToDelete);
        }else throw new IllegalStateException("This Call For Proposel doesn't exist");
    }
    @Override
    @Transactional
    public void updateCallForProposal(CallForProposal callForProposal, boolean stock){
        CallForProposal callForProposalToUpdate = callForProposalRepository.findById(callForProposal.getId()).
                orElseThrow(() -> new IllegalStateException("Call for proposal with id: " + callForProposal.getId() + " doesn't exist"));
        if (stock){
            if (callForProposal.getRefProduct()!=null && callForProposal.getRefProduct().length()>0 && !callForProposal.getRefProduct().equals(callForProposalToUpdate.getRefProduct())){
                callForProposalToUpdate.setProduct(callForProposal.getRefProduct());
            }else throw new IllegalStateException("This reference is already exist");

            if(callForProposal.getQuantity() != null && callForProposal.getQuantity() > 0){
                callForProposalToUpdate.setQuantity(callForProposal.getQuantity());
            }
            if(callForProposal.getStatus() != null && callForProposal.getStatus().equals(CallForProposalStatus.Close)){
                callForProposalToUpdate.setStatus(CallForProposalStatus.Close);
            }else throw new IllegalStateException("Status not valid");
        }
        else {
            if(callForProposal.getFournisseur() !=null){
                if(callForProposalToUpdate.getStatus() != CallForProposalStatus.Confirmed){
                    if(callForProposal.getStatus() != null && callForProposal.getStatus().equals(CallForProposalStatus.Confirmed)){
                        callForProposalToUpdate.setFournisseur(callForProposal.getFournisseur());
                        callForProposalToUpdate.setStatus(CallForProposalStatus.Confirmed);
                    } throw new IllegalStateException("Status not valid ");
                }else throw new IllegalStateException("This call is alrady confirmed");
            }
        }
    }

    public static boolean verifyEnumStatus(String str) {
        for (CallForProposalStatus enumer : CallForProposalStatus.values()) {
            if (enumer.name().equals(str))
                return true;
        }
        return false;
    }






}
