package com.example.demo;

import com.example.demo.entities.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo.JSONNodes.Paths.*;

public class BookItemDeserializer extends JsonDeserializer {

    String bookId;
    JSONNodes jsonNodes;
    Book book;

    @Override
    public Object deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec objectCodec = jsonParser.getCodec();
        JsonNode jsonNode = objectCodec.readTree(jsonParser);
        jsonNodes = new JSONNodes(jsonNode);
        AccessInfo accessInfo = readAccessInfo(jsonNodes.getPath(ACCESS_INFO));
        SaleInfo saleInfo = readSaleInfo(jsonNodes.getPath(SALE_INFO));
        VolumeInfo volumeInfo = readVolumeInfo(jsonNodes.getPath(VOLUME_INFO));
        SearchInfo searchInfo = readSearchInfo(jsonNodes.getPath(SEARCH_INFO));

        String kind = jsonNode.get("kind").asText();
        bookId = jsonNode.get("bookId").asText();
        String etag = jsonNode.get("etag").asText();
        String selfLink = jsonNode.get("selfLink").asText();

        book = Book.builder()
                .kind(kind)
                .bookId(bookId)
                .etag(etag)
                .selfLink(selfLink)
                .volumeInfo(volumeInfo)
                .saleInfo(saleInfo)
                .accessInfo(accessInfo)
                .searchInfo(searchInfo)
                .build();

        return book;
    }

    public SearchInfo readSearchInfo(JsonNode jsonNode) {
        return SearchInfo.builder()
                .bookId(bookId)
                .textSnippet(jsonNode.get("textSnippet").asText(null))
                .build();
    }

    public VolumeInfo readVolumeInfo(JsonNode jsonNode) {
        return VolumeInfo.builder()
                .bookId(bookId)
                .title(jsonNode.get("title").asText(null))
                .authors(readAuthor(jsonNode))
                .publisher(jsonNode.get("publisher").asText(null))
                .publishedDate(jsonNode.get("publishedDate").asLong(0))
                .description(jsonNode.get("description").asText(null))
                .industryIdentifiers(readIndustryIdentifier(jsonNode))
                .readingMode(readReadingMode(jsonNodes.getPath(READING_MODES)))
                .pageCount(jsonNode.get("pageCount").asInt(0))
                .printType(jsonNode.get("printType").asText(null))
                .categories(jsonNode.findValuesAsText("categories"))
                .averageRating(jsonNode.get("averageRating").asDouble())
                .ratingCount(jsonNode.get("ratingCount").asInt())
                .maturityRating(jsonNode.get("maturityRating").asText(null))
                .allowAnonLogging(jsonNode.get("allowAnonLogging").asText(null))
                .contentVersion(jsonNode.get("contentVersion").asText(null))
                .imageLinks(readImageLinks(jsonNodes.getPath(IMAGE_LINKS)))
                .language(jsonNode.get("language").asText(null))
                .previewLink(jsonNode.get("previewLink").asText(null))
                .infoLink(jsonNode.get("infoLink").asText(null))
                .canonicalVolumeLink(jsonNode.get("canonicalVolumeLink").asText(null))
                .build();
    }

    public SaleInfo readSaleInfo(JsonNode jsonNode) {
        return SaleInfo.builder()
                .bookId(bookId)
                .country(jsonNode.get("country").asText(null))
                .saleAbility(jsonNode.get("saleability").asText(null))
                .isEbook(jsonNode.get("isEbook").asBoolean(false))
                .build();
    }

    public AccessInfo readAccessInfo(JsonNode jsonNode) {
        return AccessInfo.builder()
                .bookId(bookId)
                .country(jsonNode.get("country").asText(null))
                .viewAbility(jsonNode.get("viewability").asText(null))
                .embeddable(jsonNode.get("embeddable").asBoolean(false))
                .publicDomian(jsonNode.get("publicDomian").asBoolean(false))
                .textToSpeechPermission(jsonNode.get("textToSpeechPermission").asText(null))
                .ePub(readEPub(jsonNodes.getPath(EPUB)))
                .pdf(readPDF(jsonNodes.getPath(PDF)))
                .webReaderLink(jsonNode.get("webReaderLink").asText(null))
                .accessViewStatus(jsonNode.get("accessViewStatus").asText(null))
                .quoteSharingAllowed(jsonNode.get("quoteSharingAllowed").asBoolean(false))
                .build();
    }

    public List<Author> readAuthor(JsonNode jsonNode){
        List<Author> authors = new ArrayList<>();

        jsonNode.findValuesAsText("authors").forEach(
                (v) -> authors.add(Author.builder().name(v).build())
        );

        return authors;
    }
    public EPub readEPub(JsonNode jsonNode){
        return EPub.builder()
                .bookId(bookId)
                .isAvailable(jsonNode.get("isAvailable").asBoolean(false))
                .acsTokenLink(jsonNode.get("acsTokenLink").asText(null))
                .build();

    }
    public ImageLinks readImageLinks(JsonNode jsonNode){
        return ImageLinks.builder()
                .smallThumbnail(jsonNode.get("smallThumbnail").asText(null))
                .thumbnail(jsonNode.get("thumbnail").asText(null))
                .build();
    }
    public List<IndustryIdentifier> readIndustryIdentifier(JsonNode jsonNode){
        List<IndustryIdentifier> industryIdentifiers = new ArrayList<>();

        jsonNode.findValuesAsText("industryIdentifiers").forEach(
                (v) -> industryIdentifiers.add(IndustryIdentifier.builder()
                        .bookId(bookId)
                        .type(jsonNode.get("type").asText(null))
                        .identifier(jsonNode.get("identifier").asText(null))
                        .build())
        );

        return industryIdentifiers;
    }
    public com.example.demo.entities.PDF readPDF(JsonNode jsonNode){
        return com.example.demo.entities.PDF.builder()
                .bookId(bookId)
                .isAvailable(jsonNode.get("isAvailable").asBoolean(false))
                .acsTokenLink(jsonNode.get("acsTokenLink").asText(null))
                .build();
    }
    public ReadingMode readReadingMode(JsonNode jsonNode){
        return ReadingMode.builder()
                .bookId(bookId)
                .image(jsonNode.get("image").asBoolean(false))
                .text(jsonNode.get("text").asBoolean(false))
                .build();
    }

}
