package com.sktelecom.jse.service;

import com.sktelecom.jse.domain.MemberBean;
import com.sktelecom.jse.domain.PhoneBean;

public interface PhoneService {
	public String showMessage(MemberBean member, PhoneBean phone);
	public String makeNumber();

}
