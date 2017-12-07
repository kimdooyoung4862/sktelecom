package com.sktelecom.jse.serviceimpl;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;
import com.sktelecom.jse.service.PhoneService;

public class PhoneServiceImpl implements PhoneService{
	MemberBean[] members;
	PhoneBean[] phones;
	private int memberCount, phoneCount;
	public PhoneServiceImpl() {
		memberCount = phoneCount = 0;
		members = new MemberBean[2];
		phones = new PhoneBean[2];
	}
	public void addUser(MemberBean member, PhoneBean phone) {
		member.setCustomNum(null);
		phone.setCustomNum(null);
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
				(int)(Math.random() * 9999 + 1000))+
					"-"+String.valueOf((int)(Math.random() * 9999 + 1000));
	}

}
