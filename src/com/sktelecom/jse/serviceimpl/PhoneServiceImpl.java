package com.sktelecom.jse.serviceimpl;

import java.security.Provider.Service;

import javax.naming.CommunicationException;
import javax.swing.JOptionPane;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.PhoneService;

public class PhoneServiceImpl implements PhoneService{
	MemberBean[] members;
	PhoneBean[] phones;
	private int memberCount, phoneCount, customeNum;
	public PhoneServiceImpl() {
		memberCount = phoneCount = 0;
		customeNum = 1000;
		members = new MemberBean[4];
		phones = new PhoneBean[4];
	}
	public void addUser(MemberBean member, PhoneBean phone) {
		String customNum = createCustomNum();
		member.setCustomNum(customNum);
		phone.setCustomNum(customNum);
		this.members[memberCount++] = member;
		this.phones[phoneCount++] = phone;
		
	}
	@Override
	public String showMessage(MemberBean member, PhoneBean phone) {
		phone.setNumber(makeNumber());
		addUser(member, phone);
		String message = 
				String.format(
				"[%s]님 이름으로 \n"
				+ "[010-%s] 으로 [%s]폰이 \n"
				+ "개통되었습니다.", member.getName(), phone.getNumber(), phone.getName());
		return message;
	}

	@Override
	public String makeNumber() {
		return String.valueOf(
				(int)(Math.random() * 8999 + 1000))+
					"-"+String.valueOf((int)(Math.random() * 8999 + 1000));
	}
	public String createCustomNum() {
		return String.valueOf(customeNum++);
	}
	@Override
	public String list() {
		String a = "";
		for(int i=0;i<phoneCount;i++) {
			if(members[i].getCustomNum().equals(phones[i].getCustomNum())) {
			a = a.concat("\n"+"[회원번호]"+members[i].getCustomNum()
							+" [핸드폰번호]010-"+ phones[i].getNumber() 
								+" [이름]"+ members[i].getName());
			}
		}
		return a;
	}
	@Override
	public String findByKey(String key) {
		String member = "";
		for(int i=0;i<memberCount;i++) {
			if(key.equals(members[i].getCustomNum())) {
				member = key.concat("검색결과"+"\n"+"[회원번호]"+members[i].getCustomNum()
							+" [핸드폰번호]010-"+ phones[i].getNumber() 
								+" [이름]"+ members[i].getName()+"\n");
				
			}
		}
		return member;
	}
	@Override
	public String findByName(String name) {
		String member = "";
		for(int i=0;i<memberCount;i++) {
			if(name.equals(members[i].getName())) {
				member = member.concat("검색결과"+"\n"+"[회원번호]"+members[i].getCustomNum()
							+" [핸드폰번호]010-"+ phones[i].getNumber() 
								+" [이름]"+ members[i].getName()+"\n");
			}
		}
		return member;
	}
	@Override
	public void updatePhoneNumber(String key) {
		for(int i=0;i<phoneCount;i++) {
			if(key.equals(phones[i].getCustomNum())) {
				phones[i].setNumber(makeNumber());
			}
		}
	}
	@Override
	public void deleteMember(String key) {
		findByKey(key);
		
	}
}