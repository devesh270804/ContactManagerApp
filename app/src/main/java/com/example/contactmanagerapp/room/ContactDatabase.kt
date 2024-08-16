package com.example.contactmanagerapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase :RoomDatabase(){

    abstract val contactDAO: ContactDAO

    //Singleton Design Pattern
    //only one instance of the database exists,
    //avoiding unnecessary overhead associated with repeated database creation
    companion object{
        @Volatile
        private var INSTANCE: ContactDatabase?=null
        fun getInstance(context: Context): ContactDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    //creating the database object
                    instance= Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java,
                        "contacts_db").build()
                }
                INSTANCE = instance
                return  instance

            }
        }


    }
}