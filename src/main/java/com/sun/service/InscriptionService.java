package com.sun.service;

import com.sun.entity.Inscription;
import com.sun.form.InscriptionForm;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2811:41
 */
public interface InscriptionService {
    List<Inscription> findAll();

    Inscription getOne(Integer id);

    void saveOrUpdate(InscriptionForm inscriptionForm);

    void updateList(List<InscriptionForm> inscriptionForms);
}