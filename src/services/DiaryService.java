package services;

import dtos.request.DiaryRegisterRequest;
import dtos.response.DiaryRegisterResponse;

public interface DiaryService {
    DiaryRegisterResponse register(DiaryRegisterRequest request);

    int countNumberOfDiaries();
}
