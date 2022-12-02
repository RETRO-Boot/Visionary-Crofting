package com.retro.visionarycrofting.services.implementation;

import com.retro.visionarycrofting.entities.CallForProposal;
import com.retro.visionarycrofting.entities.Fournisseur;
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
    public List<CallForProposal> findAllByFournisseurName(String name){
        List<CallForProposal> callForProposal = callForProposalRepository.findAllByFournisseurName(name);
        if(callForProposal != null){
            return callForProposal;
        }
        throw new IllegalStateException("There is no Confirmed call for proposal for the provider with name"+name);
    }
    @Override
    public List<CallForProposal> findAllByStockId(Long id){return callForProposalRepository.findAllByStockId(id);}
    @Override
    public List<CallForProposal> findAllByProductRef(String ref){return callForProposalRepository.findAllByRefProduct(ref);}
    @Override
    public List<CallForProposal> findAllByStatus(String status){
        if (verifyEnumStatus(status)){
            return callForProposalRepository.findAllByStatus(CallForProposalStatus.valueOf(status));
        }
        throw new IllegalStateException("Status not valid");
    }
    @Override
    public CallForProposal findByRef(String ref){return callForProposalRepository.findByRef(ref);}
    @Override
    public CallForProposal addNewCallForProposal(CallForProposal callForProposal){

        if(callForProposal.getRefProduct()!=null && callForProposal.getQuantity()>0 && callForProposal.getStock().getId()!=null){
            Stock stockToSet = stockService.findById(callForProposal.getStock().getId());
            CallForProposal callForProposalToSave = new CallForProposal(callForProposal.getRefProduct(), callForProposal.getQuantity(), stockToSet);
            callForProposalToSave.setStatus(CallForProposalStatus.open);
            return callForProposalRepository.save(callForProposalToSave);
        }
        throw new IllegalStateException("Inputs not valides");
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
    public Object updateCallForProposal(CallForProposal callForProposal, boolean stock){
        CallForProposal callForProposalToUpdate = callForProposalRepository.findById(callForProposal.getId()).
                orElseThrow(() -> new IllegalStateException("Call for proposal with id: " + callForProposal.getId() + " doesn't exist"));
        if (stock){
            if (callForProposal.getRefProduct()!=null){
                if(callForProposal.getRefProduct().length()>0 && !callForProposal.getRefProduct().equals(callForProposalToUpdate.getRefProduct())){
                    callForProposalToUpdate.setProduct(callForProposal.getRefProduct());
                }else return "This reference is already exist";
            }

            if(callForProposal.getQuantity() != null && callForProposal.getQuantity() > 0){
                callForProposalToUpdate.setQuantity(callForProposal.getQuantity());
            }

            if(callForProposal.getStatus() != null){
                if(callForProposal.getStatus().equals(CallForProposalStatus.close)){
                    callForProposalToUpdate.setStatus(CallForProposalStatus.close);
                }else return "Status not valid";
            }
        }
        else {
            if(callForProposal.getFournisseur() !=null){
                if(callForProposalToUpdate.getStatus() != CallForProposalStatus.confirmed){
                    if(callForProposal.getStatus() != null && callForProposal.getStatus().equals(CallForProposalStatus.confirmed)){
                        callForProposalToUpdate.setFournisseur(callForProposal.getFournisseur());
                        callForProposalToUpdate.setStatus(CallForProposalStatus.confirmed);
                        return callForProposalToUpdate;
                    } return "Status not valid ";
                }else return "This call is alrady confirmed";
            }
        }

        return "Updates done";
    }

    public static boolean verifyEnumStatus(String str) {
        for (CallForProposalStatus enumer : CallForProposalStatus.values()) {
            if (enumer.name().equals(str))
                return true;
        }
        return false;
    }






}
