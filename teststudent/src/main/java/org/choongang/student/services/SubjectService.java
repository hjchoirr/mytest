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

//    @Override
//    public List<Subject> process(RequestSubject form) {
//        System.out.println("SubjectService-process()");
//        return mapper.getList(form.getSubCode());
//    }


    @Override
    public List<Subject> process() {
        System.out.println("**SubjectService-process()");
        return mapper.getSubject();

    }

    /*
        @Override
    public List<Rank> process() {

        return mapper.getSubject();
    }
     */
}
