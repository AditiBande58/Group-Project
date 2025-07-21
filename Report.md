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
   - Handles edge cases and errors including print statements that will tell you if there is an unavailable copy, missing books, or invalid commands. 

3. **Persistence (CSV save/load)**  
 // TODO - write necessary comments

**Why these Data Structures?**  
// TODO - write necessary comments

---

## 3. Big-O Analysis of Key Methods

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

## 4. Assumptions & Analysis
// TODO - write necessary comments


---

