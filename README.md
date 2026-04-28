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
