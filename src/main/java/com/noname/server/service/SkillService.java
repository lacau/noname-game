package com.noname.server.service;

import java.util.List;

import com.noname.server.adapter.SkillAdapter;
import com.noname.server.json.SkillOut;
import com.noname.server.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lacau on 22/02/16.
 */
@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillAdapter skillAdapter;

    public List<SkillOut> listSkill() {
        return skillAdapter.adapt(skillRepository.listAll());
    }
}