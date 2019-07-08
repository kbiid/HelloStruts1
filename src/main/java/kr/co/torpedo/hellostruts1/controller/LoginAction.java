package kr.co.torpedo.hellostruts1.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import kr.co.torpedo.hellostruts1.domain.Admin;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ConfigReader reader = new ConfigReader();
		
		if (((Admin)form).getId().equals("")) {
			request.setAttribute("message", "아이디를 입력하세요.");
		} else if (((Admin) form).getPasswd().equals("")) {
			request.setAttribute("message", "비밀번호를 입력하세요.");
		} else {
			if (((Admin) form).checkAdminInfo(reader.getAdminId(), reader.getAdminPwd())) {
				return (mapping.findForward("success"));
			} else {
				return (mapping.findForward("fail"));
			}
		}
		return (mapping.findForward("back"));
	}
}
