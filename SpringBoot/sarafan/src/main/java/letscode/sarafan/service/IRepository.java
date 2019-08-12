package com.se.example.sarafan.service;

public interface IRepository<T,U>  {
    T fromRlp(U a);
}
