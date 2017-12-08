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
		String message = "";
		PhoneService service = new PhoneServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.안사 1.개통 2.목록 3.회원번호검색 4.이름검색 5.전화번호 변경")) {
			case "0" :
				JOptionPane.showMessageDialog(null, "안녕히가세요");
				return;
			case "1" :
				phone = new PhoneBean();
				member = new MemberBean();
				phone.setName((JOptionPane.showInputDialog("1.Galaxy 2.IPhone").equals("1")) ? "Galaxy " : "IPhone ");
				member.setName(JOptionPane.showInputDialog("이름이 어떻게 되시나요?"));
				JOptionPane.showMessageDialog(null, service.showMessage(member, phone));
				break;
			case "2" :
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "3" :
				JOptionPane.showMessageDialog(null, service.findByKey(JOptionPane.showInputDialog("고객번호 입력")));
				break;
			case "4" :
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름검색")));
				break;
			case "5" :
				JOptionPane.showMessageDialog(null, service.findByKey(JOptionPane.showInputDialog(phone)));
				break;
			}
		}
	}

}
