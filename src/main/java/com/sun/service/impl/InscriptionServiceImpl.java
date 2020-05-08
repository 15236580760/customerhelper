package com.sun.service.impl;

import com.sun.entity.Inscription;
import com.sun.form.InscriptionForm;
import com.sun.repository.InscriptionRepository;
import com.sun.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2811:41
 */
@Service
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;


    @Override
    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    @Override
    public Inscription getOne(Integer id) {
        return inscriptionRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(InscriptionForm inscriptionForm) {
        Inscription inscription;
        if(inscriptionForm.getId()==null){
            inscription=new Inscription();
        }else {
            inscription=inscriptionRepository.findById(inscriptionForm.getId()).get();
        }
        inscription.setAddition(inscriptionForm.getAddition());
        inscription.setEtc(inscriptionForm.getEtc());
        inscription.setInscriptionNum(inscriptionForm.getInscriptionNum());
        inscriptionRepository.save(inscription);
    }

    @Override
    public void updateList(List<InscriptionForm> inscriptionForms) {
        for(InscriptionForm inscriptionForm : inscriptionForms){
            if(inscriptionForm.getId()!=null){
                Inscription inscription=inscriptionRepository.findById(inscriptionForm.getId()).get();
                inscription.setAddition(inscriptionForm.getAddition());
                inscription.setEtc(inscriptionForm.getEtc());
                inscription.setInscriptionNum(inscriptionForm.getInscriptionNum());
                inscriptionRepository.save(inscription);
            }
        }
    }
}