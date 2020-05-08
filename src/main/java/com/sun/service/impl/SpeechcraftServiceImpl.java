package com.sun.service.impl;

import com.sun.entity.Speechcraft;
import com.sun.form.SpeechcraftForm;
import com.sun.repository.SpeechcraftRepository;
import com.sun.service.SpeechcraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2813:32
 */
@Service
public class SpeechcraftServiceImpl implements SpeechcraftService {

    @Autowired
    private SpeechcraftRepository speechcraftRepository;

    @Override
    public List<Speechcraft> findAll() {
        return speechcraftRepository.findAll();
    }

    @Override
    public Speechcraft getOne(Integer id) {
        return speechcraftRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(SpeechcraftForm speechcraftForm) {
        Speechcraft speechcraft;
        if (speechcraftForm.getId() == null) {
            speechcraft = new Speechcraft();
        } else {
            speechcraft = speechcraftRepository.findById(speechcraftForm.getId()).get();
        }
        speechcraft.setName(speechcraftForm.getName());
        speechcraft.setSpeechcraft(speechcraftForm.getSpeechcraft());
        speechcraftRepository.save(speechcraft);
    }

    @Override
    public void updateList(List<SpeechcraftForm> speechcraftForms) {

        for (SpeechcraftForm speechcraftForm : speechcraftForms) {
            if (speechcraftForm.getId() != null) {
                Speechcraft speechcraft = speechcraftRepository.findById(speechcraftForm.getId()).get();
                speechcraft.setName(speechcraftForm.getName());
                speechcraft.setSpeechcraft(speechcraftForm.getSpeechcraft());
                speechcraftRepository.save(speechcraft);
            }
        }

    }
}