package com.daou.service.core;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public interface TiKaService {
    static Metadata getMetadata(InputStream inputStream) throws TikaException, SAXException, IOException {
        Parser parser = new AutoDetectParser();
        ContentHandler handler = new BodyContentHandler();
        Metadata metadata = new Metadata();
        ParseContext context = new ParseContext();

        parser.parse(inputStream, handler, metadata, context);
        return metadata;
    }

    default Metadata getFileMetadata (InputStream inputStream) throws TikaException, SAXException, IOException {
        return getMetadata(inputStream);
    }

    default Metadata getFileMetadata (File file) throws TikaException, SAXException, IOException {
        return getMetadata(new FileInputStream(file));
    }

    default Metadata getFileMetadata (Path path) throws TikaException, SAXException, IOException {
        return getMetadata(new FileInputStream(path.toFile()));
    }

    default String getFileType (InputStream inputStream) throws TikaException, SAXException, IOException {
        Metadata metadata = getMetadata(inputStream);
        return metadata.get(Metadata.CONTENT_TYPE);
    }

    default String getFileType (File file) throws IOException, TikaException, SAXException {
        return getFileType(new FileInputStream(file));
    }

    default String getFileType (Path path) throws IOException, TikaException, SAXException {
        return getFileType(new FileInputStream(path.toFile()));
    }
}
