package com.sun.service;

import com.sun.form.SpeechcraftForm;

import java.util.List;

/**
 * @author Shou
 * @Title:
 * @Package
 * @Description:
 * @date 2020/4/2813:29
 */
public interface SpeechcraftService {
    Object findAll();

    Object getOne(Integer id);

    void saveOrUpdate(SpeechcraftForm speechcraftForm);

    void updateList(List<SpeechcraftForm> speechcraftForms);
}