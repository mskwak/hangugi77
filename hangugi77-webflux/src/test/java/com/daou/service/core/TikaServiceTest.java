package com.daou.service.core;

import com.daou.WebfluxTest;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TikaServiceTest extends WebfluxTest {
    @Autowired
    private TiKaService tiKaService;

    @Before
    public void init() {
    }

    @Test
    public void tikaServiceTest() throws IOException, TikaException, SAXException {
        File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "sample.eml");
        Assert.assertNotNull("file must be not null", file);

        String result = tiKaService.getFileType(file);
        System.out.println("type: " + result);

        Metadata metadata = tiKaService.getFileMetadata(file);
        Arrays.stream(metadata.names()).forEach(n -> {
            System.out.println("name: " + n + " value: " + metadata.get(n));
        });
    }
}
