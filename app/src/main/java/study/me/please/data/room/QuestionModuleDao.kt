package study.me.please.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import study.me.please.data.state.session.QuestionModule

/** Interface for communication with local Room database */
@Dao
interface QuestionModuleDao {

    /** Inserts or updates a question module [questionModule] in(to) the database */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestionModule(questionModule: QuestionModule)
}