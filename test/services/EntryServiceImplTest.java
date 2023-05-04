package services;

import dtos.request.DiaryRegisterRequest;
import dtos.request.EntryRegisterRequest;
import dtos.response.DiaryRegisterResponse;
import dtos.response.EntryRegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryServiceImplTest {
    EntryService entryService;
    EntryRegisterRequest entryRegisterRequest;

    @BeforeEach
    public void startWith(){
        entryService = new EntryServiceImpl();
        entryRegisterRequest = new EntryRegisterRequest();
        entryRegisterRequest.setSubject("This is my first subject");
    }
    @Test
    public void testThatEntryCanBeCreated(){
        EntryRegisterResponse response = entryService.register(entryRegisterRequest);
        assertEquals(1, entryService.countNumberOfEntries());
    }
    @Test
    public void testThatICanFindEntryById(){
        entryRegisterRequest = new EntryRegisterRequest();
        entryRegisterRequest.setSubject("This is my first subject");
        entryRegisterRequest.setBody("This is my first Body");
        entryService.register(entryRegisterRequest);
        EntryRegisterResponse findResponse = entryService.find(1);
        assertEquals("This is my first subject", findResponse.getSubject());
    }
    @Test
    public void testThatEntryCanBeDeleted(){
        entryRegisterRequest = new EntryRegisterRequest();
        entryRegisterRequest.setSubject("This is my first subject");
        entryRegisterRequest.setBody("This is my first Body");
        entryService.register(entryRegisterRequest);
        entryService.deleteById(1);
        assertEquals(0, entryService.count());

    }
}