package com.se.example.sarafan.service;

class mClasss{
    int a;
}


class mClasss2{
    int a;
}

public class MyRepository implements IRepository<mClasss ,mClasss2> {


    @Override
    public mClasss fromRlp(mClasss2 a) {
        return null;
    }
}
