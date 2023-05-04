package data.repositories;

import data.models.Diary;

public interface DiaryRepo {

    Diary save(Diary diary);

    int count();

    Diary findById(int id);

    int  getList();

    void deleteDiary(int id);
}
