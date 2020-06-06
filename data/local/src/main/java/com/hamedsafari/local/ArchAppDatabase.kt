package com.hamedsafari.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hamedsafari.local.converter.Converters
import com.hamedsafari.local.dao.UserDao
import com.hamedsafari.model.User

@Database(entities = [User::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArchAppDatabase: RoomDatabase() {

    // DAO
    abstract fun userDao(): UserDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ArchAppDatabase::class.java, "ArchApp.db")
                .build()
    }
}