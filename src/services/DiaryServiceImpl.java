package services;

import data.models.Diary;
import data.repositories.DiaryRepo;
import data.repositories.DiaryRepoImpl;
import dtos.request.DiaryRegisterRequest;
import dtos.response.DiaryRegisterResponse;

public class DiaryServiceImpl implements DiaryService {
    private DiaryRepo diaryRepo = new DiaryRepoImpl();
    @Override
    public DiaryRegisterResponse register(DiaryRegisterRequest request) {
        Diary diary = new Diary();
        diary.setName(request.getName());
        diary = diaryRepo.save(diary);

        DiaryRegisterResponse response = new DiaryRegisterResponse();
        response.setId(diary.getId());
        response.setName(diary.getName());
        return response;
    }

    @Override
    public int countNumberOfDiaries() {
        return diaryRepo.count();
    }
}
