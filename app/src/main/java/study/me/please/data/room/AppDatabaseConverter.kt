package study.me.please.data.room

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.UserPromptPreference
import study.me.please.data.io.UserPromptPreferences
import java.lang.reflect.Type
import java.util.Date
import javax.inject.Inject

/** Factory converter for Room database */
@ProvidedTypeConverter
class AppDatabaseConverter @Inject constructor(private val gson: Gson) {

    /** Converts [CollectionIO] object to string */
    @TypeConverter
    fun fromCollectionIO(value: CollectionIO): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(CollectionIO::class.java).type
        )
    }

    /** Converts string to [CollectionIO] object */
    @TypeConverter
    fun toCollectionIO(value: String): CollectionIO {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(CollectionIO::class.java).type
        )
    }

    /** Converts [QuestionIO] object to string */
    @TypeConverter
    fun fromQuestionIO(value: QuestionIO): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(QuestionIO::class.java).type
        )
    }

    /** Converts string to [Uri] */
    @TypeConverter
    fun toUri(value: String): Uri {
        return value.toUri()
    }

    /** Converts [Uri] to string */
    @TypeConverter
    fun fromUri(value: Uri): String {
        return value.toString()
    }

    /** Converts string to [QuestionIO] */
    @TypeConverter
    fun toQuestionIO(value: String): QuestionIO {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(QuestionIO::class.java).type
        )
    }

    /** Converts [UserPromptPreferences] object to string */
    @TypeConverter
    fun fromUserPromptPreferences(value: UserPromptPreferences): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(UserPromptPreferences::class.java).type
        )
    }

    /** Converts string to [UserPromptPreferences] */
    @TypeConverter
    fun toUserPromptPreferences(value: String): UserPromptPreferences {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(UserPromptPreferences::class.java).type
        )
    }

    /** Converts [LargePathAsset] object to string */
    @TypeConverter
    fun fromLargePathAsset(value: LargePathAsset?): String {
        return if(value == null) "" else {
            gson.toJson(
                value,
                TypeToken.getParameterized(LargePathAsset::class.java).type
            )
        }
    }

    /** Converts string to [LargePathAsset] */
    @TypeConverter
    fun toLargePathAsset(value: String): LargePathAsset? {
        return if(value.isEmpty()) null else {
            gson.fromJson(
                value,
                TypeToken.getParameterized(LargePathAsset::class.java).type
            )
        }
    }

    /** Converts [UserPromptPreference] object to string */
    @TypeConverter
    fun fromUserPromptPreference(value: UserPromptPreference): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(UserPromptPreference::class.java).type
        )
    }

    /** Converts string to [UserPromptPreference] */
    @TypeConverter
    fun toUserPromptPreference(value: String): UserPromptPreference {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(UserPromptPreference::class.java).type
        )
    }

    /** Converts [UserPromptPreference] object to string */
    @TypeConverter
    fun fromQuestionIOList(value: List<QuestionIO>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionIO::class.java).type
        )
    }

    /** Converts string to [UserPromptPreference] */
    @TypeConverter
    fun toQuestionIOList(value: String): List<QuestionIO> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionIO::class.java).type
        )
    }

    /** Converts list of [QuestionAnswerIO] objects to string */
    @TypeConverter
    fun fromQuestionAnswerIOList(value: List<QuestionAnswerIO>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionAnswerIO::class.java).type
        )
    }

    /** Converts string to list of [QuestionAnswerIO] */
    @TypeConverter
    fun toQuestionAnswerIOList(value: String): List<QuestionAnswerIO> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionAnswerIO::class.java).type
        )
    }

    /** Converts list of strings to string */
    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, String::class.java).type
        )
    }

    /** Converts string to list of strings */
    @TypeConverter
    fun toStringList(value: String): List<String> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, String::class.java).type
        )
    }

    /** Converts date to string */
    @TypeConverter
    fun fromDate(value: Date?): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(Date::class.java).type
        )
    }

    /** Converts string to date */
    @TypeConverter
    fun toDate(value: String): Date? {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(Date::class.java).type
        )
    }
}