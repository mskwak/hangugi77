package com.daou.service.core;

import com.daou.domain.Mime;

import javax.mail.internet.MimeMessage;

public interface MimeParserService {
	public Mime getStructure(MimeMessage mimeMessage);
}
