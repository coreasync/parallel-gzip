(ns core)

(defn file-line-counter[file-name]
  (with-open [i (-> file-name clojure.java.io/input-stream clojure.java.io/reader)]
    (count (line-seq i))))

(defn gz-line-counter[file-name]
  (with-open [i (-> file-name clojure.java.io/input-stream java.util.zip.GZIPInputStream. clojure.java.io/reader)]
    (count (line-seq i))))

(defn run-test[s f]
  (->> s
       (map #(future (time (f %))));;time print might be messed up
       doall
       (map deref)
       doall
       println
       time))

(defn run-test-file[s]
  (println)
  (println "uncompressed")
  (println "Java code:")
  (run-test s #(FileLineCounter/run %))
  (println "Clojure code:")
  (run-test s file-line-counter)
  )

(defn run-test-gz[s]
  (println)
  (println "compressed")
  (println "Java code:")
  (run-test s #(GZLineCounter/run %))
  (println "Clojure code:")
  (run-test s gz-line-counter)
  )


(defn -main[& args]
  (println "starting...")
  (run-test-file args)
  (run-test-gz (map #(str % ".gz") args))
  (println "...finished")
  (shutdown-agents);per CLJ-124
)
