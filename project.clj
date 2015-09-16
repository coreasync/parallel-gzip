(defproject test "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main core
  :java-source-paths ["src"]
  :jvm-opts ["-XX:MaxInlineLevel=16"]
)
