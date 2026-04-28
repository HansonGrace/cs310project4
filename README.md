!!!! PLEASE REMEMBER TO CHANGE THE NAME OF THE FILE TO YOUR NAME !!!!

Original Scheme Functions

  1. (define (member atm lizt)
          (cond
              ((null? lizt) #f)
              ((eq? atm (car lizt)) #t)
              (else (member atm (cdr lizt)))
          )
      )

  2. (define (append lizt1 lizt2)
        (cond
            ((null? lizt1) lizt2)
            (else (cons (car lizt1)
                (append (cdr lizt1) lizt2)))
         )
      )

  3. (define (map fun lizt)
        (cond        
            ((null? lizt) '())
            (else (cons (fun (car lizt))
                (map fun (cdr lizt))))
         )
      )

   4. (define (same lizt1 lizt2)
          (cond
              ((null? lizt1) (null? lizt2))
              ((null? lizt2) #f)
              ((eq? (car lizt1) (car lizt2))
                  (same (cdr lizt1) (cdr lizt2)))
              (else #f)
          )
      )

  5. (define (intersect lizt1 lizt2)
          (cond
              ((null? lizt1) '())
              ((member (car lizt1) lizt2)
                  (cons (car lizt1) (intersect (cdr lizt1) lizt2)))
              (else (intersect (cdr lizt1) lizt2))
          )
      )



/ Translate each function into Clojure, a Lisp dialect based on the Java platform.
    / Preserve the declarative paradigm of the original functions.
    / Preserve the recursive semantics of the original functions.
/ Translate each function into Java also.
    / Adopt the imperative paradigm instead of the declarative paradigm of the original functions.
    / Either preserve the recursive semantics of the original functions or adopt equivalent iterative semantics instead.
/ Integrate each of your translated functions into the given project template.
    / Name your source code files based on their authors, following the examples in the template.
    / Review each of your translated functions manually for correctness and proficiency.
/ Create JUnit tests of each of your translated functions for a variety of meaningful cases.
    / Name your unit test files based on their authors, following the examples in the template.
    / Include typical cases and edge cases with full test coverage of your translated functions.
