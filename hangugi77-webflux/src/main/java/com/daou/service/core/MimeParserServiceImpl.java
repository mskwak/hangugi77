package com.daou.service.core;

import com.daou.domain.Mime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;

@Slf4j
@Service
public class MimeParserServiceImpl implements MimeParserService {
    @Override
    public Mime getStructure(MimeMessage mimeMessage) {
        Mime mime = Mime.valueOf("");

        try {

            Mime.MimePart mimePart = new Mime.MimePart();
            mimePart.setDepth(0);
            mimePart.setContentType(mimeMessage.getContentType());
            mime.addMimePart(mimePart);

            this.parse(1, mimeMessage.getContent(), mime);
        } catch (IOException e) {
            log.error("", e);
        } catch (MessagingException e) {
            log.error("", e);
        }
        return mime;
    }

    private void parse(int depth, Object object, Mime mime) {
        try {
            if (object instanceof MimeMultipart) {
                MimeMultipart mimeMultipart = (MimeMultipart) object;
                int partCount = mimeMultipart.getCount();

                for (int i = 0; i < partCount; i++) {
                    BodyPart bodyPart = mimeMultipart.getBodyPart(i);

                    Mime.MimePart mimePart = new Mime.MimePart();
                    mimePart.setDepth(depth);
                    mimePart.setContentType(bodyPart.getContentType());
                    mime.addMimePart(mimePart);

                    this.parse(depth + 1, bodyPart.getContent(), mime);
                }
            }
        } catch (MessagingException e) {
            log.error("", e);
        } catch (IOException e) {
            log.error("", e);
        }
    }
}