ALTER TABLE books
        ADD COLUMN book_key VARCHAR(40) NOT NULL UNIQUE ;

CREATE UNIQUE INDEX U_books_key ON books(book_key);

