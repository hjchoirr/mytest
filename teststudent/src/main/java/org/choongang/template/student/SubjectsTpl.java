package org.choongang.template.student;

import org.choongang.template.Template;
import org.choongang.template.Templates;

import java.util.function.Supplier;

public class SubjectsTpl implements Template {

    private Supplier<String> hook;

    public void addHook(Supplier<String> hook) {
        this.hook = hook;
    }

    @Override
    public String getTpl() {

        StringBuffer sb = new StringBuffer(1000);
        sb.append("과목정보 관리\n");
        sb.append("작업할 과목을 선택하세요\n");
        sb.append(Templates.getInstance().line());

        return sb.toString();
    }
}