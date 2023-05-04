package servicesTest;

import dtos.request.DiaryRegisterRequest;
import dtos.response.DiaryRegisterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.DiaryService;
import services.DiaryServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiaryServiceTest {

    DiaryService diaryService;
    DiaryRegisterRequest diaryRegisterRequest;

    @BeforeEach void startWith(){
        diaryService = new DiaryServiceImpl();
        diaryRegisterRequest = new DiaryRegisterRequest();
        diaryRegisterRequest.setName("IK");
    }

    @Test void testThatDiaryCanBeRegistered(){
        DiaryRegisterResponse response = diaryService.register(diaryRegisterRequest);
        assertEquals(1, diaryService.countNumberOfDiaries());
    }
}
