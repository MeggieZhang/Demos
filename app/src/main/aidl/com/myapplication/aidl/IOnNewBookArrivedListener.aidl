package com.myapplication.aidl;

import com.myapplication.aidl.Book;

interface IOnNewBookArrivedListener {
    void onNewBookArrived(in Book newBook);
}
