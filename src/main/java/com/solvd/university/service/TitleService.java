package com.solvd.university.service;

import com.solvd.university.bin.Title;

public interface TitleService {

    Title getTitle(int id);
    void saveTitle(Title title);
}
