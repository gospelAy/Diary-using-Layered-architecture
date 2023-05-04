package services;

import dtos.request.EntryRegisterRequest;
import dtos.response.EntryRegisterResponse;

public interface EntryService {
    EntryRegisterResponse register(EntryRegisterRequest request);

    int count();

    long countNumberOfEntries();

    String deleteById(int id);

    EntryRegisterResponse find(int id);
}
