package com.sktelecom.jse.controller;

import javax.swing.JOptionPane;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.PhoneService;
import com.sktelecom.jse.serviceimpl.PhoneServiceImpl;

public class Controller {
	public static void main(String[] args) {
		MemberBean member = null;
		PhoneBean phone = null;
		PhoneService service = new PhoneServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.안사 1.개통")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "안녕히가세요");
				return;
			case "1" :
				phone = new PhoneBean();
				member = new MemberBean();
				phone.setName((JOptionPane.showInputDialog("1.Galaxy 2.IPhone").equals("1")) ? "Galaxy " : "IPhone ");
				member.setName(JOptionPane.showInputDialog("이름이 어떻게 되시나요?"));
				JOptionPane.showMessageDialog(null, service.showMessage(member, phone));
			}
		}
	}

}
