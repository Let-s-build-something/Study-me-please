package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.subjects.ParagraphIO

/** Interface for communication with local Room database */
@Dao
interface QuestionDao {

    /** Returns a single question based on their identification [questionUid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid == :questionUid LIMIT 1")
    suspend fun getQuestionByUid(questionUid: String): QuestionIO?

    /** Returns a single paragraph based on their identification [uid] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_PARAGRAPH_TABLE} WHERE uid == :uid LIMIT 1")
    suspend fun getParagraphByUid(uid: String): ParagraphIO?

    /** Returns a single collection based on their identification [questionUids] */
    @Query("SELECT * FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid in (:questionUids) ORDER BY date_created DESC")
    suspend fun getQuestionsByUid(questionUids: List<String>): List<QuestionIO>?

    /** Removes questions from the database within given list */
    @Query("DELETE FROM ${AppRoomDatabase.ROOM_QUESTION_TABLE} WHERE uid IN (:uidList) AND uid NOT IN (:excludedList)")
    suspend fun deleteQuestions(uidList: List<String>, excludedList: List<String> = emptyList())

    /** Inserts or updates a new question [question] into the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionIO)

    /** Inserts new questions [questions] into the database */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertQuestions(questions: List<QuestionIO>)
}