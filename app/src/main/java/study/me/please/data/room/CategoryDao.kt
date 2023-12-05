package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.subjects.CategoryIO

/** Interface for communication with local Room database */
@Dao
interface CategoryDao {

    /** Returns a list of categories based on their similarity of [query] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_CATEGORY_TABLE} WHERE name LIKE '%' || :query || '%' ORDER BY date_created DESC")
    suspend fun getCategoriesByNameLike(query: String): List<CategoryIO>?

    /** Should return a singular category matching exactly given [name] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_CATEGORY_TABLE} WHERE name LIKE :name LIMIT 1")
    suspend fun getCategoriesByNameExact(name: String): CategoryIO?

    /** Returns all categories from the DB */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_CATEGORY_TABLE}")
    suspend fun getAllCategories(): List<CategoryIO>?

    /** Removes a category from the database by its identification [uid] */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_CATEGORY_TABLE} WHERE uid == :uid")
    suspend fun deleteCategory(uid: String)

    /** Inserts a new category [category] into the database */
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertCategory(category: CategoryIO)

    /** Inserts or updates new category [category] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCategory(category: CategoryIO)
}