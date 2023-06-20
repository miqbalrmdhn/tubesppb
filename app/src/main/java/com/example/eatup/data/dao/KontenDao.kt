//package com.example.eatup.data.dao
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import com.example.eatup.data.entitas.Konten
//
//@Dao
//interface KontenDao {
//    @Query("SELECT * FROM Konten")
//    fun getAll(): List<Konten>
//
//    @Query("SELECT * FROM Konten WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<Konten>
//
//    @Query(
//        "SELECT * FROM Konten WHERE nama_berita LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(first: String, last: String): Konten
//
//    @Insert
//    fun insertAll(barang users: User)
//
//    @Delete
//    fun delete(user: User)
//}