package com.example.demo.deseializer;

import com.example.demo.BookItemDeserializer;
import com.example.demo.JSONNodes;
import com.example.demo.JSONReader;
import com.example.demo.entities.*;
import com.example.demo.services.BookJsonModule;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.io.IOException;

import static com.example.demo.JSONNodes.Paths.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookItemDeserializerTest {

    BookItemDeserializer bookItemDeserializer = new BookItemDeserializer("testJson.json");
    JSONNodes jsonNodes;
    JsonNode jsonNode;

    @BeforeEach
    private void init() {
        ObjectMapper objectMapper;

        String jsonStr = JSONReader.readJSON("testJson.json");
        JsonFactory jsonFactory = new MappingJsonFactory();
        JsonParser jsonParser = null;

        try {
            jsonParser = jsonFactory.createParser(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new BookJsonModule());

        ObjectCodec objectCodec = jsonParser.getCodec();
        jsonNode = null;
        try {
            jsonNode = objectCodec.readTree(jsonParser);
        } catch (IOException e) {
            e.printStackTrace();
        }
        jsonNodes = new JSONNodes(jsonNode);
    }

    @Test
    void bookDeserialize() throws JsonProcessingException {
        Book book = bookItemDeserializer.deserialize();

        assertEquals("test", book.getBookId());
        assertEquals("test", book.getEtag());
        assertEquals("test", book.getKind());
        assertEquals("test", book.getSelfLink());

        assertEquals("test", book.getVolumeInfo().getTitle());
//        assertEquals("1111-11-11", book.getVolumeInfo().getPublishedDate());
        assertEquals("test", book.getVolumeInfo().getDescription());
        assertEquals(1, book.getVolumeInfo().getPageCount());
        assertEquals("test", book.getVolumeInfo().getPrintType());
        assertTrue(book.getVolumeInfo().getCategories().contains("test1"));
        assertTrue(book.getVolumeInfo().getCategories().contains("test2"));
        assertEquals(1, book.getVolumeInfo().getAverageRating());
        assertEquals(1, book.getVolumeInfo().getRatingCount());
        assertEquals("test", book.getVolumeInfo().getMaturityRating());
        assertEquals("test", book.getVolumeInfo().getAllowAnonLogging());
        assertEquals("test", book.getVolumeInfo().getContentVersion());
        assertEquals("test", book.getVolumeInfo().getLanguage());
        assertEquals("test", book.getVolumeInfo().getPreviewLink());
        assertEquals("test", book.getVolumeInfo().getInfoLink());
        assertEquals("test", book.getVolumeInfo().getCanonicalVolumeLink());

        assertEquals("test", book.getAccessInfo().getCountry());
        assertEquals("test", book.getAccessInfo().getViewAbility());
        assertTrue(book.getAccessInfo().isEmbeddable());
        assertTrue(book.getAccessInfo().isPublicDomian());
        assertEquals("test", book.getAccessInfo().getTextToSpeechPermission());
        assertEquals("test", book.getAccessInfo().getWebReaderLink());
        assertEquals("test", book.getAccessInfo().getAccessViewStatus());
        assertTrue(book.getAccessInfo().isQuoteSharingAllowed());
    }

    @Disabled
    @Test
    void accessInfoDeserialize() throws JsonProcessingException {
        AccessInfo accessInfo = bookItemDeserializer.readAccessInfo(jsonNodes.getPath(ACCESS_INFO));

        assertEquals("test", accessInfo.getBookId());
        assertEquals("test", accessInfo.getCountry());
        assertEquals("test", accessInfo.getViewAbility());
        assertTrue(accessInfo.isEmbeddable());
        assertTrue(accessInfo.isPublicDomian());
        assertEquals("test", accessInfo.getTextToSpeechPermission());
        assertEquals("test", accessInfo.getWebReaderLink());
        assertEquals("test", accessInfo.getAccessViewStatus());
        assertTrue(accessInfo.isQuoteSharingAllowed());
    }

    @Test
    void authorDeserialize() throws JsonProcessingException {
        Author author = bookItemDeserializer.readAuthor(jsonNodes.getPath(AUTHORS)).get(0);

        assertEquals("test", author.getName());
    }

    @Test
    void epubDeserialize() throws JsonProcessingException {
        EPub ePub = bookItemDeserializer.readEPub(jsonNodes.getPath(EPUB));


        assertTrue(ePub.isAvailable());
        assertEquals("test", ePub.getAcsTokenLink());
    }

    @Test
    void imageLinksDeserialize() throws JsonProcessingException {
        ImageLinks imageLinks = bookItemDeserializer.readImageLinks(jsonNodes.getPath(IMAGE_LINKS));

        assertEquals("test", imageLinks.getSmallThumbnail());
        assertEquals("test", imageLinks.getThumbnail());
    }

    @Test
    void industryIdentifierDeserialize() throws JsonProcessingException {
        IndustryIdentifier industryIdentifier = bookItemDeserializer.readIndustryIdentifier(jsonNodes.getPath(INDUSTRY_IDENTIFIER)).get(0);

        assertEquals("test", industryIdentifier.getType());
        assertEquals("test", industryIdentifier.getIdentifier());
    }

    @Test
    void pdfDeserialize() throws JsonProcessingException {
        com.example.demo.entities.PDF pdf = bookItemDeserializer.readPDF(jsonNodes.getPath(PDF));

        assertTrue(pdf.isAvailable());
        assertEquals("test", pdf.getAcsTokenLink());
    }

    @Test
    void readingModeDeserialize() throws JsonProcessingException {
        ReadingMode readingMode = bookItemDeserializer.readReadingMode(jsonNodes.getPath(READING_MODES));

        assertTrue(readingMode.isText());
        assertTrue(readingMode.isImage());
    }

    @Test
    void saleInfoDeserialize() throws JsonProcessingException {
        SaleInfo saleInfo = bookItemDeserializer.readSaleInfo(jsonNodes.getPath(SALE_INFO));

        assertEquals("test", saleInfo.getCountry());
        assertEquals("test", saleInfo.getSaleAbility());
        assertTrue(saleInfo.isEbook());
    }

    @Test
    void searchInfoDeserialize() throws JsonProcessingException {
        SearchInfo searchInfo = bookItemDeserializer.readSearchInfo(jsonNodes.getPath(SEARCH_INFO));

        assertEquals("test", searchInfo.getTextSnippet());
    }

    @Disabled
    @Test
    void volumeInfoDeserialize() throws JsonProcessingException {
        VolumeInfo volumeInfo = bookItemDeserializer.readVolumeInfo(jsonNodes.getPath(VOLUME_INFO));

        assertEquals("test", volumeInfo.getBookId());
        assertEquals("test", volumeInfo.getTitle());
        assertEquals("1111-11-11", volumeInfo.getPublishedDate());
        assertEquals("test", volumeInfo.getDescription());
        assertEquals(1, volumeInfo.getPageCount());
        assertEquals("test", volumeInfo.getPrintType());
        assertTrue(volumeInfo.getCategories().contains("test1"));
        assertTrue(volumeInfo.getCategories().contains("test2"));
        assertEquals(1, volumeInfo.getAverageRating());
        assertEquals(1, volumeInfo.getRatingCount());
        assertEquals("test", volumeInfo.getMaturityRating());
        assertEquals("test", volumeInfo.getAllowAnonLogging());
        assertEquals("test", volumeInfo.getContentVersion());
        assertEquals("test", volumeInfo.getLanguage());
        assertEquals("test", volumeInfo.getPreviewLink());
        assertEquals("test", volumeInfo.getInfoLink());
        assertEquals("test", volumeInfo.getCanonicalVolumeLink());
    }
}