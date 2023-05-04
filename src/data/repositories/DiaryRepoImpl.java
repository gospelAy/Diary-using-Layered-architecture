package data.repositories;

import data.models.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepoImpl implements DiaryRepo{
    List<Diary> diaries = new ArrayList<>();
    private int count;

    @Override
    public Diary save(Diary diary) {
        if (diary.getId() == 0) {
            diary.setId(count + 1);
            diaries.add(diary);
            count++;
        }
        return diary;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Diary findById(int id) {
        for (Diary diary: diaries) {
            if (diary.getId() == id){
                return diary;
            }
        }
        return null;
    }

    @Override
    public int getList() {
        return diaries.size();
    }

    @Override
    public void deleteDiary(int id) {
        for (Diary diary: diaries) {
            if (id == diary.getId()){
                diaries.remove(id);
            }
        }
    }
}
