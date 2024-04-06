package study.me.please.data.room

import android.net.Uri
import androidx.core.net.toUri
import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import study.me.please.data.io.CollectionIO
import study.me.please.data.io.FactIO
import study.me.please.data.io.ImportedSource
import study.me.please.data.io.LargePathAsset
import study.me.please.data.io.QuestionAnswerIO
import study.me.please.data.io.QuestionIO
import study.me.please.data.io.preferences.SessionPreference
import study.me.please.data.io.preferences.SessionPreferencePack
import study.me.please.data.io.session.QuestionItem
import study.me.please.data.io.session.SessionAnswerValidation
import study.me.please.data.io.session.SessionHistoryItem
import study.me.please.data.io.subjects.CategoryIO
import study.me.please.data.io.subjects.ParagraphIO
import study.me.please.data.io.subjects.UnitIO
import study.me.please.data.state.session.QuestionModule
import java.util.Date
import javax.inject.Inject

/** Factory converter for Room database */
@ProvidedTypeConverter
class AppDatabaseConverter @Inject constructor(private val gson: Gson) {

    /** Converts [UnitIO] object to string */
    @TypeConverter
    fun fromSubjectIO(value: UnitIO): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(UnitIO::class.java).type
        )
    }

    /** Converts string to [UnitIO] object */
    @TypeConverter
    fun toSubjectIO(value: String): UnitIO {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(UnitIO::class.java).type
        )
    }

    /** Converts [CategoryIO] object to string */
    @TypeConverter
    fun fromCategoryIO(value: CategoryIO?): String? {
        return gson.toJson(
            value,
            TypeToken.getParameterized(CategoryIO::class.java).type
        )
    }

    /** Converts string to [CategoryIO] object */
    @TypeConverter
    fun toCategoryIO(value: String?): CategoryIO? {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(CategoryIO::class.java).type
        )
    }

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

    /** Converts [QuestionItem] object to string */
    @TypeConverter
    fun fromQuestionItem(value: QuestionItem): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(QuestionItem::class.java).type
        )
    }

    /** Converts string to [QuestionItem] object */
    @TypeConverter
    fun toQuestionItem(value: String): QuestionItem {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(QuestionItem::class.java).type
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

    /** Converts [SessionPreferencePack] object to string */
    @TypeConverter
    fun fromSessionPreferencePack(value: SessionPreferencePack): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(SessionPreferencePack::class.java).type
        )
    }

    /** Converts string to [SessionPreferencePack] */
    @TypeConverter
    fun toSessionPreferencePack(value: String): SessionPreferencePack {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(SessionPreferencePack::class.java).type
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

    /** Converts string to [ImportedSource] */
    @TypeConverter
    fun toImportedSource(value: String?): ImportedSource? {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(ImportedSource::class.java).type
        )
    }

    /** Converts [ImportedSource] object to string */
    @TypeConverter
    fun fromImportedSource(value: ImportedSource?): String {
        return if(value == null) "" else {
            gson.toJson(
                value,
                TypeToken.getParameterized(ImportedSource::class.java).type
            )
        }
    }

    /** Converts string to [SessionHistoryItem] */
    @TypeConverter
    fun toSessionHistoryItem(value: String): SessionHistoryItem {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(SessionHistoryItem::class.java).type
        )
    }

    /** Converts [SessionHistoryItem] object to string */
    @TypeConverter
    fun fromSessionHistoryItem(value: SessionHistoryItem?): String {
        return if(value == null) "" else {
            gson.toJson(
                value,
                TypeToken.getParameterized(SessionHistoryItem::class.java).type
            )
        }
    }

    /** Converts string to [SessionHistoryItem] array */
    @TypeConverter
    fun toSessionHistoryItemList(value: String): List<SessionHistoryItem> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, SessionHistoryItem::class.java).type
        )
    }

    /** Converts [SessionHistoryItem] object array to string */
    @TypeConverter
    fun fromSessionHistoryItemList(value: List<SessionHistoryItem>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, SessionHistoryItem::class.java).type
        )
    }

    /** Converts string to [ParagraphIO] array */
    @TypeConverter
    fun toParticleIOList(value: String): List<ParagraphIO> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, ParagraphIO::class.java).type
        )
    }

    /** Converts [ParagraphIO] object array to string */
    @TypeConverter
    fun fromParagraphIOList(value: List<ParagraphIO>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, ParagraphIO::class.java).type
        )
    }

    /** Converts string to [FactIO] array */
    @TypeConverter
    fun toFactIOList(value: String): List<FactIO> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, FactIO::class.java).type
        )
    }

    /** Converts [FactIO] object array to string */
    @TypeConverter
    fun fromFactIOList(value: List<FactIO>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, FactIO::class.java).type
        )
    }

    /** Converts string to [CategoryIO] array */
    @TypeConverter
    fun toCategoryIOList(value: String): List<CategoryIO> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, CategoryIO::class.java).type
        )
    }

    /** Converts [CategoryIO] object array to string */
    @TypeConverter
    fun fromCategoryIOList(value: List<CategoryIO>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, CategoryIO::class.java).type
        )
    }

    /** Converts string to [QuestionModule] */
    @TypeConverter
    fun toQuestionModule(value: String?): QuestionModule? {
        return if(value == null) null else {
            gson.fromJson(
                value,
                TypeToken.getParameterized(QuestionModule::class.java).type
            )
        }
    }

    /** Converts [SessionHistoryItem] object to string */
    @TypeConverter
    fun fromQuestionModule(value: QuestionModule?): String? {
        return if(value == null) "" else {
            gson.toJson(
                value,
                TypeToken.getParameterized(QuestionModule::class.java).type
            )
        }
    }

    /** Converts string to [SessionAnswerValidation] */
    @TypeConverter
    fun toSessionAnswerValidation(value: String): SessionAnswerValidation {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(SessionAnswerValidation::class.java).type
        )
    }

    /** Converts [SessionHistoryItem] object to string */
    @TypeConverter
    fun fromSessionAnswerValidation(value: SessionAnswerValidation?): String {
        return if(value == null) "" else {
            gson.toJson(
                value,
                TypeToken.getParameterized(SessionAnswerValidation::class.java).type
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

    /** Converts [SessionPreference] object to string */
    @TypeConverter
    fun fromSessionPreference(value: SessionPreference): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(SessionPreference::class.java).type
        )
    }

    /** Converts string to [SessionPreference] */
    @TypeConverter
    fun toSessionPreference(value: String): SessionPreference {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(SessionPreference::class.java).type
        )
    }

    /** Converts string set to string */
    @TypeConverter
    fun fromStringSet(value: Set<String>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(Set::class.java, String::class.java).type
        )
    }

    /** Converts string to [SessionPreference] */
    @TypeConverter
    fun toStringSet(value: String?): Set<String> {
        return if(value.isNullOrEmpty()) setOf() else gson.fromJson(
            value,
            TypeToken.getParameterized(Set::class.java, String::class.java).type
        )
    }

    /** Converts list of [QuestionIO] object to string */
    @TypeConverter
    fun fromQuestionIOList(value: List<QuestionIO>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionIO::class.java).type
        )
    }

    /** Converts string to [QuestionIO] list */
    @TypeConverter
    fun toQuestionIOList(value: String): List<QuestionIO> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionIO::class.java).type
        )
    }

    /** Converts list of [QuestionItem] object to string */
    @TypeConverter
    fun fromQuestionItemList(value: List<QuestionItem>): String {
        return gson.toJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionItem::class.java).type
        )
    }

    /** Converts string to [QuestionItem] list */
    @TypeConverter
    fun toQuestionItemList(value: String): List<QuestionItem> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(List::class.java, QuestionItem::class.java).type
        )
    }

    /** Converts list of [CollectionIO] object to string */
    @TypeConverter
    fun fromCollectionIOList(value: Set<CollectionIO>?): String? {
        return if(value == null) null else gson.toJson(
            value,
            TypeToken.getParameterized(Set::class.java, CollectionIO::class.java).type
        )
    }

    /** Converts string to [CollectionIO] */
    @TypeConverter
    fun toCollectionIOList(value: String?): Set<CollectionIO>? {
        return if(value == null) null else gson.fromJson(
            value,
            TypeToken.getParameterized(Set::class.java, CollectionIO::class.java).type
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
    fun fromStringList(value: MutableList<String>): String {
        val copyOfValue = ArrayList(value)
        return gson.toJson(
            copyOfValue,
            TypeToken.getParameterized(MutableList::class.java, String::class.java).type
        )
    }

    /** Converts string to list of strings */
    @TypeConverter
    fun toStringList(value: String): MutableList<String> {
        return gson.fromJson(
            value,
            TypeToken.getParameterized(MutableList::class.java, String::class.java).type
        ) ?: mutableListOf()
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