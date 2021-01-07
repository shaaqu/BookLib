package com.example.demo;

import com.example.demo.entities.*;
import com.example.demo.services.BookJsonModule;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.demo.JSONNodes.Paths.*;

public class BookItemDeserializer{

    String path;
    String bookId;
    JSONNodes jsonNodes;

    public BookItemDeserializer(String path) {
        this.path = path;
    }

    public List<Book> deserializeDB() {
        List<Book> books = new ArrayList<>();

        JsonNode jsonNode = init(path).get("items");
        int i = 0;
        jsonNode.forEach(
                (v) -> {
                    books.add(deserialize(v));
                }
        );

        return books;
    }

    public Book deserialize(JsonNode jsonNode){

        jsonNodes = new JSONNodes(jsonNode);
        AccessInfo accessInfo = readAccessInfo(jsonNodes.getPath(ACCESS_INFO));
        SaleInfo saleInfo = readSaleInfo(jsonNodes.getPath(SALE_INFO));
        VolumeInfo volumeInfo = readVolumeInfo(jsonNodes.getPath(VOLUME_INFO));
        SearchInfo searchInfo = readSearchInfo(jsonNodes.getPath(SEARCH_INFO));

        String kind = getValueStr(jsonNode, "kind");
        bookId = getValueStr(jsonNode, "id");
        String etag = getValueStr(jsonNode, "etag");
        String selfLink = getValueStr(jsonNode, "selfLink");

        return Book.builder()
                .kind(kind)
                .bookId(bookId)
                .etag(etag)
                .selfLink(selfLink)
                .volumeInfo(volumeInfo)
                .saleInfo(saleInfo)
                .accessInfo(accessInfo)
                .searchInfo(searchInfo)
                .build();
    }

