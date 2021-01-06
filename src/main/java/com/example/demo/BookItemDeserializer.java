package com.example.demo;

import com.example.demo.entities.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class BookItemDeserializer extends JsonDeserializer {

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);

        AccessInfo accessInfo = readAccessInfo(jsonNode.get("accessInfo"));
        SaleInfo saleInfo = readSaleInfo(jsonNode.get("saleInfo"));
        VolumeInfo volumeInfo = readVolumeInfo(jsonNode.get("volumeInfo"));
        SearchInfo searchInfo = readSearchInfo(jsonNode.get("searchInfo"));

        String kind = jsonNode.get("kind").asText();
        String bookId = jsonNode.get("bookId").asText();
        String etag = jsonNode.get("etag").asText();
        String selfLink = jsonNode.get("selfLink").asText();

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

    public SearchInfo readSearchInfo(JsonNode jsonNode) {
        return null;
    }

    public VolumeInfo readVolumeInfo(JsonNode jsonNode) {
        return null;
    }

    public SaleInfo readSaleInfo(JsonNode jsonNode) {
        return null;
    }

    public AccessInfo readAccessInfo(JsonNode jsonNode) {
        return null;
    }

    public Author readAuthor(JsonNode jsonNode){
        return null;
    }
    public EPub readEPub(JsonNode jsonNode){
        return null;
    }
    public ImageLinks readImageLinks(JsonNode jsonNode){
        return null;
    }
    public IndustryIdentifier readIndustryIdentifier(JsonNode jsonNode){
        return null;
    }
    public PDF readPDF(JsonNode jsonNode){
        return null;
    }
    public ReadingMode readReadingMode(JsonNode jsonNode){
        return null;
    }

}
