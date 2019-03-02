package com.daou.service.core;

import com.daou.WebfluxTest;
import com.daou.domain.Mime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MimeParserServiceImplTest extends WebfluxTest {
    @Autowired
    private MimeParserService mimeParserService;

    @Before
    public void init() {
    }

    @Test
    public void mimeParserServiceTest() throws MessagingException, FileNotFoundException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "sample.eml");
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
