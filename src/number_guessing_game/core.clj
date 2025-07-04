(ns number-guessing-game.core
  (:gen-class))

(defn welcome-message []
  (println "Welcome to the Number Guessing Game!\nI'm thinking of a number between 1 and 100.\nYou have to guess the correct number.\n")
  )

(defn select-difficulty []
  (println "Please select the difficulty level:\n1. Easy (10 chances)\n2. Medium (5 chances)\n3. Hard (3 chances)\n")
  (let [difficulty (read-line)]
    (case difficulty
      "1" {:level :easy :chances 10}
      "2" {:level :medium :chances 5}
      "3" {:level :hard :chances 3}
      (do
        (println "Invalid choice. Try again.")
        (recur)))))                                         ;; recursive call to the user to give a valid input

(defn get-secret-number []
  (+ (rand-int 100) 1))

(defn -main [& args]
  (welcome-message)
  (let [{:keys [level chances]} (select-difficulty)
        secret-number (get-secret-number)]
    (println "Great! You've choosen difficulty level:" (name level))
    (println "You have" chances "chances. Good luck!")
    )

  ;; game loop:
  ;;   Enter your guess: <user input>
  ;;   wrong:
  ;;     - print less or more
  ;;     - add to nrOfGuesses
  ;;   correct
  ;;     - print congrats + nrOfGuesses
  )
