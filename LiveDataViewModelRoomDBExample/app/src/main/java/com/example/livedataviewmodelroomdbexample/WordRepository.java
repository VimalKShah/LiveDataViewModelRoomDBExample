package com.example.livedataviewmodelroomdbexample;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class WordRepository {

    private WordDAO wordDAO;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase wordRoomDatabase = WordRoomDatabase.getInstance(application);
        wordDAO = wordRoomDatabase.wordDAO();
        mAllWords = wordDAO.getAlphabetizedWords();
    }

    public LiveData<List<Word>> geAllWords() {
        return mAllWords;
    }

    void insert(final Word word) {
        WordRoomDatabase.databaseExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                wordDAO.insert(word);
            }
        });
    }
}
