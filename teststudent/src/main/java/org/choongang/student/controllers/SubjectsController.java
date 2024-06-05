package org.choongang.student.controllers;

import org.choongang.global.AbstractController;
import org.choongang.global.Router;
import org.choongang.global.Service;
import org.choongang.global.constants.MainMenu;
import org.choongang.main.MainRouter;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.controllers.RequestLogin;
import org.choongang.member.services.MemberServiceLocator;
import org.choongang.student.constants.StudentMenu;
import org.choongang.student.entities.Subject;
import org.choongang.student.services.StudentServiceLocator;
import org.choongang.student.services.SubjectServiceUpdate;
import org.choongang.template.Templates;

import java.util.List;
import java.util.stream.Collectors;

public class SubjectsController extends AbstractController {
    @Override
    public void show() {
        System.out.println("**SubjectsController-show()");
        Templates.getInstance().render(StudentMenu.SUBJECTS);
    }
    @Override
    public void prompt() {
        Service<List<Subject>> service = StudentServiceLocator.getInstance().find(StudentMenu.SUBJECTS);
        List<Subject> subjects = service.process();
        String subjecting = subjects.stream()
                .map(r -> String.format("%d %s %s %s", r.getSubCode(), r.getSubNm(), r.getTeacherNm(), r.getSubDiv()))
                .collect(Collectors.joining("\n"));

        Templates.getInstance().render(StudentMenu.SUBJECTS, () -> subjecting);
        System.out.println();
        System.out.println("위의 목록에서 수정할 과목을 고르세요");
        
        int subCode = Integer.parseInt(promptWithValidation("과목코드: ", s -> !s.isBlank()));
        String subNm = promptWithValidation("과목명: ", s -> !s.isBlank());
        String teacherNm = promptWithValidation("교사: ", s -> !s.isBlank());
        String subDiv = promptWithValidation("문이과구분(문/이): ", s -> !s.isBlank());

        RequestSubject form = RequestSubject.builder()
                .subCode(subCode)
                .subNm(subNm)
                .teacherNm(teacherNm)
                .subDiv(subDiv)
                .build();
        try {

            Service  service1 = StudentServiceLocator.getInstance().findUpdate(StudentMenu.SUBJECTS);
            service1.process(form);

        } catch (RuntimeException e) {

            System.err.println(e.getMessage());
        }

        System.out.println("**SubjectsController-prompt() 끝");
        MainRouter.getInstance().change(MainMenu.STUDENT);
    }

}
