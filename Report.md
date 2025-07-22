# Library Management System – Project Report

**Authors:**  
- Roma Alimchandani
- Aditi Bande
- Elizabeth Leila Chulani 
- Gabriel Nigussie
- Kenneth Wang

**Due Date:** July 21, 2025

---

## 1. Evidence of Collaboration

Below is a link to a Google Doc of our Discord messaging threads showing us delegating up our work:

https://docs.google.com/document/d/1Vc4_2EAXj4HJqVSQAZqebEfJTplr0FOE57W2tb1xdNg/edit?usp=sharing

---

## 2. Solution Overview

We split the project into three functional pieces:

1. **Book model (`Book.java`)**  
   - Encapsulates title, author, ISBN, total vs. available copies  
   - Methods for `checkout()`, `checkin()`, and copy management  

2. **Library manager (`Library.java`)**  
   - Basic library management functionality. The functions include adding books, checking out, returning, and finding books by title/author or ISBN.
   - Provides a simple interface allowing users to interact with the library
   - Handles edge cases and errors, including print statements that will tell you if there is an unavailable copy, missing books, or invalid commands. 

3. **Persistence (CSV save/load)**
   - CSV save: Serializes all books in the library to a text file in CSV format
      - Each line in the file represents a book: title,author,ISBN,publicationYear,totalCopies,availableCopies
      - This format allows data to be easily saved and shared

    **Why these Data Structures?**  
      - ArrayList<Book> was chosen to store books due to:
      - Efficient random access and iteration
      - Fast apend operations (O(1) amortized)
      - Sufficient for small- to medium-scale library system
      - Simpler than HashMap for persistence, since each book contains all identifying metadata, and we aren't doing frequent random lookups by ISBN in the save process 

---

## 4. Big-O Analysis of Key Methods

| Method                     | Time Complexity  | Space Complexity        |
|----------------------------|------------------|-------------------------|
| `addBook(Book b)`          | O(1)             | O(1) (aside from object allocation) |
| `searchByIsbn(String isbn)`| O(1)             | O(1)                    |
| `searchByTitle(String t)`  | O(n)             | O(1)                    |
| `checkout(String isbn)`    | O(1)             | O(1)                    |
| `returnBook(String isbn)`  | O(1)             | O(1)                    |
| `listAvailableBooks()`     | O(n)             | O(n) (for returned list)|
| `saveToFile(String path)`  | O(n)             | O(1) buffer (streaming) |
| `loadFromFile(String path)`| O(n)             | O(1) buffer (streaming) |

- **n** = number of books in the library
- Title/author searches must scan every entry—hence O(n).  
- CSV I/O costs are linear in file size.

---

## 5. Assumptions & Analysis
- Book titles/authors do not contain commas (CSV delimiter-safe)
- Books are stored using ArrayList, assuming the total number of books is modest
- The file being saved to is writable and the user has permission to create or overwrite it
- If a file cannot be written (e.g., disk error), the method prints an error but does not crash the system
- No need to serialize behavior (methods), only data
- A line in the file represents a snapshot of the book state at the time of saving 

---

## 6. Work Breakdown
- Aditi Bande: Wrote methods for finding book by title and author, finding the book using ISBN, 
  getting the number of books in the library, and adding them to the library.
- Roma Alimchandani: Worked on Book.java and the methods for searching for books. Also, worked
  on the report.
- Elizabeth Leila Chulani: Wrote the methods for saving and uploading the file and the test
  cases for it.
- Gabriel Nigussie: Wrote the method for returning books as well as accompanying test cases.
- Kenneth Wang: Wrote the method for borrowing books as well as accompanying test cases.
- We mainly communicated through discord but also were using Github to collaborate and upload 
  our parts onto the files.

---

## 7. Challenges
The main challenge we faced during this project was finding everyone's contacts and ways to communicate with each other. It was hard to figure out who was who on discord leading us to start our project a bit later than anticipated. Also, there was no scheduled times where we could discuss about the project so it was hard to sync up with the whole group. However, we did a pretty good job of finding time and working together despite our schedules.

---

## 8. Testing
We created a CSV file with a couple lines on it and used that to test our code and debug if there were any errors. We wrote a lot of try and catch exceptions for our test cases in main and also threw exceptions if there were problems in the method which allowed us to catch errors and easily debug our code.

---

## 9. Conclusion
In conclusion, this project was great way for our team to work on our communication and coding skills. Through the practice we got from this project, we were able to code faster and understand the different factors that go into choosing a good data structure for our code. It was a great learning experience and we really enjoyed collaborating with each other.