    private JsonNode init(String path) {
        String jsonStr = JSONReader.readJSON(path);
        JsonFactory jsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = null;

        try {
            jsonParser = jsonFactory.createParser(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectCodec.readTree(jsonParser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    public SearchInfo readSearchInfo(JsonNode jsonNode) {
        return SearchInfo.builder()
                .bookId(bookId)
                .textSnippet(getValueStr(jsonNode, "textSnippet"))
                .build();
    }

    public VolumeInfo readVolumeInfo(JsonNode jsonNode) {

        return VolumeInfo.builder()
                .bookId(bookId)
                .title(getValueStr(jsonNode, "title"))
                .authors(readAuthor(jsonNodes.getPath(AUTHORS)))
                .publisher(getValueStr(jsonNode, "publisher"))
                .publishedDate(getDate(jsonNode))
                .description(getValueStr(jsonNode, "description"))
                .industryIdentifiers(readIndustryIdentifier(jsonNodes.getPath(INDUSTRY_IDENTIFIER)))
                .readingMode(readReadingMode(jsonNodes.getPath(READING_MODES)))
                .pageCount(getValueInt(jsonNode, "pageCount"))
                .printType(getValueStr(jsonNode, "printType"))
                .categories(readList(jsonNode.get("categories")))
                .averageRating(getValueDouble(jsonNode, "averageRating"))
                .ratingCount(getValueInt(jsonNode, "ratingCount"))
                .maturityRating(getValueStr(jsonNode, "maturityRating"))
                .allowAnonLogging(getValueStr(jsonNode, "allowAnonLogging"))
                .contentVersion(getValueStr(jsonNode, "contentVersion"))
                .imageLinks(readImageLinks(jsonNodes.getPath(IMAGE_LINKS)))
                .language(getValueStr(jsonNode, "language"))
                .previewLink(getValueStr(jsonNode, "previewLink"))
                .infoLink(getValueStr(jsonNode, "infoLink"))
                .canonicalVolumeLink(getValueStr(jsonNode, "canonicalVolumeLink"))
                .build();
    }

    private long getDate(JsonNode jsonNode) {
        Date date = null;
        long time = -1;
        if (jsonNode.get("publishedDate") != null){
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(jsonNode.get("publishedDate").asText(null));
                time = date.getTime() / 1000L;
            } catch (ParseException e) {
                try {
                    date = new SimpleDateFormat("yyyy").parse(jsonNode.get("publishedDate").asText(null));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                    time = date.getTime() / 1000L;
                }
            }
        }

        return time;
    }

    public SaleInfo readSaleInfo(JsonNode jsonNode) {
        return SaleInfo.builder()
                .bookId(bookId)
                .country(getValueStr(jsonNode, "country"))
                .saleAbility(getValueStr(jsonNode, "saleAbility"))
                .isEbook(getValueBoolean(jsonNode, "isEbook"))
                .build();
    }

    public AccessInfo readAccessInfo(JsonNode jsonNode) {
        return AccessInfo.builder()
                .bookId(bookId)
                .country(getValueStr(jsonNode, "country"))
                .viewAbility(getValueStr(jsonNode, "viewability"))
                .embeddable(getValueBoolean(jsonNode, "embeddable"))
                .publicDomian(getValueBoolean(jsonNode, "publicDomian"))
                .textToSpeechPermission(getValueStr(jsonNode, "textToSpeechPermission"))
                .ePub(readEPub(jsonNodes.getPath(EPUB)))
                .pdf(readPDF(jsonNodes.getPath(PDF)))
                .webReaderLink(getValueStr(jsonNode, "webReaderLink"))
                .accessViewStatus(getValueStr(jsonNode, "accessViewStatus"))
                .quoteSharingAllowed(getValueBoolean(jsonNode, "quoteSharingAllowed"))
                .build();
    }

    public List<String> readList(JsonNode jsonNode){
        List<String> list = new ArrayList<>();
        if (jsonNode != null) {
            jsonNode.forEach(
                    (v) -> list.add(v.asText())
            );
        }
        return list;
    }

    public List<Author> readAuthor(JsonNode jsonNode){
        List<Author> authors = new ArrayList<>();
        if (jsonNode != null) {
            jsonNode.forEach(
                    (v) -> authors.add(Author.builder().name(v.asText()).build())
            );
        }

        return authors;
    }
    public EPub readEPub(JsonNode jsonNode){
        return EPub.builder()
                .isAvailable(getValueBoolean(jsonNode, "isAvailable"))
                .acsTokenLink(getValueStr(jsonNode, "acsTokenLink"))
                .build();

    }
    public ImageLinks readImageLinks(JsonNode jsonNode){
        return ImageLinks.builder()
                .smallThumbnail(getValueStr(jsonNode, "smallThumbnail"))
                .thumbnail(getValueStr(jsonNode, "thumbnail"))
                .build();
    }
    public List<IndustryIdentifier> readIndustryIdentifier(JsonNode jsonNode){
        List<IndustryIdentifier> industryIdentifiers = new ArrayList<>();

        if (jsonNode != null){
            jsonNode.forEach(
                    (v) -> industryIdentifiers.add(IndustryIdentifier.builder()
                            .type(v.get("type").asText(null))
                            .identifier(v.get("identifier").asText(null))
                            .build())
            );
        }

        return industryIdentifiers;
    }
    public com.example.demo.entities.PDF readPDF(JsonNode jsonNode){
        return com.example.demo.entities.PDF.builder()
                .isAvailable(getValueBoolean(jsonNode, "isAvailable"))
                .acsTokenLink(getValueStr(jsonNode, "acsTokenLink"))
                .build();
    }
    public ReadingMode readReadingMode(JsonNode jsonNode){
        return ReadingMode.builder()
                .image(getValueBoolean(jsonNode, "image"))
                .text(getValueBoolean(jsonNode, "text"))
                .build();
    }

    private int getValueInt(JsonNode jsonNode, String key) {
        if (jsonNode == null) {
            return -1;
        }
        if (jsonNode.has(key)) {
            return jsonNode.get(key).asInt();
        } else {
            return -1;
        }
    }

    private String getValueStr(JsonNode jsonNode, String key) {
        if (jsonNode == null) {
            return null;
        }
        if (jsonNode.has(key)) {
            String s = jsonNode.get(key).asText();
            if (s.length() > 200) {
                s = s.substring(0, 200);
            }
            return s;
        } else {
            return null;
        }
    }

    private long getValueLong(JsonNode jsonNode, String key) {
        if (jsonNode == null) {
            return -1;
        }
        if (jsonNode.has(key)) {
            return jsonNode.get(key).asLong();
        } else {
            return -1;
        }
    }

    private double getValueDouble(JsonNode jsonNode, String key) {
        if (jsonNode == null) {
            return 0;
        }
        if (jsonNode.has(key) && jsonNode != null) {
            return jsonNode.get(key).asDouble();
        } else {
            return 0;
        }
    }

    private boolean getValueBoolean(JsonNode jsonNode, String key) {
        if (jsonNode == null) {
            return false;
        }
        if (jsonNode.has(key) && jsonNode != null) {
            return jsonNode.get(key).asBoolean();
        } else {
            return false;
        }
    }

}
