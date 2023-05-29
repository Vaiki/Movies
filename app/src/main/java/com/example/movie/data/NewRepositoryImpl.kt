package com.example.movie.data

import com.example.movie.data.datasource.LocalDataSource
import com.example.movie.data.datasource.RemoteDataSource
import com.example.movie.data.mapper.Mapper

class NewRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val mapper: Mapper
) {

}