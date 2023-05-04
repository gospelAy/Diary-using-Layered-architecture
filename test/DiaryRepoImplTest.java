
import data.models.Diary;
import data.repositories.DiaryRepo;
import data.repositories.DiaryRepoImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryRepoImplTest {
    DiaryRepo diaryRepo;
    Diary diary;

    @BeforeEach
    public void startEachTestWith(){
        diaryRepo = new DiaryRepoImpl();
        diary = new Diary();
        diary.setName("Ikechukwu");

        diary = diaryRepo.save(diary);
        Diary diary2 = new Diary();
        diary2.setName("Moyin");
        diaryRepo.save(diary2);

    }

    @Test public void testThatDiaryCanBeCreated_idIsOne(){
        assertEquals(1, diary.getId());
    }

    @Test public void saveAnExistingDiary_idIsStillOne(){
        diary = diaryRepo.save(diary);
        assertEquals(1, diary.getId());
    }

    @Test public void saveTwoDiaries_countIsTwo(){
        assertEquals(2, diaryRepo.count());
    }

    @Test public void diaryCanBeFoundAfterCreation(){
        Diary diary1 = diaryRepo.findById(1);
        assertEquals("Ikechukwu", diary1.getName());
    }
    @Test
    public void testThatDiaryCanBeDeleted(){
        diary = diaryRepo.findById(1);
        assertEquals("Ikechukwu", diary.getName());
        assertEquals(2, diaryRepo.getList());
        diaryRepo.deleteDiary(1);
        assertEquals(1, diaryRepo.getList());
    }
}