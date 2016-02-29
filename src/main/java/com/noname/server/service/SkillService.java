package com.noname.server.service;

import java.util.List;

import com.noname.server.adapter.SkillAdapter;
import com.noname.server.json.SkillOut;
import com.noname.server.json.SkillSelectIn;
import com.noname.server.repository.SkillRepository;
import com.noname.server.validator.SkillValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lacau on 22/02/16.
 */
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillAdapter skillAdapter;

    @Autowired
    private SkillValidator skillValidator;

    public List<SkillOut> listSkill() {
        return skillAdapter.adapt(skillRepository.listAll());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void selectSkills(SkillSelectIn skillSelectIn) {
    }
}