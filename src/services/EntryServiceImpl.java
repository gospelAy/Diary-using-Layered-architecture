package services;

import data.models.Entry;
import data.repositories.EntryRepo;
import data.repositories.EntryRepoImpl;
import dtos.request.EntryRegisterRequest;
import dtos.response.EntryRegisterResponse;

public class EntryServiceImpl implements EntryService{
    private static EntryRepo entryRepo = new EntryRepoImpl();
    private  static EntryRegisterResponse response;

    private static Entry entry;

    @Override
    public int count() {
        return entryRepo.count();
    }

    @Override
    public long countNumberOfEntries() {
        return entryRepo.count();
    }

    @Override
    public String deleteById(int id) {
        entryRepo.deleteEntry(id);
        String response = "Entry deleted successfully";
        return response;
    }

    @Override
    public EntryRegisterResponse find(int id) {
        entry = new Entry();
        entry =  entryRepo.findById(id);
        response = new EntryRegisterResponse();
        response.setBody(entry.getBody());
        response.setSubject(entry.getSubject());
        response.setDiaryIid(entry.getDiaryIid());
        return response;
    }

    @Override
    public EntryRegisterResponse register(EntryRegisterRequest request) {
        entry = new Entry();
        entry.setBody(request.getBody());
        entry.setSubject(request.getSubject());
        entry.setId(request.getDiaryIid());
        entryRepo.save(entry);

        EntryRegisterResponse response = new EntryRegisterResponse();
        response.setBody(entry.getBody());
        response.setSubject(entry.getSubject());
        return response;
    }

}
