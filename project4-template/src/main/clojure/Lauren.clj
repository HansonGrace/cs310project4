(ns Lauren)

;; Lauren made these functions

(defn member [atm lizt]
	(cond
		(empty? lizt) false
		(identical? atm (first lizt)) true
		:else (recur atm (rest lizt))
	) ;; cond close
) ;; defn close


(defn append [lizt1 lizt2]
	(cond
		(empty? lizt1) lizt2
		:else (cons (first lizt1) (append (rest lizt1) lizt2))
	) ;; cond close
) ;; defn close


(defn map [fun lizt]
	(cond
		(empty? lizt) '()
		:else (cons (fun (first lizt)) (map fun (rest lizt)))
	) ;; cond close
) ;; defn close


(defn same [lizt1 lizt2]
	(cond
		(empty? lizt1) (empty? lizt2)
		(empty? lizt2) false
		(identical? (first lizt1) (first lizt2)) (recur (rest lizt1) (rest lizt2))
		:else false
	) ;; cond close
) ;; defn close


(defn intersect [lizt1 lizt2]
	(cond
		(empty? lizt1) '()
		(member (first lizt1) lizt2) (cons (first lizt1) (intersect (rest lizt1) lizt2))
		:else (recur (rest lizt1) lizt2)
	) ;; cond close
) ;; defn close
