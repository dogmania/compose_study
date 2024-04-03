package com.example.myapplication.roomdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.roomdemo.dao.ProductDao
import com.example.myapplication.roomdemo.entity.Product

@Database(entities = [(Product::class)], version = 1)
abstract class ProductRoomDatabase: RoomDatabase() {

    abstract fun productDao(): ProductDao

    companion object {
        private var INSTANCE: ProductRoomDatabase? = null

        fun getInstance(context: Context): ProductRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context = context.applicationContext,
                        ProductRoomDatabase::class.java,
                        "product_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}