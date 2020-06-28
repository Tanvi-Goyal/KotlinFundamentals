package com.example.kotlinfundamentals.kotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

//// simple generic class
//class Library<T> (var book: T?, var nCopies: Int, var language: String) {
//}
//
//// definition of covariant generic class
//class Library<out T : Book>(private var book: T?, var nCopies: Int, var language: String) {
//    fun getBook() : T? = book
//}
//
//// definition of contravariant generic class
//class Library<in T : Book>(private var book: T?, var nCopies: Int, var language: String) {
//    fun setBook(book: T?) {
//        this.book = book
//    }
//}

// definition of use-site variant class
class Library<T> (private var book: T?, var nCopies: Int, var language: String) {
    fun getBook() : T? = book
    fun setBook(book: T?) {
        this.book = book
    }
}

open class Book(var attr : String)
class CourseBook(var name: String, var author: String, var course: String) : Book("abc")
class Novel(var name: String, var author: String, var genre: String) : Book("def")

fun <T> useSiteCovariant(from : Library<out T>, to : Library<T>) {
    to.setBook(from.getBook())
    from.setBook(null)
}

fun <T> useSiteContravariant(from : Library<T>, to : Library<in T>) {
    to.setBook(from.getBook())
    to.getBook()
}

public class App : AppCompatActivity() {

    val courseBook: CourseBook =
        CourseBook("Core Science Biology ", "Geeta Negi", "Biology - Class 10")
    val novel = Novel("Jane Eyre", "Charlotte Bronte", "Gothic Fiction")

    private lateinit var lCourseBook: Library<CourseBook>
    var mainBook: Library<Book> = Library(Book("abc"), 10, "English")
    var lNovel: Library<Novel> = Library(novel, 30, "English")


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

//        mainBook = lCourseBook
//
//        lCourseBook = mainBook
//
//        mainBook.setBook(novel)

        useSiteCovariant(lCourseBook, mainBook)
//        useSiteCovariant(novel, lCourseBook)

        useSiteContravariant(lCourseBook, mainBook)
//        useSiteContravariant(lCourseBook, novel)

    }
}







