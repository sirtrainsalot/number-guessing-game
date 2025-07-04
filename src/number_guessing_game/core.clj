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

(defn parse-int [s]
  (try
    (Integer/parseInt s)
    (catch Exception _ nil)))                               ;; handles error input

(defn game-loop [secret remaining attempts]
  (if (zero? remaining)
    (println (str "You're out of guesses. The number I was thinking about was " secret))
    (do
      (print "Enter your guess: ")
      (flush)
      (let [guess (parse-int (read-line))]
        (if (or (nil? guess) (< guess 1) (> guess 100))
          (do
            (println "Invalid input. Enter a number between 1 and 100")
            (recur secret remaining attempts))
          (cond
            (= guess secret)
            (println (str "Congratulations! You guessed the correct number in " attempts " attempts."))

            (< guess secret)
            (do
              (println "Incorrect! The number is greater than" guess ".\n")
              (recur secret (dec remaining) (inc attempts)))

            (> guess secret)
            (do
              (println "Incorrect! The number is less than" guess ".\n")
              (recur secret (dec remaining) (inc attempts)))))))))


(defn -main [& args]
  (welcome-message)
  (let [{:keys [level chances]} (select-difficulty)
        secret (get-secret-number)]
    (println "Great! You have selected the" (name level) "difficulty level.")
    (println "You have" chances "chances.\nLet's start the game!\n")
    (game-loop secret chances 0)))
