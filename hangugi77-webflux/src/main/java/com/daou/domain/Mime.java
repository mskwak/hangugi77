package com.daou.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
public class Mime {
    private String fileName;
    private List<MimePart> mimePartList = new ArrayList<>();

    public void addMimePart(MimePart mimePart) {
        mimePartList.add(mimePart);
    }

    private Mime(String fileName) {
        this.fileName = fileName;
    }

    public static Mime valueOf(String fileName) {
        return new Mime(fileName);
    }

    public static Mime valueOf() {
        return new Mime("");
    }

    @Getter
    @Setter
    public static class MimePart {
        private int depth;
        private String contentType;
    }
}