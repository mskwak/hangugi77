package com.daou.service.web;

import com.daou.domain.Mime;
import com.daou.service.core.MimeParserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MimeParserServiceImplTest {
    @Autowired
    private MimeParserService mimeParserService;

    @Before
    public void init() {
    }

    @Test
    public void mimeParserServiceTest() throws MessagingException, FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:sample.eml");
        MimeMessage mimeMessage = new MimeMessage(null, new FileInputStream(file));
        Mime mime  = mimeParserService.getStructure(mimeMessage);

        Assert.notNull(file, "file must be not null");
        Assert.notNull(file, "mimeMessage must be not null");
        Assert.notNull(mime, "mime must be not null");

        mime.getMimePartList().stream().forEach(m -> {
            System.out.println(m.getDepth());
            System.out.println(m.getContentType());
        });
    }
}
