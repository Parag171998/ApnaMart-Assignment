package com.example.assignmentapnamart.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.assignmentapnamart.repo.Repo

class MainViewModel(repo: Repo) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 2)) {
        repo
    }.flow.cachedIn(viewModelScope)
}