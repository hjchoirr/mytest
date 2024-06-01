package org.choongang.student.services;
import lombok.RequiredArgsConstructor;
import org.choongang.game.entities.Rank;
import org.choongang.global.Service;
import org.choongang.student.controllers.RequestSubject;
import org.choongang.student.entities.Subject;
import org.choongang.student.mapper.SubjectMapper;

import java.util.List;

@RequiredArgsConstructor
public class SubjectService implements Service<List<Subject>> {
    private final SubjectMapper mapper;
/*
    @Override
    public void process(RequestSubject form) {
        System.out.println("SubjectService-process()");

        Subject subject = mapper.get(form.getSubCode());
        System.out.println(subject.getSubNm());
    }



    @Override
    public void process(List<Subject> form) {
        Subject subject = mapper.get(form.getSubCode());
        System.out.println(subject.getSubNm());
    }
 */
    @Override
    public List<Subject> process() {
        System.out.println("SubjectService-process()");
        return mapper.getListAll();
    }
}
