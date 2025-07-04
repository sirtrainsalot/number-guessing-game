(ns number-guessing-game.core
  (:gen-class))

(defn welcome-message []
  (println "hei"))

(defn -main [& args]
  ;; print welcome message
  (welcome-message)
  ;; select random number
  ;; user input - select difficulty
  ;; game loop:
  ;;   Enter your guess: <user input>
  ;;   wrong:
  ;;     - print less or more
  ;;     - add to nrOfGuesses
  ;;   correct
  ;;     - print congrats + nrOfGuesses
  )
