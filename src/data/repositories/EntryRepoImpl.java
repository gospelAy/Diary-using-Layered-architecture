package data.repositories;

import data.models.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepoImpl implements EntryRepo{
    List<Entry> entries = new ArrayList<>();
    private int count;
    @Override
    public Entry save(Entry entry) {
        if (entry.getId() == 0) {
            entry.setId(count + 1);
            entries.add(entry);
            count++;
        }

        return entry;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    public Entry findById(int id) {
        for (Entry entry : entries) {
            if (entry.getId() == id) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public int getList() {
        return entries.size();
    }

    @Override
    public void deleteEntry(int id) {
        for (Entry entry: entries) {
            if (id == entry.getId()){
                entries.remove(id-1);
                count--;
            }
            break;
        }
    }
//    if you have 5 element and you
}
