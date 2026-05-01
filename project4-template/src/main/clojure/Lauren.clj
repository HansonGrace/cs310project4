(ns Lauren)

;; Lauren made these functions

(defn member [atm lizt] (
	(cond
		((empty? lizt) false)
		((identical? atm (first lizt)) true)
		;; issue: (atm) calls atm as a zero arg function instead of passing the value, should just be atm no ()
		:else (recur (atm) (rest lizt)))
	)
)


(defn append [lizt1 lizt2] (
	(cond
		((empty? lizt1) lizt2)
		:else (cons (first lizt1) (recur (rest lizt1) (lizt2)))
	)
)


(defn map [fun lizt] (
	(cond
	;; issue: using ‘() instead of '()
		((empty? lizt) ‘())
		:else (cons (fun (first lizt)) (recur (fun (rest lizt))))
	)
)


(defn same [lizt1 lizt2] (
	(cond
		((empty? lizt1) (empty? lizt2))
		((empty? lizt2) false)
		((identical? (first lizt1) (first lizt2)) recur ((rest lizt1) (rest lizt2)))
		:else false
	)
)


(defn intersect [lizt1 lizt2] (
	(cond
	;; issue: using ‘() instead of '()
		((empty? lizt1) ‘())
		((member (first lizt1) lizt2) (cons (first lizt1) (recur (rest lizt1) lizt2)))
		:else (recur (rest lizt1) lizt2))
	)
)
