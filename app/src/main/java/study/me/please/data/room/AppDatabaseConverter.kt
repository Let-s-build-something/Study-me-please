package study.me.please.data.room

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.UserPromptPreference
import study.me.please.data.io.UserPromptPreferences
import java.util.Date
import javax.inject.Inject

/** Factory converter for Room database */
@ProvidedTypeConverter
class AppDatabaseConverter @Inject constructor(private val gson: Gson) {

    /** Converts [CollectionIO] object to string */
    @TypeConverter
    fun fromCollectionIO(value: CollectionIO): String {
        return gson.toJson(value, object: TypeToken<CollectionIO>() {}.type)
    }

    /** Converts string to [CollectionIO] object */
    @TypeConverter
    fun toCollectionIO(value: String): CollectionIO {
        return gson.fromJson(value, object: TypeToken<CollectionIO>() {}.type)
    }

    /** Converts [QuestionIO] object to string */
    @TypeConverter
    fun fromQuestionIO(value: QuestionIO): String {
        return gson.toJson(value, object: TypeToken<QuestionIO>() {}.type)
    }

    /** Converts string to [QuestionIO] */
    @TypeConverter
    fun toQuestionIO(value: String): QuestionIO {
        return gson.fromJson(value, object: TypeToken<QuestionIO>() {}.type)
    }

    /** Converts [QuestionAnswerIO] object to string */
    @TypeConverter
    fun fromQuestionAnswerIO(value: QuestionAnswerIO): String {
        return gson.toJson(value, object: TypeToken<QuestionAnswerIO>() {}.type)
    }

    /** Converts string to [QuestionAnswerIO] */
    @TypeConverter
    fun toQuestionAnswerIO(value: String): QuestionAnswerIO {
        return gson.fromJson(value, object: TypeToken<QuestionAnswerIO>() {}.type)
    }

    /** Converts [UserPromptPreferences] object to string */
    @TypeConverter
    fun fromUserPromptPreferences(value: UserPromptPreferences): String {
        return gson.toJson(value, object: TypeToken<UserPromptPreferences>() {}.type)
    }

    /** Converts string to [UserPromptPreferences] */
    @TypeConverter
    fun toUserPromptPreferences(value: String): UserPromptPreferences {
        return gson.fromJson(value, object: TypeToken<UserPromptPreferences>() {}.type)
    }

    /** Converts [LargePathAsset] object to string */
    @TypeConverter
    fun fromLargePathAsset(value: LargePathAsset): String {
        return gson.toJson(value, object: TypeToken<LargePathAsset>() {}.type)
    }

    /** Converts string to [LargePathAsset] */
    @TypeConverter
    fun toLargePathAsset(value: String): LargePathAsset {
        return gson.fromJson(value, object: TypeToken<LargePathAsset>() {}.type)
    }

    /** Converts [UserPromptPreference] object to string */
    @TypeConverter
    fun fromUserPromptPreference(value: UserPromptPreference): String {
        return gson.toJson(value, object: TypeToken<UserPromptPreference>() {}.type)
    }

    /** Converts string to [UserPromptPreference] */
    @TypeConverter
    fun toUserPromptPreference(value: String): UserPromptPreference {
        return gson.fromJson(value, object: TypeToken<UserPromptPreference>() {}.type)
    }

    /** Converts [UserPromptPreference] object to string */
    @TypeConverter
    fun fromQuestionIOList(value: List<QuestionIO>): String {
        return gson.toJson(value, object: TypeToken<List<QuestionIO>>() {}.type)
    }

    /** Converts string to [UserPromptPreference] */
    @TypeConverter
    fun toQuestionIOList(value: String): List<QuestionIO> {
        return gson.fromJson(value, object: TypeToken<List<QuestionIO>>() {}.type)
    }

    /** Converts list of [QuestionAnswerIO] objects to string */
    @TypeConverter
    fun fromQuestionAnswerIOList(value: List<QuestionAnswerIO>): String {
        return gson.toJson(value, object: TypeToken<List<QuestionAnswerIO>>() {}.type)
    }

    /** Converts string to list of [QuestionAnswerIO] */
    @TypeConverter
    fun toQuestionAnswerIOList(value: String): List<QuestionAnswerIO> {
        return gson.fromJson(value, object: TypeToken<List<QuestionAnswerIO>>() {}.type)
    }

    /** Converts list of strings to string */
    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return gson.toJson(value, object: TypeToken<List<String>>() {}.type)
    }

    /** Converts string to list of strings */
    @TypeConverter
    fun toStringList(value: String): List<String> {
        return gson.fromJson(value, object: TypeToken<List<String>>() {}.type)
    }

    /** Converts date to string */
    @TypeConverter
    fun fromDate(value: Date?): String {
        return gson.toJson(value, object: TypeToken<Date?>() {}.type)
    }

    /** Converts string to date */
    @TypeConverter
    fun toDate(value: String): Date? {
        return gson.fromJson(value, object: TypeToken<Date?>() {}.type)
    }
}