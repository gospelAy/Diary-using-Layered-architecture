package data.repositories;

import data.models.Diary;
import data.models.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryRepoImplTest {
    DiaryRepo diaryRepo;
    Diary diary1;
    EntryRepo entryRepo;
    Entry entry;
    @BeforeEach
    void setUp() {
        diaryRepo = new DiaryRepoImpl();
        diary1 = new Diary();
        diary1 = diaryRepo.save(diary1);
        entryRepo = new EntryRepoImpl();
        entry = new Entry();
        entry.setDiaryIid(diary1.getId());
        entry.setSubject("The coming of jesus christ");
        entry = entryRepo.save(entry);
        Entry entry2 = new Entry();
        entry2.setSubject("Salvation is a deep rooted believe that you are save!");
        entry2 = entryRepo.save(entry2);
    }
    @Test public void testThatEntryCanBeCreated_idIsOne(){
        assertEquals(1, entry.getId());
    }
    @Test public void testThat_SaveAnExistingEntry_idIsStillOne(){
        entry = entryRepo.save(entry);
        assertEquals(1, entry.getId());
    }
    @Test
    public void testThat_SaveTwoEntryCountIsTwo(){
        assertEquals(2, entryRepo.count());
    }
    @Test
    public void testThatEntryCanBeFindById(){
        Entry entry1 = entryRepo.findById(1);
        assertEquals("The coming of jesus christ", entry1.getSubject());
    }
    @Test
    public void testThatEntryCanBeDeleted(){
        entry = entryRepo.findById(1);
        assertEquals("The coming of jesus christ", entry.getSubject());
        assertEquals(2, entryRepo.getList());
        entryRepo.deleteEntry(1);
        assertEquals(1, entryRepo.getList());
    }
}