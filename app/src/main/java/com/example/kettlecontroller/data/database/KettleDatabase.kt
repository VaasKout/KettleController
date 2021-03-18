package com.example.kettlecontroller.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(
    entities = [Kettle::class],
    version = 1,
    exportSchema = false
)

abstract class KettleDatabase: RoomDatabase() {
    abstract fun kettleDao(): KettleDao

    companion object {
        @Volatile
        private var INSTANCE: KettleDatabase? = null

        fun getDatabase(context: Context): KettleDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        KettleDatabase::class.java,
                        "note_database"
                    )
//                        .addCallback(object : RoomDatabase.Callback() {
//                        override fun onCreate(db: SupportSQLiteDatabase) {
//                            super.onCreate(db)
//                        }
//                    })
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}