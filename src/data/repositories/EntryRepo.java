package data.repositories;

import data.models.Entry;

public interface EntryRepo {

    Entry save(Entry entry);

    int count();

    Entry findById(int id);

    int getList();

    void deleteEntry(int id);
}
